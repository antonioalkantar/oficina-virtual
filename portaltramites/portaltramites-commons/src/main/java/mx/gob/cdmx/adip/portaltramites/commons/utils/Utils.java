package mx.gob.cdmx.adip.portaltramites.commons.utils;

import java.security.SecureRandom;

/**
 * @author Carlos
 *
 */
public class Utils {
	
	
	
	/**
	 * Constructor por defecto de la clase
	 */
	private Utils() {
		/** Constructor vacío para que no se pueda instanciar la clase **/
	}

	
	public static CharSequence randomChars() {
		StringBuilder result = new StringBuilder(64);
		SecureRandom random = new SecureRandom();
		for (int i = 0, count = result.capacity(); i < count; ++i) {
			result.append(Constantes.STATE_CHARS.charAt(random.nextInt(Constantes.STATE_CHARS.length())));
		}
		return result.toString();
	}
}
