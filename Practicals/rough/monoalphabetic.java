import java.io.*;

class monoalphabetic {
    char[] plain_char = {'a', 'b', 'e', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    char[] cipher_char = { 'Q', 'w', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};

    String encrypt(String text){
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

    String decrypt(String text){
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
        BufferedReader rb= new BufferedReader(new InputStreamReader(System.in));
        monoalphabetic ns= new monoalphabetic();

        System.out.println("***MonoAlphbetic Encryption***");
        System.out.print("Enter Your Text: ");
        String text= rb.readLine();
        
        System.out.println("Cipher Text: "+ ns.encrypt(text));
        System.out.println("Plain Text: "+ ns.decrypt(ns.encrypt(text)));
    }
}
