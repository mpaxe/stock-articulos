package pojo;



public class Pelicula extends ConArgumento{
    private Boolean esDVD;

    public Pelicula(){
        super();
        esDVD = true;
    }

    public Pelicula(String codigo, String titulo, Double precio,  String argumento, Boolean esDVD){
        super(codigo, titulo, precio, argumento);
        this.esDVD = esDVD;
    }

    public boolean isDVD(){
        return this.esDVD;
    }
    
    public void setEsDVD(String cad) {
    	if(cad.equalsIgnoreCase("si") || cad.equalsIgnoreCase("s")) {
    		this.esDVD = true;
    	}else if(cad.equalsIgnoreCase("no") || cad.equalsIgnoreCase("n")) {
    		this.esDVD = false;
    	}else {
    		System.out.println("Error: (por defecto es DVD)");
    		this.esDVD = true;
    	}
    }

    public String toString(){
    	String cad;
    	if(isDVD()) {
    		cad = "si";
    	}else {
    		cad = "no";
    	}
    	
        return "Código: "+ getCodigo()+
                "\nTitulo: "+getTitulo()+
                "\nPrecio: "+getPrecio()+
                "\nArgumento: "+getArgumento()+
                "\nEs DVD: " +cad;
                
    }
	public int compareTo(Pelicula p) {
		if(this.getCodigo().compareTo(p.getCodigo()) == 0) {
			if(this.getTitulo().compareTo(p.getTitulo()) == 0) {
				return 0;
			}else {
				if(this.getTitulo().compareTo(p.getTitulo()) < 0){
					return -1;
				}else {
					return 1;
				}
			}
		}else {
			if(this.getCodigo().compareTo(p.getCodigo()) < 0) {
				return -1;
			}else {
				return 1;
			}
		}
	}
}