package co.edu.udea.dae.main;

public class CodeBreaker {

	public String validarPosiciones(String number) {

		String cadena = "";
		for (int i = 0; i < number.length(); i++) {
			String digito = number.substring(i, i + 1);
			cadena = cadena + entregarRespuesta(digito, i);
		}

		return cadena;
	}

	private String entregarRespuesta(String digito, int posicionDigito) {
		String respuesta = "";
		final String numeroMagico = "8819";
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
}
