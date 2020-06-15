public class ListaDobleEnlazada {
    // Referencia al inicio
    private Nodo Inicio;
    // Referencia al fin
    private Nodo Fin;
    private int NoElementos;
    public ListaDobleEnlazada(){
        Inicio = null;
        Fin = null;
        NoElementos =0;
    }
    public int obtenerNoElementos(){
        return NoElementos;
    }
    public void agregarAlInicio(Nodo Agregar){
        // Caso cuando no tengo nodos
        if(Inicio == null){
            Inicio = Agregar;
            Fin = Agregar;
            NoElementos ++;
        }else{// mi lista al menos tiene un nodo
            Agregar.Siguiente = Inicio;
            Inicio.Anterior = Agregar;
            Inicio = Agregar;
            NoElementos ++;
        }    
    }
      
    public void agregarAlFinal(Nodo Agregar){
        // Caso cuando no tengo nodos
        if(Fin == null){
            Fin = Agregar;
            Inicio = Agregar;
            NoElementos++;
        }else{ // mi lista tiene al menos un nodo
            Fin.Siguiente = Agregar;
            Agregar.Anterior = Fin;
            Fin = Agregar;
            NoElementos++;
        }
    }
    
    public boolean buscar(Nodo Buscar){
        // Nodo no es null
        if(Buscar != null){
            if(Inicio !=null){
                if(Inicio.obtenerData() == Buscar.obtenerData()){
                    return true;
                }
            }
            if(Fin !=null){
                if(Inicio.obtenerData() == Buscar.obtenerData()){
                    return true;
                }
            }
            // Si el elemento a buscar no esta ni en el inicio o el fin
            Nodo ref = Inicio;
            boolean Encontrado = false;
            while((ref != null) && !Encontrado){
                // si esto es cierto el nodo fue encontrado
                //System.out.println("=>"+ref);
                //System.out.println("=>"+AB);
                if(ref.obtenerData() == Buscar.obtenerData()){
                    Encontrado = true;
                }
                ref = ref.Siguiente; 
            }
            return Encontrado;
        }
        return false; // si AB es null no tengo nada que que buscar
    }
    
    public Nodo eliminarAlInicio(){
        if(Inicio == null){
            return null;
        }else{
            Nodo Ret = Inicio;
            Inicio = Inicio.Siguiente;
            Inicio.Anterior = null;      
            Ret.Siguiente = null;
            Ret.Anterior = null;
            NoElementos--;
            return Ret;
        }        
    }  
    public Nodo eliminarAlFin(){
        if(Fin == null){
            return null;
        }else{       
            Nodo eliminar = Fin;
            Fin = Fin.Anterior;
            Fin.Siguiente = null;
            eliminar.Siguiente = null;
            eliminar.Anterior = null;         
            NoElementos--;
            return eliminar;
        }        
    }
    public Nodo eliminarPorNodo(Nodo Buscar){
        if(Buscar == null){
           return null; 
        } 
        if(Fin == null){
            return null;
        }else{
            ///////////////////////////
            if(Inicio.obtenerData()== Buscar.obtenerData()){
                return this.eliminarAlInicio();
            }
            ///////////////////////////
            if(Fin.obtenerData()== Buscar.obtenerData()){
                return this.eliminarAlFin();
            }
            ///////////////////////////
            Nodo refRojo = Inicio;
            Nodo refAzul = null;
            Nodo refElim = null;
            boolean Encontrado = false;
            while((refRojo != null)&& !Encontrado){
                if(refRojo.obtenerData() == Buscar.obtenerData()){
                    Encontrado = true; 
                    refElim = refRojo;
                    NoElementos--;
                }
                refRojo = refRojo.Siguiente;
            }
            if(Encontrado){
                refRojo = refElim.Anterior;
                refAzul = refElim.Siguiente;
                refRojo.Siguiente = refAzul;
                refAzul.Anterior = refRojo;
                refElim.Siguiente = null;
                refElim.Anterior = null;  
            }
            return refElim;
        }        
    }
    public Nodo elementoPorIndice(int p){
        if(Inicio == null){
            return null;
        }
        if(p>= NoElementos){
            return null;
        }
        if(p<0){
            return null;
        }
        int i=0;
        Nodo ref = Inicio;
        for(;i<p; i++){
            ref = ref.Siguiente; 
        }
        switch(ref.obtenerTipo()){
            case 1:
                ref = new Nodo<Integer>((int)ref.obtenerData(),1);
                break;
            case 2:
                ref = new Nodo<Double>((double)ref.obtenerData(),2);
                break;
            case 3:
                ref = new Nodo<String>((String)ref.obtenerData(),3);
                break;
            case 4:
                ref = new Nodo<Float>((float)ref.obtenerData(),4);
                break;
            case 5:
                ref = new Nodo<Boolean>((boolean)ref.obtenerData(),5);
                break;
            case 6:
                ref = new Nodo<Character>((char)ref.obtenerData(),6);
                break;
            case 7:
                ref = new Nodo<Short>((short)ref.obtenerData(),7);
                break;
            case 8:
                ref = new Nodo<Long>((long)ref.obtenerData(),8);
                break;
            default:
                //ref = new Nodo(ref.obtenerData(),ref.obtnerTipo());
                break;
        }
        
        return ref;
    }
    public String toString(){
        String tmp = "";
        if(Inicio == null){
            return "";
        }
        Nodo ref = Inicio;
        while(ref != null){
            tmp = tmp + " " +ref.toString();
            ref = ref.Siguiente;
        }
        return tmp;
    }
    public String toStringReverse(){
        String tmp = "";
        if(Fin == null){
            return "";
        }
        Nodo ref = Fin;
        while(ref != null){
            tmp = tmp + " " +ref.toString();
            ref = ref.Anterior;
        }
        return tmp;
    }
    
}
