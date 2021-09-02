import java.io.*;

public class monoalphabetic_cipher {
    char[] plain_char = {'a', 'b', 'e', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    char[] cipher_char = { 'Q', 'w', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};

    monoalphabetic_cipher() {}

    String encrypt(String text) {
        String cipher_text= "";
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < plain_char.length; j++) {
                if(text.charAt(i)== plain_char[j]){
                    cipher_text+= cipher_char[j];
                }
            }
        }
        return(cipher_text);
    }

    String decrypt(String text) {
        String plain_text= "";
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < cipher_char.length; j++) {
                if(text.charAt(i)== cipher_char[j]){
                    plain_text+= plain_char[j];
                }
            }
        }
        return(plain_text);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        monoalphabetic_cipher mc= new monoalphabetic_cipher();
        System.out.println("***Monoalphabetic Encryption***");
        System.out.print("Enter Your Text: ");
        String text= br.readLine();
        System.out.println("Cipher Text: "+ mc.encrypt(text));
        System.out.println("Plain Text: "+ mc.decrypt(mc.encrypt(text)));
    }
}
