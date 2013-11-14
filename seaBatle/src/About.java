import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class About {
	private JFrame frame;
	private CustomPanel panel;
	private JLabel description;
	private ImageIcon back;
	private JButton backButton;
	
	public About(){
		loadIcons();
		setFrame();
		setButtonsAtcions();
	}
	
	public void setFrame() {
		frame = new JFrame();
		panel = new CustomPanel(CustomPanel.PanelType.menu);
		panel.setLayout(null);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("О игре");
		frame.setSize(700, 720);
		frame.setVisible(true);
		description = new JLabel("<html><top><font color=yellow size=7>О игре:<br><br></font>"+
				"<html><top><font color=red size=5>В игре пока не реализованы: <br> " +
				"<html><top><font color=white size=5>- сохранение результатов.<br>" +
				"<html><top><font color=white size=5>- умный ИИ.<br><br><br></font>"+
				"<html><top><font color=white size=5>Автор: </font><font color=yellow size=5>Таланов С.В.</font>");

		description.setBounds(20, 200, 600, 500);
		panel.add(description);
		backButton = new JButton(back);
		backButton.setBounds(0, 635, 165, 50);
		panel.add(backButton);
		
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
