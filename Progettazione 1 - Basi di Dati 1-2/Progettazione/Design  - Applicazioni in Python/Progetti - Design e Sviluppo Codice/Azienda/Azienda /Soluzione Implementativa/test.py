'''TEST PART '''

from beartype import beartype


from classi import *
from datetime import date, timedelta

from azienda.custom_types import RealGZ


@beartype
def test():
    alice: Impiegato = Impiegato(nome="Alice", cognome="Alessi",
                                 nascita=date.today()-timedelta(days=1),
                                 stipendio_annuale_eur=RealGZ(18000))

    bob: Impiegato = Impiegato(nome="Bob", cognome="Burnham",
                               nascita=date.today()-timedelta(days=2),
                               stipendio_annuale_eur=RealGZ(19000))

    print(alice)
    alice.set_nome("Alessia")
    print(alice)

    print(bob)


    pegaso: Progetto = Progetto(nome="Pegaso", budget=RealGEZ(25_000))
    prometeo: Progetto = Progetto(nome="Prometeo", budget=RealGEZ(75_000))
    phoenix: Progetto = Progetto(nome="Phoenix", budget=RealGEZ(24_000))

    alice_in_pegaso: partecipa._link =partecipa.add(pegaso, alice, date.today())
    print(f"Ho creato il link ({alice_in_pegaso.progetto()}, "
          f"{alice_in_pegaso.impiegato()},"
          f"{alice_in_pegaso.data_inizio()}")

    bob_in_prometeo: partecipa._link = partecipa.add(prometeo, bob, date.today())

    print(prometeo.is_coinvolto(alice))
    print(prometeo.is_coinvolto(bob))


    alice._add_link_partecipa(partecipa._link(prometeo, alice, date.today()))

    print("alice è coinvolta in phoenix?")
    print(phoenix.is_coinvolto(alice))

if __name__ == "__main__":
    test()