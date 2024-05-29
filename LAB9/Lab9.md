# Lucrul cu colectii: equals(), hashCode(). Descrierea frameworkului de colectii. Clasa utitilitara Collections. Generics.
###### Metoda equals()
- Metoda equals() este o metoda mostenita din clasa Object folosita pentru a decide daca 2 obiecte sunt egale din punct de vedere al continutului
- Clasa String si clasele wrapper (wrapper pentru primitive) rescriu metoda equals()
- Daca nu rescriem metoda, aceasta se va comporta ca operatorul == -> va intoarce true daca referintele refera acelasi obiect prin compararea bitilor din variabile;
- Pentru fiecare clasa pe care o scriem, trebuie sa decidem daca are sens sa rescriem equals() si sa vedem daca 2 obiecte sunt egale; in unele cazuri, nu ar trebui/ nu vrem 
sa vedem daca 2 obiecte sunt egale ( de exemplu, un obiect Car cu 2 configuratie identica pot fi egale din prisma lui equals(), dar nu am vrea sa vedem vecinul ca ne conduce masina pentru ca 
equals() a decis ca sunt unul si acelasi obiect)
- Daca nu rescriem equals(), nu vom putea folosi un obiect pe cheia unui hashtable:
-> daca punem un obiect Car pe cheia unui HashMap (un tip de hashtable) si vrem sa recuperam obiectul Person corespunzator, cum vom putea da colectiei
obiectul introdus daca nu mai avem referinta obiectului Car pus in colectie ? Trebuie sa rescriem equals() si putem decide ca
2 obiecte Car sunt egale daca VINul este identic; bineinteles, asta poate duce potential la reprezentarea aceleiasi masini speicfice cu mai mult de un obiect; solutia 
este sa folosim un String/o clasa wrapper pentru a reprezenta VIN-ul masinii (sau putem folosi chiar unul din atributele clasei Car), eliminand posibilitatea de a avea mai multe obiecte pentru aceeasi masina 
in designul aplicatiei noastre
- Daca nu rescriem equals() nu vom avea o colectie Set care sa elimine duplicatele conceptuale cu acuratete
- Doar programatorul poate decide ce atribute fac 2 instante sa fie egale; pentru o mai mare performanta, se compara cat mai putine atribute
- Contractul equals() trebuie respectat in implementare si il gasiti aici: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object)

###### Metoda hashCode()
- hashcode urile sunt folosite pentru a creste performanta in colectiile de date mari
- Valoarea hashcode a unui obiect este folosita de unele clase colectii cum ar fi HashMap sau HashSet pentru a determina cum va fi stocat in colectie respectivul obiect; poate fi considerat un ID unic al unui obiect, desi
poate sa nu fie neaparat unic
- Este perfect legal sa ai o implementare de hashcode extrem de ineficienta daca nu este in neconcordanta cu contractul hashCode()
- Cum functioneaza hashcode ul:
-> sa ne imaginam ca ni se dau niste biletele cu niste nume pe ele si calculam un algoritm folosind A = 1, B = 2, C = 3, etc; aceste biletele sunt puse in niste boluri pe baza algoritmului calculat:
-> biletel cu ADI: 1 + 4 + 9 = 14;
-> biletel cu BOB: 2 + 15 + 2 = 19;
-> biletele cu ALEX: 1 + 12 + 5 + 24 = 42;
-> bolurile noastre: 14 - Adi; 19 - Bob; 42 - Alex
-> nu introducem nimic la intamplare; calculam pe baza algoritmului valorile si daca avem aceleasi date de intrare, vom avea aceeasi valoare;
felul in care folosim codul respectiv (il vom numi hashcode) este pentru a determina in ce bol punem fiecare biletel ( sa ne imaginam ca fiecare bol are o valoare diferita)
-> daca cineva vine si cere biletelul pentru un nume specific, rulam acelasi algoritm si stim in ce bol sa ne uitam pentru a gasi acea valoare
-> doua nume care folosesc acelesi litere dau aceeasi valoare, deci Adi si Ida ne dau 14; hashcode ul ne spune in ce bol sa ne uitam, dar nu si cum sa gasim valoarea in bol
-> un algoritm care intoarce acelasi hashcode pentru toate obiectele va pune toate numele in acelasi bol, facand cautarea extrem de ineficienta si dureroasa
-> ideal ar fi ca fiecare nume sa fie in bolul propriu (desi in viata reala nu este neobisnuit sa avem 2 obiecte cu acelasi hashcode)
-> daca rescriem doar equals, am aveam echivalentul a jumatate din nume pe care il calculam pentru cautarea in boluri, ceea ce ne-ar face sa cautam in bolul gresit -> metoda hashCode() din Object
calculeaza aproape intotdeauna un numar unic pentru fiecare obiect, chiar daca metoda equals() a fost rescrisa astfel incat 2 obiecte sa fie considerate egale !
- ar fi de preferat sa nu puneti atribute transient in algoritm, un obiect deserializat nu va mai avea acelasi hashcode dupa deserializare deoarece aceste atribute nu se salveaza
- equals() si hashCode() sunt legate printr-un contract comun care specifica ca daca 2 obiecte sunt egale conform equals(),
atunci trebuie sa aiba valori hashcode identice. Asadar, regula de aur este: rescriem equals(), rescriem si hashCode().
- Contractul hashCode() trebuie respectat in implementare si il gasiti aici: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Object.html#hashCode()

