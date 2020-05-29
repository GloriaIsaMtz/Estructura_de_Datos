import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class PruebasEncadenamientos {
	public static void main(String[] args) throws IOException {
		InputStreamReader r=new InputStreamReader(System.in);
		BufferedReader Teclado=new BufferedReader(r);
		String Pal="";
		String resp="";
		
		NodoCadena Inicial=null;
		NodoCadena SigNod=null;
		NodoCadena Actual=null;
		
		System.out.println("Bienvenido vamos a guardar Cadenas");
		do{
			System.out.println("Dame una palabra");
			Pal=Teclado.readLine();
			if(Inicial==null) {
				Inicial=new NodoCadena(null,Pal);
				Actual=Inicial;
			}else {
				SigNod=new NodoCadena(null, Pal);
				Actual.Siguiente=SigNod;
				Actual=SigNod;
			}
			System.out.println("Deseas agregar S/N");
			resp=Teclado.readLine();
		}while(resp.compareToIgnoreCase("S")==0);
		NodoCadena ref=Inicial;
		//String ref=Inicial;
		while(ref!=null) {
			System.out.println(ref);
			ref=ref.Siguiente;
		}
	
	}

}
