package org.example;

import excepciones.ExcepcionDesigualdadTriangular;
import excepciones.ExcepcionLadoNegativo;

public class Triangulo {


    private double lado1;
    private double lado2;
    private double lado3;

    private boolean desigualdadTriangular;

    // Constructor

    public Triangulo() {
    }

    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }


    // Método para identificar el tipo de triángulo
    public String identificarTipo() {
        if (lado1 == lado2 && lado2 == lado3) {
            return "Equilátero";
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }

    // Método para calcular el área del triángulo usando la fórmula de Herón
    public double calcularArea() {
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    // Método para comprobar si un lado es mayor que 0
    public String comprobarValores()throws ExcepcionLadoNegativo {
        if (lado1>0 && lado2>0 && lado3>0) {
            //System.out.println("Los valores de los lados son correctos");
            return "Los valores de los lados son correctos";

        } else {
            throw new ExcepcionLadoNegativo("Los lados del triangulo no pueden ser negativos");
        }
    }

    // Método para comprobar la desigualdad triangular
    public String verificarDesigualdadTriangular() throws ExcepcionDesigualdadTriangular{
        if (lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1){
            return "El triangulo cumple la desigualdad triangular";
            //System.out.println("El triangulo cumple la desigualdad triangular");
        }else {
            throw new ExcepcionDesigualdadTriangular("El triangulo no cumple la desigualdad triangular");
        }
    }


}
