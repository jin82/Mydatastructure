package com.company.stack;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/09/23
 * \* Time: 10:26
 * \* Description:
 * \
 */
public class ArrayStack {

	private char[] stack;

	private int maxSize;

	private int top;

	private char[] leftBracket = {'(','{','['};

	private char[] rightBracket = {')','}',']'};

	public ArrayStack(int size){
		this.stack = new char[size];
		this.maxSize = size;
		this.top = -1;
	}

	public void push(char e){
		if(!isFull()){
			stack[++top] = e;
		}else{
			throw new RuntimeException("is full");
		}
	}

	public char pop(){
		if(!isEmpty()){
			return stack[top--];
		}else{
			throw new RuntimeException("is empty");
		}
	}

	public int peek(){
		if(!isEmpty()){
			return stack[top];
		}else{
			throw new RuntimeException("is empty");
		}
	}

	public boolean isEmpty(){
		return top == -1;
	}

	public boolean isFull(){
		return top == maxSize-1;
	}

	public static boolean testBracket(String str){
		ArrayStack stack = new ArrayStack(str.length());
		try {
			for (char c : str.toCharArray()) {
				int type = stack.contain(c);
				if (type == 1) {
					stack.push(c);
				} else if (type == 2) {
					char leftBracket = stack.pop();
					if (c - leftBracket > 2) {
						return false;
					}
				}
			}
		}catch (Exception e){
			return false;
		}
		return stack.isEmpty();
	}



	private int contain(char c){
		for (char c1 : leftBracket) {
			if(c1 == c){
				return 1;
			}
		}

		for (char c1 : rightBracket) {
			if(c1 == c){
				return 2;
			}
		}
		return 0;
	}




	public static void main(String[] args) {
		String test1 = "{1*(2+3)}+2";
		String test2 = "{{1*(2+3})))+2";
		String test3 = ")1*(2+3})+2)";

		System.out.println(ArrayStack.testBracket(test1));
		System.out.println(ArrayStack.testBracket(test2));
		System.out.println(ArrayStack.testBracket(test3));

		System.out.println(new ArrayStack(5));
	}

	public void test(String str){
		char source[] = str.toCharArray();
		ArrayStack stack = new ArrayStack(source.length);
		for (char c : source) {
			stack.push(c);
		}

		for (char c : stack.leftBracket) {
			System.out.println((int)c);
		}
		for (char c : stack.rightBracket) {
			System.out.println((int)c);
		}

	}

}

