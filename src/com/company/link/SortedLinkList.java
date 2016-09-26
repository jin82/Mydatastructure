package com.company.link;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/09/26
 * \* Time: 21:25
 * \* Description:
 * \
 */
public class SortedLinkList extends LinkList{


	public SortedLinkList() {

	}


	private int length;
	public SortedLinkList(int[] arr){
		this.length = arr.length;
		for (int i : arr) {
			insertFirst(i,i);
		}
	}

	@Override
	public void insertFirst(int key, int data) {
		Node newNode = new Node(key,data);
		if(first == null){
			first = newNode;
			return;
		}
		Node next = first;
		Node prev = first;
		while(next!=null && next.key > key){
			prev = next;
			next = next.next;
		}
		if(next != null){
			if(next == prev){
				newNode.next = first;
				first = newNode;
				return;
			}else{
				newNode.next = next;
			}
		}

		prev.next = newNode;
	}


	@Override
	public void insertLast(int key, int data) {
		this.insertFirst(key,data);
	}

	public int[] toArray(){
		int toArr[] = new int[length];
		Node node = first;
		int i = 0;
		while (node!=null){
			toArr[i++] = node.item;
			node = node.next;
		}
		return toArr;
	}

	public static void main(String[] args) {
		SortedLinkList list = new SortedLinkList();
		list.insertFirst(5,5);
		list.insertFirst(3,3);
		list.insertFirst(7,7);
		list.insertFirst(4,4);
		list.insertFirst(2,2);
		list.insertFirst(6,6);

		list.showList();

		int[] a = new int[]{2,3,4,2,5,6,7,5,43,45,23,12,43,54};
		SortedLinkList list2 = new SortedLinkList(a);

		list2.showList();

		int[] b = list2.toArray();
		for (int i : b) {
			System.out.print(i+" ");
		}
	}
}
