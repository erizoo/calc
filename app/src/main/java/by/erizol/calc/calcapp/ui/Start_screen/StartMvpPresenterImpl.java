package by.erizol.calc.calcapp.ui.Start_screen;

import java.util.List;

import javax.inject.Inject;

import by.erizol.calc.calcapp.data.RepositoryManager;
import by.erizol.calc.calcapp.ui.base.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class StartMvpPresenterImpl  <V extends StartMvpView> extends BasePresenter<V>
        implements StartMvpPresenter<V>  {

    @Inject
    public StartMvpPresenterImpl(RepositoryManager repositoryManager, CompositeDisposable compositeDisposable) {
        super(repositoryManager, compositeDisposable);
    }

    @Override
    public void checkCountry() {
        getCompositeDisposable().add(
                getRepositoryManager().getServiceNetwork().checkCountry()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                getMvpView()::onCountryChecked,
                                Throwable::printStackTrace
                        )
        );
    }
}
