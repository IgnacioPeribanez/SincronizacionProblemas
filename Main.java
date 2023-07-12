package practica2;

public class Main {
	
	/**
	 * Pre: ---
	 * Post: Método que ejecuta el programa, este genera unos hilos 
	 * 		 que se encargan de calcular diferentesd datos.
	 */
	public static void main(String[] args) {
		DatosCompartidos dc = new DatosCompartidos();
		dc.rellenar();
		Worker workers[] = new Worker[16];
		int filas = 0;
		// Creamos los hilos que van a trabajar de 32 en 32 filas.
		for (int i = 0; i < workers.length; i++) {
			workers[i] = new Worker(filas, filas + 31, i+1, dc);
			filas += 32;
		}
		for (int i = 0; i < workers.length; i++) {
			workers[i].start();
		}
		try {
			for (int i = 0; i < workers.length; i++) {
				workers[i].join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Hilo que muestra por pantalla los datos.
		Informer informer = new Informer(dc);
		informer.run();		
	}
	
}