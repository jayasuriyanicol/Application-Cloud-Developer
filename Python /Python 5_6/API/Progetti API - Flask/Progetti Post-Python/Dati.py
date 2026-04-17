'''Dato l'esercizio dell'applicazione Flask di Voli Aerei, ci andiamo a ricreare tramite un eseecizio di Progettazione 1. 
   Una simulazione di un DB in PY'''


dati = {
    'Nazione': {
        1: {
            'id': 1,
            'nome': 'Italia'
        }
    },

    'Citta': {
        1: {
            'id': 1,
            'n_abitanti': 60000,
            'nome': 'Pomezia',
            'nazione': 1
        },
        2: {
            'id': 2,
            'n_abitanti': 2500000,
            'nome': 'Roma',
            'nazione': 1
        }
    },

    'Aeroporto': {
        1: {
            'id': 1,
            'codice': 'FCO',
            'nome': 'Aeroporto di Fiumicino',
            'citta': 2
        },
        2: {
            'id': 2,
            'codice': 'CIA',
            'nome': 'Aeroporto di Ciampino',
            'citta': 2
        },
        3: {
            'id': 3,
            'codice': 'MXP',
            'nome': 'Aeroporto di Malpensa',
            'citta': 2
        },
        4: {
            'id': 4,
            'codice': 'BLQ',
            'nome': 'Aeroporto di Bologna',
            'citta': 1
        }
    },

    'CompagniaAerea': {
        1: {
            'id': 1,
            'nome': 'Alitalia',
            'fondazione': 1946,
            'citta': 2
        },
        2: {
            'id': 2,
            'nome': 'Ryanair',
            'fondazione': 1984,
            'citta': 2
        },
        3: {
            'id': 3,
            'nome': 'EasyJet',
            'fondazione': 1995,
            'citta': 2
        },
        4: {
            'id': 4,
            'nome': 'Wizz Air',
            'fondazione': 2003,
            'citta': 1
        }
    },

    'Volo': {
        1: {
            'id': 1,
            'codice': 'AZ123',
            'durata_in_minuti': 90,
            'partenza': 1,
            'arrivo': 2,
            'compagnia': 1
        },
        2: {
            'id': 2,
            'codice': 'RY456',
            'durata_in_minuti': 120,
            'partenza': 2,
            'arrivo': 4,
            'compagnia': 2
        },
        3: {
            'id': 3,
            'codice': 'EZ789',
            'durata_in_minuti': 75,
            'partenza': 2, 
            'arrivo': 3,
            'compagnia': 3
        },
        4: {
            'id': 4,
            'codice': 'WZ321',
            'durata_in_minuti': 60,
            'partenza': 4,
            'arrivo': 1,
            'compagnia': 4
        }
    }
}


