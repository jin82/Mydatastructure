package com.company.queue;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/09/23
 * \* Time: 15:21
 * \* Description:
 * \
 */
public class MyQueue {

	private int[] queue;

	private int front;

	private int rear;

	private int size;

	public MyQueue(int size){
		queue = new int[size];
		this.size = 0;
		front = 0;
		rear = -1;
	}

	public void add(int e){
		if (!isFull()) {
			if(rear == queue.length - 1){
				rear = -1;
			}
			queue[++rear] = e;
			size ++;
		}else{
			System.out.println("is full");
		}
	}

	public int remove(){
		if(isEmpty()){
			System.out.println("is empty");
			throw new RuntimeException();
		}else{
			int removed = queue[front++];
			if(front == queue.length){
				front = 0;
			}
			size --;
			return removed;
		}
	}

	public int frontPeek(){
		return queue[front];
	}

	public int rearPeek(){
		return queue[rear];
	}

	public boolean isFull(){
		return size == queue.length;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public int size(){
		return size;
	}

	public static void main(String[] args) {
		MyQueue queue = new MyQueue(5);
		queue.add(2);
		System.out.printf("front : %d  rear : %d%n",queue.frontPeek(),queue.rearPeek());
		queue.add(4);
		System.out.printf("front : %d  rear : %d%n",queue.frontPeek(),queue.rearPeek());
		queue.add(3);
		System.out.printf("front : %d  rear : %d%n",queue.frontPeek(),queue.rearPeek());
		queue.add(5);
		System.out.printf("front : %d  rear : %d%n",queue.frontPeek(),queue.rearPeek());
		queue.add(1);
		System.out.printf("front : %d  rear : %d%n",queue.frontPeek(),queue.rearPeek());
		queue.add(10);
		for (int i = 0; i < 5; i++) {
			System.out.printf("front : %d  rear : %d,remove : %d %n",queue.frontPeek(),queue.rearPeek(),queue.remove());
		}


	}

}
