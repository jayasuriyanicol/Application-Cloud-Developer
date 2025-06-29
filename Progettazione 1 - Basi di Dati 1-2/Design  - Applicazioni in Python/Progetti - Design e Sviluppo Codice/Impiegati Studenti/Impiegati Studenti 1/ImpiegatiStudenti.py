'''
DESIGN del progetto Impiegati Studenti già svolto in precedenza in fase di design. IMPLEMENTAZIONE DEL CODICE IN LINGUAGGIO PYTHON.

'''

from __future__ import annotations
from datetime import date
from TipiDato import *
from Index import Index


'''  Crezione della classe PERSONA '''

class Persona:
    
    ''' Assumiamo e indichiamo che gli attributi sono protetti utilizzando "_attributo" '''
    _nome: str
    _cognome: str
    _cf: CodiceFiscale # {id}
    _nascita: date # <<immutable>>
    _is_uomo: bool  # da fusione
    _is_donna: bool # da fusione
    _maternita: IntGEZ | None # [0..1] da fusione con Donna
    _posizione_militare: PosizioneMilitare | None # [0..1] da fusione con Uomo e aggregazione di pos_uomo


    def __init__(self, *, nome: str, cognome: str, cf: CodiceFiscale, nascita: date,
                 maternita: IntGEZ|None = None,
                 posizione_militare: PosizioneMilitare |None = None) -> None:
        

        self.set_nome(nome)
        self.set_cognome(cognome)
        self.set_cf(cf)
        self._nascita = nascita
        
        '''Assiumiamo che il sesso/genere indicato sia False di default'''

        self._is_donna = False
        self._is_uomo = False
        self._maternita = maternita
        self._posizione_militare = posizione_militare


        '''Nel caso in cui andiamo a valorizzare l'attributo questo ritornerà True dato che sarà completo da qualcosa'''

        if maternita is not None:
            self._is_donna = True
        if posizione_militare is not None:
            self._is_uomo = True
        
        '''Effettuiamo un TEST per verificare che non siano entrambi dello stesso sesso o uomo o donna'''

        if not (self.is_uomo() or self.is_donna()):
            # [V.Persona.fusione]
            # Per ogni p: Persona: p.is_donna ==True or p.is_uomo==True
            raise ValueError("Ogni persona deve essere uomo, donna o entrambi!")
        



    '''Partiamo con la definizione dei metodi get,set,ecc'''

    def nome(self) -> str:
        return self._nome


    def add_genere_donna(self, maternita: IntGEZ) -> None:
        if self.is_donna():
            raise RuntimeError("Era già una donna!")
        self._maternita = maternita
        self._is_donna = True


    def add_genere_uomo(self, pos_mil: PosizioneMilitare) -> None:
        if self.is_uomo():
            raise RuntimeError("Era già un uomo!")
        self._posizione_militare = pos_mil
        self._is_uomo = True


    def remove_genere_donna(self) -> None:
        if not self.is_donna():
            raise RuntimeError("Non era una donna!")
        if not self.is_uomo():
            raise RuntimeError("Non può rimanere senza genere!")
        self._maternita = None
        self._is_donna = False


    def remove_genere_uomo(self) -> None:
        if not self.is_uomo():
            raise RuntimeError("Non era un uomo!")
        if not self.is_donna():
            raise RuntimeError("Non può rimanere senza genere!")
        self._posizione_militare = None
        self._is_uomo = False


    def is_uomo(self) -> bool:
        return self._is_uomo
    

    def is_donna(self) -> bool:
        return self._is_donna
    

    def set_nome(self, nome: str) -> None:
        self._nome = nome


    def set_cognome(self, cognome: str) -> None:
        self._cognome = cognome


    def set_cf(self, cf: CodiceFiscale) -> None:
        self._cf = cf


    def maternita(self) -> IntGEZ:
        if not self.is_donna():
            raise RuntimeError("Non era una donna!")
        return self._maternita
    

    def posizione_militare(self) -> PosizioneMilitare:
        if not self._is_uomo:
            raise RuntimeError("Non era una uomo!")
        return self._posizione_militare
    

''' Creazione della classe POSIZIONE MILITARE '''


