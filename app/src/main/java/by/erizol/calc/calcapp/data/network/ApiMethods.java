package by.erizol.calc.calcapp.data.network;

import by.erizol.calc.calcapp.data.ResponseModel.ResponseCountry;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiMethods {

    @GET("json")
    Observable<ResponseCountry> checkCountry(@Header("User-Agent") String value);
}
