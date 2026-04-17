import datetime

from util.types.integers import IntGEZ, Voto
from util.types import timerange, indirizzo

def myf(i:int)->None:
	print("myf(i): ", i)

if __name__ == '__main__':
	try:
		myf("ciao")
	except beartype.roar.BeartypeCallHintParamViolation as e:
		print(f"--> expected {type(e)}", e)

	i = 3

	j = IntGEZ(6)
	j2 = IntGEZ(j)
	k = j - 6

	print(f"i: {i} ({type(i)})\nj: {j} ({type(j)})\nj2: {j2} ({type(j2)})\nk: {k} ({type(k)})")

	print(f"Is i={i} < j={j}? {i < j}")
	print(f"Is j={j} < i={i}? {j < i}")

	print(f"Is i={i} ({type(i)}) == k={k} ({type(k)})? {i == k}")

	k2 = -k
	print(f"k2 == -k: {k2} ({type(k2)})")

	k3 = int(k2)
	print(f"k3 == {k3} ({type(k3)})")

	print(f"j // i == {j//i} ({type(j//i)})")

	try:
		print(f"IntGEZ(k4) = j / i", end="")
		k4 = IntGEZ(j/i)
		print(f" == {k4} ({type(k4)})")
	except ValueError as e:
		print(f" --> expected ValueError: {e}")

	try:
		v1 = 17
		print(f"Voto({v1}) = ", end="")
		v1 = Voto(v1)
	except ValueError as e:
		print(f" --> expected ValueError: {e}")

	v2 = Voto(18)
	print(f"v2 = {v2} ({type(v2)})")

	try:
		v3 = Voto(v2 - 1)
		print(f"v3 = {v3} ({type(v3)})")
	except ValueError as e:
		print(f" --> expected ValueError: {e}")


	tr1 = timerange.TimeRange('2025-03-01 13:50:43', '2025-03-01 13:51:44')
	print(f"tr1: {tr1}, duration = {tr1.duration()}")

	tr2 = timerange.TimeRange('2025-03-01 13:50:43', None)
	print(f"tr2: {tr2}, duration = {tr2.duration()}")

	tr3 = tr2.shift(datetime.timedelta(seconds=45))
	print(f"tr3: {tr3}, duration = {tr3.duration()}")

	print("TimeRange.intersects():")
	for tr in [ tr1, tr1.shift(datetime.timedelta(seconds=-60)), tr1.shift(datetime.timedelta(seconds=-61)), tr1.shift(datetime.timedelta(seconds=-62)) ]:
		print(f" - tr2 = {tr2} intersects {tr}? {tr2.intersects(tr)}")

	print("Test Indirizzo")
	i1 = indirizzo.Indirizzo(civico="5b", via="via di Casa mia")
	i2 = indirizzo.Indirizzo("via di Casa mia", "5b")
	i3 = indirizzo.Indirizzo("via di Casa mia", "5b")

	for i in [i1, i2, i3]:
		print(f" - {i}")

	print(f"Is i1 == i2? {i1 == i2} --> are hashes equal? {hash(i1) == hash(i2)}")
	myset = {i1, i2}
	print(f"myset = {myset}")