package javaEEex_1_1;

import java.util.LinkedList;

import org.junit.Test;

public class Cannon extends Printer implements IOutput {

	public void out() {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName()+ "���ڴ�ӡ...");
	}

	@Override
	public void getData(String msg) {
		// TODO Auto-generated method stub
		queue.add(msg);
		System.out.println(msg + "�Ѿ����������");
	}

	@Test
	public void test() {
		// ���������һ��
		getData("ʵ�鱨��");
		out();
	}
	public Cannon() {
		// TODO Auto-generated constructor stub
		//���г�ʼ��һ��
		queue = new LinkedList<String>();
		
	}

}
