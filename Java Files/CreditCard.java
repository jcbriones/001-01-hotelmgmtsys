/*
 * Staff.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the CreditCard class which holds the data of a credit card such as name,
 * credit card number, exp date, etc...
 */
/**
 * Created by Ken on 4/5/2016.
 */
import java.util.Date;
public class CreditCard {
    private String name;
    private String cardname;
    private int ccv;
    private Date expDate;
    private String billingAddress;
    private double amount=0.00;

    public CreditCard(String name,String cardname,int ccv,Date expDate, String billingAddress, double amount) {
        this.name=name;
        this.cardname = cardname;
        this.ccv = ccv;
        this.expDate = expDate;
        this.billingAddress = billingAddress;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}