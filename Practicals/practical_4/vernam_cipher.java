/*
vernam_cipher.java
Author: Jagrut Gala
Date: 22-07-2021
Practical: 4
Objective: Demonstrate Vernam Cipher.
*/

import java.io.*;

public class vernam_cipher {
    char[] alpha_arr= new char[26];
    vernam_cipher() {
        for(int i=0; i<this.alpha_arr.length; i++){
            this.alpha_arr[i]= (char) ('A'+ i);
            // System.out.println(i+ ", " + this.alpha_arr[i]);
        }
    }

    char[] getKeyArray(String key, int len) {
        char[] key_arr= new char[len];
        for(int i=0; i< key_arr.length; i++) {
            // System.out.println(i% key.length());
            key_arr[i]= key.charAt(i% key.length());
        }
        return key_arr;
    }

    String encrypt(String text, String key) {
        char[] text_arr= text.toCharArray();
        char[] key_arr= this.getKeyArray(key, text_arr.length);
        int[] num_arr= new int[text_arr.length];

        for(int i=0; i< num_arr.length; i++) {
            num_arr[i]= 0;
        }

        for(int i=0; i< text_arr.length; i++) {
            for(int j=0; j< this.alpha_arr.length; j++) {
                if(text_arr[i] == alpha_arr[j]) {
                    num_arr[i]+= j;
                    // num_arr[i]= (text_arr[i] + key_arr[i% key_arr.length])% alpha_arr.length;
                }
                if(key_arr[i] == alpha_arr[j]){
                    num_arr[i]+= j;
                }
            }
            num_arr[i]%= this.alpha_arr.length;
            
        }
        for(int i=0; i< num_arr.length; i++) {
            text_arr[i]= this.alpha_arr[num_arr[i]];
        }
        text= new String(text_arr);
        return text;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        vernam_cipher vc= new vernam_cipher();
        System.out.println("***Vernam Encryption***");
        System.out.print("Enter Your Text: ");
        String text= br.readLine();
        System.out.print("Enter Your Key: ");
        String key= br.readLine();
        System.out.println("Cipher Text: "+ vc.encrypt(text, key));
    }
}
