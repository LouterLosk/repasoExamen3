package ec.edu.evaluacion;

import java.util.ArrayList;
import java.util.List;

public class GestionEstudiantes {
    private ArrayList<Estudiante> estudiantes;

    public GestionEstudiantes() {
        estudiantes = new ArrayList<>();
        precargarEstudiantes();
    }

    private void precargarEstudiantes() {
        estudiantes.add(new Estudiante(101, "Ana Torres", "Software", 8.5));
        estudiantes.add(new Estudiante(102, "Juan Pérez", "TI", 7.2));
        estudiantes.add(new Estudiante(103, "Carla López", "Computación", 9.1));
        estudiantes.add(new Estudiante(104, "Luis Mena", "Software", 6.8));
        estudiantes.add(new Estudiante(105, "María Ruiz", "TI", 8.9));
    }

    public int total(){
        return estudiantes.size();
    }

    public ArrayList<Estudiante> listarEstudiantes() {
        // 1. Validar si la lista está vacía antes de mostrar nada
        if (estudiantes == null || estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return estudiantes;
        }
        // 2. Imprimir usando el método toString() de cada estudiante
        System.out.println("\n========== LISTADO DE ESTUDIANTES ==========");
        for (Estudiante est : estudiantes) {
            // Al pasar el objeto 'est' directamente a println, Java llama automáticamente a su método toString()
            System.out.println(est);
        }
        // 3. Retorno requerido por las pruebas unitarias
        return estudiantes;
    }

    public boolean agregarEstudiante(Estudiante estudiante) {
        if (estudiante == null)
            return false;
        if (buscarPorCodigoSecuencial(estudiante.getCodigo()) != null) {
            return false; // Código repetido, no se agrega y retorna false para que pase el test
        }
       return estudiantes.add(estudiante);
    }

    public Estudiante buscarPorCodigoSecuencial(int codigo) {
       if(estudiantes == null || estudiantes.isEmpty())
           return null;

        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante actual = estudiantes.get(i);
            // Si encontramos el código, devolvemos inmediatamente al estudiante
            if (actual.getCodigo() == codigo) {
                return actual;
            }
        }
        //Si terminamos el ciclo y no encontramos nada, devolvemos null
        return null;
    }

    public Estudiante buscarPorCodigoBinario(int codigo) {
        if(estudiantes == null || estudiantes.isEmpty())
            return null;
        if(codigo < estudiantes.get(0).getCodigo() || codigo > estudiantes.get(estudiantes.size()-1).getCodigo())
            return null;//no existe

        int inf= 0;//Inferior
        int sup = estudiantes.size()-1;//superior
        int centro;

        while(inf <= sup){
            //calculo del valor medio como es un int solo saca la parte entera
            centro = (inf + sup)/2;
            //verifica si el numero que se busca es el del medio
            if(codigo == estudiantes.get(centro).getCodigo()){
                return estudiantes.get(centro); //indice en el que se encuentra
            }else if(codigo < estudiantes.get(centro).getCodigo()){
                sup = centro - 1; //izquierdo
            }else{
                inf=centro+1; //derecho
            }
        }
        return null;//No se encontro
    }

    public Estudiante buscarPorNombreSecuencial(String nombre) {
        // Es buena práctica validar que la lista no esté vacía ni sea nula
        if (estudiantes == null || estudiantes.isEmpty()) {
            return null;
        }

        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante actual = estudiantes.get(i);
            // 1. Validamos que el nombre del estudiante no sea nulo para evitar errores
            // 2. Usamos .equals() para comparar el contenido del texto
            if (actual.getNombre() != null && actual.getNombre().equalsIgnoreCase(nombre)) {
                return actual;
            }
        }
        return null;
    }

    public ArrayList<Estudiante> ordenarPorPromedioDescendente() {
        Estudiante aux = new Estudiante();
        int j;
        for (int i = 1; i < estudiantes.size(); i++){
            aux = estudiantes.get(i);
            j = i - 1;
            while (j >= 0 && aux.getPromedio() > estudiantes.get(j).getPromedio()){//si el signo esta < es asendente y si esta > es desendente
                estudiantes.set(j+1,estudiantes.get(j));
                j--;
            }
            estudiantes.set(j+1,aux);
        }
        return estudiantes;
    }

    public ArrayList<Estudiante> ordenarPorCodigoAscendente() {
        Estudiante aux = new Estudiante();
        int j;
        for (int i = 1; i < estudiantes.size(); i++){
            aux = estudiantes.get(i);
            j = i - 1;
            while (j >= 0 && aux.getCodigo() < estudiantes.get(j).getCodigo()){//si el signo esta < es asendente y si esta > es desendente
                estudiantes.set(j+1,estudiantes.get(j));
                j--;
            }
            estudiantes.set(j+1,aux);
        }
        return estudiantes;
    }

    public int contarRecursivo(int indice) {
        // Caso base: Si el índice es igual o mayor al tamaño de la lista, detenemos la recursión.
        if (estudiantes == null || indice >= estudiantes.size()) {
            return 0;
        }
        // Caso recursivo: Sumamos 1 (por el estudiante actual) más lo que devuelva el resto de la lista.
        return 1 + contarRecursivo(indice + 1);
    }

    public double sumaPromediosRecursiva(int indice) {
        if (estudiantes == null || indice >= estudiantes.size()) {
            return 0;
        }
        return estudiantes.get(indice).getPromedio() + sumaPromediosRecursiva(indice + 1);
    }

    public double promedioGeneralRecursivo() {
        // 1. Validación de seguridad: si la lista está vacía o es nula, el promedio es 0
        if (estudiantes == null || estudiantes.isEmpty()) {
            return 0.0;
        }
        // 2. Obtenemos el total de estudiantes usando tu método recursivo (empezando desde el índice 0)
        int totalEstudiantes = contarRecursivo(0);
        // Por si acaso, para evitar una división por cero
        if (totalEstudiantes == 0) {
            return 0.0;
        }
        // 3. Obtenemos la suma acumulada de las notas usando tu método recursivo (empezando desde el índice 0)
        double sumaTotal = sumaPromediosRecursiva(0);
        // 4. Calculamos y devolvemos el promedio general
        return sumaTotal / totalEstudiantes;
    }

    public double mayorPromedioRecursivo(int indice) {
        // Caso base 1: Validación de seguridad por si la lista está vacía o el índice es inválido
        if (estudiantes == null || estudiantes.isEmpty() || indice >= estudiantes.size()) {
            return 0.0;
        }

        // Caso base 2: Si llegamos al último estudiante, su promedio es el mayor de ahí en adelante
        if (indice == contarRecursivo(0) - 1) {
            return estudiantes.get(indice).getPromedio();
        }
        // Caso recursivo: Buscamos el mayor promedio en el resto de la lista (del índice + 1 en adelante)
        double mayorDelResto = mayorPromedioRecursivo(indice + 1);
        // Obtenemos el promedio del estudiante en la posición actual
        double promedioActual = estudiantes.get(indice).getPromedio();
        // Comparamos el actual contra el mayor del resto y devolvemos el más alto
        return Math.max(promedioActual, mayorDelResto);
    }


}
