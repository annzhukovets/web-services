package com.football.scheduler;

import com.football.repository.FootballPlayerRepository;
import com.football.domain.FootballPlayer;
import com.football.service.IFootballShotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShotScheduler {

    @Autowired
    private FootballPlayerRepository footballPlayerRepository;

    @Autowired
    private IFootballShotService footballShotService;

    @Scheduled(fixedDelay = 1000 * 60)
    public void makeShots() {
        List<FootballPlayer> list = footballPlayerRepository.findAll();
        if (list != null) {
            list.forEach(footballShotService::makeShot);
        }
    }
}
