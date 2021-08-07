
public class GrafoAdyacencia<T> {
	
	public class Vertice<E>{//clase vertice
        public E data;
        public ListaEnlazada<Arista<E>> listAdj;
        int estado; //0=noExplorado, 1=Explorado
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
		int costo = -1;// se usa en grafos ponderados.
		int estado; //0=sinExplorar, 1=Descubierto, 2=AristaBack
		public Arista(Vertice<E> refDestino) {
			this(refDestino,-1);
		}
		public Arista(Vertice<E> refDestino, int peso) {
			this.refDest = refDestino;
			this.costo = peso;
		}
		public boolean equals(Object o) {
			if(o instanceof Arista) {
				Arista<E> e = (Arista<E>)o;
				return this.refDest.equals(e.refDest);
			}
			return false;
		}
		public String toString() {
			if(this.costo > -1) 
				return refDest.data + " ["+this.costo+"],";
			else 
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
		this.insertArista(verOri, verDes, -1);
	}
	
	public void insertArista(T verOri, T verDes, int peso) {
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
		refOri.listAdj.insertPrimero(new Arista<>(refDes, peso));
		refDes.listAdj.insertPrimero(new Arista<T>(refOri, peso));
	}
	public String toString() {
		return this.listaVertices.toString();
	}
	//****METODOS para BFS
	private void initLable() {
		Nodo<Vertice<T>> aux = this.listaVertices.primero;
		for(;aux != null; aux= aux.getNext()) {
			aux.data.estado = 0;
			Nodo<GrafoAdyacencia<T>.Arista<T>> auxE = aux.data.listAdj.primero;
			for(;auxE != null; auxE = auxE.getNext())
				auxE.data.estado = 0;
		}
	}
	public void BFS(T data) {
		Vertice<T> v = this.listaVertices.search(new Vertice<T>(data));
		if(v == null) {//existe el vertice donde empezar?
			System.out.println("VERTICE NO EXISTE..");
			return;
		}
		initLable();
		BFSRec(v);
	}
	private void BFSRec(Vertice<T> v) {
		v.estado = 1;
		System.out.print(v.data+", ");
		Nodo<Arista<T>> e = v.listAdj.primero;
		for(;e != null; e = e.getNext()) {
			if(e.data.estado == 0) {
				Vertice<T> w = e.data.refDest;
				if(w.estado == 0) {
					e.data.estado = 1;
					DFSRec(w);
				}else
					e.data.estado = 2;
			}
		}
	}

}
