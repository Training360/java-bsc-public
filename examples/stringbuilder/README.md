# StringBuilder

A legfontosabb, hogy míg a `String` immutable, addig a `StringBuilder` osztály módosítható. Ha egy szövegen nagyon sok műveletet szeretnénk végrehajtani, akkor használjunk `StringBuilder`-t.

Konstruktorral hozható létre. A konstruktor lehet üres (ekkor alapértelmezetten egy üres karakterláncot ábrázol), megadhatunk egy `String`-et, akkor az lesz az értéke. Megadhatunk neki capacity-t is, ugyanis a háttérben egy karaktertömb áll, aminek meg lehet adni a méretét.  Hasznos, hiszen egyből akkora tömb jön létre, amekkorát szeretnénk.

A `StringBuilder`-en kívűl használható még az úgynevezett `StringBuffer` osztály is, ez szálbiztos.

### Főbb `StringBuilder` metódusok

*	`append()` – újabb érték hozzáfűzése
*	`toString()` – karakterlánccá konvertálás
*	`charAt()`, `indexOf()`, `length()`, `substring()` – ugyanúgy működnek, mint a `String`-ben
*	`insert()` – új karakterláncot illeszt be
*	`delete()` / `deleteCharAt()` – szövegrészt/karaktert töröl
*	`reverse()` – karakterek sorrendjét megfordítja

## Ellenőrző kérdések

* Mi a lényeges különbség a `StringBuilder` `append()` metódusa és a `String` `concat()` metódusa között?
* Mi a különbség a `StringBuilder` és a `StringBuffer` között?
* Melyek a `StringBuilder` főbb metódusai?
* Hogyan konvertálható String objektum `StringBuilder` objektumba és fordítva?


## Gyakorlati feladat - Név összefűzés
Készítsünk olyan osztályt, amely egy név részelemeinek megadásával magyar vagy nyugati stílusú név összefűzést csinál,
kezelve az opcionális elemek hiányát is. A névelemek a következők: családi név, köztes név, keresztnév (givenName)
és titulus (Mr, Ms, Dr, Prof).
A neveket tovább lehet módosítani, lehet beszúrni például titulust, törölni belőle részeket.


### Hibakezelés
A családi név és az adott (kereszt) név kötelező paraméterek.
Hiányuk esetén (`null` vagy üres String) dobjon  `IllegalArgumentException`-t.

### Megvalósítás

A titulus legyen enum.

publikus metódusok:
```java
public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title)
public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title)
public String insertTitle(String name, Title title, String where)
public String deleteNamePart(String name, String delete)
```

### Tippek

Vezessünk be egy `isEmpty(String)` metódust, amelynek visszatérési értéke `true`
ha a paraméter String `null` vagy üres String!

[rating feedback=java-stringbuilder-nevossszefuzes]

## Gyakorlati feladat - Palindróma
Készítsünk olyan osztályt, amelynek metódusa egy szóról, szövegrészletről el tudja dönteni,
hogy az palindróm (visszafelé is ugyanaz).

### Hibakezelés

A metódus `null` paraméter esetén dobjon  `IllegalArgumentException`-t.

### Megvalósítás

publikus metódusok:
```java
public boolean isPalindrome(String word)
```

### Tippek

Eltérő case-t (kisbetű, nagybetű) ne vegye figyelembe!

[rating feedback=java-stringbuilder-palindroma]
