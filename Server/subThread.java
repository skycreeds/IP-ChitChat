import java.io.*;
import java.net.*;
 
public class subThread extends Thread {
    protected Socket socket;
    protected Socket Target;
    DataOutputStream Targetwriter;
    public String ip;
    DataInputStream din;
    DataOutputStream dout;
    
    String line;
    boolean singleuse=true;
    Server Thmain = new Server();

    
  

    public subThread(Socket clientSocket) {
        this.socket = clientSocket;
    }



    public void run() {
        System.out.print("Thread Created");
        try {
            din=new DataInputStream(socket.getInputStream());  
            dout=new DataOutputStream(socket.getOutputStream());   
        }
         catch (Exception e) {
             System.out.print("problem");
            
        }

        System.out.print("inpitoutput created for object client\n");
        while(true)
        {
            try {
				line=din.readUTF();
                System.out.print(line);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
         
              if(line.charAt(0)=='@'){
                switch(StringCheck(line)){
                    case "close":{
                        try {
                            Targetwriter.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        try {
                            Target.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        singleuse=true;
                    }
                    break;
                    default :{
                       if(singleuse)
                       {
                        Target=Thmain.ip_check(StringCheck(line));
                        if(Target != null){
                            try {
                                Targetwriter=new DataOutputStream(socket.getOutputStream());
                                dout.writeUTF("<server>user connected");
                                Targetwriter.writeUTF(socket.getInetAddress()+"is in chat");
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            } 
                            singleuse=false;
                        }
                        else{
                            try {
                                dout.writeUTF("<server>user  found //error");
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }    
                        }
                        
                       }
                    
                    }
                }
             }
              else{
                  if(Target!=null && Targetwriter!=null && singleuse==false)
                  {
                      try {
                        Targetwriter.writeUTF(line);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                  }
                  
             }
            

          
        }
        
       
    }
    protected String StringCheck(String str)
    {
        String straw[];
        
            straw=str.split("@",3);
          
            
            System.out.print(straw);
        
        return straw[1];
        
        

    }
 
}
