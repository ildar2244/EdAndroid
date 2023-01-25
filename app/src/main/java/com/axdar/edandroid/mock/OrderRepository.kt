package com.axdar.edandroid.mock

import io.reactivex.Observable

interface OrderRepository {

    fun getOrders(): Observable<List<Order>>
}