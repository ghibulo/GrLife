
class Board {
	int nRows, nCols;
	List< List<Place> > board;

	Board(int aRows, int aCols) {
		nRows = aRows;
		nCols = aCols;
		board = [];
		for (int j=0;j<nRows;j++) {
			def row = [];
			for (int i=0;i<nCols;i++) {
				row << new Place(occupied: false);
			}
			board << row;
		}
	}

	private int roundToBoard(int x, int max) {
		x = x%max
		x>=0?x:x+max
	}

	private int getNumNeighbours(int r, int c) {
		int s=0
		r=roundToBoard(r,nRows)
		c=roundToBoard(c,nCols)
		if (board[roundToBoard(r+1,nRows)][c].occupied) s++
		if (board[roundToBoard(r-1,nRows)][c].occupied) s++
		if (board[r][roundToBoard(c+1,nCols)].occupied) s++
		if (board[r][roundToBoard(c-1,nCols)].occupied) s++
		if (board[roundToBoard(r+1,nRows)][roundToBoard(c+1,nCols)].occupied) s++
		if (board[roundToBoard(r+1,nRows)][roundToBoard(c-1,nCols)].occupied) s++
		if (board[roundToBoard(r-1,nRows)][roundToBoard(c-1,nCols)].occupied) s++
		if (board[roundToBoard(r-1,nRows)][roundToBoard(c+1,nCols)].occupied) s++
		return s
	}

	void round() {
			for (int i=0;i<nRows;i++) {
				for (int j=0;j<nCols;j++) {
					int neighb = getNumNeighbours(i,j)
					switch (neighb) {
						case [0,1]: setPosition(i,j,false,false);break; //underpopulation -> death
						case 2: setPosition(i,j,board[i][j].occupied,false);break; //let living
						case 3: setPosition(i,j,true,false);break; //let living or reborning
						case { it > 3 }: setPosition(i,j,false,false);break; //overpopulation -> death
						default: println("error switch")
					}
				}
			}
			//turn future to now
			for (int i=0;i<nRows;i++) {
				for (int j=0;j<nCols;j++) {
					board[i][j].turnToNow();
				}
			}
	}

	void setPosition(int r, int c, Boolean life = true, Boolean now = true) {
		if (now) {
			board[r][c].occupied = life
		} else {
			board[r][c].future = life
		}
	}

	void printBoard () {
			//println(board)
			for (i in 0..(nRows-1)) {
				for (int j=0;j<nCols;j++) {
					if (board[i][j].occupied) {
						print 1
					} else {
						print 0
					}
				}
				println()
			}
			println "Finito!"
	}

}
