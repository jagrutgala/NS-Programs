/*
railfence_cipher.java
Author: Jagrut Gala
Date: 08-07-2021
Practical: 2
Objective: Demonstrate Rail Fence Cipher.
*/

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

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        railfence_cipher rc= new railfence_cipher();
        System.out.println("***Railfence Encryption***");
        System.out.print("Enter Your Text: ");
        String text= br.readLine();
        System.out.println("Cipher Text: "+ rc.encrypt(text));
    }
}
