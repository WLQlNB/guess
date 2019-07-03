package guess.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GameLogin extends JFrame {
	JLabel labUser,labPass;
	JTextField txtUser;
	JPasswordField txtPass;
	JButton btJLogin,btnCancel;
	JPanel panelput;
	
	public GameLogin() {
		this.setTitle("游戏登录");
		this.setSize(280, 135);
		labUser=new JLabel("用户名");
		labPass=new JLabel("密   码");
		txtUser=new JTextField();
		txtPass=new JPasswordField();
		btJLogin=new JButton("登陆");
		btnCancel=new JButton("取消");
		btJLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btJLogin) {
					String uname=txtUser.getText();
					String upwd=txtPass.getText();
					if(!"".equals(uname)&&!"".equals(upwd)) {		
						new GameGUI(uname);						
							setVisible(false);			
					}
				}else if(e.getSource()==btnCancel) {
					dispose();
				}
			}
		});
		panelput=new JPanel();
		panelput.setLayout(new GridLayout(2,2));
		panelput.add(labUser);
		panelput.add(txtUser);
		panelput.add(labPass);
		panelput.add(txtPass);
		JPanel panelButton=new JPanel();
		panelButton.setLayout(new FlowLayout());
		panelButton.add(btJLogin);
		panelButton.add(btnCancel);
		this.setLayout(new BorderLayout());
		this.setLocationByPlatform(true);
		this.setLocation(460, 195);
		this.add(panelput,BorderLayout.CENTER);
		this.add(panelButton,BorderLayout.SOUTH);
		this.setVisible(true);
	}
}
