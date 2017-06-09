import java.util.ArrayList;

public class Pelicula extends Product {
	public String director;
	public ArrayList<String> protagonistas;
	
	public Pelicula(String titulo, double costo, int codBar, short existencia, String productor) {
		super(titulo, costo, codBar, existencia, productor);
		this.protagonistas = new ArrayList<>();
	}

	public int addProtagonista(String prot) {
		this.protagonistas.add(prot);
		return this.protagonistas.size();
	}
	public void mostrar(String texto) {
		this.superMostrar(texto);
		MCursor.TCen("============================================================");
		MCursor.TJus("       DIRECTOR = " + this.director);
		this.protagonistas.forEach(e -> {
			MCursor.TJus("   PROTAGONISTA = " + e);
		});
		MCursor.TCen("============================================================");
		MCursor.Salida();
	}//Mostrar
}