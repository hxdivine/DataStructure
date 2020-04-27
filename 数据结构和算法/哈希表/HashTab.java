package com.hashtab;

public class HashTab {
	
	private EmpLinkList[] empLinkList;
	public HashTab(int size){
		this.empLinkList = new EmpLinkList[size];
		for(int i = 0; i < size; i++){
			this.empLinkList[i] = new EmpLinkList();
		}
	}
	
	public static void main(String[] args) {
		HashTab hashTab = new HashTab(5);
		for(int i = 0; i < 10; i++){
			Emp emp = new Emp(i,"张三" + i);
			hashTab.add(emp);
		}
		
		hashTab.list();
		
		hashTab.findEmpById(11);
		
		Emp emp = new Emp(11,"张五");
		hashTab.updaEmp(emp);
		hashTab.list();
	}
	
	public void add(Emp emp){
		//根据雇员id 确定加到哪个链表中
		int index = hashFun(emp.id);
		this.empLinkList[index].add(emp);
	}
	/**
	 * 散列函数
	 * 使用取模法
	 * @param id  雇员id
	 * @return
	 */
	public int hashFun(int id){
		return id % (this.empLinkList.length);
	}
	
	public void updaEmp(Emp emp){
		int index = hashFun(emp.id);
		this.empLinkList[index].updateEmp(emp);
	}
	
	public void findEmpById(int id){
		int index = hashFun(id);
		Emp emp = this.empLinkList[index].findEmpById(id);
		if(emp == null){
			System.out.println("未找到");
		}else{
			System.out.println("Emp id = " + emp.id + " , name = " + emp.name );
		}
	}
	/**
	 * 遍历哈希表
	 */
	public void list(){
		for(int i = 0; i < this.empLinkList.length; i++){
			this.empLinkList[i].list(i);
		}
	}
}

//表示雇员链表
class EmpLinkList{
	//头指针
	private Emp head;
	//添加雇员到链表中
	public void add(Emp emp){
		if(head == null){
			head = emp;
			return;
		}
		Emp curEmp = head;
		while(true){
			if(curEmp.next == null){
				break;
			}
			curEmp = curEmp.next;
		}
		
		curEmp.next = emp;
	}
	/**
	 * 根据id查找员工
	 * @param id
	 * @return
	 */
	public Emp findEmpById(int id){
		if(head == null){
			System.out.println("当前链表为空----------");
			return null;
		}
		Emp curEmp = head;
		while(true){
			if(curEmp == null){
				break;
			}
			if(curEmp.id == id){
				break;
			}
			curEmp = curEmp.next;
		}
		return curEmp;
	}
	/**
	 * 更新
	 * @param emp
	 */
	public void updateEmp(Emp emp){
		if(head == null){
			System.out.println("当前链表为空----------");
			return;
		}
		Emp curEmp = head;
		while(true){
			if(curEmp == null){
				break;
			}
			if(curEmp.id == emp.id){
				curEmp.name = emp.name;
				break;
			}
			curEmp = curEmp.next;
		}
		if(curEmp == null){
			System.out.println("员工信息有误");
		}
		
	}
	/**
	 * 遍历链表
	 */
	public void list(int i){
		if(head == null){
			System.out.println("当前第 " + i + " 条链表为空----------");
			return;
		}
		System.out.println("当前第 " + i + " 条雇员信息-------");
		Emp curEmp = head;
		while(true){
			System.out.println("id = " + curEmp.id + ", name = " + curEmp.name);
			if(curEmp.next == null){
				break;
			}
			curEmp = curEmp.next;
		}
		System.out.println();
		return;
	}
}

class Emp{
	public int id;
	public String name;
	public Emp next;
	public Emp(int id,String name){
		super();
		this.id = id;
		this.name = name;
	}
}
