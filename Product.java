
public class Product{
	public String titulo;
	public double costo;
	public int codBar;
	public String productor;
	public short existencia;

	public Product(String titulo, double costo, int codBar, short existencia, String productor) {
		this.titulo = titulo;
		this.costo = costo;
		this.codBar = codBar;
		this.existencia = existencia;
		this.productor = productor;
	}
	public double getPrecioVenta() {
		return costo * 1.45;
	}
	public double getGanancia() {
		return costo * .45;
	}
	public void superMostrar(String texto) {
		MCursor.TCen("============================================================");
		MCursor.TCen(texto);
		MCursor.TCen("============================================================");
		MCursor.TJus("         TITULO = " + this.titulo);
		MCursor.TJus("          COSTO = " + this.costo);
		MCursor.TJus(" PRECIO A PAGAR = " + this.getPrecioVenta());
		MCursor.TJus("CODIGO DE BARRA = " + this.codBar);
		MCursor.TJus("     PRODUCTORA = " + this.productor);
		MCursor.TJus("     EXISTENCIA = " + this.existencia);
		MCursor.TCen("============================================================");
	}//Mostrar
}