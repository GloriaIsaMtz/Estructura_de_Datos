public class ColaNumEntero {
	private int Esquina[];
	private int Frente;
	private int Siguiente;
	public ColaNumEntero(int N) {
		Esquina=new int[N];
		//Posición inicial de Siguiente
		Siguiente=0;
		//Posicion inicial de Frente
		Frente=-1;
	}
	public boolean colaLLena() {
		if(Siguiente==Esquina.length) {
			return true;
		}else {
			return false;
		}
	}
	public void encolar(int Num) throws ExcepcionColaLLena{
		//si la cola esta vacia
		//reset
		if(colaVacia()) {
			System.out.println("//Reset");
			Frente=-1;
			Siguiente=0;
		}
		if(colaLLena()) {
			throw new ExcepcionColaLLena();
		}
		Esquina[Siguiente]=Num;
		Siguiente++;
		//cuando apenas agregue un elemento
		if(Siguiente==1) {
			Frente=0;
		}
	}
	public boolean colaVacia() {
		if(Frente==Siguiente) {
			return true;
		}else if(Frente==-1) {
			return true;
		}else {
			return false;
		}
	}
	public int sacar() throws ExcepcionColaVacia {
		if(colaVacia()) {
			throw new ExcepcionColaVacia();
		}
		int valor=Esquina[Frente];
		Frente++;
		return valor;
	}
	

}
