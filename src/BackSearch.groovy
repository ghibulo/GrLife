
/*
 * This class controls a procedure for searching a previous generation
 *
 *
 */
class BackSearch {

	List<ReversePlaceVariation> occupiedPlaces = []

	//to add a new ReversePlaceVariation for every living cell on the board
	BackSearch (Board b) {
		for (int i=0;i<b.nRows;i++)
			for (int j=0;j<b.nCols;j++) {
				if (b.board[i][j].occupied) {
					occupiedPlaces << new ReversePlaceVariation(i,j)
				}
			}
	}

	void startSearching() {



	}


}