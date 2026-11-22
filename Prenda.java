import java.util.LinkedHashMap;
import java.util.Map;

public class Prenda {

    private static final String[] TALLES = {"S", "M", "L", "XL"};

    private final String modelo;
    private double precio;
    private final Map<String, Integer> stockPorTalle;

    public Prenda(String modelo, double precio) {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede estar vacío.");
        }
        if (!esPrecioValido(precio)) {
            throw new IllegalArgumentException("El precio debe ser un número mayor a 0.");
        }
        this.modelo = modelo;
        this.precio = precio;
        this.stockPorTalle = new LinkedHashMap<>();
        for (String talle : TALLES) {
            stockPorTalle.put(talle, 0);
        }
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double nuevoPrecio) {
        if (!esPrecioValido(nuevoPrecio)) {
            System.out.println("Error: el precio debe ser un número mayor a 0.");
            return;
        }
        precio = nuevoPrecio;
        System.out.println("Precio actualizado a $" + precio);
    }

    public int consultarStock(String talle) {
        String clave = normalizar(talle);
        if (!stockPorTalle.containsKey(clave)) {
            System.out.println("Error: el talle '" + talle + "' no existe.");
            return -1;
        }
        return stockPorTalle.get(clave);
    }

    public boolean agregarStock(String talle, int cantidad) {
        String clave = normalizar(talle);
        if (!stockPorTalle.containsKey(clave)) {
            System.out.println("Error: el talle '" + talle + "' no existe.");
            return false;
        }
        if (cantidad <= 0) {
            System.out.println("Error: la cantidad a agregar debe ser mayor a 0.");
            return false;
        }
        stockPorTalle.put(clave, stockPorTalle.get(clave) + cantidad);
        System.out.println("Stock agregado: +" + cantidad + " en talle " + clave
                + ". Disponible: " + stockPorTalle.get(clave));
        return true;
    }

    public boolean vender(String talle, int cantidad) {
        String clave = normalizar(talle);
        if (!stockPorTalle.containsKey(clave)) {
            System.out.println("Error: el talle '" + talle + "' no existe.");
            return false;
        }
        if (cantidad <= 0) {
            System.out.println("Error: la cantidad a vender debe ser mayor a 0.");
            return false;
        }
        int disponible = stockPorTalle.get(clave);
        if (cantidad > disponible) {
            System.out.println("Error: stock insuficiente en talle " + clave
                    + ". Solicitado: " + cantidad + " | Disponible: " + disponible);
            return false;
        }
        stockPorTalle.put(clave, disponible - cantidad);
        System.out.println("Venta registrada: -" + cantidad + " en talle " + clave
                + ". Disponible: " + stockPorTalle.get(clave));
        return true;
    }

    public int getStockTotal() {
        int total = 0;
        for (int cantidad : stockPorTalle.values()) {
            total += cantidad;
        }
        return total;
    }

    public String obtenerInventario() {
        StringBuilder sb = new StringBuilder();
        sb.append("Modelo: ").append(modelo)
                .append(" | Precio: $").append(precio);
        for (Map.Entry<String, Integer> entrada : stockPorTalle.entrySet()) {
            sb.append(" | ").append(entrada.getKey()).append(": ").append(entrada.getValue());
        }
        sb.append(" | Total: ").append(getStockTotal());
        return sb.toString();
    }

    private String normalizar(String talle) {
        return talle == null ? null : talle.trim().toUpperCase();
    }

    private boolean esPrecioValido(double valor) {
        return !Double.isNaN(valor) && !Double.isInfinite(valor) && valor > 0;
    }
}