import java.math.BigInteger;

public class xor {
	// a�Ǳ�������b�ǳ���
	private String a, b;

	public xor(String a, String b) {
		this.a = a;
		this.b = b;
	}

	public String calculate() {

		int bLength = b.length();// ��¼�����ĳ���
		String mod = a.substring(0, bLength);// ��ʼ����
		// a����k-1��0
		for (int i = 1; i < bLength; i++) {
			a = a + '0';
		}
		// ��������������
		for (int i = bLength - 1; i < a.length();) {

			mod = cal(mod, b);

			// ����������λ��
			int j = i + bLength - mod.length();
			if (j >= a.length()) {
				mod += a.substring(i + 1);
				break;
			}
			String t = a.substring(i + 1, j + 1);
//			System.out.println("��λ��=" + t);
			mod = mod + t;

//			System.out.println("mod=" + mod);
			i = j;
		}

		return mod;
	}

	public String cal(String a, String b) {
		String mod = new String();
		if (a.length() != b.length()) {
			return null;
		}
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == b.charAt(i)) {
				mod += "0";
			} else {
				mod += "1";
			}
		}
		// ������ȥ��
//		System.out.println(mod);
		long temp = Long.parseLong(mod);
		mod = Long.toString(temp);
		return mod;
	}
}
