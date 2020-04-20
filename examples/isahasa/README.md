# is-a has-a kapcsolatok

## is-a reláció
Az _is-a_ kapcsolat azt jelenti, hogy egy objektum példánya saját osztályának és az összes ősének, és az összes interfésznek, melyet ezen osztályok implementálnak. Az `instanceof` operátorral kérdezhető le. Ez a kapcsolat _statikus_.

## has-a reláció

A _has-a_ kapcsolat azt jelenti, hogy egy osztály egy másik osztályra attribútumaként hivatkozik. Ezt _kompozíciónak_ is nevezzük. A kapcsolat dinamikus, tehát futás közben változtatható. Amit szokás megvizsgálni, az a számosság, azaz hogy egy adott osztályból hány példány kapcsolódhat az osztályunkhoz. A kötelezőség annak vizsgálata, hogy lehet-e olyan eset, hogy egyetlen példány sem kapcsolódik. Valamint az irány, hogy mely osztályból példányából tudjuk elérni a másik osztály példányát, azaz merről van hivatkozás a másik példányra.

## Öröklődés helyett kompozíció
Manapság a has-a reláció az elterjedtebb, ugyanis az dinamikus. Tehát inkább tartalmazási viszonyt fogalmazunk meg, mint leszármazottit. Ennek oka az újrafelhasználhatóság.

Mi alapján döntünk?

* Meg kell vizsgálni, hogy valóban is-a kapcsolatról van-e szó
* Tényleg bővítettük az osztályt?
* Csak a polimorfizmus ne használjunk is-a kapcsolatot, inkább interfészt használjunk.


## Ellenőrző kérdések

* Melyik operátorral tudjuk lekérdezni, hogy a referált objektum altípusa-e az adott típusnak?
* Hogyan implementáljuk az is-a relációt?
* Hogyan implementáljuk a has-a relációt?
* Miért jobb a has-a reláció az is-a relációnál?

## Feladat Html dekorátor

Feladat egy html objektum forrássá alakítása osztályokkal. Származtatással
a sima szövegből több szöveg is specializálódik vastag,  dőlt, aláhúzott.
Megnézzük öröklődéssel, majd utána tartalmazással (dekorátor minta használatával)

Deklarálj egy `TextSource` interfészt az `isahasa` csomagban, melyben csak egy metódus van: `String getPlainText()`.

Hozz létre egy `HtmlText` osztályt az `isahasa` csomagban, ami implementálja a `TextSource`
 interfészt.
 Egy `plainText` attribútumban tárolja a kívánt szöveget, melyet a konstruktorban kap meg.

 * a `getPlainText()` ebben az esetben csak visszaadja a tárolt szöveget.

Hozz létre egy `Channel` interfészt, ami csak egy metódust tartalmaz: `int writeByte(byte[] bytes)`

Szükség van még egy kliens osztályra, amely kap egy `TextSource`-ot és ráírja a csatornára a tartalmát.

* A csatornáját egy attribútumban tárolja.
* Konstruktorban megkapja a csatorna referenciát, amit eltárol az attribútumban.
* definiál egy publikus `writeToChannel` metódust, ami megkap egy `TextSource` referenciát. A paraméter
tartalmát lekéri a `getPlainText` metódussal, amit átalakít byte tömbbé (`String` osztálynak van ilyen metódusa), és ezzel hívja a
csatorna `writeByte` metódusát.

[rating feedback=java-isahasa-htmldekorator]

## Első megoldás származtatással

A `BoldHtmlText` a vastagon szedett szöveget megvalósító osztály az `isa` csomagban van, és a
`HtmlText`-ből származik.

* a konstruktorban megkapott szöveget a `super`-nek adjuk át, így inicializáljuk.
* a `getPlainText` `<b>` és `</b>` közzé fogja az ősben definiált `getPlainText` eredményét.


Hasonlóan kell megvalósítani a `ItalicHtmlText` osztályt, de ez a `<i>` és `</i>` tageket
használja. A `UnderlinedHtmlText` osztály az `<u>` és `</u>` tageket használja.
A `ItalicAndBoldHtmlText` a `<i><b>` és `</b></i>` tagek kombinációját használja.
A `UnderlinedAndItalicAndBoldHtmlText` a `<u><i><b>` és `</b></i></u>`
  tagek kombinációját használja.

Vegyük észre, hogy minden variációra külön osztály kell (pl.: vastagbetűs és aláhúzott és dőlt).

[rating feedback=java-isahasa-elsomegoldas]

## Második megoldás tartalmazással

Most oldjuk meg ezt a feladatot tartalmazással, a dekorátor minta segítségével.

Hozzunk létre egy `TextDecorator` abstract osztályt (a `hasa` csomagban), amely implementálja a konkrét dekorátoroknak
a tartalmazás kapcsolatot.

* A `TextSource` interfészt implementálja. (az előírt metódust nem definiálja
felül, ezért is lesz absztrakt)
* egy védett attribútuma van: `TextSource textSource`

`Bold` osztály (ami egy konkrét dekorátor a `hasa` csomagban) a `TextDecorator` osztályból származik.

