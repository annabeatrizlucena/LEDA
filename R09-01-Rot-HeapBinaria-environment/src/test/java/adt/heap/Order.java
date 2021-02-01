package adt.heap;

import static org.junit.Assert.*;

import org.junit.Test;

import orderStatistic.OrderStatisticsHeapImpl;

public class Order {
	OrderStatisticsHeapImpl<Integer> order = new OrderStatisticsHeapImpl<Integer>();

	
	Integer[] array = {5, 2, 9};
	Integer[] array2 = {5, 2, 9, 0};
	Integer[] array3 = {};
	
	
	@Test
	public void test() {
		assertEquals(order.getOrderStatistics(array, 3), new Integer(9));
		
		
		assertEquals(order.getOrderStatistics(array2, 1), new Integer(0));
		assertEquals(order.getOrderStatistics(array2, 4), new Integer(9));
		assertEquals(order.getOrderStatistics(array2, 3), new Integer(5));
		
		assertNull(order.getOrderStatistics(array, -2));
		assertNull(order.getOrderStatistics(array, -100));
		assertNull(order.getOrderStatistics(array, 4));
		assertNull(order.getOrderStatistics(array, 0));
		assertNull(order.getOrderStatistics(array3, -1));
	}

}
