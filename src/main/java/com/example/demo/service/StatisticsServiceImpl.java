package com.example.demo.service;

import com.example.demo.entity.GITSummary;
import com.example.demo.model.FollowSummary;
import com.example.demo.repository.UserFollowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private UserFollowingRepository userFollowingRepository;

    @Override
    public GITSummary getSummary() {

        List<FollowSummary> followSummaryList = userFollowingRepository.mostfollowing();

        List<FollowSummary> sortedList = followSummaryList.stream()
                .sorted((fs1, fs2) -> fs2.getTakipEdenSayi().compareTo(fs1.getTakipEdenSayi())).collect(Collectors.toList());

        System.out.println(sortedList);

        GITSummary gitSummary = new GITSummary();
        gitSummary.setEnCokTakipEdilenler(sortedList);

        if (!sortedList.isEmpty()) {
            gitSummary.setEnCokTakipEdilen(sortedList.get(0).getFollowingUserName());
        }


        return gitSummary;
    }

}
