package by.erizol.calc.calcapp.data.ResponseModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseCountry {

    @SerializedName("countries")
    private List<String> countries;

    public ResponseCountry() {
    }

    public ResponseCountry(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }
}
