
public class VignereEncrypt {
	//密钥
	//这里对于密钥的想法：如果出现非字母的字符，则不加密
	private String key;
	public VignereEncrypt(String key) {
		// TODO Auto-generated constructor stub
		this.key=key;
		
	}
	//加密
	public String encrypt(String ciphertext){
		//化为小写
		ciphertext=ciphertext.toLowerCase();
		char[] plaintext=new char[ciphertext.length()];
		for(int i=0;i<ciphertext.length();i++){
			//A 65  Z 90 a 97 z 122
			char temp=ciphertext.charAt(i);
			//是小写字母
			if(temp>=97&&temp<=122){
				temp-=97;//减97进行计算
				//判断对应的密钥
				char tempKey=key.charAt((ciphertext.length()+i+1)%key.length());
				//如果key值对应的是小写字母
				if(tempKey>=97&&temp<=122){
					tempKey-=97;
					
				}
				else{//如果不是则不加密
					tempKey=0;
				}
				temp=(char) ((temp+tempKey)%26);
				//改成小写
				temp+=97;
			}
			plaintext[i]=temp;
		}
		String s=new String(plaintext);
		return s;
		
	}
	public String discrypt(String ciphertext){
		ciphertext=ciphertext.toLowerCase();
		char[] plaintext=new char[ciphertext.length()];
		for(int i=0;i<ciphertext.length();i++){
			//A 65  Z 90 a 97 z 122
			char temp=ciphertext.charAt(i);
			//统一转化成小写字母
			if(temp>=97&&temp<=122){
				temp-=97;//减97进行计算
				//判断对应的密钥
				char tempKey=key.charAt((ciphertext.length()+i+1)%key.length());
				//如果key值对应的是小写字母
				if(tempKey>=97&&temp<=122){
					tempKey-=97;
					
				}
				else{//如果不是则不加密
					tempKey=0;
				}
				temp=(char) ((temp-tempKey+26)%26);
				//改成小写
				temp+=97;
			}
			plaintext[i]=temp;
		}
		String s=new String(plaintext);
		return s;
		
	}
}