######Frameworkul de colectii
- Colectiile sunt niste structuri de date (sau, mai bine zis, un grup de obiecte reprezentat ca o singura unitate)
- Au luat forma incepand cu Java 1.2 si au fost extinse in 1.4, 5, 6, 7 si 8
- Libraria de colectii contine liste, seturi, maps si queues
- O colectie este folosita pentru a adauga obiecte, a sterge obiecte, a determina daca un obiect/ grup de obiecte este in colectie, a itera prin obiecte, etc
- Interfete cheie: Collection, List, Set, Queue, Map, NavigableSet, SortedSet, SortedMap, NavigableMap
- O reprezentare vizuala a frameworkului: https://www.javacodeexamples.com/wp-content/uploads/java-collections-cheat-sheet.png
- Colectiile pot tine obiecte, dar nu si primitive; folosim clasele wrapper pentru a adauga primitive intr-o colectie
- Inainte de Java 5, trebuia sa infasuram manual primitivele inainte de a le adauga in colectie; din Java 5 se ocupa autoboxingul de asta 
- O colectie poate fi nesortata si neordonata, ordonata si nesortata sau sortata si sortata. O colectie nu poate fi sortata si neordonata,
- pentru ca sortarea este un tip specific de ordonare; de exemplu, un HashSet este o implementare neordonata si nesortata de Set.
pe cand un LinkedHashSet este o implementare ordonata, dar nesortata, care mentine ordinea obiectelor dupa insertie.
- O colectie ordonata este o colectie prin care putem itera intr-o anumita ordine; de exemplu, un Hashtable nu tine o ordine, pe cand ArrayList 
va fi ordonat in functie de index (precum un array), iar LinkedHashSet tine elementele ordonate in functie de insertie
- O colectie sortata este o colectie in care elementele sunt ordonate dupa o anumita regula (sau dupa mai multe reguli); regulile de sortare nu au legatura cu
momentul in care obiectele au fost introduse in colectie sau cu indexul -> sortarea se face dupa atributele obiectului. Aceasta sortare se numeste
"sortare naturala" cand vorbim de obiecte care implementeaza interfata Comparable, dar putem adauga si alte reguli de sortare daca implementam Comparator. 
- Colectii sortate: TreeSet, TreeMap

###### List
- O colectie de tip List tine cont de index
- Are metode care pot fi folosite impreuna cu indexul: get(int index), indexOf(Object o), add(int index, Object obj), etc
- Toate 3 implementarile de List sunt ordonate dupa index
-> ArrayList:
- Este un array care poate creste
- Este o colectie ordonata (dupa index), dar nu este sortata
- implementeaza interfata marker RandomAccess si ar trebui preferata lui LinkedList atunci cand dorim sa iteram cu un timp constant de acces (rapid) si 
nu avem de gand sa facem multe insertii/stergeri

-> Vector:
- Una dintre cele 2 colectii originale (cealalta este Hashtable)
- Cam acelasi cu ArrayList, doar ca metodele sale sunt sincronizate pentru a fi thread safe
- In mod normal, ArrayList este preferat deoarece sincronizarea metodelor aduce un impact asupra performantei; in cazul in care avem nevoie de
thread safety, exista metode in clasa utilitara Collections
- implementeaza interfata marker RandomAccess

-> LinkedList:
- Este o colectie ordonata dupa index (ca ArrayList), doar ca elementele sunt dublu inlatuite unul de celalalt
- Aceasta inlantuire adauga metode noi pentru adaugarea si stergerea de la cap/coada, ceea ce o face o implementare excelenta pentru o stiva
sau o coada.
- Viteza de iteratie este mai mica ca la ArrayList, dar este excelenta pentru stergere/adaugare de elemente
- Incepand cu Java 5, implementeaza interfata java.util.Queue, ceea ce ii da noi metode precum peek(),
  poll() si offer()

###### Set
- O colectie de tip Set tine cont de unicitate; aceasta colectie nu permite duplicate
- Metoda equals() este cea care stabileste daca 2 obiecte sunt egale in acest caz
-> HashSet:
- Este o implementare neordonata, nesortata care foloseste hashcode ul obiectului inserat, deci cu cat este mai eficient hashcodeul,
cu atat mai buna va fi performanta
- Aceasta implementare este de preferat cand ne trebuie o colectie care nu permite duplicate si nu ne pasa de ordine cand iteram prin ea

-> LinkedHashSet:
- Este o implementare ordonata, nesortata de HashSet care tine o lista dublu inlantuita peste elemente
- Aceasta implementare este de preferat cand ne intereseaza ordinea in care iteram (in HashSet ordinea este imprevizibila, LinkedHashSet ne lasa sa iteram prin obiecte dupa cum au fost inserate)

