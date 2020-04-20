# Metódusok öröklődése

Hasonlóan az attribútumokhoz, a metódusok is megjelennek a leszármazottban, de a láthatóságukat a szülő osztály korlátozhatja. Csak a `public` és `protected` metódusok érhetőek el a leszármazott osztályból biztosan, a láthatósági módosító nélküliek csak akkor, ha a szülő és a gyermek is ugyanazon csomagban található. A gyermek osztály az örökölt és általa elérhető metódusokat felülírhatja (*override*) az alábbi szabályok szerint:

- A gyermek metódus láthatósága nem lehet szűkebb.
- A visszatérési érték típusa primitív típus esetén megegyezik, osztály esetén csak ugyanolyan, vagy a leszármazottja lehet (kovariáns típus).
- A metódus szignatúrájának meg kell egyeznie.
- Nem dobhat újabb vagy bővebb kivételt, de ezt a részt akár el is hagyhatjuk.
- `final` kulcsszóval ellátott metódus nem írható felül.

Ha egy metódust deklaráltak a szülőben és a gyermekben is, akkor a gyermekből elérhető a szülő metódusa is a `super` minősítővel.

Ha eredetileg nem volt hozzáférése a metódushoz, és ugyanolyan névvel létrehoz egyet, akkor az elfedi az örököltet.

```java
public class Bear {

    public void hunt() {
        System.out.println("Bear is hunting.");
        eat();
    }

    public void speak() {
        System.out.println("Bear roars.");
    }

    protected void sleep() {
        System.out.println("Bear is sleeping.");
    }

    private void eat() {
        System.out.println("Bear is eating.");
    }
}

public class Grizzly extends Bear {

    public void speak() {				// Override
        System.out.println("Grizzly growls.");
    }

    public void sleep(int length) {		// Overload
        System.out.println("Grizzly is sleeping for " + length + " hours.");
    }

    public boolean eat() {				// Hide
        System.out.println("Grizzly is eating.");
    }
}
```

A `Bear` négy metódusából az `eat` nem elérhető a `Grizzly`-ből, ezért a `Grizzly` `eat` metódusa nem írja felül a `Bear` `eat` metódusát, hanem elrejti azt.

A `hunt` metódus változtatás nélkül öröklődik, a `speak` metódust pedig a `Grizzly` felülírja, mivel a két metódus szignatúrája megegyezik. A két `sleep` metódus paramétereiben nem egyezik, ezért a `Grizzly`-ben deklarált `sleep` az örökölt metódus túlterhelése, azaz itt két különböző szignatúrájú `sleep` is létezik.

Próbáljuk ki, mi történik, ha minden elérhető metódust meghívunk egy `Grizzly` objektumból.

```java
public static void main(String[] args) {
    Grizzly grizzly = new Grizzly();
    grizzly.hunt();             // Bear is hunting. Bear is eating.
    grizzly.sleep();            // Bear is sleeping.
    grizzly.sleep(10);    	    // Grizzly is sleeping for 10 hours.
    grizzly.speak();            // Grizzly growls.
    grizzly.eat();              // Grizzly is eating.
}
```

A két `sleep`, a `speak` és az `eat` metódus láthatóan úgy működik, ahogy várjuk. A örökölt `hunt` metódus hívja az `eat` metódust, ami létezik mindkét osztályban. Láthatóan az ősben lévő fut le. Lássuk mi történik, ha megváltoztatjuk az `eat` láthatóságát a `Bear`-ben protectedre, azaz elérhetővé válik a leszármazottban. Ekkor a `Grizzly` `eat` metódusa nem elrejti, hanem felülírja azt, azaz többé nem lehet a visszatérési értéke `boolean`, mert az ellentmondana a fenti 2. szabálynak.

```java
public class Bear {

    public void hunt() {
        System.out.println("Bear is hunting.");
        eat();
    }

    public void speak() {
        System.out.println("Bear roars.");
    }

    protected void sleep() {
        System.out.println("Bear is sleeping.");
    }

    protected void eat() {
        System.out.println("Bear is eating.");
    }
}

public class Grizzly extends Bear {

    public void speak() {
        System.out.println("Grizzly growls.");
    }

    public void sleep(int length) {
        System.out.println("Grizzly is sleeping for " + length + " hours.");
    }

    public void eat() {
        System.out.println("Grizzly is eating.");
    }
}
```

Hívjuk meg újra a `Grizzly` `hunt` metódusát:

```java
public static void main(String[] args) {
    Grizzly grizzly = new Grizzly();
    grizzly.hunt();             //Bear is hunting. Grizzly is eating.
    grizzly.eat();              //Grizzly is eating.
}
```

**A metódusok mindig abból az osztályból hívódnak meg, amilyen objektumban vagyunk (dinamikus kötés), de figyeljünk a rejtett és az override-olt metódusok közötti különbségre!**

Ha az utódban a felülíró metódust a `@Override` annotációval látjuk el, akkor már fordítási időben kiderül, ha az mégsem felülírja, hanem elrejti vagy túlterheli az ősben lévő metódust.

## Statikus metódusok öröklődése

A statikus metódusok is öröklődnek, de sosem írhatóak felül, csak elrejthetőek. Az elrejtés szabályai azonban ugyanazok, mint a nem statikus metódusok felülírási szabályai kiegészítve még eggyel:

- A szülőben statikus metódus a gyermekben is statikus kell legyen, és a szülőben nem statikus metódus nem definiálható felül a gyermekben statikus metódussal. Mindkettő fordítási idejű hibához vezet.

A statikus metódusok statikusan kötődnek az őket hívó metódushoz. Azaz ugyanazon osztálybeli metódus lesz mindig meghívva, mint ahonnan hívják. Képzeljük el, hogy a fenti `Bear` és `Grizzly` osztályokban a `hunt` és az `eat` metódusok is statikusak.

