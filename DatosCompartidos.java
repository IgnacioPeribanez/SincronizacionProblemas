package practica2;

// Clase de datos compartidos.
public class DatosCompartidos {
	int matriz[][];
	int vector[];
	int resultado[];
	Long tmax;
	int idMasLento;

	public DatosCompartidos() {
		this.matriz = new int[512][512];
		this.vector = new int[512];
		this.resultado = new int[512];
		this.tmax = (long) 0;
		this.idMasLento = 0;
	}

	/**
	 * Pre: --- 
	 * Post: Método que rellena la matriz y el vector.
	 */
	public void rellenar() {
		for (int i = 0; i < this.matriz.length; i++) {
			for (int j = 0; j < this.matriz[i].length; j++) {
				this.matriz[i][j] = (int) (Math.random() * (0 - 200 + 1) + 200);
			}
		}
		int vectores = 1;
		for (int i = 0; i < this.vector.length; i++) {
			this.vector[i] = vectores;
			vectores++;
		}
	}

}