/*
 * container for every possibility that a given cell could live
 */

class ReversePlaceVariation {

	static {
		List<ReversePos> position = []
		def v = new int[3][3]
		v=[[ 1,  1,  1],
		   [-1,  0, -1],
		   [-1, -1, -1]]
		position.add(new ReversePos(v))

		v = new int[3][3]
		v=[[-1,  1,  1],
		   [-1,  0,  1],
		   [-1, -1, -1]]
		position.add(new ReversePos(v))

		v = new int[3][3]
		v=[[-1, -1,  1],
		   [-1,  0,  1],
		   [-1, -1,  1]]
		position.add(new ReversePos(v))

		v = new int[3][3]
		v= [[-1, -1, -1],
			   [-1,  0,  1],
			[-1,  1,  1]]
		position.add(new ReversePos(v))

		v = new int[3][3]
		v= [[-1, -1, -1],
			[-1,  0, -1],
			[ 1,  1,  1]]
		position.add(new ReversePos(v))

		v = new int[3][3]
		v= [[-1, -1, -1],
		  [-1,  0, -1],
		  [ 1,  1,  1]]
		position.add(new ReversePos(v))

		v = new int[3][3]
		v= [[-1, -1, -1],
		   [ 1,  0, -1],
		   [ 1,  1, -1]]
		position.add(new ReversePos(v))

		v = new int[3][3]
		v= [[-1, -1, -1],
			[ 1,  0, -1],
			[ 1,  1, -1]]
		position.add(new ReversePos(v))
		v = new int[3][3]
		v= [[ 1, -1, -1],
			[ 1,  0, -1],
			[ 1, -1, -1]]
		position.add(new ReversePos(v))

		v = new int[3][3]
		v= [[ 1,  1, -1],
			[ 1,  0, -1],
			[-1, -1, -1]]
		position.add(new ReversePos(v))

		v = new int[3][3]
		v= [[ 1,  1, -1],
			[-1,  1, -1],
			[-1, -1, -1]]
		position.add(new ReversePos(v))

		v = new int[3][3]
		v= [[ 1, -1,  1],
			[-1,  1, -1],
			[-1, -1, -1]]
		position.add(new ReversePos(v))

		// missing yet (8 over 2) ... cca 25 options

	}

	int x
	int y
	int actInd

	List<ReversePos> getList() {
		return position
	}

	Boolean anotherPosition() {
		if (++actInd <position.size()) return true else return false

	}

	ReversePlaceVariation(x,y) {
		this.x=x
		this.y=y
		currInd = 0
		}

	ReversePos getCurrentPos() {
		res = new ReversePos(position[currInd])
		res.updateCoord(this.x, this.y)
		return res
	}

}