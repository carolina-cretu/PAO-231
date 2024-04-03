# Interfete folosite pentru sortare -> Comparable<T> si Comparator<T>. Clase interioare anonime. Implementare callback folosind interfete.

###### Sintaxa interfete:
public interface numeInterfa.a{
constante //public, static si final
metode abstracte (fara implementare) //public si abstract
metode implicite (default) cu implementare
metode statice cu implementare
metode private cu implementare


Java ne ofera 2 interfete pentru sortare:
Comparable si Comparator.

###### Comparable<T>

Un obiect comparabil este un obiect capabil de a se compara pe sine cu alt obiect. Clasa trebuie sa
implementeze interfata java.lang.Comparable pentru a-si compara instantele. Aceasta interfata impune o ordine totala
pe obiectele fiecarei clase care o implementeaza. Aceasta ordine este denumita "ordine naturala de sortare" deoarece 
foloseste criteriul de sortare care are cel mai mult sens in contextul clasei (de ex, in clasa String ordinea naturala este
alfabetica, in clasa wrapper Integer ordinea naturala este crescator, etc), iar metoda compareTo() care trebuie
implementata este considerata metoda de comparare naturala.

**_public int compareTo(Object obj):_** Folosita pentru a compara obiectul curent cu obiectul
specificat. Intoarce:

- un integer pozitiv, daca obiectul curent este mai mare decat obiectul specificat
- un integer negativ, daca obiectul curent este mai mic decat obiectul specificat
- zero, if the current object is equal to the specified object.
- zero, daca obiectul curent este egal cu obiectul specificat

###### Comparator<T>

Spre deosebire de Comparable, Comparator este extern obiectului pe care il comparam.
Cream o clasa noua (sau mai multe, in functie de cate criterii aditionale de comparare
vrem sa implementam) pentru a compara dupa diferite atribute.


Pentru a compara studenti dupa GPA (medie), avem nevoie de 3 lucruri :
- Sa cream o clasa care implementeaza **_Comparator_**  (si metoda **_compare()_** care are acelasi
- rol ca si cel pe care il are compareTo()). Metoda compare() compara obiecte specifice ale 
- unei clase (x, y) date ca parametru. Intoarce urmatoarele valori:

■ 0: daca (x==y)

■ -1: daca (x < y)

■ 1: daca (x > y)

- Sa cream o instanta a clasei care implementeaza interfata Comparator
- Sa chemam metoda supraincarcata sort() careia ii pasam array ul si instanta clasei care
implementeaza Comparator

###### Clase anonime
- Clasele anonime sunt clase interioare fara nume
- Deoarece o clasa anonima nu are nume, nu o putem folosi ca sa cream instante -> de aceea trebuie
sa le declaram si sa le instantiem intr-o singura expresie atunci cand vrem sa le folosim
- Nu pot fi extinse din acelasi considerent (nu au nume); din acelasi motiv nu pot avea constructori declarati in mod explicit
- Nu pot contine membri statici, cu exceptia membrilor de tip constante
- Le folosim pentru a extinde o clasa sau a implementa o interfata 
- Deoarece o clasa anonima este o expresie ce este parte a unei declaratii, trebuie sa punem ; la sfarsitul acesteia
- Din cauza sintaxei, clasele anonime nu pot implementa mai multe interfete
- In timpul constructiei, poate exista o singura instanta a clasei anonime; de aceea nu pot fi abstracte
- Din instantele clasei anonime putem accesa variabilele locale si membrii clasei care o contine
- Clasele interioare se folosesc: cand vrem sa implementam event listeneri de UI, in cazuri particulare pentru
a obtine o ierarhie mai curata de clase (cand vrem sa modificam pe loc implementarea unor metode fara a adauga fisiere
.java).


###### Implementare calback folosind interfete
- Defineste un mecanism in care chemam o functie dintr-o functie (C/C++)
- In Java nu exista conceputl de functie callback ca in C/C++ deoarece nu avem pointeri 
- Acest mecanism se poate implementa totusi prin pasarea unei interfete care face referire la locatia unei metode
- Pasi de implementare:
1. Cream o interfata care contine metoda generica, abstracta;
2. Cream o clasa care contine o metoda care va realiza prelucrarea generica dorita (va primi ca parametru  referinta 
interfetei pentru a accesa metoda generica)
3. Definim clase care implementeaza interfata noastra generica si oferim implementare pentru metoda generica in fiecare
4. Definim obiectul clasei de la punctul 2 si apelam metoda pe care aceasta clasa o contine, pasand ca parametru obiectele 
care implementeaza interfata generica

Reprezentare concept:

static void calculateTax(adresa metodei countyTax())
{
centralTax = 1000.0
countyTax = calculare taxa judeteana in functie de adresa (Bucuresti, Prahova, etc..)
total tax = centralTax+centralTax;
}
 implementare in pachetul de callback !