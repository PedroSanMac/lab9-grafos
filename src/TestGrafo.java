
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
		
		g.BFS("aqp");
		System.out.println();
		/*
		g.insertVertice("A");
		g.insertVertice("B");
		g.insertVertice("C");
		g.insertVertice("D");
		g.insertVertice("E");
		g.insertVertice("F");
		g.insertVertice("G");
		g.insertVertice("H");
		g.insertArista("A", "B");
		g.insertArista("A", "D");
		g.insertArista("D", "E");
		g.insertArista("D", "F");
		g.insertArista("D", "B");
		g.insertArista("B", "C");
		g.insertArista("C", "H");
		g.insertArista("H", "F");
		g.insertArista("F", "G");
		System.out.println("Grafo:\n" + g);
		
		g.BFS("A");
		System.out.println();
		*/
	}

}