* definiál egy konstruktort, amely megkap egy `TextSource` referenciát, amire beállítja az örökölt `textSource` attribútumot.
* implementálja az őstől kapott `getPlainText` metódust úgy, hogy a tartalmazott `textSource` referenciája meghívja a `getPlainText`
metódust, és az értéket közrezárja a `<b>` és `</b>` tag-ek közé. (Ez még nagyon hasonló a származás megoldásához.
Különbség az, hogy ott a `super`-en hívtuk meg a `getPlainText` metódusát, itt pedig az attribútumon.)

`Italic` osztály (ami egy konkrét dekorátor a `hasa` csomagban) a `TextDecorator` osztályból származik.

* definiál egy konstruktort, amely megkap egy `TextSource` referenciát, amire beállítja az örökölt `textSource` attribútumot.
* implementálja az őstől kapott `getPlainText` metódust úgy, hogy a tartalmazott `textSource` referenciája meghívja a `getPlainText`
metódust, és az értéket közrezárja a `<i>` és `</i>` tag-ek közé.

`Underlined` osztály (ami egy konkrét dekorátor a `hasa` csomagban) a `TextDecorator` osztályból származik.

* definiál egy konstruktort, amely megkap egy `TextSource` referenciát, amire beállítja az örökölt `textSource` attribútumot.
* implementálja az őstől kapott `getPlainText` metódust úgy, hogy a tartalmazott textSource referenciája meghívja a `getPlainText`
metódust, és az értéket közrezárja a `<u>` és `</u>` tag-ek közé.


Az előbbi dekorátorok létrehozásának paramétere lehet az alap `HtmlText`, de lehet bármelyik dekorátor is,
hiszen mindegyik implementálja a `TextSource` interfészt. Ezért a dőlt vastagbetűs szöveget a dekorátorok
láncolásásval megoldhatjuk, nem kell új osztály. Ugyanígy a többi variációra sem kell. Az előbbi dekorátorokkal azok
bármilyen kombinációja láncolható.

[rating feedback=java-isahasa-masodikmegoldas]

## Feladat - Flotta

A flottában vegyesen vannak teherszállító hajók (cargo ship),
személyszállító hajók (liner) és kompok (ferry boat). A
kompok személyeket és terhet is szállíthatnak.
Ha a flotta behajóz, akkor
folyamatosan töltik fel a hajókat, mindaddig, amíg meg nem telnek, el nem fogy az utas, vagy teher.

Hozz létre egy `Ship` interfészt, mely a hajót jelöli (marker interfész, metódus nélkül),
egy `CanCarryGoods` és `CanCarryPassengers` interfészt,
mely azt jelöli, hogy egy hajó tud-e személyeket, vagy
terhet szállítani.
A `CanCarryGoods` interfészben hozz létre egy `int loadCargo(int cargoWeight)` és
`int getCargoWeight()` metódust.
A `CanCarryPassengers` interfészben egy `int loadPassenger(int passengers)` és
egy `int getPassengers()` metódust.

A `CanCarryGoodsBehaviour` implementálja a `CanCarryGoods` interfészt.
Ennek az osztálynak két attribútuma van: `int cargoWeight` és `int maxCargoWeight`.
Implementáld a `loadCargo(int weight)` metódust, melynek paramétere a betöldendő rakomány súlya,
és a `weight` attribútumba eltárolja a letárolt rakományt, és visszatér a le nem tárolt
rakomány súlyával.

Vezessünk be egy `CanCarryPassengersBehaviour` osztályt, ami implementálja a `CanCarryPassengers` interfészt.
Ennek az osztálynak két attribútuma van: `int passengers` és `int maxPassengers`.
Implementáld a `loadPassenger` metódust, melynek paramétere a beszálló utasok száma, és
a `passengers` attribútumba letárolja a beszállt utasok számát, és
 visszatér a kintmaradó utasok számával.

A `Liner` osztály implementálja a `Ship` és a `CanCarryPassengers` interfészt, és legyen
 egy `CanCarryPassengers` típusú attribútuma.

A `CargoShip` osztály implementálja a `Ship` és a `CanCarryGoods` interfészt, és legyen
  egy `CanCarryGoods` típusú attribútuma.

A `FerryBoat` osztály implementálja a `Ship`, `CanCarryGoods`, `CanCarryPassengers` interfészt, és legyen
  mindkét típusú attribútuma.

Mindhárom osztálynak legyen olyan konstruktora, mely elvárja a `CanXxxBehaviour` osztályok
konstruktorában elvárt adatokat.

Minden szükséges (interfész által kikényszerített) metódust úgy implementálj, hogy delegáld a kérést a
megfelelő attribútum megfelelő metódusának.

Azaz pl. a `FerryBoat` osztály `loadCargo()` metódusa hívja a `CanCarryGoods` `loadCargo()` metódusát.

Készíts egy `Fleet` osztályt, melynek van egy `List<Ship>` attribútuma, mely a hajókat tartalmazza.
A `loadShip()` metódusa végigmegy a listán, és sorban feltölti a hajókat a személyekkel és terhekkel.
A maradék személyeket és terheket (melyek nem fértek el) a `waitingPersons` és `waitingCargo`
attribútumokban tárolja el. Ez utóbbiakhoz generálj getter metódusokat is.

[rating feedback=java-isahasa-flotta]
