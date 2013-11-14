public class Field {

	private char[][] grid;
	private int[] coordinates;
	private char[][] visible;
	private int y, turn;
	private String log;

	public Field() {
		grid = new char[10][10]; // Сетка с отображением расстановки кораблей
		coordinates = new int[10];
		visible = new char[10][10]; // Сетка для игрока (со скрытыми кораблями)
		setField();
	}

	public void setField() {
		// Заполнить игровое поле:
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				grid[i][j] = '.';
				visible[i][j] = '.';
			}
		}
		// Вывод координат:
		for (int n = 0; n <= 9; n++) {
			coordinates[n] = n + 1;
		}

	}

	public void printField(Boolean debug) {
		if (debug) {
			System.out.println("========================");
			System.out.println("Сетка для отладки.");
			System.out.println("Обозначения:");
			System.out.println("S,R,D,B - поля, занятые кораблями");
			System.out
					.println("/ - поля, заблокированные для размещения кораблей");
		}
		System.out.println("-  A B C D E F G H I J -");
		for (int i = 0; i <= 9; i++) {
			if (i == 9) {
				System.out.print(coordinates[i] + " ");
			} else {
				System.out.print(coordinates[i] + "  ");
			}
			for (int j = 0; j <= 9; j++) {
				if (debug) {
					System.out.print(grid[i][j] + " ");
				} else {
					System.out.print(visible[i][j] + " ");
				}
			}
			System.out.println(coordinates[i]);

		}
	}

	public int convertX(char column) {
		switch (column) {
		case 'A':
			return 0;
		case 'a':
			return 0;
		case 'B':
			return 1;
		case 'b':
			return 1;
		case 'C':
			return 2;
		case 'c':
			return 2;
		case 'D':
			return 3;
		case 'd':
			return 3;
		case 'E':
			return 4;
		case 'e':
			return 4;
		case 'F':
			return 5;
		case 'f':
			return 5;
		case 'G':
			return 6;
		case 'g':
			return 6;
		case 'H':
			return 7;
		case 'h':
			return 7;
		case 'I':
			return 8;
		case 'i':
			return 8;
		case 'J':
			return 9;
		case 'j':
			return 9;
		default:
			return 0;
		}
	}

	public int convertY(int row) {
		y = row - 1;
		return y;
	}

	public char backConvertX(int column) {
		switch (column) {
		case 0:
			return 'A';
		case 1:
			return 'B';
		case 2:
			return 'C';
		case 3:
			return 'D';
		case 4:
			return 'E';
		case 5:
			return 'F';
		case 6:
			return 'G';
		case 7:
			return 'H';
		case 8:
			return 'I';
		case 9:
			return 'J';
		default:
			return 'o';
		}
	}

	public int backConvertY(int row) {
		y = row + 1;
		return y;
	}

	public void setBlockedSpaces(boolean debug) {
		if (debug) {
			for (int i = 0; i <= 9; i++) {
				for (int j = 0; j <= 9; j++) {
					if (visible[i][j] == 'X') {

						int rmin = i - 1;
						int rmax = i + 1;
						int cmin = j - 1;
						int cmax = j + 1;

						if (rmin < 0) {
							rmin = 0;
						}
						if (rmax > 9) {
							rmax = 9;
						}
						if (cmin < 0) {
							cmin = 0;
						}
						if (cmax > 9) {
							cmax = 9;
						}
						for (int r = rmin; r <= rmax; r++) {
							for (int c = cmin; c <= cmax; c++) {
								if (visible[r][c] == '.') {
									visible[r][c] = 'b';

								}
							}
						}
					}
				}
			}
		} else {
			for (int i = 0; i <= 9; i++) {
				for (int j = 0; j <= 9; j++) {
					if (grid[i][j] != '.' && grid[i][j] != '/'
							&& grid[i][j] != 'o' && grid[i][j] != 'X') {

						int rmin = i - 1;
						int rmax = i + 1;
						int cmin = j - 1;
						int cmax = j + 1;

						if (rmin < 0) {
							rmin = 0;
						}
						if (rmax > 9) {
							rmax = 9;
						}
						if (cmin < 0) {
							cmin = 0;
						}
						if (cmax > 9) {
							cmax = 9;
						}
						for (int r = rmin; r <= rmax; r++) {
							for (int c = cmin; c <= cmax; c++) {
								if (grid[r][c] == '.') {
									grid[r][c] = '/';

								}
							}
						}
					}
				}
			}
		}
	}
	
	public void showBlockedSpaces(){
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				if (grid[i][j] == 'X') {

					int rmin = i - 1;
					int rmax = i + 1;
					int cmin = j - 1;
					int cmax = j + 1;

					if (rmin < 0) {
						rmin = 0;
					}
					if (rmax > 9) {
						rmax = 9;
					}
					if (cmin < 0) {
						cmin = 0;
					}
					if (cmax > 9) {
						cmax = 9;
					}
					for (int r = rmin; r <= rmax; r++) {
						for (int c = cmin; c <= cmax; c++) {
							if (grid[r][c] == '/') {
								grid[r][c] = 'b';

							}
						}
					}
				}
			}
		}
	}

	public boolean placeShip(Ship ship, char x, int y, int rotation) {

		int column = convertX(x);
		int row = convertY(y);

		if (rotation == 0) {
			if (checkHorSpace(ship, x, y)) {
				for (int i = column; i < column + ship.getLength(); i++) {
					grid[row][i] = ship.getLabel();
				}
				setBlockedSpaces(false);
				return true;
			} else {
				return false;
			}

		} else {
			if (checkVerSpace(ship, x, y)) {

				for (int i = row; i < row + ship.getLength(); i++) {
					grid[i][column] = ship.getLabel();

				}
				setBlockedSpaces(false);
				return true;
			} else
				return false;

		}

	}

	public boolean checkHorSpace(Ship ship, char x, int y) {
		int column = convertX(x);
		int row = convertY(y);
		int freeSpace = 0;
		if (column <= 10 - ship.getLength()) {
			for (int i = column; i < column + ship.getLength(); i++) {
				if (grid[row][i] == '.') {
					freeSpace += 1;
				}
			}
		}
		if (freeSpace < ship.getLength()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean checkVerSpace(Ship ship, char x, int y) {
		int column = convertX(x);
		int row = convertY(y);
		int freeSpace = 0;
		if (row <= 10 - ship.getLength()) {
			for (int i = row; i < row + ship.getLength(); i++) {
				if (grid[i][column] == '.') {
					freeSpace += 1;
				}
			}
		}

		if (freeSpace < ship.getLength()) { // TODO if может быть упрощен
			return false;
		} else {
			return true;
		}
	}

	public void placeShipRandom(Ship ship) {

		int column;
		int row;
		int rotation;
		boolean stopChecking = false;

		while (!stopChecking) {

			column = (int) (Math.random() * 10);
			row = (int) (Math.random() * 10);
			rotation = (int) (Math.random() * 2);

			switch (rotation) {
			case 0:
				if (checkHorSpace(ship, backConvertX(column), backConvertY(row))) {
					stopChecking = true;
				}
				break;
			case 1:
				if (checkVerSpace(ship, backConvertX(column), backConvertY(row))) {
					stopChecking = true;
				}
				break;
			}

			placeShip(ship, backConvertX(column), backConvertY(row), rotation);
		}
	}

	public boolean checkHit(Ship ship, char x, int y) {
		int column = convertX(x);
		int row = convertY(y);

		if (grid[row][column] == ship.getLabel()) {
			visible[row][column] = 'X';
			grid[row][column] = 'X';
			ship.hit();

			if (ship.getHitted() == ship.getLength()) {
				log = ship.getType() + " потоплен!!!";
				System.out.println(ship.getType() + " потоплен!!!");
				ship.setDead();
				setBlockedSpaces(true);
				showBlockedSpaces();
			} else {
				log = x+Integer.toString(y) + " ранил!";
			}
			return true;
		} else {
			visible[row][column] = 'o';
			return false;
		}

	}
	public String getLog(){
		return log;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public boolean isAllKilled() {
		int n = 0; // счетчик полей живых кораблей
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				if (grid[i][j] != '.' && grid[i][j] != '/' && grid[i][j] != 'o'
						&& grid[i][j] != 'X' && grid[i][j] != 'b') {
					n++;
				}
			}
		}
		if (n != 0) {
			return false;
		} else {
			return true;

		}
	}

	public void printWinnerResults() {
		System.out.println("Вы выиграли!");
		System.out.println("Количество сделанных ходов: " + getTurn());
	}

	public void nextTurn() {
		turn += 1;
	}

	public char decodeInputX(String input) {
		return input.charAt(0);
	}

	public int decodeInputY(String input) {
		String c = input.substring(1);
		y = Integer.parseInt(c);
		return y;
	}

	public char getFieldOfGrid(int i, int j) {
		return grid[i][j];
	}

	public void setFieldOnGrid(int i, int j, char value) {
		grid[i][j] = value;
	}

}