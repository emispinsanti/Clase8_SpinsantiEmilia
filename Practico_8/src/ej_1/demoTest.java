package ej_1;

import org.junit.*;


public class demoTest {
	
	@Test (expected = Exception.class)
	public void Test_1() throws Exception {
		
		float total = 0;
		float descuento1 = (float) 14.0;
		float descuento2= (float) 0.1;
		float descuento3= (float) 0.2;
	
		if (total == 0) {
			throw new Exception();
		}
		Descuento desc_fijo = new DescuentoFijo();
		desc_fijo.setValorDesc(descuento1);
		float desc1 = desc_fijo.valorFinal(total);
		
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
			
	}
	
	
	@Test (expected = Exception.class)
	public void Test_2() throws Exception {
		
		float total = 50;
		float descuento1 = (float) 140.0;
		float descuento2= (float) 0.1;
		float descuento3= (float) 0.2;
	
		if (total == 0) {
			throw new Exception();
		}
		Descuento desc_fijo = new DescuentoFijo();
		desc_fijo.setValorDesc(descuento1);
		float desc1 = desc_fijo.valorFinal(total);
		
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
			
	}
	
}
	