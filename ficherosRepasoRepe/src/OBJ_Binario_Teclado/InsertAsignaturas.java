package OBJ_Binario_Teclado;

import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class InsertAsignaturas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado = new Scanner(System.in);
		
		//Asignatura [] asignaturas = new Asignatura[5];
		ArrayList <Asignatura> asignaturas = new ArrayList();
		int codAsignatura;
		String nombreAsignatura;
		String nombreProfesor;
		int nHoras;
		int nAsignaturas;
		
		System.out.println("Cuantas asignaturas deseas introducir");
		nAsignaturas = teclado.nextInt();
		
		
		for (int i = 0; i < nAsignaturas; i++) {
			System.out.println("Introduce el codigo de la asignatura");
			codAsignatura = teclado.nextInt();
			teclado.nextLine();
			System.out.println("Introduce el nombre de la asignatura");
			nombreAsignatura = teclado.nextLine();
			System.out.println("Introduce el nombre del profesor");
			nombreProfesor = teclado.nextLine();
			System.out.println("numero de horas: ");
			nHoras = teclado.nextInt();
			Asignatura as = new Asignatura(codAsignatura, nombreAsignatura, nombreProfesor, nHoras);	
			asignaturas.add(as);	
		}
		
		
		ObjectOutputStream ou = null;
		ObjectInputStream oi = null;
		
		try {
			ou = new ObjectOutputStream(new FileOutputStream("asignaturas.dat"));
			for (int i = 0; i < asignaturas.size(); i++) {
				Asignatura a = new Asignatura(asignaturas.get(i).getCodAsignatura(),
											  asignaturas.get(i).getNombreAsignatura(),
											  asignaturas.get(i).getNombreProfesor(),
											  asignaturas.get(i).getnHoras());
				
				
				ou.writeObject(a);
			}
			
			ou.flush();
			//Leemos el fichero para ver que está bien grabado
			
			oi = new ObjectInputStream(new FileInputStream("asignaturas.dat"));
			
			Asignatura as = (Asignatura) oi.readObject();
			while(as != null){
				System.out.println("Id: " + as.getCodAsignatura()+
									" Nombre asignatura: " + as.getNombreAsignatura()+
									" Nombre profesor: " + as.getNombreProfesor()+
									" numero de horas: " + as.getnHoras());
				
				as = (Asignatura) oi.readObject();
			}
			System.out.println("Final lectura del fichero");
			
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} catch (ClassNotFoundException e) {
			
		} finally{
			if(oi != null){
				try {
					oi.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ou != null){
				try {
					ou.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		

	}

}
