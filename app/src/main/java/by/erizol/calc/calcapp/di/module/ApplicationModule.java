package by.erizol.calc.calcapp.di.module;

import android.content.Context;

import javax.inject.Singleton;

import by.erizol.calc.calcapp.Calc;
import by.erizol.calc.calcapp.data.RepositoryManager;
import by.erizol.calc.calcapp.data.RepositoryManagerImpl;
import by.erizol.calc.calcapp.di.ApplicationContext;
import dagger.Module;
import dagger.Provides;

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

    @Provides
    @Singleton
    RepositoryManager provideRepositoryManager(RepositoryManagerImpl repositoryManager) {
        return repositoryManager;
    }
}

