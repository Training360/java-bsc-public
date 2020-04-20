# Szélsőérték keresés tétele

Az algoritmus bemenete egy n elemű lista. A feladat, hogy visszaadjuk azt az elemet, ami a legnagyobb vagy a legkisebb, az elemeknek ezért összehasonlíthatónak kell lenniük. Figyelnünk kell az egyenlőségre. Ilyen esetben általában az első vagy az utolsó elemet szokás visszaadni, de lehet, hogy az összeset.

### Elméleti megvalósítás
*	Változó deklarálása szélsőértéknek
*	Ciklusban iterálni
*	Amennyiben a ciklusváltozó nagyobb, kisebb, a szélsőértéket le kell cserélni a ciklusváltozó értékére
*	Szélsőérték visszaadása


### Gyakorlati megvalósítás
```java
public int max(List<Integer> numbers) {
    int max = Integer.MIN_VALUE;
    for (Integer n: numbers) {
        if (n > max) {
            max = n;
        }
    }
    return max;
}
```

```java
public Trainer trainerWithMaxAge(List<Trainer> trainers) {
    Trainer trainerWithMaxAge = null;
    for (Trainer trainer: trainers) {
        if (trainerWithMaxAge == null || trainer.getAge() > trainerWithMaxAge.getAge()) {
            trainerWithMaxAge = trainer;
        }
    }
    return trainerWithMaxAge;
}
```

## Ellenőrző kérdések
* Mi a bemenete és a kimenete a szélsőérték kiválasztás algoritmusának?
* Mi legyen a kezdőértéke a majdani visszatérési értéket tároló változónak?

## Legjobb értékesítő
Hozz létre egy `Salesperson` osztályt, a szükséges attribútumokkal:

* `name`, az értékesítő kolléga neve
* `amount`, az üzletkötéseiből származó árbevétel
* `target`, a cél árbevétel, amit az adott étékesítő számára előírt az értékesítési igazgató

Feladat a következő metódusok megírása a megfelelő osztályokban:

* kiválasztja a legnagyobb árbevételt elért értékesítőt
* kiválasztja azt az értékesítőt, aki a célt a legnagyobb összeggel meghaladta
* kiválasztja azt az értékesítőt, aki a legnagyobb összeggel alulmúlta a célt

[rating feedback=java-algorithmsmax-ertekesito]

## Legidősebb trainer
Hozz létre egy `Trainer` osztályt a következő attribútumokkal:

* `name`, a trainer neve
* `age` , az életkora

A feladat:

* Egy `MaxAgeCalculator` osztályban hozz létre egy `Trainer trainerWithMaxAge(List<Trainer> trainers)`
metódust, amely kikeresi a legidősebb trainert.

[rating feedback=java-algorithmsmax-trainer]


## Legnagyobb szám

Hozz létre egy `IntegerMaxCalculator` osztályt, valamint benne egy metódust,
ami a kapott egész számok listájából kiválasztja a legnagyobbat.

[rating feedback=java-algorithmsmax-maxszam]
