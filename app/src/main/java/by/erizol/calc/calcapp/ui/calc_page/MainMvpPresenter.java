package by.erizol.calc.calcapp.ui.calc_page;

import by.erizol.calc.calcapp.ui.shop_window.CreditModel;
import by.erizol.calc.calcapp.ui.base.MvpPresenter;

public interface MainMvpPresenter <V extends MainMvpView> extends MvpPresenter<V> {

    void count(CreditModel creditModel);

}
