package OBJ_Binarios;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IntroProducto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Producto p1 = new Producto(1, "mesa", "110 x 120", 35);
		Producto p2 = new Producto(2, "silla", "10 x 12", 95);
		Producto p3 = new Producto(3, "lampara", "11 x 20", 120);
		Producto p4 = new Producto(4, "cuadro", "10 x 120", 15);
		Producto p5 = new Producto(5, "tv", "110 x 100", 350);
		
		Producto [] productos = {p1,p2,p3,p4,p5};
		
		ObjectOutputStream ou = null;
		ObjectInputStream oi = null;
		
		Producto p = null;
		try {
			ou = new ObjectOutputStream(new FileOutputStream("productos.dat"));
			for (int i = 0; i < productos.length; i++) {
				p = new Producto(productos[i].getId()
						, productos[i].getNombre()
						, productos[i].getMedidas()
						, productos[i].getPrecio());
				ou.writeObject(p);
			}
			
			//lectura fichero
			oi = new ObjectInputStream(new FileInputStream("productos.dat"));
			p = (Producto) oi.readObject(); 
			
			while(p != null){
				System.out.println("ID: "+ p.getId() +
									"Producto: " + p.getNombre()+
									"Medidas: "+ p.getMedidas() +
									"Precio: " + p.getPrecio());
				p = (Producto) oi.readObject();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			System.out.println("Final lectura");
		} 
		
	}

}
