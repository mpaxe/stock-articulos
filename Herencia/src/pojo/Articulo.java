package pojo;

public class Articulo implements Comparable<Articulo>{
	
	private String codigo;
	private String titulo;
	private Double precio;
	
	public Articulo() {
		super();
		codigo = "0";
		precio = 0.0;
		titulo = "No tiene.";
	}

	public Articulo(String codigo, String titulo, Double precio) {
		this.codigo = codigo;
		this.precio = precio;
		this.titulo = titulo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Articulo [codigo=" + codigo + ", precio=" + precio + ", titulo=" + titulo + "]";
	}
	
	public int compareTo(Articulo a) {
		if(this.getCodigo().compareTo(a.getCodigo()) == 0) {
			if(this.getTitulo().compareTo(a.getTitulo()) == 0) {
				return 0;
			}else {
				if(this.getTitulo().compareTo(a.getTitulo()) < 0) {
					return -1;
				}else {
					return 1;
				}
			}
		}else {
			if(this.getCodigo().compareTo( a.getCodigo()) < 0) {
				return -1;
			}else {
				return 1;
			}
		}
	}
	
}