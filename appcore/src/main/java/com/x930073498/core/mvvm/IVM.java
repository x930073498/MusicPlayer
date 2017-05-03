package com.x930073498.core.mvvm;

import javax.inject.Inject;

/**
 * Created by x930073498 on 17-5-3.
 */

public  class IVM<V extends IVeiw, M extends IData> {
    private V view;
    private M data;

    public IVM(V view, M data) {
        this.view = view;
        this.data = data;
    }

    @Inject
    public IVM(V view) {
        this.view = view;
    }

    public IVM() {

    }

    public void setData(M data) {
        this.data = data;
    }

    public void setView(V view) {
        this.view = view;
    }
}
