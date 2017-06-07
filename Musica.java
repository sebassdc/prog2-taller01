
public class Musica extends Product {
	public String cantante;
	
	public Musica(String titulo, double costo, long codBar, short existencia, String productor, String cantante) {
		super(titulo, costo, codBar, existencia, productor);
		this.cantante = cantante;
	}

	public void mostrar(String texto) {
		this.superMostrar(texto);
		MCursor.TCen("============================================================");
		MCursor.TJus("  CANT/GRUP MUS = " + this.cantante);
		MCursor.TCen("============================================================");
		MCursor.Salida();
	}//Mostrar
}