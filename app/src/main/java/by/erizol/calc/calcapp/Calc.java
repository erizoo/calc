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

    private static Context context;

    public Typeface open_sans;
    public Typeface open_sans_bold;
    public Typeface open_sans_semibold;
    public Typeface san_francisco_display_bold;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        applicationComponent.inject(this);

        context = this;

        open_sans = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/open_sans.ttf");
        open_sans_bold = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/open_sans_bold.ttf");
        open_sans_semibold = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/open_sans_semibold.ttf");
        san_francisco_display_bold = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/SanFranciscoDisplay_Bold.ttf");
    }

    public static Context getContext() {
        return context;
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
