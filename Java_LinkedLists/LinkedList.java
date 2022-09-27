package Java_LinkedLists;

public class LinkedList {

    Nodo PTR;
    Nodo ULT;

    public LinkedList() { // constructor
        this.PTR = null;
        this.ULT = null;
    }

    public void AddNode(String data) { // Adicionar Nodo
        Nodo P = new Nodo(data);
        if (this.PTR == null) { // si es el único
            this.PTR = P;
            this.ULT = P;
        } else {
            ULT.next = P;
            this.ULT = P;
        }
    }

    public void InsertNode(String data, int pos) {
        Nodo Q = new Nodo(data); // Nodo a insertar
        Nodo P = this.PTR; // 0("4") 1("9") 2("7") 3("6")
        if (pos == 0) {
            this.PTR = Q; // si es 0 pos, el nuevo nodo es ahora PTR
            Q.next = P;
        } else {
            for (int i = 0; i < pos - 1; i++) {
                P = P.next; // posicionarme antes de donde quiero insertar el nodo
            }
            Nodo R = P.next; // Nodo por desplazar
            P.next = Q; // el siguiente es ahora Q
            Q.next = R; // Se desplaza R
            if (pos == this.len() - 1) {
                this.ULT = Q;
            }

        }

    }

    public void InsertAfter(String data, String valor) { // Revisar caso antes de ULT (hecho)
        Nodo P = this.PTR;
        while (P != null && !P.data.equals(data)) {
            P = P.next;
        }
        if (P == null) {
            System.out.println(data + " No hallado");
        } else {
            Nodo Q = new Nodo(valor);
            Q.next = P.next;
            P.next = Q; // el siguiente es ahora Q
            if (Q.next == null) {
                this.ULT = Q;
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
            while (P.next != null && !P.next.data.equals(data)) { // 56 4 21 0
                P = P.next;
            }
            if (P.next == null) {
                System.out.println(data + " No hallado");
            } else {
                Nodo Q = new Nodo(valor);
                Q.next = P.next;
                P.next = Q; // el siguiente es ahora Q
                if (Q.next == null) {
                    this.ULT = Q;
                }
            }
        }

    }

    public void EliminarNodo(String data) {
        Nodo prev = null;
        Nodo P = this.PTR;
        while (P != null) {
            if (this.PTR.data.equals(data)) {
                this.PTR = P.next;
                P.next = null;
                P = this.PTR;
            } else {
                while (P != null && !P.data.equals(data)) {
                    prev = P;
                    P = P.next;
                }
                if (P != null && P.data.equals(data)) {
                    if (P == this.ULT) {
                        this.ULT = prev;
                    }
                    prev.next = P.next;
                    P.next = null;
                    P = prev.next;
                }
            }

        }
    }

    public void EliminarNodo2(String data, int times) { // elimina times instancias de data
        Nodo prev = null;
        Nodo P = this.PTR;
        while (P != null & times > 0) {
            if (this.PTR.data.equals(data) & times > 0) {
                times -= 1;
                this.PTR = P.next;
                P.next = null;
                P = this.PTR;
            } else {
                while (P != null && !P.data.equals(data) & times > 0) {
                    prev = P;
                    P = P.next;
                }
                if (P != null && P.data.equals(data) & times > 0) {
                    times -= 1;
                    if (P == this.ULT) {
                        this.ULT = prev;
                    }
                    prev.next = P.next;
                    P.next = null;
                    P = prev.next;
                }
            }

        }
    }

    public void Escribir_lista() { // imprime cada valor del Nodo
        Nodo P = this.PTR;
        while (P != null) {
            System.out.print(P.data + " - ");
            P = P.next;
        }
        System.out.print("null\n");
    }

    public int len() { // devuelve el número de elementos de la LinkedList
        int l = 0;
        Nodo P = this.PTR;
        while (P != null) {
            P = P.next;
            l++;
        }
        return l;
    }

    public void Combinar(LinkedList b) { // Modifica el original al que se le aplica la funcion
        this.ULT.next = b.PTR;

    }

    public void Combinar2(LinkedList a, LinkedList b) {
        // llena una tercera lista con la combinacion de nodos a y b
        this.PTR = a.PTR;
        this.ULT = a.ULT;
        this.ULT.next = b.PTR;
    }

    public void sort() {
        int len = this.len(); // Longitud de lista
        String arr[] = new String[len];

        Nodo P = this.PTR;
        int i = 0;
        while (P != null) { // copiar datos a vector
            arr[i] = P.data;
            i++;
            P = P.next;
        }
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
        while (P != null) { // Pasar datos ordenados a lista
            P.data = arr[i];
            P = P.next;
            i++;
        }

    }

    public void eliminar_comun(LinkedList a) {
        this.sort();
        a.sort();
        // ordenan listas
        Nodo P1 = this.PTR;
        Nodo P2 = a.PTR;
        String share[] = new String[this.len()];
        int i = 0;
        while (P1 != null && P2 != null) {
            int p1 = Integer.parseInt(P1.data);
            int p2 = Integer.parseInt(P2.data);
            // System.out.println("p1 "+p1+" p2 "+p2);
            if (p1 == p2) {
                share[i] = String.valueOf(p1);
                i++;
                P1 = P1.next;
                P2 = P2.next;
            } else {
                if (p1 < p2) {
                    P1 = P1.next;
                } else { // p1>p2
                    P2 = P2.next;
                }
            }
        }
        for (int j = 0; j < i; j++) {
            this.EliminarNodo(share[j]);
        }
    }

    public void Diferentes(LinkedList a) {
        this.sort();
        a.sort();
        Nodo P1 = this.PTR;
        Nodo P2 = a.PTR;
        String dif[] = new String[this.len() + a.len()];
        // Vector guarda diferentes
        int i = 0;
        while (P1 != null && P2 != null) { // misma logica de archivos
            int p1 = Integer.parseInt(P1.data);
            int p2 = Integer.parseInt(P2.data);
            if (p1 == p2) {
                P1 = P1.next;
                P2 = P2.next;
            } else {
                if (p1 < p2) {
                    dif[i] = String.valueOf(p1);
                    i++;
                    P1 = P1.next;
                    // cada diferente se guarda y aumenta posicion en vector
                } else { // p1>p2
                    dif[i] = String.valueOf(p2);
                    i++;
                    P2 = P2.next;
                }
            }
        }
        while (P1 != null) {
            int p1 = Integer.parseInt(P1.data);
            dif[i] = String.valueOf(p1);
            i++;
            P1 = P1.next;
        }
        while (P2 != null) {
            int p2 = Integer.parseInt(P2.data);
            dif[i] = String.valueOf(p2);
            i++;
            P2 = P2.next;
        }
        // si quedan por revisar, son diferentes
        System.out.println("Diferentes " + i);
        for (int j = 0; j < i; j++) {
            System.out.print(dif[j] + " ");
        }
        System.out.println();
    }

    public void invertir() {
        Nodo prev = null;
        Nodo current = this.PTR;
        Nodo next = null;
        // Guardamos el valor anterior, actual, y siguiente
        while (current != null) {
            next = current.next; // actualizamos siguiente
            if (current == this.PTR) {
                this.ULT = current; // PTR será ULT y viceversa
            } else if (current.next == null) {
                this.PTR = current;
            }
            current.next = prev; // actual conecta hacia atrás
            prev = current; // actual es ahora prev
            current = next; // nos movemos al suguiente...
        }

    }

    public void special() {
        Nodo prev = null;
        Nodo P = this.PTR;
        while (P != null) {
            int p = Integer.parseInt(P.data);
            System.out.println("P es " + p);
            if (p < 0) { // negativo poner -1000 antes
                System.out.println("negativo " + p);
                if (prev == null) { // Si estamos en PTR prev sera el nodo añadido
                    prev = new Nodo("-1000");
                } else {
                    Nodo Q = new Nodo("-1000"); // Si no, Introducimos nuevo nodo
                    prev.next = Q;
                    Q.next = P;
                }
                if (P == PTR) { // Actualizar PTR
                    this.PTR = prev; // prev vuelve PTR
                    prev.next = P;
                }
                prev = P;
                P = P.next;
            } else if (p == 0) { // 0 eliminar
                if (P == this.PTR) {
                    this.PTR = P.next;
                    P.next = null;
                    P = this.PTR;
                } else {
                    if (P == this.ULT) {
                        this.ULT = prev;
                    }
                    prev.next = P.next;
                    P.next = null;
                    P = prev;
                    prev = P;
                    P = P.next;
                }
            } else if (p > 0) { // positivo 1000 despues

                Nodo Q = new Nodo("1000");
                Q.next = P.next;
                P.next = Q;
                if (P == this.ULT) { // Actualizar ULT
                    this.ULT = Q;
                }
                prev = P;
                P = P.next; // moverse para ignorar 1000 añadido
                prev = P;
                P = P.next;
            }

            // cambiar prev y nodo
        }

    }

    public LinkedList copy() {
        LinkedList C = new LinkedList();
        Nodo P = this.PTR;
        while (P != null) {
            C.AddNode(P.data);
            P = P.next;
        }
        return C;
    }

    public int n_norepetidos() {
        LinkedList copy = this.copy(); // copio lista original para no afectar datos
        copy.sort();

        int len = this.len(); // Longitud de lista
        String arr[] = new String[len];

        Nodo P = copy.PTR;
        int i = 0;
        while (P != null) { // copiar datos a vector
            arr[i] = P.data;
            i++;
            P = P.next;
        }
        for (int j = 0; j < i; j++) {
            for (int k = j + 1; k < i; k++) {

                if (arr[j].equals(arr[k])) {
                    copy.EliminarNodo(arr[j]); // Eliminar repetidos en copia
                }

            }

        }
        int res = copy.len(); // nueva longitud de copia es de datos no repetidos
        return res;
    }

    public void pos_neg(LinkedList pos, LinkedList neg) {
        this.EliminarNodo("0"); // Eliminamos el 0 del Nodo
        Nodo P = this.PTR;
        while (P != null) {
            int pdata = Integer.parseInt(P.data);
            if (pdata > 0) {
                pos.AddNode(P.data);
            } else {
                neg.AddNode(P.data);
            }
            P = P.next;
        }
        System.out.println("POS");
        pos.Escribir_lista();
        System.out.println("NEG");
        neg.Escribir_lista();
    }

    public LinkedList reverse_comun(LinkedList a) {
        this.sort();
        a.sort();
        // deben estar ordenados pero se revisa igualmente

        LinkedList res = new LinkedList();
        // Se crea lista para guardar semejantes
        Nodo P1 = this.PTR;
        Nodo P2 = a.PTR;
        String share[] = new String[this.len()];
        int i = 0;
        while (P1 != null && P2 != null) {
            int p1 = Integer.parseInt(P1.data);
            int p2 = Integer.parseInt(P2.data);
            // System.out.println("p1 "+p1+" p2 "+p2);
            if (p1 == p2) {
                share[i] = String.valueOf(p1);
                i++;
                P1 = P1.next;
                P2 = P2.next;
            } else {
                if (p1 < p2) {
                    P1 = P1.next;
                } else { // p1>p2
                    P2 = P2.next;
                }
            }
        }
        // Reuliliza codigo de eliminar comunes
        for (int j = 0; j < i; j++) {
            res.AddNode(share[j]);
        }
        // añado comunes a res
        res.invertir();
        return res;
    }

    public boolean son_iguales(LinkedList lista2) {
        boolean res = true; // Asume son iguales
        this.sort();
        lista2.sort();
        // Ordenan ambas
        Nodo P1 = this.PTR;
        Nodo P2 = lista2.PTR;
        if (this.len() == lista2.len()) {
            // Obtienen PTRs de cada una
            while (P1 != null && res) { // si son iguales iterar en base a largo de una es igual
                if (!P1.data.equals(P2.data)) {
                    res = false;
                    // Si valor es diferente no pueden ser iguales
                }
                P1 = P1.next;
                P2 = P2.next;
            }
        } else {
            res = false;
        }

        return res; // devolver booleano
    }

    public void Eliminar_k(int pos) {
        Nodo prev = null;
        Nodo P = this.PTR;
        if (pos == 0) {
            this.PTR = P.next;
            P.next = null;
            P = this.PTR;
        } else {
            int i = 0;
            while (P != null && i != pos) {
                prev = P;
                P = P.next;
                i++;
            }
            if (P != null && i == pos) {
                if (P == this.ULT) {
                    this.ULT = prev;
                }
                prev.next = P.next;
                P.next = null;
                P = prev.next;
            }else if(P==null){
                System.out.println("Posición no en lista");
            }
        }

    }

}