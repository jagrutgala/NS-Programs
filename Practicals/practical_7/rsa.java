/*
rsa.java
Author: Jagrut Gala
Date: 26-08-2021
Practical: 7
Objective: Demonstarte RSA
*/

import java.security.*;
import java.math.*;

public class rsa 
{
    public static void main(String[] args) 
    {
        SecureRandom r;
        BigInteger p,q,p1,q1,n,n1,e,d,msg,ct,pt;
        int bitLength = 512;
        int certinity = 100;
        r = new SecureRandom();

        //Step1: Generate prime number p & q
        p = new BigInteger(bitLength,certinity,r);
        q = new BigInteger(bitLength,certinity,r);

        //Step2: n = p * q
        n = p.multiply(q);

        System.out.println("Prime Number P is: " + p.intValue());
        System.out.println("Prime Number Q is: " + q.intValue());
        System.out.println("n = p * q is: " + n.intValue());

        //Step3: Generating Punlic Key (E)
        p1 = p.subtract(new BigInteger("1"));
        q1 = q.subtract(new BigInteger("1"));
        n1 = p1.multiply(q1);
        e = new BigInteger("2");

        while (n1.gcd(e).intValue() > 1 || e.compareTo(p1) != -1)
        {
            e = e.add(new BigInteger("1"));
        }

        System.out.println("Public Key is (" + n.intValue() + "," + e.intValue() + ")");

        //Step4: D = E ^ -1 mod(P-1)(Q-1)
        d = e.modInverse(n1);
        System.out.println("Private Key is (" + n.intValue() + "," + d.intValue() + ")");

        //Step5: Encryption CT = (PT) ^ e mod n
        msg = new BigInteger("42");
        ct = msg.modPow(e, n);
        System.out.println("Encrypted Text is: " + ct.intValue());

        pt = ct.modPow(d, n);
        System.out.println("Decrypted Text is: " + pt.intValue());
    }
}
