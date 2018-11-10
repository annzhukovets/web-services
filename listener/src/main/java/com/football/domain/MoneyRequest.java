package com.football.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class MoneyRequest implements Serializable {

    private static final long serialVersionUID = 2L;

    private String id;

    private BigDecimal money;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
