package pojo;

public class Disco extends Articulo{
    private Boolean esLP;

    public Disco(){
        super();
        esLP = true;
    }

    public Disco(String codigo,String titulo, Double precio, Boolean esLP){
        super(codigo,titulo, precio);
        this.esLP = esLP;
    }

    public boolean isLP(){
        return this.esLP;
    }

    public String toString(){
    	String cad;
    	if(isLP()) {
    		cad = "si";
    	}else {
    		cad = "no";
    	}
        return "Código: "+ getCodigo()+
                "\nTitulo: "+getTitulo()+
                "\nPrecio: "+getPrecio()+
                "\nEs LP: " +cad;
                
    }
    
	public int compareTo(Disco d) {
		if(this.getCodigo().compareTo(d.getCodigo()) == 0) {
			if(this.getTitulo().compareTo(d.getTitulo()) == 0) {
				return 0;
			}else {
				if(this.getTitulo().compareTo(d.getTitulo()) < 0){
					return -1;
				}else {
					return 1;
				}
			}
		}else {
			if(this.getCodigo().compareTo(d.getCodigo()) < 0) {
				return -1;
			}else {
				return 1;
			}
		}
	}
}