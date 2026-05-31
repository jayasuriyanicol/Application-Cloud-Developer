
# 📝 File Principali Creati per l'utilizzo in fase di Sviluppo in Python

Questo progetto illustra l'uso di **tipi specializzati, validazioni, pattern di design e utility** per la progettazione di software orientato agli oggetti in Python. Le classi definite permettono di rafforzare i controlli a runtime e migliorare la leggibilità e affidabilità del codice.

## 📂 Organizzazione File

---

### `main.py`

> Script dimostrativo che utilizza vari moduli del progetto per testare comportamenti, validazioni e confronto tra oggetti.

* **Tipi numerici**: `IntGEZ` (interi ≥ 0), `Voto` (valori ≥ 18).
* **Validazioni**: dimostrazione del controllo dei tipi con `beartype`.
* **Date e orari**: utilizzo di `TimeRange` per rappresentare intervalli temporali.
* **Oggetti strutturati**: `Indirizzo` con supporto a confronto e hashing.
* **Tipi civico specializzati**: `CivicoLettera`, esempio di estensione strutturata per indirizzi con numerazione e lettera.

---

### `FormatRequired.py`

> Contiene classi che validano stringhe secondo un formato preciso usando REGEX.

* **`FormatRequired`**: Classe base per stringhe vincolate a un formato (es. codice fiscale).
* **`CodiceFiscaleItaliano`**: Estensione semantica specifica per CF italiani, applica la stessa logica di validazione con REGEX.

---

## 🔧 Altri Moduli Rilevanti (da `util/types/`)

Questi moduli estendono i tipi base con validazioni e vincoli logici:

### ✅ Tipi numerici personalizzati

* **`IntGEZ`**: Interi garantiti ≥ 0. Rifiuta numeri negativi, float, o anche se ci sono condizioni con relativo `ValueError`.

* **`FieldsAssumption`**: Utilizzato per compilare i campi in maniera corretta seguendo le **REGEX**. Solleva `ValueError` per enumerazioni che non seguono la sintassi richiesta dallo standard.

* **`init`**: Per l'inserimento della libreria come inizializzazione per il programma **`main.py`**.

* **`TimeRangeExecution`**: Classe per rappresentare intervalli di tempo con metodi per:

  * Calcolare durata
  * Verificare intersezioni
  * Eseguire traslazioni temporali

### 🏠 Esempio di Strutture dati complesse

* **`Indirizzo`**: Oggetto immutabile con `via` e `civico`, supporta uguaglianza e hashing. Usato anche in collezioni (es. `set`).

* **`CivicoLettera`**: Oggetto strutturato per rappresentare un numero civico con lettera opzionale (es. `12B`). Controlla che il numero sia ≥ 0 e che la lettera sia un singolo carattere alfabetico. Supporta confronto e hashing.

---

## ✅ Requisiti

* Python 3.10+
* `beartype` per la validazione dei tipi a runtime (`pip install beartype`)

---

## 📌 Esempio di utilizzo

```python
from FormatRequired import CodiceFiscaleItaliano
from util.types import CivicoLettera

cf = CodiceFiscaleItaliano("RSSMRA85M01H501Z")
print(cf)  # Output: RSSMRA85M01H501Z

civico = CivicoLettera(12, "B")
print(civico)  # Output: CivicoLettera(numero=12, lettera='B')
```
