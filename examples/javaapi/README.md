# Java API

![JDK és JRE](images/jdk_jre.png)

[important]
A Java 11 már nem tartalmaz külön JRE-t, csak a JDK-t lehet letölteni.
[/important]

A Java nyelv nagyon gazdag osztálykönyvtárral rendelkezik csomagokba szervezve, melyet verzióról verzióra 
újabbakkal egészítenek ki, így nem kell minden feladatra saját osztályt gyártanunk. 
Legyen az párhuzamosság kezelése, naplózás, dátum- és időkezelés, reguláris kifejezések, 
XML feldolgozás, adatbázis-kezelés, fájlkezelés, felhasználói felületek és még sorolhatnánk, a 
Java alapkönyvtáraiban ezekre mind találunk megoldást. 
Teljes dokumentációt találhatsz a [Java SE 12 & JDK 12](https://docs.oracle.com/en/java/javase/12/docs/api/index.html) oldalon, 
sőt, ha kíváncsi vagy az osztályok forráskódjára, akkor azt is megtalálod a JDK telepítési könyvtárában a `lib\src.zip` állományban.

## Ellenőrző kérdések

* Mi az az osztálykönyvtár?
* Hogyan van az osztálykönyvtár szervezve?
* Hogyan kell elemeket felhasználni az osztálykönyvtárból?
* Milyen esetekben nem kell `import` kulcsszót használni?
* Hol található az osztálykönyvtár dokumentációja?

## Feladatok

### Nagybetűsítés

Keresd ki a JDK API dokumentációból, a
`String` osztálynál, hogyan lehet egy karakterláncot nagybetűssé tenni!

Írj egy `HelloWorld` osztályt, ami a `Hello World!` szöveget nagybetűssé alakítja!

A szöveg kiírása így történt:

```java
System.out.println("Hello World!");
```

A következőképpen használd a megtalált metódusnevet:

```java
System.out.println("Hello World!".metodusNeve());
```


### Bónusz feladat 1.

Hogyan áll össze egy osztály JavaDoc dokumentációja, miket tartalmaz?

### Bónusz feladat 2.

Mit jelent a deprecated szó?

### Bónusz feladat 3.

Amennyiben mi akarunk JavaDoc dokumentációt írni a saját osztályainkhoz, hogyan tudjuk ezt megtenni?
Milyen tageket használhatunk?

A `HelloWorld` osztályunkhoz írjunk JavaDoc-ot (osztály és metódus szinten). Majd generáljuk ki
az `mvn javadoc:javadoc` paranccsal. Hol jelenik meg a JavaDoc és milyen formátumban?

## Teszt

Melyik osztály NEM a `java.lang` csomagban van?

* [x] `Scanner`
* `String`
* `System`
