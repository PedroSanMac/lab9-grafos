import ListaEnlazada.Enlace;

public class GrafoAdyacencia {
	
	private class Vertice<E>{
        public E valor;
        public Vertice siguiente;
        public Vertice adyacente;
        public Vertice(E val, Vertice ady){
            this.valor = val;
            this.adyacente = ady;
        }
    }
	
	

}
