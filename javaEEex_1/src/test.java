import org.junit.Test;

import javaEEex_1_1.*;

public class test {
	// ������������Ե�
	public static void main(String[] args) {
		Cannon cannon = new Cannon();
		cannon.out();
		cannon.getData("ʵ�鱨��1");
		
		//���� ���� ����ģʽ
		Hp hp = Factory.getOutputImpInstance(Hp.class);
		hp.out();
		System.out.println(hp.leftLink(30));
		hp.getData("�γ����");
		hp.getQueueNow();
		
		//���Ե���
		Hp hp2 =Factory.getOutputImpInstance(Hp.class);
		System.out.println("hp == hp2 ? ");
		System.out.println( hp==hp2);
	}
}
