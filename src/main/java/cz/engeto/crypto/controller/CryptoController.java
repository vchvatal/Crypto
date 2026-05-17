package cz.engeto.crypto.controller;

import cz.engeto.crypto.model.Crypto;
import cz.engeto.crypto.service.CryptoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cryptos")
public class CryptoController {

    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    /**
     * Endpoint pro pridani kryptomeny
     */
    @PostMapping("")
    public Crypto addCrypto(@RequestBody Crypto crypto) {
        this.cryptoService.addCrypto(crypto);
        return crypto;
    }

    /**
     * Endpoint pro vraceni kryptomeny podle id
     */
    @GetMapping("/{id}")
    public Crypto getCryptoById(@PathVariable(value = "id") int idOfCrypto){
        return this.cryptoService.getCryptoById(idOfCrypto);
    }

    /**
     * Endpoint pro aktualizaci kryptomeny podle id
     */
    @PutMapping("/{id}")
    public String updateCrypto(@PathVariable(value = "id") int idOfCrypto,
                                               @RequestBody Crypto crypto) {
        return this.cryptoService.updateCrypto(idOfCrypto, crypto);
    }

    /**
     * Endpoint pro vypis vsech kryptomen, volitelne setrideny podle name, price nebo quantity.
     * /cryptos - bez razeni
     */
    @GetMapping("")
    public List<Crypto> allCryptos(@RequestParam(value = "sort", required = false) String sortBy) {
        if (sortBy != null) {
            return this.cryptoService.getSortedCryptos(sortBy);
        }
        return this.cryptoService.getAllCryptos();
    }

    /**
     * Endpoint pro vypocet celkove hodnoty portfolia
     */
    @GetMapping("/portfolio-value")
    public Double getPortfolioValue() {
        return this.cryptoService.getPortfolioValue();
    }

    /**
     * Endpoint pro odstraneni kryptomeny (vcetne duplicit) podle celkove shody
     */
    @DeleteMapping("/delete")
    public String deleteCrypto(@RequestBody Crypto crypto) {
        return this.cryptoService.deleteCrypto(crypto);
    }

    /**
     * Endpoint pro odstraneni kryptomeny (vcetne duplicit) podle id
     */
    @DeleteMapping("/delete/{id}")
    public String deleteCrypto(@PathVariable(value = "id") int idOfCrypto){
        return this.cryptoService.deleteCrypto(idOfCrypto);
    }

    /**
     * Endpoint pro inicializaci seznamu pro otestovani endpointu
     */
    @PostMapping("/init")
    public List<Crypto> initCryptos() {
        this.cryptoService.clearCryptos();
        this.cryptoService.initCryptos();
        return this.cryptoService.getAllCryptos();
    }

    /**
     * Endpoint pro vyprazdneni seznamu
     */
    @PostMapping("/clear")
    public List<Crypto> clearCryptos() {
        this.cryptoService.clearCryptos();
        return this.cryptoService.getAllCryptos();
    }
}
