public class Estudiante{
	private String Nombre;
	private String NoControl;
	public Estudiante(String Nombre,String NoControl){
		this.Nombre = Nombre;
		this.NoControl = NoControl;
	}
	public String toString(){
		return Nombre + "\n" + NoControl;
	}
}

