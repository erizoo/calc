package by.erizol.calc.calcapp.ui.base;

import by.erizol.calc.calcapp.data.RepositoryManager;
import io.reactivex.disposables.CompositeDisposable;

public interface MvpPresenter<V> {

    void onAttach(V mvpView);

    void onDetach();

    void onDestroy();

    CompositeDisposable getCompositeDisposable();

    V getMvpView();

    RepositoryManager getRepositoryManager();

}
