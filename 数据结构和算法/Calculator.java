package com.stack;

import javax.management.RuntimeErrorException;

/**
 * 栈实现简单计算器（中缀）
 * @author 骄傲的大树
 *
 */
public class Calculator {

	public static void main(String[] args) {
		String str = "10-2*5+60";
		
		ArrayStack numStack = new ArrayStack(10);
		ArrayStack chStack = new ArrayStack(10);
		
		String keepNum = "";
		int index = 0;
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		char ch = ' ';	
		int res = 0;
		while(true){
			 ch = str.substring(index, index+1).charAt(0);
			 //判断是不是符号位
			if(isOper(ch)) {
				if(ch == '(') {
					//有（的优先级最低 
					chStack.push(ch);
				}else if(ch == ')') {
					while(true) {
						
						if(chStack.pip() == '(') {
							chStack.pop();
							break;
						}
						oper = (char) chStack.pop();
						num1 = numStack.pop();
						num2 = numStack.pop();
						res = numStack.Operation(num1, num2, oper);
						numStack.push(res);;
					}
				}else {
				//符号栈不为空
				if( !chStack.isEmpty()) {					
					//符号栈内的操作数比 当前符号位优先级高
					//数栈取出两个数进行运算
					while(true) {
						if( !chStack.isEmpty() && chStack.pripority(ch) <= chStack.pripority(chStack.pip()) && !numStack.isEmpty()) {
					
							num1 = numStack.pop();
							num2 = numStack.pop();
							oper = chStack.pop();
							res = numStack.Operation(num1, num2, oper);
							numStack.push(res);
						}else {
							break;
						}
					}
						chStack.push(ch);
//					}else {
//				//操作数比当前符号位优先级低
//					chStack.push(ch);
//				}
			}else{
				//当前栈为空
				chStack.push(ch);
			}
				}
		}else {
				keepNum += ch;
				if(index == str.length() -1) {
					numStack.push(Integer.parseInt(keepNum));
				}else if(isOper(str.substring(index+1,index+2).charAt(0))) {
					numStack.push(Integer.parseInt(keepNum));
					keepNum = "";
				}
				
			}
			index++;
			if(index >= str.length()) {
				break;
			}
		}
		
		//将栈内存在的数据进行运算
		while(true) {
			
			if(chStack.isEmpty()) {
				break;
			}
			oper = (char) chStack.pop();
			num1 = numStack.pop();
			num2 = numStack.pop();
			res = numStack.Operation(num1, num2, oper);
			numStack.push(res);;
		}
		
		numStack.listStack();
	}
	
	public static boolean isOper(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(' || ch == ')';
	}
}
class ArrayStack{
	private int MaxSize;
	private int top = -1;
	private int[] stack;
	
	ArrayStack(int MaxSize){
		this.MaxSize = MaxSize;
		this.stack = new int[MaxSize];
	}
	
	//判断符号优先级
	public int pripority(int pri) {
		if(pri == '*' || pri == '/') {
			return 1;
		}else if(pri == '+' || pri == '-') {
			return 0;
		}else {
			return -1;
		}
			
	}
	
	//根据符号进行运算
	public int Operation(int num1,int num2, int oper) {
		int result = 0;
		switch (oper) {
		case '*':
			result = num1 * num2;
			break;
		case '/':
			result = num2 / num1;
			break;
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num2 - num1;
			break;
		default:
			break;
		}
		return result;
	}
	
	//获取栈顶数据
	public int pip() {
		return stack[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == MaxSize;
	}
	//入栈
	public void push(int num) {
		if(isFull()) {
			System.out.println("Stack is full");
			return;
		}
		
		stack[++top] = num;
	}
	
	//出栈
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
			throw new RuntimeException("Stack is Empty");
		}
		
		return stack[top--];
	}
	
	public void listStack() {
		for(int i = top; i >= 0; i--) {
			System.out.println(stack[i]);
		}
	}
}
