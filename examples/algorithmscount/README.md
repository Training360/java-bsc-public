# Számlálás tétele
Az algoritmus bemenete egy n elemű lista. A feladat az, hogy számoljuk meg azokat az elemeket amelyekre igaz egy feltétel. Például számoljuk meg a 15-nél nagyobb számokat egy listában.

### Elméleti megvalósítás
*	Változó deklarálása számlálónak
*	Ciklusban iterálás
*	Feltétel teljesülése esetén számláló növelése
*	Számláló visszaadása

### Gyakorlati megvalósítás
```java
public int countLetters(String s, char c) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == c) {
            count++;
        }
    }
    return count;
}
```

```java
public int countElderly(List<Trainer> trainers, int minAge ) {
      int count = 0;
      for (Trainer trainer: trainers) {
          if (trainer.getAge() >= minAge) {
              count++;
          }
      }
      return count;
  }
```


## Ellenőrző kérdések
* Mi a bemenete és a kimenete a számlálás algoritmusának?
* Mi legyen a kezdőértéke a majdani visszatérési értéket tároló változónak?

## Nagy összegű bankszámlák
Hozz létre egy `BankAccount` osztályt, a szükséges attribútumokkal:

* `nameOfOwner`, a számla tulajdonosának neve
* `accountNumber`, a számlaszám
* `balance`, egyenleg

Feladat egy metódus megírása a `BankAccountConditionCounter` osztályban, ami megszámlálja, hány olyan számla van,
amelynek az aktuális egyenlege meghaladja a paraméterként kapott alsó határt.

[rating feedback=java-algorithmscount-bankszamlak]

## Kis összegű tranzakciók
Hozz létre egy `Transaction` osztályt, a szükséges attribútumokkal:

* `accountNumber`, számlaszám
* `transactionType` (credit vagy debit, egy külön `TransactionType` enum)
* `amount`, a tranzakció összege

Feladat egy metódus megírása a `TransactionCounter` osztályban, ami megszámlálja hány olyan tranzakció van,
amely a paraméterként kapott összeghatárnál kisebb értékű.

[rating feedback=java-algorithmscount-tranzakciok]
