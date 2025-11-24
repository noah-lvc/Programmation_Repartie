// Estimate the value of Pi using Monte-Carlo Method, using parallel program
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
class PiMonteCarlo {
	AtomicInteger nAtomSuccess; //AtomicInteger : valeur protégée
	int nThrows;
	double value;
	class MonteCarlo implements Runnable {
		@Override
		public void run() {
			//Une seule itération de la boucle T1i
			double x = Math.random();
			double y = Math.random();
			if (x * x + y * y <= 1)
				nAtomSuccess.incrementAndGet(); //c_cible++ (ressource critique)
		}
	}
	public PiMonteCarlo(int i) {
		this.nAtomSuccess = new AtomicInteger(0); //n_cible
		this.nThrows = i; //n_total
		this.value = 0; //pi
	}
	public double getPi(int nProcessors) {
		//int nProcessors = Runtime.getRuntime().availableProcessors(); 
		ExecutorService executor = Executors.newWorkStealingPool(nProcessors);
		for (int i = 1; i <= nThrows; i++) {
			Runnable worker = new MonteCarlo();
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		value = 4.0 * nAtomSuccess.get() / nThrows; //pi=4*n_cible/t_total
		return value;
	}
}
public class Assignment102 {
	public static void main(String[] args) {
		int n_tot = 1000011600;
		int p = 1;
		for (int i=0;i<5;i++){
			PiMonteCarlo PiVal = new PiMonteCarlo(n_tot);
			long startTime = System.currentTimeMillis();
			double value = PiVal.getPi(p);
			long stopTime = System.currentTimeMillis();
			System.out.println("Approx value:" + value);
			System.out.println("Difference to exact value of pi: " + (value - Math.PI));
			System.out.println("Error: " + (value - Math.PI) / Math.PI * 100 + " %");
			System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
			System.out.println("Time Duration: " + (stopTime - startTime) + "ms");
			
			try(
				FileWriter fw = new FileWriter("test_times.txt", true);
				PrintWriter pw = new PrintWriter(fw)) {
					pw.println(n_tot + " " + p + " " + (stopTime - startTime));
				} catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}
}