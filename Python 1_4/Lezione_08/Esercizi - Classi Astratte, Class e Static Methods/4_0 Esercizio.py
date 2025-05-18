'''
Exercise 4: University Management System

Create a system to manage a university with departments, courses, professors, and students.  

1. Create an abstract class Person:
Attributes:

    name
    age

Methods:

    get_role, an abstract method to be implemented by subclasses.
    __str__, method to return a string representation of the person.

2. Create subclasses Student and Professor that inherit from Person and implement the abstract method.

Class Student:
Additional attributes:

        student_id,
        courses (list of Course instances).

Additional method:

        enroll, to enroll the student in a course.

Class Professor:
Additional attributes:

        professor_id,
        department (a Department instance), 
        courses (list of Course instances)

Additional method:

        assign_to_course, to assign the professor to a course.


3. Create a class Course:
Attributes:

    course_name
    course_code
    students (list of Student instances)
    professor (Professor instance)

Methods:

    add_student, to add a student to the course.
    set_professor, to set the professor for the course.
    __str__, method to return a string representation of the course.

4. Create a class Department:

Attributes:

    department_name
    courses (list of Course instances)
    professors (list of Professor instances)

Methods:

    add_course, to add a course to the department.
    add_professor, to add a professor to the department.
    __str__, method to return a string representation of the department.

5. Create a class University:

Attributes:

    name
    departments (list of Department instances)
    students (list of Student instances)

Methods:

    add_department, to add a department to the university.
    add_student, to add a student to the university.
    __str__, method to return a string representation of the university.

Finally, write a simple driver program. After creating a University, you should begin by creating instances of the main components that make up a university:

    Departments (e.g., Computer Science, Literature)

    Courses (e.g., Data Structures, Medieval Literature)

    Professors (e.g., faculty members who will teach the courses)

    Students (e.g., individuals who will enroll in the courses)

Once these instances are created, follow these steps:

    Add all entities to the university: Ensure the university class can register departments and students. 

    Enroll students in courses: Simulate student registration by assigning students to one or more courses. 

    Assign professors to courses: Each course should have a professor responsible for teaching it. 

    Display the state of the university: at each significant step, print out a summary of the university’s current state. This might include:
        A list of courses with assigned professors.
        Which students are enrolled in which courses.
        A breakdown of departments and the courses they offer.

'''

from abc import ABC, abstractmethod

class Person(ABC):
    def __init__(self, name: str, age: int) -> None:
        self.name = name
        self.age = age

    @abstractmethod 
    def get_role(self):
        pass

    def __str__(self):
        return f"NAME:{self.name} | AGE:{self.age} | RUOLO:{self.get_role()}"
    

class Student(Person):
    def __init__(self, name: str, age: int, student_id: str) -> None:
        super().__init__(name, age)
        self.student_id = student_id
        self.courses = []

    def enroll(self, course) -> str:
        if course not in self.courses:
            self.courses.append(course)
            course.add_student(self)
            return "SUCCESSO! studente registrato con successo !"
        else:
            return "ATTENZIONE ! Lo studente è già iscritto a questo corso"
    
    def get_role(self):
        return "STUDENTE"
    
    def __str__(self):
        return super().__str__() + f", ID: {self.student_id}"


class Professor(Person):
    def __init__(self, name: str, age: int, professor_id: str, department) -> None:
        super().__init__(name, age)
        self.professor_id = professor_id
        self.department = department
        self.courses = []

    def assign_to_course(self, course) -> str:
        if course not in self.courses:
            self.courses.append(course)
            course.set_professor(self)
            return "SUCCESSO! professore registrato con successo !"
        else:
            return "ATTENZIONE ! Il professore è già assegnato a questo corso"
    
    def get_role(self):
        return "PROFESSORE"
    
    def __str__(self):
        return super().__str__() + f", ID: {self.professor_id}"


class Course:
    def __init__(self, course_name: str, course_code: str) -> None:
        self.course_name = course_name
        self.course_code = course_code
        self.students = []
        self.professor = None

    def add_student(self, student) -> str:
        if student not in self.students:
            self.students.append(student)
            return "SUCCESSO ! Lo studente è stato inserito nel corso"
        else:
            return "ATTENZIONE ! Lo studente è già presente nel corso"

    def set_professor(self, professor) -> str:
        if self.professor is None:
            self.professor = professor
            return "SUCCESSO ! il professore è stato inserito nel corso"
        else:
            return "ATTENZIONE ! Questo corso ha già un professore assegnato"
    
    def __str__(self): 
        prof_name = self.professor.name if self.professor else "Nessun professore"
        student_names = ', '.join([s.name for s in self.students]) or "Nessuno studente"
        return f"COURSE ID: {self.course_code} | COURSE NAME: {self.course_name} | PROFESSOR NAME: {prof_name} | STUDENTS: {student_names}"


