package org.example;

import excepciones.ExcepcionDesigualdadTriangular;
import excepciones.ExcepcionLadoNegativo;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TrianguloTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    //Test valores correctos

//Test valores correctos
    @Test
    public void testValoresCorrectos() throws ExcepcionLadoNegativo {
        double lado1=3;
        double lado2=3;
        double lado3=3;
        Triangulo triangulo = new Triangulo(lado1, lado2, lado3);
        String mensajeEsperado = "Los valores de los lados son correctos";
        Assertions.assertEquals(mensajeEsperado, triangulo.comprobarValores());
    }

    //Test valores incorrectos
    @Test
    public void testValoresIncorrectos(){
        double lado1=3;
        double lado2=-3;
        double lado3=3;
        Triangulo triangulo = new Triangulo(lado1, lado2, lado3);
        String mensajeEsperado = "Los lados del triangulo no pueden ser negativos";

        ExcepcionLadoNegativo excepcionObtenida =
                Assertions.assertThrows(ExcepcionLadoNegativo.class, ()-> triangulo.comprobarValores());
        Assertions.assertEquals(mensajeEsperado, excepcionObtenida.getMessage());
    }



    //Test triangulo Equilatero
    @Test
    public void testTrianguloEquilatero(){
        double lado1=3;
        double lado2=3;
        double lado3=3;
        Triangulo triangulo = new Triangulo(lado1, lado2, lado3);
        String tipoDeTrianguloEsperado = "Equilátero";
        assertEquals(tipoDeTrianguloEsperado,triangulo.identificarTipo());
    }

    //Test que cumple con desigualdad triangular
    @Test
    public void testDesigualdadTriangularValida() throws ExcepcionDesigualdadTriangular {
        double lado1=3;
        double lado2=4;
        double lado3=5;
        Triangulo triangulo = new Triangulo(lado1, lado2, lado3);
        String desigualdadTriangularEsperada = "El triangulo cumple la desigualdad triangular";
        assertEquals(desigualdadTriangularEsperada,triangulo.verificarDesigualdadTriangular());
    }


    //Test que no cumple con desigualdad triangular
    @Test
    public void testDesigualdadTriangularNoValida(){
        double lado1=3;
        double lado2=4;
        double lado3=9;
        Triangulo triangulo = new Triangulo(lado1, lado2, lado3);
        String desigualdadTriangularEsperada = "El triangulo no cumple la desigualdad triangular";
        ExcepcionDesigualdadTriangular excepcionObtenida =
                Assertions.assertThrows(ExcepcionDesigualdadTriangular.class, ()-> triangulo.verificarDesigualdadTriangular());
        Assertions.assertEquals(desigualdadTriangularEsperada, excepcionObtenida.getMessage());

    }

}