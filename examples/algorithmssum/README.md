# Összegzés tétele

### Nevezetes algoritmusok
Vannak olyan problémák amik gyakran előfordulnak a programozás során, így az ezen algoritmusoknak külön névvel látták el, programozási tételeknek vagy nevezetes algoritmusoknak hívják. Ezek általában valamilyen kollekción dolgoznak. Nézzük ezeket sorban:

*	Összegzés tétele
*	Számlálás tétele
*	Szélsőérték keresés
*	Eldöntés tétele

### Összegzés tétele

   Az algoritmus bemenete egy n elemű lista. Egyszerűbb esetben számokat tartalmazó lista, de akár objektumokat tartalmazó lista is lehet valamilyen szám értékkel. Ezeket a számokat illetve számértékeket akarjuk összeadni.

### Elméleti megvalósítás
*	Változó deklarálása
*	Ciklusban iterálás
*	Ha szükséges feltétel az elemre
*	Ha szükséges az elem konvertálása számmá
*	Összeghez hozzáadni a számot
*	Összeget visszaadni

### Gyakorlati megvalósítás
```java
public int sum(List<Integer> numbers) {
    int sum = 0;
    for (Integer n: numbers) {
        sum += n;
    }
    return sum;
}
```

```java
public int ageSumCalculator(List<Trainer> trainers){
    int sum = 0;
    for(Trainer trainer: trainers){
        sum += trainer.getAge();
    }
    return sum;
}   
```

## Ellenőrző kérdések
* Mi a bemenete és a kimenete az összegzés algoritmusának?
* Mi legyen a kezdőértéke a majdani visszatérési értéket tároló változónak?

## Értékesítők számai
Hozz létre egy `Salesperson` osztályt, a szükséges attribútumokkal:

* `name`, az értékesítő kolléga neve
* `amount`, az üzletkötéseiből származó árbevétel

Feladat egy metódus megírása a megfelelő osztályban, ami összegzi a cég öszes értékesítőjének árbevételét.

[rating feedback=java-algorithmssum-ertekesitok]



## Összes jóváírás
Hozz létre egy `Transaction` osztályt, a szükséges attribútumokkal:

* `accountNumber`, számlaszám
* `transactionOperation` (TransactionOperation enum, CREDIT vagy DEBIT)
* `amount`, a tranzakció összege

Hozz létre egy `TransactionSumCalculator` osztályt, amelyben van
egy `int sumAmountOfCreditEntries(List<Transaction> transactions)` metódus,
amely összegzi a credit tranzakciók összegét.

[rating feedback=java-algorithmssum-jovairas]
