from Nodo import Nodo,Nodo2

class LinkedlistC:
    def __init__(self) -> None:
        self.PTR = None
        self.PTR2 = None
        self.ULT = None
        self.ULT = None

    def addNode(self, data: str):
        P = Nodo(data)
        if self.PTR == None:
            self.PTR = P
            self.ULT = P
            self.PTR.next = self.ULT
        else:
            self.ULT.next = P
            self.ULT = P
            self.ULT.next = self.PTR

    def delete(self, data: str):
        """
        Elimina cualquier nodo con data
        """
        prev: Nodo = self.ULT
        P: Nodo = self.PTR
        while(self.PTR.data==data):
            prev.next = P.next
            self.PTR = P.next
            P.next = None
            P = self.PTR
        prev = P
        P = P.next
        while P!=self.PTR:
            while P!=self.PTR and P.data!=data:
                prev = P
                P = P.next
                if P!=self.PTR and P.data==data:
                    if P==self.ULT:
                        self.ULT = prev
                    prev.next = P.next
                    P.next = None
                    P = prev.next

    def insert_before(self, data: str, valor: str):
        P = self.PTR
        if P.data==data:
            Q = Nodo(valor)
            Q.next = self.PTR
            self.PTR = Q
        else:
            while P.next!=self.PTR  and P.next.data!=data:
                P = P.next
            if P.next==self.PTR:
                print("No hallado")
            else:
                Q = Nodo(valor)
                Q.next = P.next
                P.next = Q
                if Q.next == self.PTR:
                    self.ULT = Q
        self.ULT.next = self.PTR

    def insertar_lista(self, lista2: object):
        """
        Inserta lista de forma ordenada en otra
        """
        P = lista2.PTR
        while(P.next !=lista2.PTR):
            self.addNode(P.data)
            P = P.next
        self.addNode(P.data)
        self.sort() # Solo se ordena al final

    def insertar_lista2(self, lista2, pos: int):
        """
        Inserta lista2 en principal pos posicion
        """
        P1 = self.PTR
        P2 = lista2.PTR
        for x in range(pos): # Va a posicion
            P1 = P1.next
        sig  = P1.next # Guarda siguiente
        while P2.next!=lista2.PTR:
            P1.next = P2
            P2 = P2.next
            P1 = P1.next
            # Agregan nodos de la otra lista
        P2.next = sig # Pone siguiente
        if sig == self.PTR:
            self.ULT = P2

    def sort(self):
        """
        Ordenamiento
        """
        arr=[]
        P = self.PTR
        while(P.next!=self.PTR):
            arr.append(int(P.data))
            P = P.next
        arr.append(int(P.data))
        arr.sort()
        i = 0
        P = self.PTR
        while(P.next!=self.PTR):
            P.data = str(arr[i])
            i+=1
            P = P.next
        P.data = str(arr[i])

    def addNode2(self, coef: int, expx: int, expy: int, expz: int):
        """
        Añaden nodos polinómicos
        """
        P = Nodo2(coef, expx, expy, expz)
        if self.PTR2 == None:
            self.PTR2 = P
            self.ULT2 = P
            self.PTR2.next = self.ULT2
        else:
            self.ULT2.next = P
            self.ULT2 = P
            self.ULT2.next = self.PTR2


    def recorrer2(self):
        """
        Recorren nodos polinómicos
        """
        P:Nodo2 = self.PTR2
        while(P.next!=self.PTR2):
            print(P,end="->")
            P = P.next
        print(P,"->",P.next,"(PTR2")
    
    def coeficientes(self, lista2: object):
        """
        Operan Nodos polinomicos de 2 listas
        """
        prev = self.ULT2
        P1 = self.PTR2
        P2 = lista2.PTR2
        while P1.next!=self.PTR2:
            if P1.expx==P2.expx and P1.expy==P2.expy and P1.expz==P2.expz:
                    P1.coef = P1.coef + P2.coef # Si comparten exponentes opera coeficiente
                    if P1.coef==0: # Si queda 0 elimina
                        if P1== self.PTR2:
                            self.PTR2 = prev
                        prev.next = P1.next
                        P1.next = None
                        P1 = prev
                    prev = P1
                    P1 = P1.next
                    P2 = lista2.PTR2 # Avanza en 1 reinicia otra
            else:
                P2 = P2.next
                if P2 == lista2.PTR2: # Avanza en la otra y si se acaba avanza en principal
                    prev = P1
                    P1 = P1.next
        while P1!=self.PTR2: # idem pero en ULT
            if P1.expx == P2.expx and P1.expy == P2.expy and P1.expz == P2.expz:
                    P1.coef = P1.coef + P2.coef
                    if P1.coef==0:
                        if P1== self.ULT2:
                            self.ULT2= prev
                        prev.next = P1.next
                        P1.next = None
                        P1 = prev
                    prev = P1
                    P1 = P1.next
                    P2 = lista2.PTR2
            else:
                P2 = P2.next
                if P2 == lista2.PTR2:
                    prev = P1
                    P1 = P1.next
            

    def __repr__(self) -> str:
        res = ""
        P = self.PTR
        while P.next!=self.PTR:
            res+=str(P.data)+"->"
            P = P.next
        res+=str(P.data)+"->"+(self.PTR.data)+"(PTR)"
        return res