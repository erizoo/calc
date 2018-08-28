package by.erizol.calc.calcapp.ui;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FireBasePojo {

    @SerializedName("countries")
    private List<String> countries;

    public FireBasePojo() {
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
