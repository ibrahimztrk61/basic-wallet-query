package com.example.wallet.domain;

import java.math.BigDecimal;

public class WalletResponse {

    private String id;
    private BigDecimal balance;
    private Integer depositCount;
    private Integer payCount;

    public static WalletResponse fromModel(Wallet wallet) {
        WalletResponse walletResponse = new WalletResponse();
        walletResponse.id = wallet.getId();
        walletResponse.balance = wallet.getBalance();
        walletResponse.depositCount = wallet.getDepositCount();
        walletResponse.payCount = wallet.getPayCount();
        return walletResponse;
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

}
