'''
Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)

    HH = hours, padded to 2 digits, range: 00 - 99
    MM = minutes, padded to 2 digits, range: 00 - 59
    SS = seconds, padded to 2 digits, range: 00 - 59

The maximum time never exceeds 359999 (99:59:59)

You can find some examples in the test fixtures.

'''


def make_readable(seconds):

    HH = 0
    MM = 0
    SS = 0


    if seconds > 359999:
       print("ATTENZIONE ! Il programma non può continuare dato che il limite non deve superare le:\n-> 99 ore 59 minuti e 59 secondi")
    
    elif seconds < 0:
        print("ATTENZIONE ! Il programma non può continuare dato che non può operare con NUMERI NEGATIVI:\n-> SOLO NUMERI POSITIVI > 0")    
    else:

        if seconds > 3600:

         HH = int(seconds//3600)
         MM = int(seconds%3600) // 60
         SS = int(seconds%60)
        
        elif seconds < 3600:
         
         MM = int(seconds%3600) // 60
         SS = int(seconds%60)
        
        elif seconds < 60:
         
         SS = int(seconds%60)
        

    return f"{HH:02} : {MM:02} : {SS:02}"





print(make_readable(34300))
print(make_readable(50))
print(make_readable(360000))
print(make_readable(-10))
