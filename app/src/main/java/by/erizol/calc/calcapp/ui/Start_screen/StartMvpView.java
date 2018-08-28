package by.erizol.calc.calcapp.ui.Start_screen;

import by.erizol.calc.calcapp.data.ResponseModel.ResponseCountry;
import by.erizol.calc.calcapp.ui.base.MvpView;

public interface StartMvpView extends MvpView {

    void onCountryChecked(ResponseCountry responseCountry);
}
