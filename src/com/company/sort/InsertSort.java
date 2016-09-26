package com.company.sort;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/09/22
 * \* Time: 23:42
 * \* Description:
 * \
 */
public class InsertSort {

	private int[] list;

	public InsertSort(int[] list){
		this.list = list;
	}


	public void sort(){
		Integer size = list.length;
		if( size<= 1){
			return;
		}else{
			for(int right=1;right<size;right++){
				int temp = list[right];
				int emptyIndex = right;
				while ( emptyIndex >0 && list[emptyIndex-1] > temp){
					list[emptyIndex] = list[emptyIndex-1];
					emptyIndex --;
				}
				list[emptyIndex] = temp;

			}
		}
	}

	public void print(){
		for (int i : list) {
			System.out.print(i+" ");
		}
	}

	public static void main(String[] args) {
		int a[] =new int[]{6,2,3,8,1,4,9,5,7};
		InsertSort sort = new InsertSort(a);
		sort.sort();
		sort.print();
	}




}
