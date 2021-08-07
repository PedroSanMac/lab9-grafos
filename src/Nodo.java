

public class Nodo<E>{
	public E data;
	public Nodo<E> next = null;
	
	public Nodo(E val, Nodo<E> sig){
           this.data = val;
           this.next = sig;
    }
	
	public Nodo<E> getNext(){
		return this.next;
	}
	public E getData() {
		return data;
	}	
}
	