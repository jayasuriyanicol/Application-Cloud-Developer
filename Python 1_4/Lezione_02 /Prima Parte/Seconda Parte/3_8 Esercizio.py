'''
3-8. Seeing the World: Think of at least five places in the world you’d like to visit.
• Store the locations in a list. Make sure the list is not in alphabetical order.
• Print your list in its original order. Don’t worry about printing the list neatly; just print it as a raw Python list.
• Use sorted() to print your list in alphabetical order without modifying the actual list.
• Show that your list is still in its original order by printing it.
• Use sorted() to print your list in reverse-alphabetical order without changing the order of the original list.
• Show that your list is still in its original order by printing it again.
• Use reverse()  to change the order of your list. Print the list to show that its order has changed.
• Use reverse() to change the order of your list again. Print the list to show it’s back to its original order.
• Use sort() to change your list so it’s stored in alphabetical order. Print the list to show that its order has been changed.
• Use sort() to change your list so it’s stored in reverse-alphabetical order.
Print the list to show that its order has changed.

'''
# Lista di luoghi che vorrei visitare
places_to_visit = ["Japan", "Maldive", "America", "Finland"]

# Stampa la lista nell'ordine originale
print("\nQuesta è la lista NON IN ORDINE ALFABETICO:", places_to_visit)

# Stampa la lista in ordine alfabetico senza modificarla
print("\nQuesta è la lista MODIFICATA NON IN MODO PERMANENTE, in ORDINE ALFABETICO:", sorted(places_to_visit))

# Mostra che la lista è ancora nell'ordine originale
print("\nInfatti se notate, LA LISTA È RIMASTA INVARIATA:", places_to_visit)

# Stampa la lista in ordine alfabetico inverso senza modificarla
print("\nQuesta è la lista MODIFICATA NON IN MODO PERMANENTE, NON in ORDINE ALFABETICO:", sorted(places_to_visit, reverse=True))

# Mostra che la lista è ancora nell'ordine originale
print("\nInfatti se notate, LA LISTA È RIMASTA INVARIATA:", places_to_visit)

# Usa reverse() per cambiare l'ordine della lista
places_to_visit.reverse()
print("\nQuesta è la lista in MODALITÀ REVERSE:", places_to_visit)

# Usa reverse() di nuovo per tornare all'ordine originale
places_to_visit.reverse()
print("\nInfatti se notate ora la lista è RITORNATA NORMALE sempre in REVERSE:", places_to_visit)

# Usa sort() per ordinare la lista in ordine alfabetico
places_to_visit.sort()
print("\nQuesta è la lista MODIFICATA IN MODO PERMANENTE, in ORDINE ALFABETICO:", places_to_visit)

# Usa sort() per ordinare la lista in ordine alfabetico inverso
places_to_visit.sort(reverse=True)
print("\nQuesta è la lista MODIFICATA IN MODO PERMANENTE, in MODALITÀ REVERSE:", places_to_visit)

print("\n\n|ULTIMA GENERAZIONE|\n\n Infatti se notate LISTA È CAMBIATA IN MODO PERMANENTE:", places_to_visit, "\n\n")
