package com.linkList;

/**
 * Josephu问题 
 * 小孩轮流报数出圈
 * 代码实现使用单向环形链表
 * @author 骄傲的大树
 *
 */
public class Josephu {

	public static void main(String[] args) {
		
		CirLinklist list = new CirLinklist();
		list.addBoy(16);
		//list.showBoy();
		list.Josephu_prob(52);
	}

}

class CirLinklist{
	
	private Boy first = new Boy(-1);
	
	/**
	 * 
	 * @param num 报数
	 */
	public  void Josephu_prob(int num) {
			
		if(first == null) {
			System.out.println("孩子数量为空");
			return;
		}
		//helper指向 first的后一个位置
		Boy helper = first;
		while(true) {
			if(helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}
		//输出
		while(true) {
			//全部小孩出圈
			if(helper == first) {
				System.out.println("小孩 num = " + first.getNo());
				break;
			}
			//每报一次数 移动 num-1次
			for(int i = 0; i < num-1; i++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			
			System.out.println("小孩 num = " + first.getNo());
			
			first = first.getNext();
			helper.setNext(first); 
		}
	}
	
 	public void addBoy(int nums) {
		
		if(nums < 1) {
			System.out.println("孩子数量输入出错");
			return;
		}
		
		Boy curBoy = null;
		
		for(int i = 1; i <= nums; i++) {
			Boy boy = new Boy(i);
			
			if(i == 1) {
				first = boy;
				first.setNext(first);  //形成环
				curBoy = first;     //指向第一个小孩
			}else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
		}
	}
	
	public void showBoy() {
		
		if(first == null) {
			System.out.println("没有任何小孩");
			return;
		}
		
		Boy curBoy = first;
		while(true) {
			System.out.println("小孩num = " + curBoy.getNo());
			if(curBoy.getNext() == first) {
				break;
			}
			curBoy = curBoy.getNext();
		}
	}
}

class Boy{
	
	private int no;
	
	private Boy next;
	
	Boy(int no){
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}
	
}
