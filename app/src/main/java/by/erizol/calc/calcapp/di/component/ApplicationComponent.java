package by.erizol.calc.calcapp.di.component;

import android.content.Context;

import javax.inject.Singleton;

import by.erizol.calc.calcapp.Calc;
import by.erizol.calc.calcapp.di.ApplicationContext;
import by.erizol.calc.calcapp.di.PerScreen;
import by.erizol.calc.calcapp.di.module.ApplicationModule;
import dagger.Component;
import dagger.Provides;

@PerScreen
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(Calc application);

    Context context();

}
