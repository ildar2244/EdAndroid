package com.axdar.edandroid.mock

import io.reactivex.Scheduler
import io.reactivex.observers.DisposableObserver

class OrderListPresenter(
    private val orderRepository: OrderRepository,
    private val workScheduler: Scheduler,
    private val resultScheduler: Scheduler,
) : BasePresenter<OrderListContract.View>(), OrderListContract.Presenter {

    override fun refresh() {
        getView()?.let { view ->
            view.showProgress()
            orderRepository.getOrders()
                .subscribeOn(workScheduler)
                .observeOn(resultScheduler)
                .subscribe(object : DisposableObserver<List<Order>>() {
                    override fun onNext(orders: List<Order>) {
                        getView()?.let { v ->
                            v.hideProgress()
                            v.showOrders(orders)
                        } ?: return
                    }

                    override fun onError(e: Throwable) {
                        getView()?.let { v ->
                            v.hideProgress()
                            v.showError(e.message.toString())
                        } ?: return
                    }

                    override fun onComplete() {

                    }

                })
        } ?: return
    }
}