package org.example;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {
        try {
            // Configuración del manejador de archivo
            FileHandler fileHandler = new FileHandler("logs.txt", true);
            LOGGER.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);


            // Ejemplo de uso
            //obtenerLados()
            Triangulo triangulo = new Triangulo(3, 3, 3);
            triangulo.comprobarValores();
            System.out.println(triangulo.verificarDesigualdadTriangular());
            System.out.println("Tipo de Triángulo: " + triangulo.identificarTipo());
            System.out.println("Área del Triángulo: " + triangulo.calcularArea());

        } catch (Exception ex) {
            // Registra el mensaje de la excepción en el log
            LOGGER.log(Level.SEVERE, "Error: ", ex);
        }
    }
}