class PosizioneMilitare:
    _nome: str # id immutabile

    def __init__(self, nome: str) -> None:
        self._nome = nome

    def nome(self) -> str:
        return self._nome


''' Creazione della classe STUDENTE '''

class Studente(Persona):

    _matricola: int # immutabile {id}
    _n_libretto: int # {id1}
    _codice: str # {id1}


    def __init__(self, *, nome: str, cognome: str, cf: CodiceFiscale, nascita: date,
                 maternita: IntGEZ | None = None,
                 posizione_militare: PosizioneMilitare | None = None,
                 matricola: int,
                 n_libretto: int,
                 codice: str) -> None:
        super().__init__(nome=nome, cognome=cognome, cf=cf, nascita=nascita,
                         maternita=maternita,posizione_militare=posizione_militare)
        

        self._matricola = matricola
        self._index_matricola.add(matricola, self)

        self._n_libretto = n_libretto
        self._codice = codice
        self._index_libretto_codice.add((n_libretto, codice), self)


    _index_matricola: Index[int, Self] = Index('Studente_matricola')
    _index_libretto_codice: Index[tuple[int, str], Self] = Index('Studente_libretto_codice')

    @classmethod
    def all(cls) -> frozenset[Studente]:
        return frozenset(cls._index_matricola.all())

    @classmethod
    def n_objects(cls) -> int:
        return len(cls._index_matricola)

    @classmethod
    def get_by_matricola(cls, matricola: int) -> Studente | None:
        return cls._index_matricola.get(matricola)

    @classmethod
    def get_by_n_libretto_e_codice(cls, n_libretto: int, codice: str) -> Studente | None:
        return cls._index_libretto_codice.get((n_libretto, codice))

    def set_n_libretto_e_codice(self, n_libretto: int|None=None, codice: str|None=None) -> None:
        if n_libretto is None and codice is None:
            raise ValueError("Almeno uno dei due argomenti deve essere non-None")
        pass



''' Creazione della classe IMPIEGATO => PERSONA '''

class Impiegato(Persona):

    _ruolo: Ruolo # mutabile
    _progetti: dict[Progetto, resp_prog._link] | None

    def __init__(self, *, nome: str, cognome: str, cf: CodiceFiscale, nascita: date,
                 maternita: IntGEZ|None = None,
                 posizione_militare: PosizioneMilitare | None=None, ruolo:Ruolo) -> None:
        super().__init__(nome=nome, cognome=cognome, cf=cf, nascita=nascita,
                         maternita=maternita, posizione_militare=posizione_militare)
        self._ruolo = ruolo
        if ruolo == Ruolo.progettista:
            self._progetti = dict()
        else:
            self._progetti = None


    def get_progetti(self) -> frozenset[resp_prog._link]:
        if not self.is_progettista():
            raise RuntimeError("L'impiegato non è un progettista, quindi non può essere responsabile di progetti!")
        return frozenset(self._progetti.values())

    def add_progetto(self, progetto: Progetto) -> None:
        if not self.is_progettista():
            raise RuntimeError("L'impiegato non è un progettista, quindi non può essere responsabile di progetti!")
        link = resp_prog._link(self, progetto)
        self._progetti[progetto] = link
        # progetto._add_impiegato(link)

    def is_progettista(self) -> bool:
        return self._ruolo == Ruolo.progettista



''' Creazione della classe RUOLO '''

class Ruolo(StrEnum):
    direttore = auto()
    segretario = auto()
    progettista = auto()


''' Creazione della classe PROGETTO - da implementare '''

class Progetto:
    pass


''' Creazione della classe RESPONSABILE PROGETTO => (IMPIEGATO -> PROGETTO) '''

class resp_prog:

    class _link:
        _impiegato: Impiegato
        _progetto: Progetto
        def __init__(self, impiegato: Impiegato, progetto: Progetto) -> None:
            if not impiegato.is_progettista():
                raise ValueError("Non posso coinvolgere un impiegato in un link resp_prog se non è un progettista!")

            self._impiegato = impiegato
            self._progetto = progetto

        def impiegato(self) -> Impiegato:
            return self._impiegato

        def progetto(self) -> Progetto:
            return self._progetto

     

       
             



    


        

    

    
           