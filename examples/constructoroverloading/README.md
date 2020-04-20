# Konstruktor túlterhelés

Dönthetünk úgy, hogy többféle bemenő paraméterkombinációval szeretnénk létrehozni az objektumokat. Ehhez több, különböző paraméter szignatúrájú konstruktorra van szükségünk, azaz a konstruktor is túlterhelhető. A paraméter egyeztetés ugyanúgy működik, ahogy a a túlterhelt metódusoknál.

Amennyiben az egyik konstruktor általi műveletek megismétlendők lennének egy másikban, akkor nem kell az utasításokat átmásolnunk, mert a konstruktorok hívhatnak más konstruktorokat a `this` kulcsszó segítségével. Amennyiben egyre bővülő paraméterlistával hozzuk létre a konstruktorokat, akkor gyakorlatilag mind használni tudja az előzőt. Ezt hívjuk teleszkóp konstruktornak. Fontos megjegyezni, hogy egy konstruktor csak egyetlen másikat hívhat, és a hívásnak a legelső utasításnak kell lennie!

```java
public class Product {

    private String name;

    private int stock;

    private LocalDate bestBefore;

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, int stock) {
        this(name);
        this.stock = stock;
    }

    public Product(String name, int stock, LocalDate bestBefore) {
        this(name, stock);
        this.bestBefore = bestBefore;
    }
}
```

![overloading](images/overloading.png)

Ha nagyon sokféle paraméterezéssel példányosíthatunk egy osztályt, érdemes megfontolni builder osztály létrehozását.

## Ellenőrző kérdések

* Hány konstruktora lehet egy osztálynak?
* Milyen szabályok vonatkoznak az egy osztályon belüli konstruktorokra?
* Mi határozza meg, hogy egy példányosítás melyik konstruktort használja?
* Hogyan hívhatja meg egy osztály konstruktora ugyanazon osztály egy másik konstruktorát?
* Milyen szigorú szabály vonatkozik a `this()` használatára?


## Gyakorlat 1 `SimpleTime` osztály

Az osztály objektuma egy időpontot reprezentál egy napon belül, és többféleképpen
hozható létre. Az objektum el tudja dönteni, hogy a paraméterként kapott azonos típusú
objektumtól percekben kifejezve mennyire különbözik.

konstruktorok:
```java
 public SimpleTime(int hours, int minutes)
 public SimpleTime(int hours)
 public SimpleTime(SimpleTime time)
```

publikus metódusok:
```java
 public int difference(SimpleTime time)
 public String toString()
```

[rating feedback=java-constructoroverloading-simpletime]

## Gyakorlat 2 `BusTimeTable` osztály

Az osztály egy buszmenetrendet reprezentál,
ahol az indulási időket `SimpleTime` objektumok listája tárolja.
Ezt többféleképpen létre lehet hozni, lásd a konstruktorokat
(óránként indul, generáláskor az  első indulás óráját, az utolsó indulás óráját,
és az ismétlődő perceket kell megadni).
A listából ki lehet keresni a következő indulás idejét.

konstruktorok:
```java
public BusTimeTable(List<SimpleTime> timeTable)
public BusTimeTable(int firstHour, int lastHour, int everyMinute)
```

publikus metódusok:
```java
public List<SimpleTime> getTimeTable()
public SimpleTime nextBus(SimpleTime actual)
```

## Hibakezelés

  Ha az adott napon több busz már nem indul, a metódus dobjon
   `IllegalStateException`-t a megfelelő információs szöveggel.
   
[rating feedback=java-constructoroverloading-bustimetable]   

## Bónusz feladat

Írj egy olyan metódust a `BusTimeTable` osztályban, ami az aznapi első busz indulást adja vissza!

Gondolj arra, hogy a listában nem feltétlenül az első elem az első busz indulási ideje!
A metódus teszteléséhez bővítsd ki a `BusTimeTableTest` osztályt a megfelelő teszt metódusokkal.
