package org.example;

public class TClasificador {

	public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
		switch (metodoClasificacion) {
			case 1:
				return ordenarPorInsercion(datosParaClasificar);
			case 2:
				return ordenarPorShell(datosParaClasificar);
			case 3:
				return ordenarPorBurbuja(datosParaClasificar);
			default:
				System.err.println("Este codigo no deberia haberse ejecutado");
				break;
		}
		return datosParaClasificar;
	}

	private void intercambiar(int[] vector, int pos1, int pos2) {
		int temp = vector[pos2];
		vector[pos2] = vector[pos1];
		vector[pos1] = temp;
	}

	// CORREGIDO FUNCIONANDO
	private int[] ordenarPorShell(int[] datosParaClasificar) {
		int j, inc;
		int[] incrementos = new int[] { 4, 2, 1 }; // Secuencia de incrementos

		//Recorre el array de incrementos.
		for (int posIncrementoActual = 0; posIncrementoActual < incrementos.length; posIncrementoActual++) {
			inc = incrementos[posIncrementoActual];

			for (int i = inc; i < datosParaClasificar.length; i++) {
				int clave = datosParaClasificar[i]; // Elemento actual a insertar que empieza por el incremento, en este caso 4 (4to elemento)
				j = i;

				while (j >= inc && datosParaClasificar[j - inc] > clave) {
					datosParaClasificar[j] = datosParaClasificar[j - inc];
					j -= inc;
				}

				datosParaClasificar[j] = clave;
			}
		}

		return datosParaClasificar;
	}

	// CORREGIDO FUNCIONANDO
	protected int[] ordenarPorInsercion(int[] datosParaClasificar) {
		if (datosParaClasificar != null) {
			for (int i = 1; i < datosParaClasificar.length; i++) {
				int valorActual = datosParaClasificar[i];
				int j = i - 1;
				while ((j >= 0) && (datosParaClasificar[j] > valorActual)) {
					intercambiar(datosParaClasificar, j+1, j);
					j--;
				}
				datosParaClasificar[j+1] = valorActual;
			}
			return datosParaClasificar;
		}
		return null;
	}

	// CORREGIDO FUNCIONANDO
	private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
		if (datosParaClasificar != null) {
			int n = datosParaClasificar.length - 1;
			for (int i = 0; i <= n; i++) {
				for (int j = n; j >= (i + 1); j--) {
					if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
						intercambiar(datosParaClasificar, j - 1, j);
					}
				}
			}
			return datosParaClasificar;
		}
		return null;
	}

	private int[] ordenarPorBurbujaOptimizado(int[] datosParaClasificar) {
		if (datosParaClasificar == null) {
			return null; // Caso base: arreglo nulo
		}

		int n = datosParaClasificar.length - 1; // Último índice del arreglo
		boolean swapped;

		for (int i = 0; i <= n; i++) {
			swapped = false; // Reinicia la bandera en cada pasada

			// Recorre desde el final hasta la posición i
			for (int j = n; j > i; j--) {
				if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
					intercambiar(datosParaClasificar, j - 1, j);
					swapped = true; // Hubo un intercambio
				}
			}

			// Si no hubo intercambios, el arreglo ya está ordenado
			if (!swapped) {
				break;
			}
		}

		return datosParaClasificar;
	}

	public static boolean estaOrdenado(int[] datos) {
		for (int i = 0; i < datos.length - 1; i++) {
			if (datos[i] > datos[i + 1]) {
				return false; // Si un elemento es mayor que el siguiente, no está ordenado
			}
		}
		return true; // Si recorremos todo el arreglo sin encontrar problemas, está ordenado.
	}
}