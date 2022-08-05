package colecciones;

import java.util.Objects;

public class libro {
	
	public libro(String titulo, String autor, int ISBN) {
		
		this.titulo=titulo;
		this.autor=autor;
		this.ISBN=ISBN;
		
	}
	
	public String getDatos() {
		
		return "El titulo es: " + titulo + " el autor es: "+ autor+ " y e ISBN es: "+ISBN;
	}
	
	/*public boolean equals(Object obj) {
		
		if(obj instanceof libro) {
			
			libro otro=(libro)obj;//hacemos un casting convertimos obj en una variable de tipo libro
			
			if(this.ISBN==otro.ISBN) {//comparando si el isbn de los dos objetos es igual
				
				return true;				
				
			}else {
				
				return false;
			}
			
		}else {
			
			return false;
		}
	}*/
	
	
	private String titulo;
	@Override
	public int hashCode() {
		return Objects.hash(ISBN);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		libro other = (libro) obj;
		return ISBN == other.ISBN;
	}

	private String autor;
	private int ISBN;

}
