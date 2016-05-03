import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.imageio.stream.FileImageInputStream;
import javax.print.DocFlavor.STRING;

public class test {
	public static void main(String[] args) {
		// initCaesarEncrypt();
		//initVignereEncrypt();
		try {
			readFromFileVignereEncrypt();//����
			readFromFileVignereDiscrypt();//����
			charStatistics("plaintext");
			charStatistics("encrypttext");
			//�ַ�ͳ��
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void initCaesarEncrypt() {
		Scanner scanner = new Scanner(System.in);

		int i = -1;
		while (i < 0 || i > 25) {
			System.out.println("ce������Կֵ(0-25):");
			i = scanner.nextInt();
		}
		CaesarEncrypt ce = new CaesarEncrypt(i);
		System.out.println("�������ģ�");
		// ���տ���
		scanner.nextLine();
		String ciphertext = scanner.nextLine();
		System.out.println("���ģ�" + ciphertext);
		String keytext = ce.encrypt(ciphertext);
		System.out.println("���ģ�" + keytext);
	}

	static void initVignereEncrypt() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("ve������Կ����:");
		String key= scanner.nextLine();
		key=key.toLowerCase();
		VignereEncrypt ve = new VignereEncrypt(key);
		System.out.println("�������ģ�");
		// ���տ���
		String ciphertext = scanner.nextLine();
		System.out.println("���ģ�" + ciphertext);
		String keytext = ve.encrypt(ciphertext);
		System.out.println("���ģ�" + keytext);
	}
	static void readFromFileVignereEncrypt() throws Exception{
		StringBuffer sb=new StringBuffer();
		FileReader fr=new FileReader("1key.txt");
		BufferedReader br=new BufferedReader(fr);
		//������Կ��һ��
		String key=br.readLine();
		//ȥ������ո�
		key=key.trim();
		System.out.println("key:"+key);
		//����
		VignereEncrypt ve = new VignereEncrypt(key);
		//����������ļ�
		String context=null;
		fr=new FileReader("source.txt");
		br=new BufferedReader(fr);
		while((context=br.readLine())!=null){
			//���벢����
			String encrypt=ve.encrypt(context);
			
			sb.append(encrypt+"\n");
		}
		br.close();
		fr.close();
		//д���ļ�
		FileWriter writer = new FileWriter("encrypttext.txt"); 
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write(sb.toString());
        bw.close();
        writer.close();

	}
	static void readFromFileVignereDiscrypt() throws Exception{
		StringBuffer sb=new StringBuffer();
		FileReader fr=new FileReader("1key.txt");
		BufferedReader br=new BufferedReader(fr);
		//������Կ��һ��
		String key=br.readLine();
		//ȥ������ո�
		key=key.trim();
		//����
		VignereEncrypt ve = new VignereEncrypt(key);
		//����������ļ�
		String context=null;
		fr=new FileReader("encrypttext.txt");
		br=new BufferedReader(fr);
		while((context=br.readLine())!=null){
			//���벢����
			String encrypt=ve.discrypt(context);
			
			sb.append(encrypt+"\n");
		}
		br.close();
		fr.close();
		//д���ļ�
		FileWriter writer = new FileWriter("plaintext.txt"); 
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write(sb.toString());
        bw.close();
        writer.close();

	}
	static void charStatistics(String filename) throws Exception{
		String filename2=filename+".txt";
		StringBuffer sb=new StringBuffer();
		FileReader fr=new FileReader(filename2);
		BufferedReader br=new BufferedReader(fr);
		int[] al=new int[26];
		String context;
		//�ļ�����
		while((context=br.readLine())!=null){
			for(int i=0;i<context.length();i++){
				int num=context.charAt(i)-97;//����ĸƵ��
				if(num>=0&&num<=25){//�����Сд��ĸ
					al[num]++;
				}
			}
		}
		FileWriter writer = new FileWriter(filename+"Statics.txt"); 
        BufferedWriter bw = new BufferedWriter(writer);
        //д��
        for(int i=0;i<al.length;i++){
        	char c=(char) ('a'+i);
        	bw.write(c+":"+al[i]+"��\n\r");
        }
        bw.close();
        writer.close();
	}
}
