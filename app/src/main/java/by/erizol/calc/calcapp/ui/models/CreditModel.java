package by.erizol.calc.calcapp.ui.models;

public class CreditModel {

    private double summCredit;
    private double rate;
    private double date;

    public CreditModel() {
    }

    public CreditModel(double summCredit, double rate, double date) {
        this.summCredit = summCredit;
        this.rate = rate;
        this.date = date;
    }

    public double getSummCredit() {
        return summCredit;
    }

    public void setSummCredit(double summCredit) {
        this.summCredit = summCredit;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getDate() {
        return date;
    }

    public void setDate(double date) {
        this.date = date;
    }
}
