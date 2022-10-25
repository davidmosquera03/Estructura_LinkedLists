class Nodo:
    def __init__(self, data) -> None:
        self.data = data
        self.next = None
    
    def __repr__(self) -> str:
        return f"{self.data}"
    
class Nodo2:
    def __init__(self, coef: int, expx: int, expy: int, expz: int) -> None:
        """
        Constructor para Nodos polinomiales
        """
        self.coef = coef
        self.expx = expx
        self.expy = expy
        self.expz = expz
    def __repr__(self) -> str:
        return f"{self.coef} {self.expx} {self.expy} {self.expz}"


        