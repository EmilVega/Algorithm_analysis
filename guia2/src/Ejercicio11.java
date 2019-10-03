
public class Ejercicio11 {

	public static void main(String[] args) {
		LList<String> lista = new LList();
		lista.append("hola");
		lista.append("emil");
		lista.append("cama");
		lista.append("hoja");
		lista.append("dedo");
		lista.moveToPos(3);
		lista.insert("pepito");
		lista.moveToStart();
		for(int i=0; i<lista.lenght();i++){
			System.out.println(lista.getValue());
			lista.next();
		}
		lista.swap_ith(6);
		lista.moveToStart();
		System.out.println("\n");
		for(int i=0; i<lista.lenght();i++){
			System.out.println(lista.getValue());
			lista.next();
		}
		
	}

}
