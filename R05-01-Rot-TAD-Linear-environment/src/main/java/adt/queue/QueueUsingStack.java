package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(this.isFull()) {
			throw new QueueOverflowException();
		}
		try {
			if(element != null) {
				this.stack1.push(element);
			}
			
		}catch(StackOverflowException s) {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T element = null;
		if(this.isEmpty()) {
			throw new QueueUnderflowException();
		}
		try {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			element = this.stack2.pop();
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
			
		}catch(StackUnderflowException e1) {
			throw new QueueUnderflowException();
			
		}catch(StackOverflowException e2) {
			
		}
		return element;
	}

	@Override
	public T head() {
		T headElement = null;
		try {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			headElement = this.stack2.top();
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
			
		}catch(StackUnderflowException e1) {
			
		}catch(StackOverflowException e2) {
			
		}
		return headElement;
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
	return this.stack1.isFull();
	}

}
