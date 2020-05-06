 /*
 * NotaciÃ³n prefija o Polaca es una 

 * forma de escribir operaciones diferente a 
 * la ordinaria
 * Ejemplo 
 * 		Normal ==> Polaca
 * 		3 + 4  ==> + 3 4 
 * 
 * Siempre usamos un <espacio> entre los
 * operandos y la operaciÃ³n va al principio,
 * y se repite hasta terminar con los operandos
 * 
 *   + 3 10 
 *   13
 * Los operandos se toman de dos en dos
 * por lo que :
 * 
 *   + 4 5 6 7
 * 
 * implica primero resolver: 4 + 5 = 9
 * 
 * + 9 6 7
 * 
 * volvemos a tomar dos numeros: 9 + 6 = 15
 * 
 * + 15 7
 * 
 * repetimos hasta que no haya mÃ¡s: 15 + 7
 * 
 * 22
 * 
 * 
 * Nota:
 * La notacion polaca no funciona exactamente
 * como la describi aqui, en Automatas I y II
 * se vera a profundidad.
 * 
 * Ejercicio
 * Escribir una calculadora basica en notacion
 * polaca para aplicar operaciones basicas de
 * Suma, Resta, Multiplicacion y Division
 * que implemente una cola circular que
 * soporte 1 Operacion y 5 operandos.
 * Escriba el resultado e imprima.
 * Corrida de escritorio


 * 
 * Bienvenido a este programa!
 * Escribe tu operacion:
 * > +
 * Escribe el operando 1:
 * > 1
 * Escribe el operando 2:
 * > 2
 * Escribe el operando 3:
 * > 3
 * Escribe el operando 4:
 * > 4
 * Escribe el operando 5:
 * > 5
 * 
 * El resulado es 15
 * Notacion Polaca: + 1 2 3 4 5 
 **/
 
/* Nota Mia: Esta Calculadora de Notacion Polaca se resuelve a mi opinion o punto de Vista con una
 * Cola Simple, no necesariamente tendria que ser circular, ya que el número lo tenemos definido,
 * A lo que yo entendi la cola circular es cuando no sabemos y queremos "Reutilizar" el espacio dejado
 * por las variables "Sacadas o desencoladas"
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Calculadora {

	public static void main(String[] args) throws IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("---Bienvenidos a este programa---");
		int Op=0;
		int Ope1=0,Ope2=0,Ope3=0,Ope4=0,Ope5=0;
		String Signo="";
		//Los Operandonos que se pidan se guardará en una cola circular Tipo Entera
		ColaCircularEntera ColNP=new ColaCircularEntera(5);
		System.out.println("Elije una Operacion \n 1)Suma  2)Resta  3)Multiplicacion 4)Division" );
		Op=Integer.parseInt(teclado.readLine());
		//Pedir primero los operandonos antes de entrar al switch
		try{
			System.out.println("Escribe el Operando 1:");
			Ope1=Integer.parseInt(teclado.readLine());
		    ColNP.encolar(Ope1);
		    System.out.println("Escribe el Operando 2:");
		    Ope2=Integer.parseInt(teclado.readLine());
		    ColNP.encolar(Ope2);
		    System.out.println("Escribe el Operando 3:");
		    Ope3=Integer.parseInt(teclado.readLine());
		    ColNP.encolar(Ope3);
		    System.out.println("Escribe el Operando 4:");
		    Ope4=Integer.parseInt(teclado.readLine());
		    ColNP.encolar(Ope4);
		    System.out.println("Escribe el Operando 5:");
		    Ope5=Integer.parseInt(teclado.readLine());
		    ColNP.encolar(Ope5);
		}catch(ExcepcionColaCirLLena Err) {
			System.out.println(Err.getMessage());
		}
		//Tipo decimal por que en la division es muy comun que de 0 con numeros decimales
		float NumSacado=0;
		float NumNuevo=0;
		switch(Op) {
		    case 1:
		    	Signo="+";
		    	try {
		    		while(!ColNP.colaVacia()) {
		    	      NumSacado=ColNP.sacar();
		    	      NumNuevo=NumSacado+NumNuevo;
		    		    }
		    	     }catch(ExcepcionColaCirVacia Err) {
					      System.out.println(Err.getMessage());
		    	      }
			    break;
		    case 2:
		    	Signo="-";
		    	try {
		    		while(!ColNP.colaVacia()) {  
		    			NumSacado=ColNP.sacar();
		    			   if(ColNP.ObtenerFrente()==1) {
		    	              NumNuevo=NumSacado-NumNuevo;
		    		        }else {
		    			      NumNuevo=NumNuevo-NumSacado;
		    		           } 
		    		        }
		    	   }catch(ExcepcionColaCirVacia Err) {
					  System.out.println(Err.getMessage());
		    	}
		    	break;
		    case 3:
		    	Signo="*";
		    	try {
		    		while(!ColNP.colaVacia()) {  
		    			NumSacado=ColNP.sacar();
		    			  if(ColNP.ObtenerFrente()==1) {
		    	             NumNuevo=NumSacado;
		    		      }else {
		    			   NumNuevo=NumNuevo*NumSacado;
		    		   } 
		    		}
		    	  }catch(ExcepcionColaCirVacia Err) {
					System.out.println(Err.getMessage());
		    	     }
		    	break;
		    case 4:
		    	Signo="/";
		    	try {
		    		while(!ColNP.colaVacia()) {  
		    			NumSacado=ColNP.sacar();
		    	        //System.out.println(NumSacado);
		    	        //System.out.println("Frente:"+ColNP.ObtenerFrente());
		    			if(ColNP.ObtenerFrente()==1) {
		    	           NumNuevo=NumSacado;
		    	           //System.out.println("--"+NumNuevo);
		    		    }else  {
		    			   NumNuevo=(NumNuevo)/(NumSacado);
		    	           //System.out.println(NumNuevo);
		    		   } 
		    		}
		    	}catch(ExcepcionColaCirVacia Err) {
					System.out.println(Err.getMessage());
		    	}
		    	break;
		    default:
		    	System.out.println("Ingresa una opcion valida");
		    	break;
		}
		System.out.println("El resultado es :"+NumNuevo);
		System.out.println("Notacion Polaca: "+Signo+" "+Ope1+" "+Ope2+" "+Ope3+" "+Ope4+" "+Ope5);
	}

}
