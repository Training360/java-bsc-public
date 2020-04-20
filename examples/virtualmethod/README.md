# Dinamikus kötés

A dinamikus kötés a polimorfizmus egyik legfőbb jellemzője. Legyen adott egy `A` osztály és annak egy leszármazottja `B` osztály. Az `A` osztályban deklarálunk egy metódust melyet a `B` osztályban felülírunk. Az, hogy egy adott példány esetén melyik kerül meghívásra az futás időben dől el, és kizárólag az objektum dinamikus típusa határozza meg. Az ilyen metódusokat virtuális metódusoknak hívjuk.

Ha egy metódust "overrideolunk", akkor annak láthatósága nem szűkíthető, csak bővíthető.

Példa: Adott a következő két osztály, nézzük meg, mikor melyik `getFreeTime()` metódus hívódik meg.

```java
package virtualmethod.trainer;

public class Human implements HasName {

    private static final int DEFAULT_FREE_TIME =4;

    private String name;

    public Human(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getFreeTime() {
        return DEFAULT_FREE_TIME;
    }
}
```

```java
package virtualmethod.trainer;

import java.util.List;

public class Trainer extends Human {

    private List<Course> courses;

    public Trainer(String name, List<Course> courses){
        super(name);
        this.courses=courses;
    }

    @Override
    public int getFreeTime() {
        return Math.max(super.getFreeTime() - courses.size(),0);
    }
}
```

És most nézzük az ezekhez tartozó (helyes) teszteket.

```java
@Test
public void testFreeTimeByHuman() {
    Human human= new Human("John Doe");

    assertThat(human.getFreeTime(),equalTo(4));
}

@Test
public void testFreeTimeByTrainer() {
    Trainer trainer = new Trainer("John Doe", Arrays.asList(new Course("Course1")));
    assertThat(trainer.getFreeTime(), equalTo(3));

    Human human = new Trainer("John Doe", Arrays.asList(new Course("Course1")));
    assertThat(trainer.getFreeTime(), equalTo(3));

}

```
Első két esetben a válasz elég egyértelmű, viszont harmadik esetben amikor az objektum statikus típusa `Human`, dinamikus típusa pedig `Trainer`, akkor jól látható a teszteseten, hogy a `Trainer` osztályban lévő metódus hívódik meg, tehát a dinamikus típusban lévő!


## Ellenőrző kérdések

* Mit jelent a dinamikus kötés?
* Mit jelent, hogy virtuális metódus?
* Override esetén a metódus nevére, paramétereire, visszatérési típusára, láthatósági módosítószóira és a dobott kivételekre milyen szabályok vonatkoznak?

## Gyakorlat 1 - Személykocsi, teherkocsi modell

Hozz létre egy `Vehicle` osztályt. Az általános jármű osztálynak van önsúlya, és legalább egy vezető.
Ezek adják a teljes súlyát.

* Vezess be egy `vehicleWeight` privát attribútumot, a jármű súlya.
* `PERSON_AVERAGE_WEIGHT` konstans érték: egy személy átlagos súlyát tartalmazza. Az értéke legyen 75.
* Hozz létre egy konstruktort, amely megkap egy értéket az attribútum számára, és beállítja azt.
* Szükséges metódus a `getGrossLoad`, amely visszaadja a mozgó jármű súlyát. (A jármű súlyához adjuk hozzá a sofőr súlyát.)

Hozz létre egy `Car` osztályt, amely az általánosabb jármű osztályból származik (`Vehicle`) a következők alapján

* tartalmaz egy attribútumot
  * `numberPassenger`: egész szám, amely az utasok számát jelenti (sofőr nélkül)
* konstruktor, amely megkap két értéket az attribútumok számára, és beállítja azokat (az ős attribútumát a `super` hívással).
* `getGrossLoad` visszaadja a mozgó gépkocsi súlyát. Hívd az ős azonos nevű metódusát, és add hozzá az utasok
súlyát (Ez lesz a visszatérési érték).
* Definiáld felül a `toString` metódust, a következő formára:
  * `Car{numberOfPassenger=4, vehicleWeight=1700}`


Hozz létre egy `Van` osztályt, amely egy kisteherautót modellez. Ez az osztály az általános autóból származik,
kiterjeszti a `Car` osztályt.

* Tartalmaz egy `cargoWeight` egész attribútumot a rakomány súlyának tárolására.
* Definiálj egy konstruktort, amely megkapja a rakománysúlyt, és az ős osztály két attribútumához szükséges
értékeket is (összesen három egész érték). Hívd a `super`-t az ős attribútumok inicilizálására, és állítsa be az új attribútumot is.
* Definiáld felül a `getGrossLoad` metódust. Hívd az ős azonos nevű metódusát, és add hozzá a rakomány
súlyát (Ez lesz a visszatérési érték).
* Definiáld felül a `toString` metódust, a következő formára:
  * `Van{cargoWeight=1222, numberOfPassenger=4, vehicleWeight=1200}`

Virtuális metódusok használata (Mindig az hívódik, amelyikre szükség van.)

[rating feedback=java-virtualmethod-vehiclecarvan]

## Gyakorlat 2 - FerryBoat

A komp `FerryBoat` képes bármilyen autót tárolni, aminek kisebb a súlya a megengedett összsúlynál. Viszont a komp is
egy speciális jármű.

* Definiálj egy állandót `MAX_CARRY_WEIGHT` néven, amely tárolja a maximálisan szállítható autó súlyát.
* Ha szállít autót, akkor azt egy `Car` típusú `car` attribútumba tárold. (Ha nem szállít, akkor ez `null`.)
* Hozz létre egy konstruktort, amely megkap egy egész értéket, amivel meghívod a `super`-t.
* Definiáld felül a `getGrossLoad` metódust. Hívd az ős azonos nevű metódusát, és add hozzá a szállított
autó súlyát (Ez lesz a visszatérési érték).
* Definiálj egy `canCarry` metódust, ami igazat ad vissza, ha a paraméterben kapott autót szállíthatja,
azaz a szállítandó autó súlya kisebb, mint a `MAX_CARRY_WEIGHT` (egyébként hamis).
(Akár autó, akár kisbusz a referencia célja mindig a megfelelő metódus hívódik meg.)
* Definiálj egy `load` metódust, ami igazat ad vissza, ha a paraméterben kapott autót berakodta,
azaz a súlya kisebb, mint a `MAX_CARRY_WEIGHT` (ekkor tárolja el az autót a referenciába).
* Definiáld felül a `toString` metódust, a következő formára `FerryBoat=` + a tárolt autó `toString` eredménye:
  * `FerryBoat{car=Van{cargoWeight=200, numberOfPassenger=1, vehicleWeight=1200}}`
  * `FerryBoat{car=Car{numberOfPassenger=1, vehicleWeight=1200}}`
  
[rating feedback=java-virtualmethod-ferryboat]
