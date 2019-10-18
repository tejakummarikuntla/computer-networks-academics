//TelnetServer.java

import java.lang.*;
import java.io.*;
import java.net.*;

class TelnetServer {
   public static void main(String args[]) {
      String data = "Hello Client!! ";
      try {
          // Create object of Server Socket 
         ServerSocket srvr = new ServerSocket(8088);
          // Socket object that listens the port (8088) and accepts the incoming connection
          //requests 
         Socket skt = srvr.accept();
         System.out.println("Client Connected!");
         // gets output stream object  
         PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
         //gets input stream object    
         DataInputStream din=new DataInputStream(skt.getInputStream());        
         if(din.readUTF().equals("1")){ 
         // sends response to incoming request if command is '1'    

         System.out.println("String: '" + data);
         out.print(data);
         }
         out.close();// clos out
         skt.close();// close skt
         srvr.close();// close srvr
         din.close(); // close din
      }
      catch(Exception e) {
         System.out.print(e);
      }
   }
}


//TelnetClient.java

import java.net.*;
import java.io.*;

class TelnetClient
{
    public static void main(String args[]) throws Exception
    {
        //Create object of Socket
        Socket soc=new Socket("localhost",8088);
        String Command;
        //Create object of Input Stream to read from socket
        DataInputStream din=new DataInputStream(soc.getInputStream());    
        //Create object of Output Stream  to write on socket 
        DataOutputStream dout=new DataOutputStream(soc.getOutputStream());
        // Object of Buffered Reader to read command from terminal
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Telnet Client");
        System.out.println("< Telnet Prompt >");
        Command=br.readLine();//reads the command 
        dout.writeUTF(Command);//sends command to server
        System.out.println(din.readLine()); //gets the response of server        
        soc.close();  //close port  
        din.close();  //close input stream      
        dout.close(); //close output stream      
        br.close();  //close buffered Reader    
    }
}
