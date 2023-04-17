package com.example.project;

public class trans {
    String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return desccription;
    }

    public void setDescription(String description) {
        this.desccription = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    String desccription;
    String amount;
    trans(String date, String desc, String amount){
        setAmount(amount);
        setDate(date);
        setDescription(desc);
    }
}
