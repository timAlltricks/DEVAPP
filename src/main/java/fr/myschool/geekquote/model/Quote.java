package fr.myschool.geekquote.model;

import java.util.Date;

public class Quote {
    private String strQuote;
    private int rating;
    private Date date;

    public Quote(){}

    public Quote(String quote){
        this.strQuote = quote;
        this.rating = 0;
        this.date = new Date();
    }

    public String getStrQuote() {
        return strQuote;
    }

    public void setStrQuote(String strQuote) {
        this.strQuote = strQuote;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return strQuote;
    }
}
