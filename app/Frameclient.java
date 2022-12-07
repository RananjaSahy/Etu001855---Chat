package app;

import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Frameclient extends JFrame{
    
    String name;
    Socket socket;
    int lastheigth;
    PrintWriter output;
    JTextField text;
    JButton envoyer;

    public Frameclient(String name, String host)throws Exception{

        setSocket(new Socket(host,5000));
        setName(name);
        setTitle(getName());
        setOutput(new PrintWriter(socket.getOutputStream(),true));

        ClientRunnable clientRun = new ClientRunnable(this);
        new Thread(clientRun).start();

        // JLabel label = new JLabel("ESSAI BE");

        setSize(800, 800);
        setResizable(false);
        setLayout(null);
        setLastheigth(25);

        // label.setBounds(50, getLastheigth(), 600, 25);
        // this.add(label);

        // JLabel label2 = new JLabel();
        // label2.setText("Essai be 2 ");
        // label2.setBounds(50, getLastheigth()+25, 600, 25);
        // this.add(label2);

        setText(new JTextField());
        getText().setBounds(50, 700, 500, 40);
        this.add(getText());

        setEnvoyer(new JButton("Envoyer"));
        getEnvoyer().setBounds(600, 700, 100, 40);
        getEnvoyer().addActionListener(new Ecouteurenvoyer(this));
        this.add(getEnvoyer());

        setVisible(true);
        getOutput().println(getName()+" a rejoint la discussion.");
    }

    public int getLastheigth() {
        return lastheigth;
    }

    public void setLastheigth(int lastheigth) {
        this.lastheigth = lastheigth;
    }

    public JTextField getText() {
        return text;
    }

    public void setText(JTextField text) {
        this.text = text;
    }

    public JButton getEnvoyer() {
        return envoyer;
    }

    public void setEnvoyer(JButton envoyer) {
        this.envoyer = envoyer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }    

    
    public PrintWriter getOutput() {
        return output;
    }

    public void setOutput(PrintWriter output) {
        this.output = output;
    }
    
    public void sendmessage(){
        String message = ( "(" +getName()+ ")" + " : " );
        message = message + this.getText().getText();
        getOutput().println(message);
        getText().setText("");
    }

}
