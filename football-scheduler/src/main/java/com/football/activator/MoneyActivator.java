package com.football.activator;

import com.football.domain.FootballPlayer;
import com.football.domain.MoneyRequest;
import com.football.repository.FootballPlayerRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyActivator {

    @Autowired
    private FootballPlayerRepository footballPlayerRepository;

    @RabbitListener(queues = "money")
    void handleMoney(MoneyRequest moneyRequest) {
        FootballPlayer player = footballPlayerRepository.findById(moneyRequest.getId()).orElse(null);
        if (player != null) {
            player.setMoney(player.getMoney().add(moneyRequest.getMoney()));
            footballPlayerRepository.save(player);
        }
    }
}
