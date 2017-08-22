
class MainLife {

	static void main(String[] args) {
		Board b = new Board(15,20)
		b.setPosition(2, 3)
		b.setPosition(1, 4)
		b.setPosition(2, 4)
		b.setPosition(2, 5)
		println b.getNumNeighbours(3, 3)
		println b.getNumNeighbours(2, 2)
		println b.getNumNeighbours(1, 4)
		println b.getNumNeighbours(1, 1)
		HtmlView hv = new HtmlView("vystup2.html")
		hv.addTable(b, "Poèáteèní pozice:")
		for (i in 1..15) {
			b.round()
			b.printBoard()
			hv.addTable(b, "Pozice èíslo ${i}:")
		}
		hv.createHtml()
	 }

}
