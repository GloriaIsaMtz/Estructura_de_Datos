import java.util.Random;
public class Juego {
	public static void main(String[] args) throws SubDesbordamientoMateriales{
		// TODO Auto-generated method stub
	System.out.println("B I E N V E N I D O\n"+
			"----BIG SHIP----- ");	
	//herramientas
	boolean Mesa=false;
	boolean Barco=false;
	boolean Baston=false;
	boolean Cana_p=false;
	boolean Cuerda=false;
	//crear una variable aleatoria para definir los materiales
	int tipAl=0;//Tipo Aleatorio
	int al=0;//aleatorio
	// SE CREAN LAS CLASES GENERICAS PARA CADA MATERIAL
	//se crea la clase generica HILO
	  PilaMaterial<Integer> PH = new PilaMaterial<>(4);//numero max que puede llegar a tener
	//se crea la clase generica RESINA
	  PilaMaterial<Integer> PR = new PilaMaterial<>(1);//numero max que puede llegar a tener
	  //se crea la clase generica MADERA
	  PilaMaterial<Integer> PM = new PilaMaterial<>(5);//numero max que puede llegar a tener
	
	  //primero crear un arreglo para que se guarden todos los materiales para despues utilizarlos
	  //----> Vector auxiliar----> Quitar int mat[]=new int[30];
	  //Crear una variable para guardar el tipo de material que se ira modificando 
	  int VarTM=0;
	boolean ResinaC=false;
	//--------------Empieza el juego-----------------
	for(int x=0;x<30;x++) {
		//Definir el tipo de material
		VarTM=(int)(Math.random()*(2-(-1)));
		//se define lo que se va apilar (Numero aleatorio)
		al=(int)(Math.random()*(10-1));
		//MADERA
		if(VarTM==0) { 
			  try {
				  PM.apilar(al);
				 // System.out.println("M");//Conteo de las Maderas
				  if((PM.cantidad()==4)&(Mesa==false)) {  
					  Mesa=true;
					  System.out.println("Mesa adquirida");
					  //vaciar la pila
					  PM.vaciarComple();  
				  }if((PM.cantidad()==2)&(Baston==false)&(Mesa)) {
					  Baston=true;
					  System.out.println("Baston adquirido");
					//vaciar la pila
					  PM.vaciarComple(); 
				  }
			  }catch(DesbordamientoMateriales E) {
				  System.out.println(E.getMessage()+" Madera esta completa");
				  if((Barco==false)&(Mesa)&(Baston)&(Cuerda)&(Cana_p)) {
					  Barco=true;
					  System.out.println("Barco adquirido!!\n---  B I G  S H I P :)  ---");
					  //Vaciar la pila
					  PM.vaciarComple();
					  //impresion de vector con materiales
					  //System.out.println("      MATERIALES EN EL MAPA:");
					   //  PilaMaterial.impVectorM(mat);
					  //Termina el programa con gane
					  System.exit(0);
				  }
			  }
			  //RESINA
		}if(VarTM==1) {
			  try {
			 PR.apilar(al);
		   }catch(DesbordamientoMateriales E) {
			  System.out.println(E.getMessage()+" Resina esta Completa :v");
			 //condicion aquí
		       if(ResinaC==false) {
			    ResinaC=true;
			    //Vaciar pila de Resina
			     PR.vaciarComple();
			     }
			   }  
		 }//HILO
		  if(VarTM==2){
			  try {
			  PH.apilar(al);
		    }catch(DesbordamientoMateriales E) {
			  System.out.println(E.getMessage()+" Hilo esta completa ");
			  if((Cuerda==false)&(Mesa)&(ResinaC)&(Baston)) { //solo que aquí no evaluamos la cantidad que hay en la pila ya que esta desbordada
				  Cuerda=true;
				  System.out.println("Cuerda adquirida");
				  //vaciar la Pila de Hilo
				  PH.vaciarComple();
			    }
				 //inmediatamente comparar si se cumple lo necesario para la caña
			   if((Cana_p==false)&(Mesa)&(Baston)&(Cuerda)) {
		    	  Cana_p=true;
		    	  System.out.println("Cana de Pescar Adquirida");
			     }
		      }
		    }   
	    }
	//imprimir el vector para ver los materiales en el mapa
	//System.out.println("      MATERIALES EN EL MAPA:");
     //PilaMaterial.impVectorM(mat);
	}
}

