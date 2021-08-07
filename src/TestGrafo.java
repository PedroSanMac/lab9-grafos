
public class TestGrafo {

	public static void main(String[] args) {
		
		GrafoAdyacencia<String> g = new GrafoAdyacencia<String>();
		
		g.insertVertice("lima");
		g.insertVertice("aqp");
		g.insertVertice("cusco");
		g.insertVertice("piura");
		g.insertVertice("tarapoto");
		
		g.insertArista("lima", "aqp");
		g.insertArista("cusco", "aqp");
		g.insertArista("piura", "lima");
		g.insertArista("cusco", "lima");
		g.insertArista("piura", "tarapoto");
		
		System.out.println("Grafo:\n" + g);
		
	}

}
