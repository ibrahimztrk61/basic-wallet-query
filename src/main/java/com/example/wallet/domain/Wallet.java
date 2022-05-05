package com.example.wallet.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Wallet {

    @Id
    private String id;

    private BigDecimal balance = BigDecimal.ZERO;

    private Integer depositCount = 0;

    private Integer payCount = 0;

    public Wallet() {
    }

    public Wallet(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Integer getDepositCount() {
        return depositCount;
    }

    public Integer getPayCount() {
        return payCount;
    }

    public void deposit(BigDecimal amount) {
        this.depositCount = this.depositCount + 1;
        this.balance = this.balance.add(amount);
    }

    public void pay(BigDecimal amount) {
        this.payCount = this.payCount + 1;
        this.balance = this.balance.subtract(amount);
    }
}
