//server2.java

import java.net.*;
import java.io.*;
import java.util.*;
public class server2 extends Thread
{
public static void main(String[] args) throws Exception
{ 
ServerSocket sSocket = new ServerSocket(1000);
Socket cSocket=sSocket.accept();
BufferedReader br=new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
PrintWriter out=new PrintWriter(cSocket.getOutputStream(),true);
Date d = new Date();
try
	{
	while(true)
	{
	d= new Date();
out.println("Time at server;" +d.toString());
System.out.println(br.readLine());
sleep(1000);
}
}
catch(IOException e)
	{
System.out.println("----Client has Closed-----");
	}
}
}
//*******************************************************
//client2.java
import java.net.*;
import java.io.*;
public class client2
{
public static void main (String[] arg) throws Exception
{
try
{

Socket s=new Socket(InetAddress.getLocalHost(),1000);
BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
String input;
PrintWriter out=new PrintWriter(s.getOutputStream(),true);
while((input=br.readLine())!=null)
{
System.out.println(input);
out.println("Date and Time Received-----------client Acknowledge------");
}
}
catch(Exception e)
	{
	}
}
}


