package testapp;

/**
* testapp/matchDataHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from test1.idl
* Friday, October 11, 2024 5:08:09 PM CEST
*/

public final class matchDataHolder implements org.omg.CORBA.portable.Streamable
{
  public testapp.matchData value = null;

  public matchDataHolder ()
  {
  }

  public matchDataHolder (testapp.matchData initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = testapp.matchDataHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    testapp.matchDataHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return testapp.matchDataHelper.type ();
  }

}