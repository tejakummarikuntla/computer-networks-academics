//checksum
//Server.java
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.zip.*;
import java.lang.*;

public class Server extends Thread
{
public static void main(String[] args) throws Exception
    {
		try
		{
			ServerSocket sSocket=new ServerSocket(1000);
			Socket cSocket=sSocket.accept();
			BufferedReader br=new BufferedReader(new 		InputStreamReader(cSocket.getInputStream()));
			PrintWriter out=new PrintWriter(cSocket.getOutputStream(),true);
			String str1,str2;
			str2=br.readLine();
			System.out.println("INCOMING DATA : " + str2);
			StringTokenizer s=new StringTokenizer(str2,"$");
			CRC32 c=new CRC32();
			str1=s.nextToken();
			for(int i=0;i<s.countTokens()+2;i++)
			{
				System.out.println(str1);
				c.update(str1.getBytes());
				str1=s.nextToken();
			}
			System.out.println(str1);
			c.update(str1.getBytes());
			
			long rCRC=Long.parseLong(br.readLine()),cCRC=c.getValue();
			System.out.println("rCRC = " + rCRC);
			System.out.println("cCRC = " + cCRC);
			if(rCRC==cCRC)
			{
				out.println("CRC Check successful...");
				System.out.println("CRC Check successful...");
			}
			else
			{
				out.println("CRC Check un-successful...");
				System.out.println("CRC Check un-successful...");
			}
		}
		catch(Exception e){}
    }
}

//Client.java


import java.net.*;
import java.io.*;
import java.lang.*;
import java.util.zip.*;

public class Client
{
public static void main(String[] args) throws Exception
    {
		try
		{
			Socket s=new Socket(InetAddress.getLocalHost(),1000);
			BufferedReader br=new BufferedReader(new 	InputStreamReader(s.getInputStream()));
			PrintWriter out=new PrintWriter(s.getOutputStream(),true);
			String data="";
			CRC32 c=new CRC32();
			
			for(int i=0;i<args.length;i++)
			{
				System.out.println(args[i]);
				c.update(args[i].getBytes());
				data=data+args[i]+"$";
			}
			
			System.out.println(data);
			System.out.println("CRC = " + c.getValue());
			out.println(data);
			out.println(c.getValue());
			System.out.println(br.readLine());
		}
		catch(Exception e){}
    }
}



