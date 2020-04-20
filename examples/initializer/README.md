# Inicializátorok

Inicializátornak hívjuk az osztályba írt név nélküli blokkot, mely ugyanúgy utasításokat tartalmaz, mint a metódusok. Feladatuk az osztály változóinak inicializálása. Jogosan felmerülhet a kérdés, hogy miért van erre szükség, amikor ezeket akár a deklaráció sorában, akár a konstruktorban megtehetjük. Valóban nagyon ritkán használjuk, de mégis van létjogosultsága. A statikus inicializátorban (`static` kulcsszó előzi meg) található kód az osztály betöltődésekor, a nem statikus inicializátorban található példányosításkor, még a konstruktor előtt lefut. Statikus attribútumok értékének megadására, ha azok bonyolultan állíthatóak csak elő, használhatunk statikus metódusokat. (Például véletlenszámot kell generálnunk, vagy ciklussal kell feltöltenünk egy kollekciót, esetleg közben kivételt is kezelnünk.) Statikus inicializátort akkor használunk, ha egyszerre több statikus attribútum értékét akarjuk kiszámolni. A nem statikus inicializátor anonymous belső osztályok esetén használható jól, mivel ezekhez nem tudunk konstruktort írni, lévén nincs nevük.

Egy osztály akár több inicializátort is tartalmazhat, ebben az esetben a deklaráció sorrendjében futnak le.

```java
public class Lottery {

    public static final Set<Integer> numbers;

    static {
        Set<Integer> draws = new TreeSet<>();
        Random rnd = new Random();
        while(draws.size() < 5) {
            draws.add(rnd.nextInt(90) + 1);
        }
        numbers = draws;
    }
}
```



## Ellenőrző kérdések

* Mikor hajtódik végre a statikus inicializáló blokk?
* Mikor hajtódik végre a példányszintű inicializáló blokk?
* Az osztály mely elemeire hivatkozhat a statikus inicializáló blokk?
* Mondj néhány példát, amikor a statikus inicializáló blokk használata célszerű!

## Gyakorlat - Hitelkártya használat

A `CreditCard` osztály egy hitelkártyát reprezentál, amelyet a létrehozásakor adott összeggel
"feltöltenek" és ebből tudunk gazdálkodni. A feltöltés forintban vagy tetszőleges valutában
történhet, ezt a feltöltés során forintra konvertálja a rendszer.

A kiadás `payment()` többféle valutában is lehetséges,
ezeket a rendszer egész forintra konvertálja és így terheli meg a kártyát. Ha nem adunk meg valutát,
automatikusan forintnak veszi a terhelést.

A hitelkártya "használatba vételekor" (`CreditCard` osztály betöltése)
az aktuális átváltási faktorok (`Rate`) feltöltésre kerülnek a `CreditCard` osztályba,
egy statikus final listába (statikus inicializálás).

konstruktorok:
```java
public CreditCard(long balance, Currency currency)
public CreditCard(long balance)
```

publikus metódusok:
```java
public long getBalance()
public boolean payment(long amount, Currency currency)
public boolean payment(long amount)
```

A `Rate` osztály az egyes valutákhoz (`Currency` enum) tartozó átváltási faktorokat tárolja,
ezek listájából dolgozik a `payment()` metódus.
Hozzuk létre a `Currency` enum-ot is HUF, EUR, SFR, GBP, USD értékekkel!

konstruktor:
```java
public Rate(Currency currency, double conversionFactor)
```
publikus metódusok:
```java
public Currency getCurrency()
public double getConversionFactor()
```
[rating feedback=java-initializer-creditcard]
