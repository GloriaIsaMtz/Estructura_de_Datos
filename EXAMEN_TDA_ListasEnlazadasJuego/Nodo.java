public class Nodo {
	public Nodo Siguiente;
	private int Data;
	public Nodo(Nodo Sig,int Data) {
		this.Siguiente=Sig;
		this.Data=Data;
	}
	public int obtenerData() {
		return Data;
	}
	public void colocarData(int Data) {
		this.Data=Data;
	}
	public String toString() {
		return "Data: "+Data;
	}
	

}
