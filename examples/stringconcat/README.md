# Konkatenáció

A konkatenáció összefűzést jelent. A `String` tartalmaz egy `concat()` metódust, 
amely egy másik `String`-et vár paraméterül, de figyeljünk, hogy az objektum 
immutable, ezért egy új `String` objektum fog létrejönni. Összefűzésre használható még a `+` operátor.

```java
String s1 = "abc";
s1.concat("def"); // s1 értéke még mindig "abc"
String s2 = s1.concat("def"); // s2 értéke "abcdef"

s1 += "def"; //s1 értéke is "abcdef"

```

Figyelni kell a műveletek sorrendjére. Például, ha két számot és egy szöveget szeretnénk 
összekonkatenálni, akkor ha először a két szám szerepel, akkor ezek összeadódnak 
és ehhez fűződik hozzá a szöveg. Viszont, ha előbb van a szöveg, akkor a balról jobbra 
történő kiértékelés miatt először a szöveghez hozzáfűződik az első szám, és így már 
egyben egy `String` lesz, majd ugyanez történik a másodikkal. Nézzünk erre példát:


```java
System.out.println("Szöveg" + 1 + 5); // Eredmény: "Szöveg15"
System.out.println(1 + 5 + "Szöveg"); // Eredmény: "6Szöveg"
```

Egy lehetséges megoldás utóbbi kiküszöbölésére, ha a számok elé egy üres `String`-et írunk:

```java
System.out.println("" + 1 + 5 + "Szöveg"); // Eredmény: "15Szöveg"
```

Ennél jobb megoldás, ha a csomagoló osztályok `toString()` metódusát hívjuk.

```java
System.out.println(Integer.toString(1) + 5 + "Szöveg");
```

## Ellenőrző kérdések

* Mit jelent az, hogy a `String` immutable?
* Hogyan fűzhetők össze `String` objektumok?
* Mi történik konkatenálás esetén az objektumok szintjén?

## Feladat

### `toString()`

Készítsd el az `Employee` osztályt és annak a `toString()` metódusát! Az osztály tartalmazza az 
alkalmazott nevét, foglalkozását és fizetését, melyeket konstruktorban kap meg. A `toString()` metódus az alkalmazott 
adatait az alábbi formában adja vissza:

```text
Kis Géza - minőségellenőr - 520000 Ft
```

Hibakezelés:  
Minden adat megadása kötelező, és a fizetés csak 1000-rel osztható pozitív szám lehet. 
Bármilyen hiba esetén dobj `IllegalArgumentException` kivételt!

### Név összefűzése

Készítsünk olyan osztályt, amely egy név részelemeinek konstruktorban történő megadásával
magyar vagy nyugati stílusú név összefűzést csinál,
kezelve az opcionális elemek hiányát is. A névelemek a következők: családi név, köztes név, keresztnév (givenName)
és titulus (Mr, Ms, Dr).

Hibakezelés:  
A családi név és az adott (kereszt) név kötelező attribútumok.
Hiányuk esetén (`null` vagy üres `String`) dobjon  `IllegalArgumentException`-t!

A titulus legyen enum. Az egyik metódusban használj `+=` operátorokat, a másikban `concat()` metódust.

publikus metódusok:

```java
public Name(String familyName, String middleName, String givenName, Title title)
public Name(String familyName, String middleName, String givenName)
public String concatNameWesternStyle()
public String concatNameHungarianStyle()
```

Tippek:  
Vezessünk be egy `isEmpty(String)` metódust, amelynek visszatérési értéke `true`
ha a paraméter String `null` vagy üres String!

[rating feedback=java-stringconcat-nevconcat]

## Teszt

Melyik műveletsornak nem `12Degree` az eredménye?

* [x] `1 + 2 + "Degree"`
* `Integer.toString(1) + 2 + "Degree"`
* `"" + 1 + 2 + "Degree"`
* `1 + "" + 2 + "Degree"`

