package com.company.Array;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/09/22
 * \* Time: 15:22
 * \* Description:
 * \
 */
public class MyOrderedArray {

	private int[] data;

	private int size ;

	public MyOrderedArray(int size){
		data = new int[size];
		this.size = 0;
	}

	public void insert(int e){
		if(size == 0){
			data[0] = e;
		}else{
			for (int i = 0; i < size; i++) {
				if(data[i] >= e){
					System.arraycopy(data,i,data,i+1,size - i);
					data[i] = e;
					break;
				}else if(i==size-1){
					data[size] = e;
					break;
				}
			}
		}

		size ++;
	}

	public void delete(int e){
		while (true) {
			int value = find(e);
			if(value == -1){
				return;
			}else{
				System.arraycopy(data,value+1,data,value,size - value -1);
				data[size - 1] =0;
				size -- ;
			}
		}
	}

	public int find(int e){
		int upper = size - 1;
		int lower = 0;

		while (true){
			if(lower >= upper){
				return -1;
			}
			int middle = (upper + lower) / 2;
			int catchOne = data[middle];
			if(catchOne == e){
				return middle;
			}else{
				if(e > catchOne){
					lower = middle + 1 ;
				}else{
					upper = middle - 1 ;
				}
			}
		}

	}

	public static void main(String[] args) {


		MyOrderedArray array = new MyOrderedArray(40);
		array.insert(5);
		array.insert(10);
		array.insert(3);
		array.insert(0);
		array.insert(5);
		array.insert(7);
		array.insert(44);
		array.insert(20);
		array.insert(11);
		array.insert(0);
		array.insert(7);
		array.insert(5);
		array.insert(5);

		array.find(10);

		array.find(5);

		array.find(44);
		array.find(3);
		array.find(2);

		array.delete(5);

		int c[] =new int[]{1,2};
		int d = 0;
		int e = 0;
		System.out.println(c[d++]);
		System.out.println(c[++e]);
		System.out.println(d+","+e);
	}



}
