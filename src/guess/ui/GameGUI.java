package guess.ui;

import guess.pojo.Computer;
import guess.pojo.Person;
import guess.pojo.Rank;
import guess.service.Game;
import guess.service.IOUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;


@SuppressWarnings("serial")
public class GameGUI extends JFrame implements ActionListener,Runnable {

	int perFirst=0;
	int compFirst=0;
	private Socket socket;
	
	public void setSocket(Socket neter) {
		this.socket=neter;
		Thread thread=new Thread(this);
		thread.start();
	}
	public JLabel prea1b1 = null;// 用户出拳
	public JLabel comq1b1 = null;// 电脑出拳
	public JButton j1b1 = null;// 剪刀
	public JButton q1b1 = null;// 石头
	public JButton b1b1 = null;// 布
	public JLabel w1q1 = null;// 结果提示
	private static int gameCount = 0;
	JPanel contentPane;
	JMenuBar mnuNotepad = new JMenuBar();
	JMenu mnuFile = new JMenu();
	JMenu mnuEdit = new JMenu();
	JMenu mnuFormat = new JMenu();
	JMenuItem mnuNew = new JMenuItem();
	JMenuItem mnuOpen = new JMenuItem();
	JMenuItem mnuSave = new JMenuItem();
	JMenuItem mnuSaveAs = new JMenuItem();
	JMenuItem mnuExit = new JMenuItem();
	JMenu mnuHelp = new JMenu();
	private Person person;
	private Computer computer;
	private Game game;
	String loginName="";

	public GameGUI(){
		init();
		registerListener();
	}
	public GameGUI(String name) {
		// TODO Auto-generated constructor stub
		this();
		this.loginName=name;
		
	}
	public void init() {
		this.setTitle("猜拳游戏");
		this.setSize(550, 500);
		this.setLayout(null);
		this.setResizable(false); // 设置窗口大小并不让用户调整窗口大小
		
		String fiilepath = "src/images/icon.jpg";
		ImageIcon icon = new ImageIcon(fiilepath);
		this.setIconImage(icon.getImage());
		this.getContentPane().setBackground(Color.blue);// .设置背景窗口颜色
		JLabel label1 = new JLabel();
		label1.setIcon(new ImageIcon("src/images/m1.png"));
		label1.setBounds(27, 40, 85, 80);
		this.add(label1);
		prea1b1 = new JLabel();
		prea1b1.setIcon(new ImageIcon("src/images/q.png"));
		prea1b1.setBounds(125, 46, 50, 50);
		this.add(prea1b1);
		JLabel label3 = new JLabel();
		label3.setIcon(new ImageIcon("src/images/vs1.png"));
		label3.setBounds(230, 45, 70, 45);
		this.add(label3);
		comq1b1 = new JLabel();
		comq1b1.setIcon(new ImageIcon("src/images/b.png"));
		comq1b1.setBounds(350, 46, 50, 50);
		this.add(comq1b1);
		JLabel label5 = new JLabel();
		label5.setIcon(new ImageIcon("src/images/m2.png"));
		label5.setBounds(420, 40, 85, 80);
		this.add(label5);
		j1b1 = new JButton();
		j1b1.setIcon(new ImageIcon("src/images/j.png"));
		j1b1.setBounds(40, 150, 50, 50);
		this.add(j1b1);
		q1b1 = new JButton();
		q1b1.setIcon(new ImageIcon("src/images/q.png"));
		q1b1.setBounds(40, 260, 50, 50);
		this.add(q1b1);
		b1b1 = new JButton();
		b1b1.setIcon(new ImageIcon("src/images/b.png"));
		b1b1.setBounds(40, 370, 50, 50);
		this.add(b1b1);
		w1q1 = new JLabel();
		w1q1.setIcon(new ImageIcon("src/images/w.png"));
		w1q1.setBounds(160, 130, 230, 150);
		this.add(w1q1);
		JLabel label10 = new JLabel();
		label10.setIcon(new ImageIcon("src/images/vs.png"));
		label10.setBounds(125, 255, 330, 190);
		this.add(label10);
		person = new Person(loginName);
		computer = new Computer("电脑");
		game = new Game(person, computer);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);
		this.setJMenuBar(mnuNotepad);
		mnuFile.setText("文件");
		mnuEdit.setText("编辑");
		mnuFormat.setText("格式");
		mnuNew.setText("新建");
		mnuOpen.setText("打开...");
		mnuSave.setText("保存");
		mnuSaveAs.setText("另存为...");
		mnuExit.setText("退出");
		mnuHelp.setText("帮助");
		mnuNotepad.add(mnuFile);
		mnuNotepad.add(mnuEdit);
		mnuNotepad.add(mnuFormat);
		mnuNotepad.add(mnuHelp);
		mnuFile.add(mnuNew);
		mnuFile.add(mnuOpen);
		mnuFile.add(mnuSave);
		mnuFile.add(mnuSaveAs);
		mnuFile.add(mnuExit);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
					Date dNow = new Date( );
				    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
					String data = "\n时间: "+ ft.format(dNow)+"\t姓名: "+person.getName()+"\t本轮成绩：" + person.getScore();
					Rank rank=new Rank();
					rank.setTime(ft.format(dNow));
					rank.setUsername(person.getName());
					rank.setScore(person.getScore());
					String str = IOUtils.readData();
					try {
						IOUtils.writeData(rank);
						IOUtils.sort();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showConfirmDialog(null, "结果:\n上次" + str + "\n" + data, "关闭窗口", JOptionPane.YES_NO_OPTION);
			}
		});
	}
	private void registerListener() {
		j1b1.addActionListener(this);
		q1b1.addActionListener(this);
		b1b1.addActionListener(this);
		this.addWindowListener(new MyWindowListerner());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton jButton = (JButton) e.getSource();
		int perFirst = person.punches(this, jButton);
		int compFirst = computerShowFist();
		String data=socket.getLocalPort()+":"+perFirst;
		send(data);
		gameCount++;
		game.setCount(gameCount);
		showResult(perFirst, compFirst);
	}
	public void send(String data) {
		try {
			DataOutputStream pw=new DataOutputStream(socket.getOutputStream());
			pw.writeUTF(data);
			System.out.println("发消息"+data);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private int computerShowFist() {
		int show = computer.punches();
		switch (show) {
		case 1:
			comq1b1.setIcon(new ImageIcon("src/images/j.png"));
			break;
		case 2:
			comq1b1.setIcon(new ImageIcon("src/images/q.png"));
			break;
		case 3:
			comq1b1.setIcon(new ImageIcon("src/images/b.png"));
			break;
		default:
			break;
		}
		return show;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	private void showResult(int perFirst, int comFirst) {
		int rule = game.rule(perFirst, comFirst);
		if (rule == 0) {
			w1q1.setIcon(new ImageIcon("src/images/z.png"));
		} else if (rule == 1) {
			w1q1.setIcon(new ImageIcon("src/images/h.png"));
		} else {
			w1q1.setIcon(new ImageIcon("src/images/w.png"));
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			String rec="";
			try {
				DataInputStream buf=new DataInputStream(socket.getInputStream());
				rec=buf.readUTF();
				System.out.println("接收到的信息："+rec);
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			String[] texts=rec.split(":");
			if(null==texts||texts.length<=1) {
				return;
			}
			String firstNum=texts[1];
			compFirst=Integer.parseInt(firstNum);
			computerShowFist();
			int result=game.rule(perFirst, compFirst);
			showResult(perFirst, compFirst);
			
		}
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("127.0.0.1",8080);
		GameGUI gameGUI=new GameGUI();
		gameGUI.setSocket(socket);
	}
}
