package by.erizol.calc.calcapp.di.module;

import  android.content.Context;
import android.support.v7.app.AppCompatActivity;

import by.erizol.calc.calcapp.di.ActivityContext;
import by.erizol.calc.calcapp.di.PerScreen;
import by.erizol.calc.calcapp.ui.MainMvpPresenter;
import by.erizol.calc.calcapp.ui.MainMvpPresenterImpl;
import by.erizol.calc.calcapp.ui.MainMvpView;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ScreenModule {

    private final AppCompatActivity activity;

    public ScreenModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return activity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerScreen
    MainMvpPresenter<MainMvpView> provideMainMvpPresenter(MainMvpPresenterImpl<MainMvpView> presenter) {
        return presenter;
    }
}
