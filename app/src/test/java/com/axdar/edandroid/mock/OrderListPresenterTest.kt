package com.axdar.edandroid.mock

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.anyString
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.never
import org.mockito.kotlin.verify
import java.util.*

@RunWith(MockitoJUnitRunner::class)
internal class OrderListPresenterTest {

    private lateinit var presenter: OrderListPresenter

    @Mock
    private lateinit var mockOrderRepository: OrderRepository

    @Mock
    private lateinit var mockView: OrderListContract.View

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = OrderListPresenter(
            mockOrderRepository,
            Schedulers.trampoline(),
            Schedulers.trampoline(),
        )
        presenter.attachView(mockView)
    }

    private fun getFakeOrderList(): List<Order> {
        val orders: MutableList<Order> = LinkedList()
        orders.add(Order(1, 100.0, "Order 1"))
        orders.add(Order(2, 200.0, "Order 2"))
        return orders
    }

    @Test
    fun refreshSuccess() {
        val fakeOrders = getFakeOrderList()
        `when`(mockOrderRepository.getOrders()).thenReturn(Observable.just(fakeOrders))

        presenter.refresh()

        verify(mockView).showProgress()
        verify(mockView).hideProgress()
        verify(mockView).showOrders(fakeOrders)
        verify(mockView, never()).showError(anyString())
    }

    @Test
    fun refreshFailed() {
        val error: String = "Network error"
        `when`(mockOrderRepository.getOrders()).thenReturn(Observable.error(Exception(error)))

        presenter.refresh()

        verify(mockView).showProgress()
        verify(mockView).hideProgress()
        verify(mockView).showError(error)
        verify(mockView, never()).showOrders(ArgumentMatchers.anyList())
    }

    @Test
    fun refreshWithoutView() {
        presenter.detachView()
        presenter.refresh()

        verify(mockOrderRepository, never()).getOrders()
        verify(mockView, never()).showProgress()
        verify(mockView, never()).showOrders(ArgumentMatchers.anyList())
    }
}