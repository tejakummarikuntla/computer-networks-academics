 //Client
 
 import java.lang.*;
 import java.net.*;
 import java.io.*;

 public class UdpClient{
     public static void main(String args[]) throws Exception
     {
         //Socket for communication
         DatagramSocket dSocket = new DatagramSocket();

         //IP Address of the System
         InetAddress ipAdd = InetAddress.getLocalHost();

         //Data to send
         int sendData = 8;
         byte[] sendDataBytes = String.valueOf(sendData).getBytes();

         //Datagram pack for sending
         DatagramPacket dpSend = new DatagramPacket(sendDataBytes, sendDataBytes.length,ipAdd,9999);
         //Sending Data
         dSocket.send(dpSend);

         //Receiving the Data
         byte[] reciveData = new byte[1024];
         DatagramPacket dpRecive = new DatagramPacket(reciveData, reciveData.length);
         dSocket.receive(dpRecive);

         //Taking the Data recived
         String recivedData = new String(dpRecive.getData(),0,dpRecive.getLength());
         System.out.println("Result: "+ recivedData);

     }

 }
 
 // Server
 
  import java.lang.*;
 import java.net.*;
 import java.io.*;

 public class UdpServer{
     public static void main(String args[]) throws Exception
     {
         DatagramSocket dSocket = new DatagramSocket(9999);
                  //IP Address of the System
          InetAddress ipAdd = InetAddress.getLocalHost();

         //Receving the data
          byte[] reciveData = new byte[1024];
          DatagramPacket dpRecive = new DatagramPacket(reciveData, reciveData.length);
          dSocket.receive(dpRecive);

          //Taking the Data
          String rData = new String(dpRecive.getData(),0,dpRecive.getLength());
          int rDataNum = Integer.parseInt(rData.trim());
          int result = rDataNum * rDataNum;

         byte[] sendDataBytes = String.valueOf(result).getBytes();

          //Datagram pack for sending
          DatagramPacket dpSend = new DatagramPacket(sendDataBytes, sendDataBytes.length,ipAdd,dpRecive.getPort());          //Sending Data
          dSocket.send(dpSend);
     }
 }
