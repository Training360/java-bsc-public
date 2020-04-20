# Scanner

A `Scanner` osztályt arra használjuk, hogy különböző primitív vagy `String` tipusú értékeket olvassunk be különböző forrásokból, pl.`String`, fájl, adatfolyam. A konstruktorban megadhatjuk a forrást, jól használható például akkor is, ha billentyűzetről szeretnénk beolvasni:

```java
Scanner scanner = new Scanner (System.in);
```

### Metódusok
*	`nextXXX()` – különböző típusokhoz, eltérő, de mindig `next` prefixű metódusok beolvasásra

```java
int number = scanner.nextInt(); //Csak szám beolvasására jó!
```

*	`hasNextXXX()` – `boolean` visszatérési értékű, megadja, hogy a következő érték adott típusú-e.
*	`next() / hasNext()` - a következő elválasztó karakterig adja vissza a szöveget. Az elválasztó karakter alapértelmezetten whitespace (`Charater.isWhiteSpace()`).
 Az elválasztó karakter a `useDelimiter()` metódussal változtatható meg.
*	`nextLine()` / `hasNextLine()` – akkor használjuk, ha egy szöveget soronként szeretnénk feldolgozni.


## Ellenőrző kérdések

* Mi a `Scanner` szerepe String feldolgozásoknál?
* Mi a delimiter szerepe, mi az alapértelmezett delimiter?
* Hogyan lehet az alapértelmezett delimitert visszaállítani?
* Hogyan lehet számokat beolvasni `Scanner` segítségével?


## Gyakorlati feladat - String beolvasás

Készítsünk egy `StringScanner` osztályt. Ennek metódusaival számok olvashatók be és összegezhetők
a delimiter megadásával vagy anélkül, illetve többsoros szövegből kiszűrhetők azok a sorok,
amelyek adott szót tartalmaznak.

### Hibakezelés

Az egyes funkcióknál a feldolgozhatatlan paraméterek és
paraméter kombinációk esetén dobjon `IllegalArgumentException`-t

### Megvalósítás

publikus metódusok:
```java
public int readAndSumValues(String intString, String delimiter)
public int readAndSumValues(String intString)
public String filterLinesWithWordOccurrences(String text, String word)
```

### Tippek

Vezessünk be egy `isEmpty(String)` metódust, amelynek visszatérési értéke `true`
ha a paraméter String `null` vagy üres String!
A túlterheléses metódusok esetén lehetőség van egymás hívására!

[rating feedback=java-stringscanner-stringbeolvasas]
