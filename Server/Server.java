import java.io.*;
import java.net.*;


public class Server {

    static final int PORT = 50002;
    static  int i=0;
    static ServerSocket serverSocket = null;
    static Socket socket[] = new Socket[10];
    public static void main(String args[]) {

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.print("server started in ip"+serverSocket+"and port 5002\n");
        } catch (IOException e) {
            e.printStackTrace();

        }
        while (true) {
            try {
                System.out.print("server is listening \n");
                 socket[i] = serverSocket.accept();

            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            // new thread for a client
            new subThread(socket[i]).start();
            System.out.print(socket[i].getInetAddress().toString()+"is connected"+"\n");
            i++;
        }
    }
    public Socket ip_check(String str){
        
        Socket s=null;
      
        for(int i=0 ;i<10;i++)
        {
            if((socket[i].getInetAddress()).toString()==str)
            {
                s=socket[i];
                break;
            }
         
        }
        if(s!=null){
            return s;
        }
        else{
            return null;
        }
       
        

    }
  
}
