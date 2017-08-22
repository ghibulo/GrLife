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
