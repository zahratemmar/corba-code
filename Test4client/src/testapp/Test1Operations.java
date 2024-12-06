package testapp;


/**
* testapp/Test1Operations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Test1.idl
* Saturday, October 19, 2024 1:57:06 PM CEST
*/

public interface Test1Operations 
{
  testapp.matchData matchMe ();
  testapp.data movePeice (testapp.data d);
  boolean update (int id);
  boolean signup (String username, String password);
  boolean login (String username, String password);
  String getUserStats (String username);

  // New method to get user stats
  void updateUserStats (String username, int wins, int draws, int losses);

  // New method to update user stats
  void shutdown ();
} // interface Test1Operations
