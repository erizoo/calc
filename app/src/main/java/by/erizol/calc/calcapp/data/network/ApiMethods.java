package by.erizol.calc.calcapp.data.network;

import by.erizol.calc.calcapp.data.ResponseModel.ResponseCountry;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiMethods {

    @GET()
    Observable<ResponseCountry> checkCountry();
}
