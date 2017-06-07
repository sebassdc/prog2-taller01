import java.util.ArrayList;

public class Tienda {
	static short MAX = 10;
	static ArrayList<Pelicula> PELICULAS = new ArrayList<>();
	static ArrayList<Musica> MUSICA = new ArrayList<>();
	//METODO PRINCIPAL
	public static void main(String arg[]) {
		byte opc;
		do{
			opc = menu();
			MCursor.BLinea(30);
			switch(opc) {
				case 1:
					ingresarMusica();
					break;
				case 2:
					mostrarMusica();
					break;
				case 3:
					ingresarPelicula();
					break;
				case 4:
					mostrarPelicula();
					break;
				case 5:
					mostrarGanancias();
					break;
			}//switch
		}while (opc != 0);
	}//main

	//CASO 1: METODO PARA INGRESAR LA MUSICA
	public static void ingresarMusica() {
		if(MUSICA.size() < MAX) {
			MCursor.TCen("============================================================");
			MCursor.TCen("INGRESE LOS DATOS DEL ARTICULO NUMERO " + (MUSICA.size() + 1));

			// Titulo
			MCursor.TCen("============================================================");
			MCursor.UCursor(15);
			String titulo = Leer.CString("TITULO = ").toUpperCase();

			// Codigo de barra
			MCursor.TCen("============================================================");
			int codBar;
			do{
				MCursor.UCursor(15);
				codBar = Leer.NInt("CODIGO BARRA = ");
			}while ((codBar < 10000000) || (codBar > 99999999));

			// Cantante
			MCursor.TCen("============================================================");
			String cantante;
			do {
				MCursor.UCursor(15);
				cantante = Leer.CString("CANTANTE = ").toUpperCase();;
			} while ( cantante.length() < 0);

			// Existencia
			MCursor.TCen("============================================================");
			short existencia;
			do {
				MCursor.UCursor(15);
				existencia = Leer.NShort("EXISTENCIA = ");
			} while ((existencia < 1) || (existencia > 1000));

			// Productor
			MCursor.TCen("============================================================");
			String productor;
			do {
				MCursor.UCursor(15);
				productor = Leer.CString("PRODUCTORA = ").toUpperCase();;
			} while ( productor.length() < 0);

			// Costo
			MCursor.TCen("============================================================");
			double costo;
			do {
				MCursor.UCursor(15);
				costo = Leer.NFloat("COSTO DEL ARTICULO = ");
			}while (costo <= 0);
			MCursor.TCen("============================================================");
			
			// Agregar
			MUSICA.add(new Musica(titulo, costo, codBar, existencia, productor, cantante));

		} else error("NO HAY CAPACIDAD PARA ALMACENAR OTRO ARTICULO");
		return;
	}

	//CASO 2: METODO PARA MOSTRAR MUSICA
	public static void mostrarMusica() {
		if(MUSICA.isEmpty()) error("NO HAY MUSICA ALMACENADA");
		else {
			for(int i = 0; i < MUSICA.size(); i++) {
				MCursor.BLinea(30);
				MUSICA.get(i).mostrar("MUSICA NUMERO " + (i + 1));
			}//for
		}//else
		return;
	}

