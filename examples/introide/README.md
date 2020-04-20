# IDE

## Elmélet

Java fejlesztésre különböző fejlesztőeszközöket használunk, melyek ugyanúgy a JDK szolgáltatásaira épülnek, de grafikus
felhasználói felülettel rendelkeznek, és egyszerűbbé teszik a forráskód szerkesztését, a build folyamat futtatását,
és az alkalmazás tesztelését és elindítását.

A legelterjedtebb fejlesztőeszközök a NetBeans, Eclipse és IntelliJ IDEA. A NetBeans nyílt forráskódú, az Oracle berkeiben volt,
de nemrég átkerült az Apache szervezethez. Az Eclipse fejlesztése régóta az Apache szervezeten belül történik, szintén
nyílt forráskódú eszköz. A NetBeans egy kezdők számára jobban ajánlott eszköz, a különböző funkciók jobban integráltak, de
kevésbé testre szabhatóak. Az Eclipse inkább haladó fejlesztőknek javasolt, pluginekkel tetszőlegesen bővíthető, és
jobban testre szabható. Az IntelliJ egy fejlesztőeszközök gyártására szakosodott cég, és neki a kereskedelmi terméke az
IDEA, mely egy Java fejlesztőeszköz. Nagyon sok Javára épülő technológiát támogat. Két kiadása van, egy ingyen használható
Community és egy nagyvállalati fejlesztésre szánt kereskedelmi Ultimate verzió.

A fejlesztőeszköz alapvető fogalma a projekt. Egy projekt állományok összessége:
Java forrásállományok, erőforrás állományok stb. Létre lehet hozni új projektet,
vagy meg lehet nyitni már létező projektet.

Egy projekt típusa lehet különbőző, attól függően, hogy milyen eszközöket szeretnénk használni.

Egy projekten belül létre tudunk hozni fizikai elemeket, pl. könyvtárat, fájlt stb., de
létre hozhatunk logikai elemeket is, mint pl. Java osztály. Ez utóbbit létrehozva
a fejlesztőeszköz létrehozza a neki megfelelő fájlokat, esetleg könyvtárakat is.

A fejlesztő a legtöbb időt a kódszerkesztő ablakban tölti, mely különböző kisegítő
funkciókkal támogatja a forráskód írását, ilyen a kód színezése, vagy az automatikus
kódkiegészítés.

A projekt felépítését, fizikai elemeket (könyvtárakat, fájlokat), valamint
logikai elemeket (pl. osztályokat) a project ablak mutatja.

A fejlesztőeszköz lehetőséget biztosít a tesztesetek, és a projekt futtatására is.

Az IDEA fejlesztőeszköz képes a Maven kezelésére, azonban a saját projekt fogalma,
és a Maven projekt fogalma eltér. Ezért a kettőt szinkronizálja. Választhatunk,
hogy a fejlesztőeszköz automatikusan tegye ezt, vagy kérdezzen rá, és nekünk kell
a frissítést elvégezni, amennyiben módosítjuk a `pom.xml` állományt.

Fontos megjegyezni, hogy az IDEA-ban az `src/main/java` könyvtárnak
Sources Root-nak kell lennie, míg az `src/test/java` könyvtárnak
Test Sources Root könyvtárnak. Amennyiben a projekt megnyitásakor
ezek már léteznek, az IDEA felismeri ezeket. Amennyiben később kerülnek
létrehozásra, frissíteni kell a Maven konfigurációt. Ehhez a View / Tool Windows /
Maven Projects ablakot kell előhozni, és ott megnyomni a Reimport All Maven Projects
gombot.

Az IDEA leggyakrabban használt billentyűzet kombinációit a Help/Keymap reference
tartalmazza, mely egy nyomtatható PDF állomány.

A leghasznosabb a `Ctrl` + `Space`, ami automatikus kódkiegészítést végez, valamint
a `Alt` + `Enter`, mely a leggyakoribb hibákra próbál megoldási javaslatot adni.
Gyakran használt kódrészleteket nem kell mindig begépelni, hanem erre un.
code template-ek állnak a rendelkezésre. Ilyenkor egy rövidítést kell
beírni, majd a `Tab` billentyűt lenyomni. Pl. a `psvm` + `Tab`
a `main()` metódust generálja le, míg az `sout` + `Tab` a `System.out.println`
code template-je.

## Ellenőrző kérdések

* Milyen Java IDE-kről hallottál?
* Miben segít nekünk az IDE?
* Mi a fejlesztés alapegysége?
* Hogyan néz ki tipikusan a fejlesztés egy IDE-ben?
* Mondj néhány billentyűkombinációt!

## Feladat

### IDEA telepítése

Ellenőrizd, hogy az IntelliJ IDEA fejlesztőeszköz telepítve van-e a gépeden!
Az Asztalon, Tálcán, vagy a Start menüben meg kell jelennie.

Amennyiben nincs, az IDEA letölthető a https://www.jetbrains.com/idea/#chooseYourEdition
címről, és a Community verziót kell letölteni és feltelepíteni.

Érdemes a `C:\Java` könyvtárba telepíteni.

A telepítés történhet az alapértelmezett beállításokkal, azon módosítani nem
szükséges.

### Új projekt

Hozz létre egy új projektet `introide` néven, és hozz létre benne egy
`HelloWorld` osztályt, mely kiírja a `Hello World!` szöveget! Futtasd az
alkalmazást!

### Bónusz feladat

Állítsd be az IDE-t, hogy az alkalmazást parancssori paraméterekkel indítsa!
