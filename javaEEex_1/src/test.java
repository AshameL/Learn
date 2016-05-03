import org.junit.Test;

import javaEEex_1_1.*;

public class test {
	// 这个类用来测试的
	public static void main(String[] args) {
		Cannon cannon = new Cannon();
		cannon.out();
		cannon.getData("实验报告1");
		
		//反射 泛型 工厂模式
		Hp hp = Factory.getOutputImpInstance(Hp.class);
		hp.out();
		System.out.println(hp.leftLink(30));
		hp.getData("课程设计");
		hp.getQueueNow();
		
		//测试单例
		Hp hp2 =Factory.getOutputImpInstance(Hp.class);
		System.out.println("hp == hp2 ? ");
		System.out.println( hp==hp2);
	}
}
