class Quadrato(Forma):
    def __init__(self, lato: float):
        super().__init__("Quadrato")
        self.lato = lato

    def getArea(self) -> float:
        return self.lato * self.lato

    def render(self) -> None:
        for _ in range(int(self.lato)):
            print("* " * int(self.lato))


class Rettangolo(Forma):
    def __init__(self, base: float, altezza: float):
        super().__init__("Rettangolo")
        self.base = base
        self.altezza = altezza

    def getArea(self) -> float:
        return self.base * self.altezza

    def render(self) -> None:
        for _ in range(int(self.altezza)):
            print("* " * int(self.base))


class TriangoloRettangolo(Forma):
    def __init__(self, base: float, altezza: float):
        super().__init__("Triangolo Rettangolo")
        self.base = base
        self.altezza = altezza

    def getArea(self) -> float:
        return (self.base * self.altezza) / 2

    def render(self) -> None:
        for i in range(1, int(self.altezza) + 1):
            print("* " * i)
