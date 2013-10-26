package co.edu.udea.dae.main;

import java.util.ArrayList;
import java.util.List;

public class CodeBreaker {
	final String numeroMagico = "8819";

	public String validarPosiciones(String number) {
		boolean agregarGuion = false;
		String cadena = "";

		for (int i = 0; i < number.length(); i++) {
			String digito = number.substring(i, i + 1);
			List<Integer> posicionesRepetidas = new ArrayList<Integer>();
			posicionesRepetidas = posicionRepeticiones(number, digito);

			if ((posicionesRepetidas.size() > 1) && (!digito.equals("8"))) {				
				for (int posicion : posicionesRepetidas) {
					if (posicion == i && entregarRespuesta(digito, posicion).equals("X")) {
						cadena = cadena + entregarRespuesta(digito, i);
						agregarGuion = false;
					} else {
						agregarGuion = true;
					}
				}
			} else {
				cadena = cadena + entregarRespuesta(digito, i);
			}
		}
		if(agregarGuion == true)
			cadena = cadena + "-";
		return cadena;
	}

	private String entregarRespuesta(String digito, int posicionDigito) {
		String respuesta = "";
		String numeroReducido = numeroMagico.substring(posicionDigito);
		int posicionReal = numeroReducido.indexOf(digito);

		if (numeroMagico.contains(digito)) {
			if ((posicionReal + posicionDigito) == posicionDigito) {
				respuesta = "X";
			} else {
				respuesta = "-";
			}
		}

		return respuesta;
	}

	public static List<Integer> posicionRepeticiones(String numero, String digito) {
		List<Integer> posiciones = new ArrayList<Integer>();
		int letrasEliminadasDeCadenaOriginal = 0;
		while (numero.indexOf(digito) > -1) {
			letrasEliminadasDeCadenaOriginal = 4 - numero.length();
			posiciones.add(numero.indexOf(digito) + letrasEliminadasDeCadenaOriginal);
			numero = numero.substring(numero.indexOf(digito) + digito.length(),
					numero.length());
		}
		return posiciones;
	}
}
