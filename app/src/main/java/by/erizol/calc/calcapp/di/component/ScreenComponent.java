package by.erizol.calc.calcapp.di.component;

import by.erizol.calc.calcapp.di.PerScreen;
import by.erizol.calc.calcapp.di.module.ScreenModule;
import by.erizol.calc.calcapp.ui.Start_screen.StartActivity;
import by.erizol.calc.calcapp.ui.calc_page.MainActivity;
import dagger.Component;

@PerScreen
@Component(modules = ScreenModule.class, dependencies = ApplicationComponent.class)
public interface ScreenComponent {

    void inject(MainActivity activity);

    void inject(StartActivity activity);

}
