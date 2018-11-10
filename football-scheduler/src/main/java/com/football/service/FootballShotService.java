package com.football.service;

import com.football.domain.FootballPlayer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FootballShotService implements IFootballShotService {

    private String QUEUE = "shot";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void makeShot(FootballPlayer footballPlayer) {
            rabbitTemplate.convertAndSend(QUEUE, footballPlayer);
    }
}
