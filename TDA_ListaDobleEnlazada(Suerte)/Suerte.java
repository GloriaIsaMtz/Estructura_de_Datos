/*
 * El numero de la suerte

 * 
 * Realice un programa que permita al usuario agregar
 * numeros enteros a voluntad con la restriccion de que
 * al menos deben ser 5 numeros.
 * 
 * Imprima al derecho y al reves dichos numeros.
 * 
 * Luego con un generador de numeros aleatorios simulen
 * el lanzamiento de una moneda. (Sugiero usar nextBoolean)
 * 
 * Si la moneda cae cara eliminan un numero del principio
 * Si la moneda cae cruz eliminan un numero del final
 * 
 * Este proceso continua hasta que solo quede un numero
 * dicho numero sera deplegado como el numero de la suerte.
 * 
 * Corrida de escritorio
 * ///////////////////////////////////////////////////////
 * Bienvenido a este programa que calcula tu numero de la
 * Suerte.
 * 
 * Por favor dame un numero entero:
 * 1
 * Por favor dame un numero entero:
 * 45
 * Por favor dame un numero entero:
 * 63
 * Por favor dame un numero entero:
 * 68
 * Por favor dame un numero entero:
 * 128
 * Deseas agregar otro numero S / N
 * S
 * Por favor dame un numero entero:
 * 343
 * Deseas agregar otro numero S / N
 * N
 * Tus numeros:
 * 1 45 63 68 128 343
 * 343 128 68 63 45 1
 * Procesado ....
 * Se lanzo la moneda 5 Veces
 * Tu numero de la suerte es: 128
 */ 
import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.Random;
public class Suerte {
	    public static void main(String[] args) throws IOException{
	        BufferedReader Teclado = new BufferedReader(new InputStreamReader(System.in));
	        Random Generador = new Random();
	        ListaDobleEnlazada L = new ListaDobleEnlazada();
	        boolean Moneda=false;
	        boolean PrimerosNumeros=true;
	        int Num=0,NumEl=0;
	        int contador=4;
	        String Resp="";
	        do{
	            System.out.println("Por favor dame un numero entero:");
	            Num=Integer.parseInt(Teclado.readLine());
	            L.agregarAlInicio(new Nodo<Integer>(Num,1));
	            if(PrimerosNumeros){
	                for(int i=0;i<4;i++){
	                    System.out.println("Por favor dame un numero entero:");
	                    Num=Integer.parseInt(Teclado.readLine());
	                    L.agregarAlInicio(new Nodo<Integer>(Num,1));
	                
	                }
	                PrimerosNumeros=false;
	            }
	            contador++;
	            System.out.println("Deseas agregar otro numero S / N");
	            Resp=Teclado.readLine(); 
	        }while(Resp.compareToIgnoreCase("S")==0);
	        System.out.println("Tus numeros:");
	        System.out.println(L.toStringReverse());
	        System.out.println(L);      
	        System.out.println("Procesando......");
	        NumEl = (L.obtenerNoElementos())-1;
	        for(int j=0;j<NumEl;j++){
	            Moneda = Generador.nextBoolean();
	            /*
	                cara = true
	                cruz = false
	            */  
	            if(Moneda==true){
	                Nodo Eliminado =L.eliminarAlInicio();
	            }
	            if(Moneda==false){
	                Nodo Eliminado =L.eliminarAlFin();      
	            }
	        }
	        System.out.println("Se lanzo la moneda "+ contador +" Veces");
	        System.out.println("NUMERO DE LA SUERTE = "+ L);
	    }  
	}

