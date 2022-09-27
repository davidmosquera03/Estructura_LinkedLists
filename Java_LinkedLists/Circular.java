package Java_LinkedLists;

public class Circular {
    public static void main(String[] args) {
        LinkedListC c = new LinkedListC();
        c.AddNode("1");
        c.AddNode("4");
        c.AddNode("4");
        c.AddNode( "6");
        c.AddNode( "7");
        c.AddNode( "7");
        System.out.println("Lista");
        c.Escribir_lista();

        System.out.println("ELiminar 7");
        c.EliminarNodo("7");
        c.Escribir_lista();
        System.out.println(c.ULT);
    
        System.out.println("Insertar 15 antes de 6");
        c.InsertBefore("6", "15");
        c.Escribir_lista();

        System.out.println("Insertar -8 despues de 4");
        c.InsertAfter("4", "-8");
        c.Escribir_lista();

        System.out.println("add 2 more nodes");
        c.AddNode("-5");
        c.AddNode("7");
        c.Escribir_lista();

        System.out.println("Longitud l "+c.len());
        System.out.println("Sorting");
        c.sort();
        c.Escribir_lista();

        System.out.println("Agregar de contenido de una a otra (sin repetir)");
        LinkedListC d = new LinkedListC();
        d.AddNode("-3");
        d.AddNode("2");
        d.AddNode("10");
        System.out.println("Lista D ");
        d.Escribir_lista();
        System.out.println("Insertar en orden d en c");
        c.insertar_lista(d);
        c.Escribir_lista();

        System.out.println("Insertar despues de pos 0 c en d");
        c.EliminarNodo("4");
        c.EliminarNodo("7");
        System.out.println("Lista D ");
        d.Escribir_lista();
        System.out.println("Lista C");
        c.Escribir_lista();
        System.out.println("C len es "+c.len());
        d.insert_lista2(c,0);
        d.Escribir_lista();
        System.out.println("PTR "+d.PTR+" ULT "+d.ULT);
        System.out.println("Lista X");
        LinkedListC x = new LinkedListC();
        x.AddNode2(3, 2, 2, 3);
        x.AddNode2(1, 2,1,2);
        x.AddNode2(3,0,0,0);
        x.recorrer2();
        System.out.println("Lista y");
        LinkedListC y = new LinkedListC();
        y.AddNode2(-4, 2, 1, 4);
        y.AddNode2(-1, 2, 1, 2);
        y.AddNode2(5, 0, 0, 0);
        y.recorrer2();
        System.out.println("Opera x con y");
        x.coeficientes(y);
        x.recorrer2();
    }
}
