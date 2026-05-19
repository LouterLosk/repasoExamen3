package ec.edu.evaluacion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GestionEstudiantesTest {

    @Test
    void debePrecargarCincoEstudiantes() {
        GestionEstudiantes gestion = new GestionEstudiantes();
        assertEquals(5, gestion.total());
        assertEquals(5, gestion.listarEstudiantes().size());
    }

    @Test
    void noDebeAgregarCodigoRepetido() {
        GestionEstudiantes gestion = new GestionEstudiantes();
        boolean agregado = gestion.agregarEstudiante(new Estudiante(101, "Duplicado", "Software", 10));
        assertFalse(agregado);
        assertEquals(5, gestion.total());
    }

    @Test
    void debeAgregarCodigoNuevo() {
        GestionEstudiantes gestion = new GestionEstudiantes();
        boolean agregado = gestion.agregarEstudiante(new Estudiante(200, "Nuevo Estudiante", "TI", 8.0));
        assertTrue(agregado);
        assertEquals(6, gestion.total());
        assertNotNull(gestion.buscarPorCodigoSecuencial(200));
    }

    @Test
    void debeBuscarPorNombreSecuencialSinImportarMayusculas() {
        GestionEstudiantes gestion = new GestionEstudiantes();
        Estudiante encontrado = gestion.buscarPorNombreSecuencial("ana torres");
        assertNotNull(encontrado);
        assertEquals(101, encontrado.getCodigo());
    }

    @Test
    void debeOrdenarPorPromedioDescendente() {
        GestionEstudiantes gestion = new GestionEstudiantes();
        gestion.agregarEstudiante(new Estudiante(200, "Pedro Alto", "Software", 9.8));
        ArrayList<Estudiante> ordenados = gestion.ordenarPorPromedioDescendente();

        for (int i = 0; i < ordenados.size() - 1; i++) {
            assertTrue(ordenados.get(i).getPromedio() >= ordenados.get(i + 1).getPromedio(),
                    "La lista debe estar ordenada de mayor a menor promedio");
        }
        assertEquals(9.8, ordenados.get(0).getPromedio(), 0.001);
    }


    @Test
    void debeBuscarPorCodigoBinario() {
        GestionEstudiantes gestion = new GestionEstudiantes();
        gestion.agregarEstudiante(new Estudiante(99, "Codigo Bajo", "TI", 7.0));
        gestion.agregarEstudiante(new Estudiante(300, "Codigo Alto", "TI", 7.0));

        Estudiante encontrado = gestion.buscarPorCodigoBinario(300);
        assertNotNull(encontrado);
        assertEquals("Codigo Alto", encontrado.getNombre());
        assertNull(gestion.buscarPorCodigoBinario(999));
    }

    @Test
    void debeContarRecursivamente() {
        GestionEstudiantes gestion = new GestionEstudiantes();
        gestion.agregarEstudiante(new Estudiante(200, "Nuevo", "Software", 8));
        assertEquals(6, gestion.contarRecursivo(0));
    }

    @Test
    void debeSumarYPromediarRecursivamente() {
        GestionEstudiantes gestion = new GestionEstudiantes();
        double sumaEsperada = 8.5 + 7.2 + 9.1 + 6.8 + 8.9;
        assertEquals(sumaEsperada, gestion.sumaPromediosRecursiva(0), 0.001);
        assertEquals(sumaEsperada / 5, gestion.promedioGeneralRecursivo(), 0.001);
    }


}
