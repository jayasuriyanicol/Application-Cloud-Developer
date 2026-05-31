'''
4. Database of dates:  Write a class that manages a database of dates with the format gg.mm.aaaa implementing methods to add a new date, 
delete a given date, modify a date, and perform a query on a given date is required.  A query on a given date allows for retrieving a given new date. 
Note that a date is an object for your database; 
it must be instantiated from a string.

'''

import re


class ManagesDatabase:


    def __init__(self,date:str) -> None:
        
        #The date follow the sequence => gg => giorno, mm => mese e aa => anno
        self.date = date

    def addingNewDate(self,dateInsertion:str) -> None:


        dateValide:str = ""

        dateValide = "^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}$"

        re.match()

