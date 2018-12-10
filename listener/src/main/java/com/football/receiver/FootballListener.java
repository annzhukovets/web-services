package com.football.receiver;

import com.football.domain.FootballPlayer;
import com.football.domain.MoneyRequest;
import com.football.service.FootballService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FootballListener {

    private final static Logger logger = LoggerFactory.getLogger(FootballListener.class);

    @Autowired
    private FootballService footballService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "shot")
    public void makeShot(FootballPlayer footballPlayer) {
        MoneyRequest moneyRequest = footballService.makeShot(footballPlayer);
        logger.info("shot result - ", moneyRequest.getMoney());
        rabbitTemplate.convertAndSend("money", moneyRequest);
    }
}
