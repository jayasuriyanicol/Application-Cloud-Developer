'''
1. School Grading System:

    Create a function that takes a student's name and their scores in different subjects as input.
    The function calculates the average score and prints the student's name, average, and a message indicating whether 
    the student passed the exam (average >= 60) or failed.
    Create a for loop to iterate over a list of students and scores, calling the function for each student.
'''


#Definiamo una funzione che calcola la media e mostra come messaggio se lo stato è PASSED od FAILED
def studentScore(name: str, scores: list) -> None:
    average = sum(scores) / len(scores)

    if average >= 60:
        message: str = "PASSED"
    else:
        message: str = "FAILED"

    print(f"\nThe STUDENT {name.upper()} has scored an AVERAGE of {average} % and the STATUS is {message}")

#Riportiamo dei messaggi per l'inserimento di quanti studenti e voti si vuole inserire, inserendo poi tali valori salvandoli nella lista SCORES e poi tutti sulla lista STUDENTS
num_students: int = int(input("\n\nWelcome! Please write down the number of students: "))
students: list = []

for i in range(num_students):
    name = input("\nPlease, write down the NAME of the STUDENT: ")

    num_score: int = int(input(f"\nPlease, write down the NUMBER of SCORES for {name}: "))
    scores: list = []

    for j in range(num_score):
        score = int(input(f"\nPlease, write down SCORE {j+1}: "))
        scores.append(score)

    students.append((name, scores))

#Richiamiamo la funzione attraverso un FOR dove inseriamo i valori di SCORE e NAME, dalla lista STUDENTS
for name, scores in students:
    studentScore(name, scores)


































