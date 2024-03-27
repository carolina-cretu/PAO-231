# Clase si obiecte. Extinderea claselor. Polimorfism

#### Principiile programarii orientate pe obiecte:
- Abstractizarea: reducerea la un model simplu a proprietatilor si functionalitatilor unui obiect, prin definirea unui sablon (template); ascunderea anumitor detalii
- Incapsularea: proprietatea claselor de a grupa datele şi metodele într-o singură structură de date; datele se definesc impreuna cu codul ce actioneaza asupra lor
- Mostenirea: o clasa copil poate mosteni starile si comportamentele unei clase parinte
- Polimorfismul: capacitatea unui obiect de a lua forme multiple.


#### Clase si obiecte
In Java, tipurile complexe de date sunt modelate folosind clase.

Clasa este o abstractizare folosita pentru a crea obiecte, un sablon.

Obiect = instanta a unei clase; in momentul instantierii se aloca spatiu in memorie pentru obiectul respectiv.

O clasa contine:
- atribute (datele, state-ul obiectului)
- metode (cod executabil)
- constructori (cod executabil folosit pentru instantierea obiectelor)

Keyword: this - referinta la obiectul curent

#### Modificatori de access:

###### Private

- vizibilitate doar in interiorul clasei
- poate fi folosit pentru: metode, atribute, clase (doar interne)
###### Default (package)

- daca nu punem nici un modificator de access => default (vizibilitate la nivel de package)
- poate fi folosit pentru: metode, atribute, clase

###### Protected

- vizibilitate in interiorul pachetului si in exterior din cadrul claselor copil
- poate fi folosit pentru: metode, atribute, clase (doar interne)

###### Public

- poate fi accesat de oriunde
- poate fi folosit pentru: metode, atribute, clase

#### Mostenirea

- prin mostenire, o clasa de baza (parinte) este extinsa, adaugand functionalitate mai specializata
- keyword: extends
- nu putem mosteni mai multe clase simultan
- in Java, orice clasa extinde by default clasa Object.

#### Static keyword

Static fields:

- va exista intr-un singur exemplar in memorie, indiferent de numarul de instante ale clasei
- campul este vizibil tuturor instantelor clasei si poate fi modificat de oricare dintre acestea

Static methods:

- pot fi apelate fara a fi nevoie sa creezi o instanta a clasei

#### Final keyword

- pe atribut/variabila: nu poate fi modificata (devine constanta)
- pe metoda: nu poate fi suprascrisa
- pe clasa: nu poate fi extinsa

#### Enum

- tip special de clasa ce mapeaza o lista de constante

#### Arrayuri (tablouri)


 - un array este un obiect ce contine un numar fix de valori de acelasi tip.
 - elementele unui array sunt indexate, ceea ce inseamna ca le putem accesa cu numere (indici)
 - putem considera ca un array este o lista numeoratata de celule, fiecare celula fiind o variabila ce are o valoare. In Java, numerotarea incepe de la 0 (index 0)
 - putem defini array uri de primitive sau arrayuri de obiecte. Asta inseamna ca putem avea array uri de int, float, boolean, dar si array uri de String, Object sau obiecte custom
 - array urile pot fi unidimensionale sau multidimensionale (bidimensionale, tridimensionale)
 - pentru operatii cu array uri, putem folosi clasa Arrays unde gasim diverse metode care ne ajuta sa manipulam array urile (copy(), fill(), etc)
 - in cazul array urilor, ca si in cauzl primitivelor, referinta este tot in zona de memorie de tip stiva; initializarea aloca spatiu de memorie pe heap pentru variabile

#### Clase interioare 

 - o clasa interioara este o clasa ce este definita intr-o alta clasa
 - clasele interioare pot fi statice sau nonstatice 
 - pot avea orice modificator de acces in declaratie (fata de clasele de top, care nu pot avea decat public sau protected - declarare default, fara modificator)
 - cele statice apartin clasei exterioare care o contine si nu unei instante; poate accesa membrii statici ai clasei exterioare
 - cele non statice apartin unei instante si nu pot fi instantiate fara o instanta de clasa exterioara; poate accesa si membrii statici si cei nonstatici
