import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ShipPlacement {
private Game game;
	private CustomPanel panel;
	private JFrame frame;
	// Icons
	private ImageIcon field_free, field_hover, field_ship, field_blocked;
	private ImageIcon rotate, reset, start, back, random;
	private ImageIcon battleship, destroyer, rocketboat, submarine;
	private ImageIcon battleship_rot, destroyer_rot, rocketboat_rot;
	private ImageIcon battleship_icon, destroyer_icon, rocketboat_icon,
			submarine_icon;
	private ImageIcon normalIcon, rotatedIcon;
	// Buttons
	private JButton rotateButton;
	private JButton startButton;
	private JButton backButton;
	private JButton resetButton;
	private JButton randomButton;
	private JButton battleshipButton, destroyerButton_1, destroyerButton_2,
			rocketboatButton_1, rocketboatButton_2, rocketboatButton_3,
			submarineButton_1, submarineButton_2, submarineButton_3,
			submarineButton_4;
	private JButton currentShipButton;
	// Labels
	private JLabel shipName;
	private JLabel help;
	// For grid
	public Field playerGrid;
	private ArrayList<JLabel> fields;
	private char x;
	private int y;
	private int rotation;

	// Ships
	private Ship pSubmirine_1, pSubmirine_2, pSubmirine_3, pSubmirine_4;
	private Ship pRocketBoat_1, pRocketBoat_2, pRocketBoat_3;
	private Ship pDestroyer_1, pDestroyer_2;
	private Ship pBattleShip_1;
	private Ship placingShip;

	public ShipPlacement() {
		playerGrid = new Field();
		rotation = 0;
		game = new Game(this);
		loadIcons();
		setShips();
		setField();
		setFrame();
		drawFields();
		setInterfaceButtons();
		setLabels();
		setShipButtons();
		shipButtonActions();
	}

	public void setShips() {
		pSubmirine_1 = new Ship(Ship.ShipType.submarine_1);
		pSubmirine_2 = new Ship(Ship.ShipType.submarine_2);
		pSubmirine_3 = new Ship(Ship.ShipType.submarine_3);
		pSubmirine_4 = new Ship(Ship.ShipType.submarine_4);
		pRocketBoat_1 = new Ship(Ship.ShipType.rocketboat_1);
		pRocketBoat_2 = new Ship(Ship.ShipType.rocketboat_2);
		pRocketBoat_3 = new Ship(Ship.ShipType.rocketboat_3);
		pDestroyer_1 = new Ship(Ship.ShipType.destroyer_1);
		pDestroyer_2 = new Ship(Ship.ShipType.destroyer_2);
		pBattleShip_1 = new Ship(Ship.ShipType.battleship);

	}

	public void setField() {
		playerGrid.setField();
	}

	public void setFrame() {
		frame = new JFrame();
		panel = new CustomPanel(CustomPanel.PanelType.shipPlacement);
		panel.setLayout(null);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Расстановка кораблей");
		frame.setSize(1000, 720);
		frame.setVisible(true);
	}

	public void setLabels() {
		shipName = new JLabel(
				"<html><center><font color=yellow size=5>Выберите корабль</font>");
		help = new JLabel("<html><center><font color=white size=5>Щелкните на поле сетки.</font>");
		shipName.setBounds(650, 325, 400, 200);
		help.setBounds(20, 450, 300, 50);
		panel.add(shipName);
		panel.add(help);
		help.setVisible(false);
	}

	private void drawFields() {
		fields = new ArrayList();
		int n = 0; // порядковый номер поля (JLabel) в ArrayList
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JLabel f = new JLabel(field_free);
				f.setBounds(50 + 40 * i, 50 + 40 * j, 42, 42);
				if (i == 0) {
					f.setName("A" + Integer.toString(j + 1));
				} else if (i == 1) {
					f.setName("B" + Integer.toString(j + 1));
				} else if (i == 2) {
					f.setName("C" + Integer.toString(j + 1));
				} else if (i == 3) {
					f.setName("D" + Integer.toString(j + 1));
				} else if (i == 4) {
					f.setName("E" + Integer.toString(j + 1));
				} else if (i == 5) {
					f.setName("F" + Integer.toString(j + 1));
				} else if (i == 6) {
					f.setName("G" + Integer.toString(j + 1));
				} else if (i == 7) {
					f.setName("H" + Integer.toString(j + 1));
				} else if (i == 8) {
					f.setName("I" + Integer.toString(j + 1));
				} else if (i == 9) {
					f.setName("J" + Integer.toString(j + 1));
				}

				setFieldActions(f);
				fields.add(f);
				panel.add(fields.get(n));
				n++;
			}
		}
	}

	public void loadIcons() {
		field_free = new ImageIcon("assets/placement/field_free.png");
		field_hover = new ImageIcon("assets/placement/field_hover.png");
		field_ship = new ImageIcon("assets/placement/field_ship.png");
		field_blocked = new ImageIcon("assets/placement/field_blocked.png");
		rotate = new ImageIcon("assets/placement/buttons/rotate.png");
		reset = new ImageIcon("assets/placement/buttons/reset.png");
		start = new ImageIcon("assets/placement/buttons/start.png");
		back = new ImageIcon("assets/placement/buttons/back.png");
		random = new ImageIcon("assets/placement/buttons/random.png");
		battleship = new ImageIcon("assets/ships/battleship.png");
		battleship_icon = new ImageIcon("assets/ships/battleship_icon.png");
		battleship_rot = new ImageIcon("assets/ships/battleship_rot.png");
		destroyer = new ImageIcon("assets/ships/destroyer.png");
		destroyer_icon = new ImageIcon("assets/ships/destroyer_icon.png");
		destroyer_rot = new ImageIcon("assets/ships/destroyer_rot.png");
		rocketboat = new ImageIcon("assets/ships/rocketboat.png");
		rocketboat_icon = new ImageIcon("assets/ships/rocketboat_icon.png");
		rocketboat_rot = new ImageIcon("assets/ships/rocketboat_rot.png");
		submarine = new ImageIcon("assets/ships/submarine.png");
		submarine_icon = new ImageIcon("assets/ships/submarine_icon.png");

	}

	public void setInterfaceButtons() {
		rotateButton = new JButton(rotate);
		resetButton = new JButton(reset);
		startButton = new JButton(start);
		backButton = new JButton(back);
		randomButton = new JButton(random);
		rotateButton.setBounds(748, 325, 168, 50);
		resetButton.setBounds(0, 510, 165, 50);
		startButton.setBounds(825, 635, 165, 50);
		backButton.setBounds(0, 635, 165, 50);
		randomButton.setBounds(600, 635, 220, 50);
		panel.add(rotateButton);
		panel.add(resetButton);
		panel.add(startButton);
		panel.add(backButton);
		panel.add(randomButton);
		rotateButton.setVisible(false);

	}

	public void setShipButtons() {
		battleshipButton = new JButton(battleship_icon);
		destroyerButton_1 = new JButton(destroyer_icon);
		destroyerButton_2 = new JButton(destroyer_icon);
		rocketboatButton_1 = new JButton(rocketboat_icon);
		rocketboatButton_2 = new JButton(rocketboat_icon);
		rocketboatButton_3 = new JButton(rocketboat_icon);
		submarineButton_1 = new JButton(submarine_icon);
		submarineButton_2 = new JButton(submarine_icon);
		submarineButton_3 = new JButton(submarine_icon);
		submarineButton_4 = new JButton(submarine_icon);
		battleshipButton.setBounds(515, 45, 400, 70);
		destroyerButton_1.setBounds(515, 115, 200, 70);
		destroyerButton_2.setBounds(715, 115, 200, 70);
		rocketboatButton_1.setBounds(515, 185, 133, 70);
		rocketboatButton_2.setBounds(648, 185, 133, 70);
		rocketboatButton_3.setBounds(781, 185, 133, 70);
		submarineButton_1.setBounds(515, 255, 100, 70);
		submarineButton_2.setBounds(615, 255, 100, 70);
		submarineButton_3.setBounds(715, 255, 100, 70);
		submarineButton_4.setBounds(815, 255, 100, 70);
		panel.add(battleshipButton);
		panel.add(destroyerButton_1);
		panel.add(destroyerButton_2);
		panel.add(rocketboatButton_1);
		panel.add(rocketboatButton_2);
		panel.add(rocketboatButton_3);
		panel.add(submarineButton_1);
		panel.add(submarineButton_2);
		panel.add(submarineButton_3);
		panel.add(submarineButton_4);
	}

	public void setShipButtonsVisibility(boolean visibility) {
		battleshipButton.setVisible(visibility);
		destroyerButton_1.setVisible(visibility);
		destroyerButton_2.setVisible(visibility);
		rocketboatButton_1.setVisible(visibility);
		rocketboatButton_2.setVisible(visibility);
		rocketboatButton_3.setVisible(visibility);
		submarineButton_1.setVisible(visibility);
		submarineButton_2.setVisible(visibility);
		submarineButton_3.setVisible(visibility);
		submarineButton_4.setVisible(visibility);
	}

	public void updateFields() {
		int n = 0;
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {
				if (playerGrid.getFieldOfGrid(i, j) != '.'
						&& playerGrid.getFieldOfGrid(i, j) != '/') {
					fields.get(n).setIcon(field_ship);
				} else if (playerGrid.getFieldOfGrid(i, j) == '/') {
					fields.get(n).setIcon(field_blocked);
				}else if (playerGrid.getFieldOfGrid(i, j) == '.') {
					fields.get(n).setIcon(field_free);
				}
				n++;
			}
		}
	}

	public void resetField() {
		playerGrid.setField();
	}
	
	public char getPlayerGrid(int i, int j){
		return playerGrid.getFieldOfGrid(i, j);
	}

	public boolean checkReadyToStart() {
		if (!battleshipButton.isVisible() && !destroyerButton_1.isVisible()
				&& !destroyerButton_2.isVisible()
				&& !rocketboatButton_1.isVisible()
				&& !rocketboatButton_2.isVisible()
				&& !rocketboatButton_3.isVisible()
				&& !submarineButton_1.isVisible()
				&& !submarineButton_2.isVisible()
				&& !submarineButton_3.isVisible()
				&& !submarineButton_4.isVisible()) {
			return true;
		}else {
			return false;
		}		
	}
	
	public void randomPlaceShips(){
		playerGrid.placeShipRandom(pBattleShip_1);
		playerGrid.placeShipRandom(pDestroyer_1);
		playerGrid.placeShipRandom(pDestroyer_2);
		playerGrid.placeShipRandom(pRocketBoat_1);
		playerGrid.placeShipRandom(pRocketBoat_2);
		playerGrid.placeShipRandom(pRocketBoat_3);
		playerGrid.placeShipRandom(pSubmirine_1);
		playerGrid.placeShipRandom(pSubmirine_2);
		playerGrid.placeShipRandom(pSubmirine_3);
		playerGrid.placeShipRandom(pSubmirine_4);
		playerGrid.printField(true);
	}
	
	
	public void setFieldActions(final JLabel f) {
		f.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				System.out.println(f.getName());
				if (placingShip != null) {
					x = playerGrid.decodeInputX(f.getName());
					y = playerGrid.decodeInputY(f.getName());
					System.out.println(x);
					System.out.println(y);

					if (playerGrid.placeShip(placingShip, x, y, rotation)) {

						playerGrid.printField(true);
						currentShipButton.setVisible(false);
						updateFields();
						currentShipButton = null;
						placingShip = null;
						if (checkReadyToStart()){
							shipName.setText("<html><center><font color=white size=5>К БОЮ ГОТОВ!</font>");
						}else{
						shipName.setText("<html><center><font color=white size=5>Выберите корабль</font>");
						}
						shipName.setIcon(null);
						normalIcon = null;
						rotatedIcon = null;
						rotateButton.setVisible(false);
						help.setVisible(false);
					}
				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (f.getIcon() != field_ship && currentShipButton != null
						&& f.getIcon() != field_blocked) {
					f.setIcon(field_hover);
				}
				super.mouseEntered(e);
			}

			@Override
			public void mouseExited(MouseEvent e) {

				if (f.getIcon() != field_ship && f.getIcon() != field_blocked) {
					f.setIcon(field_free);
				}
				super.mouseExited(e);
			}
		});
	}

	public void shipButtonActions() {
		battleshipButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				placingShip = pBattleShip_1;
				currentShipButton = battleshipButton;
				shipName.setText("");
				normalIcon = battleship;
				rotatedIcon = battleship_rot;
				shipName.setIcon(normalIcon);
				rotation = 0;
				rotateButton.setVisible(true);
				help.setVisible(true);
			}
		});
		destroyerButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				placingShip = pDestroyer_1;
				currentShipButton = destroyerButton_1;
				shipName.setText("");
				normalIcon = destroyer;
				rotatedIcon = destroyer_rot;
				shipName.setIcon(normalIcon);
				rotation = 0;
				rotateButton.setVisible(true);
				help.setVisible(true);
			}
		});
		destroyerButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				placingShip = pDestroyer_2;
				currentShipButton = destroyerButton_2;
				shipName.setText("");
				normalIcon = destroyer;
				rotatedIcon = destroyer_rot;
				shipName.setIcon(normalIcon);
				rotation = 0;
				rotateButton.setVisible(true);
				help.setVisible(true);
			}
		});
		rocketboatButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				placingShip = pRocketBoat_1;
				currentShipButton = rocketboatButton_1;
				shipName.setText("");
				normalIcon = rocketboat;
				rotatedIcon = rocketboat_rot;
				shipName.setIcon(normalIcon);
				rotation = 0;
				rotateButton.setVisible(true);
				help.setVisible(true);
			}
		});
		rocketboatButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				placingShip = pRocketBoat_2;
				currentShipButton = rocketboatButton_2;
				shipName.setText("");
				normalIcon = rocketboat;
				rotatedIcon = rocketboat_rot;
				shipName.setIcon(normalIcon);
				rotation = 0;
				rotateButton.setVisible(true);
				help.setVisible(true);
			}
		});
		rocketboatButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				placingShip = pRocketBoat_3;
				currentShipButton = rocketboatButton_3;
				shipName.setText("");
				normalIcon = rocketboat;
				rotatedIcon = rocketboat_rot;
				shipName.setIcon(normalIcon);
				rotation = 0;
				rotateButton.setVisible(true);
				help.setVisible(true);
			}
		});
		submarineButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				placingShip = pSubmirine_1;
				currentShipButton = submarineButton_1;
				shipName.setText("");
				normalIcon = submarine;
				rotatedIcon = submarine;
				shipName.setIcon(normalIcon);
				rotation = 0;
				rotateButton.setVisible(true);
				help.setVisible(true);
			}
		});
		submarineButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				placingShip = pSubmirine_2;
				currentShipButton = submarineButton_2;
				shipName.setText("");
				normalIcon = submarine;
				rotatedIcon = submarine;
				shipName.setIcon(normalIcon);
				rotation = 0;
				rotateButton.setVisible(true);
				help.setVisible(true);
			}
		});
		submarineButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				placingShip = pSubmirine_3;
				currentShipButton = submarineButton_3;
				shipName.setText("");
				normalIcon = submarine;
				rotatedIcon = submarine;
				shipName.setIcon(normalIcon);
				rotation = 0;
				rotateButton.setVisible(true);
				help.setVisible(true);
			}
		});
		submarineButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				placingShip = pSubmirine_4;
				currentShipButton = submarineButton_4;
				shipName.setText("");
				normalIcon = submarine;
				rotatedIcon = submarine;
				shipName.setIcon(normalIcon);
				rotation = 0;
				rotateButton.setVisible(true);
				help.setVisible(true);
			}
		});
		rotateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				switch (rotation) {
				case 1:
					rotation = 0;
					shipName.setIcon(normalIcon);
					break;
				case 0:
					rotation = 1;
					shipName.setIcon(rotatedIcon);
					break;
				}
			}
		});
		resetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				resetField();
				for (int i = 0; i < 100; i++) {
					fields.get(i).setIcon(field_free);
				}
				setShipButtonsVisibility(true);
				shipName.setIcon(null);
				normalIcon = null;
				rotatedIcon = null;
				rotateButton.setVisible(false);
				shipName.setText("<html><center><font color=white size=5>Выберите корабль</font>");
			}
		});
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (checkReadyToStart()){
					frame.setVisible(false);
					game.setGameVisibility(true);
					game.drawPlayerFields();
					game.drawEnemyFields();
					game.showPlayerShips();
				} else{
					JOptionPane.showMessageDialog(frame, "Не все корабли расставлены!");
				}
			}
		});
		randomButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				resetField();
				randomPlaceShips();
				updateFields();	
				setShipButtonsVisibility(false);
				shipName.setIcon(null);
				normalIcon = null;
				rotatedIcon = null;
				rotateButton.setVisible(false);
				shipName.setText("<html><center><font color=white size=5>К БОЮ ГОТОВ!</font>");
			}
		});
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
				MainMenu menu = new MainMenu();
			}
		});

	}

}
