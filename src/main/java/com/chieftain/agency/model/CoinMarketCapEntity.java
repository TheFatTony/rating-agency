package com.chieftain.agency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinMarketCapEntity {

    @JsonIgnore
    private String id;
    private String name;
    private String symbol;
    private Integer rank;

    @JsonProperty("price_usd")
    private Double priceUsd;

    @JsonProperty("price_btc")
    private Double priceBtc;

    @JsonProperty("24h_volume_usd")
    private Double volumeUsd24h;

    @JsonProperty("market_cap_usd")
    private Double markeCapUsd;

    @JsonProperty("available_supply")
    private Double availableSupply;

    @JsonProperty("total_supply")
    private String totalSupply;

    @JsonProperty("max_supply")
    private Double maxSupply;

    @JsonProperty("percent_change_1h")
    private Double percentChange1h;

    @JsonProperty("percent_change_24h")
    private Double percentChange24h;

    @JsonProperty("percent_change_7d")
    private Double percentChange7d;

    @JsonIgnore
    @JsonProperty("last_updated")
    private String lastUpdated;


    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
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

    public Double getMarkeCapUsd() {
        return markeCapUsd;
    }

    public void setMarkeCapUsd(Double markeCapUsd) {
        this.markeCapUsd = markeCapUsd;
    }

    public Double getAvailableSupply() {
        return availableSupply;
    }

    public void setAvailableSupply(Double availableSupply) {
        this.availableSupply = availableSupply;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(String totalSupply) {
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

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
