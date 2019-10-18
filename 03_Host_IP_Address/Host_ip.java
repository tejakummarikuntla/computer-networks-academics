 import java.net.InetAddress;

 class IpAdd
 {
     public static void main(String args[])
     {
         try
         {
              System.out.println("The Host Ip Address is :"+ InetAddress.getLocalHost());
         }catch(IOException e){
             System.out.println("The Exception is: "+e);
         }
     }
 }
