package Java_LinkedLists;

//extends father
public class Nodo {

    String data;
    Nodo next;

// this es obligatorio cuando valor de entrada y atributo tiene el mismo nombre
    public Nodo(String data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return this.data;
    }

}
