public class MainTp42 {

    public static void main(String[] args){

        final BAL bal = new BAL();

        Producteur prod = new Producteur(bal);
        Consomateur cons = new Consomateur(bal);

        Thread threadProd = new Thread(prod);
        Thread threadCons = new Thread(cons);
        
        threadProd.start();
        threadCons.start();    
    }
}
 