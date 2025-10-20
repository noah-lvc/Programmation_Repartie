import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BAL { 
    BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);

    public boolean deposer(String bufferContent) throws InterruptedException {
        return queue.offer(bufferContent, 200, TimeUnit.MILLISECONDS);
    }

    public String retirer() throws InterruptedException {
        return queue.poll(200, TimeUnit.MILLISECONDS);
    }

    public int getStock() {
        return queue.size() ;
    }
}
