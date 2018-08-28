package by.erizol.calc.calcapp.data.network;

import by.erizol.calc.calcapp.data.ResponseModel.ResponseCountry;
import io.reactivex.Observable;

public interface ServiceNetwork {

    Observable<ResponseCountry> checkCountry();
}
