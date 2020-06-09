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
	// SE CREAN LAS CLASES DE LISTAS ENLAZADAS
	ListaEnlazadaMat LH = new ListaEnlazadaMat();
	ListaEnlazadaMat LR = new ListaEnlazadaMat();
	ListaEnlazadaMat LM = new ListaEnlazadaMat();
	
	//Variable Tipo Material
	 int VarTM=0;
	 //Resina Completa
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
				  LM.apilar(al);
				 // System.out.println("M");//Conteo de las Maderas
				  if((LM.cantidad()==4)&(Mesa==false)) {  
					  Mesa=true;
					  System.out.println("---> Mesa adquirida");
					  //vaciar la pila
	                    LM.sacar();
	                    LM.sacar();
	                    LM.sacar();
	                    LM.sacar(); 
	                  //  System.out.println(LM.cantidad());
				  }if((LM.cantidad()==2)&(Baston==false)&(Mesa)) {
					  LM.sacar();
	                  LM.sacar();
	                 // System.out.println(LM.cantidad());
					  Baston=true;
					  System.out.println("---> Baston adquirido");
				  } 
				 // System.out.println(" Madera esta completa");
				  if((LM.cantidad()>=5)&(Mesa)&(Baston)&(Cuerda)&(Cana_p)) {
					  Barco=true;
					  System.out.println("---> Barco adquirido!!\n---  B I G  S H I P :)  ---");
					  System.exit(0);
				  }
			  }catch(DesbordamientoMateriales E) {	
				  System.out.println(E.getMessage()+" Madera esta Completa");
			  }
			  //RESINA
		}if(VarTM==1) {
			  try {
			 LR.apilar(al); 
			 //condicion de Resina Completa
		       if(ResinaC==false) {
			    ResinaC=true;
			    //Vaciar pila de Resina
			     LR.sacar();
			     }  
		   }catch(DesbordamientoMateriales E) {
			  System.out.println(E.getMessage()+" Resina esta Completa ");
		   }
		 }//HILO
		  if(VarTM==2){
			  try {
			  LH.apilar(al);
			  if((Cuerda==false)&(Mesa)&(ResinaC)&(Baston)) { //solo que aquí no evaluamos la cantidad que hay en la pila ya que esta desbordada
				  Cuerda=true;
				  System.out.println("---> Cuerda adquirida");
				  //vaciar la Pila de Hilo
                  LH.sacar();
                  LH.sacar();
                  LH.sacar();
                  LH.sacar();
                 // System.out.println(LH.cantidad());
			    }
				 //inmediatamente comparar si se cumple lo necesario para la caña
			   if((Cana_p==false)&(Mesa)&(Baston)&(Cuerda)) {
		    	  Cana_p=true;
		    	  System.out.println("---> Cana de Pescar Adquirida");
			     }
		    }catch(DesbordamientoMateriales E) {
			  System.out.println(E.getMessage()+" Hilo esta completa ");
		      }
		    }   
	    }
	}
}

