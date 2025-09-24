'''

Hint: per il disegno utilizzare print("*", end=" "), dato che l'argomento 
end = " " permette di controllare come termina ogni chiamata a print, e 
impostandolo a uno spazio si può fare in modo che tutte le stampe successive siano 
sulla stessa riga, separate da uno spazio.

Esempi di output:
Ecco un Quadrato di lato 4!

* * * *
*       *
*       *
* * * *
L'area di questo quadrato vale: 16

Ecco un Rettangolo avente base 8 ed altezza 4!
* * * * * * * *
*                 *
*                 *
* * * * * * * *
L'area di questo rettangolo vale: 32

Ecco un Triangolo avente base 4 ed altezza 4!
*      
* *    
*   *  
* * * *
L'area di questo triangolo vale: 8.0


'''

from forma import Forma
from triangolo import Triangolo
from rettangolo import Rettangolo
from quadrato import Quadrato


quadrato = Quadrato(Forma)
quadrato(4)

rettangolo = Rettangolo(Forma)
rettangolo(8,4)


triangolo = Triangolo(Forma)
triangolo(4,4)



print("\nEcco un Quadrato di lato 4 !\n ")
quadrato.render()

print("L'area di questo quadrato vale: ",quadrato.getArea())



print("\nEcco un Rettangolo avente base 8 ed altezza 4 !\n ")
rettangolo.render()

print("L'area di questo Rettangolo vale: ",rettangolo.getArea())



print("\nEcco un Triangolo avente base 4 ed altezza 4 !\n ")
triangolo.render()

print("L'area di questo Triangolo vale: ",triangolo.getArea())
