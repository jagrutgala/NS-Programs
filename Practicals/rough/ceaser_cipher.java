import java.io.*;

class ceaser_cipher {
    ceaser_cipher(){
    }

    static String encrypt(String str){
        String cipher_text= "";
        str= str.toLowerCase();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)== ('a')){
                cipher_text+= "x"; 
            } else if(str.charAt(i)== ('b')){
                cipher_text+= "y";
            } else if(str.charAt(i)== ('c')){
                cipher_text+= "z";
            } else {
                char ch= str.charAt(i);
                cipher_text+= (char) (ch+ 3);
            }
        }
        return(cipher_text);
    }

    static String decrypt(String str){
        String plain_text= "";
        str= str.toLowerCase();
        for(int i=0; i< str.length(); i++){
            if(str.charAt(i)== ('x')){
                plain_text+= "a"; 
            } else if(str.charAt(i)== ('y')){
                plain_text+= "b";
            } else if(str.charAt(i)== ('z')){
                plain_text+= "c";
            } else {
                char ch= str.charAt(i);
                plain_text+= (char) (ch- 3);
            }
        }
        return(plain_text);
    }


    public static void main(String[] args) throws IOException{
        BufferedReader rb= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("***Ceaser Encryption***");
        System.out.print("Enter Your Text: ");
        String text= rb.readLine();
        System.out.println("Cipher Text: "+ encrypt(text));
        System.out.println("Plain Text: "+ decrypt(encrypt(text)));
    }
}
