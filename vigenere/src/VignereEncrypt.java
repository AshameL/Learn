
public class VignereEncrypt {
	//��Կ
	//���������Կ���뷨��������ַ���ĸ���ַ����򲻼���
	private String key;
	public VignereEncrypt(String key) {
		// TODO Auto-generated constructor stub
		this.key=key;
		
	}
	//����
	public String encrypt(String ciphertext){
		//��ΪСд
		ciphertext=ciphertext.toLowerCase();
		char[] plaintext=new char[ciphertext.length()];
		for(int i=0;i<ciphertext.length();i++){
			//A 65  Z 90 a 97 z 122
			char temp=ciphertext.charAt(i);
			//��Сд��ĸ
			if(temp>=97&&temp<=122){
				temp-=97;//��97���м���
				//�ж϶�Ӧ����Կ
				char tempKey=key.charAt((ciphertext.length()+i+1)%key.length());
				//���keyֵ��Ӧ����Сд��ĸ
				if(tempKey>=97&&temp<=122){
					tempKey-=97;
					
				}
				else{//��������򲻼���
					tempKey=0;
				}
				temp=(char) ((temp+tempKey)%26);
				//�ĳ�Сд
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
			//ͳһת����Сд��ĸ
			if(temp>=97&&temp<=122){
				temp-=97;//��97���м���
				//�ж϶�Ӧ����Կ
				char tempKey=key.charAt((ciphertext.length()+i+1)%key.length());
				//���keyֵ��Ӧ����Сд��ĸ
				if(tempKey>=97&&temp<=122){
					tempKey-=97;
					
				}
				else{//��������򲻼���
					tempKey=0;
				}
				temp=(char) ((temp-tempKey+26)%26);
				//�ĳ�Сд
				temp+=97;
			}
			plaintext[i]=temp;
		}
		String s=new String(plaintext);
		return s;
		
	}
}
