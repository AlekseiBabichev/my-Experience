import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Game {
	private int turn;
	private ShipPlacement placement;
	private CustomPanel panel;
	private JFrame frame;
	private ArrayList<JLabel> playerFields;
	private ArrayList<JLabel> enemyFields;
	private ImageIcon field_free, field_hover, field_ship, field_blocked,
			field_fired;
	private JLabel massageLog, turnCount;
	// Enemy Ships
	private Field enemyGrid;
	private Ship eSubmirine_1, eSubmirine_2, eSubmirine_3, eSubmirine_4;
	private Ship eRocketBoat_1, eRocketBoat_2, eRocketBoat_3;
	private Ship eDestroyer_1, eDestroyer_2;
	private Ship eBattleShip_1;

	public Game(ShipPlacement placement) {
		turn = 0;
		this.placement = placement;
		loadIcons();
		setFrame();
		setEnemyShips();
		randomPlaceEnemyShips();

	}

	public void setGameVisibility(boolean visibility) {
		frame.setVisible(visibility);
	}

	public void setFrame() {
		frame = new JFrame();
		panel = new CustomPanel(CustomPanel.PanelType.game);
		panel.setLayout(null);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Сражение");
		frame.setSize(1000, 720);
		frame.setVisible(false);
		massageLog = new JLabel(
				"<html><center><font color=yellow size=5>Ваш ход.</font>");
		turnCount = new JLabel("<html><center><font color=yellow size=5>Ход: "
				+ turn + "</font>");
		turnCount.setBounds(15, 640, 150, 50);
		massageLog.setBounds(600, 640, 400, 50);
		panel.add(massageLog);
		panel.add(turnCount);
	}

	public void drawPlayerFields() {
		playerFields = new ArrayList();
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

				// setFieldActions(f);
				playerFields.add(f);
				panel.add(playerFields.get(n));
				n++;
			}
		}
	}

	public void drawEnemyFields() {
		enemyFields = new ArrayList();
		int n = 0; // порядковый номер поля (JLabel) в ArrayList
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JLabel f = new JLabel(field_free);
				f.setBounds(550 + 40 * i, 50 + 40 * j, 42, 42);
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
				enemyFields.add(f);
				panel.add(enemyFields.get(n));
				n++;
			}
		}
	}

	public void loadIcons() {
		field_free = new ImageIcon("assets/placement/field_free.png");
		field_hover = new ImageIcon("assets/placement/field_hover.png");
		field_ship = new ImageIcon("assets/placement/field_ship.png");
		field_blocked = new ImageIcon("assets/placement/field_blocked.png");
		field_fired = new ImageIcon("assets/placement/field_fired.png");
	}

	public void showPlayerShips() {
		int n = 0;
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {
				if (placement.getPlayerGrid(i, j) != '.'
						&& placement.getPlayerGrid(i, j) != '/') {
					playerFields.get(n).setIcon(field_ship);
				} else if (placement.getPlayerGrid(i, j) == '.') {
					playerFields.get(n).setIcon(field_free);
				}
				n++;
			}
		}
		placement.playerGrid.printField(true);
	}

	public void setEnemyShips() {
		eSubmirine_1 = new Ship(Ship.ShipType.submarine_1);
		eSubmirine_2 = new Ship(Ship.ShipType.submarine_2);
		eSubmirine_3 = new Ship(Ship.ShipType.submarine_3);
		eSubmirine_4 = new Ship(Ship.ShipType.submarine_4);
		eRocketBoat_1 = new Ship(Ship.ShipType.rocketboat_1);
		eRocketBoat_2 = new Ship(Ship.ShipType.rocketboat_2);
		eRocketBoat_3 = new Ship(Ship.ShipType.rocketboat_3);
		eDestroyer_1 = new Ship(Ship.ShipType.destroyer_1);
		eDestroyer_2 = new Ship(Ship.ShipType.destroyer_2);
		eBattleShip_1 = new Ship(Ship.ShipType.battleship);
	}

	public void randomPlaceEnemyShips() {
		enemyGrid = new Field();
		enemyGrid.placeShipRandom(eBattleShip_1);
		enemyGrid.placeShipRandom(eDestroyer_1);
		enemyGrid.placeShipRandom(eDestroyer_2);
		enemyGrid.placeShipRandom(eRocketBoat_1);
		enemyGrid.placeShipRandom(eRocketBoat_2);
		enemyGrid.placeShipRandom(eRocketBoat_3);
		enemyGrid.placeShipRandom(eSubmirine_1);
		enemyGrid.placeShipRandom(eSubmirine_2);
		enemyGrid.placeShipRandom(eSubmirine_3);
		enemyGrid.placeShipRandom(eSubmirine_4);
		enemyGrid.printField(true);
	}

	public boolean checkHit(char x, int y) {
		if (enemyGrid.checkHit(eBattleShip_1, x, y)
				|| enemyGrid.checkHit(eDestroyer_1, x, y)
				|| enemyGrid.checkHit(eDestroyer_2, x, y)
				|| enemyGrid.checkHit(eRocketBoat_1, x, y)
				|| enemyGrid.checkHit(eRocketBoat_2, x, y)
				|| enemyGrid.checkHit(eRocketBoat_3, x, y)
				|| enemyGrid.checkHit(eSubmirine_1, x, y)
				|| enemyGrid.checkHit(eSubmirine_2, x, y)
				|| enemyGrid.checkHit(eSubmirine_3, x, y)
				|| enemyGrid.checkHit(eSubmirine_4, x, y)) {
			massageLog.setText("<html><center><font color=yellow size=5>"
					+ enemyGrid.getLog() + "</font>");
			updateEnemyField();
			if (checkPlayerWin()){
				JOptionPane.showMessageDialog(frame, "ВЫ ВЫИГРАЛИ!");
				//TODO:выход в окно очков
				frame.setVisible(false);
				Scores scores = new Scores();
				scores.currentTurns = turn;
				scores.newRecord();
				
			}
			return true;
		} else {
			massageLog.setText("<html><center><font color=yellow size=5>" + x
					+ Integer.toString(y) + " - мимо</font>");
			updateEnemyField();
			enemyTurn();
			return false;
		}
	}

	public void enemyTurn() {
		boolean finish = false;
		while (!finish) {
			int n = (int) (Math.random() * 100);
			if (playerFields.get(n).getIcon() == field_free) {
				playerFields.get(n).setIcon(field_blocked);
				finish = true;
			} else if (playerFields.get(n).getIcon() == field_ship) {
				playerFields.get(n).setIcon(field_fired);
			}
		}
		if (!checkComputerWin()){
		nextTurn();
		printTurn();
		} else {
			JOptionPane.showMessageDialog(frame, "ВЫ ПРОИГРАЛИ!");
			frame.setVisible(false);
			MainMenu menu = new MainMenu();
		}
	}

	public void nextTurn() {
		turn++;
	}

	public void printTurn() {
		turnCount.setText("<html><center><font color=yellow size=5>Ход: "
				+ turn + "</font>");
	}
	
	public boolean checkComputerWin(){
		if (placement.playerGrid.isAllKilled()){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean checkPlayerWin(){
		if (enemyGrid.isAllKilled()){
			return true;
		}else{
			return false;
		}
	}
	

	public void updateEnemyField() {
		int n = 0;
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {
				if (enemyGrid.getFieldOfGrid(i, j) == 'X') {
					enemyFields.get(n).setIcon(field_fired);
				}else if(enemyGrid.getFieldOfGrid(i, j) == 'b'){
					enemyFields.get(n).setIcon(field_blocked);
				}
				n++;
			}
		}
		enemyGrid.printField(true);
	}

	public void setFieldActions(final JLabel f) {
		f.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				System.out.println(f.getName());

				char x = placement.playerGrid.decodeInputX(f.getName());
				int y = placement.playerGrid.decodeInputY(f.getName());
				System.out.println(x);
				System.out.println(y);
				if (checkHit(x, y)) {
					f.setIcon(field_fired);
				} else {
					f.setIcon(field_blocked);
				}
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (f.getIcon() != field_fired && f.getIcon() != field_blocked) {
					f.setIcon(field_hover);
				}
				super.mouseEntered(e);
			}

			@Override
			public void mouseExited(MouseEvent e) {

				if (f.getIcon() != field_fired && f.getIcon() != field_blocked) {
					f.setIcon(field_free);
				}
				super.mouseExited(e);
			}
		});
	}

}
