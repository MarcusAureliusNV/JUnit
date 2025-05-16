package calculadoraDescuentos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

public class productoTest {
	
	//TESTS DE LA CLASE PRODUCTO
		@Test
		public void testDescuentoElectronicaSinVipCantidadMenorA5() {
			List<Producto> descuento = generarLista("electronica", 10.0, 4);
			assertEquals(216.0, descuento); // DA ERROR ESTA LINEA
		}

		private List<Producto> generarLista(String categoria, double precio, int cantidad) {
			List<Producto> productos = new java.util.ArrayList<>();
			for (int i = 0; i < cantidad; i++) {
				productos.add(new Producto(categoria, precio, cantidad));
			}
			return productos;
		}

		@Test
		public void testPrecioNegativoLanzaExcepcion() {
			assertThrows(IllegalArgumentException.class, () -> {
				new Producto("electronica", -10.0, 5);
			});
		}

		@Test
		public void testCantidadNegativaLanzaExcepcion() {
			assertThrows(IllegalArgumentException.class, () -> {
				new Producto("electronica", 10.0, -5);
			});
		}
		
}
