package com.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式（后缀表达式）
 * 中缀表达式  1 + 2 * 6 -8
后缀表达式 1 2 6 * + 8 -

中缀表达式  1 + （（2 + 3） * 4） - 5 
后缀表达式 1 2 3 + 4 * + 5 -
 * @author 骄傲的大树
 *
 */
public class PolenNotation {

	public static void main(String[] args) {
		String expression = "1+((2+3)*4)-5";
		List<String > ls = toInfixExpression(expression);
		System.out.println(ls.toString());
		List<String > list = getlaterExpression(ls);
		System.out.println(list.toString());
		int result = getResult(list);
		System.out.println(result);
	}
	
	//将前缀表达式转换成后缀表达式
	public static List<String> getlaterExpression(List<String> ls){
		
		Stack<String> s1 = new Stack<String>(); //符号栈
		List<String> s2 = new ArrayList<String>();  //中间结果
		//遍历ls
		for(String item : ls) {
			if(item.matches("\\d+")) {
				s2.add(item);
			}else if(item.equals("(")) {
				s1.push(item);
			}else if(item.equals(")")){
				while(!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop(); //将 （ 出栈
			}else {
				//比较优先级
				while(s1.size() != 0 &&pripority(s1.peek()) >= pripority(item)) {
					s2.add(s1.pop());
				}
				s1.push(item);
			}
		}
		
		//将s1中剩余的运算符依次压入s2中
		while(s1.size() !=0) {
			s2.add(s1.pop());
		}
		return s2;
	}
	
	//返回运算符优先级
	public static int pripority(String operation) {
		int result = 0;
				switch (operation) {
				case "+":
				case "-":
					result = 1;
					break;
				case "*":
				case "/":
					result = 2;
					break;
				default:
					result = 0;
					break;
				};
		return result;
	}
	//将中缀表达式转成对应的list
	public static List<String> toInfixExpression(String s){
		List<String> ls = new ArrayList<String>();
		int i = 0;
		String str;
		char c;
		do {
			if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
				ls.add("" + c);
				i++;
			}else {
				str = "";
				while(i < s.length() && (c =s.charAt(i)) >=48 && (c=s.charAt(i)) <= 57) {
					str += c;
					i++;
				}
				ls.add(str);
			}
		}while(i < s.length());
		System.out.println(ls.toString());
		return ls;
	}
	
	public static int getResult(List<String> list) {
		int result = 0;
		int num1 = 0;
		int num2 = 0;
		Stack<String> stack = new Stack<String>();
		for(String str : list) {
			//正则表达式
			if(str.matches("\\d+")) {
				stack.push(str);
			}else {
				num1 = Integer.parseInt(stack.pop());
				num2 = Integer.parseInt(stack.pop());
				switch (str) {
				case "+":
					result = num1 + num2;
					break;
				case "*":
					result = num1 * num2;
					break;
				case "-":
					result = num2 - num1;
					break;
				case "/":
					result = num2 + num1;
					break;
				default:
					break;
				}
				stack.push("" + result);
			}
		}
		return Integer.parseInt(stack.pop());
	}
	public static List<String> getListExpression(String expression) {
		List<String> list = new ArrayList<String>();
		String[] str = expression.split(" ");
		for(String s : str) {
			list.add(s);
		}
		return list;
	}
}
