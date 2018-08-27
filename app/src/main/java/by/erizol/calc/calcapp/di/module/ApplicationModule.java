package by.erizol.calc.calcapp.di.module;

import android.content.Context;

import by.erizol.calc.calcapp.Calc;
import by.erizol.calc.calcapp.di.PerScreen;
import by.erizol.calc.calcapp.ui.MainMvpPresenter;
import by.erizol.calc.calcapp.ui.MainMvpPresenterImpl;
import by.erizol.calc.calcapp.ui.MainMvpView;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ApplicationModule {

    private Calc application;

    public ApplicationModule(Calc application) {

        this.application = application;
    }

    @Provides
    Context provideContext() {
        return application;
    }


    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerScreen
    MainMvpPresenter<MainMvpView> provideMainMvpPresenter(MainMvpPresenterImpl<MainMvpView> presenter){
        return presenter;
    }
}
