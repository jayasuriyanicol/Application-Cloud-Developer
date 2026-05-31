'''
1️⃣ Gestione Studenti e Corsi

Scrivi una funzione:

register_student(courses: dict[str, list[str]], corso: str, studente: str) -> dict[str, list[str]]

che aggiunga uno studente a un corso.

Se il corso non esiste, crealo.

Se lo studente è già iscritto, non duplicarlo.

Esempio:

register_student(
    {"Python": ["Anna"], "Java": ["Luca"]},
    "Python", "Marta"
)
➜ {"Python": ["Anna", "Marta"], "Java": ["Luca"]}

'''



def register_student(courses:dict[str, list[str]], corso: str, studente: str) -> dict[str, list[str]]:



    if corso not in courses:

        courses[corso] = [studente]

    if corso in courses:

        if studente not in courses[corso]: 

            courses[corso].append(studente)      
        else:
            print(f"ERRORE: lo studente: {studente} esiste nel sistema")
    
    return courses



    '''Maniera alternativa

    valoreTrovato:bool = False

    for k,v in courses.items():

        if corso == k:

            valoreTrovato == True

            if studente not in v:

                v.append(studente)
            else:
                print (f"ERRORE: lo studente: {studente} esiste nel sistema")

            break

        if valoreTrovato == False:


            courses[corso]  =[studente] 


    return courses
    '''


print(register_student({"Python": ["Anna"], "Java": ["Luca"]}, "Python", "Marta"))

print(register_student({"Python": ["Anna"], "Java": ["Luca"]}, "Web", "Delicious"))
             