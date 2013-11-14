import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Scores {
	public int currentTurns;
	public String currentName;
	private JFrame frame;
	private CustomPanel panel;
	private JLabel example;
	private int position;
	private ImageIcon back;
	private JButton backButton;
	
	

	public Scores(){
		position = 1;
		loadIcons();
		setFrame();
		setButtonsAtcions();
	}
	
	
	
	
	
	
	
	
	public void setFrame() {
		frame = new JFrame();
		panel = new CustomPanel(CustomPanel.PanelType.scores);
		panel.setLayout(null);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Рекорды");
		frame.setSize(1000, 720);
		frame.setVisible(true);
		example = new JLabel(
				"<html><top><font color=yellow size=16>Stas: 14 turns</font>");

		example.setBounds(20, 100, 400, 50);
		panel.add(example);
		backButton = new JButton(back);
		backButton.setBounds(0, 635, 165, 50);
		panel.add(backButton);
		
	}
	
	public void newRecord(){
		position++;
		JLabel pos = new JLabel();
		pos.setBounds(20, 100*position, 400, 50);
		panel.add(pos);
		currentName = (String)JOptionPane.showInputDialog(null, "Введите ваше имя:", "Новый рекорд", 2); 
		pos.setText("<html><top><font color=yellow size=16>"+currentName+" : " + currentTurns+ " turns</font>");
		
	}
	
	public void loadIcons(){
		back = new ImageIcon("assets/placement/buttons/back.png");
	}
	
	public void setButtonsAtcions(){
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
				MainMenu menu = new MainMenu();
			}
		});
	}
	
	
	
}
