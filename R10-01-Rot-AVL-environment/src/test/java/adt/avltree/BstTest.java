package adt.avltree;

import static org.junit.Assert.*;

import org.junit.Test;

import adt.bst.BSTImpl;
import adt.bst.BSTVerifierImpl;

public class BstTest {

	private Integer[] array = { 1, 6, 8, 9, 10, 13, 35, 76, 89 };
	private Integer[] array2 = {};
	private Integer[] array3 = {100};
	private BSTImpl<Integer> tree = new BSTImpl<>();
	private BSTImpl<Integer> tree2 = new BSTImpl<>();
	private BSTImpl<Integer> tree3 = new BSTImpl<>();
	@Test
	public void test() {
		for (Integer element : array) {
			tree.insert(element);
		}
		BSTVerifierImpl<Integer> bstV = new BSTVerifierImpl<>(tree);
		assertTrue(bstV.isBST());

	}
	
	@Test
	public void test2() {
		for (Integer element : array2) {
			tree2.insert(element);
		}
		BSTVerifierImpl<Integer> bstV = new BSTVerifierImpl<>(tree2);
		assertTrue(bstV.isBST());
		
	}
	
	@Test
	public void test3() {
		for (Integer element : array3) {
			tree3.insert(element);
		}
		BSTVerifierImpl<Integer> bstV = new BSTVerifierImpl<>(tree3);
		assertTrue(bstV.isBST());
		
	}

}

// BSTVerifierImpl<Integer> bst = new BSTVerifierImpl(tree);

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
//
//}
