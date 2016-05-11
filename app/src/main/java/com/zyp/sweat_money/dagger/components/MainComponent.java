package com.zyp.sweat_money.dagger.components;


import com.zyp.sweat_money.MainActivity;
import com.zyp.sweat_money.dagger.PerActivity;
import com.zyp.sweat_money.dagger.modules.ActivityModule;
import com.zyp.sweat_money.dagger.modules.MainModule;

import dagger.Component;

/**
 * A scope {@link PerActivity} component.
 * Injects user specific Fragments.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = {ActivityModule.class, MainModule.class})
public interface MainComponent extends ActivityComponent {
    void inject(MainActivity mainActivity);
}
