# Default és paraméter nélküli konstruktor

Amennyiben egy osztálynak nem adunk meg konstruktort, a fordító biztosít egy default konstruktort az osztály példányosításához. Ez semmi más utasítást nem tartalmaz, csak egy `super()` hívást, amely az ős (jobb híján az `Object` osztály) paraméter nélküli konstruktorának hívása. Amennyiben bármilyen konstruktort implementálunk, akár paraméterrel, akár paraméter nélkül, az osztály nem kap default konstruktort.

A paraméter nélküli konstruktorban is inicializálhatunk attribútumokat, ha van valamilyen értelmes, az alapértelmezettől eltérő kezdőértékük.

##Ellenőrző kérdések

* Van-e olyan Java osztály, amelynek egyáltalán nincs konstruktora?
* Mikor lehet paraméter nélküli példányosítás?
* Mit csinál a default konstruktor?
* Mi a különbség a default konstruktor és a paraméter nélküli konstruktor között?


## Gyakorlat 1 `SimpleDate` osztály

Az osztály év, hó, nap dátumokat reprezentál, de csak 1990. január 1. utáni dátumokat, ezeket
`year`, `month`, `day` nevű (`int` típusú) attribútumokban tárolja, konstruktora nincs. Az értékek beállítása
publikus metódusból történik.

publikus metódusok:
```java
public void setDate(int year, int month, int day)
public int getYear()
public int getMonth()
public int getDay()
```

A dátum részek megadásakor legyen ellenőrzés, csak korrekt év (>= 1900), korrekt hónap (1-12) és a hónapnak megfelelő nap
érték fogadható el. Vegyük figyelembe a szökőéveket is! Inkorrekt paraméter értékek esetén a metódus dobjon
`IllegalArgumentException`-t, a megfelelő tájékoztató szöveggel.

## Tipp

Az ellenőrzést szervezzük ki privát metódusokba! pl. a következők lehetnek:

private metódusok:
```java
private boolean isCorrect(int year, int month, int day)
private boolean isLeapYear(int year)
private int calculateMonthLength(int year, int month)
```

[rating feedback=java-defaultconstructor-simpledate]

## Gyakorlat 2 `SimpleDateFormatter` osztály

A dátum adatot formázni is kellene, mégpedig országonként eltérő módon. Hozzunk létre egy CountryCode
enumot HU, EN, US értékekkel. Az osztály egyik publikus metódusa átvesz egy enumot és annak alapján állítja össze a dátum
stringet, a másik az alapértelmezett országkódot használja. Ezt az osztály paraméter nélküli konstruktora állítja be.

publikus metódusok:
```java
public SimpleDateFormatter()
public String formatDateString(SimpleDate simpleDate)
public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate)
```

[rating feedback=java-defaultconstructor-simpledateformatter]

## Tanulmányi feladat

Hogyan tudjuk ellenőrizni, hogy a konstruktor nélküli osztályunk valóban kapott üres konstruktort?

Decompiler segítségével visszafejthetjük a .class fájlt és annak metódusait megtekinthetjük. Ehhez fordítsuk le a kész
`SimpleDate.java` forráskódot (Maven ablak, build), majd navigáljunk parancssorból a projekt target\classes könyvtárába.
Ezt egyszerűen megtehetjük TotalCommander használatával, ha megkeressük a classes mappát, a Commands menüben az
Open command prompt window pont ezen a mappán nyílik meg.

Adjuk ki a `javap defaultconstructor.date.SimpleDate` parancsot. A `javap` a JDK beépített decompiler alkalmazása, és a .class
fájl alapján visszaadja annak tartalmát metódus szinten (további paraméterezés is lehetséges). Itt látható lesz az
a `defaultconstructor.date.SimpleDate()` metódus is, amit a `javac` szerkesztett bele a class fájlba.

[rating feedback=java-defaultconstructor-tanulmanyi]
