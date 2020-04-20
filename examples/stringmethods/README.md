# Főbb String metódusok

A `String` immutable és minden metódusa egy új `String`-et ad vissza.

```java
String name = "John Doe";
String upperName = name.toUpperCase(); // name értéke nem változik
```

A metódusok meghívhatóak literálokon is.

```java
String upperName = "John Doe".toUpperCase();
```

Amikor egy változó értékét akarjuk összehasonlítani egy literállal, akkor
mindig a literált tegyük előre, mert ez nem lehet `null` (szemben a
változó értékével), és ezért nem keletkezhet `NullPointerException`.

```java
String s = "john doe";
boolean b = "John Doe".equalsIgnoreCase(s);
```

A metódushívások egymás után láncolhatók.

```java
String upperForename = "John Doe".toUpperCase().substring(0, 4);
```

Ebben a leckében csak a legfontosabb `String` metódusokat vizsgáljuk meg. A többi metódusért érdemes megnézni a Java API-t.

* `length()` – a szöveg hosszát adja vissza
* `isEmpty()` - `true` értékkel tér vissza, ha a hossza egy
* `isBlank()` - `true` értékkel tér vissza, ha üres, vagy csak whitespace karaktereket tartalmaz (Java 11-esben jelent meg)
* `charAt()` – a paraméterül átadott indexen szereplő karaktert adja vissza
* `indexOf()`- azt adja vissza, hogy az egyik `String` egy másikban hányadik pozícióban található
* `startsWith()`/`endsWith()` – visszaadja, hogy egy `String` egy másik (paraméterül átadott) `String`-gel kezdődik / végződik
* `contains()` – megnézi, hogy egy `String` tartalmaz-e egy másikat
* `substring()` – egy Stringből egy másik `String`-et tudunk képezni. Két paramétre a "hányadik" karaktertől, "hányadik" karakterig szeretnék egy rész `String`-et létrehozni
* `toLowerCase()` / `toUpperCase()` – az új `String`-et kis- illetve nagybetűsen adja vissza
* `equals()` / `equalsIgnoreCase()` – `String`-ek összehasonlítására használhatóak, utóbbi nem veszi figyelembe a kis és nagybetű különbségeket.
     (Ha literállal hasonlítunk össze, akkor érdemes a literál `equals()` metódusát hívni, ugyanis a literál nem lehet null, szemben egy változó értékével.)
* `repeat()` - megismétli a `String` értéket a paraméterben megadott egész számszor (Java 11-esben jelent meg)
* `trim()` – a szöveg elején illetve végén lévő whitespace-karaktereket levágja. Gyakran használható üresség vizsgálatra.
* `replace()` – egy `String` egy részét tudjuk kicserélni egy másikra
* `split()` – Egy szeparátor karakter alapján, darabokra vághatjuk a szöveget. Visszatérési értéke egy `String` tömb



## Ellenőrző kérdések
* A `length()` metódus mit ad vissza a következő string esetében: " a p p l e" ?
* A `charAt()` metódus mit ad vissza: `"index".charAt(2)` hívás esetén?
* Az `indexOf()` metódus mit ad vissza `"index".indexOf('x')` hívás esetén?
* A `substring()` metódus hogyan értelmezi a paraméterként átadott indexeket?
* Az `equals()` és `equalsIgnoreCase()` metódusoknak mi a jelentősége?
* A `contains()` metódusnak mi a visszatérési értéke?
* A `replace()` metódus char vagy CharSequence paramétereket fogad. Mit jelent a CharSequence?
* A `trim()` metódus mit eredményez a következő string esetében: "\t an apple" ?

## Gyakorlati feladat - Fájlnevek kezelése

Készítsünk egy `FileNameManipulator` osztályt, amely fájlnevek ellenőrzésére, illetve ehhez kapcsolódó
String műveletekre alkalmas metódusokat tartalmaz.

### Hibakezelés
Az egyes funkcióknál a feldolgozhatatlan paraméterek és
paraméter kombinációk esetén dobjon `IllegalArgumentException`-t

### Megvalósítás

publikus metódusok:
```java
public char findLastCharacter(String str)
public String findFileExtension(String fileName)
public boolean identifyFilesByExtension(String ext, String fileName)
public boolean compareFilesByName(String searchedFileName, String actualFileName)
public String changeExtensionToLowerCase(String fileName)
public String replaceStringPart(String fileName, String present, String target)
```

### Tippek

Ha igény van rá, alkalmazzuk a metódusok láncolását!
Figyeljünk a vezető és követő `whitespace` karakterekre!

[rating feedback=java-stringmethods-filenamemanipulator]
