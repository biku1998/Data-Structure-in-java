
/*
Implementation of doubly linked list in java with generics , to store any type of data
author : Sourabh kumar.
*/
public class DbList<T> {
	T data;
	DbList<T> next;
	DbList<T> prev;
	DbList<T> head;
	DbList<T> tail;

	static String dataOfList;

	DbList<T> createNode(T data) {
		DbList<T> newNode = new DbList<T>();
		newNode.data = data;
		return newNode;
	}

	void createList(T data) {
		DbList<T> newNode = createNode(data);
		newNode.next = null;
		newNode.prev = null;
		head = newNode;
		tail = newNode;
	}

	void storeAtFirst(T data) {
		if (head == null) {
			createList(data);
			return;
		}
		DbList<T> newNode = createNode(data);
		newNode.next = head;
		newNode.prev = null;
		head.prev = newNode;
		head = newNode;
	}

	void storeAtLast(T data) {
		if (head == null) {
			createList(data);
			return;
		}

		DbList<T> newNode = createNode(data);
		tail.next = newNode;
		newNode.prev = tail;
		newNode.next = null;
		tail = newNode;

	}

	void removeAtFirst() {
		DbList<T> temp = head;
		head = temp.next;
		head.prev = null;
		temp = null;
	}

	void removeAtLast() {
		DbList<T> toDelete = tail;
		tail = toDelete.prev;
		tail.next = null;
		toDelete = null;
	}

	int firstIndex(T element) {
		DbList<T> ref = head;
		int index = 0;
		while (ref != null) {
			if (ref.data == element)
				return index;
			else
				index++;

			ref = ref.next;
		}

		return -1;
	}

	int lastIndex(T element) {
		int lIndex = -1;
		DbList<T> ref = head;

		for (int i = 0; i < sizeOfList(); i++) {
			if (ref.data == element) {
				lIndex = i;
				ref = ref.next;
			} else {
				ref = ref.next;
			}
		}

		return lIndex;
	}

	int sizeOfList() {
		int s = 0;
		DbList<T> ref = this.head;

		while (ref != null) {
			s++;
			ref = ref.next;
		}
		return s;
	}

	void printList() {
		DbList<T> ref = this.head;
		while (ref != null) {
			System.out.print("-" + ref.data);
			dataOfList = dataOfList + " " + String.valueOf(ref.data);
			ref = ref.next;
		}
	}

	void printListReverse() {
		DbList<T> ref = this.tail;
		while (ref != null) {
			System.out.print("-" + ref.data);
			dataOfList = dataOfList + " " + String.valueOf(ref.data);
			ref = ref.prev;
		}
	}

	void remove(T elementToDelete) {

		int i = firstIndex(elementToDelete);

		remove(i);

	}

	void remove(int index) {
		if (index == 0) {
			removeAtFirst();
			return;
		}
		if (index == sizeOfList() - 1) {
			removeAtLast();
			return;
		}
		DbList<T> current = head;
		DbList<T> pre = null;

		for (int i = 0; i < index; i++) {
			pre = current;
			current = current.next;
		}

		pre.next = current.next;
		current.next.prev = pre;
		current = null;
	}

	void dataForToString(DbList<T> ref) {

		while (ref != null) {

			dataOfList = dataOfList + " " + String.valueOf(ref.data);
			ref = ref.next;
		}
	}

	T getElement(int index) {
		DbList<T> ref = head;

		for (int i = 0; i < sizeOfList(); i++) {
			if (i == index) {
				return ref.data;
			} else {
				ref = ref.next;
			}
		}
		return null;
	}

	@Override
	public String toString() {

		dataForToString(head);
		String[] data = dataOfList.split(" ");
		String d = "[";
		for (int i = 0; i < data.length; i++) {
			if (i != 0) {
				if (i == data.length - 1) {
					d = d + data[i] + "";
				} else {
					d = d + data[i] + "," + " ";
				}
			}
		}
		d = d.concat("]");
		dataOfList = null;
		return d;
	}

}
