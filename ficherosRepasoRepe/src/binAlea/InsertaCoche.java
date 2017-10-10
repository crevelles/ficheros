package binAlea;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertaCoche {

	/**
	 * @param args
	 */
	private static int TMODELO = 20;

	public static void main(String[] args) {

		String[] modelo = { "Golf", "A3", "Insignia", "M3", "CLK", "Scenic"};
		int[] aniosF = { 2001, 2002, 1998, 1996, 2010, 1992 };
		double[] precios = { 12000, 10000, 19000, 15000, 11000, 17000};

		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile("coches.dat", "rw");
			
			// nos situamos al principio
			raf.seek(raf.length());

			StringBuffer sb = null;

		
			// modelo
			for (int i = 0; i < modelo.length; i++) {
				
				
				sb = new StringBuffer(modelo[i]);
				sb.setLength(TMODELO);
				raf.writeChars(sb.toString());
				

				// anioFabricación
				raf.writeInt(aniosF[i]);
				System.out.println(aniosF[i]);
				// precio
				raf.writeDouble(precios[i]);

			}
			
			
			
			//Leemos el fichero creado
			
			
			
			//nos situamos al principio del fichero
			raf.seek(0);
			
			//declaramos los arrays que contienen los caracteres de modelo 
			char [] cModelo = new char[TMODELO];
			int af;
			double price;
			String  model;
			
				while(raf.getFilePointer() <= raf.length()){
					
					//marc = raf.readUTF();
					
					for (int i = 0; i < TMODELO; i++) {	
						cModelo[i] = raf.readChar();
					}
					model = new String(cModelo);
					
					af = raf.readInt();
					
					price = raf.readDouble();
					
					
					System.out.println("Modelo "  + " añio " + af + " Precio " +  price);
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
