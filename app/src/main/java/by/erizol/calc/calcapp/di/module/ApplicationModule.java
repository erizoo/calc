package by.erizol.calc.calcapp.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Singleton;

import by.erizol.calc.calcapp.Calc;
import by.erizol.calc.calcapp.di.ActivityContext;
import by.erizol.calc.calcapp.di.ApplicationContext;
import by.erizol.calc.calcapp.di.PerScreen;
import by.erizol.calc.calcapp.ui.MainMvpPresenter;
import by.erizol.calc.calcapp.ui.MainMvpPresenterImpl;
import by.erizol.calc.calcapp.ui.MainMvpView;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ApplicationModule {

    private final Calc application;

    public ApplicationModule(Calc application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    Calc provideApplication() {
        return application;
    }
}

