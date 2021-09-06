/*
caesar_cipher.java
Author: Jagrut Gala
Date: 01-07-2021
Practical: 1
Objective: Demonstrate Caesar Cipher.
*/

import java.io.*;

class caesar_cipher {
    caesar_cipher() {}

    String encrypt(String str){
        String cipher_text= "";
        str= str.toLowerCase();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)== ('x')){
                cipher_text+= "a"; 
            } else if(str.charAt(i)== ('y')){
                cipher_text+= "b";
            } else if(str.charAt(i)== ('z')){
                cipher_text+= "c";
            } else {
                char ch= str.charAt(i);
                cipher_text+= (char) (ch+ 3);
            }
        }
        return(cipher_text);
    }

    String decrypt(String str){ // yes
        String plain_text= "";
        str= str.toLowerCase();
        for(int i=0; i< str.length(); i++){
            if(str.charAt(i)== ('a')){
                plain_text+= "x"; 
            } else if(str.charAt(i)== ('b')){
                plain_text+= "y";
            } else if(str.charAt(i)== ('c')){
                plain_text+= "z";
            } else {
                char ch= str.charAt(i);
                plain_text+= (char) (ch- 3);
            }
        }
        return(plain_text);
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        caesar_cipher cc= new caesar_cipher();
        System.out.println("***Ceaser Encryption***");
        System.out.print("Enter Your Text: ");
        String text= br.readLine();
        System.out.println("Cipher Text: "+ cc.encrypt(text));
        System.out.println("Plain Text: "+ cc.decrypt(cc.encrypt(text)));
    }
}
