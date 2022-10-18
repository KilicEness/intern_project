package com.example.demo.service;

import com.example.demo.entity.GITProfile;
import com.example.demo.entity.UserFollowing;
import com.example.demo.entity.UserFollowingPK;
import com.example.demo.model.GITUserResponse;
import com.example.demo.repository.GITProfileRepository;
import com.example.demo.repository.UserFollowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class GITApiServiceImpl implements GITApiService {

    private final GITProfileRepository gitProfileRepository;
    private final UserFollowingRepository userFollowingRepository;

    @Autowired
    public GITApiServiceImpl(GITProfileRepository gitProfileRepository, UserFollowingRepository userFollowingRepository){
        this.gitProfileRepository = gitProfileRepository;
        this.userFollowingRepository = userFollowingRepository;
    }


    @Override
    public void gitApiVeriCek() {

        //NOT: İşimiz kalmadığı için kapatıldı.
        if (true) {
            return;
        }

        System.out.println("Servis Başlangıç Saati:");
        System.out.println(new Date());

        RestTemplate restTemplate = new RestTemplate();

        for(int j = 0; j < 10; j++){
            String fooResourceUrl = "https://api.github.com/search/users?q=location:turkey&order=desc&page=" + j + "&per_page=100";


            try {
                ResponseEntity<GITUserResponse> gitUserResponseEntity = restTemplate.getForEntity(fooResourceUrl, GITUserResponse.class);
                GITUserResponse gitUserResponse = gitUserResponseEntity.getBody();
                System.out.println("Total Count : " + gitUserResponse.getTotal_count());
                List<GITProfile> items = gitUserResponse.getItems();
                System.out.println("Items -> ");

                items.forEach(i -> {
                    System.out.println(i.toString());
                    gitProfileRepository.save(i);
                });

            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }

        System.out.println("Servis Bitiş Saati:");
        System.out.println(new Date());


        //GİT revize test


    }


    @Transactional
    @Override
    public void gitUserFollowingCek() {

        List<GITProfile> gitProfiles = gitProfileRepository.findAllByFollowingKontrolEdildi(Boolean.FALSE);
        if (gitProfiles.isEmpty()) {
            return;
        }

        RestTemplate restTemplate = new RestTemplate();

        List<GITProfile> kontrolEdilecekler = gitProfiles.subList(0, 10);

        int counter = 0;
        for (GITProfile profile : kontrolEdilecekler) {
            counter++;


            System.out.println(counter + ". USER KONTROLU ");
            //TODO 403 rate lımıt donuyor gıthub'dan cozum dusunulecek. Thread.sleep vesaire ıle github api ıncelencek bekletılecke !

            String userName = profile.getLogin();
            String resourceUrl = "https://api.github.com/users/" + userName + "/following";

            //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
            //TODO: alttaki request'in headerina bunu token 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 olarak ekle.

            try {
                System.out.println("followingUserListResp rest request sending !");

                HttpHeaders headers = new HttpHeaders();
                headers.add("Authorization", "token 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");

                HttpEntity<String> entity = new HttpEntity<>("body", headers);

                ResponseEntity<GITProfile[]> followingUserListResp = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, GITProfile[].class);

                if (Objects.nonNull(followingUserListResp.getBody()) && followingUserListResp.getBody().length > 0) {

                    for (GITProfile followingUser : followingUserListResp.getBody()) {
                        UserFollowing userFollowing = new UserFollowing();

                        UserFollowingPK userFollowingPK = new UserFollowingPK();
                        userFollowingPK.setId(profile.getId());
                        userFollowingPK.setFollowing_user_id(followingUser.getId());

                        userFollowing.setId(userFollowingPK);

                        userFollowing.setLogin(userName);
                        userFollowing.setFollowing_user_name(followingUser.getLogin());
                        System.out.println(userFollowing);
                        userFollowingRepository.save(userFollowing);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            profile.setFollowingKontrolEdildi(Boolean.TRUE);
            gitProfileRepository.save(profile);


            try {
                Thread.sleep(10000);
                //TODO dene hata dvm ederse süreyi uzat
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }



}
