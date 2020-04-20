# Rekurzió
Az önmagát hívó metódusokat rekurziónak nevezzük. A metódus hívhatja magát közvetlenül, vagy akár más metódusokon keresztül is. Minden rekurzió ciklussá formálható. Vigyázzunk, mert könnyen implementálhatunk végtelen rekurziót.

### Rekurzív feladat
Rekurziót főleg akkor alkalmazunk, mikor egy feladat visszavezethető egy hasonló, egyszerűbb esetre. Létezik legegyszerűbb eset, melyben a megoldás már magától értetődő. Létezik, egy olyan egyszerűsítési folyamat, melyet alkalmazva véges sok lépésben eljutunk a legegyszerűbb esethez. Minden lépésben feltételezzük, hogy a következő egyszerűbb esetnek már van megoldása.

### Rekurzió részei
A rekurzió tartalmaz egy állapotot mely elérhet egy küszöböt, egy utasítást mely az állapotot a küszöb felé viszi, illetve egy leállító feltétel, amely azt vizsgálja, hogy az állapot elérte-e a küszöböt.

Leggyakoribb példa a rekurzióra, a faktoriális számítás:
```java
public long getFactorial(int n) {
    if(n > 1) {
        long solution = getFactorial(n - 1);
        return n * solution;
    } else {
        return 1;
    }
}
```


## Ellenőrző kérdések

* Mit jelent a rekurzió?
* Hogyan biztosítható, hogy véges lépésben befejeződjön a rekurzív algoritmus?


## Faktoriális számítás rekurzívan

A matematikában egy n nemnegatív egész szám faktoriálisának az n-nél kisebb vagy egyenlő pozitív egész számok szorzatát nevezzük. n! = n * (n-1) * ... * 2 * 1

Írd meg a faktoriális számítás algoritmusát rekurzívan.

[rating feedback=java-recursion-faktorialis]
