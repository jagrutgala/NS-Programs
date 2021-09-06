/*
columnar_cipher_2.java
Author: Jagrut Gala
Date: 29-07-2021
Practical: 5
Objective: Demonstrate Columnar Cipher.
*/

import java.io.*;
public class columnar_cipher_2 {
    columnar_cipher_2() {}

    String encrypt(String text, int row, int col, int[] choice) {
        int count= 0;
        char[][] cipher_matrix= new char[row][col];
        for(int i= 0; i< row; i++) { // columnar creation
            for(int j= 0; j< col; j++) {
                if(count>= text.length()) {
                    cipher_matrix[i][j]= ' ';
                } else {
                    cipher_matrix[i][j]= text.charAt(count);
                }
                count++;
                System.out.print(cipher_matrix[i][j]);
            }
        }
        System.out.println("");
        String cipher_text= "";
        for(int i= 0; i< col; i++) { // columnar encrption
            int k= choice[i];
            for(int j= 0; j< row; j++) {
                cipher_text+= cipher_matrix[j][k];
            }
        }
        return cipher_text;
    }

    String decrypt(String text, int rows, int cols, int[] choice) {
        return text;
    }
    
    public static void main(String[] args) throws IOException, Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        columnar_cipher_2 cc= new columnar_cipher_2();
        System.out.print("Enter a String: ");
        String text= br.readLine();
        System.out.print("Enter Number of Rows: ");
        int row_num = Integer.parseInt(br.readLine());
        System.out.print("Enter Number of Columns: ");
        int col_num= Integer.parseInt(br.readLine());
        if(row_num* col_num < text.length()) {
            throw new Exception("Insufficent Area for Text");
        }

        System.out.print("Enter your order of columns: ");
        String[] order= br.readLine().trim().split(" ");
        if(order.length != col_num) {
            throw new Exception("Invalid order of Colmuns given");
        }
        int[] choice= new int[col_num];
        for(int i=0; i<order.length; i++) {
            choice[i]= Integer.parseInt(order[i])- 1;
        }
        String cipher_text=cc.encrypt(text, row_num, col_num, choice);
        System.out.println("Encryption: "+ cipher_text);
    }
}
