public class Consomateur implements Runnable{
    BAL bal;
    String content = null;
    
    public Consomateur(BAL bal) {
        this.bal = bal;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                String content = bal.retirer();

                if (content != null)  {
                    System.out.println("[" + Thread.currentThread().getName() +  "]" + 
                    "[" + bal.getStock() +  "] contenu de la lettre : " + content) ;
                }  else {
                    System.out.println("[" + Thread.currentThread().getName() +  "]" + 
                                        "[" + bal.getStock() +  "] la boite aux lettre est vide.") ;
                }
            }
        }  catch (InterruptedException e) {
            }
    }
}
 