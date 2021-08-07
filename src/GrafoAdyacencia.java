

public class GrafoAdyacencia {
	
	private class Vertice<E>{
        public E data;
        public ListaEnlazada<Arista<E>> listAdj;
        public Vertice(E val){
            this.data = val;
            this.listAdj = new ListaEnlazada<Arista<E>>();
        }
        public boolean equals(Object o) {
        	if(o instanceof Vertice<?>) {
        		Vertice<E> v = (Vertice<E>)o;
        		return this.data.equals(v.data);
        	}
        	return false;
        }
        public String toString() {
        	return this.data+" --> "+this.listAdj.toString()+"\n";
        }
    }
	private class Arista<E>{//clase arista
		Vertice<E> refDest;
		public Arista(Vertice<E> refDestino) {
			this.refDest = refDestino;
		}
		public boolean equals(Object o) {
			if(o instanceof Arista<?>) {
				Arista<E> e = (Arista<E>)o;
				return this.refDest.equals(e.refDest);
			}
			return false;
		}
		public String toString() {
			return refDest.data + ", ";
		}
	}
	
	

}
