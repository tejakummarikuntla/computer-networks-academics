//smtpserver.java
import java.io.*;
import java.net.*;
class smtpserver
{
public static void main(String args[])
{
try
{
ServerSocket ss=new ServerSocket(8080);
Socket s=ss.accept();
ServiceClient(s);
}
catch(Exception e)
{
System.out.println("Exception caught in main:"+e);
}
}
public static void ServiceClient (Socket s)throws Exception
{
try
{
DataInputStream dis=null;
PrintStream ps=null;
dis=new DataInputStream(s.getInputStream());
ps=new PrintStream(s.getOutputStream());
FileWriter f=new FileWriter("abc.eml");
String tel=dis.readLine();
if(tel.equals("ready"))
System.out.println("ready signal received from client: client accepted");
ps.println("enter the from address:");
String from=dis.readLine();
f.write("from: "+from+"\n");
ps.println("enter the to address");
String to=dis.readLine();
f.write("to:"+to+"\n");
ps.println("enter the message");
while(true)
{
String msg=dis.readLine();
System.out.println(msg);
f.write("\n");
f.write("message:"+msg+"\n");
if(msg.equals("quit")) break;
}
f.close();
}
catch(Exception e)
{
System.out.println("Exception caught:"+e);
}
}
}

//smtpclient.java
import java.io.*;
import java.net.*;
class smtpclient
{
public static void main(String args[])throws Exception
{
try
{
Socket s=new Socket("LocalHost",8080);
DataInputStream dis=new DataInputStream(s.getInputStream());
DataInputStream in=new DataInputStream(System.in);
PrintStream ps=new PrintStream(s.getOutputStream());
ps.println("ready");
String fa=dis.readLine();
System.out.println(fa);
String strf=in.readLine();
ps.println(strf);
String ta=dis.readLine();
System.out.println(ta);
String strt=in.readLine();
ps.println(strt);
String ms=dis.readLine();
System.out.println(ms);
while(true)
{
String msg=in.readLine();
ps.println(msg);
if(msg.equals("quit"))                                                              
{
System.out.println("message is delivered to server and client quits");
break;
}
}
}
catch(Exception e)
{
System.out.println("Exception caught in main:" +e);
}
}
}
