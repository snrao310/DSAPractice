/**
 * Created by S N Rao on 4/25/2017.
 *
 * Count the number of prime numbers less than a non-negative number, n.
 *
 */
public class CountPrimesLeetCode {

    //Sieve of Eratosthenes. To understand, see the gif on wikipedia (https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes)
    public static int countPrimes(int n) {
        int count=0;
        boolean[] notPrime=new boolean[n];
        for(int i=2;i<n;i++){
            if(!notPrime[i]){
                count++;
                for(int j=2;i*j<n;j++)
                    notPrime[i*j]=true;
            }
        }
        return count;
    }

    public static void main(String args[]){
        System.out.println(countPrimes(16)); //6
    }
}
