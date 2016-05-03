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
			readFromFileVignereEncrypt();//加密
			readFromFileVignereDiscrypt();//解密
			charStatistics("plaintext");
			charStatistics("encrypttext");
			//字符统计
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void initCaesarEncrypt() {
		Scanner scanner = new Scanner(System.in);

		int i = -1;
		while (i < 0 || i > 25) {
			System.out.println("ce输入密钥值(0-25):");
			i = scanner.nextInt();
		}
		CaesarEncrypt ce = new CaesarEncrypt(i);
		System.out.println("输入明文：");
		// 回收空行
		scanner.nextLine();
		String ciphertext = scanner.nextLine();
		System.out.println("明文：" + ciphertext);
		String keytext = ce.encrypt(ciphertext);
		System.out.println("密文：" + keytext);
	}

	static void initVignereEncrypt() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("ve输入密钥短语:");
		String key= scanner.nextLine();
		key=key.toLowerCase();
		VignereEncrypt ve = new VignereEncrypt(key);
		System.out.println("输入明文：");
		// 回收空行
		String ciphertext = scanner.nextLine();
		System.out.println("明文：" + ciphertext);
		String keytext = ve.encrypt(ciphertext);
		System.out.println("密文：" + keytext);
	}
	static void readFromFileVignereEncrypt() throws Exception{
		StringBuffer sb=new StringBuffer();
		FileReader fr=new FileReader("1key.txt");
		BufferedReader br=new BufferedReader(fr);
		//假设密钥就一行
		String key=br.readLine();
		//去掉多余空格
		key=key.trim();
		System.out.println("key:"+key);
		//构造
		VignereEncrypt ve = new VignereEncrypt(key);
		//读入待加密文件
		String context=null;
		fr=new FileReader("source.txt");
		br=new BufferedReader(fr);
		while((context=br.readLine())!=null){
			//读入并加密
			String encrypt=ve.encrypt(context);
			
			sb.append(encrypt+"\n");
		}
		br.close();
		fr.close();
		//写入文件
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
		//假设密钥就一行
		String key=br.readLine();
		//去掉多余空格
		key=key.trim();
		//构造
		VignereEncrypt ve = new VignereEncrypt(key);
		//读入待加密文件
		String context=null;
		fr=new FileReader("encrypttext.txt");
		br=new BufferedReader(fr);
		while((context=br.readLine())!=null){
			//读入并加密
			String encrypt=ve.discrypt(context);
			
			sb.append(encrypt+"\n");
		}
		br.close();
		fr.close();
		//写入文件
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
		//文件读入
		while((context=br.readLine())!=null){
			for(int i=0;i<context.length();i++){
				int num=context.charAt(i)-97;//算字母频率
				if(num>=0&&num<=25){//如果是小写字母
					al[num]++;
				}
			}
		}
		FileWriter writer = new FileWriter(filename+"Statics.txt"); 
        BufferedWriter bw = new BufferedWriter(writer);
        //写入
        for(int i=0;i<al.length;i++){
        	char c=(char) ('a'+i);
        	bw.write(c+":"+al[i]+"次\n\r");
        }
        bw.close();
        writer.close();
	}
}
