public class MainTp4 {

    public static void main(String[] args){

        BAL bal = new BAL();

        Consomateur cons = new Consomateur(bal);
        Producteur prodA = new Producteur(bal, "aaa");    
        Producteur prodB = new Producteur(bal, "bbb");    
        Producteur prodC = new Producteur(bal, "ccc");    
        Producteur prodD = new Producteur(bal, "ddd");    

        
        prodA.start();
        prodB.start();
        
        cons.start();        

        prodC.start();
        prodD.start();

    }
}
 