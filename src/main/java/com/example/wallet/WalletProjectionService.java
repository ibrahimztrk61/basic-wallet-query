package com.example.wallet;

import com.example.wallet.domain.Wallet;
import com.example.wallet.event.DepositedEvent;
import com.example.wallet.event.PaidEvent;
import com.example.wallet.event.WalletCreatedEvent;
import com.example.wallet.repository.WalletRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.annotation.SourceId;
import org.springframework.stereotype.Service;

@ProcessingGroup("projection")
@Service
public class WalletProjectionService {

    private final WalletRepository walletRepository;

    public WalletProjectionService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @EventHandler
    public void handle(WalletCreatedEvent event) {
        Wallet wallet = new Wallet(event.getId());
        walletRepository.save(wallet);
    }

    @EventHandler
    public void handle(DepositedEvent event, @SourceId String id) {
        walletRepository.findById(id).ifPresent(wallet -> {
            wallet.deposit(event.getAmount());
            walletRepository.save(wallet);
        });
    }

    @EventHandler
    public void handle(PaidEvent event, @SourceId String id) {
        walletRepository.findById(id).ifPresent(wallet -> {
            wallet.pay(event.getAmount());
            walletRepository.save(wallet);
        });
    }

    public Wallet getWallet(String id) {
        return walletRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Unable to find wallet with id :" + id));
    }
}
