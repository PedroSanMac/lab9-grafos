
public class ListaEnlazada<T> {
	
	protected Nodo<T> primero;
	
	public ListaEnlazada() {
		this.primero = null;
	}
	
	public boolean isEmpty() {
		return this.primero == null;
	}
	public T search(T data) {
		Nodo<T> nodo = this.primero;
		while (nodo != null && !nodo.data.equals(data)) {
			nodo = nodo.getNext();
		}	
		if(nodo != null)
			return nodo.data;	
		return null;
	}
	
	void insertPrimero(T data) {
		this.primero = new Nodo<T>(data, this.primero);
	}
	
	public String toString() {
		String rpta = "";
		Nodo<T> aux = this.primero;
		while(aux != null) {
			rpta = rpta+aux.getData();
			aux = aux.getNext();
		}
		return rpta;
	}
	
	public T remove(T data) {
		T item = null;
		Nodo<T> aux = this.primero;
		if(this.primero != null && this.primero.data.equals(data)) {
			item = primero.data;
			primero = primero.getNext();
		}
		else {
			while (aux.next != null && !aux.next.data.equals(data)) {
				aux = aux.getNext();
			}
			if(aux.getNext() != null) {
				item = aux.next.data;
				aux.next = aux.next.next;
			}
		}
		return item;
		
	}

}
