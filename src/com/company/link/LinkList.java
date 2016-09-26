package com.company.link;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/09/26
 * \* Time: 14:43
 * \* Description:
 * \
 */
public class LinkList {

	protected class Node{
		protected int item;
		protected int key;
		protected Node next;

		public Node(int key,int item){
			this.key = key;
			this.item = item;
		}

		@Override
		public String toString() {
			return new StringBuilder("[ key -> ").append(key).append(" ,value ->").append(item).append(" ]").toString();
		}
	}

	protected Node first;

	protected Node last;

	public LinkList(){}

	public LinkList(int key,int data){
		first = new Node(key,data);
		last = first;
	}

	public void insertFirst(int key,int data){
		Node newNode = new Node(key,data);
		newNode.next = first;
		first = newNode;
		if(last == null){
			last = first;
		}
	}

	public void insertLast(int key,int data){
		Node newNode = new Node(key, data);
		last.next = newNode;
		last = newNode;
	}

	public int deleteFirst(){
		Node node = first;
		first = first.next;
		return node.item;
	}

	public void showList(){
		Node item = first;
		System.out.println("=======list=======");
		while (item != null){
			System.out.println(item.item);
			item = item.next;
		}
		System.out.println("=======list=======");
	}

	protected Node findNode(int key){
		Node node = first;
		while (node.key != key) {
			node = node.next;
		}
		return node;
	}

	public int get(int key){

		return findNode(key).item;
	}

	public int delete(int key){
		Node next = first;
		Node pre = first;
		while (next != null && next.key != key ){
			pre = next;
			next = next.next;
		}
		if(next == null){
			return -1;
		}else{
			int result = next.item;
			if(next.key == pre.key){
				first = next.next;
			}else{
				pre.next = next.next;
				if(pre.next == null){
					last = pre;
				}
			}
			return result;
		}
	}


	public static void main(String[] args) {
		LinkList list = new LinkList();
		list.insertFirst(1,1);
		list.insertFirst(2,2);
		list.insertFirst(3,3);
		list.insertFirst(4,4);
		list.insertFirst(5,5);
		list.insertFirst(6,6);
		list.insertFirst(7,7);
		list.insertFirst(8,8);
		list.insertFirst(9,9);
		list.insertFirst(10,10);
//		for(int i = 0;i<10;i++){
//			list.showList();
//			int item = list.deleteFirst();
//			System.out.printf("deleted item %d %n",item);
//		}

		System.out.println(list.get(5));
		//list.delete(5);
		list.delete(10);
		list.showList();
		list.delete(1);
		list.showList();
		list.delete(3);
		list.showList();

		list.insertLast(50, 50);
		list.insertLast(50, 50);
		list.insertLast(50, 50);
		list.delete(50);
		list.delete(2);
		list.showList();
	}

}
