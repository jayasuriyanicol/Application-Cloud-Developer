'''

Test automatici con requests

Scrivi un file di test che:

    Imposta gli header per lavorare con JSON, ad esempio:

    headers = {
      "Content-type": "application/json",
      "Accept": "application/json"
    }

    Esegue almeno le seguenti operazioni, usando requests:
        GET / e stampa/verifica il contenuto della risposta;
        GET /bookings e controlla che la lista non sia vuota;
        POST /bookings per aggiungere una nuova prenotazione;
        GET /bookings/<booking_id> per verificare che sia stata creata;
        PATCH /bookings/<booking_id>/status per aggiornare lo stato;
        PUT /bookings/<booking_id> per sostituire le info della prenotazione;
        DELETE /bookings/<booking_id> per eliminarla;
        GET /bookings/<booking_id> per verificare che non esista più (status 404).
    Come minimo, i test devono stampare le risposte.

Esempio minimale di struttura (non il codice completo):

import requests
import json

BASE_URL = "http://localhost:5000"

if __name__ == "__main__":
    headers = {
        "Content-type": "application/json",
        "Accept": "application/json"
    }

    response = requests.get(f"{BASE_URL}/", headers=headers)
    print("GET /", response.status_code, response.json())

    # ... altri test per POST, PUT, PATCH, DELETE ...

'''

import requests
import json

BASE_URL = "http://localhost:5000"

HEADERS = {
    "Content-type": "application/json",
    "Accept": "application/json"
}

def delimitatore(title):
    print(f"\n{'='*10} {title} {'='*10}")


def run_tests():
    test_id = "BK-TEST-999"

    delimitatore("1. GET /")
    try:
        response = requests.get(f"{BASE_URL}/", headers=HEADERS)
        print(f"Status: {response.status_code}")
        print("Body:", json.dumps(response.json(), indent=2))

    except requests.exceptions.ConnectionError:

        print("Errore di connessione.")
        return

    delimitatore("2. GET /bookings")

    response = requests.get(f"{BASE_URL}/bookings", headers=HEADERS)
    print(f"Status: {response.status_code}")
    print(f"Items: {len(response.json())}")


    delimitatore(f"3. POST /bookings ({test_id})")
    new_booking = {
        "type": "visit",
        "booking_id": test_id,
        "patient_name": "Giuseppe Verdi",
        "doctor": "Dr. Test",
        "department": "Cardiologia",
        "date": "2026-12-01",
        "time": "09:00",
        "status": "scheduled",
        "visit_reason": "Test API",
        "first_time": True
    }

    response = requests.post(f"{BASE_URL}/bookings", headers=HEADERS, json=new_booking)
    print(f"Status: {response.status_code}")
    print("Body:", json.dumps(response.json(), indent=2))


    delimitatore(f"4. GET /bookings/{test_id}")
    response = requests.get(f"{BASE_URL}/bookings/{test_id}", headers=HEADERS)
    print(f"Status: {response.status_code}")
    print("Body:", json.dumps(response.json(), indent=2))


    delimitatore(f"5. PATCH /bookings/{test_id}/status")
    patch_data = {"status": "checked_in"}
    response = requests.patch(f"{BASE_URL}/bookings/{test_id}/status", headers=HEADERS, json=patch_data)
    print(f"Status: {response.status_code}")
    print("Body:", json.dumps(response.json(), indent=2))


    delimitatore(f"6. PUT /bookings/{test_id}")
    put_data = {
        "type": "visit",
        "booking_id": test_id,
        "patient_name": "Giuseppe Verdi",
        "doctor": "Dr. Sostituto",
        "department": "Cardiologia",
        "date": "2026-12-01",
        "time": "10:00",
        "status": "checked_in",
        "visit_reason": "Test API Updated",
        "first_time": True
    }

    response = requests.put(f"{BASE_URL}/bookings/{test_id}", headers=HEADERS, json=put_data)
    print(f"Status: {response.status_code}")
    print("Body:", json.dumps(response.json(), indent=2))


    delimitatore(f"7. DELETE /bookings/{test_id}")
    response = requests.delete(f"{BASE_URL}/bookings/{test_id}", headers=HEADERS)
    print(f"Status: {response.status_code}")
    print("Body:", json.dumps(response.json(), indent=2))

    delimitatore(f"8. GET /bookings/{test_id} (Check 404)")
    response = requests.get(f"{BASE_URL}/bookings/{test_id}", headers=HEADERS)
    print(f"Status: {response.status_code}")

if __name__ == "__main__":
    run_tests()