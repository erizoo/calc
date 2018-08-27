package by.erizol.calc.calcapp.ui.base;

import android.content.Context;

public interface MvpView {

    Context getContext();

    void startScreen(Class activity, boolean isCleatTop);

}
