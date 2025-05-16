package calculadoraDescuentos;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class calculadoraDescuentosTest {

    // Tests reorganizados por categoría + casos límite
    // ================================================

    @Test
    void cubreTodasCategorias() {
        List<Producto> productos = Arrays.asList(
            new Producto("electronica", 100, 6),
            new Producto("ropa", 100, 4),
            new Producto("hogar", 100, 3),
            new Producto("alimentacion", 100, 1)
        );

        double totalVIP = CalculadoraDescuentosUtils.calcularTotalConDescuento(productos, true);
        assertEquals(1208.07, totalVIP); // Combina todos los descuentos
    }

    // Tests Electrónica
    // -----------------
    @Test
    void electronica_5unidades_VIP() {
        List<Producto> productos = Collections.nCopies(5, new Producto("electronica", 10, 1));
        double total = CalculadoraDescuentosUtils.calcularTotalConDescuento(productos, true);
        assertEquals(42.75, total); // (5% + 10%) 
    }

    @Test
    void electronica_4unidades_noVIP() {
        List<Producto> productos = Collections.nCopies(4, new Producto("electronica", 10, 1));
        double total = CalculadoraDescuentosUtils.calcularTotalConDescuento(productos, false);
        assertEquals(40, total); // Sin descuento
    }

    // Tests Ropa
    // -----------
    @Test
    void ropa_3unidades_VIP() {
        List<Producto> productos = Collections.nCopies(3, new Producto("ropa", 10, 1));
        double total = CalculadoraDescuentosUtils.calcularTotalConDescuento(productos, true);
        assertEquals(26.19, total); // (3% + 10%)
    }

    // Tests Hogar
    // ------------
    @Test
    void hogar_2unidades_noVIP() {
        List<Producto> productos = Collections.nCopies(2, new Producto("hogar", 10, 1));
        double total = CalculadoraDescuentosUtils.calcularTotalConDescuento(productos, false);
        assertEquals(19, total); // 5% descuento
    }

    // Tests Alimentación
    // -------------------
    @Test
    void alimentacion_VIP() {
        List<Producto> productos = List.of(new Producto("alimentacion", 10, 1));
        double total = CalculadoraDescuentosUtils.calcularTotalConDescuento(productos, true);
        assertEquals(9, total); // Solo descuento VIP
    }

    // Tests de errores y límites
    // ---------------------------
    @Test
    void lanzaErrorCategoriaInvalida() {
        List<Producto> productos = List.of(new Producto("categoria_falsa", 10, 1));
        assertThrows(IllegalArgumentException.class, () -> 
            CalculadoraDescuentosUtils.calcularTotalConDescuento(productos, false)
        );
    }

    @Test
    void cantidadCeroLanzaError() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Producto("electronica", 10, 0)
        );
    }
}