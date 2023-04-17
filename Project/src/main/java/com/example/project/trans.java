package com.example.project;

public class trans {
    String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    String desc;
    String amount;
    trans(String date, String desc, String amount){
        setAmount(amount);
        setDate(date);
        setDesc(desc);
    }
}
