'''
🧮 Classe: StudentRegister

Implementa i seguenti metodi:

__init__(self)

Inizializza self.students come dizionario vuoto.

add_student(student_id: str, nome: str) -> None

Aggiunge uno studente se non già presente.
Se esiste, stampa "Studente già registrato".

add_course(student_id: str, corso: str, voto: int) -> None

Aggiunge un corso e il voto allo studente indicato.
Se lo studente non esiste, stampa "Studente non trovato".
Se il corso è già presente, aggiorna il voto.

remove_course(student_id: str, corso: str) -> None

Rimuove un corso per quello studente.
Se non esiste, stampa "Corso non trovato".

get_average(student_id: str) -> float | str

Restituisce la media dei voti dello studente, oppure "Studente non trovato".

remove_student(student_id: str) -> None

Elimina completamente lo studente dal registro.

list_students() -> dict[str, dict]

Restituisce l’intero dizionario self.students.


'''


class StudentRegister:

    def __init__(self) -> None:

        self.students:dict[str,dict[str,dict[str,int]]] = {}

    def add_student(self,student_id:str, nome:str) -> None:

        if student_id not in self.students:

            self.students[student_id] = {
                "nome": nome,
                "corsi": {}}
        else:
            print("Studente già registrato")
    
    def add_course(self,student_id:str, corso:str, voto:int) -> None:

        if student_id in self.students:

            self.students[student_id]["corsi"][corso]= voto
        else:

            print("Studente non trovato") 

    def  remove_course(self,student_id:str,corso:str) -> None:

         if student_id in self.students:
             
             if corso in self.students[student_id]["corsi"]:  
                 
                 self.students[student_id]["corsi"].pop(corso)   
         else:
            print("Corso non trovato")

    def get_average(self,student_id:str) -> float | str:
         
        corsi = self.students[student_id]["corsi"]
        if not corsi:

            return 0.0
        
        else:
            somma= sum(corsi.values())

            return somma / len(corsi)
    
    def remove_student(self,student_id:str)-> None:

        if student_id in self.students:

            self.students.pop(student_id)
    

    def list_students(self) -> dict[str,dict]:

        return self.students
    




registro = StudentRegister()
registro.add_student("S001", "Anna Rossi")
registro.add_student("S002", "Luca Verdi")

registro.add_course("S001", "Matematica", 28)
registro.add_course("S001", "Informatica", 30)
registro.add_course("S002", "Storia", 25)

print(registro.get_average("S001")) 
registro.remove_course("S001", "Matematica")
print(registro.list_students())

        
