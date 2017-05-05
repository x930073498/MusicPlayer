package com.x930073498.MusicPlayer.screen.viewModel;

import com.x930073498.MusicPlayer.screen.model.SecondModel;
import com.x930073498.MusicPlayer.screen.view.SecondView;
import com.x930073498.core.mvvm.IVM;

/**
 * Created by x930073498 on 17-5-5.
 */

public class SecondViewModel extends IVM<SecondView, SecondModel> {

    public SecondViewModel(SecondView view, SecondModel data) {
        super(view, data);
    }

    public SecondViewModel(SecondView view) {
        super(view);
    }

    public SecondViewModel() {
    }

    public void setResult() {
        view.setResultAndFinish();
    }
}
