package by.erizol.calc.calcapp.ui;

public class CreditModel {

    private String summCredit;
    private String rate;
    private String date;

    public CreditModel() {
    }

    public CreditModel(String summCredit, String rate, String date) {
        this.summCredit = summCredit;
        this.rate = rate;
        this.date = date;
    }

    public String getSummCredit() {
        return summCredit;
    }

    public void setSummCredit(String summCredit) {
        this.summCredit = summCredit;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
