# Metódusok

Az objektumok nem csak adatokat, utasításokat is tartalmazhatnak, melyeket 
a **metódusok** tartalmazzák. A metódusok feladata az objektum 
attribútumainak módosítása vagy azok lekérdezése. Ezzel tulajdonképpen pontosíthatjuk 
az osztály definícióját: az osztály a modell tulajdonságainak (attribútumok) és 
műveleteinek (metódusok) az összessége.

Egy metódus készítésekor meg kell adnunk, hogy mi legyen a visszatérési típusa, 
a metódus neve, valamint zárójelek között a paraméterek listája. Mivel a Java 
erősen típusos nyelv, minden paraméter esetén meg kell adni annak típusát is. 
Visszatérési típust akkor is kötelező megadnunk, ha a metódus nem ad vissza értéket. 
Ebben az esetben a `void` szót kell megadnunk.

A metódus az attribútumokon kívül csak azokhoz az adatokhoz fér hozzá, amit 
paraméterként megkap, vagy lokális változóként benne deklarálunk. Előfordul, 
hogy a paraméterként kapott változó neve ugyanaz, mint az attribútumé. Ekkor 
úgy lehet megkülönböztetni őket, hogy az attribútum elé kitesszük a `this` minősítőt.

Fontos objektumorientált alapelv, hogy az attribútumokhoz nem engedünk közvetlen 
hozzáférést kívülről, azokat mind lekérdezni, mind módosítani csak metóduson át 
lehet. Ez az **information hiding** alapelv. De hogyan tudjuk ezt elérni? A 
tagok láthatóságát módosító szavakkal szabályozhatjuk, melyet mindig a legelső 
helyen kell megadni.

* `public` - minden osztályból látható, elérhető
* `private` - csak az adott osztályon belül látható, érhető el

Javában az alapértelmezett láthatóság a package private, azaz azonos csomagon 
belül más osztályokból is elérhető a tag. Ekkor semmilyen módosítót nem használunk.

```Java
public class Trainer {
    
    private String name;
    
    private int yearOfBirth;
    
    public String getNameAndYearOfBirth() {
        return name + ": " + yearOfBirth;
    }
    
    public int getAge(int year) {
        return year - yearOfBirth;
    }
    
    public void changeName(String name) {
        this.name = name;
    }
    
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
    
}
```

Egy másik osztályból már csak a `Trainer` metódusait érhetjük el, az attribútumait nem.

```java
public class TrainerMain {
    
    public static void main(String[] args) {
        Trainer trainer = new Trainer();
        trainer.changeName("John Doe");
        trainer.setYearOfBirth(1980);

        String nameAndYearOfBirth = trainer.getNameAndYearOfBirth();
        int age = trainer.getAge(2019);
    }
}
```

Nagyon gyakran használunk olyan metódusokat, amelyek egyetlen attribútum értékét 
lekérdezik, illetve módosítják. A lekérdező metódus neve **getter**, a módosítóé 
**setter**. Ezeket az IDEA fejlesztőeszközzel nagyon könnyen előállíthatjuk: 
jobb klikk a szerkesztőben, majd *Generate...*(vagy `ALT + Insert` billentyűkombináció), 
azon belül *Getter and Setter* pont. Miután kiválasztottuk azokat az attribútumokat, 
amelyekhez szeretnénk gettert és settert generálni, az IDEA automatikusan beszúrja 
ezek kódját az osztályba.

## Ellenőrző kérdések

* Mi a feladata a metódusoknak?
* Milyen részei vannak a metódus deklarációjának?
* Mik azok a getter és setter metódusok?

## Feladat

### Ügyfél osztály

Hozz létre egy `Client` osztályt, melynek három `private` attribútuma van: 
név (`name`), születési év (`year`) és cím (`address`). Típusaik rendre 
`String`, `int` és `String`!

Mind a három attribútumra legyen lekérdező és módosító metódus! Legyen egy
`public void migrate(String address)` metódusa is, mely az ügyfél elköltözését
implementálja, valójában beállítja a tárolt címet az új, paraméterként átadott címre.

Hozz létre egy `main()` metódust egy `ClientMain` osztályban, amelyben kipróbálod 
az osztály működését! Példányosítani kell egy objektumot a `Client` osztály alapján, majd
be kell állítani az attribútumai értékét.
Írd ki konzolra az összes adatát, majd hívd meg a `migrate()` metódust egy másik címmel!
Jelezd vissza a felhasználónak a címváltozás sikerességét úgy, hogy kiírod az 
eltárolt új címet!

### Jegyzeteljünk

Készíts egy `Note` osztályt, melyben a felhasználó rövid szöveges jegyzetét 
tárolod. Tárolni kell a felhasználó nevét (`name`), a jegyzet témáját (`topic`) 
és szövegét (`text`). Fejlesztés során ezentúl mindig tartsd be az information 
hiding elvet, azaz az attribútumok legyenek privátak, és ha szükséges, készíts 
hozzájuk gettereket és settereket! Készíts egy `getNoteText()` metódust, mely az 
osztály attribútumai alapján egyetlen szöveget ad vissza `name: (topic) text` formátumban!

Teszteld az osztályod a `NoteMain` osztály `main()` metódusából! A `Note` tartalmának
megjelenítésekor használd a `getNoteText()` metódust!

## Forrás

OCA - Chapter 1/Understanding the Java Class Structure, Writing a main() Method

## Teszt

Igaz-e? A getter metódusok az osztály azon tagjai, melyek beállítják az 
attribútumok értékét.

* igaz
* [x] hamis

Mi a visszatérési típusa annak a metódusnak, amely nem ad vissza semmilyen értéket?

* `main`
* `setter`
* [x] `void`
* `getter`

Mi történik, ha egy metódus paraméter neve megegyezik egy attribútum nevével?

* A metódusban csak az attribútumhoz lehet hozzáférni, a paraméterhez nem.
* [x] A metódusban mind a paraméterhez, mind az attribútumhoz hozzá lehet férni, 
az attribútumhoz a `this` minősítővel.
* A metódusban csak a paraméterhez lehet hozzáférni, az attribútumhoz nem.
* A metódusban mind a paraméterhez, mind az attribútumhoz hozzá lehet férni, 
a paraméterhez a `this` minősítővel.

