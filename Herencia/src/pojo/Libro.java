package pojo;

public class Libro extends ConArgumento{

	private Integer paginas;
	
	public Libro() {
		super();
		paginas = 0;
	}
	
	public Libro(String codigo, String titulo, Double precio, String argumento, Integer paginas) {
		super(codigo,titulo, precio, argumento);
		this.paginas = paginas; 
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}
	
	public String toString() {
		return "Código: "+this.getCodigo()+
				"\nTitulo: "+this.getTitulo()+
				"\nPrecio: "+this.getPrecio()+
				"\nArgumento: "+this.getArgumento()+
				"\nPáginas: "+this.getPaginas();
	}
	
	public int compareTo(Libro l) {
		if(this.getCodigo().compareTo(l.getCodigo()) == 0) {
			if(this.getTitulo().compareTo(l.getTitulo()) == 0) {
				return 0;
			}else {
				if(this.getTitulo().compareTo(l.getTitulo()) < 0){
					return -1;
				}else {
					return 1;
				}
			}
		}else {
			if(this.getCodigo().compareTo(l.getCodigo()) < 0) {
				return -1;
			}else {
				return 1;
			}
		}
	}
		
}