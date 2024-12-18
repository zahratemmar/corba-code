package testapp;


/**
* testapp/Test1POA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Test1.idl
* Saturday, October 19, 2024 1:57:06 PM CEST
*/

public abstract class Test1POA extends org.omg.PortableServer.Servant
 implements testapp.Test1Operations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("matchMe", new java.lang.Integer (0));
    _methods.put ("movePeice", new java.lang.Integer (1));
    _methods.put ("update", new java.lang.Integer (2));
    _methods.put ("signup", new java.lang.Integer (3));
    _methods.put ("login", new java.lang.Integer (4));
    _methods.put ("getUserStats", new java.lang.Integer (5));
    _methods.put ("updateUserStats", new java.lang.Integer (6));
    _methods.put ("shutdown", new java.lang.Integer (7));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // testapp/Test1/matchMe
       {
         testapp.matchData $result = null;
         $result = this.matchMe ();
         out = $rh.createReply();
         testapp.matchDataHelper.write (out, $result);
         break;
       }

       case 1:  // testapp/Test1/movePeice
       {
         testapp.data d = testapp.dataHelper.read (in);
         testapp.data $result = null;
         $result = this.movePeice (d);
         out = $rh.createReply();
         testapp.dataHelper.write (out, $result);
         break;
       }

       case 2:  // testapp/Test1/update
       {
         int id = in.read_long ();
         boolean $result = false;
         $result = this.update (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // testapp/Test1/signup
       {
         String username = in.read_string ();
         String password = in.read_string ();
         boolean $result = false;
         $result = this.signup (username, password);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 4:  // testapp/Test1/login
       {
         String username = in.read_string ();
         String password = in.read_string ();
         boolean $result = false;
         $result = this.login (username, password);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 5:  // testapp/Test1/getUserStats
       {
         String username = in.read_string ();
         String $result = null;
         $result = this.getUserStats (username);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }


  // New method to get user stats
       case 6:  // testapp/Test1/updateUserStats
       {
         String username = in.read_string ();
         int wins = in.read_long ();
         int draws = in.read_long ();
         int losses = in.read_long ();
         this.updateUserStats (username, wins, draws, losses);
         out = $rh.createReply();
         break;
       }


  // New method to update user stats
       case 7:  // testapp/Test1/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:testapp/Test1:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Test1 _this() 
  {
    return Test1Helper.narrow(
    super._this_object());
  }

  public Test1 _this(org.omg.CORBA.ORB orb) 
  {
    return Test1Helper.narrow(
    super._this_object(orb));
  }


} // class Test1POA
