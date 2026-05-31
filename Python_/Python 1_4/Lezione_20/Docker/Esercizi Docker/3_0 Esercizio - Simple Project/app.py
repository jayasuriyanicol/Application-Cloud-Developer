import numpy as np

def main():
    data = np.random.randint(0, 100, size=10)
    print("Array casuale:", data)
    print("Media:", np.mean(data))
    print("Deviazione standard:", np.std(data))
    print("Somma:", np.sum(data))

if __name__ == '__main__':
    main()

