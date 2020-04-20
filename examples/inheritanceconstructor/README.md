# Konstruktorok és az öröklődés viszonya

Első és legfontosabb, amit meg kell jegyeznünk, hogy a konstruktorok nem öröklődnek. A második, hogy az utód osztály példányosításakor mindig lefut az ős osztály valamelyik konstruktora, akár tartalmaz explicit hívást az utód konstruktora, akár nem. A hívást a `super()` metódus valósítja meg.

Hogyan is működik mindez. Tekintsük a következő osztályokat:

```java
public class Person {

    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Employee extends Person {

    private int salary;

    public Employee(String name, int age, int salary) {
        this.name = name;		// nem fordul le
        this.age = age;			// nem fordul le
        this.salary = salary;	// ez lefordul
    }
}
```

Az `Employee` példányosításakor azt várjuk, hogy legyen neve, kora és fizetése is, ezért ezeket átadjuk a konstruktorának. Csakhogy ő nem éri el a `name` és `age` attribútumokat, mert ezek a szülőben vannak deklarálva és a `private` láthatóság miatt semmilyen másik osztályból nem érhetőek el. Gondolhatnánk, hogy ha van publikus setter metódusa, akkor az öröklődik, tehát használható.

```java
public class Person {

    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {...}

    public void setAge(int age) {...}
}

public class Employee extends Person {

    private int salary;

    public Employee(String name, int age, int salary) {
        this.setName(name);
        this.setAge(age);
        this.salary = salary;
    } // még mindig nem fordul le
}
```

Ez teljesen igaz, használhatjuk, azonban a fordító még mindig hibát jelez. A hiba oka az, hogy nem használtuk a szülő konstruktorát sehol. A fordító ilyenkor is elhelyez az `Employee` konstruktorában egy `super()` hívást, amely az ős paraméter nélküli vagy default konstruktorát hívná. Csakhogy nincs ilyen a `Person`-ban, ezért szükséges, hogy mi hívjuk meg az ott lévő két paraméteres konstruktort, átadva neki a szükséges adatokat.

A helyes megoldás ebben az esetben:

```java
public class Person {

    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Employee extends Person {
    private int salary;

    public Employee(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }
}
```

Két fontos szabályt azonban be kell tartanunk:

- A `super()` hívás mindig a konstruktor első utasítása kell legyen.
- Egy konstruktor vagy `super()`, vagy `this()` hívást tartalmaz, a kettőt egyszerre sosem.

Mivel minden osztály példányosításakor lefut az ős konstruktora is, ezért `super` hívásnak mindenképp kell lennie valamelyik konstruktorban, akkor is, ha az implicit, azaz nem írjuk ki. (A default konstruktor ezek szerint implicit tartalmaz egy `super()` hívást és semmi mást.) Az első szabály miatt először mindig az ős konstruktora fut le, és csak utána a gyereké, azaz jelen esetben először az `Object`, majd a `Person` és legvégül az `Employee` kontruktora.

## Ellenőrző kérdések

* Mi a konstruktorok végrehajtási sorrendje egy leszármazott osztály példányosításánál?
* Mi határozza meg, hogy az ős osztály melyik konstruktora hajtódik végre?
* Milyen szigorú szabály vonatkozik a `super(...)` használatára?
* Mi a következménye az ős osztályra vonatkozóan, ha a leszármazott osztálynak csak default konstruktora van?
* Mi a következménye az ős osztályra vonatkozóan, ha a leszármazott osztály konstruktora nem tartalmaz `super(...)`  hívást?


## Gyakorlat 1

### `Car` és `Jeep` osztályok

A `Car` osztályból öröklődik a `Jeep` osztály, egyes metódusokat felülírva és használva az ős attribútumait. Mindkét autótípus esetében van `drive(int)` metódus, ami a vezetést szimulálja, adott km megtételét és közben az elhasznált üzemanyaggal csökkenti annak mennyiségét is, valamint ki tudjuk számítani a tankolható üzemanyagot is (`calculateRefillAmount()`).
A `Jeep` abban különbözik ősosztályától, hogy üzemanyagot nem csak a tankban, hanem kannákban is tud szállítani.
Felhasználáskor mindig először a kannákat ürítjük ki, utána a tankban levő üzemanyag mennyisége csökken.

`Car` osztály `double fuelRate`, `double fuel` `double tankCapacity` attribútumokkal

Publikus metódusok:

```java
public Car(double fuelRate, double fuel, double tankCapacity)
public void modifyFuelAmount(double fuel)
public void drive(int km) // csökkenti az üzemanyag mennyiségét, nem fogyhat ki!
public double calculateRefillAmount() //kiszámolja, mennyit lehet tankolni
```

`Jeep` osztály `double extraCapacity` és `double extraFuel` attribútumokkal

Publikus metódusok:

```java
public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel)
public void modifyFuelAmount(double fuel)
public void drive(int km) // csökkenti az üzemanyag mennyiségét, nem fogyhat ki!
public double calculateRefillAmount() //kiszámolja, mennyit lehet tankolni
```

## Tipp

Érdemes egy külön metódusba kiszervezni, hogy adott km megtételéhez van-e elegendő üzemanyagunk!

[rating feedback=java-inheritanceconstructor-carjeep]

## Gyakorlat 2

### `Course` osztály, `enum Facility` `PROJECTOR, COMPUTERS és CHALKBOARD` elemekkel, `Room` és `ClassRoom` osztályok
A `Room` leszármazottja a `ClassRoom` osztály.

 Ezek egy oktatócég termeit és kurzusait reprezentálják, meg kell tudni mondani, hogy adott kurzust annak létszáma és
 igénye (facility) alapján adott teremben meg lehet-e tartani.

`Room` osztály `String location` és `int capacity` attribútumokkal.

Publikus metódusok:

```java
public Room(String location, int capacity)
```

`ClassRoom` osztály `Facility facility` attribútummal

Publikus metódusok:

```java
public ClassRoom(String location, int capacity, Facility facility)
public boolean isSuitable(Course course)
```

`Course` osztály  `int participants` és `Facility facilityNeeded` attribútumokkal

Publikus metódusok:

```java
public Course(int participants, Facility facilityNeeded)
```

[rating feedback=java-inheritanceconstructor-coursefacility]

### Bónusz feladat

Mi történik, ha próbaképpen egy új osztályt akarunk örökíteni a `ClassRoom`-ból? Az IDE mit "követel" és miért?
