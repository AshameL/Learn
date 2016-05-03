package javaEEex_1_1;

import java.util.LinkedList;

import org.junit.Test;

public class Cannon extends Printer implements IOutput {

	public void out() {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName()+ "正在打印...");
	}

	@Override
	public void getData(String msg) {
		// TODO Auto-generated method stub
		queue.add(msg);
		System.out.println(msg + "已经被加入队列");
	}

	@Test
	public void test() {
		// 在这里测试一下
		getData("实验报告");
		out();
	}
	public Cannon() {
		// TODO Auto-generated constructor stub
		//队列初始化一下
		queue = new LinkedList<String>();
		
	}

}
