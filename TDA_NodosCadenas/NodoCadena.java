public class NodoCadena {
	public NodoCadena Siguiente;
	private String Data;
	public NodoCadena(NodoCadena Sig,String Data) {
		this.Siguiente=Sig;
		this.Data=Data;
	}
	public String obtenerData() {
		return Data;
	}
	public void colocarData(String Data) {
		this.Data=Data;
	}
	public String toString() {
		return "Palabra: "+Data;
	}
	

}