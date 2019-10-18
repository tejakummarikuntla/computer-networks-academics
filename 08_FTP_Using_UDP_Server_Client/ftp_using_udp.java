//ftp using udp
//server5.java
import java.net.*;
import java.io.*;
public class server5
{
            public static void main(String args[])throws IOException
            {
                        byte b[]=new byte[3072];
                        DatagramSocket dsoc=new DatagramSocket(1000);
                        FileOutputStream f=new FileOutputStream("D:/nandha.txt");
                        while(true)
                        {
                                    DatagramPacket dp=new DatagramPacket(b,b.length);
                                    dsoc.receive(dp);
                                    System.out.println(new String(dp.getData(),0,dp.getLength()));                             

                        }
            }
}

//client5.java
import java.net.*;
import java.io.*;
public class client5
{
            public static void main(String args[])throws Exception
            {         
                        byte b[]=new byte[1024];
                        FileInputStream f=new FileInputStream("D:/divya.txt");
                        DatagramSocket dsoc=new DatagramSocket(2000);
                        int i=0;
                        while(f.available()!=0)
                        {
                                    b[i]=(byte)f.read();
                                    i++;
                        }                     
                        f.close();
                        dsoc.send(new DatagramPacket(b,i,InetAddress.getLocalHost(),1000));
            }

}

