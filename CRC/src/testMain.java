import java.math.BigInteger;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 输入数据，随机生成被除数
		String a = "1";// 被除数
		String b = "1";// 除数
		int aLength = 10;// 先用10位来测试
		int bLength = 6;// 除数6位
		String mod = null;// 最后的余数
		// 随机产生数字
		for (int i = 1; i < aLength; i++) {
			int rd = Math.random() > 0.5 ? 1 : 0;
			a = a + rd;
		}
		for (int i = 1; i < bLength; i++) {
			int rd = Math.random() > 0.5 ? 1 : 0;
			b = b + rd;
		}
//		a = "1010001101";
//		b = "110101";
		System.out.println("随机生成的bite序列：" + a);
		System.out.println("随机生成的校验序列：" + b);
		// /////异或计算
		xor x = new xor(a, b);

		mod = x.calculate();
		System.out.println("计算的余数：" + mod);
	}

}
