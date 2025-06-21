from __future__ import annotations
from datetime import date

from azienda.custom_types import *


class Impiegato:
	_nome:str
	_cognome:str
	_stipendio_annuale_eur:RealGZ
	_nascita: date # <<imm>>
	_progetti: set[partecipa._link] # da assoc. 'partecipa' [0..*], certamente non noti alla nascita


	def __init__(self, *, nome:str, cognome:str,
				 stipendio_annuale_eur:RealGZ,
				 nascita:date
				 )->None:
		self.set_nome(nome)
		self.set_cognome(cognome)
		self.set_stipendio_annuale_eur(stipendio_annuale_eur)
		self.nascita = nascita
		self._progetti = set()

	def nome(self)->str:
		return self._nome

	def cognome(self)->str:
		return self._cognome

	def stipendio_annuale_eur(self)-> RealGZ:
		return self._stipendio_annuale_eur

	def nascita(self)-> date:
		return self._nascita

	def progetti(self)-> frozenset[partecipa._link]:
		return frozenset(self._progetti)

	def _add_link_partecipa(self, l: partecipa._link) -> None:
		if l.impiegato() != self:
			raise ValueError("il link non coinvolge me!")
		if self.is_coinvolto(l.progetto()):
			raise ValueError("Lavoravo già nel progetto!")
		self._progetti.add(l)

	def _remove_link_partecipa(self, l: partecipa._link) -> None:
		if l.impiegato() != self:
			raise ValueError("il link non coinvolge me!")
		if not self.is_coinvolto(l.progetto()):
			raise ValueError("Non lavoravo nel progetto!")

	def is_coinvolto(self, progetto: Progetto) -> bool:
		for link_partecipa in self.progetti():
			if link_partecipa.progetto() == progetto:
				return True
		return False

	def set_nome(self, nome:str)->None:
		if len(nome) < 2:
			raise ValueError("Non puoi avere un nome con meno di due lettere")
		self._nome = nome

	def set_cognome(self, v:str)->None:
		self._cognome = v

	def set_stipendio_annuale_eur(self, v:RealGZ)->None:
		self._stipendio_annuale_eur = v

	# def set_nascita(self, v:...)  <<-- NO, perché <<imm>> e nota alla nascita
	def __str__(self)->str:
		return f"{self._nome} {self._cognome}"

class Progetto:
	_nome: str # noto alla nascita
	_budget: RealGEZ # noto alla nascita
	_impiegati: set[partecipa._link] # da assoc. 'partecipa' [0..*], certamente non noti alla nascita

	def __init__(self, *, nome:str, budget:RealGEZ):
		self.set_nome(nome)
		self.set_budget(budget)
		self._impiegati = set()

	def nome(self)->str:
		return self._nome

	def budget(self)->RealGEZ:
		return self._budget

	def impiegati(self)-> frozenset[partecipa._link]:

		return frozenset(self._impiegati)

	def _add_link_partecipa(self, l: partecipa._link) -> None:
		if l.progetto() != self:
			raise ValueError("il link non coinvolge me!")
		if self.is_coinvolto(l.impiegato()):
			raise ValueError("L'impiegato lavorava  già nel progetto!")
		self._impiegati.add(l)

	def _remove_link_partecipa(self, l: partecipa._link) -> None:
		if l.progetto() != self:
			raise ValueError("il link non coinvolge me!")
		if not self.is_coinvolto(l.impiegato()):
			raise ValueError("L'impiegato non lavorava nel progetto!")
		self._impiegati.remove(l)

	def is_coinvolto(self, impiegato: Impiegato) -> bool:
		for link_partecipa in self.impiegati():
			if link_partecipa.impiegato() == impiegato:
				return True
		return False

	def set_nome(self, nome:str)->None:
		self._nome = nome

	def set_budget(self, budget:RealGEZ)->None:
		self._budget = budget

	def __str__(self)->str:
		return f"Progetto '{self._nome}'"

class partecipa:

	@classmethod
	def add(cls, progetto:Progetto, impiegato:Impiegato, data_inizio:date)-> _link:
		l = cls._link(progetto, impiegato, data_inizio)
		progetto._add_link_partecipa(l)
		impiegato._add_link_partecipa(l)
		return l

	@classmethod
	def remove(cls, l: _link)-> None:
		l.impiegato()._remove_link_partecipa(l)
		l.progetto()._remove_link_partecipa(l)
		del l


	class _link:
		# ogni istanza di questa classe rappresenta un link partecipa
		# cioè una coppia (Progetto, Impiegato) con una data

		_progetto: Progetto 	# ovviamente immutabile e noto alla nascita
		_impiegato: Impiegato 	# ovviamente immutabile e noto alla nascita
		_data_inizio: date 		# immutabile, noto alla nascita

		def __init__(self, progetto:Progetto, impiegato:Impiegato, data_inizio:date)->None:
			self._progetto = progetto
			self._impiegato = impiegato
			self._data_inizio = data_inizio

		def progetto(self)->Progetto:
			return self._progetto

		def impiegato(self)->Impiegato:
			return self._impiegato

		def data_inizio(self)->date:
			return self._data_inizio

		def __hash__(self)->int:
			return hash((self.progetto(), self.impiegato()))

		def __eq__(self, other: Any)->bool:
			if type(other) != type(self) \
					or hash(self) != hash(other):
				return False
			return (self.progetto(), self.impiegato()) == \
				(other.progetto(), other.impiegato())

