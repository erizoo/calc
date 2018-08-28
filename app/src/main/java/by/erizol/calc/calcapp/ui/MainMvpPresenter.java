package by.erizol.calc.calcapp.ui;

import by.erizol.calc.calcapp.ui.base.MvpPresenter;

public interface MainMvpPresenter <V extends MainMvpView> extends MvpPresenter<V> {

    void sendMessage();

    void count(CreditModel creditModel);
}
