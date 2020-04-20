# Statikus attribútumok és metódusok

## Statikus attribútumok

A statikus (`static`) attribútumok az osztályhoz, és nem az objektumhoz tartoznak, de minden az adott osztályú objektum eléri és közösen használhatja azokat. Osztálybetöltéskor jönnek létre és inicializálódnak. Elérésükhöz osztályon belül csak a nevet kell megadnunk, osztályon kívülről azonban akár az osztálynevet, akár a változónevet használhatjuk minősítőnek. Konvenció szerint az osztály nevét szoktuk, ezzel is jelezve, hogy az attribútum "közös tulajdon", nem az adott objektumé. Nagyon gyakran tárolunk bennük az osztályban használt konstanst, ilyenkor az attribútum `static final` módosítóval rendelkezik. A konstansok nevét csupa nagybetűvel írjuk, a több szóból állókat pedig `'_'` jellel választjuk el.

```java
class Parcel {

    public static final double BOX_WEIGTH = 2.3;

    private double netWeight;

    public Parcel(double netWeight){
        this.netWeight = netWeight;
    }

    public double grossWeight(){
        return netWeight + BOX_WEIGHT;
    }
}
```

## Ellenőrző kérdések
* Miben speciális a statikus attribútum?
* Hogyan lehet hivatkozni a statikus attribútumra?
* Hivatkozhat-e az osztály bármelyik metódusa a statikus attribútumra?

## Statikus metódusok

Az osztályban deklarált metódusok csak példányosítás után, a példányon át érhetőek el, és jellemzően a példányváltozókkal dolgoznak. A statikus (`static`) metódusok példányosítás nélkül is elérhetőek, kívülről az osztálynév minősítővel. Elérik a statikus atribútumokat és más statikus metódusokat hívhatnak. Nem érnek el nem statikus attribútumokat és metódusokat, de a példány attribútumai és metódusai elérhetik a statikus metódusokat.

Használhatjuk konstruktorok helyett, főleg, ha sok túlterhelt konstruktorra van szükség, vagy más osztályt kell példányosítani.

```java
class Sector{
    private double degree;
    private double radius;

    public Sector(double degree, double radius){
        this.degree = degree;
        this.radius = radius;
    }

    public void setDegree(double degree){
        this.degree = degree;
    }

    public void setRadian(double radian){
        degree = radianToDegree(radian);
    }

    public static double radianToDegree(double radian){
        return radian / Math.PI * 180;
    }
}
```

A fenti osztályban a `radianToDegree` metódust akkor is használhatjuk, ha nincs körcikkünk, csak szeretnénk átváltani radiánból fokra. A példány is használhatja, ha a körcikknek utólag állítjuk be a szögét, de azt csak radiánban tudjuk megadni (`setRadian`).

## Ellenőrző kérdések

* Hogyan kell egy statikus metódust deklarálni?
* Hogyan kell egy statikus metódust meghívni?
* Az osztály milyen attribútumaira és metódusaira hivatkozhat a statikus metódus?
* Meghívhatja-e egy nem statikus metódus a statikus metódust? És fordítva?
* Példányosíthatja-e egy másik osztály objektumát egy statikus metódus?

## Statikus import

Egy osztály statikus metódusait és attrobútumait közvetlenül importálhatjuk, ha az import után használjuk a static kulcsszót. Ebben az esetben a metódus és az attribútum minősítő nélkül is használhatóvá válik, ezért sok statikus import használata rontja a kód olvashatóságát.

```java
import static java.lang.Math.PI;

class Circle{
    private double radius;

    public double area(){
        return radius * radius * PI;
    }
}
```

## Gyakorlat - banki tranzakciók követése

### `BankTransaction` osztály
Az osztály követi a létrehozott példányai által reprezentált banki tranzakciókat.
Számolja a tranzakciókat, azok értékét összegzi, és utasításra átlagolja azokat.
Minden tranzakció értéket megvizsgál, és a nap elején beállított statikus `currentMinValue`
és `currentMaxValue` változókban nyilvántartja az adott tranzakcióig
előforduló minimális és maximális tranzakció értékeket.

Publikus statikus metódusok:

```java
public static void initTheDay()
public static BigDecimal averageOfTransaction()
public static long getCurrentMinValue()
public static long getCurrentMaxValue()
public static BigDecimal getSumOfTrxs()
```

Publikus metódus:

```java
 public BankTransaction(long trxValue)
```

### Hibakezelés

Amennyiben a létrejövő `BankTransaction` objektum tranzakció értéke kívül esik a
konstansként megadott min és max határokon (1 és 10 000 000), `IllegalArgumentException`-t várunk a megfelelő értesítő szöveggel.

### Tipp

A megoldás készüljön fel arra az (egyébként nem túl valószínű) esetre is,
ha egyetlen érvényes tranzakció sem volt. Ilyenkor az `averageOfTransaction`,
a `getCurrentMinValue` és a `getCurrentMaxValue` metódusok nullát adjanak vissza.

Több esetben jól alkalmazható a Java három operandusú művelete!

### Statikus import megjelenése

Figyeld meg, hogy a teszt osztályok hogyan használják az `import` és az `import static` direktívákat.

Figyeld meg, hogy a fejlesztő környezeted az általad írt példákban mikor generál `import` és
mikor `import static` direktívákat.

 [rating feedback=java-staticattrmeth-banktransaction]
