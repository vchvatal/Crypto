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
     * Metoda pro odebrani kryptomeny
     */
    public void removeCrypto(Crypto crypto) {
        this.cryptos.remove(crypto);
    }

    /**
     * Metoda pro vypis vsech kryptomen
     */
    public List<Crypto> allCryptos() {
        return new ArrayList<>(this.cryptos);
    }

    /**
     * Metoda pro defaultni setrideni kryptomen.
     */
    public void sortCryptos () {
        this.cryptos.sort(null);
    }

//    /**
//     * Metoda pro volitelne setrideni kryptomen.
//     */
//    public void sortCryptos (Comparator<Crypto> comparator) {
//        this.cryptos.sort(comparator);
//    }

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
