package by.erizol.calc.calcapp.di.component;

import android.content.Context;

import javax.inject.Singleton;

import by.erizol.calc.calcapp.Calc;
import by.erizol.calc.calcapp.data.RepositoryManager;
import by.erizol.calc.calcapp.di.ApplicationContext;
import by.erizol.calc.calcapp.di.module.ApiModule;
import by.erizol.calc.calcapp.di.module.ApplicationModule;
import by.erizol.calc.calcapp.ui.MainActivity;
import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

    void inject(Calc application);

    @ApplicationContext
    Context context();

    RepositoryManager getRepositoryManager();

}

