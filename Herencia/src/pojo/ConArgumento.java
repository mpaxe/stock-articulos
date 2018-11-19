package pojo;

public class ConArgumento extends Articulo {

	private String argumento;

	public ConArgumento() {
		super();
		argumento = "Sin argumento.";
	}

	public ConArgumento(String codigo, String titulo, Double precio, String argumento) {
		super(codigo, titulo, precio);
		this.argumento = argumento;
	}
	
	public String getArgumento() {
		return argumento;
	}

	public void setArgumento(String argumento) {
		this.argumento = argumento;
	}

	@Override
	public String toString() {
		return "ConArgumento [getArgumento()=" + getArgumento() + ", getCodigo()=" + getCodigo() + ", getPrecio()="
				+ getPrecio() + ", getTitulo()=" + getTitulo() + "]";
	}
	

}