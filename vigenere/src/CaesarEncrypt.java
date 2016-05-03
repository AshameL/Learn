
public class CaesarEncrypt {
	private int key;
	//加密算法
	public CaesarEncrypt(int key) {
		// TODO Auto-generated constructor stub
		this.key=key;
	}
	public String encrypt(String ciphertext){
		char[] plaintext=new char[ciphertext.length()];
		for(int i=0;i<ciphertext.length();i++){
			//A 65  Z 90 a 97 z 122
			char temp=ciphertext.charAt(i);
			//大写字母
			if(temp>=65&&temp<=90){
				temp=(char) (((temp-65)+key)%26);
				temp+=65;
			}
			else if(temp>=97&&temp<=122){
				temp=(char) (((temp-97)+key)%26);
				temp+=97;
			}
			plaintext[i]=temp;
		}
		String s=new String(plaintext);
		return s;
		
	}
	//解密算法。。。。。。。。
}
