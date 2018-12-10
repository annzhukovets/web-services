package com.football.runner;

import com.football.domain.FootballPlayer;
import com.football.repository.FootballPlayerRepository;
import com.football.service.FootballShotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShotRunner implements CommandLineRunner {
    private final static Logger logger = LoggerFactory.getLogger(ShotRunner.class);

    @Autowired
    private FootballPlayerRepository footballPlayerRepository;

    @Autowired
    private FootballShotService footballShotService;


    @Override
    public void run(String... args) throws Exception {
        while (true) {
            try {
                logger.info(" Input something to start");
                System.in.read();
                List<FootballPlayer> list = footballPlayerRepository.findAll();

                if (list != null) {
                    list.forEach(footballShotService::makeShot);
                }
            } catch (Exception e) {
                logger.error("exception", e);
            }
        }
    }
}

