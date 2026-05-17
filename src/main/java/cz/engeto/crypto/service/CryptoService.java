package cz.engeto.crypto.service;

import cz.engeto.crypto.model.Crypto;
import cz.engeto.crypto.model.Cryptos;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CryptoService {

    private final Cryptos cryptos = new Cryptos();

    /**
     * Sluzba pro pridani kryptomeny
     */
    public void addCrypto(Crypto crypto) {
        this.cryptos.addCrypto(crypto);
    }

    /**
     * Sluzba pro aktualizaci kryptomeny podle id
     */
    public String updateCrypto(int id, Crypto updatedCrypto) {
        return this.cryptos.updateCrypto(id, updatedCrypto);
    }

    /**
     * Sluzba pro odebrani vsech výskytu (vcetne duplicit) kryptomeny podle obsahu
     */
    public String deleteCrypto(Crypto crypto) {
        return this.cryptos.deleteCrypto(crypto);
    }

    /**
     * Sluzba pro odebrani vsech výskytu (vcetne duplicit) kryptomeny podle id
     */
    public String deleteCryptoById(int id) {
        return this.cryptos.deleteCrypto(id);
    }

    /**
     * Sluzba pro vraceni kryptomeny
     */
    public Crypto getCryptoById(int id) {
        return this.cryptos.getCryptoById(id);
    }

    /**
     * Sluzba pro vypis vsech kryptomen
     */
    public List<Crypto> getAllCryptos() {
        return this.cryptos.allCryptos();
    }

    /**
     * Sluzba pro setrideni kryptomen podle zadaneho parametru (name, price, quantity).
     */
    public List<Crypto> getSortedCryptos(String sortBy) {
        Comparator<Crypto> comparator = switch (sortBy) {
            case "price"    -> Comparator.comparing(Crypto::getPrice);
            case "quantity" -> Comparator.comparing(Crypto::getQuantity);
            default         -> Comparator.comparing(Crypto::getName);
        };
        this.cryptos.sortCryptos(comparator);
        return this.cryptos.allCryptos();
    }

    /**
     * Sluzba pro vypocet celkove hodnoty portfolia
     */
    public Double getPortfolioValue() {
        return this.cryptos.getPortfolioValue();
    }

    /**
     * Sluzba pro vymazani a naplneni seznamu testovacimi daty
     */
    public void initCryptos() {
        this.cryptos.clearCryptos();
        this.cryptos.addCrypto(new Crypto(1, "Bitcoin", "BTC", 78200.0, 10.0));
        this.cryptos.addCrypto(new Crypto(2, "Ethereum", "ETH", 2180.0, 60.0));
        this.cryptos.addCrypto(new Crypto(3, "Cardano", "ADA", 0.2, 150.0));
    }

    /**
     * Sluzba pro vymazani seznamu
     */
    public void clearCryptos() {
        this.cryptos.clearCryptos();
    }

    /**
     * Sluzba pro odebrani vsech výskytu (vcetne duplicit) kryptomeny podle id
     */
    public String deleteCrypto(int idOfCrypto) {
        return this.cryptos.deleteCrypto(idOfCrypto);
    }
}