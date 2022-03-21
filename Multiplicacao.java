import java.util.*;

import java.math.*;

public class Multiplicacao {
    public static void main(String[] args){
        BigInteger a = new BigInteger("12"); 
        BigInteger b = new BigInteger("12");

        int N = Math.max(a.toString().length(), b.toString().length());
        N = (N / 2) + (N % 2);

        System.out.println(multp_padrao(a, b, N));
        System.out.println(karatsuba(a, b, N));
    }

    static BigInteger multp_padrao(BigInteger A, BigInteger B, int N){
        if(N > 1){
            
            BigInteger ten_n = BigDecimal.valueOf(Math.pow(10, N)).toBigInteger();
            //System.out.println("tenn2 " + ten_n);
            BigInteger A1 = A.divide(ten_n);
            BigInteger A0 = A.mod(ten_n);
            BigInteger B1 = B.divide(ten_n);
            BigInteger B0 = B.mod(ten_n);
            
            //System.out.println(A1 + "\t" + A0 + "\t" + B1 + "\t" + B0 + "\n");
            
            
            //sub-expressions
            BigInteger A1B1 = multp_padrao(A1, B1, N/2);
            BigInteger A1B0 = multp_padrao(A1, B0, N/2);
            BigInteger A0B1 = multp_padrao(A0, B1, N/2);
            BigInteger A0B0 = multp_padrao(A0, B0, N/2);

            BigInteger ten_n2 = BigDecimal.valueOf(Math.pow(10, N / 2)).toBigInteger();
            BigInteger first = ten_n.multiply(A1B1);
            BigInteger second = ten_n2.multiply(A1B0);
            BigInteger third = ten_n2.multiply(A0B1);
            BigInteger forth = A0B0;
            return first.add(second).add(third).add(forth);
        }
        else{
            return A.multiply(B);
        }
    }

    static BigInteger karatsuba(BigInteger A, BigInteger B, int N){
        if(N > 1){

            BigInteger ten_n = BigDecimal.valueOf(Math.pow(10, N)).toBigInteger();
            //System.out.println("tenn2 " + ten_n);
            BigInteger A1 = A.divide(ten_n);
            BigInteger A0 = A.mod(ten_n);
            BigInteger B1 = B.divide(ten_n);
            BigInteger B0 = B.mod(ten_n);

            BigInteger A1B1 = karatsuba(A1, B1, N / 2);
            BigInteger A0B0 = karatsuba(A0, B0, N / 2);
            BigInteger M3 = karatsuba(A1.add(A0), B1.add(B0), N / 2);

            BigInteger ten_n2 = BigDecimal.valueOf(Math.pow(10, N / 2)).toBigInteger();
            BigInteger first = ten_n.multiply(A1B1);
            BigInteger second = M3.subtract(A1B1).subtract(A0B0);
            BigInteger third = ten_n2.multiply(second);
            
            return first.add(third).add(A0B0);
        }
        else{
            return A.multiply(B);
        }
    }
}
