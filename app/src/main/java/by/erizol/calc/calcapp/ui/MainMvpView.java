package by.erizol.calc.calcapp.ui;

import by.erizol.calc.calcapp.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void sendMessage(double interestPerMonth, double bodyCredit, double monthlyPaymen, double totalSum, double overpayment);
}
