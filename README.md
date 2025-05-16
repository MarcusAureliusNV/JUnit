## Estructura del Código

### Producto.java  
- **Propósito:** Representa un producto con atributos:  
  - `categoria`: Tipo de producto (ej. "electronica", "ropa", etc.).  
  - `precio`: Precio unitario (≥ 0).  
  - `cantidad`: Cantidad de unidades (≥ 0).  
- **Validación:**  
  - El constructor lanza `IllegalArgumentException` si `precio` o `cantidad` son negativos.

### CalculadoraDescuentosUtils.java  
- **Método Principal:** `calcularTotalConDescuento(List<Producto> productos, boolean esClienteVip)`  
  - Recorre la lista de productos.
  - Calcula un descuento base según la categoría y cantidad:
    - **Electrónica:** 20% si la cantidad es 5 o más; 10% de otra forma.
    - **Ropa:** 15% si la cantidad es 3 o más; 5% en caso contrario.
    - **Hogar:** 10% si la cantidad es 2 o más; 0% si es inferior.
    - **Alimentación:** 5% siempre.
  - Si el cliente es VIP, se añade un 5% adicional sin sobrepasar el 30% total.
  - Calcula el subtotal (precio × cantidad) y aplica el descuento.
  - Redondea el total a dos decimales usando un método auxiliar `redondear(double valor)`.

### Pruebas Unitarias  
- **productoTest.java:**  
  - Verifica la creación correcta de `Producto` y el lanzamiento de excepciones por precios o cantidades negativas.
  - *Nota:* Revisar el método `generarLista` para asegurar que cada instancia refleje la cantidad correcta.
  
- **calculadoraDescuentosTest.java:**  
  - Comprueba los distintos escenarios de descuento para cada categoría.
  - Verifica la condición VIP y el límite máximo de descuento.
  - Incluye pruebas para manejo de categorías inválidas.
  - Las líneas 28-30 contenían un if que no se cumple nunca la función así que para mejorar en números lo he comentado.
 # Con esto se explica superficialmente el proceso de JUnit.
