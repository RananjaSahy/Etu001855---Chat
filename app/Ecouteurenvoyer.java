package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Frameclient;

public class Ecouteurenvoyer implements ActionListener{

    Frameclient frameclient;

    
    public Ecouteurenvoyer(Frameclient frameclient) {
        setFrameclient(frameclient);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getFrameclient().sendmessage();
    }

    public Frameclient getFrameclient() {
        return frameclient;
    }

    public void setFrameclient(Frameclient frameclient) {
        this.frameclient = frameclient;
    }
    
}
