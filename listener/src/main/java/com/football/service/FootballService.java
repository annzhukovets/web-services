package com.football.service;

import com.amazonaws.services.lambda.invoke.LambdaFunction;
import com.football.domain.FootballPlayer;
import com.football.domain.MoneyRequest;

public interface FootballService {

    @LambdaFunction(functionName = "test1")
    MoneyRequest makeShot(FootballPlayer footballPlayer);
}
