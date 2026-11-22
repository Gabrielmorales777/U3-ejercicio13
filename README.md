# U3-ejercicio13
# 👕 Administración de Stock en una Tienda de Ropa

Ejercicio de **Programación Orientada a Objetos en Java** que modela una prenda con stock por talle aplicando el principio de **encapsulamiento**. Las cantidades se guardan en un mapa privado que relaciona cada talle (S, M, L, XL) con su stock, y todas las entradas y salidas pasan por métodos que validan el talle y evitan que el inventario quede en negativo.

## 🎯 Objetivo

Gestionar el stock por talle de una prenda ocultando los detalles internos de almacenamiento y controlando las operaciones de carga y venta para mantener la consistencia de las cantidades.

## ✨ Características

- Atributos privados: `modelo`, `precio` y un `Map<String, Integer>` con el stock por talle.
- `consultarStock(String talle)`: devuelve la cantidad disponible, o `-1` si el talle no existe.
- `agregarStock(String talle, int cantidad)`: valida talle existente y cantidad positiva.
- `vender(String talle, int cantidad)`: valida talle existente, cantidad positiva y stock suficiente.
- Talles aceptados sin distinguir mayúsculas ni espacios (`"l"` equivale a `"L"`).
- Inventario impreso siempre en el mismo orden gracias a `LinkedHashMap`.
- Precio protegido con setter validado.

## 📚 Conceptos aplicados

Encapsulamiento · Colecciones (`Map`) · Modificadores de acceso · Validación de datos · Constructores · Métodos privados

![U3 ejercicio13](U3%20ejercicio13.png)
