import java.math.BigInteger;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �������ݣ�������ɱ�����
		String a = "1";// ������
		String b = "1";// ����
		int aLength = 10;// ����10λ������
		int bLength = 6;// ����6λ
		String mod = null;// ��������
		// �����������
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
		System.out.println("������ɵ�bite���У�" + a);
		System.out.println("������ɵ�У�����У�" + b);
		// /////������
		xor x = new xor(a, b);

		mod = x.calculate();
		System.out.println("�����������" + mod);
	}

}
