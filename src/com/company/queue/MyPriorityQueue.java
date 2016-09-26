package com.company.queue;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/09/23
 * \* Time: 19:11
 * \* Description:
 * \
 */
public class MyPriorityQueue {

	private int maxSize;
	private int[] queue;
	private int size;

	public MyPriorityQueue(int legth){
		maxSize = legth;
		queue = new int[legth];
		size = 0;
	}

	public void insert(int e){
		if(size == 0){
			queue[0] = e;
		}else{
			int index = size ;
			while(index > 0 && queue[index - 1] > e){
				queue[index] = queue[index - 1];
				index --;
			}
			queue[index] = e;
		}
		size ++;
	}

	public int remove(){
		return queue[--size];
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public boolean isFull(){
		return size == maxSize;
	}

	public static void main(String[] args) {
		MyPriorityQueue queue = new MyPriorityQueue(5);
		queue.insert(5);
		queue.insert(2);
		queue.insert(10);
		queue.insert(7);
		queue.insert(3);
		queue.remove();
		queue.insert(3);
	}

}
