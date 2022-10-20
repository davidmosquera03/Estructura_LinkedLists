from Nodo import Nodo
class LinkedList:
    def __init__(self) -> None:
        self.PTR = None
        self.ULT = None

    def addNode(self, data)->None:
        """
        Adds node at last position
        """
        P = Nodo(data)
        if self.PTR == None:
            self.PTR = P
            self.ULT = P
        else:
            self.ULT.next= P
            self.ULT = P

    def DeleteNode(self, data):
        """
        Deletes instance of Node with data
        """
        if (self.PTR == None):
            print("Empty list")
        anteP = None
        P = self.PTR
        while(P != None):
            if (self.PTR.data == data):
                self.PTR = P.next
                del P
                P = self.PTR
            else:
                while(P != None and P.data != data):
                    anteP = P
                    P = P.next
                if (P != None and P.data == data):
                    if P==self.ULT:
                        self.ULT = anteP
                    anteP.next = P.next
                    P.next = None
                    del P
                    P = anteP.next


    def sort(self):
        save = []
        P = self.PTR
        while(P!=None):
            save.append(int(P.data))
            P = P.next
        save.sort()
        i=0
        P = self.PTR
        while(P!=None):
            P.data = str(save[i])
            i+=1
            P = P.next


    def eliminar_comun(self, lista2: object):
        """
        Elimina de una lista los elementos comunes con la otra
        """
        self.sort()
        lista2.sort()
        P1 = self.PTR
        P2 = lista2.PTR
        share = []
        # Recorren listas y guarda en share valores comunes
        while(P1!=None and P2!=None):
            if(int(P1.data)==int(P2.data)):
                share.append(P1.data)
                P1 = P1.next
                P2 = P2.next
            else:
                if(P1.data>P2.data):
                    P2 = P2.next
                else:
                    P1 = P1.next
        print(share)
        for i in range(len(share)):
            self.DeleteNode(share[i]) # Itera para borrar elementos
        print(self)

    def diferentes(self, lista2):
        """
        Devuelve elementos diferenes entre dos listas
        """
        self.sort()
        lista2.sort()
        P1 = self.PTR
        P2 = lista2.PTR
        dif = [] # Almacena aqui diferentes
        while(P1!=None and P2!=None): # Logica de archivos
            if(P1.data==P2.data):
                P1 = P1.next
                P2 = P2.next
            else:
                if(P1.data>P2.data):
                    dif.append(P2.data)
                    P2 = P2.next
                else:
                    dif.append(P1.data)
                    P1 = P1.next
        while(P1!=None):
            dif.append(P1.data)
            P1 = P1.next
        while(P2!=None):
            dif.append(P2.data)
            P1 = P1.next
        print("Diferentes "+str(len(dif)))
        print(dif)

    def invertir(self):
        """
        Invierte el sentido de los enlaces
        """
        prev: Nodo = None
        current: Nodo = self.PTR
        next: Nodo = None
        while(current!=None):
            next = current.next
            if(current==self.PTR):
                self.ULT = current
            elif (current.next==None):
                self.PTR = current
            current.next = prev # El actual ahora se conecta con el anterior
            prev = current
            current = next # Seguir recorriendo

    def special(self):
        """
        elimina 0
        agrega -1000 antes de negativos
        agrega 1000 despues de positivos
        """
        prev: Nodo = None
        P : Nodo = self.PTR
        while(P !=None):
            p = int(P.data)
            if(p<0):
                if(prev == None):
                    prev = Nodo("-1000")
                else:
                    Q: Nodo = Nodo("-1000")
                    prev.next = Q
                    Q.next = P
                if P == self.PTR:
                    self.PTR = prev
                    prev.next = P
                prev = P
                P = P.next
            elif(p==0):
                if(P == self.PTR):
                    self.PTR = P.next
                    P.next = None
                    P = self.PTR
                else:
                    if(P == self.ULT):
                        self.ULT = prev
                    prev.next = P.next
                    P.next = None
                    P = prev
                    prev = P
                    P = P.next
            elif(p>0):
                Q: Nodo = Nodo("1000")
                Q.next = P.next
                P.next = Q
                if(P==self.ULT):
                    self.ULT = Q
                prev = P
                P = P.next
                prev = P
                P = P.next

    def copy(self):
        """
        Crea una copia de la lista
        """
        C = LinkedList()
        P: Nodo = self.PTR
        while(P!=None):
            C.addNode(P.data)
            P = P.next
        return C
    def len(self):
        """
        devuelve numero de elementos en la lista
        """
        i=0
        P = self.PTR
        while(P!=None):
            P = P.next
            i+=1
        return i
    def n_norepetidos(self):
        """
        Devuelve numero de elementos no repetidos
        """
        copy = self.copy()
        copy.sort()
        arr = []
        P = copy.PTR
        while(P!=None):
            arr.append(P.data)
            P = P.next
        # Guarda elementos repetidos en arr
        for i in range(0,len(arr)):
            for j in range(1,len(arr)):
                if arr[i]==arr[j]:
                    copy.DeleteNode(arr[i])
        # Al detectar repetido se elimina de la copia
        res = copy.len() # longitud de la copia es de elementos no repetidos
        return res

    def pos_neg(self, neg, pos):
        """
        dadas dos listas
        almacena en una valores positivos
        en otra negativos
        elimina el 0 de la lista principal
        """
        self.DeleteNode("0")
        P = self.PTR
        while(P!=None):
            p = int(P.data)
            if(p<0):
                neg.addNode(P.data)
            else:
                pos.addNode(P.data)
            P = P.next
            print("POS")
            print(pos)
            print("NEG")
            print(neg)

    def reverse_comun(self, lista2):
        """
        
        devuelve otro lista con elementos comunes
        y en sentido descendiente
        """
        res = LinkedList()
        self.sort() 
        lista2.sort()
        # ordena ascendentemente
        P1 = self.PTR
        P2 = lista2.PTR
        share = []
        while(P1!=None and P2!=None):
            if(int(P1.data)==int(P2.data)):
                share.append(P1.data)
                P1 = P1.next
                P2 = P2.next
            else:
                if(P1.data>P2.data):
                    P2 = P2.next
                else:
                    P1 = P1.next
        for i in range(len(share)):
            res.addNode(share[i]) # añade comunes guardados a nueva lista
        res.invertir() # solo hay q invertir ordenado ascendentemente
        return res

    def son_iguales(self, lista2):
        """
        devueve si dos listas son iguales en datos
        """
        res = True
        P1= self.PTR
        P2 = lista2.PTR
        if(self.len()==lista2.len()):
            while(P1!=None and res):
                if(P1.data!=P2.data):
                    res = False
                P1 = P1.next
                P2 = P2.next
        else:
            res = False
        return res

    def DeleteK(self, pos:int):
        """
        Dada posición k elimina Nodo k-esimo
        """
        prev: Nodo = None
        P = self.PTR
        if pos==0: # caso PTR
            self.PTR = P.next
        else:
            i = 0  
            while P!=None and i!=pos: # Recorre hasta posición
                prev = P
                P = P.next
                i+=1
            if P!=None and i==pos:
                if P==self.ULT: # Caso ULT
                    self.ULT = prev
                prev.next = P.next
                P.next = None
                P = prev.next
            elif P==None:
                print("Posicion no en lista")


    def __repr__(self) -> str:
        s =""
        P = self.PTR
        while(P != None):
            s= s+str(P.data)+"->"
            P = P.next
        s=s+"None"
        return s
