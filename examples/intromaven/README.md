# Maven

## Elmélet

Sajnos a Java platform nem biztosít standard projekt struktúrát, ezért a nyelv
megjelenésekor minden projekt máshogy épült fel, más könyvtárakba csoportosították
az alkalmazás felépítéséhez szükséges állományokat. A Java források fordításával,
az így előállt bájtkód és az alkalmazás futtatásához szükséges egyéb állományok
(un. erőforrás állományok) összecsomagolásával jön létre maga az alkalmazás. Ezt
a folyamatot nevezzük build folyamatnak.

A Maven egy kvázi szabványos eszköz a build folyamat megvalósításáért. Ezen kívül
kezeli a függőségeket, hiszen egy alkalmazás fejlesztésekor számos más szervezet és
gyártó által használt nyílt és zárt forráskódú könyvtárat használunk. Ennél
azonban többnek definiálja magát a Maven, un. software project management and comprehension tool.
Betartja a Convention over configuration elvet, ami azt jelenti, ha a konvencióknak
(megállapodásoknak) megfelelően járunk el, akkor az eszközt nem kell konfigurálni,
hanem a build folyamatban az előzetes megállapodásoknak megfelelően fog eljárni.
Ez gyakorlatban annyit tesz, ha a fájlokat a megfelelő könyvtárakban helyezzük el,
akkor különleges konfiguráció nélkül lefut a build folyamat, lefordításra kerülnek
a forrás állományok, és összecsomagolásra az alkalmazás.

A build folyamat tehát általában a következő nagyobb lépésekből áll:

* Forrás állományok fordítása
* Többi, ún. erőforrás állomány kezelése
* Teszt esetek futtatása
* Alkalmazás összecsomagolása

A Maven projektet a `pom.xml` állomány írja le. A különböző állományokat konvenció
szerint a következő könyvtárakba kell elhelyezni:

* `src\main\java` Java forráskódok
* `src\main\resources` Erőforrás állományok
* `src\test\java` Teszt esetek, nem része az alkalmazásnak
* `src\test\resources` Teszt esetekhez szükséges egyéb erőforrás állományok, nem része az alkalmazásnak

A következő példa bemutat egy minimális `pom.xml` állományt.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.training360.yellowroad</groupId>
    <artifactId>intromaven</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <name>${project.artifactId}</name>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>12</maven.compiler.source>
        <maven.compiler.target>12</maven.compiler.target>
    </properties>

</project>
```

Ebben szerepelnek a projekt koordinátái, melyek egyedileg azonosítják a projektet,
úgymint `groupId`, `artifactId`, `version`. Érdemes még megadni a karakterkódolást,
hiszen a fájl önmaga nem tartalmazza, hogy milyen karakterkódolással íródott a
forráskód. Tartalmaznia kell, hogy mely Java verzióval kompatibilis a forrás,
és mely Java verzióra legyen fordítva.

A `pom.xml` állományban kell definiálni a függőségeket is. Az alábbi példa egy
JUnit függőséget definiál, ugyanúgy meg kell adni a projekt koordinátáit.

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

## Ellenőrző kérdések

* Mire használjuk a Maven-t?
* Tipikusan hogyan épül fel egy build folyamat?
* Hogyan épül fel egy projekt könyvtár szinten?
* Mi ír le egy projektet? Milyen elemek találhatók benne?

## Feladat

### Maven telepítése

Töltsd le a legfrissebb Maven Binary zip archive állományt a https://maven.apache.org/download.cgi címről,
majd a letöltött `.zip` állományt tömörítsd ki a `C:\Java` könyvtárba!

A fájl neve pl. `apache-maven-3.6.0-bin.zip`.

Vedd fel az `M2_HOME` környezeti változót, melynek értéke az a könyvtár, ahova
a Maven ki lett csomagolva (példánkban `C:\Java\apache-maven-3.6.0`),
és vegyük fel a `PATH` környezeti változóba a `%M2_HOME%\bin` értéket is, pontosvesszővel
(`;`) elválasztva!

A telepítés és beállítás sikerességét a `mvn -version` parancs kiadásával ellenőrizzük!
Valami hasonlót fog kiírni:

```
Apache Maven 3.6.0 (97c98ec64a1fdfee7767ce5ffb20918da4f719f3; 2018-10-24T20:41:47+02:00)
Maven home: c:\Java\apache-maven-3.6.0\bin\..
Java version: 10.0.1, vendor: Oracle Corporation
Java home: C:\Java\jdk-11.0.1
Default locale: hu_HU, platform encoding: Cp1250
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```

### Első Maven projekt

Hozzunk létre egy `pom.xml` állományt a következő tartalommal:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.training360</groupId>
    <artifactId>intromaven</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>12</maven.compiler.source>
        <maven.compiler.target>12</maven.compiler.target>
    </properties>

</project>
```

Majd az `src/main/java` könyvtárban hozzunk létre egy `HelloWorld.java` állományt
a következő tartalommal:

```java
public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }
}
```

Majd adjuk ki az `mvn clean package` parancsot! A `target/classes` könyvtárban
létrejön a `HelloWorld.class` állomány. Ez futtatható a következő paranccsal
a projekt könyvtárában: `java -classpath target\classes HelloWorld`.

### Új állomány elhelyezése

Helyezzük el a `HelloArguments.java` állományt, mely kiírja a paraméterként átadott
értékeket a megfelelő könyvtárban, hogy a `mvn clean package` parancs hatására
az is leforduljon, majd futtassuk is a megfelelő parancccsal!

### Bónusz feladat 1.

Milyen lépésekből áll egy Java projekt Maven életciklusa? Milyen utasításokat adhatunk ki, ha csak fordítani akarunk?
Ha csak teszteket akarunk futtatni, akkor megtörténik a fordítás is?

### Bónusz feladat 2.

Miért olyan kicsi a Maven telepítőkészlete? A függőségeket a Maven hova helyezi el a saját gépen?

### Bónusz feladat 3.

Mi az a `-classpath` kapcsoló, melyet paranccsorban átadtunk a JVM-nek futtatáskor?

## Teszt

Maven alkalmazása esetén konvenció szerint melyik könyvtárba kerülnek az alkalmazás forráskódjai?

* [x] `src\main\java`
* `src\java\main`
* `src\test\java`
* `src\java\test`

Melyik állomány írja le egy Maven projekt tulajdonságait?

* `mvn.java`
* `properties.mvn`
* [x] `pom.xml`
* `pom.java`

