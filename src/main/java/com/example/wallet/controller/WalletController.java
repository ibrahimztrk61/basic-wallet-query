package com.example.wallet.controller;

import com.example.wallet.WalletProjectionService;
import com.example.wallet.domain.Wallet;
import com.example.wallet.domain.WalletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    private final WalletProjectionService walletProjectionService;

    public WalletController(WalletProjectionService walletProjectionService) {
        this.walletProjectionService = walletProjectionService;
    }

    @GetMapping("/{id}")
    public WalletResponse getWallet(@PathVariable("id") String id) {
        Wallet wallet = walletProjectionService.getWallet(id);
        return WalletResponse.fromModel(wallet);
    }
}
