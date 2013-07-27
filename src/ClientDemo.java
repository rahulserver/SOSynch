import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws InterruptedException {
        try {
            Socket client= null;
            try {
                client = new Socket("localhost", 6666);
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            while(true)
            {
                System.out.println("Hello");
                Thread th=new Thread(new ClientThread(client));
                th.start();
                System.out.println("Thread started........");
                th.sleep(1000);

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

class ClientThread implements Runnable {
    Socket c;
    public ClientThread(Socket client) {
        this.c=client;
    }
    @Override
    public void run() {
        DataOutputStream dos=null;
        try {
            System.out.println("Client thread is going to write.......");
            dos = new DataOutputStream(c.getOutputStream());
            dos.writeUTF("Hello From Client");
            System.out.println("Data written by client............");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            System.out.println(e+"");
        }


    }

}