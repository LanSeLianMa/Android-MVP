package com.example.androidmvp.base;

/**
 * Base 代理接口 负责业务逻辑
 */
public interface IBasePresenter {

    // 写一些，公用或者通用的方法，用于扩展

    default void removeHandlerMsgAndCallback() {} // 删除handler 回调和消息

}
