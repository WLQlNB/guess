package guess.pojo;

import guess.ui.GameGUI;

import javax.swing.*;

public class Person extends User {

    public Person(String name) {
        super(name);
    }

    public Person() {
		// TODO Auto-generated constructor stub
	}

	public int punches(GameGUI gameGUI, JButton jButton) {
        int perFirst=0;
        if (jButton== gameGUI.j1b1) {
            perFirst=1;
            ImageIcon perImg2=new ImageIcon("src/images/j.png");
            gameGUI.prea1b1.setIcon(perImg2);
        }
        if (jButton==gameGUI.q1b1) {
            perFirst=2;
            ImageIcon perImg2=new ImageIcon("src/images/q.png");
            gameGUI.prea1b1.setIcon(perImg2);
        }
        if (jButton==gameGUI.b1b1) {
            perFirst=3;
            ImageIcon perImg2=new ImageIcon("src/images/b.png");
            gameGUI.prea1b1.setIcon(perImg2);
        }
        return  perFirst;
    }
}
