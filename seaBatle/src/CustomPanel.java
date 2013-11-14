import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CustomPanel extends JPanel {
	public enum PanelType {
		menu, shipPlacement, game, scores, about
	};

	private PanelType type;
	private BufferedImage image;

	public CustomPanel(PanelType type) {
		this.type = type;
		try {
			switch (type) {
			case menu:
				image = ImageIO.read(new File("assets/menu/background.png"));
				break;
			case shipPlacement:
				image = ImageIO.read(new File("assets/placement/background.png"));
				break;
			case game:
				image = ImageIO.read(new File("assets/game/background.png"));
				break;
			case about:
				break;
			case scores:
				image = ImageIO.read(new File("assets/scores/background.png"));
				break;
			}
		} catch (IOException ex) {
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}

}
