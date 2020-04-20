# Eldöntés tétele
Az algoritmus bemenet egy n elemű lista. A feladat az, hogy döntsük el, hogy van-e olyan elem a listában, amelyre igaz egy feltétel.

### Elméleti megvalósítás

*	Változó deklarációja a találat tényének (hamis kezdőértékkel)
*	Ciklusban iterálni addig, amíg van elem, és nincs találat
*	Feltétel teljesülésének esetén a találat tényét igazra állítani, és kilépni a ciklusból
*	Találat tényének visszaadása

### Gyakorlati megvalósítás
```java
public boolean containsGreaterThan(List<Integer> numbers, int min) {
        for (Integer i : numbers) {
            if (i > min) {
                return true;
            }
        }
        return false;
    }
```

```java
  public boolean containsLowerThan(List<Integer> numbers, int max) {
        boolean contains = false;
        int i = 0;

        while (i < numbers.size() && !contains) {
            if (numbers.get(i) < max) {
                contains = true;
            }
            i++;
        }
        return contains;
    }

```

## Ellenőrző kérdések

* Mi a bemenete és a kimenete az eldöntés algoritmusának?
* Mi legyen a kezdőértéke a majdani visszatérési értéket tároló változónak?
* Meddig iteráljunk a ciklusban?

## Nagy összegű bankszámlák

Hozz létre egy `BankAccount` osztályt, a szükséges attribútumokkal:

* `nameOfOwner`, a számla tulajdonosának neve
* `accountNumber`, a számlaszám
* `balance`, egyenleg

Legyen az osztálynak `withdraw` és `deposit` metódusa paraméterként kapott összeg levételére ill. betételére a számlára.

Feladat egy metódus megírása, ami eldönti van-e olyan számla, amelynek az aktuális egyenlege meghaladja a paraméterként kapott alsó határt.

[rating feedback=java-algorithmsdecision-bankszamlak]

## Nagy összegű terhelés
Hozz létre egy `Transaction` osztályt, a szükséges attribútumokkal:

* `accountNumber`, számlaszám
* `transactionOperation` `TransactionOperation` enum, a tranzakció típusa
* `amount`, a tranzakció összege
* `dateOfTransaction`, a tranzakció dátuma
* `status`, a tranzakció státusza (CREATED, SUCCEEDED, PENDING)

Feladat egy metódus megírása, ami eldönti van-e olyan terhelés (debit) tranzakció egy adott dátum intervallumon belül, amely egy adott összeghatárnál nagyobb.

### Tipp

A `dateOfTransaction` attribútum típusa legyen `LocalDateTime` típusú,
mely tárolja a dátumot és az időt. Ennek van egy `isAfter()` és `isBefore()`
metódusa, mellyel eldönthető, hogy a paraméterként átadott másik dátum
előtte vagy utána van-e.

Pl.:

```java
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
LocalDateTime today = LocalDateTime.parse("2017-03-08 10:00", formatter);
LocalDateTime tomorrow = LocalDateTime.parse("2017-03-09 10:00", formatter);

assertThat(today.isBefore(tomorrow), is(true));
```

[rating feedback=java-algorithmsdecision-terheles]

## Tranzakciók átvezetése a számlákra
Készíts egy metódust, amelyik megkap egy tranzakció listát és egy számlák listát paraméterként és végrehajtja az összes tranzakciót,
azaz minden tranzakcióhoz megkeresi az érintett számlát és ha megtalálja, akkor a `creditOrDebit` értéke alapján a számla megfelelő metódusának (`withdraw` vagy `deposit`) meghívásával
módosítja a számla egyenlegét. Sikeres végrehajtás esetén a tranzakció státuszát állítsd SUCCEEDED-re, különben tedd PENDING-re.
Feltételezzük természetesen, hogy a számlaszámok egyediek a számlák listában.

### Megjegyzés
Ahol nincs külön megadva osztálynév, ott a tesztesetek alapján meghatározható osztályokba dolgozz. Célszerű ezeket az elején létrehozni, és utána megírni a metódusokat.

[rating feedback=java-algorithmsdecision-tranzakciok]
