public class Ship {

	public enum ShipType {
		submarine_1,submarine_2, submarine_3, submarine_4, rocketboat_1, rocketboat_2, rocketboat_3, destroyer_1,destroyer_2, battleship
	};

	private ShipType type;
	private int x, y, length, hitted;
	private char label;
	private boolean dead;

	public Ship(ShipType type) {
		this.type = type;
		this.hitted = 0;
		switch (type) {
		case submarine_1:
			length = 1;
			label = '1';
			break;
		case submarine_2:
			length = 1;
			label = '2';
			break;
		case submarine_3:
			length = 1;
			label = '3';
			break;
		case submarine_4:
			length = 1;
			label = '4';
			break;
		case rocketboat_1:
			length = 2;
			label = '5';
			break;
		case rocketboat_2:
			length = 2;
			label = '6';
			break;
		case rocketboat_3:
			length = 2;
			label = '7';
			break;
		case destroyer_1:
			length = 3;
			label = '8';
			break;
		case destroyer_2:
			length = 3;
			label = '9';
			break;
		case battleship:
			length = 4;
			label = '0';
			break;
		}
	}

	// Setters:

	public void set_x(int x) {
		this.x = x;
	}

	public void set_y(int y) {
		this.y = y;
	}

	// Getters:

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getLength() {
		return length;
	}

	public ShipType getType() {
		return type;
	}

	public void hit() {
		hitted++;
		System.out.println("Попал!");
	}

	public int getHitted() {
		return hitted;
	}

	public char getLabel() {
		return label;
	}
	public void setDead(){
		dead = true;
	}
	public boolean isDead(){
		return dead;
	}

}
