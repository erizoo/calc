package by.erizol.calc.calcapp.data.ResponseModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseCountry {

    private String country;

    public ResponseCountry() {
    }

    public ResponseCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
