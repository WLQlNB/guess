package guess.ui;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuFrame extends JFrame {
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

	public MenuFrame() {
		try {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);
		this.setJMenuBar(mnuNotepad);
		setSize(new Dimension(760, 480));
		setTitle("菜单");
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
		setVisible(true);
	}
}
