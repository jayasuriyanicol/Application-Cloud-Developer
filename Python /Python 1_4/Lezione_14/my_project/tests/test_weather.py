#Procediamo con l'import del nostro TEST Weather per testare il suo funzionamento tramite 'test_weather'
from my_project.weather import check_weather

#Importiamo 'Pytest' per creare dei messaggi specifici come ae -> AssertError
import pytest 

@pytest.mark.parametrize ("temperature, expected", [

    (21.00 , "hot"),
    (13.00, "average"),
    (0.00, "cold"),
    (15.00, "cold")
] )

#Procediamo con la stesura dei relativi errori che appariranno in concomitaznza con la fase di DEBUGGING con PYTEST
def test_check_weather(temperature, expected):

    ae: str = ""
    if temperature > 20:
        ae = "temperatures greater than 20 degreee must be considered as hot"
    
    elif 10 < temperature <= 20:
        ae = "temperatures within 10 and 20 degree must be considered as average temperature"
    
    else:
        ae = "temperatures lower than 10 degree must be considered as cold"

    assert check_weather(temperature) == expected,ae


#Adesso invece andiamo a effettuare i vari test che saranno in totale 6 con l'utlima con doppia condizione ASSERT


#passed
def test_check_weather1():
    assert check_weather(21.00) == "hot", 'temperature greater than 20 degree \
           must be considered as hot'


#failed
def test_check_weather2():
    assert check_weather(5.00) == "average", 'temperature between 10 and 20 degree \
           must be considered as avarage temperature'


#passed
def test_check_weather3():
    assert check_weather(5.00) == "cold", 'temperature lower 10 degree \
           must be considered as cold temperature'
    


#passed
def test_check_weather4():
    assert check_weather(13.00) == "average", 'temperature between 10 and 20 degree \
           must be considered as avarage temperature'

#passed
def test_check_weather5():
    assert check_weather(30.00) == "hot", 'temperature greater than 20 degree must be considered as hot'  
    assert check_weather(11.00) == "cold", 'temperature lower than 10 degree must be considered as cold' 
    