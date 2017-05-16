package com.x930073498.core.mvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.x930073498.appcore.BR;

/**
 * Created by x930073498 on 17-5-3.
 */

public class IVM<V extends IView, M extends IData> extends BaseObservable {
    protected V view;
    protected M data;

    public IVM(V view, M data) {
        this.view = view;
        this.data = data;
    }

    public IVM(V view) {
        this.view = view;
    }

    public IVM() {

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

    public void onCreate() {

    }

    public void onDestroy() {

    }
}
