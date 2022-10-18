package com.example.demo.service;

import com.example.demo.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CRONJobService {

    @Autowired
    private GITApiService gitApiService;

    @Scheduled(fixedRate = 30000, initialDelay = 5000)
    public void followingJobExecute() {

        if (StringUtil.isEmpty("ererasdasd")) {
            System.out.println("STRING DOLU ");
        }

        if (true)  {
            System.out.println("followingJobExecute iptal edildi !");
            return;
        }

        System.out.println("followingJobExecute started :" + new Date());
        gitApiService.gitUserFollowingCek();
        System.out.println("followingJobExecute ended :" + new Date());
    }





}
