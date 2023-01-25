package com.axdar.edandroid.mock

open class BasePresenter<V> {

    private var view: V? = null

    fun attachView(view: V) {
        this.view = view
    }

    fun getView(): V? = view

    fun detachView() {
        view = null
    }
}