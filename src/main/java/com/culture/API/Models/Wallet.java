package com.culture.API.Models;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import com.culture.API.Repository.WalletRepository;

import jakarta.persistence.*;

@Entity
public class Wallet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String number;

    @Basic
    private double balance;

    @OneToOne
    @JoinColumn(name = "idOwner")
    private Owner owner;

    @OneToMany(mappedBy = "wallet", fetch = FetchType.EAGER)
    private List<WalletTransaction> walletTransactions;

    public Wallet() {
    }

    public Wallet(String number, double balance, Owner owner) {
        this.number = number;
        this.balance = balance;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public static Wallet saveWallet(Wallet w, WalletRepository wr) {
        return wr.save(w);
    }

    public static List<Wallet> findAllWallet(WalletRepository wr) {
        return wr.findAll();
    }

    public static Wallet findById(Long id, WalletRepository wr) {
        return wr.findById(id).orElse(null);
    }

    public void inscription(WalletRepository walletRepository) {
        throw new UnsupportedOperationException("Unimplemented method 'Inscription'");
    }
}
