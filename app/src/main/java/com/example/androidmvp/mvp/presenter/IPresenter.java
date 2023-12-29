package com.example.androidmvp.mvp.presenter;

import com.example.androidmvp.base.IBasePresenter;
import com.example.androidmvp.mvp.model.IModel;
import com.example.androidmvp.mvp.view.IView;

public interface IPresenter extends IBasePresenter {

    void setView(IView view);  // 持有 View

    void setModel(IModel model);  // 持有 Model


    void onDataChanged(String data); // 时时修改Model的数据，由View通知 Presenter

    void onDataChangedUpdateText(String data); // 修改View的TextView数据，由Model通知 Presenter


    void submitFromData(); // 执行Model的 提交表单服务，由View通知 Presenter


    void showSubmitFromLoading(String data); // 执行View的显示loading方法，由Model通知 Presenter

    void hideSubmitFromLoading(); // 执行View的隐藏loading方法，由Model通知 Presenter


    void clearData(); // 执行Model的 清空数据方法，由View通知 Presenter

    void clearTextData(); // 执行View的清空TextView内容方法，由Model通知 Presenter

}
