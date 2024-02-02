package com.culture.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

import com.culture.API.Models.Wallet;


public interface WalletRepository extends JpaRepository<Wallet, Long> {

        List<Wallet> findAll();
        Optional<Wallet> findById(Long id);
}