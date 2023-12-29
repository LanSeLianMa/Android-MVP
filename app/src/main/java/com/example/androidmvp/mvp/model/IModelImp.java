package com.example.androidmvp.mvp.model;

import android.os.Handler;

import com.example.androidmvp.mvp.presenter.IPresenter;

/**
 * 数据模型逻辑 具体实现
 */
public class IModelImp implements IModel {

    private String mData = "";
    private IPresenter presenter;
    private Handler handler = new Handler();

    @Override
    public void setPresenter(IPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onDataChanged(String data) {
        mData = data;
        presenter.onDataChangedUpdateText(mData);
    }

    @Override
    public void removeHandlerMsgAndCallback() {
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    public void submitFromData() {
        presenter.showSubmitFromLoading(mData);
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.hideSubmitFromLoading();
            }
        }, 1500);
    }

    @Override
    public void clearData() {
        mData = "";
        presenter.clearTextData();
    }
}
