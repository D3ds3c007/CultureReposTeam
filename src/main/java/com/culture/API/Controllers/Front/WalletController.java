package com.culture.API.Controllers.Front;
import com.culture.API.Models.Wallet;
import com.culture.API.Repository.WalletRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET})

public class WalletController {
    @Autowired
    private WalletRepository walletRepository;
    // private FieldRepository fieldRepository;

    @GetMapping("/wallet") 
    public ResponseEntity<List<Wallet>> getAllWallet(){
        try{
            List<Wallet> w = Wallet.findAllWallet(walletRepository);
            return new ResponseEntity<>(w, HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/wallets")
    public ResponseEntity<Wallet> insertWallet(@RequestBody Wallet w) {
        try{
            Wallet wt = Wallet.saveWallet(w, walletRepository);
            return new ResponseEntity<>(wt,HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
    
}
