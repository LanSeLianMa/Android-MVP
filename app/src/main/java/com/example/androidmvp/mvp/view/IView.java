package com.example.androidmvp.mvp.view;

import com.example.androidmvp.base.IBaseView;
import com.example.androidmvp.mvp.presenter.IPresenter;

/**
 * 视图接口 负责视图逻辑
 */
public interface IView extends IBaseView {

    default void setPresenter(IPresenter presenter) {} // 持有 Presenter

    /**
     * 这些都是方法，都是由 Presenter 调用的
     */

    void onDataChangedUpdateText(String data); // 根据时时数据更新TextView

    void showSubmitFromLoading(String data); // 显示提交表单loading

    void hideSubmitFromLoading(); // 隐藏提交表单loading

    void clearFromData(); // 清空EditText数据

}
