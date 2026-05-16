package cz.engeto.crypto.controller;

import cz.engeto.crypto.model.Crypto;
import cz.engeto.crypto.model.Cryptos;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class CryptoController {

    private final Cryptos cryptos = new Cryptos();

    /**
     * Endpoint pro pridani kryptomeny
     */
    @PostMapping("cryptos")
    public Crypto addCrypto(@RequestBody Crypto crypto) {
        this.cryptos.addCrypto(crypto);
        return crypto;
    }

    /**
     * Endpoint pro odstraneni kryptomeny
     */
    @DeleteMapping("cryptos/delete")
    public Crypto removeCrypto(@RequestBody Crypto crypto) {
        this.cryptos.removeCrypto(crypto);
        return crypto;
    }

    /**
     * Endpoint pro vypis vsech kryptomen
     */
    @GetMapping("cryptos")
    public List<Crypto> allCryptos() {
        return this.cryptos.allCryptos();
    }

    /**
     * Endpoint pro vypis s defaultnim setridenim kryptomen.
     */
    @GetMapping("cryptos/sort")
    public List<Crypto> sortAllCryptos () {
        this.cryptos.sortCryptos();
        return this.cryptos.allCryptos();
    }

//    /**
//     * Endpoint pro vypis s volitelnym setridenim kryptomen.
//     */
//    @GetMapping("cryptos/sort/")
//    public List<Crypto> sortAllCryptos (Comparator<Crypto> comparator) {
//        this.cryptos.sortCryptos(comparator);
//        return this.cryptos.allCryptos();
//    }

    /**
     * Endpoint pro inicializaci seznamu pro otestovani endpointu
     */
    @GetMapping("cryptos/init")
    public List<Crypto> initCryptos() {
        this.cryptos.clearCryptos();
        this.cryptos.addCrypto(new Crypto(1,"Bitcoin","BTC",78200.0,10.0));
        this.cryptos.addCrypto(new Crypto(2,"Ethereum)","ETH",2180.0,60.0));
        this.cryptos.addCrypto(new Crypto(3,"Cardano","ADA",0.2,150.0));
        return this.cryptos.allCryptos();
    }

    /**
     * Endpoint pro vyprazdneni seznamu
     */
    @GetMapping("cryptos/clear")
    public List<Crypto> clearCryptos() {
        this.cryptos.clearCryptos();
        return this.cryptos.allCryptos();
    }
}
