import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class test {
	public static void main(String[] args) throws Exception {
		// String inputStr = "����������";
		// String key = "abcdefg";
		// RC4 test = new RC4(inputStr, key);
		// String s=test.encrypt();
		// // ��ӡ���ܺ���ַ���
		// System.out.println(s);
		// test = new RC4(s, key);
		// // ��ӡ���ܺ���ַ���
		// s=test.encrypt();
		// System.out.print(s);

		String key = "random number generation!";
		RC4 test = new RC4(key);
		byte[] s = new byte[50000];
		s = test.encrypt(50000);
		System.out.println(s.length);
		test.readIn(50000);
		//ȡϵͳʱ��Ϊ�������������
		
		long key2 = System.currentTimeMillis();
		key = Long.toString(key2);
		RC4 test2 = new RC4(key);
		byte[] s2 = test2.encrypt(6000);
		BufferedWriter output = new BufferedWriter(new FileWriter(new File(
				"touzi.txt")));
		int [] num = new int [6];
		for(int i: num){
			i =0;
		}
		for(int i: s2){
			i += 256;
			i = i % 6 ;
			num[i]++;
		}
		for(int i = 0;i<6;i++){
			output.write((i+1)+":"+num[i]+"\n");
			System.out.println((i+1)+":"+num[i]+"\n");
		}
		output.close();
	}

}
