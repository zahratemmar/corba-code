package testapp;

/**
* testapp/dataHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Test1.idl
* Saturday, October 19, 2024 1:57:06 PM CEST
*/

public final class dataHolder implements org.omg.CORBA.portable.Streamable
{
  public testapp.data value = null;

  public dataHolder ()
  {
  }

  public dataHolder (testapp.data initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = testapp.dataHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    testapp.dataHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return testapp.dataHelper.type ();
  }

}