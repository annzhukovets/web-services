package com.football.service;

import com.football.domain.FootballPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FootballShotService implements IFootballShotService {

    private String QUEUE = "shot";

    private final static Logger logger = LoggerFactory.getLogger(FootballShotService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void makeShot(FootballPlayer footballPlayer) {
            logger.info("making new shot for player {}", footballPlayer.getId());
            rabbitTemplate.convertAndSend(QUEUE, footballPlayer);
    }
}