-> TreeSet:
- Este una dintre cele doua colectii ordonate si sortate (cealalta este TreeMap)
- Foloseste o structura arbore Rosu-Negru care garanteaza ca obiectele vor fi ordonate ascendent, conform "ordinii naturale"
- Optional, se poate construi pasand constructorului argumentul de sortare propriu (folosind un Comparator)

###### Map
- O colectie Map tine cont de ID uri unice; mapezi un ID la o valoare
- Implementarile de Map permit cautarea dupa cheie, dupa valoare, obtinerea colectiei de chei sau de valori
- Ca si colectiile de tip Set, se bazeaza pe equals() pentru a determina ca doua chei sunt identice

-> HashMap:
- Este o implementare neordonata si nesortata
- Este de preferat atunci cand avem nevoie de o implementare de Map si nu ne intereseaza ordinea in care sunt puse cheile; cheile sunt adaugate
pe baza hashcode ului, asadar, precum HashSet, cu cat este mai eficienta implementarea de hashCode(), cu atat performanta va fi mai buna
- Permite o cheie null si multiple valori null 
- Este cea mai rapida implementare; celelalte implementari adauga putin la performanta

-> Hashtable:
- Este a doua colectie original implementata in Java
- Este varianta sincronizata a lui HashMap
- nu permite valori null

-> LinkedHashMap:
- Aceasta colectie mentine ordinea de insertie a elementelor
- este mai lenta decat HashMap la adaugare/stergere de elemente, dar iteratia este mai rapida

-> TreeSet:
- este o colectie ordonata si sortata
- La fel ca si TreeSet, elementele sunt sortate dupa "ordinea naturala"
- Permite definirea colectiei prin pasarea argumentului de tip Comparator pentru sortare custom
- Incepand cu Java 6, implementeaza NavigableMap


###### Queue
- O colectie de tip Queue este facuta pentru a mentine o lista  "de facut", sau de lucruri de procesat intr-un anumit fel
- In general, colectiile de acest tip sunt gandite pentru a fi procesate FIFO (first in, first out), desi se pot defini si alte moduri de procesare
- Colectiile Queue beneficiaza de toate metodele din Collection, dar au si metode proprii de adaugare, extragere sau vizualizare elemente

-> PriorityQueue:
- De cand LinkedList a fost upgradata sa implementeze Queue, cozile de baza pot fi implementate folosind LinkedList
- Scopul acestei implementari este sa creeze o coada de tip "priority in, priority out", nu FIFO;
- Elementele acestei implementari sunt ordonate dupa "ordinea naturala" (caz in care elementele ordonate primele vor fi si primele accesate) sau pot fi sortate dupa o regula custom cu
un Comparator; in orice caz, ordinea elementelor reprezinta prioritatea lor relativa

-> ArrayDeque:
- Este ordonata dupa pozitia elementelor si nu este sortata
- implementeaza interfata Deque, care a fost adaugata in Java 6
- Este o alegere buna pentru a implementa o stiva sau o coada pentru ca nu are restrictii de capacitate, este flexibila in ceea ce priveste nr de elemente (resizable) si este
facuta sa fie high performance (dar nu este thread safe)


###### Clasa utilitara Collections
- Este o clasa utilitara ce extinde Object
- Contine metode statice care intorc colectii sau lucreaza cu colectii
- Toate metodele arunca NullPointerException daca colectia pasata/obiectul pasat este null
- Contine metode ca: 	addAll(Collection<? super T> c, T... elements), binarySearch(List<? extends Comparable<? super T>> list, T key),
  copy(List<? super T> dest, List<? extends T> src), etc

###### Generics
- A fost introdus in Java 5 si este folosit ca o modalitate de a asigura tipul folosit in colectii 
- Sintaxa este un operator diamant <> care tine tipul parametrizat, exemplu: List<String> list = ....
- Tipul paramtrizat este strict pentru compilator (el dispare la runtime, JVM vede colectiile la fel ca si in Java 5 -> type erasure)
- Compilatorul face cast urile in spate (pentru a obtine obiecte din colectie)
- O colectie parametrizata pe Object tine orice tip de obiect ( la fel ca si inainte de java 5)
- Cand mixam cod vechi (neparametrizat) cu cod nou (parametrizat), compilatorul emite warninguri pentru ca in colectiile noastre pot aparea tipuri nedorite
- Polimorfismul nu merge la generics cum il stim in java. Exemplu:
-> class Parent {}
-> class Child extends Parent {}
-> List<Parent> list = new ArrayList<Child>(); // nu merge; tipul declarat trebuie sa fie acelasi cu cel pasat
-> List<Parent> list = new ArrayList<Parent>(); // asta merge
-> List<Child> list = new ArrayList<Child>(); // asta merge
- Motivul pentru care exemplul de mai sus merge cu array uri, dar nu si cu colectii parametrizate este pentru ca la array uri avem exceptie de runtime cand se pune tipul gresit ( de exemplu, un obiect Dog intr-un array Cat),
dar la colectii avem doar compilatorul care ne poate ajuta, la runtime avem type erasure, JVM nu stie de parametrii colectiei
- List<?>/ List<? extends Object> inseamna orice tip, List<Object> inseamna doar Object
- Putem crea propria clasa parametrizata pe un tip, metode,etc