# JAR állomány

Egy Java alkalmazás több száz, vagy akár több ezer osztályból is állhat. Az alkalmazás 
terjesztése sokkal könnyebb, ha ezek valahogyan egységbe vannak foglalva. 
A JAR állomány tulajdonképpen a Java class fájlokat tartalmazza ZIP formátumba
összecsomagolva, megkönnyítve ezzel a teljes alkalmazás hordozását. JAR állomány 
készítését a Maven is támogatja. 

```
mvn clean package
```

A parancs hatására a Maven kitürli az előző fordítás eredményét (`clean`), majd 
újra fordítja az osztályokat és elkészíti a JAR állományt alapértelmezetten a 
`target` könyvtárba. Az összecsomagolt osztályok használatához a JVM-nek 
tudnia kell, hogy ezek hol vannak, azaz a JAR állományt hozzá kell adni a classpathhoz, 
és meg kell adnunk a futtatandó osztályt benne teljes minősített névvel.

```
java -classpath target\distjar-1.0-SNAPSHOT.jar distjar.HelloWorld
```

## Futtatható JAR állomány

Amennyiben az összecsomagolt osztályok között van `main()` metódust tartalmazó, akkor 
a JAR állomány önállóan futtatható is lehet. Ehhez szükséges, 
hogy maga a JAR állomány tartalmazzon hivatkozást a `main()` metódust tartalmazó 
osztályra, melyet a `pom.xml` állományban tudnunk konfigurálni.

```xml
<build>
    <plugins>
        <plugin>
            <artifactId>maven-jar-plugin</artifactId>
            <configuration>
                <archive>
                    <manifest>
                        <mainClass>distjar.HelloWorld</mainClass>
                    </manifest>
                </archive>
            </configuration>
        </plugin>
    </plugins>
</build>
```

A futtatáshoz szükséges információkat a `META-INF/MANIFEST.MF` fájl tartalmazza. 
Ebben az esetben az alkalmazás a `-jar` kapcsolóval indítható.

```
java -jar target\distjar-1.0-SNAPSHOT.jar
```

Amennyiben a teljes alkalmazás több JAR állományból áll, akkor az összes JAR-t a 
classpathra kell tenni.


## Ellenőrző kérdések

* Mire valók a JAR állományok?
* Hogyan épülnek fel a JAR állományok?
* Hogyan lehet futtatni egy JAR állományban lévő `main()` metódusban lévő osztályt?
* Hogyan lehet futtathatóvá tenni egy JAR állományt?

## Feladat

### JAR állomány készítése

Hozz létre egy `Main` osztályt `main()` metódussal, mely "Hello User!" szöveggel üdvözli a felhasználót!

Készíts JAR-t az alkalmazásból az `mvn clean package` parancs kiadásával!

### Futtatható JAR állomány készítése

A `pom.xml` állományt egészítsd ki a következővel:

```xml
<build>
    <plugins>
        <plugin>
            <artifactId>maven-jar-plugin</artifactId>
            <configuration>
                <archive>
                    <manifest>
                        <mainClass>distjar.Main</mainClass>
                    </manifest>
                </archive>
            </configuration>
        </plugin>
    </plugins>
</build>
```

Készíts JAR-t az alkalmazásból az `mvn clean package` parancs kiadásával!
Mivel módosult a létrejött JAR állomány?

A JAR állomány futtatható a `java -jar target\distjar-1.0-SNAPSHOT.jar`
paranccsal, vagy paraméterezve: `java -jar target\distjar-1.0-SNAPSHOT.jar Doe`.

### Bónusz feladat 1.

Tömörítsd ki a JAR állományt Maven használata nélkül parancssorból, a `jar`
parancs használatával!

### Bónusz feladat 2.

Tömörítsd be a JAR állományt Maven használata nélkül parancssorból, a `jar`
parancs használatával! A `target/classes` könyvtár tartalmát kell betömöríteni.

### Bónusz feladat 2.

Készítsd el a JAR állományt Maven használata nélkül parancssorból úgy, hogy futtatható legyen!

## Teszt

Hogyan készíthetünk futtatható JAR állományt Mavennel?

* Parancssorból kiadjuk az `mvn clean package runnable distjar.GentlemanMain` parancsot, 
ahol a `distjar` a projekt neve, a `GentlemanMain` pedig a `main()` metódust tartalmazó 
osztály neve.
* Parancssorból kiadjuk a `java -jar target\distjar-1.0-SNAPSHOT.jar` parancsot
* [x] Kiegészítjük a `pom.xml` állományt egy `build` elemmel, mely a konfigurációt tartalmazza, 
majd parancssorból kiadjuk az `mvn clean package` parancsot.
* Kiegészítjük a `pom.xml` állományt egy `build` elemmel, mely a konfigurációt tartalmazza, 
majd parancssorból kiadjuk a `java -classpath target\distjar-1.0-SNAPSHOT.jar` parancsot.

