# Git használata IDE-ben

## Elmélet

Az IDEA fejlesztőeszköz beépítetten támogatja a Git használatát.
Lehetőség van új projekt esetén azt verziókezelő rendszerben tárolni,
vagy egy projektet úgy megnyitni, hogy közvetlen verziókezelő rendszerből
kerüljön letöltésre és megnyitásra.

Amennyiben a projekt már parancssorból Gitből került letöltésre (clone), az 
IDEA-ban megnyitható, és a Git használható. Ehhez a _VCS / Enable Version 
Control Integration_ menüpontot kell használni.

A View / Tool Windows / Version Control menüponttal nyitható meg a Git
műveletek használatát segítő ablak. Ezen ablak mutatja az újonnan létrehozott,
módosított és törölt állományokat. Itt lehet az állományokat a Githez hozzáadni,
commitolni. A revert művelettel lehet a saját módosításainkat elvetni.
A verziókezelő rendszerhez, azaz esetünkben a Githez kapcsolódó parancsokat
a Git menüpont alatt lehet megtalálni, ebből a Pull és Push a leggyakrabban
használt.

Bár érdemes az IDEA fejlesztőeszközt használni a Git műveletek végrehajtására,
tisztában kell lenni azzal, hogy parancssorban hogyan lehet ezeket elvégezni.
Gyakran lehet olyan, hogy vagy nincs kéznél fejlesztőeszköz, vagy
parancssorból kell ellenőrizni, hogy a fejlesztőeszköz jól működik-e, esetleg
speciális parancsokat kell kiadni.

## Ellenőrző kérdések

* Hogyan támogatja a fejlesztőeszköz a Git használatát?

## Feladat

### Első push

Hozz létre egy új projektet `introgit` néven, abban egy `HelloGit`
Java osztályt, ami kiírja, hogy `Hello Git!`!

Commitold, majd push-old a megoldásodat!

### Második push

Írd át a `HelloGit` osztályban, hogy azt írja ki, hogy `Hello Git 2!`!

Commitold, majd push-old a megoldásodat!

### Bónusz kérdés 1.

Hogyan lehet megnézni a fejlesztőeszközben, hogy milyen commitok voltak?

### Bónusz kérdés 2.

Hogyan lehet megnézni egy állományon a fejlesztőeszközben, hogy ki melyik sort módosította?

## Teszt

Milyen git parancsokat támogat az IntelliJ IDEA?

* [x] add
* [x] commit
* [x] push
* [x] pull
* [x] clone
