import java.io.*;

public class railfence_cipher {
    railfence_cipher() {}

    String encrypt(String text) {
        String str1= "";
        String str2= "";
        for(int i=0 ; i< text.length(); i++) {
            if(i% 2== 0) {
                str1+= text.charAt(i);
            } else {
                str2+= text.charAt(i);
            }
        }
        text= str1+ str2;
        return text;
    }

    String decrypt(String text) {
        return str1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        railfence_cipher rc= new railfence_cipher();
        System.out.println("***Railfence Encryption***");
        System.out.print("Enter Your Text: ");
        String text= br.readLine();
        System.out.println("Cipher Text: "+ rc.encrypt(text));
        System.out.println("Plain Text: "+ rc.decrypt(rc.encrypt(text)));
    }
}
