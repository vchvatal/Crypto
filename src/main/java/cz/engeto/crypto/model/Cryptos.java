package cz.engeto.crypto.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class Cryptos {

    private final List<Crypto> cryptos;

    //region Constructors
    public Cryptos() {
        this.cryptos = new ArrayList<>();
    }

    public Cryptos(Cryptos oldCryptos) {
        this.cryptos = new ArrayList<>(oldCryptos.cryptos);
    }

    public Cryptos(List<Crypto> oldList) {
        this.cryptos = new ArrayList<>(oldList);
    }
    //endregion

    /**
     * Metoda pro pridani kryptomeny
     */
    public void addCrypto(Crypto crypto) {
        this.cryptos.add(crypto);
    }

    /**
     * Metoda pro update kryptomeny podle id
     */
    public String updateCrypto(int id, Crypto updatedCrypto) {
        for (int i = 0; i < this.cryptos.size(); i++) {
            if (this.cryptos.get(i).getId() == id) {
                updatedCrypto.setId(id);
                this.cryptos.set(i, updatedCrypto);
                return "Kryptoměna byla upravena";
            }
        }
        return "Kryptoměna v seznamu neexistuje";
    }

    /**
     * Metoda pro odebrani vsech výskytu (vcetne duplicit) kryptomeny podle obsahu
     */
    public String deleteCrypto(Crypto crypto) {
        if (this.cryptos.removeIf(c -> c.equals(crypto))) {
            return "Kryptoměna smazána";
        } else {
            return "Kryptoměna v seznamu neexistuje";
        }
    }

    /**
     * Metoda pro odebrani vsech výskytu (vcetne duplicit) kryptomeny podle id
     */
    public String deleteCrypto(int id){
        if (this.cryptos.removeIf(c -> c.getId() == id)) {
            return "Kryptoměna smazána";
        } else {
            return "Kryptoměna v seznamu neexistuje";
        }
    }

    /**
     * Metoda pro vypis vsech kryptomen
     */
    public List<Crypto> allCryptos() {
        return this.cryptos;
    }

    /**
     * Metoda pro získání kryptomeny podle id
     */
    public Crypto getCryptoById(int id){
        return cryptos.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Metoda pro volitelne setrideni kryptomen.
     */
    public void sortCryptos (Comparator<Crypto> comparator) {
        this.cryptos.sort(comparator);
    }

    /**
     * Metoda pro vypocet celkove hodnoty portfolia
     */
    public Double getPortfolioValue() {
        return this.cryptos.stream()
                .mapToDouble(c -> c.getPrice() * c.getQuantity())
                .sum();
    }

    /**
     * Metoda pro vypis seznamu kryptomen
     */
    public void printCryptos(String titul) {
        System.out.println(titul);
        for (Crypto crypto : this.cryptos) {
            System.out.println(crypto);
        }
    }

    /**
     * Metoda na vymazani seznamu kryptomen.
     */
    public void clearCryptos() {
        this.cryptos.clear();
    }

}
