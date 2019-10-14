//cchatserver.java

import java.net.*;
import java.io.*;
import java.util.*;
public class cchatserver extends Thread
{
public static void main(String arg[])throws Exception
{
ServerSocket ssocket=new ServerSocket(4000);
Socket csocket=ssocket.accept();
BufferedReader br=new BufferedReader(new InputStreamReader(csocket.getInputStream()));
BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
PrintWriter out=new PrintWriter(csocket.getOutputStream(),true);
String s,t;
try
{
while(true)
{
System.out.println(&quot;server&quot;);
s=in.readLine();
out.println(&quot;server:&quot;+s);
System.out.println(br.readLine());
}
}
catch(IOException e)
{
System.out.println(&quot;client has closed&quot;);
}
}
}


\\cchatclient.java
import java.net.*;
import java.io.*;
public class cchatclient
{
public static void main(String arg[])throws Exception
{
Socket s=new Socket(InetAddress.getLocalHost(),4000);
BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
PrintWriter out=new PrintWriter(s.getOutputStream(),true);
String input,t;
while(true)
{
System.out.println(&quot;client&quot;);
out.println(&quot;client:&quot;+in.readLine());
System.out.println(br.readLine());
}
}
}
