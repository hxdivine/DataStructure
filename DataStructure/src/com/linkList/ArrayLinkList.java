package com.linkList;

import java.util.Stack;

public class ArrayLinkList {

	public static void main(String[] args) {
		
		HeroDemo hero1 = new HeroDemo(1 ,"张扬");
		HeroDemo hero2 = new HeroDemo(2 ,"王汝华");
		HeroDemo hero3 = new HeroDemo(3 ,"五舅");
		HeroDemo hero4 = new HeroDemo(4 ,"四伯");
		
		ArrayLink list = new ArrayLink();
		
		list.addList(hero1);
		list.addList(hero4);
		list.addList(hero3);
		list.addList(hero2);
		list.list();
		
		System.out.println("--------find last index--------");
		System.out.println(list.findBylastIndex(list.getLeng(), 5));
		
		System.out.println("--------length--------");
		System.out.println(list.getLeng());
		
		System.out.println("--------lastprint--------");
		list.lastPrint();
		
		System.out.println("--------reverse--------");
		HeroDemo head = ArrayLink.ReverseLink(list.getHead());
		list.setHead(head);
		list.list();
		
		HeroDemo hero5 = new HeroDemo(3 ,"六舅");
		System.out.println("--------update--------");
		list.update(hero5);
		list.list();
		
		System.out.println("--------del--------");
		list.del(2);
		list.del(4);
		list.list();
		
	}
}
	
	class ArrayLink{
		
		private HeroDemo head = new HeroDemo(0,"");
		
		/*
		 * 查找倒数第几个
		 */
		public HeroDemo findBylastIndex(int size,int index) {
			if(head.next == null) {
				System.out.println("------head empty----------");
				return null;
			}
			if(size < index) {
				System.out.println("------full number----------");
				return null;
			}
			HeroDemo temp = head.next;
			for(int i = 0; i < size - index; i++) {
				temp = temp.next;
			}
			return temp;
		}
		
		public int getLeng() {
			HeroDemo temp = head.next;
			int len = 0;
			while(temp != null) {
				len++;
				temp = temp.next;
			}
			return len;
		}
		/*
		 * 链表从尾部开始输出 可以使用栈实现
		 * 另一种方法使用反转 但是改变了原来头节点
		 */
		public void lastPrint() {
			
			if(head.next == null) {
				System.out.println("------head empty----------");
				return;
			}
			
			HeroDemo temp = head.next;
			Stack<HeroDemo> stack = new Stack<HeroDemo>();
			
			while(temp != null) {
				
				stack.push(temp);
				temp = temp.next;
			}
			
			while(stack.size() > 0) {
				System.out.println(stack.pop());
			}
		}
		
		public void setHead(HeroDemo head) {
			this.head = head;
		}
		/*
		 * 反转
		 */
		public static HeroDemo ReverseLink(HeroDemo head) {
			if(head.next == null || head.next.next == null) {
				return head;
			}
			
			HeroDemo cur = head.next;
			HeroDemo next = null;
			HeroDemo ReverseHead = new HeroDemo(0,"");
			
			while(cur != null) {
				
				next = cur.next;
				cur.next = ReverseHead.next;
				ReverseHead.next = cur;
				cur = next;
			}
			head.next = ReverseHead.next;
			return head;
			
		}
		
		public HeroDemo getHead() {
			return head;
		}
		
		public void del(int no) {
			if(head.next == null) {
				System.out.println("------head empty----------");
				return;
			}
			HeroDemo temp = head;
			boolean flag = false;
			while(temp.next != null) {
				
				if(temp.next.no == no) {
					flag = true;
					break;
				}
				temp = temp.next;
			}
			if(flag) {
				temp.next = temp.next.next;
				return;
			}else {
				System.out.println("------not find----------");
				return;
			}
		}
		
		public void update(HeroDemo hero) {
			if(head.next == null) {
				System.out.println("------head empty----------");
				return;
			}
			HeroDemo temp = head.next;
			boolean flag = false;
			while(temp != null) {
				
				if(temp.no == hero.no) {
					flag = true;
					break;
				}
				temp = temp.next;
			}
			if(flag) {
				temp.name = hero.name;
				return;
			}else {
				System.out.println("------not find----------");
				return;
			}
		}
		
		public void add(HeroDemo hero) {
			
			HeroDemo temp = head;
			
			while(true) {
				
				if(temp.next == null) {
					temp.next = hero;
					break;
				}
				temp = temp.next;
			}
		}
		
		public void addList(HeroDemo hero) {
			
			HeroDemo temp = head;
			boolean flag = false;
			
			while(true) {
				
				if(temp.next == null) {
					break;
				}else if(temp.next.no > hero.no) {
					break;
				}else if(temp.next.no == hero.no) {
					flag = true;
				}
				temp = temp.next;
			}
			
			if(flag) {
				System.out.println("数据已存在");
				return;
			}
			hero.next = temp.next;
			temp.next = hero;
		}
		
		public void list() {
			
			HeroDemo temp = head.next;
			if(temp == null) {
				System.out.println("链表为空");
			}
			while(temp != null) {
				
				System.out.println(temp);
				temp = temp.next;
			}
		}
	}
	
	class HeroDemo{
		
		public int no;
		
		public String name;
		
		public HeroDemo next;
		
		public HeroDemo(int no,String name) {
			this.no = no;
			this.name = name;
			this.next = null;
		}

		@Override
		public String toString() {
			return "HeroDemo [no=" + no + ", name=" + name + "]";
		}
		
	}

