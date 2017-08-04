package pojo;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TICKER")
public class Ticker {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TICKER_SEQ")
    @javax.persistence.SequenceGenerator(
            name = "TICKER_SEQ",
            sequenceName = "TICKER_SEQ",
            allocationSize = 1
    )
    @Column(name = "ID")
    private int id;

    @Column(name = "CREATEDON")
    private LocalDateTime createdOn;

    @Column(name = "CURRENCYPAIR")
    private String currencyPair;

    @Column(name = "LAST")
    private String last;

    @Column(name = "LOWESTASK")
    private String lowestAsk;

    @Column(name = "HIGHESTBID")
    private String highestBid;

    @Column(name = "PERCENTCHANGE")
    private String percentChange;

    @Column(name = "BASEVOLUME")
    private String baseVolume;

    @Column(name = "QUOTEVOLUME")
    private String quoteVolume;

    public Ticker() {
    }

    public Ticker(LocalDateTime createdOn, String currencyPair, String last, String lowestAsk, String highestBid, String percentChange, String baseVolume, String quoteVolume) {
        this.createdOn = createdOn;
        this.currencyPair = currencyPair;
        this.last = last;
        this.lowestAsk = lowestAsk;
        this.highestBid = highestBid;
        this.percentChange = percentChange;
        this.baseVolume = baseVolume;
        this.quoteVolume = quoteVolume;
    }

    public int getId() {
        return id;
    }



    public LocalDateTime getCreatedOn() {
        return createdOn; }

    public void setCreatedOn() { this.createdOn = createdOn; }

    public String getCurrencyPair() {
        return currencyPair;
    }

    public void setCurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getLowestAsk() {
        return lowestAsk;
    }

    public void setLowestAsk(String lowestAsk) {
        this.lowestAsk = lowestAsk;
    }

    public String getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(String highestBid) {
        this.highestBid = highestBid;
    }

    public String getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(String percentChange) {
        this.percentChange = percentChange;
    }

    public String getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(String baseVolume) {
        this.baseVolume = baseVolume;
    }

    public String getQuoteVolume() {
        return quoteVolume;
    }

    public void setQuoteVolume(String quoteVolume) {
        this.quoteVolume = quoteVolume;
    }
}
