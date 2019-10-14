//Client

 import java.net.*;
 import java.io.*;

 class SocClient
  {
      public static void main(String args[]) throws Exception
      {
          String ip = "localhost";
          int port = 9999;
          Socket s = new Socket(ip, port);

          String name = InetAddress.getLocalHost().toString();

          OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
          PrintWriter pw = new PrintWriter(os);
          os.write(name);
          os.flush();
      }
  }
  
  // Server
  
 import java.net.*;
 import java.io.*;

 public class SocServer {

     public static void main(String[] args) throws Exception
     {
         System.out.println("Server is Started");
         ServerSocket ss = new ServerSocket(9999);

         System.out.println("Server is waitin for client request");
         Socket s = ss.accept();

         System.out.println("Client Connected");

         //For Fetching the Data.
         BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
         String str =  br.readLine();

         System.out.println("client Data: " + str);

     }

 }
