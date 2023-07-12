package practica2;

// Clase que actua como contructor de un Thread llamado Informer
// y da la posibilidad de calcular el modelo de una tabla de resultados.
public class Informer extends Thread {
	private DatosCompartidos dc;

	public Informer(DatosCompartidos dc) {
		this.dc = dc;
	}
	
	/**
	 * Pre: --- 
	 * Post: Método que rellena calcula el modelo y lo muestra por pantalla, acompañando
	 * 		 los datos compartidos.
	 */
	public synchronized void run() {
		System.out.println();
		Float modelo = (float) 0;
		for (int i = 0; i < this.dc.resultado.length; i++) {
			modelo = (float) (modelo + Math.pow(this.dc.resultado[i], 2));
		}
		modelo = (float) Math.sqrt(modelo);
		System.out.println("Modelo: " + modelo);
		System.out.println("Id del proceso mas lento: " + this.dc.idMasLento);
		System.out.println("Tiempo máximo de un proceso: " + this.dc.tmax + " nanosegundos.");
	}
	
}