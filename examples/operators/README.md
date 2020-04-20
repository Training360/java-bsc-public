# Operátorok

Az operátorok kifejezésekben szerepelnek. Például:

```java
int num = 3;
int result = num + 2;
```

Itt a `num` és `2` az operandus a `+` és a `=` pedig az operátor. Egy kifejezésben 
több operátor is szerepelhet. Ilyenkor nem mindegy, hogy milyen sorrendben értékeljük ki őket, 
ezért először nézzük meg ezt.

## Operátorok kiértékelési sorrendje

*	Először a belső zárójel tartalma
*	Ha nincs zárójel, akkor a nagyobb precedenciájú operátor
*	Egyenlő precedencia esetén balról jobbra, értékadás esetén jobbról balra

### Precedenciatáblázat

*	Postfix operátor (`kifejezés++`, `kifejezés--`)
*	Prefix operátor (`++kifejezés`, `--kifejezés`)
*	További egyoperandusú operátorok (`+`,` -`, `!`)
*	Multiplikatív operátorok (`*`, `/`, `%`)
*	Additív operátorok (`+`, `-`)
*	Léptető műveletek (`<<`, `>>`, `>>>`)
*	Összehasonlítás (`<`,` <=`,` >`, `>=`)
*	Egyenlőségvizsgálat (`==`, `!=`)
*	Bitenkénti (`&`, `^`, `|`)
*	Logikai (`&&`, `||`)
*	Feltételes kifejezés (`? :`) - _Figyelem! Három operandusú!_
*	Értékadások (`=`, `+=`, `-=`, `*=`, `=`, `>>=`, `<<=`, `>>>=`, `&=`, `^=`, `|=`)

A precedencia az operátorok erősségét jelzi. Nem érdemes megjegyezni a precendencia 
táblázatot, inkább használjunk helyette megfelelő zárójelezést.

## Léptető műveletek

A léptető műveletek bináris műveletek, tehát érdemes ismerni az adott szám bináris 
reprezentációját. Nézzünk ehhez néhány metódust!

* `Integer.toBinaryString()`  a számot átváltja kettes számrendszerbe.
* `Integer.parseInt(String, int)` a megadott számrendszerben ábrázolt reprezentációból 
adja vissza az adott számot. Ha a második paraméter 2, akkor a bináris reprezentációból 
alakít számmá.

Léptető operátorok:

* `a >> b`: az `a` bitjeit jobbra lépteti `b`-szer, balról ugyanolyan bitekkel tölti fel, 
amilyen az eredeti bal szélső bit volt.
* `a << b`: az `a` bitjeit balra lépteti `b`-szer, jobbról 0 bitekkel tölti fel a helyeket.
* `a >>> b`: az `a` bitjeit jobbra lépteti `b`-szer, balról 0 bitekkel tölti fel a helyeket.

Például a 9 binárisan 1001.

```java
String number = Integer.toBinaryString(9); // Eredmény  "1001"
number = Integer.toBinaryString(9 >> 1); //// Eredmény  "100"
number = Integer.toBinaryString(9 << 1); //// Eredmény  "10010"
number = Integer.toBinaryString(Integer.MIN_VALUE); //// Eredmény  "10000000000000000000000000000000"
number = Integer.toBinaryString(Integer.MIN_VALUE >> 1); //// Eredmény  "11000000000000000000000000000000"
number = Integer.toBinaryString(9 >>> 1); //// Eredmény  "01000000000000000000000000000000"
```

## Bitenkénti operátorok

Boolean értékek esetén logikai műveletek, egész számok esetén a bináris reprezentáció 
minden bitjére végrehajtja a műveletet.

* Az ÉS (`&`) eredménye csak akkor 1, ha minden operandus 1
* A VAGY (`|`) eredménye csak akkor 0, ha minden operandus 0
* A KIZÁRÓ VAGY (`^`) eredménye csak akkor 1, ha az operandusok eltérnek

Például:

```text
  1110010011110101
& 0011111001111011
  ----------------
  0010010001110001
  
  1110010011110101
| 0011111001111011
  ----------------
  1111111011111111
  
  1110010011110101
^ 0011111001111011
  ----------------
  1101101010001110
```

## Logikai operátorok

*	Az ÉS (`&&`) eredménye csak akkor `true`, ha minden operandus `true`
*	A VAGY (`||`) eredménye csak akkor `false`, ha minden operandus `false`

## Rövidzár kifejezés

Tudjuk például a VAGY műveletnél, hogy ha a baloldali operandus értéke `true`, 
akkor az egész kifejezés értéke is az, így a jobb oldali operandust nem kell kiértékelni. 
Ha a baloldali kifejezés értéke `false`, akkor természetesen zajlik tovább a kiértékelés. 
Nézzük meg példán keresztül a `||` és a `|` operátorok közötti különbséget!

* `true || (1/0 == 0)` kifejezés értéke `true`
* `true | (1/0 == 0)` kifejezés kiértékelése közben `java.lang.ArithmeticException` keletkezik "/ by zero" üzenettel

Természetesen ugyanez elmondható a `&&` és az `&` műveletekre. Első esetben ha a kifejezés 
baloldala `false`, akkor az egész kifejezés hamis, míg a bitenkénti operátornál az 
egész kifejezés kiértékelésre kerül.

## Értékadás

Az értékadásnak is van eredménye, a bal oldali változóba kerülő érték, így ez is használható operandusként.

## Ellenőrző kérdések

* Nézd át egyesével az operátorokat! Melyik mire való? Hogyan működik?
* Mi a különbség a bitenkénti és logikai operátorok között?
* Mit jelent a rövidzár kifejezés?

## Feladat
 
### Páros szám

A `operators.Operators` osztályba dolgozz, a teszteléseket viszont az 
`operators.OperatorsMain` osztály `main()` metódusában végezd!

Hozz létre egy `boolean isEven(int n)`
metódust, mely visszaadja, hogy a paraméterként átadott egész szám páros-e!

[rating feedback=java-operators-parosszam]

### Léptető operátorok

Milyen matematikai műveletnek felel meg a jobbra vagy balra léptetés? Próbáld ki, 
hogy mi történik, ha a 16-ot lépteted jobbra vagy balra! És ha a 13-at?

Hogyan lehetne léptetésekkel megvalósítani a szorzást? Készíts egy `multiplyByPowerOfTwo()` metódust 
az `Operators` osztályba, amely az első paraméterként kapott számot megszorozza 
2-vel annyiszor, amennyi a második paraméter. (Ne használj ciklust, csak léptető operátort!)

### Bónusz feladat

Miért ad a következő kódrészlet kivételt?

```java
int i = -1;
String s = Integer.toBinaryString(i);
System.out.println(s);
int j = Integer.parseInt(s, 2);
System.out.println(j);
```

Miért megoldás erre a `Long.valueOf(s, 2).intValue()` kifejezés használata?

### Bónusz feladat

Mit ír ki a következő kifejezés, és miért?

```java
System.out.println(0333);
```

## Teszt

Mit ír ki az alábbi kódrészlet?

```java
int x = 5;
int y = 2;
int z = x++ + (x - 4) * y - 2;
System.out.println(x + " " + z);
```

* [x] 6 7
* 5 7
* 6 8
* 5 8
* 6 6
* 5 5
