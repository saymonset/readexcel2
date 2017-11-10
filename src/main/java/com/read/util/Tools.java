package com.read.util;

import java.lang.reflect.Method;

public class Tools {

	public static final String STPROVEEDOR_POR_ACTIVAR = "0";
	public static final String STPROVEEDOR_POR_ACTIVAR_PASO_1 = "-1";
	public static final String STPROVEEDOR_POR_ACTIVAR_PASO_0 = null;
	public static final String STPROVEEDOR_ACTIVO = "1";
	public static final String STPROVEEDOR_INACTIVO = "2";
	public static final String STPROVEEDOR_ACTIVOFORBEAN = "activo";
	public static final String STPROVEEDOR_INACTIVOFORBEAN = "inActivo";
	public static final String STPROVEEDOR_MAXIMO_REGISTRADO = "1";
	public static final String STPROVEEDOR_MAXIMO_SUSPENDIDO = "2";

	public static void anlisiClass(Class aClass) {
		Method[] methods = aClass.getMethods();

		for (Method method : methods) {
			// if(isGetter(method)) System.out.println("getter: " + method);
			if (isSetter(method))
				System.out.println("setter: " + method);

		}
	}

	public static boolean isGetter(Method method) {
		if (!method.getName().startsWith("get"))
			return false;
		if (method.getParameterTypes().length != 0)
			return false;
		if (void.class.equals(method.getReturnType()))
			return false;
		return true;
	}

	public static boolean isSetter(Method method) {
		if (!method.getName().startsWith("set"))
			return false;
		if (method.getParameterTypes().length != 1)
			return false;
		return true;
	}

	/**
	 * @param Valida
	 *            si es vacio o nulo el valor a pasar
	 * @return true si no es vacio
	 */
	public static boolean isEmptyOrNull(String valor) {
		boolean swVacioCadena = (valor == null || valor.trim().length() == 0
				|| valor.trim().equalsIgnoreCase("null") || valor.trim()
				.equalsIgnoreCase("#000000"));
		return swVacioCadena;
	}

	public static String tlf(String maximoTlf) {
		StringBuilder salida = new StringBuilder("");
	 
		maximoTlf = quitarEspaciosEnBlanco(maximoTlf);
	 
		if (!isEmptyOrNull(maximoTlf)) {
			StringBuilder tlf = new StringBuilder(maximoTlf);
			tlf.reverse();
			int num1 = 0;
			int numArea1 = 0;
			int numInternacionaLArea1 = 0;
			StringBuilder num1Tlf = new StringBuilder("");
			StringBuilder num1Area = new StringBuilder("");
			StringBuilder num1AreaInternacional = new StringBuilder("");
			for (int i = 0; i < tlf.length(); i++) {
				if (num1 < 7 && isNumeric(tlf.charAt(i) + "")) {
					num1++;
					num1Tlf.append(tlf.charAt(i));
					// System.out.println("que pasa1="+num1Tlf.toString());
				} else if (numArea1 < 3 && num1 == 7
						&& isNumeric(tlf.charAt(i) + "")) {
					numArea1++;
					num1Area.append(tlf.charAt(i));
				} else if (numInternacionaLArea1 < 3 && numArea1 == 3
						&& isNumeric(tlf.charAt(i) + "")) {
					if (!(numInternacionaLArea1 == 0 && "0"
							.equalsIgnoreCase(tlf.charAt(i) + ""))) {
						numInternacionaLArea1++;
						num1AreaInternacional.append(tlf.charAt(i));
					}

				}
			}

			// "(111)-(111)-1111111"
			// System.out.println("num1Tlf=="+num1Tlf.reverse());
			// System.out.println("num1Area=="+num1Area.reverse());
			// System.out.println("num1AreaInternacional=="+num1AreaInternacional.reverse());
			if (!isEmptyOrNull(num1AreaInternacional + "")) {
				salida.append("(").append(num1AreaInternacional.reverse())
						.append(")").append("-");
				;
			} else {
				salida.append("(").append("058").append(")").append("-");
				;
			}
			if (!isEmptyOrNull(num1Area + "")) {
				salida.append("(").append(num1Area.reverse()).append(")")
						.append("-");
				;
			} else {
				salida.append("(").append("212").append(")").append("-");
				;
			}
			if (!isEmptyOrNull(num1Tlf + "")) {
				salida.append("").append(num1Tlf.reverse()).append("");
				;

			}

			// System.out.println("(111)-(111)-1111111");

		}

		return salida.toString();
	}

	public static String quitarEspaciosEnBlanco(String cadena) {
		if (cadena != null) {
			int j = 0;
			StringBuilder stbl = new StringBuilder("");
			while (j < cadena.length()) {
				if (!isEmptyOrNull(cadena.charAt(j) + "")) {
					stbl.append(cadena.charAt(j) + "");
				}
				++j;
			}
			if (!isEmptyOrNull(stbl.toString())) {
				cadena = stbl.toString();
			}
		}
		return cadena;

	}

	public static boolean isNumeric(String cadena) {
		if (isEmptyOrNull(cadena)) {
			return false;
		}
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
}
