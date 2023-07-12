package practica2;

// Clase que actua como contructor de un Thread llamado Worker
// y da la posibilidad de calcular matriz x vector.
public class Worker extends Thread {
	private int inicioFila;
	private int finalFila;
	private int id;
	private DatosCompartidos dc;

	public Worker(int inicioFila, int finalFila, int id, DatosCompartidos dc) {
		this.inicioFila = inicioFila;
		this.finalFila = finalFila;
		this.id = id;
		this.dc = dc;
	}

	/**
	 * Pre: --- 
	 * Post: Método que rellena la tabla de resultados con el resultado de la fila de la matriz 
	 * 		 multiplicada por el vector.
	 */
	public void run()  {
		Long tiempoInicio = System.nanoTime();
		for (int i = this.inicioFila; i < this.finalFila; i++) {
			for (int j = 0; j < this.dc.matriz[i].length; j++) {
				this.dc.resultado[i] = this.dc.matriz[i][j] * this.dc.vector[i] + this.dc.resultado[i];
			}
		}
		Long tiempoFinal = System.nanoTime();
		tiempo(tiempoFinal-tiempoInicio, this.id);
	}
	
	/**
	 * Pre: --- 
	 * Post: Método que guarda el proceso que mas tarda en ejecutarse.
	 */
	public synchronized void tiempo(Long tiempo, int id)  {
		System.out.println("Tiempo: " + id + " " + (tiempo) + " nanosegundos.");
		if (tiempo > this.dc.tmax) {
			this.dc.idMasLento = this.id;
			this.dc.tmax = (tiempo);
		}
	}
}