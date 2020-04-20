# Polimorfizmus

## Statikus és dinamikus típus

A statikus típus az a típus, amellyel a változót deklaráljuk, a dinamikus típus pedig az, amellyel az adott objektumot példányosítjuk. A kettő megegyezhet, vagy a statikus típus lehet a dinamikus típusnak bármely ősosztálya, vagy olyan interfész amit a dinamikus típus implementál.

```java
String s = new String("Word"); // Statikus és dinamikus típus is String
Object o = new String("Word"); // Statikus típus Object, a dinamikus típus a String
```

A dinamikus kötés azt mondja meg, hogy mikor kerül eldöntésre, hogy az osztályhierarchiában metódus felülírás esetén melyik metódus kerül meghívásra. Javaban a dinamikus típus dönti el, futásidőben, hogy melyik metódus lesz érvényes.

## Polimorfizmus
A szó többalakúságot jelent, azaz egy példányosított objektum több formában is megjelenhet.

 Nyilvánvaló, hogy ezek közül az egyik az osztály, melyből példányosításra került (dinamikus típusa), de ezen kívül bármely ősosztályként is megjelenhet, akár `Object`-ként is, sőt bármely implementált interfaceként is. Minden esteben az `instanceof` operátor igazat fog visszaadni.

## Típuskényszerítés
Az osztályhierarchiában az „ős-felé” automatikus a típuskényszerítés, viszont másik irányba explicit módon nekünk kell megadnunk a típuskényszerítést.


## Ellenőrző kérdések

* Hol használjuk a statikus és dinamikus típus fogalmakat?
* Mit jelent a statikus és dinamikus típus?
* Mi teheti lehetővé azt, hogy a kettőnek nem kell megfelelnie egymásnak?
* Mit jelent a polimorfizmus?
* Mire és hogyan használható az `instanceof` operátor?
* Referencia típusok között milyen típuskényszerítés lehetséges?
