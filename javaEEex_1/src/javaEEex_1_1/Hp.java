package javaEEex_1_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hp extends Printer implements IOutputHignLevel {
	// 把这个打印机写成单例
	private int link = 100;// 墨水数量
	private int need = 0;
	private static Hp instance;// 单例

	@Override
	public void out() {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName() + "正在打印...");
		link -= need;
	}

	@Override
	public void getData(String msg) {
		// TODO Auto-generated method stub
		queue.offer(msg);
		System.out.println(msg + "已经被加入队列");
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
		// 队列初始化一下
		queue = new LinkedList<String>();
		// TODO Auto-generated constructor stub
	}

	public static Hp getInstance() {
		// 如果instance为null，则表明不曾创建过
		// 如果instance 不为null,则表明已经创建了
		if (instance == null) {
			instance = new Hp();
		}
		return instance;
	}
}
