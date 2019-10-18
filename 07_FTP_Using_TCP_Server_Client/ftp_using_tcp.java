//ftpserver.java

import java.io.*;
import java.net.*;
public class ftpserver extends Thread
{
public static void main(String args[]) throws Exception
{
ServerSocket ss=new ServerSocket(4000);
Socket s=ss.accept();
String f1,data="",tmp="";
try
{
BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter the file name to open");
f1=in.readLine();
PrintWriter out=new PrintWriter(s.getOutputStream(),true);
File f=new File(f1);
if(f.isFile()&&f.canRead())
{
BufferedReader br=new BufferedReader(new FileReader(f1));
while((tmp=br.readLine())!=null)
data=data+tmp+"\n";
}
else
data="error in input file";
out.println(data);
}
catch(Exception e)
{}
}
}

//ftpclient.java

import java.io.*;
import java.net.*;
public class ftpclient
{
public static void main(String args[])throws Exception
{
Socket s= new Socket(InetAddress.getLocalHost(),4000);
BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
String tmp;
try
{
while((tmp=in.readLine())!=null)
System.out.println(tmp);
}
catch(Exception e)
{}
}
}


