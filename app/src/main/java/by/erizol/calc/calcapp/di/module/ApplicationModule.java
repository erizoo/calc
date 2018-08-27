package by.erizol.calc.calcapp.di.module;
import android.content.Context;

import by.erizol.calc.calcapp.Calc;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Calc application;

    public ApplicationModule(Calc application) {
        this.application = application;
    }

    @Provides
    Context provideContext() {
        return application;
    }

    @Provides
    Calc provideApplication() {
        return application;
    }

}

