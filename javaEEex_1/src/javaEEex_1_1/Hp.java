package javaEEex_1_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hp extends Printer implements IOutputHignLevel {
	// �������ӡ��д�ɵ���
	private int link = 100;// īˮ����
	private int need = 0;
	private static Hp instance;// ����

	@Override
	public void out() {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName() + "���ڴ�ӡ...");
		link -= need;
	}

	@Override
	public void getData(String msg) {
		// TODO Auto-generated method stub
		queue.offer(msg);
		System.out.println(msg + "�Ѿ����������");
	}

	@Override
	public Queue getQueueNow() {
		// TODO Auto-generated method stub
		for (String s : queue) {
			Logger log = Logger.getLogger("queue");
			log.setLevel(Level.INFO);
			log.info("print---->" + s);
		}
		return queue;
	}

	@Override
	public String leftLink(int need) {
		// TODO Auto-generated method stub
		this.need = need;
		if (link >= need) {
			return "the left link is enough";
		}
		return "the left link is not enough";
	}

	public Hp() {
		// ���г�ʼ��һ��
		queue = new LinkedList<String>();
		// TODO Auto-generated constructor stub
	}

	public static Hp getInstance() {
		// ���instanceΪnull�����������������
		// ���instance ��Ϊnull,������Ѿ�������
		if (instance == null) {
			instance = new Hp();
		}
		return instance;
	}
}
