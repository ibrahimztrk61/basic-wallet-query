package com.example.wallet.repository;


import com.example.wallet.domain.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<Wallet, String> {


}
