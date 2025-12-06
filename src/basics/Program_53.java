package basics;

public class Program_53 {
	public static void hi(int n) {
		//outer loop
    for(int i=1;i<=n;i++) {
    	for(int j=1;j<=n-i+1;j++) {
    		System.out.print(j+"");
    	}
    	System.out.println();
    }
	}

	public static void main(String[] args) {
	    hi(9);

	}

}
