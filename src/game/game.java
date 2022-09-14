package game;

public class game {

	private player player1;
	private player player2;
	private String[][] board;
	private boolean xturn;
	private coin coin;

	public player getPlayer1() {
		return player1;
	}

	public player getPlayer2() {
		return player2;
	}

	public String[][] getBoard() {
		return board;
	}

	public boolean isXturn() {
		return xturn;
	}

	public game(player player1, player player2) {
		this.player1 = player1;
		this.player2 = player2;
		board = new String[3][3];
		xturn = true;

		coin = new coin(this.player1, this.player2);
	}

	public void firstround() {
		coin.Flip();
	}

	public void insertxo(int x, int y) {

		if (xturn) {
			board[x][y] = "X";
			xturn = false;
		} else {
			board[x][y] = "O";
			xturn = true;
		}
		coin.turn();

	}

	// method win to check if the player win
	// first case | x | x | x |// second case x | | |
	// | | | |// x | | |
	// | | | |// x | | |
	public Boolean win() {
		for (int x = 0; x < 3; x++) {

			if ((board[x][0] != null && board[x][1] != null && board[x][2] != null && (board[x][0].equals(board[x][1]))
					&& (board[x][0].equals(board[x][2])))
					|| (board[0][x] != null && board[1][x] != null && board[2][x] != null
							&& (board[0][x].equals(board[1][x])) && (board[0][x].equals(board[2][x])))
					|| (board[0][0] != null && board[1][1] != null && board[2][2] != null
							&& (board[0][0].equals(board[1][1])) && (board[0][0].equals(board[2][2])))
					|| (board[2][0] != null && board[0][2] != null && board[1][1] != null
							&& (board[2][0].equals(board[1][1])) && (board[1][1].equals(board[0][2])))) {
				return true;
			}
		}
		return false;

	}

	public Boolean draw() {

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (board[x][y] == null)
					return false;
			}
		}
		return true;
	}

	public void endround() {

		if (win()) {
			winner().setPoints(winner().getPoints() + 1);
			coin.setCurrent(winner());
			coin.turn();
			newround();
		}

		if (draw()) {
			coin.turn();
			newround();
		}

	}

	public void newround() {

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				board[x][y] = null;
			}
		}

		xturn = true;
	}

	public player winner() {

		//coin.turn();

		return coin.getCurrent();

	}

	public coin getCoin() {
		return coin;
	}

}