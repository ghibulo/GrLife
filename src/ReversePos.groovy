/* every living cell has a list of these classes
 * and every ReversePos represents a possible variation
 * which was the beginning of this cell
 */

class ReversePos {
	//position of the centre on the matrix
	int x
	int y
	Boolean isValid = true

	ReversePos(ArrayList v) {
		variation = v
	}

	/*
	 * (-1) -> can't be
	 * (0)  -> doesn't matter
	 * (1)  -> must be
	 */
	def variation = new int[3][3]


	void updateCoord(x,y) {
		this.x=x
		this.y=y
	}

	ReversePos join (ReversePos another) {
		def delx = x-another.x
		def dely = y-another.y
		def result = new ReversePos()

		if ((delx<-2)||(delx>2)||(dely<-2)||(dely>2)) return true

		//tmp - what is overlapping
		def tmp = new int[3][3]
		for (int j=0;j<3;j++) {
			for (int i=0;i<3;i++) {
				def tx = i-delx
				def ty = j-dely
				if ((ty<0)||(ty>2)) break //this j is cursed
				if ((tx>=0)&&(tx<3)) {
					tmp[ty][tx]=another.variation[j][i]
				}
			}
		}

		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				if (variation[i][j]*tmp[i][j] == -1) { //only 1 * (-1) is incompatible
					result.isValid=false
					return result
				} else {
					// 1 or (-1) is more important than 0
					if (tmp[i][j] == 0) {
						result.variation[i][j]=variation[i][j]
					} else {
						result.variation[i][j]=tmp[i][j]
					}
				}
			}
		}
		return result
	}


}
