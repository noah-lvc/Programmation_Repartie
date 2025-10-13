public class BAL { // BAL est un moniteur
    private String buffer = null;
    private Boolean avalaible = true;

    public synchronized void deposer(String bufferContent){
        while(avalaible == false) {
            try {
                wait();
            } catch(InterruptedException e) { }
        }
        this.buffer = bufferContent;
        System.out.println("Buffer Déposé : " + bufferContent);
        avalaible = false;
        notifyAll();    
    }

    public synchronized String retirer() {
        String contenu = this.buffer;
        while(avalaible == true) {
            try {
                wait();
            } catch(InterruptedException e) { }            
        }
        System.out.println("Contenu Buffer : " + this.buffer);
        avalaible = true;
        notifyAll();
        return contenu;
    }
}
