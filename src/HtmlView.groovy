import java.util.List
import groovy.xml.*

class HtmlView {
	FileWriter outFile
	List listTables
	
	HtmlView (outfilename) {
		this.outFile = new FileWriter(outfilename)
		listTables = []
	}


	
	def addTable(Board b, String title) {
		StringWriter buffer = new StringWriter()
		MarkupBuilder markup = new MarkupBuilder(buffer)
		markup.table(border:1,style:"border-collapse:collapse"){
			h2 title

				b.board.eachWithIndex{itl, i ->
					(tr {
						//println "htmlv> "+i+" "+ itl
						itl.each{
							td(align:"center",width:"100px", height:'20px',it.output())
						}
					})
		
				}
		}
		listTables << buffer		
				
	}
		
	
	
	void createHtml() {
		MarkupBuilder markup = new MarkupBuilder(outFile)
		markup.html{
			head { meta (charset:"cp1250")}
			listTables.each {
				mkp.yieldUnescaped(it)
			}
		}
	}
	
	
}
	









/*
def writer = new FileWriter('output.html')
def markup = new groovy.xml.MarkupBuilder(writer) // the builder
markup.html{
	table {
		for (i in 1..5){ tr { td(class:"row", "hello world!") } }
	}
}*/