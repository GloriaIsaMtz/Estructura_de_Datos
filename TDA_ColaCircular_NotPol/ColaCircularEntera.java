public class ColaCircularEntera {
	private int Vuelta[];
	private int Frente;
	private int Siguiente;
	public ColaCircularEntera(int N) {
		Vuelta=new int[N];
		//Posición inicial de Siguiente
		Siguiente=0;
		//Posicion inicial de Frente
		Frente=-1;
	}
  
	public boolean colaLLena() {
		if((Siguiente==Vuelta.length)) {
			return true;
		}else {
			return false;
		}
	}
	public void encolar(int Num) throws ExcepcionColaCirLLena{
		//si la cola esta vacia
		//reset
		 if(colaVacia()&(Espacio()==true)) {
			System.out.println("//Reset");
			Frente=-1;
			Siguiente=0;
		}
		if(colaLLena()) {
			throw new ExcepcionColaCirLLena();
		}	 
		Vuelta[Siguiente]=Num;
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
	public int sacar() throws ExcepcionColaCirVacia {
		if(colaVacia()) {
			throw new ExcepcionColaCirVacia();
		}
		int valor=Vuelta[Frente];
		Frente++;
		return valor;
	}
	public boolean Espacio() { 
	    //EL MODULO TE DICE CUANTAS POSICIONES VACIAS TIENES EN FRENTE
	    int PosicionesVaciasFrente;
	    PosicionesVaciasFrente=((Frente+1)%Vuelta.length);
	      if(PosicionesVaciasFrente>0) {
	    	 //System.out.println("Hay Espacio para otro dato");
		     return true;
	       }else {
		     return false;
	       }
       }
	public int ObtenerFrente() {
		return Frente;
	}
  }
  

