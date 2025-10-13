public class Consomateur extends Thread{
    BAL bal;
    String bufferContent = null;
    
    public Consomateur(BAL bal) {
        this.bal = bal;
    }

    public void run() {
        this.bufferContent = bal.retirer();
    }
}
 