package testapp;


/**
* testapp/Test1POA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Test1.idl
* Wednesday, October 9, 2024 6:14:12 PM CEST
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
    _methods.put ("shutdown", new java.lang.Integer (2));
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

       case 2:  // testapp/Test1/shutdown
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
