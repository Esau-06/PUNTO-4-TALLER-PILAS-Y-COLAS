import java.util.Scanner;
import java.util.Stack;

public class Metodos {

    public Stack<ObjDato> LLenarPila(Stack<ObjDato> p, Scanner sc) {
        boolean continuar = true;

        while (continuar) {
            ObjDato o = new ObjDato();

            System.out.println("Digite el numero:");
            o.setNumero(sc.nextInt());

            p.push(o);

            System.out.println("Desea ingresar otro numero 1) si, 2) no");
            int opt = sc.nextInt();

            if (opt == 2) {
                continuar = false;
            }
        }

        return p;
    }

    public void MostrarPila(Stack<ObjDato> p) {
        for (ObjDato o : p) {
            System.out.print(o.getNumero() + " ");
        }
        System.out.println();
    }

    // PUNTO 4
    public void Punto4(Stack<ObjDato> p, Scanner sc) {

        boolean encontrado = false;
        int buscar = 0;

        while (true) {

            if (p.isEmpty()) {
                System.out.println("La pila esta vacia, debe llenarla nuevamente");
                p = LLenarPila(p, sc);
            }

            System.out.println("Ingrese el numero a buscar:");
            buscar = sc.nextInt();

            Stack<ObjDato> aux = new Stack<>();
            int posicion = 0;
            int contador = 0;

            encontrado = false;

            while (!p.isEmpty()) {
                ObjDato o = p.pop();
                contador++;

                if (o.getNumero() == buscar && !encontrado) {
                    posicion = contador;
                    encontrado = true;
                }

                aux.push(o);
            }

            // reconstruir pila
            while (!aux.isEmpty()) {
                p.push(aux.pop());
            }

            if (encontrado) {
                System.out.println("Numero encontrado en la posicion: " + posicion);
                break;
            } else {
                System.out.println("No se encontro el numero, intente nuevamente");
            }
        }
    }
}