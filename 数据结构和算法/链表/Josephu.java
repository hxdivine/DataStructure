package com.linkList;

/**
 * Josephu���� 
 * С������������Ȧ
 * ����ʵ��ʹ�õ���������
 * @author �����Ĵ���
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
	 * @param num ����
	 */
	public  void Josephu_prob(int num) {
			
		if(first == null) {
			System.out.println("��������Ϊ��");
			return;
		}
		//helperָ�� first�ĺ�һ��λ��
		Boy helper = first;
		while(true) {
			if(helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}
		//���
		while(true) {
			//ȫ��С����Ȧ
			if(helper == first) {
				System.out.println("С�� num = " + first.getNo());
				break;
			}
			//ÿ��һ���� �ƶ� num-1��
			for(int i = 0; i < num-1; i++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			
			System.out.println("С�� num = " + first.getNo());
			
			first = first.getNext();
			helper.setNext(first); 
		}
	}
	
 	public void addBoy(int nums) {
		
		if(nums < 1) {
			System.out.println("���������������");
			return;
		}
		
		Boy curBoy = null;
		
		for(int i = 1; i <= nums; i++) {
			Boy boy = new Boy(i);
			
			if(i == 1) {
				first = boy;
				first.setNext(first);  //�γɻ�
				curBoy = first;     //ָ���һ��С��
			}else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
		}
	}
	
	public void showBoy() {
		
		if(first == null) {
			System.out.println("û���κ�С��");
			return;
		}
		
		Boy curBoy = first;
		while(true) {
			System.out.println("С��num = " + curBoy.getNo());
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
