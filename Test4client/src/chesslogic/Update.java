/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chesslogic;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import testapp.Client;
import static testapp.Client.obj;
import testapp.Test1;
import testapp.Test1Helper;

/**
 *
 * @author ZAHRA
 */
public class Update extends Thread{
    public static Test1 obj;
    static int id;

         public static void main(String[] args,int idd) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {
            ORB orb = ORB.init(args, null);
            id=idd;
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            obj = (Test1) Test1Helper.narrow(ncRef.resolve_str("ABC"));
            Update up = new Update();
            up.start();
         }
        public void run(){
            while(true){
            obj.update(id);
            try {
                sleep(400);
            } catch (InterruptedException ex) {
                Logger.getLogger(ChessGame.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
        }
}
