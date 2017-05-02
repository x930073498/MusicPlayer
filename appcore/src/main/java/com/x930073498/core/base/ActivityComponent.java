package com.x930073498.core.base;

import dagger.Component;

/**
 * Created by x930073498 on 17-5-2.
 */
@ActivityScope
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {
//    <ACTIVITY extends BaseActivity> void inject(ACTIVITY activity);
}
