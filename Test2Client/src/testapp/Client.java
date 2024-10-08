package testapp;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
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
                    System.out.println("u have been paired . your id = "+result.px);
                    id=result.px;
                    if(result.py==0){
                        System.out.println("it's your opponent turn to play");
                        result=obj.movePeice(new data(-1,-1,-1,-1,id));
                        System.out.println("result === "+result.mx+"   "+result.my);
                    }
                    
                    while(true){
                        result = playTurn();
                        System.out.println("result === "+result.mx+"   "+result.my);

                    }
	       }
	       catch (Exception e) {
	          System.out.println("Hello Client exception: " + e);
		  e.printStackTrace();
	       }
	}
        public static data playTurn(){
                        System.out.println("it's your turn to play");
                        data value =new data();
                        value.mx= myObj.nextInt(); 
                        value.px= myObj.nextInt();
                        value.my=value.mx;
                        value.py=value.px;
                        value.id=id;
                        data result=obj.movePeice(value);
                        return result;
        }

}
