/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp;
import static java.lang.Thread.sleep;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORB;

/**
 *
 * @author ZAHRA
 */
public class Test1Impl extends Test1POA {
    Semaphore access = new Semaphore(1,true);
    private ORB orb;
    private int nbrPlayers = 0;
    private ArrayList<Room> matches = new ArrayList<Room>();
    private static ArrayList<int[]> cnx=new ArrayList<int[]>();
    private int temp;
    private int idcounter = 0;
    private cnxCheck cc=new cnxCheck();
    Semaphore sem = new Semaphore(0);

    public void setORB(ORB orb_val) {
        orb = orb_val;
        cc.start();
    }

    @Override
    public matchData matchMe() {
        System.out.println(".....................................");
        idcounter += 1;
        int id = idcounter;
        int k = 0;
        if (nbrPlayers == 0) {
            k = 1;
            try {
                nbrPlayers += 1;
                temp = id;
                sem.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(Test1Impl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            matches.add(new Room(id, temp));
            sem.release();
            temp = 0;
            nbrPlayers = 0;
        }
        /*
         * for (Room m : matches){
         * System.out.println("id = "+m.playerCouples[0]+"  opponent = "+m.playerCouples
         * [1]);
         * 
         * }
         */
        int[] ar={id,timeStamp()};
        System.out.println("arrrr ---------------------------  "+ar[0]+"  "+ar[1]);
        cnx.add(ar);
        return new matchData(k, id);

    }

    @Override
public data movePeice(data d) {
       // System.out.println("hi-------------------------------------------------------------------");
    Room ms = null;
    int opponent = 0;
        System.out.println("data received"+d.id+" played "+d.px+" "+d.py+" ------>"+d.mx+" "+d.my);
    try {
        
        ms = search(d.id);
        //System.out.println("room is "+ms.playerCouples[0]+" "+ms.playerCouples[1]);
        if (ms == null) {
            System.out.println("No matching room found for player with id: " + d.id);
            return new data(-1, -1,-1,-1,-1,false); // Return error if no match
        }
        opponent = (ms.playerCouples[0] == d.id) ? ms.playerCouples[1] : ms.playerCouples[0];
        if (d.px == -1) {
            // Get last move if it's the opponent's turn
            ms.update.acquire();
            if(ms.lastPiece[0]==-1){
                ms.update.release();
            }
            System.out.println("data sent after "+ms.lastPiece[0]+" "+ms.lastPiece[1]+" "+ms.lastMove[0]+" "+ms.lastMove[1]);

            return new data( ms.lastPiece[0], ms.lastPiece[1],ms.lastMove[0], ms.lastMove[1], opponent,false);
        } else {
            // Update the last move and piece position
            ms.lastMove[0] = d.mx;
            ms.lastMove[1] = d.my;
            ms.lastPiece[0] = d.px;
            ms.lastPiece[1] = d.py;
            
            //System.out.println("Player with id: " + d.id + " made a move.");

            // Release for the opponent to move
            ms.update.release();
            sleep(50);
            ms.update.acquire();
            if(ms.lastPiece[0]==-1){
                ms.update.release();
            }
            // Don't wait here for opponent's move, just return immediately
            System.out.println("data sent after "+ms.lastPiece[0]+" "+ms.lastPiece[1]+" "+ms.lastMove[0]+" "+ms.lastMove[1]);
            return new data( ms.lastPiece[0], ms.lastPiece[1],ms.lastMove[0], ms.lastMove[1], opponent,false);
        }
    } catch (InterruptedException ex) {
        Logger.getLogger(Test1Impl.class.getName()).log(Level.SEVERE, null, ex);
    }

    return new data(9, 9, 9, 9, 9,false); // Return error data in case of failure
}


    @Override
    public void shutdown() {
        orb.shutdown(false);
    }
    
    
    
    private Room search(int id){
        for (Room m : matches) {
            boolean res = m.findMe(id);
            if (res) {
                return m;
            }
        }
        return null;
    }
    
    
    
    
    public class Room {
        int[] playerCouples = new int[2];
        int[] lastPiece = new int[2];
        int[] lastMove = new int[2];
        Semaphore update = new Semaphore(0);

        public Room(int a, int b) {
            this.playerCouples[0] = a;
            this.playerCouples[1] = b;
        }

        public boolean findMe(int id) {
            if (this.playerCouples[0] == id || this.playerCouples[1] == id) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    
    public static int timeStamp(){
    LocalTime myObj = LocalTime.now();
    String s=myObj.toString().replace(":","").replace(".", "");
    return Integer.valueOf(s);
    }
    
    
    
    
    public  class cnxCheck extends Thread {
        public void run() {
            System.out.println("cnxCheck.run() is wornking");
          while(true){
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Test1Impl.class.getName()).log(Level.SEVERE, null, ex);
                }
              int time=timeStamp();
             // System.out.println("time="+time);
           if(cnx.size()!=0){
            for(int i=0;i<cnx.size();i++){
                int[] arr=cnx.get(i);
                                                    try {
                    //System.out.println("                 cnxCheck.run()       " + (time-arr[1]));
                    access.acquire();
                                                        } catch (InterruptedException ex) {
                                                             Logger.getLogger(Test1Impl.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(time-arr[1]>1000){
                    System.out.println("------------------------------------->"+(time-arr[1]));                           

                    try {
                        disconnect(arr,arr[0]);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Test1Impl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                access.release();
              }
            }
          }
        }

        
        
    }
    private void disconnect(int[]arr , int id) throws InterruptedException {
            Room r=search(id);
            System.out.println("disonnect() id = "+id+"room is "+r.playerCouples[0]+" "+r.playerCouples[1]);
            if(r!=null){
               r.lastPiece[0]=-1;
               r.update.release();
               sleep(50);
               r.update.acquire();
               cnx.remove(arr);
               int index=Integer.valueOf(matches.indexOf(r));
                System.out.println("index = "+index);
               matches.remove(index);
            }
        }

    public void update(int id){
        updatecnx l=new updatecnx(id);
        l.start();

    }
    
    
    public class updatecnx extends Thread{
        int id;
        public updatecnx(int idd){
            this.id=idd;
        }
        public void run(){
            //System.out.println("...");
            for(int i=0;i<cnx.size();i++){
                int[] arr=cnx.get(i);
                //System.out.println("arr = "+arr[0]+"   id = "+id);                            
            if(arr[0]==id){
                                                        try {
                access.acquire();
                                            } catch (InterruptedException ex) {
                                                    Logger.getLogger(Test1Impl.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                //System.out.println("in if");
                arr[1]=timeStamp();
                //System.out.println("have access");
               // System.out.println("lost access");
                //System.out.println("                                 update()    "+arr[1]);
                access.release();
                break;
            
            }

        }
        }
    }
  
}
