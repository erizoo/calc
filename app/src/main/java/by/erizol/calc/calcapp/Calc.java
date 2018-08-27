package by.erizol.calc.calcapp;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Typeface;

import by.erizol.calc.calcapp.di.component.ApplicationComponent;
import by.erizol.calc.calcapp.di.component.DaggerApplicationComponent;
import by.erizol.calc.calcapp.di.module.ApplicationModule;


public class Calc  extends Application {


    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
