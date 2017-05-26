package com.x930073498.MusicPlayer.core.mvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;

import com.hwangjr.rxbus.RxBus;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.x930073498.appcore.BR;

/**
 * Created by x930073498 on 17-5-3.
 */

public class IVM<V extends IView, M extends IData> extends BaseObservable {
    protected V view;
    protected M data;
    protected LifecycleProvider<ActivityEvent> lifecycleProvider;


    public IVM(V view, M data, @NonNull LifecycleProvider<ActivityEvent> lifecycleProvider) {
        this.view = view;
        this.data = data;
        this.lifecycleProvider = lifecycleProvider;
        if (useRxBus()) RxBus.get().register(this);
    }

    protected boolean useRxBus() {
        return false;
    }


    public void setData(M data) {
        this.data = data;
        notifyPropertyChanged(BR.data);
    }

    @Bindable
    public M getData() {
        return data;
    }

    @Bindable
    public V getView() {
        return view;
    }

    public void setView(V view) {
        this.view = view;
        notifyPropertyChanged(BR.view);
    }

    public void destroy() {
        RxBus.get().unregister(this);
    }

}
