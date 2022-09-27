package Java_LinkedLists;

public class Nodo2 {
    int coef;
    int expx;
    int expy;
    int expz;
    Nodo2 next;
    public Nodo2(int coef, int expx, int expy, int expz) {
        this.coef = coef;
        this.expx = expx;
        this.expy = expy;
        this.expz = expz;
        this.next = null;
    }

    @Override
   
    public String toString() {
        String txt =(this.coef+" "+this.expx+" "+this.expy+" "+this.expz);
        return txt;
    }
}
