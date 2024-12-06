package testapp;


/**
* testapp/matchDataHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Test1.idl
* Saturday, October 19, 2024 1:57:06 PM CEST
*/

abstract public class matchDataHelper
{
  private static String  _id = "IDL:testapp/matchData:1.0";

  public static void insert (org.omg.CORBA.Any a, testapp.matchData that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static testapp.matchData extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [2];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "k",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[1] = new org.omg.CORBA.StructMember (
            "id",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (testapp.matchDataHelper.id (), "matchData", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static testapp.matchData read (org.omg.CORBA.portable.InputStream istream)
  {
    testapp.matchData value = new testapp.matchData ();
    value.k = istream.read_long ();
    value.id = istream.read_long ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, testapp.matchData value)
  {
    ostream.write_long (value.k);
    ostream.write_long (value.id);
  }

}
