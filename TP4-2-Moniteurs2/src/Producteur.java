public class Producteur implements Runnable{
    BAL bal;
    
    public Producteur(BAL bal) {
        this.bal = bal;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                int i;
                String lettres[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","*"};
                for (i=0; i <= lettres.length; i++) {
                    boolean added = bal.deposer(lettres[i]);
                    if (added) {
                        System.out.println("[" + Thread.currentThread().getName() +  "]" + 
                                            "[" + bal.getStock() +  "] je livre la lettre : " + lettres[i]) ;
                    }  else {
                        System.out.println("[" + Thread.currentThread().getName() +  "]" + 
                                            "[" + bal.getStock() +  "] la boite aux lettre est pleine.") ;
                    }
                }
            }
        } catch (InterruptedException e) {
            }   

    }
}
