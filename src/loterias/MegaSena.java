package loterias;

import java.util.Arrays;
import java.util.Random;

//Agradeco a Deus pelo dom do conhecimento
//Eduardo Marcal
//Codigo fonte criado em: 06/08/14

public class MegaSena {

	static int dezena;
	static int unidade;
	static int bola;
	static int contador = 0;
	static int paradaWhile = 6;
	static int paraFor = 0;

	public static int geraNumero(Random random) {
		dezena = (random.nextInt(7)) * 10;
		unidade = random.nextInt(7) + 1;
		bola = dezena + unidade;
		return bola;
	}

	public static void comparaNumeros(String[] numeros, Random random) {
		for (int j = 0; j <= contador; j++) {
			if (bola == Integer.parseInt(numeros[j]) & contador > 0) {
				bola = geraNumero(random);
				if (bola <= 60) {
					comparaNumeros(numeros, random);
					numeros[contador] = String.valueOf(bola);
				}
			}
		}
	}

	public static String[] ordenarNumerosSorteados(String[] numeros) {
		int temp1, temp2, aux;
		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < numeros.length; j++) {
				temp1 = Integer.parseInt(numeros[i]);
				temp2 = Integer.parseInt(numeros[j]);
				if (temp2 > temp1) {
					aux = temp2;
					temp2 = temp1;
					temp1 = aux;
					numeros[j] = String.valueOf(temp2);
					numeros[i] = String.valueOf(temp1);
				}
			}
		}
		return numeros;
	}

	public static void main(String[] args) {
		Random random = new Random();
		String[] numerosSorteados = new String[6];
		// System.out.println(random.nextInt(7));
		while (contador < paradaWhile & contador < 6) {
			bola = geraNumero(random);
			if (bola <= 60) {
				numerosSorteados[contador] = String.valueOf(bola);
				comparaNumeros(numerosSorteados, random);
				contador++;
			} else {
				paradaWhile += 1;
			}
		}

		
		System.out.println("Sorteado");
		System.out.println(Arrays.toString(numerosSorteados));

		//System.out.println("--------");
		System.out.println("Ordenado");
		int inic = 0;
		System.out.print("[");
		for (String num : ordenarNumerosSorteados(numerosSorteados)) {
			inic++;
			if (inic <= 5) {
				System.out.print(num + ", ");
			} else {
				System.out.print(num);
			}
			
		}
		System.out.print("]");
	}

}
