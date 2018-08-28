package by.erizol.calc.calcapp.ui;

import javax.inject.Inject;

import by.erizol.calc.calcapp.ui.base.BasePresenter;
import io.reactivex.disposables.CompositeDisposable;

public class MainMvpPresenterImpl <V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    @Inject
    public MainMvpPresenterImpl(CompositeDisposable compositeDisposable) {
        super(compositeDisposable);
    }

    @Override
    public void sendMessage() {
        getMvpView().sendMessage();
    }
}
