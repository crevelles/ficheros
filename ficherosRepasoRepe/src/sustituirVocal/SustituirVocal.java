package sustituirVocal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SustituirVocal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FileInputStream fi = null;
		
		String nombre = "/home/satan/workspace/ficherosRepasoRepe/vocales.txt";
		
		try {
			fi = new FileInputStream(nombre);
			int valor = fi.read();
			
			while(valor != -1){
				if(valor == 97 || valor == 69 || valor == 101 || valor == 105 || valor == 111 || valor == 117){
					valor = 97;
				}
				System.out.print((char)valor);
				valor = fi.read();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
