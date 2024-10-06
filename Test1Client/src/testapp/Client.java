package testapp;
import java.util.Scanner;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class Client {
        static Scanner myObj= new Scanner(System.in); 
        static int id;
        static Test1 obj;
    	public static void main(String[] args) {
            try {
		    ORB orb = ORB.init(args, null);
		    org.omg.CORBA.Object objRef =   orb.resolve_initial_references("NameService");
		    NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
		     obj = (Test1) Test1Helper.narrow(ncRef.resolve_str("ABC"));
	            System.out.println("Welcome to chess game . wait to be paired with a player");          		    
                    data result=obj.matchMe();
                    System.out.println("u have been paired . your id = "+result.p);
                   /* id=result.p;
                    if(result.m==0){
                        System.out.println("it's your opponent turn to play");
                        obj.movePeice(new data(-1,-1,id));
                    }else{
                        result = playTurn();
                    }
                    while(true){
                        System.out.println("ur opponent played :"+result.p+" to "+result.m);
                        result = playTurn();
                    }*/
	       }
	       catch (Exception e) {
	          System.out.println("Hello Client exception: " + e);
		  e.printStackTrace();
	       }
	}
      /*  public static data playTurn(){
                        System.out.println("it's your turn to play");
                        data value =new data();
                        value.p= myObj.nextInt(); 
                        value.m= myObj.nextInt(); 
                        value.id=id;
                        data result=obj.movePeice(value);
                        return result;
        }*/

}
