package Java_LinkedLists;

public class Test_LinkedL {

    //static no puede hacerle Override
    public static void main(String[] args) {
        LinkedList lista = new LinkedList();
        
        System.out.println("Lista 1");
        lista.AddNode("1");
        lista.AddNode("3");
        lista.AddNode("2");
        lista.AddNode("10");
        lista.Escribir_lista();
        
        System.out.println("Agregar 4 despues de 10");
        lista.InsertAfter("10","4");
        lista.Escribir_lista(); 
        System.out.println("ULT es "+lista.ULT);
        
        System.out.println("Agregar -5 antes de 1");
        lista.InsertBefore("1", "-5");
        lista.Escribir_lista();
        System.out.println("PTR es "+lista.PTR);
        System.out.println("ULT es "+lista.ULT);
        
        System.out.println("Eliminar 10");
        lista.EliminarNodo("10");
        lista.Escribir_lista();
        
        System.out.println("Ordenada");
        lista.sort();
        lista.Escribir_lista();
        System.out.println("longitud de lista1 es "+lista.len());
   
        
        LinkedList lista2 = new LinkedList();
        System.out.println("Lista 2");
        lista2.AddNode("-1");
        lista2.AddNode("-3");
        lista2.AddNode("-4");
        lista2.AddNode("-7");
        lista2.Escribir_lista();
        
        System.out.println("Ordenada");
        lista2.sort();
        lista2.Escribir_lista();
         
        LinkedList lista3 = new LinkedList();
        //Combinar dos listas
        System.out.println("Combinacion 1 y 2");
        lista3.Combinar2(lista, lista2);
        lista3.Escribir_lista();
        
        LinkedList lista4 = new LinkedList();
        lista4.AddNode("1");
        lista4.AddNode("1");
        lista4.AddNode("4");
        lista4.AddNode("10");
        lista4.AddNode("1");
        lista4.AddNode("7");
        lista4.AddNode("1");
        System.out.println("Lista 4");
        lista4.Escribir_lista();
        System.out.println("Eliminar 1, 3 vecess");
        lista4.EliminarNodo2("1",3);
        lista4.Escribir_lista();

        System.out.println("Lista5");
        System.out.println("insertar en ULT");
        LinkedList lista5 = new LinkedList();
        lista5.AddNode("1");
        lista5.AddNode("4");
        lista5.InsertNode("8", 2);
        lista5.Escribir_lista();
        System.out.println("PTR "+lista5.PTR+" ULT "+lista5.ULT);

        System.out.println("Sorting cambiando enlaces (Pesadilla)");
        
        lista5.AddNode("-2");
        lista5.AddNode("-1");
        lista5.Escribir_lista();
        lista5.sort_enlaces();
        lista5.Escribir_lista();
        
        System.out.println("Eliminar toda la lista igual a un valor");
        LinkedList x = new LinkedList();
        x.AddNode("1");
        x.AddNode("1");
        x.Escribir_lista();
        x.EliminarNodo("1");
        x.Escribir_lista();
    }
    
}