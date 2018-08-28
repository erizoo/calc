package by.erizol.calc.calcapp.ui.shop_window;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FireBasePojo {

    @SerializedName("countries")
    private List<String> countries;
    @SerializedName("offers")
    private List<OffersModel> offers;

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
}
