/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORB;

/**
 *
 * @author ZAHRA
 */
public class Test1Impl extends Test1POA{
    	private ORB orb;
	private int nbrPlayers=0;
        private ArrayList<MatchStatus> matches = new ArrayList<MatchStatus>();
        private int temp;
        private int idcounter=0;
	  public void setORB(ORB orb_val) {
	    orb = orb_val; 
	  }

    @Override
    public data matchMe() {
       
       idcounter+=1;
        int id=idcounter,k=0;
        if(nbrPlayers==0){
            nbrPlayers+=1;
            temp=id;
            k=1;
            while(temp!=0){
                try {
                    sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Test1Impl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            matches.add(new MatchStatus(new Doubled(temp,id)));
            temp=0;
            nbrPlayers=0;
        }
        int opponent=0;
        for (MatchStatus m : matches){
            boolean res = m.findMe(id);
            if(res=true){
                if(m.playerCouples.a==id){
                    opponent=m.playerCouples.b;
                }else{
                    opponent=m.playerCouples.a;
                }
                break;
            }
        }
        return new data(opponent,k,id);


    }

    
    
    @Override
    public data movePeice(data d) {
               //DO NOT READ THIS !!!!!!! GHADI NBDLH

       /* MatchStatus ms = null;
            int opponent=-1;
            for (MatchStatus m : matches){
                boolean res = m.findMe(d.id);
                if(res=true){
                    ms=m;
                    if(m.playerCouples.a==d.id){
                        opponent=m.playerCouples.b;
                    }else{
                        opponent=m.playerCouples.a;
                    }
                    break;
                }
                System.out.println("---------------------"+ms.playerCouples.a+"    "+ms.playerCouples.b);
        if(d.m==-1){    
            while(ms.update!=true){
                try {
                    sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Test1Impl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            ms.lastMove.a = -1;
            ms.update=false;
            return new data(ms.lastMove.a,ms.lastMove.b,opponent);

            
            
            
            
        }else{
            }
            ms.lastMove.a=d.p;
            ms.lastMove.b=d.m;
            ms.update=true;
            while(ms.lastMove.a != -1){
                try {
                    sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Test1Impl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            while(ms.update!=true){
                try {
                    sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Test1Impl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            ms.lastMove.a = -1;
            ms.update=false;
            return new data(ms.lastMove.a,ms.lastMove.b,opponent);
        }*/
        return new data(0,0,0);


    }

    
    
    
    
    
    
    
    @Override
    public void shutdown() {
        orb.shutdown(false);
    }

         
    
    
    
    
    
    
    
    
    public class MatchStatus {
        Doubled playerCouples;
        Doubled lastMove;
        boolean update;
        
        public MatchStatus(Doubled a ){
            this.playerCouples=a;  
            this.update=false;
            this.lastMove.a=-1;
            this.lastMove.b=-1;
            }
        
        public  boolean findMe(int id){
            if(this.playerCouples.a==id || this.playerCouples.b==id){
                return true;
            }
            else{
                return false;
            }
        }
}
        public class Doubled {
        int a;
        int b;        
        public Doubled(int a ,int b){
            this.a=a; 
            this.b=b;
            }
        
        
}

    
          
          
          
}
