#Procediamo con l'import del nostro TEST Weather per testare il suo funzionamento tramite 'test_weather'
from my_project.weather import *

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