package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JLabel;

public class ClientRunnable implements Runnable {

    Frameclient frameclient;
    BufferedReader input;
    // private PrintWriter output;

    public ClientRunnable(Frameclient frameclient) throws IOException {
        setFrameclient(frameclient);
        setInput(new BufferedReader( new InputStreamReader(getFrameclient().getSocket().getInputStream())));
        // this.output = new PrintWriter(socket.getOutputStream(),true);
    }
    
    @Override
    public void run() {
        
            try {
                while(true) {
                     String response = getInput().readLine();
                     System.out.println(response);
                     JLabel label = new JLabel(response);
                     label.setBounds(50,getFrameclient().getLastheigth(),600,25);

                     System.out.println(getFrameclient().getTitle());
                     System.out.println(getFrameclient().getLastheigth());
                     getFrameclient().add(label);
                     getFrameclient().setLastheigth(getFrameclient().getLastheigth()+25);
                     getFrameclient().repaint();
                     
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    input.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }

    

    public BufferedReader getInput() {
        return input;
    }
    public Frameclient getFrameclient() {
        return frameclient;
    }

    public void setFrameclient(Frameclient frameclient) {
        this.frameclient = frameclient;
    }

    public void setInput(BufferedReader input) {
        this.input = input;
    }

    
    
}