import java.math.BigInteger;

public class xor {
	// a是被除数，b是除数
	private String a, b;

	public xor(String a, String b) {
		this.a = a;
		this.b = b;
	}

	public String calculate() {

		int bLength = b.length();// 记录除数的长度
		String mod = a.substring(0, bLength);// 初始长度
		// a增加k-1个0
		for (int i = 1; i < bLength; i++) {
			a = a + '0';
		}
		// 这里进行异或运算
		for (int i = bLength - 1; i < a.length();) {

			mod = cal(mod, b);

			// 计算余数的位数
			int j = i + bLength - mod.length();
			if (j >= a.length()) {
				mod += a.substring(i + 1);
				break;
			}
			String t = a.substring(i + 1, j + 1);
//			System.out.println("进位数=" + t);
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
		// 在这里去零
//		System.out.println(mod);
		long temp = Long.parseLong(mod);
		mod = Long.toString(temp);
		return mod;
	}
}
