/**
 * Approximates PI using the Monte Carlo method.  Demonstrates
 * use of Callables, Futures, and thread pools.
 */
public class Pi 
{
    public static void main(String[] args) throws Exception 
    {
	long total=0;
	int tot = 500000;
	;
	int worker = 8;
	for (int i=0; i<5;i++) {
		total = new Master().doRun(tot, worker);
		System.out.println("total from Master = " + total);
    	}
	}
}

