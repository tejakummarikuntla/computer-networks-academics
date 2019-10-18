//udpserver.java
import java.net.*;
import java.io.*;
public class udpserver
{
public static int client=789;
public static int server=790;
public static void main(String arg[]) throws IOException
{
String s;
InetAddress id=InetAddress.getLocalHost();
BufferedReader dis=new BufferedReader(new InputStreamReader(System.in));
DatagramSocket ds=new DatagramSocket(server);
byte b[]=new byte[1024];
System.out.println("Server Side.... Sending....");
System.out.println("\n"+id);
while(true)
{
s=dis.readLine();
if(s.equals("end"))
{
b=s.getBytes();
DatagramPacket dp=new DatagramPacket(b,s.length(),id,client);
ds.send(dp);
break;
}
else
{
b=s.getBytes();
DatagramPacket dp=new DatagramPacket(b,s.length(),id,client);
ds.send(dp);
}
}


//udpclient.java
import java.net.*;
import java.io.*;
public class udpclient
{
public static int client=789;
public static void main(String args[]) throws IOException
{
DatagramSocket ds=new DatagramSocket(client);
byte b[]=new byte[1024];
System.out.println("client....receiving....");
while(true)
{
DatagramPacket dp=new DatagramPacket(b,b.length);
ds.receive(dp);
String s=new String(dp.getData(),0,dp.getLength());
if(s.equals("end")) break;
else System.out.println(s);
}
}
}
 

}
}