class Department:
    def __init__(self, department_name: str) -> None:
        self.department_name = department_name
        self.courses = []
        self.professors = []

    def add_course(self, course) -> str:
        if course not in self.courses:
            self.courses.append(course)
            return "SUCCESSO ! CORSO aggiunto con successo al DIPARTIMENTO"
        else:
            return "ATTENZIONE ! Errore: RISULTA già un'altro CORSO nel DIPARTIMENTO"

    def add_professor(self, professor) -> str:
        if professor not in self.professors:
            self.professors.append(professor)
            return "SUCCESSO ! PROFESSORE aggiunto con successo al DIPARTIMENTO"
        else:
            return "ATTENZIONE ! Errore: RISULTA già un'altro PROFESSORE nel DIPARTIMENTO"

    def __str__(self) -> str:

        courses_str = ""
        if not self.courses:
            courses_str = "No courses"
        else:
            for course in self.courses:
                courses_str += "    " + str(course) + "\n"
        return f"DEPARTMENT: {self.department_name}| COURSE: {courses_str}"


class University:
    def __init__(self, name: str) -> None:
        self.name = name
        self.departments = []
        self.students = []

    def add_department(self, department) -> str:
        if department not in self.departments:
            self.departments.append(department)
            return "SUCCESSO ! DIPARTIMENTO aggiunto con successo all'UNIVERSITÀ"
        else:
            return "ATTENZIONE ! Errore: RISULTA già un'altro DIPARTIMENTO nell'UNIVERSITÀ"

    def add_student(self, student) -> str:
        if student not in self.students:
            self.students.append(student)
            return "SUCCESSO ! STUDENTE aggiunto con successo all'UNIVERSITÀ"
        else:
            return "ATTENZIONE ! Errore: RISULTA già un'altro STUDENTE nell'UNIVERSITÀ"

    def __str__(self):
        
        departments_str = ""
        for dept in self.departments:
            departments_str += str(dept) + "\n\n"

        students_str = ""
        for stud in self.students:
            students_str += str(stud) + "\n"

        return f"UNIVERSITY: {self.name} | DEPARTMENTS: {departments_str} | STUDENTS: {students_str}"
    



if __name__ == "__main__":
    # 1. Creazione dell'università
    uni = University("Università degli Studi di Esempio")

    # 2. Creazione dei dipartimenti
    cs_department = Department("Informatica")
    lit_department = Department("Lettere")

    # 3. Aggiunta dei dipartimenti all'università
    print(uni.add_department(cs_department))
    print(uni.add_department(lit_department))

    # 4. Creazione dei corsi
    ds_course = Course("Strutture Dati", "CS101")
    lit_course = Course("Letteratura Medievale", "LIT201")

    # 5. Aggiunta dei corsi ai dipartimenti
    print(cs_department.add_course(ds_course))
    print(lit_department.add_course(lit_course))

    # 6. Creazione dei professori
    prof_mario = Professor("Mario Rossi", 50, "P001", cs_department)
    prof_gina = Professor("Gina Verdi", 45, "P002", lit_department)

    # 7. Aggiunta dei professori ai dipartimenti
    print(cs_department.add_professor(prof_mario))
    print(lit_department.add_professor(prof_gina))

    # 8. Assegnazione professori ai corsi (corretto: solo un argomento)
    print(ds_course.set_professor(prof_mario))
    print(lit_course.set_professor(prof_gina))

    # 9. Creazione degli studenti
    student_anna = Student("Anna Bianchi", 20, "S001")
    student_luca = Student("Luca Neri", 22, "S002")

    # 10. Aggiunta studenti all'università
    print(uni.add_student(student_anna))
    print(uni.add_student(student_luca))

    # 11. Enroll studenti nei corsi (corretto: solo uno)
    print(student_anna.enroll(ds_course))
    print(student_luca.enroll(lit_course))

    # 12. Stampa dello stato finale dell’università
    print("\n" + "="*60)
    print("STATO ATTUALE DELL'UNIVERSITÀ:")
    print("="*60)
    print(uni)
