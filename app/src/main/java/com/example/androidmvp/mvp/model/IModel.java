package com.example.androidmvp.mvp.model;

import com.example.androidmvp.base.IBaseModel;
import com.example.androidmvp.mvp.presenter.IPresenter;

/**
 * 数据模型接口 负责数据逻辑
 */
public interface IModel extends IBaseModel {

    default void setPresenter(IPresenter presenter) {}  // 持有 Presenter

    /**
     * 这些都是方法，都是由 Presenter 调用的
     */

    void onDataChanged(String data); // 监听文本变化，时时更新数据

    void submitFromData(); // 提交表单数据

    void clearData(); // 清空数据

}
