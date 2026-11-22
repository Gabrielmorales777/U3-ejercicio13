public class Main {

    public static void main(String[] args) {

        Prenda prenda = new Prenda("Remera básica", 15000);

        System.out.println("=== Estado inicial ===");
        System.out.println(prenda.obtenerInventario());

        System.out.println("\n=== Carga de stock ===");
        prenda.agregarStock("S", 10);
        prenda.agregarStock("M", 15);
        prenda.agregarStock("L", 8);
        prenda.agregarStock("XL", 5);
        System.out.println(prenda.obtenerInventario());

        System.out.println("\n=== Ventas exitosas ===");
        prenda.vender("M", 4);
        prenda.vender("l", 8);
        prenda.vender("S", 3);

        System.out.println("\n=== Operaciones inválidas ===");
        prenda.vender("L", 1);
        prenda.vender("XXL", 2);
        prenda.agregarStock("S", -5);
        prenda.vender("M", 0);
        prenda.agregarStock("XS", 10);

        System.out.println("\n=== Consultas de stock ===");
        System.out.println("Stock talle M: " + prenda.consultarStock("M"));
        System.out.println("Stock talle L: " + prenda.consultarStock("L"));
        System.out.println("Stock talle XS: " + prenda.consultarStock("XS"));

        System.out.println("\n=== Inventario final ===");
        System.out.println(prenda.obtenerInventario());
    }
}