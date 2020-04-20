# Változó hosszúságú paraméterlista

A változó hosszú paraméterlistát a Java 5-ben vezették be.  Előtte a több, ugyanolyan típusú paramétert kollekcióba téve adhattuk át a metódusnak, vagy több, ugyanolyan nevű metódust készítettünk különböző számú paraméterrel (metódus túlterhelés). A varargs használata elkerülhetővé tette ezt.

A paraméterlistában a típus után három pont (`...`) jelzi, hogy itt több, ugyanolyan típusú érték is megadható, akár felsorolással, akár tömbként. A metódusból a varargsként átadott paramétereket tömbként látjuk. Az ugyanolyan típusú paraméterek száma akárhány lehet, még nulla is. Ha van minimális száma a megadható paramétereknek, akkor azokat a varargs előtt külön kell deklarálnunk.

```java
public void putStudentsIntoCourse(String... students) {
	for (String name: students) {
		course.add(name);
	}
}
```

Hívni akár tömbbel, akár `String`-ek sorozatával lehet:

```java
putStudentsIntoCourse("Emma", "Dániel", "Péter", "Ferenc", "Mariann");
```

vagy

```java
String[] names = {"Emma", "Dániel", "Péter", "Ferenc", "Mariann"};
putStudentsIntoCourse(names);
```

VIGYÁZZ! Varargs csak egy, a legutolsó paraméter lehet. Sose használd különböző értelmű paraméterek összevonására csak azért, mert a típusuk egyezik!

## Ellenőrző kérdések

* Hogyan kell deklarálni a paraméter listában a változó hosszúságú paraméter listát?
* Lehet egy metódusnak vegyes paraméter listája (fix és változó hosszúságú is)?
* Metódus hívásnál hogyan kell megadni a változó hosszúságú paramétert?

## Vizsga statisztika
Készíts egy `ExamStats` osztályt, amely képes változó számú vizsgaeredmény (pontokban megadva)
esetén "statisztikát" készíteni. Ehhez az objektum adott vizsga esetén megkapja a max pontszámot konstruktorban,
majd az egyik metódusában a küszöbérték (százalék) valamint a vizsgaeredmények (pontok) felsorolásával ki tudja számolni az adott küszöbérték feleltti eredmények számát. Egy másik metódusban az alsó küszöbérték (százalékban) megadása és a vizsgaeredmény felsorolás megadásával meg tudja mondani, bukott-e valaki a vizsgán.

Publikus metódusok:
```java
 public ExamStats(int maxPoints)
 public int getNumberOfTopGrades(int limitInPercent, int... results)
 public boolean hasAnyFailed(int limitInPercent, int... results)
```

## Tipp

Ha a felsorolást nem adja meg a felhasználó (kihagyja a paramétert), a
metódusnál nem mutat hibát az IDE. Vararg esetén ugyanis ilyenkor automatikusan
üres tömb lesz a paraméter. Ebben az esetben viszont  `IllegalArgumentException`-t
várunk, a megfelelő tájékoztató szöveggel.

[rating feedback=java-methodvarargs-statisztika]
