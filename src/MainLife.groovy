/*
 * Main class - setting start position and generate the html document
 */


class MainLife {
	
	static void testReversePos() {
		//testing
		ReversePos pok = new ReversePos()
		pok.x=10
		pok.y=12
		pok.variation[0][2]=1
		//pok.variation[1][1]=1
		//pok.variation[2][1]=1
		ReversePos pok2 = new ReversePos()
		pok2.x = 10
		pok2.y = 11
		pok2.variation[2][1]=-1
		//pok2.variation[1][1]=1
		
		println pok.join(pok2).variation
	}
	
	
	

	static void testing (String[] args) {

		//testReversePos()
		ReversePlaceVariation pom = new ReversePlaceVariation()
	}
	static void main(String[] args) {
		Board b = new Board(15,20)
		b.setPosition(5, 8)
		b.setPosition(4, 9)
		b.setPosition(5, 9)
		b.setPosition(5, 10)
		//println b.getNumNeighbours(3, 3)
	
		HtmlView hv = new HtmlView("result.html")
		hv.addTable(b, "Poèáteèní pozice:")
		for (i in 1..25) {
			b.round()
			b.printBoard()
			hv.addTable(b, "Pozice èíslo ${i}:")
		}
		hv.createHtml()
	 }

}
