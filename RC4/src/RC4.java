import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class RC4 {
	int[] s;
	byte[] t;
	String input;
	String key;

	public RC4(String input, String key) {

		// TODO Auto-generated constructor stub
		this.input = input;
		this.key = key;
		// 状态向量s，临时向量t
		s = new int[256];
		t = new byte[256];

		// 初始化 s和t
		for (int i = 0; i < 256; i++) {
			s[i] = i;
			t[i] = (byte) key.charAt(i % key.length());
		}
		// 初始排列s
		int j = 0;
		for (int i = 0; i < 255; i++) {
			j = (j + s[i] + t[i]) % 256;
			// 交换
			int temp = s[i];
			s[i] = s[j];
			s[j] = temp;
		}

	}

	public RC4(String key) {

		// TODO Auto-generated constructor stub
		this.key = key;
		// 状态向量s，临时向量t
		s = new int[256];
		t = new byte[256];

		// 初始化 s和t
		for (int i = 0; i < 256; i++) {
			s[i] = i;
			t[i] = (byte) key.charAt(i % key.length());
		}
		// 初始排列s
		int j = 0;
		for (int i = 0; i < 255; i++) {
			j = (j + s[i] + t[i]) % 256;
			// 交换
			int temp = s[i];
			s[i] = s[j];
			s[j] = temp;
		}

	}

	public String encrypt() {
		int i = 0;
		int j = 0;

		char[] iInputChar = input.toCharArray();
		char[] iOutputChar = new char[iInputChar.length];
		for (int x = 0; x < iInputChar.length; x++) {
			i = (i + 1) % 256;
			j = (j + s[i]) % 256;
			// 交换
			int temp = s[i];
			s[i] = s[j];
			s[j] = temp;

			int t = (s[i] + (s[j] % 256)) % 256;
			int iY = s[t];
			char iCY = (char) iY;
			iOutputChar[x] = (char) (iInputChar[x] ^ iCY);
		}

		return new String(iOutputChar);
	}

	public byte[] encrypt(int max) throws Exception {
		int i = 0;
		int j = 0;

		byte[] iOutputChar = new byte[max];

		FileOutputStream fos = new FileOutputStream("test.txt");

		for (int x = 0; x < max; x++) {
			i = (i + 1) % 256;
			j = (j + s[i]) % 256;
			// 交换
			int temp = s[i];
			s[i] = s[j];
			s[j] = temp;

			int te = (s[i] + s[j]) % 256;
			byte iY = (byte) s[te];
			fos.write(iY);

			iOutputChar[x] = iY;

		}

		return iOutputChar;
	}
	//骰子
//	public byte[] encrypt(int max) throws Exception {
//		int i = 0;
//		int j = 0;
//
//		byte[] iOutputChar = new byte[max];
//
//		FileOutputStream fos = new FileOutputStream("test.txt");
//
//		for (int x = 0; x < max; x++) {
//			i = (i + 1) % 256;
//			j = (j + s[i]) % 256;
//			// 交换
//			int temp = s[i];
//			s[i] = s[j];
//			s[j] = temp;
//
//			int te = (s[i] + s[j]) % 256;
//			byte iY = (byte) s[te];
//			fos.write(iY);
//
//			iOutputChar[x] = iY;
//
//		}
//
//		return iOutputChar;
//	}

	// 5w 文件
	public void readIn(int len) throws Exception {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(
				"test.txt"));
		ByteArrayOutputStream out = new ByteArrayOutputStream(len);
		byte[] temp = new byte[len];
		int size = 0;
		while ((size = in.read(temp)) != -1) {
			out.write(temp, 0, size);
		}
		in.close();

		byte[] content = out.toByteArray();
		System.out.println("Readed bytes count:" + content.length);
		int[] count = new int[256];
		for (byte x : content) {
			int y = ((x + 256) % 256);
			count[y]++;
		}
		BufferedWriter output = new BufferedWriter(new FileWriter(new File(
				"frequence.txt")));
		for (int i = 0; i < count.length; i++) {
			//System.out.println(count[i]);
			output.write(i + ":" + count[i] + "   \n\r");

		}
		output.close();
	}
}
