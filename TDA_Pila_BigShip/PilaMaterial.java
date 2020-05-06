public class PilaMaterial<T>{
	private T Esquina[];
	private int indice;
	//contructor
	@SuppressWarnings("unchecked")
	public PilaMaterial(int n){
		// N es la cantidad de elementos
		// que puede guardar mi pila
		Esquina = (T[])new Object[n];
		indice = 0;
	}
	public int cantidad(){
		return indice ;//-1
	}
	public void apilar(T valor) throws DesbordamientoMateriales{
		if (this.llena()){
			throw new DesbordamientoMateriales();
		}
		Esquina[indice] = valor;
		indice++;
	}
	public T sacar() throws SubDesbordamientoMateriales{
		if(this.vacia()){
			throw new SubDesbordamientoMateriales();
		}
		T esacar;
		esacar = Esquina[indice-1];
		indice--;
		//indice--;
		//esacar = Esquina[indice];
		return esacar;
	}
	public boolean vacia(){
		if (indice == 0){
			return true;
		}
		return false;
	}
	public boolean llena(){
		if (indice == Esquina.length){
			return true;
		}
		return false;
	}
	public int capacidad(){
		return Esquina.length;
	}
	public void vaciarComple() throws SubDesbordamientoMateriales {
		while(!vacia()) {
		sacar();
	  }
	}
	//imprimir el vector de los materiales
	public static void impVectorM(int mat[]) {
		System.out.print("[");
		for(int j=0;j<mat.length;j++) {
			if(mat[j]==0) {
				System.out.print("M|");
			}if(mat[j]==1) {
				System.out.print("R|");
			}if(mat[j]==2) {
				System.out.print("H|");
			}if(j==mat.length/2) {
				System.out.println();
			}
		}
		System.out.print("]");
	}
}

