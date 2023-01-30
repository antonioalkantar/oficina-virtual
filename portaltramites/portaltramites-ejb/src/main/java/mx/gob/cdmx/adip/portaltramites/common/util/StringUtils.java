package mx.gob.cdmx.adip.portaltramites.common.util;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Random;

public class StringUtils {
	
	public static String PATRON_CORREO = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static String PATRON_DECIMALES = "^[0-9]*.([0-9]+)";
	
	private StringUtils() {
		/**Constructo privado para que no se pueda instaciar la clase.*/
	}
	
	public static String generarCodigoVerificacionContacto() {
		Random rnd = new Random();
		String codigoVerificacion ="";
		final String letras = "ABCDFGHIJKLMNOPQLRSTUVWXYZ";
		int pos = 0, num;
		pos = (int) (rnd.nextDouble() * letras.length() - 1 + 0);
		num = (int) (rnd.nextDouble() * 99999 + 10000);
		codigoVerificacion = codigoVerificacion + letras.charAt(pos) + num;
		pos = (int) (rnd.nextDouble() * letras.length() - 1 + 0);
		codigoVerificacion = codigoVerificacion + letras.charAt(pos);
		return codigoVerificacion;
	}
	
	public static boolean validarCorreo(String correo) {
	    return correo.matches(PATRON_CORREO);
	}
	
	/**
	 * Método que quita acentos de una palabra dada
	 * @param string
	 * @return
	 */
	public static String removeDiacriticalMarks(String string) {
	    return Normalizer.normalize(string, Form.NFD)
	        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}
	
	public static String capitalizeFirstLetter(String original) {
	    if (original == null || original.isEmpty()) {
	        return original;
	    }
	    return original.substring(0, 1).toUpperCase() + original.substring(1);
	}
	
//	public static void main(String args[]) {
//		String numero = "4.5";
//		System.out.println("Coincide " + numero.matches(PATRON_DECIMALES));
//	}
}
