# Saját kivétel

Saját kivétel implementálásánál először el kell tűnődni azon, hogy az adott kivétel nincs-e még implementálva, valamint azon, hogy biztosan kivételes eset keletkezik-e.

Csak `Exception`-t írunk `Error`-t nem, és azon belül is inkább a nem kezelendő kivétel írása az elterjedtebb. Miután ezeket átgondoltuk, jöhet a származtatás például a `RuntimeException` osztályból.


## Konvenciók
Egy kivételnél tipikusan két dolgot adhatunk meg. Az egyik egy üzenet, aminél fontos, hogy minél informatívabb legyen. A másik a kiváltó kivétel megadása.

A kivételek általában módosíthatatlanok, ezért tipikusan konstruktor(ok)ban inicializáljuk. A kiváltó kivétel már deklarálva van az ősosztályban ezért a konstruktorban  `super` hívással tudunk hivatkozni az ősben lévő konstruktorra, így nem kell tárolnunk a kiváltó kivételt és az üzenetet.

Példa:

```java
public class InvalideAgeException extends RuntimeException {

    private int parameterAge;

    private int minAge;

     public InvalideAgeException(String message, int parameterAge, int minAge){
         super(message);
         this.minAge = minAge;
         this.parameterAge = parameterAge;
     }

     public int getParameterAge() {
         return parameterAge;
     }

     public int getMinAge() {
         return minAge;
     }    
}
```


## Ellenőrző kérdések
* Milyen kivételfajták léteznek?
* Hogyan hozhatunk létre saját kivétel osztályokat?
* Miért hozzunk létre saját kivétel osztályokat?

## Gyakorlat - SimpleTime példa

Készíts egy `SimpleTime` osztályt, amely egyszerűsített időpont reprezentáló osztály.

* Lehet létrehozni óra és perc megadásával és lehet időpontot megadni "hh:mm" alakú String-el is.
* Legyen felüldefiniálva a `toString` úgy, hogy "hh:mm" alakú időt adjon.
* Legyen `getHour`, és `getMinute` metódusa is.

Hibakezelés:

Definiálj egy saját `InvalidTimeException`-t, amely `RuntimeException` leszármazott.
Dobjon `InvalidTimeException`-t "Hour is invalid (0-23)" szöveggel, ha a konstruktornak nem megfelelő óra értéket adnak meg.
Dobjon `InvalidTimeException`-t "Minute is invalid (0-59)" szöveggel ha a perc hibás.
Dobjon `InvalidTimeException`-t "Time is null" szöveggel ha null String-et adnak meg.
Dobjon `InvalidTimeException`-t "Time is not hh:mm", ha érvénytelen a String formátuma.

Készíts egy `Course` osztályt. A kurzusnak van neve (`name`) és kezdete (`begin`), ami `SimpleTime` típusú.
Legyen konstruktora, ahol megkapja az adatokat, legyenek getterei, valamint legyen felüldefiniálva a `toString`-je úgy,
hogy `hh:mm: kurzusnév` alakú legyen.

[rating feedback=java-exceptionclass-simpletime]

## Bank példa

Készíts egy `Bank` osztályt. A `Bank` számlákat (`Account`-okat) tárol egy listában.

* az `Account` listát konstruktorban tudja megkapni
* képes adott számlaszámú `Account` egyenlegét csökkenteni egy megadott összeggel,
* képes adott számlaszámú `Account` egyenlegét növelni

Egy `Account` attribútumai:

* számlaszám (`accountNumber`, `String`),
* egyenleg (`balance`, `double`) (a valóságban inkább `BigDecimal`, de most az egyszerűség kedvéért legyen `double`).
* max levonható összeg (`maxSubtract`, `double`)

Egy `Account` műveletei:

* példányosítás: számlaszám és egyenleg megadásával, a `maxSubtract` legyen 100000
* getterek
* setter a `maxSubtract` attribútumra
* `subtract`: egyenleg csökkentése egy megadott értékkel
* `deposit`: egyenleg növelése egy megadott értékkel

### Hibakezelés

Legyen egy `InvalidBankOperationException`, amely `RuntimeException` leszármazott és van egy `ErrorCode` attribútuma,
amely egy enum `LOW_BALANCE`, `INVALID_AMOUNT`, `INVALID_ACCOUNTNUMBER` konstansokkal.
Az `Account` és a `Bank` osztály dobjon ilyen kivételt a megfelelő értékkel inicializálva, ha

* nincs elegendő egyenleg a csökkentéshez,
* valamelyik metódusnak érvénytelen összeget adnak meg,
* a keresett számlaszám nincs meg

Dobj `IllegalArgumentException` kivételt, ha a `Bank` konstruktora `null` listát kap vagy az `Account` `null` számlaszámot.

[rating feedback=java-exceptionclass-bank]

## Bank példa más hibakezeléssel

A feladat ugyanaz, mint az előbb, de a hibakezelés eltér.
Legyen most minden hibafajtára külön hiba osztály, amely egy közös osztály leszármazottja.
Azaz legyen `InvalidBankOperationException` (a közös ős), valamint `InvalidAccountNumberBankOperationException`,
`InvalidAmountBankOperationException`, `LowBalanceBankOperationException`.

(Mik ezen megoldások előnyei, hátrányai?)

[rating feedback=java-exceptionclass-bankotherexceptions]
