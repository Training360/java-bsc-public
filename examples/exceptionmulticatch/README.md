# Multi-catch

Gyakran előfordul, hogy több kivételt is le szeretnénk kezelni egy blokkban, de ezek a kivételek semmilyen kapcsolatban nem állnak egymással, csupán mindegyik az `Exception` osztály leszármazottja. Mit tehetünk ilyenkor?

*	Duplikálni nem célszerű
* Multi catch, amikor egy catch ágban több kivételt is le tudunk kezelni, úgynevezett pipe (`|`) karakterrel elválasztva, egy névvel.


Nézzük hogyan:

```java
public class TrainerParser {

    public static final String SEPARATOR =";";

    public Trainer parse(String line) {
      try {
        String[] fields =  line.split(SEPARATOR);
        Trainer trainer = new Trainer(fields[0], Integer.parseInt(field[1]));
      } catch (NullPointerException | IllegalArgumentException | IndexOutOfBoundsException e) {
         throw new ParseException("Invalid line = " + line, 0);
      }
    }
}
```

## Ellenőrző kérdések
* Mit szokás csinálni az elkapott kivételekkel?
* Mikor kapjunk el egy catch ágban többféle kivételt?

## Gyakorlat - Converter példa

Adatbázisban kódolva tárolunk több igaz, hamis értéket egyetlen szöveges adatban, ahol '0' karakter a hamis és '1' karakter az igaz.
Készíteni kell tehát konvertert, amely átalakítja a szöveges adatot `boolean` tömb adattá.
A konvertáláshoz két osztályt is kell készíteni.
Legyen egy `BinaryStringConverter` osztály, amelynek van
`public boolean[] binaryStringToBooleanArray(String)` és egy
`public String booleanArrayToBinaryString(boolean[])` metódusa.
A `String`-ből konvertáló `IllegalArgumentException`-t dob, ha a `String`-ben nem csupa 0 és 1 van.
A `boolean[]`-ből konvertáló pedig `IllegalArgumentException`-t dob, ha a tömb üres.

Majd pedig kell egy `AnswerStat` osztály, amely az igaz/hamis adatokon számol statisztikát,
jelen esetben az igaz értékek százalékos arányát.

* legyen egy `convert` metódus, amely a `binaryStringToBooleanArray` metódus hívását csomagolja be.
Azaz elkapja a konvertálás során előforduló `NullPointerException`-t
vagy `IllegalArgumentException`-t és logolja a hibát, majd tovább dobja becsomagolva egy `InvalidBinaryStringException`-be,
amely egy saját `RuntimeException`-ból származó kivételosztály.
Mivel mindkét hibafajtára ugyanazt kell csinálni, használja a multi-catch-et.
* Legyen egy `int answerTruePercent(String answers)` metódusa, amely a paramétert `boolean` tömbbé alakítja,
majd meghatározza és visszaadja az igaz értékek százalékos arányát egészre kerekítve.
* A konstruktor paraméterben kapja meg a `BinaryStringConverter`-t.

[rating feedback=java-exceptionmulticatch-converter]
