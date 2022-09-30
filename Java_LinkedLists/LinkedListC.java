package Java_LinkedLists;

import java.util.ArrayList;

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
    public void DeleteNodePos(int pos) { // Elimina el nodo en pos dada
        Nodo P = this.PTR; 
        int posult = this.len()-1; // posicion de ULT
        if (pos == 0) { // caso PTR el siguiente es ahora PTR y reconecta atrás
            this.ULT.next = P.next;
            this.PTR = P.next;
            P.next = null;
        } else {
            for (int i = 0; i < pos - 1; i++) {
                P = P.next; // posicionarme antes de donde quiero eliminar el nodo
            }
            Nodo R = P.next; // R es por eliminar
            P.next = R.next;  // actual reconecta con next de R
            R.next = null; // R es desconectado
            if (pos == posult) { // caso ULT
                this.ULT.next = null;
                this.ULT = P;
                P.next = this.PTR;
            }

        }

    }
    public void eliminar_lista(LinkedListC lista2){ // Elimina presencia exacta de lista2 en lista principal
        ArrayList<Integer> pos = new ArrayList<Integer>();
        // Arraylist para guardar posiciones de presencia 
        boolean is_list=false; // Asume que no está lista2
        Nodo P = this.PTR;
        Nodo P2 = lista2.PTR;
        String possible = ""; // Para guardar posiciones antes de comprobar que toda la lista esté
        int l_pos = 0;  // contador de posición actual en lista principal
        while(P.next!=this.PTR){
            if(P.data.equals(P2.data)){
                if(!is_list){
                    is_list = true;
                }
                possible+=String.valueOf(l_pos)+";";
                if(P2==lista2.ULT){
                   String[] data = possible.split(";");
                    for (int i = 0; i < data.length; i++) {
                        pos.add(Integer.parseInt(data[i]));
                    }
                    possible="";
                    P2 = lista2.PTR;
                }else{
                    P2 = P2.next;
                }
            }else{
                if(is_list){
                    is_list = false;
                    possible = "";
                    P2 = lista2.PTR;
                }
                
            }
            l_pos++;
            P = P.next;
        }
        if(P.data.equals(P2.data)){ // se repite para ULT de lista principal
            if(!is_list){
                is_list = true;
            }
            possible+=String.valueOf(l_pos)+";";
            if(P2==lista2.ULT){
               String[] data = possible.split(";");
                for (int i = 0; i < data.length; i++) {
                    pos.add(Integer.parseInt(data[i]));
                }
                possible="";
                P2 = lista2.PTR;
            }else{
                P2 = P2.next;
            }
        }else{
            if(is_list){
                is_list = false;
                possible = "";
                P2 = lista2.PTR;
            }
            
        }

        for (int i =pos.size()-1; i>=0; i--) { 
            // para no afectar la posición de los demás elementos, se busca desde la ultima 
            this.DeleteNodePos(pos.get(i));
            // Elimina el Nodo en esa posición
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

    public boolean puede_operar(LinkedListC lista2) {
        // verifica si un polinomio tiene con que operar en otra lsita
                boolean res = false;//
                Nodo2 P1 = this.PTR2;
                Nodo2 P2 = lista2.PTR2;
                while (P1.next != PTR2) {
                    if (P1.expx == P2.expx && P1.expy == P2.expy && P1.expz == P2.expz) {
                        res = true;
                    }
                    P1 = P1.next;
                    if (P1 == null) {
                        break;
                    }
                }
                if (P1 != null) {
                    if (P1.expx == P2.expx && P1.expy == P2.expy && P1.expz == P2.expz) {
                        res = true;
                    }
                }
        
                return res;
            }
        
            public void coeficientes(LinkedListC lista2) {
                Nodo2 prev = this.ULT2;
                Nodo2 prev2 = lista2.ULT2;
                Nodo2 P1 = this.PTR2;
                Nodo2 P2 = lista2.PTR2;
                while (P1.next != PTR2) {
                    if (P1.expx == P2.expx && P1.expy == P2.expy && P1.expz == P2.expz) {
                        // si exponentes son iguales se suman los coeficientes
                        P1.coef = P1.coef + P2.coef;
                        if (P1.coef == 0) { // se elimina el Nodo en AMBAS LISTAS si es 0 el coeficiente (0xyz=0)
                            if (P1 == PTR2) {
                                this.PTR2 = prev; // Caso especial PTR2
                            }
                            if (P1 == ULT2) {
                                this.ULT2 = prev;
                            }
                            if (P2 == PTR2) {
                                lista2.PTR2 = prev2;
                            }
                            if (P2 == lista2.ULT2) {
                                lista2.ULT2 = prev;
                            }
                            prev2.next = P2.next;
                            P2.next = null;
        
                            prev.next = P1.next;
                            P1.next = null;
                            P1 = prev;
                        }
                        prev = P1;
                        P1 = P1.next;
                        P2 = lista2.PTR2;
                        prev2 = lista2.ULT2;
                        // se pasa al siguiente Nodo en en lista1 y reinicia en lista2
                    } else {
                        prev2 = P2;
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
                        if (P1.coef == 0) { // se elimina el Nodo en AMBAS LISTAS si es 0 el coeficiente (0xyz=0)
                            if (P1 == PTR2) {
                                this.PTR2 = prev; // Caso especial PTR2
                            }
                            if (P1 == ULT2) {
                                this.ULT2 = prev;
                            }
                            if (P2 == PTR2) {
                                lista2.PTR2 = prev2;
                            }
                            if (P2 == lista2.ULT2) {
                                lista2.ULT2 = prev;
                            }
                            prev2.next = P2.next;
                            P2.next = null;
        
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
                // añadimos polinomios no operados a PTR1
                // pues x^2 + x^3 = x^2 + x^3
                P2 = lista2.PTR2;
                
                while (P2.next != lista2.PTR2) {
                    if (!lista2.puede_operar(this)) {
                        this.AddNode2(P2.coef, P2.expx, P2.expy, P2.expz);
                    }
                    P2 = P2.next;
                }
                if (!lista2.puede_operar(this)) {
                        this.AddNode2(P2.coef, P2.expx, P2.expy, P2.expz);
                    }
                
        
            }
}
