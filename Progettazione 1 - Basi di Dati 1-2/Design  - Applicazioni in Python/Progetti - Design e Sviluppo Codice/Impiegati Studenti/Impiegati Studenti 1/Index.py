from typing import *
from weakref import WeakValueDictionary

KeyType = TypeVar('KeyType')
ValueType = TypeVar('ValueType')

"""
	An instance of this class defines an index over a set of objects
"""

class Index(Generic[KeyType, ValueType]):
	_name:str
	_objects:WeakValueDictionary[KeyType, ValueType]

	def __init__(self, name:str):
		self._name:str = name
		self._objects:WeakValueDictionary[KeyType, ValueType] = WeakValueDictionary()

	def __str__(self)->str:
		return (f"Index {self.name()}:\n - length: {len(self._objects)}\n - keys = {[k for k in self._objects.keys()]}")

	def name(self)->str:
		return self._name

	def add(self, _id:KeyType, obj:ValueType)->None:
		if _id in self._objects:
			raise KeyError(f"Index {self.name()} error: Duplicate key {_id} for class {type(obj)}")
		self._objects[_id] = obj

	def remove(self, _id:KeyType)->None:
		if _id is not None:
			del self._objects[_id]

	def get(self, _id:KeyType)->ValueType|None:
		return self._objects.get(_id, None)

	def all(self)->Iterator[ValueType]:
		return self._objects.values()

	def __len__(self)->int:
		return len(self._objects)