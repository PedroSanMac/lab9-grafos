
public class TestGrafo {

	public static void main(String[] args) {
		
		GrafoAdyacencia<String> g = new GrafoAdyacencia<String>();
		
		g.insertVertice("lima");
		g.insertVertice("aqp");
		g.insertVertice("cusco");
		g.insertVertice("piura");
		g.insertVertice("tarapoto");
		
		g.insertArista("lima", "aqp",10);
		g.insertArista("cusco", "aqp",3);
		g.insertArista("piura", "lima",5);
		g.insertArista("cusco", "lima",8);
		g.insertArista("piura", "tarapoto", 9);
		
		System.out.println("Grafo:\n" + g);
		
		//g.DFS("aqp");
		//System.out.println();
		
	}

}
