package basics;

public class Program_46 {
    public static boolean isprime(int n) {
    	boolean isPrime = true;
    	for(int i=2 ; i <= n-1 ; i++) {
    		if(n%i==0) {
    			boolean isprime = false;
    			break;
    		}
    	}
    	
		return isPrime;
    	
    }
	public static void main(String[] args) {
		System.out.println(isprime(12));

	}

}
