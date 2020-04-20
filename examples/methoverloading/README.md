# Metódusnév túlterhelés

Metódus túlterhelésről (_method overloading_) akkor beszélünk, ha egy osztályon belül több ugyanolyan nevű, de eltérő paraméter szignatúrával rendelkező metódus van. (Azaz a formális paraméterek típusának listája eltérő.) Akkor hasznos, ha több metódusnak is ugyanaz a feladata, de ehhez más és más bemenő adatra van szüksége. Híváskor a fordító onnan tudja, hogy melyik metódust kell futtatnia, hogy megnézi, hogy az aktuálisan kapott paraméterek mely formális paraméter szignatúrának felelnek meg.

Hogyan dönti el a fordító, hogy ez melyik?

1. Típusra pontos egyezést talál.
2. Primitív típus esetén nagyobbat talál.
3. Primitív típus esetén a csomagolóosztálynak megfelelőt talál.
4. Ugyanolyan típusú varargs paramétert talál.

A sorrend nagyon fontos: az első találatnál leáll, és csak egy konverziót végez!

Adva vannak az alábbi metódusok egy osztályban:

```java
public void play(short a) {...}		// 1
public void play(long a) {..}		// 2
public void play(Integer a) {...}	// 3
public void play(String... a) {...}	// 4
public void play(String a, String b) {..} // 5
```

Melyik fut le az egyes esetekben?

```java
short x = 3;
play(4);
play(x);
play("Hello");
play("alma", "körte");
```

Az első híváskor az aktuális paraméter `int` típusú. Nincs pontos egyezés, de nagyobb primitív típust talál, ezért a `// 2` fut le.

A második híváskor az aktuális paraméter `short` típusú. Ilyen paraméterű pont van, ezért az `// 1` fut le.

A harmadik híváskor a paraméter `String`, amely csak a `varargs`-ot váró `// 4` metódusnak felel meg.

A negyedik hívásra van pontos egyezés, ezért az `// 5` metódus fut le, hiába felel meg a `// 4` paraméter szignatúrának is.

## Ellenőrző kérdések
* Mi határozza meg egy metódus paraméter szignatúráját?
* Mitől különbözhet két paraméter szignatúra?
* Fordítási vagy futási időben történik a hívás és a definíció összerendelése?



## Gyakorlat - Time osztály

Szükségünk van egy időpontot reprezentáló osztályra `Time`, amely többféle paraméterezéssel példányosítható.
Az osztály metódusai segítségével adott objektumát össze tudjuk hasonlítani másik `Time` objektummal
és meg tudjuk mondani a kapott objektumról, hogy azonos időpontot reprezentál
vagy az adott objektum korábbi időpontot reprezentál (mindkét esetben egy-egy napon belül vagyunk!).

Konstruktorok:

```java
public Time(int hours, int minutes, int seconds)
public Time(int hours, int minutes)
public Time(int hours)
public Time(Time time)
```

Publikus metódusok:

```java
public boolean isEqual(Time time)
public boolean isEqual(int hours, int minutes, int seconds)
public boolean isEarlier(Time time)
public boolean isEarlier(int hours, int minutes, int seconds)
```

### Megjegyzés

A Java természetesen rendelkezik a megfelelő dátum és időkezelő osztályokkal,
de azok esetében is hasonló módon lett megoldva a többféle paraméterezés.

 [rating feedback=java-methodoverloading-time]

## Bónusz feladat

Kocsmatúrát tervezünk, és a maximális időkihasználás érdekében
a legjobb kocsma a legkorábban nyitó intézmény. Valósítsuk meg ennek kiválasztását adott listából
a `Pub` (kocsma neve és nyitási időpontja `Time` osztály használatával), valamint a listát tároló
`ListOfGoodPubs` osztály segítségével.

`Pub` osztály publikus metódusok:

```java
public Pub(String name, int hours, int minutes)
public String toString()
```

`ListOfGoodPubs` osztály publikus metódusok:

```java
public ListOfGoodPubs(List<Pub> goodPubs)
public Pub findTheBest()
```

### Hibakezelés

A `ListOfGoodPubs` osztály nem kaphat a konstruktorban `null` értéket, vagy üres listát!
Kivételkezeléssel (`IllegalArgumentException`) jelezzük, ha rossz a paraméter.

