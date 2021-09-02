import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class rsa {
    /*
    P & Q = prime numbers
    n = part of first key = P*Q
    e = exponent = small integer not a factor of n = public key
    k = random integer
    d = private key
    d = (k*Φ(n) + 1) / e
    Φ(n) = (P-1)(Q-1)
    */

    boolean isPrime(int num) {
        for(int i=0; i< num/2; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int gcd(int a, int b)
    {
    if (b == 0)
        return a;
    return gcd(b, a % b);
    }

    static int getExponent(int n, int limit) {
        int e= 2;
        for(e=2; e< limit; e++) {
            if(gcd(e, n)== 1) {
                break;
            }
        }
        return e;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int P, Q, n, e, k, on, d;

        System.out.print("Enter a prime number: ");
        P= Integer.valueOf(br.readLine());
        System.out.print("Enter a prime number: ");
        Q= Integer.valueOf(br.readLine());
        n= P * Q;
        on= (P-1)* (Q-1);
        e= getExponent(n, on);

    }
}