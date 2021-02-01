package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insert(T element) {
		if (element != null) {

			if (this.isEmpty()) {
				DoubleLinkedListNode<T> auxNode = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<T>(),
						new DoubleLinkedListNode<T>());
				this.setHead(auxNode);
				this.setLast(auxNode);

			} else {
				DoubleLinkedListNode<T> auxNode = new DoubleLinkedListNode<>();
				if (this.getHead() instanceof DoubleLinkedListNode<?>) {
					auxNode = (DoubleLinkedListNode<T>) this.getHead();
				}

				while (!auxNode.getNext().isNIL()) {

					if (auxNode.getNext() instanceof DoubleLinkedListNode<?>) {

						auxNode = (DoubleLinkedListNode<T>) auxNode.getNext();

					}
				}
				auxNode.setNext(new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(), auxNode));

				if (auxNode.getNext() instanceof DoubleLinkedListNode<?>) {
					this.setLast((DoubleLinkedListNode<T>) auxNode.getNext());
				}

			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>();

			newHead.setData(element);
			newHead.setNext(this.getHead());
			newHead.setPrevious(new DoubleLinkedListNode<>());

			((DoubleLinkedListNode<T>) this.head).setPrevious(newHead);

			if (this.head.isNIL()) {
				this.setLast(newHead);
			}

			this.setHead(newHead);

		}

	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (!this.isEmpty()) {
				
				if (this.size() == 1) {
					
					this.setLast(new DoubleLinkedListNode<T>());
					this.setHead(this.getLast());
				}
				else if (this.getHead().getData().equals(element))
					removeFirst();
				else if (this.getLast().getData().equals(element))
					removeLast();
				else {
					
					DoubleLinkedListNode<T> auxNode = new DoubleLinkedListNode<>();
					if (this.getHead() instanceof DoubleLinkedListNode<?>) {
						auxNode = (DoubleLinkedListNode<T>) this.getHead();
					}
					while (!auxNode.isNIL() && !auxNode.getData().equals(element)) {
						auxNode = (DoubleLinkedListNode<T>) auxNode.getNext();
					}
					if (!auxNode.isNIL()) {
						auxNode.getPrevious().setNext(auxNode.getNext());
						((DoubleLinkedListNode<T>) auxNode.getNext()).setPrevious(auxNode.getPrevious());
					}
				}

			}

		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			this.setHead(this.getHead().getNext());

			if (this.getHead().isNIL()) {
				setLast((DoubleLinkedListNode<T>) this.getHead());
			}

			if (this.getHead() instanceof DoubleLinkedListNode<?>) {
				((DoubleLinkedListNode<T>) this.head).setPrevious(new DoubleLinkedListNode<>());
			}

		}

	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {

			if (this.size() == 1) {

				this.setLast(new DoubleLinkedListNode<T>()); 
				this.setHead(this.getLast());

			} else {

				this.getLast().getPrevious().setNext(new DoubleLinkedListNode<T>());
				this.setLast(this.getLast().getPrevious());
			}
		}

	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
