
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
		GrafoAdyacencia<String> x = new GrafoAdyacencia<String>();
		x.insertVertice("aqp");
		x.insertVertice("lima");
		x.insertArista("aqp", "lima");
		System.out.println("GRAFO:\n"+x);
		
		System.out.println(g.estaEn(x));
	}

}
