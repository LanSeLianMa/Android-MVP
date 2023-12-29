package com.example.androidmvp.mvp.presenter;

import com.example.androidmvp.mvp.model.IModel;
import com.example.androidmvp.mvp.view.IView;

/**
 * 具体业务逻辑实现
 */
public class IPresenterImp implements IPresenter {

    private IView view;
    private IModel model;

    @Override
    public void setView(IView view) {
        this.view = view;
    }

    @Override
    public void removeHandlerMsgAndCallback() {
        model.removeHandlerMsgAndCallback();
    }

    @Override
    public void setModel(IModel model) {
        this.model = model;
    }

    @Override
    public void onDataChanged(String data) {
        model.onDataChanged(data);
    }

    @Override
    public void onDataChangedUpdateText(String data) {
        view.onDataChangedUpdateText(data);
    }

    @Override
    public void submitFromData() {
        model.submitFromData();
    }

    @Override
    public void showSubmitFromLoading(String data) {
        view.showSubmitFromLoading(data);
    }

    @Override
    public void hideSubmitFromLoading() {
        view.hideSubmitFromLoading();
    }

    @Override
    public void clearData() {
        model.clearData();
    }

    @Override
    public void clearTextData() {
        view.clearFromData();
    }

}