```java
public class Bear {

    public static void hunt() {
        System.out.println("Bear is hunting.");
        eat();
    }

    protected static void eat() {
        System.out.println("Bear is eating.");
    }
}

public class Grizzly extends Bear {

    public static void eat() {
        System.out.println("Grizzly is eating.");
    }
}
```

Ekkor a `Grizzly` osztályból hívva a `hunt` metódust, mivel az a szülőben van definiálva, azt tapasztaljuk, hogy a szülő `eat` metódusát hÍvja. De ezt is vártuk, hiszen a gyerekben lévő statikus `eat` metódus csak elrejti a szülő `eat` metódusát, és nem felülírja azt.

```java
public static void main(String[] args) {
    Grizzly.hunt();             // Bear is hunting. Bear is eating.
    Grizzly.eat();              // Grizzly is eating.
}
```

Ha példányból hívjuk őket, akkor a deklarált típus számít, és nem az, hogy milyen típusú a tényleges objektum.

```java
public static void main(String[] args) {
    Bear bear = new Grizzly();
    Grizzly grizzly = new Grizzly();
    bear.eat();			// Bear is eating.
    grizzly.eat();		// Grizzly is eating.
}
```

Éppúgy ahogy a statikus változók esetén, a statikus metódusoknál is kerüljük az referencia változón való hívást, és inkább használjuk az osztály nevét minősítőként.

## Ellenőrző kérdések

* Öröklődnek-e a metódusok?
* Minden örökölt metódust elér a leszármazott?
* Milyen láthatósági módosítók vannak?
* Hogyan érheti el a leszármazott osztály az ős osztály `private` metódusát?
* Milyen szabályai vannak a metódus felüldefiniálásnak?
* Lehet-e a felüldefiniáló metódusnak más típusú visszatérési értéke, mint a felüldefiniáltnak?
* Mi a haszna az `@Override` annotációnak? Kötelező-e használni?
* Hogyan lehet a leszármazott osztályban a felüldefiniált ős osztálybeli metódust elérni?
* Az `A` osztály leszármazottja a `B`, annak leszármazottja a `C`. Az `A` osztályban van egy `m()` metódus, amit a `B` osztály nem definiált felül. Felüldefiniálhatja-e ezt a metódust a `C` osztály?
* Mi történik, ha a leszármazott osztályban van egy, az ős osztály `private` metódusával azonos nevű metódus?
* Hogyan lehet megakadályozni, hogy a leszármazott osztály felüldefiniálja az ős osztály egy metódusát? Mikor lehet erre szükség?


## Gyakorlat 1

### `Product` és `PackedProduct` osztályok

Az ős `Product` osztály adott terméket reprezentál, a `PackedProduct` osztály ennek becsomagolt
specializációja. Egymástól metódusokat örökölnek, de ezeket az osztályra jellemző módon felül
kell írni (overwriting).

`Product` osztály `String name`, `BigDecimal unitWeight` és `int numberOfDecimals` attribútumokkal.
Ha a tizedes értékek száma nics megadva, alapértelmezetten két tizedesjeggyel számolunk
(egységként kg értendő).

publikus metódusok:    
```java
 public Product(String name, BigDecimal unitWeigth, int numberOfDecimals)
 public Product(String name, BigDecimal unitWeigth)
 public BigDecimal totalWeight(int pieces)
```

`PacketProduct` osztály `int packingUnit` és `BigDecimal weightOfBox` attribútumokkal.
Ezek megadják, hogy a termékből hány darab helyezhető egy dobozba, és annak súlya alapján
a csomagolt termék súlya számítható.

publikus metódusok:    
```java
 public PackedProduct(String name, BigDecimal unitWeight, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox)
 public BigDecimal totalWeight(int pieces)
```

Írd felül az örökölt `totalWeight()` metódust úgy, hogy egy szállítmány
(azaz a termékek és a szükséges számú dobozok) összes súlyát adja vissza,
szintén `numberOfDecimals` tizedesre kerekítve.
A darabszámtól függően lehet, hogy lesz egy nem tele doboz is!
A felüldefiniálás során felhasználhatók örökölt metódusok is!

[rating feedback=java-inheritancemethods-productpackedproduct]

## Gyakorlat 2

### `DebitAccount` és `CreditAccount` osztályok
Az ős `DebitAccount` és a leszármazott `CreditAccount` osztályok egy,
a saját számlához csatolt terheléses kártyát és egy kombinált kártyát reprezentálnak.
Míg az előbbi csak a számlaegyenleg értékéig használható (debit kártya), a kombinált kártya
a számlaegyenleg felett az előre megállapított hitelkeretig felhasználható. Minden tranzakciónak
költsége van, ez a megadott konstans értékek és a tranzakció értéke alapján számítódik,
és levonásra kerül az egyenlegből.

`DebitAccount` osztály `String accountNumber` és `long balance` attribútumokkal, valamint
* `double COST` - 3.0-ra inicializálva, és
* `long MIN_COST` - 200-ra inicializálva konstans értékekkel.

publikus metódusok:    
```java
 public DebitAccount(String accountNumber, long balance)
 public final long costOfTransaction(long amount)
 public boolean transaction(long amount)
 public void balanceToZero() // az egyenleget nullázza le, túlköltés esetén
```

`CreditAccount` osztály a `DebitAccount` osztály leszármazottjaként,
`long overdraftLimit` attribútummal.

publikus metódusok:    
```java
 public CreditAccount(String accountNumber, long balance, long overdraftLimit)
 public boolean transaction(long amount)
```

[rating feedback=java-inheritancemethods-debitcreditaccounts]
