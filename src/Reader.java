import java.io.InputStream;
import java.io.OutputStream;
import java.lang.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.*;
import java.util.Date;
import java.util.Random;

public class Reader extends Thread{

    public Socket s;
    int num;

    public Reader(int num, Socket s){
        this.num = num;
        this.s = s;

        setDaemon(true);
        setPriority(NORM_PRIORITY);
        start();
    }

    public static void main(String args[]){
        try {
            int i = 0;

            ServerSocket server = new ServerSocket(3128, 0, InetAddress.getByName("localhost"));

            System.out.println(InetAddress.getByName("localhost"));
            while (true){
                Reader r=new Reader(i, server.accept());
                i++;
                System.out.println(r.num);

            }
        } catch (Exception e){
          e.printStackTrace();
        }
    }

    public void run(){
        try {
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            byte buf[] = new byte[64*1024];
            int r = is.read(buf);

            String data = new String(buf, 0, r);

            data = "" +num+": " +"\n" + data;

            System.out.println(data);
            os.write(data.getBytes());

            s.close();
        } catch (Exception e){
            System.out.println("init error: " + e);
            e.printStackTrace();
        }
    }

}