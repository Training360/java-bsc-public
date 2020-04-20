# Java platform

## Elmélet

A Java imperatív programozási nyelv, ahol az alkalmazás utasítások sorozatából áll.
Szöveges állomány a forráskód, melyet bájtkódra kell lefordítani. Ez a bájtkód
a Java futtatókörnyezet, a Java Virtual Machine (továbbiakban JVM) gépi kódja. A bájtkód gépi feldolgozása
sokkal gyorsabb és biztonságosabb, mint a forrás közvetlen feldolgozása, ezért
van szükség a fordításra.

A JVM felelős továbbá a platformfüggetlenségért is, ugyanis a bájtkódot másik platformra
átmásolva az azon a platformon lévő virtuális gép módosítás nélkül tudja értelmezni, ezáltal
elrejti a Java alkalmazás elől a tényleges platformot.

A Java programozási nyelv, a bájtkód szabvány, melynek különböző implementációi lehetnek.
A JVM leggyakrabban használt implementációját az Oracle (Sun felvásárlásával) biztosítja.
Ennek neve Java HotSpot utalva a JVM-ben implementált JIT-re (Just In Time Compiler).

A JVM-et az Oracle több csomagban biztosítja. A Java Runtime Environment (JRE)
csak a Java alkalmazás futtatásáért felelős, azonban a JDK további fejlesztőeszközöket
is tartalmaz, pl. a parancssori fordítót (`javac`).

[important]
A Java 11-es verziójában már nincs megkülönböztetve a JDK és JRE, a JRE-t már nem lehet külön letölteni.
[/important]

## Ellenőrző kérdések

* Hogyan történik a fejlesztési folyamat?
* Hogyan biztosítja a Java a platform függetlenséget?
* Milyen eszközök szükségesek Java fejlesztéshez?

## Feladat

### JDK telepítése

Ellenőrizd, hogy milyen JDK van telepítve a gépre parancssorban a `java -version` parancs kiadásával. Ha legfrissebb, 
akkor nincs további dolgod.
Amennyiben van fenn korábbi, mondjuk 8-as, akkor el kell távolítani (Windowson Programok telepítése és törlése.)

A JDK legutolsó verzióját le kell tölteni a https://www.oracle.com/technetwork/java/javase/downloads/index.html címről,
majd a varázslóval értelemszerűen feltelepíteni.

Állítsuk be a `JAVA_HOME` és `PATH` környezeti változókat, (Windows Speciális rendszerbeállítások)!
A `JAVA_HOME` értéke könyvtár, ahova a JDK telepítve lett, a `PATH` környezeti változó értéke `%JAVA_HOME%\bin` legyen.
Amennyiben már van `PATH` környezeti beállítás, a könyvtárakat pontosvessző (`;`) karakterekkel válasszuk el egymástól.

Sikeres telepítés és beállítás után parancssorba a `java -version` parancsot írva a következőt írja ki:

```
java version "12.0.1" 2019-04-16
Java(TM) SE Runtime Environment (build 12.0.1+12)
Java HotSpot(TM) 64-Bit Server VM (build 12.0.1+12, mixed mode, sharing)
```

Próbáljuk meg kiadni a `javac` parancsot is!

Hozzuk létre a `HelloWorld.java` állományt! Figyeljünk a kis- és nagybetűk közötti különbségekre!

```java
public class HelloWorld {

  public static void main(String[] args) {
    System.out.println("Hello World!");
  }

}
```

Fordítsuk le a `javac HelloWorld.java` paranccsal! Hatására létrejön a `HelloWorld.class` állomány.
Hexadecimális szerkesztőben megnyitva látható, hogy az első 8 bájt `0xCAFEBABE`.

Futtatni a lefordított állományt a `java HelloWorld` paranccsal lehet, mely hatására elindul a virtuális gép.

### Bónusz feladat 1

Nézz utána, hogy amennyiben megvan egy Java osztályod bájtkódja, vissza lehet-e azt fejteni Java
forráskóddá! (Az IDEA funkciói között is keresgélhetsz!)

### Bónusz feladat 2

Hozz létre egy `HelloArguments.java` állományt, mely kiírja a Java Virtual Machine-nek átadott paramétereket!
Nyomozd ki, hogy kell ezeket a paramétereket neki átadni.

## Teszt

Mi futtatja a Java bájtkódot?

* JDK
* JRE
* [x] JVM
* Java fordító

Hogyan lehet futtatni a `Calculator` osztályban elkészített Java programot?

* `javac Calculator.java`
* `java Calculator.class`
* `javac Calculator`
* [x] `java Calculator`

