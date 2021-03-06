package com.chieftain.agency.entity;


import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "currency_rating")
public class CurrencyRating implements Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "rank")
    private Long rank;

    @Column(name = "price_usd")
    private Double priceUsd;

    @Column(name = "price_btc")
    private Double priceBtc;

    @Column(name = "volume_usd_24h")
    private Double volumeUsd24h;

    @Column(name = "market_cap_usd")
    private Double marketCapUsd;

    @Column(name = "available_supply")
    private Double availableSupply;

    @Column(name = "total_supply")
    private Double totalSupply;

    @Column(name = "max_supply")
    private Double maxSupply;

    @Column(name = "percent_change_1h")
    private Double percentChange1h;

    @Column(name = "percent_change_24h")
    private Double percentChange24h;

    @Column(name = "percent_change_7d")
    private Double percentChange7d;


    public CurrencyRating() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Double getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(Double priceUsd) {
        this.priceUsd = priceUsd;
    }

    public Double getPriceBtc() {
        return priceBtc;
    }

    public void setPriceBtc(Double priceBtc) {
        this.priceBtc = priceBtc;
    }

    public Double getVolumeUsd24h() {
        return volumeUsd24h;
    }

    public void setVolumeUsd24h(Double volumeUsd24h) {
        this.volumeUsd24h = volumeUsd24h;
    }

    public Double getMarketCapUsd() {
        return marketCapUsd;
    }

    public void setMarketCapUsd(Double marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    public Double getAvailableSupply() {
        return availableSupply;
    }

    public void setAvailableSupply(Double availableSupply) {
        this.availableSupply = availableSupply;
    }

    public Double getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(Double totalSupply) {
        this.totalSupply = totalSupply;
    }

    public Double getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(Double maxSupply) {
        this.maxSupply = maxSupply;
    }

    public Double getPercentChange1h() {
        return percentChange1h;
    }

    public void setPercentChange1h(Double percentChange1h) {
        this.percentChange1h = percentChange1h;
    }

    public Double getPercentChange24h() {
        return percentChange24h;
    }

    public void setPercentChange24h(Double percentChange24h) {
        this.percentChange24h = percentChange24h;
    }

    public Double getPercentChange7d() {
        return percentChange7d;
    }

    public void setPercentChange7d(Double percentChange7d) {
        this.percentChange7d = percentChange7d;
    }
}
