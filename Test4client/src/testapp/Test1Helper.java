package testapp;


/**
* testapp/Test1Helper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Test1.idl
* Saturday, October 19, 2024 1:57:06 PM CEST
*/

abstract public class Test1Helper
{
  private static String  _id = "IDL:testapp/Test1:1.0";

  public static void insert (org.omg.CORBA.Any a, testapp.Test1 that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static testapp.Test1 extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (testapp.Test1Helper.id (), "Test1");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static testapp.Test1 read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_Test1Stub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, testapp.Test1 value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static testapp.Test1 narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof testapp.Test1)
      return (testapp.Test1)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      testapp._Test1Stub stub = new testapp._Test1Stub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static testapp.Test1 unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof testapp.Test1)
      return (testapp.Test1)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      testapp._Test1Stub stub = new testapp._Test1Stub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
