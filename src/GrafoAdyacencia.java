

public class GrafoAdyacencia<T> {
	
	public class Vertice<E>{//clase vertice
        public E data;
        public ListaEnlazada<Arista<E>> listAdj;
        public Vertice(E val){
            this.data = val;
            this.listAdj = new ListaEnlazada<Arista<E>>();
        }
        public boolean equals(Object o) {
        	if(o instanceof Vertice) {
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
			if(o instanceof Arista) {
				Arista<E> e = (Arista<E>)o;
				return this.refDest.equals(e.refDest);
			}
			return false;
		}
		public String toString() {
			return refDest.data + ", ";
		}
	}
	//*******************************************************************
	ListaEnlazada<Vertice<T>> listaVertices;
	
	public GrafoAdyacencia() {
		listaVertices = new ListaEnlazada<Vertice<T>>();
	}
	public void insertVertice(T data) {
		Vertice<T> nuevo = new Vertice<T>(data);
		if(this.listaVertices.search(nuevo) != null) {
			System.out.println("VERTICE YA INSERTADO..");
			return;
		}
		this.listaVertices.insertPrimero(nuevo);
	}
	public void insertArista(T verOri, T verDes) {
		Vertice<T> refOri =this.listaVertices.search(new Vertice<T>(verOri));
		Vertice<T> refDes =this.listaVertices.search(new Vertice<T>(verDes));
		
		if(refOri == null || refDes ==null) {
			System.out.println("VERTIVE NO EXISTE...");
			return;
		}
		if(refOri.listAdj.search(new Arista<T>(refDes)) != null) {
			System.out.println("Arista ya insertada antes ...");
			return;
		}
		//no dirigido.
		refOri.listAdj.insertPrimero(new Arista<>(refDes));
		refDes.listAdj.insertPrimero(new Arista<T>(refOri));
	}
	public String toString() {
		return this.listaVertices.toString();
	}
	//*******
	public boolean estaEn(GrafoAdyacencia<T> x) {
		Vertice<T> nuevo = x.listaVertices.primero.getData();
		if(this.listaVertices.search(nuevo) != null) {
			//System.out.println("Primer vertice si esta en el grafo..");
			return true;
		}else {
			//comparar si estan todos los elementos.
		}
		return false;
	}
	

}
