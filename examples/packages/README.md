# Csomagok

## Csomagok célja

A Java nyelv alapegysége az osztály. Általában egy osztály egy fájlnak felel meg, 
de ez alól vannak kivételek. Ha nagyon sok fájlunk van, vagy vannak azonos nevűek, 
akkor azokat különböző könyvtárakba szervezzük azért, hogy könnyebben áttekinthetőek 
legyenek, könnyen megtaláljuk és differenciáljuk azokat. A Java nyelvben a _csomag_ 
(package) hasonló jelentőséggel bír, mint az operációs rendszerben a mappa, sőt, 
tényleges mappaszerkezetet jelent az operációs rendszerben.

Legfontosabb feladatai:  

* **Struktúrát ad a projektnek**: nagyobb projektek több száz, vagy akár több ezer 
osztályt is tartalmazhatnak. Ezeket pl. alkalmazás rétegek vagy funkciójuk szerint 
csoportosíthatjuk csomagok használatával.
* **Névütközés feloldása**: ha több azonos nevű osztály van, akkor ezeket megkülönböztetjük 
aszerint, hogy melyik csomagban vannak.
* **Szabályozza a láthatóságot**: a Java nyelvben az osztályok zártak, ami azt 
jelenti, hogy megadhatjuk, ki mit lásson belőle. Ha nem szabályozzuk, akkor a 
tagok alapértelmezett láthatósága csomag szintű, azaz az ugyanazon csomagban 
lévő más osztályok hozzáférhetnek az osztályunkban lévő tagokhoz.

## Csomagok használata

A `Scanner` osztály a `java.util` csomagban van.
Hiába deklarálunk egy `Scanner` típusú változót, a fordító nem fogja megtalálni, 
mert nem tudja, hol keresse. Ehhez meg kell mondanunk azt is, hogy melyik csomagban van. 
Ezt többféleképpen is megtehetjük.

Az első, hogy az osztály neve előtt megadjuk a csomagot is ponttal elválasztva: 
`java.util.Scanner`. Persze akárhányszor hivatkozunk a `Scanner` osztályra, mindig 
újra és újra így, teljes **minősített névvel** kell azt tennünk, ami hosszú és 
áttekinthetetlen kódhoz vezetne.

```java
public class NameReader {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("What's your name?");
        String name = scanner.nextLine();
        System.out.println(name);
    }

}
```

A második, hogy beimportáljuk az osztályt a fájlunkban közvetlen az osztály 
deklarációja fölé. Így ebben a fájlban bárhol használhatjuk pusztán 
osztálynévvel hivatkozva rá.

```java
import java.util.Scanner;

public class NameReader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        String name = scanner.nextLine();
        System.out.println(name);
    }

}
```

A harmadik, hogy beimportáljuk az adott csomagban lévő összes osztályt, így a 
`Scanner` osztályt is. Ebben az esetben minden, az importált csomagban lévő 
osztályra hivatkozhatunk kizárólag az osztály nevével. Ha egy csomagban lévő minden osztályt 
be szeretnénk importálni, akkor azt az osztálynév helyére tett `*` karakterrel 
jelölhetjük (_wildcard_).

```java
import java.util.*;

public class NameReader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        String name = scanner.nextLine();
        System.out.println(name);
    }

}
```

Leggyakrabban a második módszert használjuk, a harmadik pedig nem javasolt.

[important]
A Clean Code könyv szerint azonban inkább a wildcard használata javasolt, ugyanis 
ekkor nincs konkrét hivatkozás az osztályra, csak a csomagra, így a függőség 
lazább. Amennyiben sok osztály van, miért is akarnánk a kódot felesleges importokkal terhelni.
[/important]

Van azonban egy csomag, amelynek az osztályait importálás nélkül is elérjük, a 
`java.lang` csomag. Ebben található például a `System` és a `String` osztály is.
Mi van akkor, ha két ugyanolyan nevű osztályt szeretnénk használni? Az biztos, 
hogy ezek két különböző csomagban vannak, de ha mindkettőt importáljuk, akkor 
vajon melyikre gondolunk a kódban?

```java
import java.util.Date;
import java.sql.Date; // HIBA!!!

public class DateCalculator {

public static void main(String[] args) {
		Date date = new Date(); // Ez most melyik Date?
		// ...
	}

}
```

Ezt a Java fordító nem engedi, jelzi, hogy a kódunk hibás. Két választásunk van:

- az egyiket importáljuk, a másiknál minősített nevet használunk:

```java
import java.util.Date;

public class DateCalculator {

    public static void main(String[] args) {
        Date date;
        java.sql.Date sqlDate;
        // ...
    }

}
```

- mindkettő esetén teljes minősített nevet használunk:

```java
public class DateCalculator {

	public static void main(String[] args) {
		java.util.Date date;
		java.sql.Date sqlDate;
		// ...
	}

}
```

Hogy tudjuk megadni, hogy a mi osztályunk melyik csomagban van? A fájl első sora 
mindig a csomagdeklarációt tartalmazza.

```java
package business;

public class BusinessLogic {
    // ...	
}
```

Ha ez elmarad, akkor az osztályunk egy ún. *default package-be* kerül, ami a 
projektünk gyökérmappája. Ez nem javasolt, ezért mindig adjunk meg csomagnevet! 
Mivel nagyon sok cég fejleszt Java nyelven, és gyakran előfordul, hogy azonos 
osztályneveket használnak, ezért a javasolt csomagnév tartalmazza a domain nevet 
visszafelé. Például a Training360 domain neve `training360.com`, ezért használható lenne
a `com.training360` csomagnévként.

## Ellenőrző kérdések

* Mire használatosak a Java csomagok?
* Mi a csomag fizikai fájlrendszerbeli megfelelője?
* Hogyan hozunk létre új csomagokat?
* Hogyan használunk más csomagban lévő osztályokat?
* Hogyan kezeljünk a névütközést?

## Feladatok

### Köszöntés

Hozz létre a `packages.greetings` csomagban egy `Greeter` osztályt, melynek legyen
egy `public void sayHello()` metódusa, mely kiírja, hogy `Hello World!`.

### Köszöntés hívása

Hozz létre a `packages.main` csomagban egy `MainProgram` osztályt, melynek 
legyen egy `main()` metódusa. Ez hívja meg a `Greeter` `sayHello()` metódusát 
a következőképp:

```java
new Greeter().sayHello();
```

Ne feledd a `Greeter` osztály használatakor azt importálni!

### Bónusz feladat 1.

Nézd meg, hogy a csomagokba lévő osztályok a `target` könyvtárban
milyen könyvtárba kerülnek!

### Bónusz feladat 2.

Miért nem kell a `String` vagy az `Integer` osztály használatakor
`import` kulcsszót használni?

## Forrás

OCA - Chapter 1/Understanding Package Declarations and Imports

## Teszt

Milyen módosítással NEM lehet elérni, hogy az alábbi program leforduljon?

Account.java

```java
package account;
// 1
public class Account {
    //...
}
```

AccountManager.java

```java
package manager;
// 2
public class AccountManager {
    
    public static void main(String[] args) {
        Account account = new Account(500); // 3
        //...
    }
}
```

* A program lefordul, ha az `Account` osztályt a `manager` csomagba mozgatjuk.
* [x] A program lefordul, ha a `// 3` sort lecseréljük az `account.Account account = new Account(500);` szövegre.
* A program lefordul, ha `// 2`-es sorba elhelyezzük az `import account.*;` szöveget.
* A program lefordul, ha a `// 2`-es sorba elhelyezzük az `import account.Account;` szöveget.
