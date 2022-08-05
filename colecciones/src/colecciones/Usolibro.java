package colecciones;

public class Usolibro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		libro libro1=new libro("PROGRAMACION EN JAVA ", "GEISON", 25);
		libro libro2=new libro("PROGRAMACION EN JAVA ", "GEISON", 25);
		
		libro1=libro2;
		if(libro1.equals(libro2)){
			
			System.out.println("Es el mismo libro");
			
			System.out.println(libro1.hashCode());
			System.out.println(libro2.hashCode());
						
		} else {
			
			System.out.println("No es el mismo libro");
			
			System.out.println(libro1.hashCode());
			System.out.println(libro2.hashCode());
		}
	}

}
