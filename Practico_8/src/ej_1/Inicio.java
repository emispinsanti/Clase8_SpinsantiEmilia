package ej_1;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) throws Exception {

		String Ruta = "C:\\Users\\Emi\\Carpeta Emi\\Documentos\\Programacion\\JAVA\\Practico\\Practico_8\\lista_productos.txt";
		List <Producto> lista_prod = new ArrayList();
		
		try {
			int lineas = (int) Files.lines(Paths.get(Ruta)).count();
			for( int j = 0 ; j < lineas ; j++) {
				String linea = Files.readAllLines(Paths.get(Ruta)).get(j);
				String a[]=linea.split("-");
				Producto prod = new Producto();
				prod.setCodigo_prod(Integer.parseInt(a[0]));
				prod.setNombre_prod(a[1]);
				prod.setPrecio_prod(Float.parseFloat(a[2]));
				lista_prod.add(prod);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i=0;i<lista_prod.size();i++) {
			System.out.println(lista_prod.get(i).getNombre_prod() + " - Codigo: " + lista_prod.get(i).getCodigo_prod() + " - Precio: " + lista_prod.get(i).getPrecio_prod() );
		}
		
		Carrito carrito1 = new Carrito();
		
		for (int m=0 ; m<3 ; m++){
			System.out.println("****************** \nQue producto desea agregar?"); 
			Scanner producto_in = new Scanner(System.in);
			int agregar_prod = 0;
			agregar_prod = Integer.parseInt(producto_in.nextLine());
				if(agregar_prod>lista_prod.size()) {
					System.out.println("****************** \nEl producto seleccionado no existe!");
				}else {
					Producto prod_prod = lista_prod.get(agregar_prod-1);
					String nombre_prod = lista_prod.get(agregar_prod-1).getNombre_prod();
		
					System.out.println("****************** \nCuantas unidades necesita?"); 
					Scanner cant_in = new Scanner(System.in);
					int agregar_cant = 0;
					agregar_cant = Integer.parseInt(cant_in.nextLine());
		
					ItemCarrito item1 = new ItemCarrito(prod_prod, agregar_cant);
					System.out.println("La eleccion fue: " + nombre_prod + " - " + agregar_cant + " unidades.");
				
					carrito1.agregar_item(item1);
					int h=0 ;
					System.out.println("Se agrego "  + carrito1.mostrar_item(h).getProducto().getNombre_prod());
					h++;
				}
		}
		
		System.out.println("\nEl carrito contiene:");
		for (int i=0; i<carrito1.cant_items(); i++) {
			System.out.println(carrito1.mostrar_item(i).getCantidad() + " unidades de " + carrito1.mostrar_item(i).getProducto().getNombre_prod());
		}
		float total = carrito1.getTotal();
		System.out.println("El total sin descuentos es de $"  + total);
		
		try {
			if (total == 0) {
				throw new Exception();
			}
				float descuento1 = (float) 14.0;
				float descuento2= (float) 0.1;
				float descuento3= (float) 0.2;
			
				Descuento desc_fijo = new DescuentoFijo();
				desc_fijo.setValorDesc(descuento1);
				float desc1 = desc_fijo.valorFinal(carrito1.getTotal());
		
				Descuento desc_porc = new DescuentoPorc();
				desc_porc.setValorDesc(descuento2);
				float desc2 = desc_porc.valorFinal(desc1);
				
				Descuento desc_porc_tope = new DescuentoPorcTope();
				float tope = 300;
				desc_porc_tope.setTope(tope);
				desc_porc_tope.setValorDesc(descuento3);
				float desc3 = desc_porc_tope.valorFinal(desc2);
			
					if (desc3 < 0) {
						throw new Exception();
					}
						System.out.println("******************\nDescuento fijo:  " + "$" + descuento1);
						System.out.println("Descuento porcentual " + (descuento2*100) + "%:  $" + (desc1-desc2));
						System.out.println("Descuento porcentual " + (descuento3*100) + "% con tope de $" + tope + ":  $" + (desc2-desc3));
						System.out.println("******************\nEl total a pagar es de $"  + desc3);
			
		} catch (Exception e) {
			System.out.println("Error! No se puede aplicar descuentos.");
			System.out.println(e.toString());
		}
	}
}
