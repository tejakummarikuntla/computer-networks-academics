 import java.net.URL;
 import java.io.*;
 import javax.net.ssl.HttpsURLConnection;

 public class httpConn
 {

 public static void main(String[] args) throws Exception {
 String httpsURL = "https://www.google.com";
 URL myUrl = new URL(httpsURL);
 HttpsURLConnection conn = (HttpsURLConnection)myUrl.openConnection();
 InputStream is = conn.getInputStream();
 InputStreamReader isr = new InputStreamReader(is);
 BufferedReader br = new BufferedReader(isr);

 String inputLine;

 while ((inputLine = br.readLine()) != null) {
 System.out.println(inputLine);
 }

 br.close();
 }

 }
