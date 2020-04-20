# Object ősosztály

Az `Object` osztály a `java.lang` csomagban található,  és minden olyan osztály közvetlen őse, amelyben nem adunk meg explicit őst. A Java nyelvben egyszeres öröklődés van, ezért ez az osztály az öröklődési hierarchia gyökéreleme. Mivel minden osztály közvetlen vagy közvetve leszármazottja, ezért mindegyik örökli az `Object` publikus metódusait (pl. `equals`, `hashCode`, `toString`). Mivel minden osztály `Object` és minden példány `Object` példány is, ezért az `Object` típusú referenciaváltozónak bármilyen objektumot értékül adhatunk. Sőt, még a tömbnek is őse, ezért akár tömböt is bele tehetünk. Gyakorlatilag minden adatszerkezet mögött `Object` áll, a kollekciók mögött is.

Már tapasztalhattuk, hogy minden objektumot át tudunk adni a `System.out.print` metódusnak, azonban többnyire valamilyen furcsa szöveg jelenik meg a képernyőn. Ez azért van, mert ez az objektum `toString()` metódusát hívja, amely mindig van neki, hiszen az `Object` osztálytól örökölte. Lehetőségünk van ezt a metódust felülírni, hogy számunkra értelmezhető szöveg jelenjen meg.

## Ellenőrző kérdések

* Van-e őse az `Object` osztálynak?
* Lehet-e létrehozni olyan Java osztályt, aminek nincs őse?
* Sorold fel az `Object` osztály legfontosabb metódusait!
* Mi a `toString()` metódus szerepe?
* Amennyiben egy objektumot kiíratunk, melynek osztályában nincs implementálva a `toString()` metódus, mi kerül kiírásra?

## Gyakorlat - SimpleBag

### `Book`, `Beer` és `SimpleBag` osztályok

A `SimpleBag` osztály egy tetszőleges számú `Object` típusú objektumot tartalmazó adatszerkezetet reprezentál,
a `Book` és `Beer` osztályok a kipróbálását segítik. A tartalmazott objektumok között lehetnek azonosak is.
A `SimpleBag` osztály a tartalmazott objektumokat egy `List<Object> items` attribútumban tárolja, és saját metódusai
vannak az adatszerkezet kezelésére.
Az adatszerkezet bejárása a "kurzor" szemlélettel lehetséges. A kurzor a létrehozáskor az első elem előtt áll,
és bármikor újra ide helyezhető a `beforeFirst` metódus meghívásával. Azaz a bejárás megismételhető.

publikus metódusok:
```java
 public SimpleBag()
 public void putItem(Object item)
 public boolean isEmpty()
 public int size()
 public void beforeFirst()
 public boolean hasNext()
 public Object next()
 public boolean contains(Object item)
 public int getCursor()
```

`Book` osztály `String author` és `String title` attribútumokkal

publikus metódusok:    
```java
public Book(String author, String title)
public String toString()
public boolean equals(Object o) // generált metódus!
```

`Beer` osztály `String name` és `int price` attribútumokkal

publikus metódusok:    
```java
 public Beer(String name, int price)
 public boolean equals(Object o) // generált metódus!
```

[rating feedback=java-objectclass-simplebag]

