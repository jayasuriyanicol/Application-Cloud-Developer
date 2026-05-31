'''
3-10. Every Function: Think of things you could store in a list. 
For example, you could make a list of mountains, rivers, countries, cities, languages, or anything else you’d like. 
Write a program that creates a list containing these items and then uses each function introduced in this chapter at least once.

'''
# Lista di elementi di interesse
items = ["Montagne", "Fiumi", "Paesi", "Città", "Lingue"]

# Stampa la lista originale
print("\nLista originale:", items)

# Stampa la lista in ordine alfabetico senza modificarla
print("\nLista ordinata temporaneamente in ordine alfabetico:", sorted(items))

# Mostra che la lista è ancora nell'ordine originale
print("\nLista invariata dopo sorted():", items)

# Stampa la lista in ordine alfabetico inverso senza modificarla
print("\nLista ordinata temporaneamente in ordine inverso:", sorted(items, reverse=True))

# Mostra che la lista è ancora nell'ordine originale
print("\nLista invariata dopo sorted() inverso:", items)

# Usa reverse() per invertire l'ordine della lista
items.reverse()
print("\nLista dopo reverse():", items)

# Usa reverse() di nuovo per ripristinare l'ordine originale
items.reverse()
print("\nLista dopo secondo reverse():", items)

# Usa sort() per ordinare la lista in ordine alfabetico
items.sort()
print("\nLista dopo sort() in ordine alfabetico:", items)

# Usa sort() per ordinare la lista in ordine alfabetico inverso
items.sort(reverse=True)
print("\nLista dopo sort() in ordine inverso:", items)

# Aggiunta di un nuovo elemento alla lista
items.append("Oceani")
print("\nLista dopo append():", items)

# Inserimento di un elemento in una posizione specifica
items.insert(2, "Foreste")
print("\nLista dopo insert():", items)

# Rimozione di un elemento dalla lista con del
del items[1]
print("\nLista dopo del:", items)

# Rimozione di un elemento con pop()
removed_item = items.pop()
print(f"\nElemento rimosso con pop(): {removed_item}")
print("Lista dopo pop():", items)

# Rimozione di un elemento specifico con remove()
items.remove("Montagne")
print("\nLista dopo remove():", items)

