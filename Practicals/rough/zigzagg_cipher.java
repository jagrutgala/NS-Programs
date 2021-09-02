import java.io.*;

class zigzagg_cipher {
    zigzagg_cipher(){
    }

    static String encrypt(String msg) {
        String cipher_text= "";
        String str1= "";
        String str2= "";
        for(int i=0; i<msg.length(); i++){
            if(i%2 == 0){
                str1+= msg.charAt(i);
            } else {
                str2+= msg.charAt(i);
            }
        }
        cipher_text= str1+ str2;
        return(cipher_text);
    }

    static String decrypt(String msg) {
        String plain_text= "";
        if(msg.length()%2 ==1){
            msg+= " ";
        }
        String str1= msg.substring(0, msg.length()/2);
        String str2= msg.substring(msg.length()/2);
        for(int i=0; i<str1.length(); i++){
            plain_text+= (Character.toString(str1.charAt(i)))+ (Character.toString(str2.charAt(i)));
        }
        plain_text= plain_text.trim();
        return(plain_text);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader rb= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("***ZigZaag Encryption***");
        System.out.print("Enter Your Text: ");
        String text= rb.readLine();
        System.out.println("Cipher Text: "+ encrypt(text));
        System.out.println("Plain Text: "+ decrypt(encrypt(text)));
    }
}
