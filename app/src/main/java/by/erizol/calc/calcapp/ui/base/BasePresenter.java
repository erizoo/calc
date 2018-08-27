package by.erizol.calc.calcapp.ui.base;

import javax.inject.Inject;
import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private final CompositeDisposable compositeDisposable;

    private V mvpView;

    @Inject
    public BasePresenter( CompositeDisposable compositeDisposable) {
        this.compositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(V mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void onDetach() {
        compositeDisposable.dispose();
    }

    @Override
    public void onDestroy() {
        compositeDisposable.dispose();
    }

    @Override
    public V getMvpView() {
        return mvpView;
    }

    @Override
    public CompositeDisposable getCompositeDisposable(){
        return compositeDisposable;
    }

}