	// CASO 3: METODO PARA INGRESAR PELICULAS
	public static void ingresarPelicula() {
		if(PELICULAS.size() < MAX) {
			MCursor.TCen("============================================================");
			MCursor.TCen("INGRESE LOS DATOS DEL ARTICULO NUMERO " + (PELICULAS.size() + 1));

			// Titulo
			MCursor.TCen("============================================================");
			MCursor.UCursor(15);
			String titulo = Leer.CString("TITULO = ").toUpperCase();

			// Codigo de barra
			MCursor.TCen("============================================================");
			int codBar;
			do{
				MCursor.UCursor(15);
				codBar = Leer.NInt("CODIGO BARRA = ");
			}while ((codBar < 10000000) || (codBar > 99999999));

			// Existencia
			MCursor.TCen("============================================================");
			short existencia;
			do {
				MCursor.UCursor(15);
				existencia = Leer.NShort("EXISTENCIA = ");
			} while ((existencia < 1) || (existencia > 1000));

			// Productor
			MCursor.TCen("============================================================");
			String productor;
			do {
				MCursor.UCursor(15);
				productor = Leer.CString("PRODUCTORA = ").toUpperCase();;
			} while ( productor.length() < 0);

			// Costo
			MCursor.TCen("============================================================");
			double costo;
			do {
				MCursor.UCursor(15);
				costo = Leer.NFloat("COSTO DEL ARTICULO = ");
			}while (costo <= 0);
			MCursor.TCen("============================================================");
			
			Pelicula p = new Pelicula(titulo, costo, codBar, existencia, productor);

			// Director
			MCursor.TCen("============================================================");
			do {
				MCursor.UCursor(15);
				p.director = Leer.CString("DIRECTOR = ").toUpperCase();
			} while ( p.director.length() < 0);

			// Protagonistas
			MCursor.TCen("============================================================");
			char miopc = 'S';
			String prot;
			int protoNum = 0;

			do {
				MCursor.UCursor(15);
				prot = Leer.CString("PROTAGONISTA = ").toUpperCase();
				p.addProtagonista(prot);
				
				MCursor.UCursor(15);
				if (p.protagonistas.size() == 3) break;
				miopc = Leer.CString("¿DESEA AGREGAR OTRO PROTAGONISTA? (S/N)").toUpperCase().charAt(0);
			} while (p.protagonistas.size() < 3 && miopc != 'N');

			// Agregar
			PELICULAS.add(p);

		} else error("NO HAY CAPACIDAD PARA ALMACENAR OTRO ARTICULO");
		return;
	}

	// CASO 4: METODO PARA MOSTRAR PELICULAS
	public static void mostrarPelicula() {
		if(PELICULAS.isEmpty()) error("NO HAY PELICULAS ALMACENADAS");
		else {
			for(int i = 0; i < PELICULAS.size(); i++) {
				MCursor.BLinea(30);
				PELICULAS.get(i).mostrar("PELICULAS NUMERO " + (i + 1));
			}//for
		}//else
		return;
	}

	public static void mostrarGanancias() {
		double subtotalMusica = 0;
		double subtotalPeliculas = 0;
		for(int i = 0; i < MUSICA.size(); i++)
			subtotalMusica += MUSICA.get(i).getGanancia();
		
		for(int i = 0; i < PELICULAS.size(); i++)
			subtotalPeliculas += PELICULAS.get(i).getGanancia();
		MCursor.TCen("============================================================");
		MCursor.TCen("EL TOTAL DE GANANCIAS ES DE: " + (subtotalMusica + subtotalPeliculas));
		MCursor.Salida();
	}
	//METODO PARA GENERAR UN MENSAJE DE ERROR
	public static void error (String Texto){
		MCursor.BLinea(2);
		MCursor.TCen("============================================================");
		MCursor.TJus("E		R		R		O		R\n");
		MCursor.TCen(Texto);
		MCursor.TCen("============================================================");
		MCursor.Salida();
		return;
	}//error

	//METODO PARA MOSTRAR EL MENU DE OPCIONES
	public static byte menu() {
		MCursor.BLinea(30);
		MCursor.TCen("============================================================");
		MCursor.TCen("TIENDA \"Video & Music\"");
		MCursor.TCen("MENU PRINCIPAL DE OPCIONES");
		MCursor.TCen("============================================================");
		MCursor.TJus("1.- INGRESAR MUSICA");
		MCursor.TJus("2.- MOSTRAR MUSICA");
		MCursor.TJus("3.- INGRESAR PELICULA");
		MCursor.TJus("4.- MOSTRAR PELICULA");
		MCursor.TJus("5.- CALCULAR GANANCIA");
		MCursor.TCen("============================================================");
		MCursor.TJus("0.- SALIR DEL SISTEMA");
		MCursor.TCen("============================================================");
		MCursor.UCursor(25);
		return Leer.NByte("ESCOJA SU OPCION = ");
	}//menu
}//class