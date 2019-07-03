package guess.ui;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowListerner extends WindowAdapter {
    private String result="";
    public MyWindowListerner(){

    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void windowClosing(WindowEvent e){
        GameGUI gameGUI=(GameGUI) e.getSource();
        result=gameGUI.getGame().showResult();
        JOptionPane.showConfirmDialog(null,result);

    }
}
