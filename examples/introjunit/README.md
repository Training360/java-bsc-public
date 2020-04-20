# Unit tesztelés JUnittal

A unit tesztelés célja az alkalmazás legkisebb egységének tesztelése. Ezért Javában 
unit tesztelni osztályokat szoktunk.

Törekedjünk arra, hogy a unit teszt legyen automatikus, megismételhető. Az alapkoncepció, 
hogy bízunk benne, hogyha a darabok hibátlanok, akkor az egész is az. Fontos, hogy 
a hibákat minél előbb megtaláljuk, és gondoljunk a szélsőséges esetekre is, így 
biztonságosabban tudjuk változtatni a kódot, hiszen amíg a unit teszt lefut, addig helyesen működik a program.

A unit teszt dokumentálja is a kódunkat, azaz kitalálható belőle egy osztály működése.

## JUnit

A JUnit egy keretrendszer Javában implementálva Java osztályok unit teszteléséhez. 
Egy JUnit teszteset általában három részből áll:

*	Given - adott állapot (általában példányosítunk)
*	When - meghívunk rajta egy metódust (metódus hívás)
*	Then – az történik-e, amit vártunk (objektum állapotának, vagy a metódus visszatérési 
értékének vizsgálata)

Utóbbit úgynevezett `assert`-ekkel tudjuk megtenni. Ezek csupán annyit vizsgálnak, 
hogy a visszaadott és érték megfelel-e az elvártnak. A _Hamcrest_ keretrendszer segít abban, 
hogy az objektumok vizsgálatát meg tudjuk valósítani, illetve az esetleges különbségeket 
emberibb formában jeleníti meg. A JUnitot támogatja a Maven, illetve az IDE-k is. 
Mavenben a tesztek az `src/test/java` mappában találhatóak és ezen belül a tesztelendő 
osztálynak megfelelő csomagban.

Példa teszt:

```java
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TrainerTest {
    @Test
    public void testCreate() {
        //Given
        Trainer trainer = new Trainer("John Doe");

        //When
        String name = trainer.getName();

        //Then
       assertThat(name, equalTo("John Doe"));

    }
}

```

A példa teszt leellenőrzi, hogy a `Trainer` objektum megfelelően jött-e létre, 
vagyis az-e a neve, amit konstruktorban átadtunk.

## Tesztlefedettség

A tesztlefedettség azt méri, hogy mely kódsorok futottak le a tesztek futtatása közben. 
Ezt az IDE-k is támogatják. Segít nekünk abban, hogy további teszteket írjunk az 
esetlegesen nem tesztelt kódrészletekre. Cél a minél nagyobb tesztlefedettség (kb. 80%).

## Mikor jó egy unit teszt?

Ahhoz, hogy igazán jó unit teszteket írjunk néhány szabályt be kell tartanunk.

* **A tesztesetek legyenek egymástól függetlenek.**  
Ha az egyik teszteset függ egy másik teszteset eredményétől, akkor nem tudhatjuk, hogy az 
adott funkció önmagában használva jól működik-e, illetve ha mindkét teszteset elbukik, akkor csak az 
egyik funkció működik rosszul vagy mindkettő. A tesztesetek függetlenségét biztosítja a JUnit azzal, hogy 
a különböző teszteseteket véletlenszerű sorrendben futtatja.
* **Egység teszt ne tartalmazzon külső függőséget**  
Ez nem azt jelenti, hogy a tesztelendő osztályon kívül semmilyen más osztályt nem tartalmazhat. Amiről 
már biztosan tudjuk, hogy jól működik, mert vagy a Java SE osztálykönyvtár vagy harmadik féltől 
származó library része, azt korlátlanul használhatjuk. Azonban a saját magunk által készített 
osztályokat helyettesítsük valamilyen **test double**-val, ami az eredeti interfészével rendelkezik, de annak 
valamilyen módon leegyszerűsített változata.
* **Minden esetre kell teszt, de ne vidd túlzásba**  
Az összes lehetséges esetre lehetetlen tesztet írni, de nem is szükséges. Partícionáljuk az 
eseteket a bemenet és/vagy az elvárt eredmény szerint! Ezután minden partícióból csak egy elemre írunk 
tesztet. Ha valamilyen szempont szerint rendezhetők az egy partícióba tartozó elemek, 
akkor a szélsőséges esetekre külön tesztet írunk.

## Ellenőrző kérdések

* Mire való a JUnit keretrendszer?
* Tipikusan hogyan épül fel egy teszteset?
* Hogyan támogatja a JUnit-ot a Maven?
* Hogyan támogatja a JUnit-ot az IDE?

## Feladat

### Első teszt implementálása

A `pom.xml` állományba vedd fel függőségként a JUnit keretrendszert `test` scope-pal!

```xml
<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

Hozz létre egy `introjunit.Gentleman` osztályt, melyben van egy `public String sayHello(String name)`
metódus, mely visszaad egy `String`-et, mely egy üdvözlő szöveg (`Hello `),
hozzáfűzve a paraméterként átadott név!

Létrehoztunk egy `introjunit.GentlemanTest` osztályt a teszt ágon, mely azt ellenőrzi, hogy `John Doe`
 nevet átadva a visszaadott szöveg valóban `Hello John Doe`.

### Hibás teszt

Rontsd el először a programot, hogy hibás üzenetet adjon vissza! Hogy jelzi a JUnit ezt? Rontsd el
a tesztesetet, hogy hibás legyen, amire ellenőriz! Hogyan jelzi ezt a JUnit a futtatáskor?

### Tesztlefedettség mérése

Implementáld, hogy ha a `sayHello()` metódus `null` paramétert kap, a visszaadott szöveg `Hello Anonymous` legyen!
Futtasd le a tesztlefedettség mérést, és nézd meg, hogy hogyan jelzi a fejlesztőeszköz, hogy az új ág nem lett lefedve!
Implementáld a megfelelő tesztesetet a `GentlemanTest` osztályban, és futtasd le újra a lefedettség mérést!

[rating feedback=java-introjunit-lefedettsegmeres]

### Bónusz feladat 1.

Hova fordítja le a teszt fájlokat a Maven? Hova teszi a tesztek futtatásáról a Maven a riportokat?
És mit tartalmaznak ezek?

### Bónusz feladat 2.

Hogyan lehet megoldani, hogy `mvn clean package` parancs kiadása esetén ugorja át a teszt esetek futtatását?

### Bónusz feladat 3.

Kik a JUnit fő fejlesztői? Milyen könyveket írtak, melyek hasznosak lehetnek a Java programozáshoz?

### Bónusz feladat 4.  Teszt eset futtatása parancssorból

Telepítsd fel a Maven legújabb verzióját a gépedre, és futtasd le a tesztesetet Mavennel parancssorból! 
Rontsd el a tesztelendő metódust, hogy más üzenetet adjon vissza! Hogy jelzi ezt a Maven futáskor?

## Teszt

Milyen rész nincs egy JUnit tesztesetben?

* Given
* [x] Apply
* When
* Then
