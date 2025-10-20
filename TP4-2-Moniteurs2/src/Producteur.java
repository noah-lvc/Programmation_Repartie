public class Producteur extends Thread{
    BAL bal;
    String bufferContent;
    
    public Producteur(BAL bal, String bufferContent) {
        this.bal = bal;
        this.bufferContent = bufferContent;
    }

    public void run() {
        bal.deposer(bufferContent);
    }
}
