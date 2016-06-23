package com.zyp.gank.dagger.components;


import com.zyp.gank.MainActivity;
import com.zyp.gank.dagger.PerActivity;
import com.zyp.gank.dagger.modules.ActivityModule;
import com.zyp.gank.dagger.modules.MainModule;

import dagger.Component;

/**
 * A scope {@link PerActivity} component.
 * Injects user specific Fragments.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = {ActivityModule.class, MainModule.class})
public interface MainComponent extends ActivityComponent {
    //void inject(MainActivity mainActivity);
}
