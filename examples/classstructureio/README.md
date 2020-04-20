# Kiírás és beolvasás konzolról

A Java nyelv alap építőköve az osztály. Minden alkalmazás osztályokból épül fel. 
Tipikusan egy fájlba egy osztályt írunk, és a fájl neve meg kell egyezzen az 
osztály nevével. (Megj.: Ha több osztályt írunk egy fájlba, akkor csak egyetlen 
publikus osztály lehet benne, és ennek a neve kell megegyezzen a fájlnévvel.)

Sok osztályból álló alkalmazásnak csomagokkal tudunk belső struktúrát adni. A 
csomagok nem csak könnyebbé teszik az áttekintést, de az osztályok láthatóságát 
is szabályozzák.

Az osztály tagjai között vannak, amelyek adatokat tárolnak és vannak, amelyek 
utasításokat fognak össze. Ez utóbbiak a metódusok.

Az alkalmazáson belül azon osztályok futtathatóak, melyek tartalmaznak `main` 
metódust. Egy alkalmazásban akár több ilyen is lehet, azonban tipikusan egy 
szokott lenni, ez az alkalmazás fő belépési pontja, ezzel indítjuk el az 
alkalmazást. Azonban tanuláskor több osztálynak is készíthetünk `main` metódust, 
tesztelve osztályunk működését. A JVM a `main` metódust csak akkor találja meg, 
ha megfelel bizonyos szabályoknak. Nézzük, hogy kell kinéznie egy `main` 
metódusnak az osztályon belül:

```java
package hello;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

}
```

Ez az osztály futtatható, a `training` csomagban van és a fájl neve `HelloWorld.java`. 
Az osztály futtatásával a `main` metódusban lévő utasítások szépen sorban 
végrehajtódnak. A `HelloWorld` osztály esetében ez egyetlen egy utasítást jelent, 
mely a konzolra kiírja a `Hello World!` szöveget.

Az IntelliJ IDEA fejlesztőeszköz számos template-et tartalmaz a gyakran használt 
kódrészletek gyors legenerálására. Ezek a template-ek rövid szavakkal elérhetőek, 
melyek begépelése után a `Tab` billentyű lenyomására az elmenett kódrészlet 
jelenik meg. Ilyen például a `main` metódust legeneráló `psvm` rövidítés. 
A `System.out.println()` utasítás szintén elérhető template-ből a `sout` rövidítéssel. 
További template-eket találsz a _File / Settings..._ menüpont alatt megjelenő 
ablak _Editor/Live Templates_ lapján.

## Kommunikáció a felhasználóval

Az alkalmazások valamilyen felületen át kommunikálnak a felhasználóval. Az üzenetek 
megjelenítésének legegyszerűbb módja, ha azt a konzolra kiírjuk. Ezt 
a `System.out.println()` metódus hívásával tehetjük meg. A zárójelei között 
paraméterként a kiírandó üzenetet kell megadnunk. Ez legtöbbször szöveg, de lehet 
más típusú adat is.

Ha szeretnénk valamilyen adatot bekérni a felhasználótól, akkor azt a `Scanner` 
osztállyal tehetjük meg. Ehhez először példányosítanunk kell `new Scanner(System.in)` 
utasítással, és a kapott objektumot el kell tárolni egy változóban. Ezek után 
a `Scanner` objektum metódusait használva különböző típusú adatokat tudunk beolvasni.

* `nextLine()`: az `Enter` lenyomásáig bevitt szöveget olvassa be
* `nextInt()`: egész szám beolvasására használható

Egy szöveg beolvasható a következő kóddal:

```java
package hello;

import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What's your name?");
        String name = scanner.nextLine();
        System.out.println(name);
    }
}
```

A kód beolvassa a nevet, majd kiírja a konzolra. A nevet az IDEA-ban alul, 
a `Run` ablakban lehet megadni.

Mivel a `Scanner` osztály a `java.util` csomagban található, ezért importálni 
kell az osztály elején. Ezt nem szükséges beírni, hanem amikor az
osztály nevét (`Scanner`) írjuk a `main()` metódusban, akkor az IDEA felajánlja, 
hogy automatikusan beimportálja. Ehhez nyomjuk meg az `Alt + Enter`
billentyűkombinációt (amikor az osztály neve piros, és alá van húzva). 
Ekkor elhelyezi az IDEA az import utasítást az osztály elején a csomagdeklaráció
(`package`) alatt.

A következő példa azt is megmutatja, milyen műveleteket lehet végezni a `String` 
és `int` típusú értékekkel.

```java
package hello;

import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What's your name?");
        String name = scanner.nextLine();
        System.out.println("Hello " + name); // 1

        System.out.println("What's your year of birth?");
        int yearOfBirth = scanner.nextInt();
        System.out.println("Year of birth: " + yearOfBirth); // 2

        System.out.println(2019 - yearOfBirth); // 3
    }
}
```

Az `// 1` jelzéssel ellátott sor mutatja, hogy kell két karakterláncot összefűzni.
A `// 2` jelzéssel ellátott sor mutatja, hogy egy karakterlánchoz egy egész szám is
hozzáfűzhető. Ekkor a szám először automatikusan szöveggé kerül átalakításra.
A `// 3` jelzéssel ellátott sor mutatja, hogy lehet két egész számmal kivonás műveletet
elvégezni.

[important]
Egyszerűnek tűnik, ugye? Azonban akadhatnak problémák, amikbe előbb utóbb belefutsz.
A `nextInt()` nem olvassa be az Enter leütésével odakerült sortörés karaktert,
így az a következő `nextLine()` hívást megzavarja.
[/important]

Mire figyelj a `Scanner` használatakor: a `nextLine()` a teljes szöveget beolvassa, 
de a sorvége jelet eldobja, míg a `nextInt()` csak az első láthatatlan karakterig 
(pl. szóköz, sorvége jel) olvas, és azt ott hagyja. Éppen ezért, ha szám beolvasása 
után egy szöveget akarsz olvasni, akkor azt fogod tapasztalni, hogy ez a szöveg
üres lesz, és csak a második olvasás ad eredményt.

```java
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How old are you?");
        int age = scanner.nextInt();
        scanner.nextLine(); //Ez fogja az ottmaradt sorvége jelet beolvasni
        
        System.out.println("What's your name?");
        String name = scanner.nextLine();
        System.out.println(name);
    }
```

## Ellenőrző kérdések

* Hogyan lehet konzolról adatokat bekérni? Melyik osztályra van ehhez szükségünk? 
* Hogyan lehet a konzolra adatokat kiírni?

## Feladat

### Szorzógép

Készíts egy `Multiplier` osztályt! A `main` metódusban kérj be a felhasználótól 
két egész számot, majd írd ki a szorzatukat az alábbi formában: `5 * 4 = 20`!

### Regisztráció

Készíts egy `Registration` osztályt! A `main` metódusban kérd be a felhasználótól a
nevét és az email címét, majd jelezd vissza, hogy milyen adatokkal regisztrált!

## Teszt

A `Scanner` osztály melyik metódusa tud bármilyen szöveget beolvasni?

* [x] `nextLine()`
* `nextInt()`
* `nextDouble()`

Melyik utasítással lehet a konzolra kiírni a "Hello" szöveget?

* `System.in.writeln("Hello")`
* `System.out.writeln("Hello")`
* `System.in.println("Hello")`
* [x] `System.out.println("Hello")`

