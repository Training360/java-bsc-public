# Metódus paraméterek

A metódus elején érdemes a paraméterek értékét ellenőrizni, mivel csak a számukat 
és típusukat ellenőrzi a fordító. Különösen vizsgálandó referencia változó 
átadásakor, hogy `null`-e az értéke, illetve csak bizonyos értékkészletből vehetnek 
fel értéket a paraméterek. Kerüljük a `boolean` típusú, illetve a jelzésre használt 
szám paramétereket, használjuk helyettük `enum`-ot, mert az sokkal jobban olvasható. 
Ha nagyon sok bemenő paraméter van, nehéz követni a sorrendjüket, akkor megfontolandó 
egy paraméterosztályt létrehozni, és azt átadni a metódusnak.

A metódusok csak egyetlen értéket tudnak visszaadni, ha többet szeretnénk, akkor azokat 
egy osztályba kell csomagolnunk, vagy esetleg több külön metódusba kell szerveznünk a 
feladatot. Amennyiben nincs mit visszaadnunk, például keresés esetén nincs találat, 
akkor a visszatérési érték lehet `null`, vagy jelezhetjük kivétel dobásával keresett 
elem hiányát. Amennyiben a metódus kollekcióval tér vissza, az `null` helyett inkább 
üres kollekció legyen.

## Ellenőrző kérdések
* Milyen ajánlásokat ismersz a metódusok paraméterére vonatkozóan?
* Mit teszel, ha egy metódusnak több értéket is vissza kéne adnia?
* Milyen ajánlásokat ismersz a metódusok visszatérési értékére vonatkozóan?

## Feladat

### Measurement osztály

Készíts egy `Measurement` osztályt, amely mérési eredményeket reprezentál.

* adatai: egy valós tömb, amely a mérési eredményeket tárolja.
* a mérési adatokat kapja meg konstruktor paraméterben
* legyen `int findFirstIndexInLimit(int lower, int upper)` metódusa,
amely visszaadja az első olyan mérési adat indexét, amely
a megadott határok közé esik. Adjon vissza -1-t, ha nincs ilyen adat.
* legyen `double minimum()` metódusa, amely a legkisebb mérési eredményt adja vissza.
* legyen `double maximum()` metódusa, amely a legnagyobb mérési eredményt adja vissza.
* legyen `ExtremValues minmax()` metódusa, amely a legnagyobb és a
legkisebb mérési ereményt adja vissza egy `ExtremValues` objektumban.

Az `ExtremValues` osztály egy egyszerű immutable adat transzfer osztály, amely `min` és `max` adatokat tárol,
konstruktorral állíthatóak be, és getter metódusokkal kérhetők le.

[rating feedback=java-methodparam-measurement]
