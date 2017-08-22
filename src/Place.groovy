/*
 * Class representing a place on the board
 * occupied - is there a living cell now?
 * future - is going to be there a living cell?
 */
class Place {
	Boolean occupied;
	Boolean future;
	void turnToNow() {
		occupied = future
	}
	def output() {
		return occupied?"X":" ";
	}
}
