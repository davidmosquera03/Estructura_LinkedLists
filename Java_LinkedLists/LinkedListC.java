package Java_LinkedLists;

public class LinkedListC {
    Nodo PTR;
    Nodo ULT;
    Nodo2 PTR2;
    Nodo2 ULT2;

    public LinkedListC() {
        this.PTR = null;
        this.ULT = null;
        this.PTR2 = null;
        this.ULT2 = null;
    }

    public void AddNode(String data) { // Adicionar Nodo
        Nodo P = new Nodo(data);
        if (this.PTR == null) { // si es el único
            this.PTR = P;
            this.ULT = P;
            this.PTR.next = PTR;
        } else {
            ULT.next = P;
            this.ULT = P;
            this.ULT.next = this.PTR;
        }
    }

    public void Escribir_lista() { // imprime cada valor del Nodo
        Nodo P = this.PTR;
        while (P.next != PTR) {
            System.out.print(P.data + " - ");
            P = P.next;
        }
        System.out.print(P.data + " - " + P.next + "(PTR)\n"); // Imprime ULT y muestra PTR
    }

    public void EliminarNodo(String data) {
        Nodo prev = this.ULT;
        Nodo P = this.PTR;
        while (this.PTR.data.equals(data)) {
            prev.next = P.next;
            this.PTR = P.next;
            P.next = null;
            P = this.PTR;
        }
        prev = P;
        P = P.next;
        while (P != PTR) {
            while (P != PTR & !P.data.equals(data)) {
                prev = P;
                P = P.next;
            }
            if (P != PTR && P.data.equals(data)) {
                if (P == this.ULT) {
                    this.ULT = prev;
                }
                prev.next = P.next;
                P.next = null;
                P = prev.next;
            }
        }

    }

    public void InsertBefore(String data, String valor) { // Revisar caso antes de PTR
        Nodo P = this.PTR;
        if (P.data.equals(data)) {
            Nodo Q = new Nodo(valor);
            Q.next = this.PTR;
            this.PTR = Q;
        } else {
            while (P.next != PTR && !P.next.data.equals(data)) { // 56 4 21 0
                P = P.next;
            }
            if (P.next == PTR) {
                System.out.println(data + " No hallado");
            } else {
                Nodo Q = new Nodo(valor);
                Q.next = P.next;
                P.next = Q; // el siguiente es ahora Q
                if (Q.next == PTR) {
                    this.ULT = Q;
                }
            }
        }
        this.ULT.next = PTR;
    }

    public void InsertAfter(String data, String valor) { // Revisar caso antes de ULT (hecho)
        Nodo P = this.PTR;
        while (P.next != PTR && !P.data.equals(data)) {
            P = P.next;
        }
        if (P.next == PTR && !P.data.equals(data)) {
            System.out.println(data + " No hallado");
        } else {
            Nodo Q = new Nodo(valor);
            Q.next = P.next;
            P.next = Q; // el siguiente es ahora Q
            if (Q.next == null) {
                this.ULT = Q;
                this.ULT.next = this.PTR;
            }
        }

    }

    public int len() { // devuelve el número de elementos de la LinkedList
        int l = 0;
        Nodo P = this.PTR;
        while (P.next != PTR) {
            P = P.next;
            l++;
        }
        l++;
        return l;
    }

    public void sort() {

        int len = this.len(); // Longitud de lista
        String arr[] = new String[len];

        Nodo P = this.PTR;
        int i = 0;
        while (P.next != PTR) { // copiar datos a vector
            arr[i] = P.data;
            i++;
            P = P.next;
        }
        arr[i] = P.data;
        i++;

        for (i = 0; i < len - 1; i++) { // Ordenar vector
            for (int j = i + 1; j < len; j++) {
                if (Integer.parseInt(arr[i]) > Integer.parseInt(arr[j])) {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        i = 0;
        P = this.PTR;
        while (P.next != PTR) { // Pasar datos ordenados a lista
            P.data = arr[i];
            P = P.next;
            i++;
        }
        P.data = arr[i]; // ultimo dato

    }

    public void insertar_lista(LinkedListC lista2) {

        Nodo P = lista2.PTR;
        while (P.next != lista2.PTR) {
            this.AddNode(P.data);
            P = P.next;
        }
        this.AddNode(P.data); // agregar ULT
        this.sort(); // ordenamos
    }

    public void insert_lista2(LinkedListC lista2, int pos) { // despues de posición dada
        Nodo P1 = this.PTR;
        Nodo P2 = lista2.PTR;
        for (int i = 0; i < pos; i++) { // ir a posicion
            P1 = P1.next;
        }
        Nodo sig = P1.next; // guardar cual es el siguiente en lista1
        while (P2.next != lista2.PTR) {
            P1.next = P2;
            P2 = P2.next;
            P1 = P1.next;
            // conectar lista1 con primer elemento de lista2 y continuar....
        }
        // al llegar al ULT de lista conectar con siguiente guardado
        P2.next = sig;
        if (sig == this.PTR) {
            this.ULT = P2;
        }
    }

    public void AddNode2(int coef, int expx, int expy, int expz) { // Adicionar Nodo
        Nodo2 P = new Nodo2(coef, expx, expy, expz);
        if (this.PTR2 == null) { // si es el único
            this.PTR2 = P;
            this.ULT2 = P;
            this.PTR2.next = PTR2;
        } else {
            ULT2.next = P;
            this.ULT2 = P;
            this.ULT2.next = this.PTR2;
        }
    }

    public void recorrer2() {
        Nodo2 P = this.PTR2;
        while (P.next != PTR2) {
            System.out.print(P + " - ");
            P = P.next;
        }
        System.out.print(P + " - " + P.next + "(PTR2)\n"); // Imprime ULT y muestra PTR
    }

    public void coeficientes(LinkedListC lista2) {
        Nodo2 prev = this.ULT2;
        Nodo2 P1 = this.PTR2;
        Nodo2 P2 = lista2.PTR2;
        while (P1.next != PTR2) {
            if (P1.expx == P2.expx && P1.expy == P2.expy && P1.expz == P2.expz) {
                // si exponentes son iguales se suman los coeficientes
                P1.coef = P1.coef + P2.coef;
                if (P1.coef == 0) { // se elimina el Nodo si es 0 el coeficiente (0xyz=0)
                    if (P1 == PTR2) {
                        this.PTR2 = prev; // Caso especial PTR2
                    }
                    prev.next = P1.next;
                    P1.next = null;
                    P1 = prev;
                }
                prev = P1;
                P1 = P1.next;
                P2 = lista2.PTR2;
                // se pasa al siguiente Nodo en en lista1 y reinicia en lista2
            } else {
                P2 = P2.next;
                // Si no son iguales avanzamos en lista2
                if (P2 == lista2.PTR2) {
                    prev = P1;
                    P1 = P1.next;
                    // Si ya se recorrió la lista2, moverse en lista1
                }
            }
        }
        while (P1 != PTR2) { // Para el ULT2
            if (P1.expx == P2.expx && P1.expy == P2.expy && P1.expz == P2.expz) {
                P1.coef = P1.coef + P2.coef;
                if (P1.coef == 0) { // se elimina el Nodo si es 0 el coeficiente (0xyz=0)
                    this.ULT2 = prev; // cambiar ULT2
                    prev.next = P1.next;
                    P1.next = null;
                    P1 = prev;
                }
                prev = P1.next;
                P1 = P1.next;
                P2 = lista2.PTR2;
            } else {
                P2 = P2.next;
                if (P2 == lista2.PTR2) {
                    prev = P1;
                    P1 = P1.next;
                }
            }
        }

    }

}
