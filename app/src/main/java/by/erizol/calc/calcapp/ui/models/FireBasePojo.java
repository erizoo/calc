package by.erizol.calc.calcapp.ui.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FireBasePojo {

    @SerializedName("countries")
    private List<String> countries;
    @SerializedName("offers")
    private List<OffersModel> offers;
    @SerializedName("name")
    private String name;

    public FireBasePojo() {
    }

    public List<OffersModel> getOffers() {
        return offers;
    }

    public void setOffers(List<OffersModel> offers) {
        this.offers = offers;
    }

    public FireBasePojo(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
