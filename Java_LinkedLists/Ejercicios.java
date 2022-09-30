package Java_LinkedLists;

public class Ejercicios {
    public static void main(String[] args) {
        LinkedList lista = new LinkedList();
        System.out.println("Lista 1");
        lista.AddNode("-1");
        lista.AddNode("0");
        lista.AddNode("3");
        lista.AddNode("7");
        lista.AddNode("7");
        lista.Escribir_lista();
        LinkedList lista2 = new LinkedList();
        System.out.println("Lista 2");
        lista2.AddNode("0");
        lista2.AddNode("2");
        lista2.AddNode("3");
        lista2.AddNode("10");
        lista2.Escribir_lista();
        
        System.out.println("Eliminar comunes");
        lista.eliminar_comun(lista2);
        lista.Escribir_lista();
        
        System.out.println("Diferentes");
        lista.Diferentes(lista2);
        
        LinkedList lista3 = new LinkedList();
        lista3.AddNode("1");
        lista3.AddNode("0");
        lista3.AddNode("0");
        lista3.Escribir_lista();

        System.out.println("Invertir ");
        lista3.invertir();
        lista3.Escribir_lista();

        System.out.println("Special");
        lista3.special();
        lista3.Escribir_lista();
        System.out.println("PTR "+lista3.PTR+" ULT "+lista3.ULT);

        System.out.println("Lista1");
        lista.AddNode("0");
        lista.AddNode("0");
        lista.Escribir_lista();
        System.out.println("Numero no repetidos "+lista.n_norepetidos());
        lista.Escribir_lista();
        lista.AddNode("-63");
        LinkedList neg = new LinkedList();
        LinkedList pos = new LinkedList();
        lista.pos_neg(pos, neg);

        LinkedList A = new LinkedList();
        LinkedList B = new LinkedList();
        System.out.println("Comparar igualdad");
      
        A.AddNode("9");
        A.AddNode("8");
        

        B.AddNode("8");
        B.AddNode("9");
        
        System.out.println("A");
        A.Escribir_lista();
        System.out.println("B");
        B.Escribir_lista();
        if(A.son_iguales(B)){
            System.out.println("Son iguales");
        }else{
            System.out.println("Las listas son diferentes");
        }
        System.out.println("Guardar semejantes descendentemente");
        A.AddNode("-5");
        B.AddNode("40");
        LinkedList AuB = A.reverse_comun(B);
        AuB.Escribir_lista();
        if(A.son_iguales(B)){
            System.out.println("Son iguales");
        }else{
            System.out.println("Las listas son diferentes");
        }
        System.out.println("A");
        A.Escribir_lista();
        A.Eliminar_k(3);
        A.Escribir_lista();
        LinkedList a = new LinkedList();
        a.AddNode("5");
        a.AddNode("3");
        a.AddNode("8");
        a.AddNode("8");
        LinkedList b = new LinkedList();
        b.AddNode("8");
        b.AddNode("5");
        b.AddNode("8");
        b.AddNode("3");
        System.out.println("Times");
        int res = b.times_data("8");
        System.out.println(res);
        System.out.println("Similares a y b?");
        if(a.similar(b)){ // Linea 510 de LinkedLISt
            System.out.println("Similares");
        }else{
            System.out.println("NOOO");
        }
    }
}
