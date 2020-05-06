public class PruebaColaGenerica {
	public static void main(String[]args) {
		//Cola Entera
		System.out.println("--Cola Entera--");
		ColaGenerica<Integer>CI=new ColaGenerica<>(3);
		try {
		    CI.encolar(100);
		    CI.encolar(243);
		    //Sacar numero
		    int V=CI.sacar();
		    System.out.println("Sacamos "+V);
		    V=CI.sacar();
		    System.out.println("Sacamos "+V);
		    System.out.println("agregamos 10");
		    CI.encolar(10);
		}catch(ExcepcionColaLLena Err) {
			System.out.println(Err.getMessage());
		}catch(ExcepcionColaVacia Err) {
			System.out.println(Err.getMessage());
		}
		/////////////////////
		//Cola Double
		System.out.println("--Cola Double--");
		ColaGenerica<Double>CD=new ColaGenerica<>(3);
		try {
		    CD.encolar(1.34);
		    CD.encolar(2.56);
		    //Sacar numero
		    double D=CD.sacar();
		    System.out.println("Sacamos "+D);
		    D=CD.sacar();
		    System.out.println("Sacamos "+D);
		    System.out.println("agregamos 10.4567");
		    CD.encolar(10.4567);
		}catch(ExcepcionColaLLena Err) {
			System.out.println(Err.getMessage());
		}catch(ExcepcionColaVacia Err) {
			System.out.println(Err.getMessage());
		}
		///////////////////
		//Cola Cadena
		System.out.println("--Cola Cadena--");
		ColaGenerica<String>CS=new ColaGenerica<>(3);
		try {
		    CS.encolar("Gloria");
		    CS.encolar("Martinez");
		    //Sacar cadena
		    String S=CS.sacar();
		    System.out.println("Sacamos "+S);
		    S=CS.sacar();
		    System.out.println("Sacamos "+S);
		    System.out.println("agregamos Mendoza");
		    CS.encolar("Mendoza");
		}catch(ExcepcionColaLLena Err) {
			System.out.println(Err.getMessage());
		}catch(ExcepcionColaVacia Err) {
			System.out.println(Err.getMessage());
		}
		///////////////////////
		//Cola Estudiante
		System.out.println("--Cola Estudiante--");
		ColaGenerica<Estudiante>CE=new ColaGenerica<>(3);
		try {
			Estudiante e1,e2;
			e1=new Estudiante("Gloria","18590237");
			e2=new Estudiante("Manuel","18534569");
		    CE.encolar(e1);
		    CE.encolar(e2);
		    //Sacar cadena
		    Estudiante E=CE.sacar();
		    System.out.println("Sacamos a e1 ");
		    E=CE.sacar();
		    System.out.println("Sacamos a e2");
		    System.out.println("agregamos otro estudiante");
		    Estudiante e3=new Estudiante("Jorge","18590546");
		    CE.encolar(e3);
		}catch(ExcepcionColaLLena Err) {
			System.out.println(Err.getMessage());
		}catch(ExcepcionColaVacia Err) {
			System.out.println(Err.getMessage());
		}
	}
}
