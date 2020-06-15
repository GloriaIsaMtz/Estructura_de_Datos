public class Arbol {
	private Nodo raiz;
	public Arbol() {
		raiz=null;
	}
	//Metodo a envolver 
	private void insertarDesde(Nodo noda, Nodo Desde) {
		if(Desde.obtenerData()==noda.obtenerData()) {
			return;
		}
		if(noda.obtenerData()> Desde.obtenerData()) {
			//Colocar a la derecha
			if(Desde.Der==null) {
				Desde.Der=noda;
				return;
			}else {
				//11
				insertarDesde(noda, Desde.Der);
				return;
			}
		}else {
			//Colocar a la izquierda
			if(Desde.Izq==null){
				Desde.Izq=noda;
				return;
			}else {
				//nodo 5
				insertarDesde(noda,Desde.Izq);
				return;
			}
		}
	}
	//Metodo que envuelve wrapper
	public void insertar(Nodo noda) {
		//Es decir es el primer elemento
		//Esto pasa cuando la raiz es nula
		if(raiz==null){
			raiz=noda;
			return;//termina el metodo
		}
		///////////////
		//si llego aqui la raiz no es nula
		insertarDesde(noda,raiz);
	}
	public boolean buscar(Nodo noba) {
		return buscarDesde(noba, raiz);
	}
	private boolean buscarDesde(Nodo noba, Nodo Desde) {
		if(Desde==null) {
			return false;
		}
		//Es cuando el nodo es el encontrado
		if(Desde.obtenerData()==noba.obtenerData()) {
			return true;
		}
		if(noba.obtenerData()>Desde.obtenerData()) {
			//derecha
			return buscarDesde(noba, Desde.Der);
		}else {
			//izquierda
			return buscarDesde(noba, Desde.Izq);
		}
	}
}
