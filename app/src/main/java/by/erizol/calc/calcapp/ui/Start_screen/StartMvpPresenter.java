package by.erizol.calc.calcapp.ui.Start_screen;

import java.util.List;

import by.erizol.calc.calcapp.ui.base.MvpPresenter;

public interface StartMvpPresenter <V extends StartMvpView> extends MvpPresenter<V> {

    void checkCountry();
}
