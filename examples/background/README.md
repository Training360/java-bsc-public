# Java történeti háttér

## Elmélet

Szoftverkrízis fogalma már 1968-ban megjelent, mely a mai napig azt jelenti, hogy
minél több, komplexebb alkalmazás fejlesztésére van igény, lehetőleg egyre kevesebb
fejlesztői erőforrás igénybe vételével. Erre a problémára több megoldás is született
több-kevesebb sikerrel, és ezek között szerepelnek különböző programozási
paradigmák bevezetése, mint pl. objektumorientált programozás.

A Java nyelv 1991-ben a Sun titkos projektjeként született, James Gosling vezetésével.
A cél egy olyan programozási platform, mellyel hatékonyan lehet alkalmazásokat
fejleszteni olyan digitális eszközökhöz, mint pl. a televízió.
Az első megjelenése egy Mosaic böngészőbe épített Java motor, mely
egy molekulát forgatott három dimenzióban. Elképzelhető mekkora
újítás volt ez akkor, mikor a weboldalak fehér alapon fekete betűk voltak,
és az oldalakat kék színű linkek kötötték össze.

![James Gosling](images/477px-James_Gosling_2008.jpg)

A Java kifejlesztésekor a következő célkitűzéseket fogalmazták meg:

* Egyszerű, könnyen tanulható és használható
* Objektumorientált
* Robusztus, azaz hibatűrő, az alkalmazás fejlesztője, vagy használója által
vétett hiba ne befolyásolja a teljes rendszer működését, hanem kellően lokalizálható legyen
* Biztonságos, hiszen az internetről letöltött tartalmakban nem mindig lehet megbízni
* Architektúra-semleges, hordozható, azaz a megírt alkalmazás ugyanúgy fusson eltérő platformokon, mint Windows vagy Linux
* Nagyteljesítményű
* Interpretált, utasításonként végrehajtott
* Többszálúságot nyelvi szinten támogassa
* Dinamikus, azaz a futáshoz szükséges kódrészeket futás közben töltse be, mindig azt, amire szükség van

![Java logo](images/131px-Java_programming_language_logo.svg.png)

A Java jelenleg az Oracle céghez tartozik, a Sun megvásárlásával került oda. Elsődleges
felhasználási területe nagyvállalati háttérrendszerek (backend). Mobil környezetben is
találkozhatunk vele, hiszen az Android készülékekre először Javaban kellett fejleszteni.
Az Oracle biztosítja a fejlesztőkörnyezetet, a weboldaláról lehet letölteni Java Development Kit néven.
Ez tanulásra, fejleszésre ingyenesen használható.

[important]
A Google az Oracle-lel való jogi csatározások miatt Android területen kezd elfordulni a Java
programozási nyelvtől, és helyette a Kotlin programozási nyelvet javasolja.
[/important]

Felhasználói felületek fejlesztésére, számítógépre telepíthető, önállóan futó alkalmazások
fejlesztésére (kliens alkalmazások) a Java nem annyira alkalmas. Bár több technológia létezik, Swing, NetBeans Platform, Eclipse Platform, nem igazán terjedt el.
Főleg Java fejlesztőeszközöket implementálnak Java alkalmazásokként.

[important]
A JavaFX egy újabb technológia felhasználói felületek fejlesztésére. A Java 8-as fejlesztőkészletben jelent meg, azonban a Java 11-esből eltávolították. 
Eredetileg a Java részét képző Swing vastag kliens technológia leváltására jött létre.
[/important]


Java áll több IoT (Internet of Things - Internetre kötött eszközök), és Big Data megvalósítás mögött.
Az Oracle szerint jelenleg 10 millió Java fejlesztő van a világon és mintegy 15 milliárd Java kódot futtató eszköz.

A Java verziószámozása az újabb verziókban már konzisztens, a weboldalon letöltéskor megjelenő verziószám (pl. 12.0.1)
megegyezik azzal, amit a fejlesztőkörnyezet is kiír.

## További források

Java verziószámozását, és a különböző verziókban megjelenő újdonságot a
[Wikipedia](https://en.wikipedia.org/wiki/Java\_version\_history) részletesen taglalja.

## Ellenőrző kérdések

* Milyen megoldások születtek a szoftverkrízisre?
* Kinek a nevéhez kötődik a Java programozási nyelv?
* Mely cég vett és vesz részt a Java fejlesztésében?
* Milyen irányelveket vettek figyelembe a Java nyelv kialakításakor?
* Melyik a legfrissebb Java verzió?

## Bónusz feladat

* Nézz utána, hogy melyik szervezet felelős a Java alapú technológiákhoz kapcsolódó
szabványok karbantartásáért! Hogyan hívnak egy Java szabványt? Milyen lépésekből áll
a jóváhagyási folyamat? Tipikusan mikből áll egy Java szabvány?

## Teszt

Kit tekintünk a Java atyjának?

* Ryan Gosling
* [x] James Gosling
* Richard Gosling
* Jeremy Gosling

Mely cégek vettek/vesznek részt a Java fejlesztésében?

* Sun Microsystem, Miscrosoft
* IBM, Apache, Oracle
* [x] Sun Microsystem, Oracle
* Apache, Google, Oracle
