package initial_sources;


/**
 * Approximates PI using the Monte Carlo method.  Demonstrates
 * use of Callables, Futures, and thread pools.
 */
public class Pi 
{
    public static void main(String[] args) throws Exception 
    {
		for (int i=0;i<10;i++){
			long total=0;
			// 10 workers, 50000 iterations each
			total = new Master().doRun(1000000, 8);
			System.out.println("total from Master = " + total);
		}
		
	}
}
