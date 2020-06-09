
public class ListaEnlazadaMat <T> extends ListaEnlazada {
	private ListaEnlazada Esquina;
	private int indice;
	// constructor
	@SuppressWarnings("unchecked")
	public ListaEnlazadaMat(){
		// N es la cantidad de elementos
		// que puede guardar mi pila
		Esquina = new ListaEnlazada();
		indice = 0;
	}
	public int cantidad(){
		return indice ;
	}
	public void apilar(int n)throws DesbordamientoMateriales{
	   Esquina.agregarAlInicio(new Nodo(null,n));
	   indice ++;
     }
	public Nodo sacar()throws SubDesbordamientoMateriales{ 
		Nodo esacar= Esquina.EliminarAlInicio();
		indice--;
		return esacar;
		}
}
