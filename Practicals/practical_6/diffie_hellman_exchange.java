/*
diffie_hellman_exchange.java
Author: Jagrut Gala
Date: 12-08-2021
Practical: 6
Objective: Demonstrate diffie_hellman_exchange
Input: 
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class diffie_hellman_exchange { // just key generation
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

    BigInteger prime1;
    BigInteger prime2;
    
    static BigInteger getBigIntegerNum(String msg) {
        BigInteger num= new BigInteger("0");
        try {
            System.out.print(msg+ ": ");
            num= new BigInteger(br.readLine());
        } catch(Exception err) {
            System.out.println(err);
        }
        return num;
    }

    static boolean isPrime(BigInteger num){
        if(num.isProbablePrime(10)) {
            return true;
        } else {
            return false;
        }
    }

    // static BigInteger powerMod(BigInteger base, BigInteger power, BigInteger div) {
    //     BigInteger result= new BigInteger(Math.pow(base.intValue(), power.intValue()));
    //     return result;
    // }

    public static void main(String[] args){
        BigInteger a, b, x, y, p, g, xa, yb;
        p= getBigIntegerNum("Enter a Prime Number");
        while(!isPrime(p)) {
            System.out.println("Not Prime");
            p= getBigIntegerNum("Enter a Prime Number");
        }
        g= getBigIntegerNum("Enter a Primitive root of "+ p.toString(10));
        // while(!isPrime(g)) {
        //     System.out.println("Not Prime");
        //     g= getBigIntegerNum("Enter a Prime Number");
        // }

        a= getBigIntegerNum("Enter a Number(key for a)");
        x= g.modPow(a, p);
        // x= powerMod(g, a, p);

        b= getBigIntegerNum("Enter a Number(key for b)");
        y= g.modPow(b, p);
        // y= powerMod(g, b, p);


        // xa= powerMod(y, a, p);
        xa= y.modPow(a, p);
        System.out.println("xa: "+ xa);
        // xb= powerMod(x, b, p);
        yb= x.modPow(b, p);
        System.out.println("yb: "+ yb);

        if(xa == yb) {
            System.out.println("Keys are Symmetric: "+ xa);
        }


    }
}
