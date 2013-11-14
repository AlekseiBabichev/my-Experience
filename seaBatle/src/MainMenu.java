import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainMenu {
	private JFrame frame;
	private CustomPanel panel;
	private JLabel start;
	private JLabel scores;
	private JLabel about;
	private JLabel exit;
	private ImageIcon start_norm, start_hover;
	private ImageIcon scores_norm, scores_hover;
	private ImageIcon about_norm, about_hover;
	private ImageIcon exit_norm, exit_hover;

	public MainMenu() {
		loadIcons();
		setFrame();
		setLabels();
		addLabelsToPanel();
		setLabelActions();
	}

	public void addLabelsToPanel() {
		panel.setLayout(null);
		panel.add(start);
		panel.add(scores);
		panel.add(about);
		panel.add(exit);
	}

	public void setLabels() {
		start = new JLabel(start_norm);
		scores = new JLabel(scores_norm);
		about = new JLabel(about_norm);
		exit = new JLabel(exit_norm);
		start.setBounds(50, 50, 400, 100);
		scores.setBounds(250, 300, 250, 100);
		about.setBounds(250, 400, 250, 100);
		exit.setBounds(20, 570, 250, 100);
	}

	public void setFrame() {
		frame = new JFrame();
		panel = new CustomPanel(CustomPanel.PanelType.menu);
		frame.setSize(700, 720);
		frame.setTitle("Battle Ships on SWING");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
	}

	public void loadIcons() {
		start_norm = new ImageIcon("assets/menu/buttons/start_norm.png");
		start_hover = new ImageIcon("assets/menu/buttons/start_hover.png");
		scores_norm = new ImageIcon("assets/menu/buttons/scores_norm.png");
		scores_hover = new ImageIcon("assets/menu/buttons/scores_hover.png");
		about_norm = new ImageIcon("assets/menu/buttons/about_norm.png");
		about_hover = new ImageIcon("assets/menu/buttons/about_hover.png");
		exit_norm = new ImageIcon("assets/menu/buttons/exit_norm.png");
		exit_hover = new ImageIcon("assets/menu/buttons/exit_hover.png");
	}

	public void setLabelActions() {
		start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setSize(1000, 720);
				frame.setVisible(false);
				ShipPlacement placement = new ShipPlacement();
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				start.setIcon(start_hover);
				super.mouseEntered(e);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				start.setIcon(start_norm);
				super.mouseExited(e);
			}
		});

		scores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
				Scores scores = new Scores();
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				scores.setIcon(scores_hover);
				super.mouseEntered(e);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				scores.setIcon(scores_norm);
				super.mouseExited(e);
			}
		});
		about.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
				About about = new About();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				about.setIcon(about_hover);
				super.mouseEntered(e);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				about.setIcon(about_norm);
				super.mouseExited(e);
			}
		});

		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);// Exit
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				exit.setIcon(exit_hover);
				super.mouseEntered(e);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exit.setIcon(exit_norm);
				super.mouseExited(e);
			}
		});

	}

}
