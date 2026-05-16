package cz.engeto.crypto.model;

import java.util.Objects;

public class Crypto implements Comparable<Crypto> {

    private Integer id; // unikátní identifikátor kryptoměny
    private String name; // název kryptoměny (např. Bitcoin, Ethereum)
    private String symbol; // zkratka kryptoměny (např. BTC, ETH)
    private Double price; // aktuální cena kryptoměny v dolarech
    private Double quantity; // počet jednotek kryptoměny v portfoliu.

    public Crypto() {
    }

    public Crypto(Integer id, String name, String symbol, Double price, Double quantity) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
    }

    //region Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
    //endregion Getters and Setters

    /**
     * Metoda pro porovnání kryptoměn
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Crypto crypto = (Crypto) object;
        return Objects.equals(id, crypto.id) &&
                Objects.equals(name, crypto.name) &&
                Objects.equals(symbol, crypto.symbol) &&
                Objects.equals(price, crypto.price) &&
                Objects.equals(quantity, crypto.quantity);

    }

    /**
     * Prepsani hashCode() kvuli souvislosti s equals()
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, symbol, price, quantity);
    }

    /**
     * Vychozi razeni seznamu kryptomen je podle jmena
     */
    @Override
    public int compareTo(Crypto other) {
        if (this.name == null && other.name == null) return 0;
        if (this.name == null) return -1;
        if (other.name == null) return 1;
        return this.name.compareTo(other.name);
    }

    /**
     * Metoda popis objektu tridy Crypto
     */
    @Override
    public String toString () {
        return "id: " + this.getId() + " " +
                "Jméno: " + this.getName() + " " +
                "Zkratka: " + this.getSymbol() + " " +
                "Cena $: " + this.getPrice() + " " +
                "Počet: " + this.getQuantity();
    }
}
