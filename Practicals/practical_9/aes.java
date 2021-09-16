/*
aes.java
Author: Jagrut Gala
Date: 26-08-2021
Practical: 9
Objective: Demonstrate AES Encryption and Decryption.
*/

import java.io.*;
import java.util.Base64;
import javax.crypto.*;

public class aes {
    Cipher encipher, decipher;
    aes(SecretKey key) {
        try {
            encipher= Cipher.getInstance("AES");
            encipher.init(Cipher.ENCRYPT_MODE, key);
            decipher= Cipher.getInstance("AES");
            decipher.init(Cipher.DECRYPT_MODE, key);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    String encrypt1(String plain_text) {
        String encrpypted_text= "";
        try {
            byte[] utf8_text= plain_text.getBytes("UTF8");
            byte[] enc= encipher.doFinal(utf8_text);
            encrpypted_text= new String(Base64.getEncoder().encode(enc));
        } catch (Exception e) {
            System.out.println(e);
        }
        return encrpypted_text;
    }

    String decrypt1(String cipher_text) {
        String decrpypted_text= "";
        try {
            byte[] dec= Base64.getDecoder().decode(cipher_text);
            byte[] utf8_text= decipher.doFinal(dec);
            decrpypted_text= new String(utf8_text);
        } catch (Exception e) {
            System.out.println(e);
        }
        return decrpypted_text;
    }


    public static void main(String[] args) {
        String text= "jagrut";
        System.out.println("Entered String: "+ text);
        try {
            SecretKey key= KeyGenerator.getInstance("AES").generateKey();
            aes aes_var= new aes(key);
            String encrypted_text= aes_var.encrypt1(text);
            String decrypted_text= aes_var.decrypt1(encrypted_text);

            System.out.println("Encrypted Text: "+ encrypted_text);
            System.out.println("Decrypted Text: "+ decrypted_text);

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
