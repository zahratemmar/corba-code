package testapp;


/**
* testapp/data.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from test1.idl
* Friday, October 11, 2024 5:08:09 PM CEST
*/

public final class data implements org.omg.CORBA.portable.IDLEntity
{
  public int px = (int)0;
  public int py = (int)0;
  public int mx = (int)0;
  public int my = (int)0;
  public int id = (int)0;
  public boolean win = false;

  public data ()
  {
  } // ctor

  public data (int _px, int _py, int _mx, int _my, int _id, boolean _win)
  {
    px = _px;
    py = _py;
    mx = _mx;
    my = _my;
    id = _id;
    win = _win;
  } // ctor

} // class data
