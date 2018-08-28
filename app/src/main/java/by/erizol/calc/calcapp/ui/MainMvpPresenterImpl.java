package by.erizol.calc.calcapp.ui;

import javax.inject.Inject;

import by.erizol.calc.calcapp.data.RepositoryManager;
import by.erizol.calc.calcapp.ui.base.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainMvpPresenterImpl <V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    private static final int DAY_OF_MONTH = 30;

    @Inject
    public MainMvpPresenterImpl(RepositoryManager repositoryManager, CompositeDisposable compositeDisposable) {
        super(repositoryManager, compositeDisposable);
    }


    @Override
    public void count(CreditModel creditModel) {
        double interestPerMonth = getInterestPerMonth(creditModel);
        double bodyCredit = getBodyCredit(creditModel);
        double monthlyPaymen = getMonthlyPaymen(bodyCredit, interestPerMonth);
        double totalSum = getTotalSum(monthlyPaymen, creditModel);
        double overpayment = getOverpayment(totalSum, creditModel);
        getMvpView().sendMessage(interestPerMonth, bodyCredit, monthlyPaymen, totalSum, overpayment);
    }

    @Override
    public void checkCountry() {
        getCompositeDisposable().add(
                getRepositoryManager().getServiceNetwork().checkCountry()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                getMvpView()::onCountrtChecked,
                                Throwable::printStackTrace
                        )
        );
    }

    private double getOverpayment(double totalSum, CreditModel creditModel) {
        double result = totalSum - creditModel.getSummCredit();
        return Math.round(result*100)/100.0d;
    }

    private double getTotalSum(double monthlyPaymen, CreditModel creditModel) {
        double result = monthlyPaymen * creditModel.getDate();
        return Math.round(result*100)/100.0d;
    }

    private double getMonthlyPaymen(double bodyCredit, double interestPerMonth) {
        double result = bodyCredit + interestPerMonth;
        return Math.round(result*100)/100.0d;
    }

    private double getBodyCredit(CreditModel creditModel) {
        double result = creditModel.getSummCredit() / creditModel.getDate();
        return Math.round(result*100)/100.0d;
    }

    public double getInterestPerMonth(CreditModel creditModel){
        double result = (creditModel.getSummCredit() * creditModel.getRate() * DAY_OF_MONTH)/365;
        return Math.round(result*100)/100.0d;
    }


}
