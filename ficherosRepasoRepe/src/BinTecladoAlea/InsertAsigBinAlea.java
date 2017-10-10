package BinTecladoAlea;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertAsigBinAlea {
	
	static final int TAM_NOMBRE_ASIG = 20;
	static final int TAM_NOMBRE_PROF = 10;
	static final int TAM_REG = 68;

	public static void main(String[] args) {
		
		RandomAccessFile raf = null;
		String [] nombresAsig = {"Programación", "BBDD", "LM"};
		String [] nombresProf = {"Pilar", "Susana", "Jairo"};
		int [] horas = {8,6,4};
		int ultimoID = 0;
		
		try {
			raf = new RandomAccessFile("asignaturas2.dat", "rw");
			
			//nos posicionamos al final
			raf.seek(raf.length());
			
			//vamos a comprobar si hay datos en el fichero para obtenr el
			//ultimo ID y obtener los siguientes.
			
			if(raf.length() > 0) {
				//AVERIGUAMOs al final del fichero y le restamos 1 registro
				//pra situarnos al principio del ultimo registro (LEER EL ID DEL ULTIMO REGISTRO)
				raf.seek(raf.length()-TAM_REG);
				ultimoID = raf.readInt();
			}
			
			//Para leer cadena caracteres
			StringBuffer sbAsig = null;
			StringBuffer sbProf = null;
			
			//nos posicionamos al final
			raf.seek(raf.length());
			for (int i = 0; i < horas.length; i++) {
				
				//escribimos el ID
				raf.writeInt(ultimoID + i + 1);
				
				
				//escribimos cadena de caracteres
				sbAsig = new StringBuffer(nombresAsig[i]);
				sbAsig.setLength(TAM_NOMBRE_ASIG);
				raf.writeChars(sbAsig.toString());
				
				//escribimos cadena de caracteres
				sbProf = new StringBuffer(nombresProf[i]);
				sbProf.setLength(TAM_NOMBRE_PROF);
				raf.writeChars(sbProf.toString());
				
				//horas
				raf.writeInt(horas[i]);
				
				
			}
			
			
			
			//cogemos el ultimo registro, calculando el tamaño d registro
			//teniendo en cuenta la estructura del fichero:
			//ID--> 2 caracteres x 2 => 4
			//Asignatura --> 20 caracteres x 2 =>40
			//Nombre prof --> 10 caracteres x2 =>20
			//Num horas --> 2 caracteres x 2 => 4
			//TOTAL 68
			
			
			
			//Leemos
			raf.seek(0);
			int id, horass;
			String nombreA, nombreP;
			char [] cNombreA = new char[TAM_NOMBRE_ASIG];
			char [] cNombreP = new char[TAM_NOMBRE_PROF];
			
			try {
				while(true) {
					//leemos el ID
					id = raf.readInt();
					
					//Leemos nombre asig
					for (int i = 0; i < TAM_NOMBRE_ASIG; i++) {
						cNombreA[i] = raf.readChar();
					}
					nombreA = new String(cNombreA);
					
					
					//Leemos el nombre profesor
					for (int i = 0; i < TAM_NOMBRE_PROF; i++) {
						cNombreP[i] = raf.readChar();
					}
					nombreP = new String(cNombreP);
					
					//leemos horas
					horass = raf.readInt();
					
					System.out.println("ID "+id+ " nombre profesor: " + nombreP
										+ " asignaturas: " + nombreA + " horas: " + horass);
				}
								
			}catch (EOFException e) {
				System.out.println("Final fichero");
			}
				
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		

	}

}
