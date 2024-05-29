# Programare functionala. Expresii lambda. Interfete functionale din jfk. Streamuri. Optional

###### Programare functionala
- Programarea functionala este o paradigma de programare in care programele sunt construite aplicand si adaugand functii
- Este o paradigma de programare declarativa in care functiile sunt arbori de expresii care mapeaza valori la alte valori (spre deosebire de programarea 
imperativa, unde folosim o secventa de instructiuni care altereaza starea progrmaului)
- Principiile programarii functionale:
-> Functiile trebuie sa accepte cel putin un argument
-> Functiile ar trebui sa returneze date sau o alta functie
-> Nu trebuie folosite bucle.
-> Apelarea unei functii nu produce efecte colaterale (adica nu sunt modificate variabile externe si nu se modifica valorile parametrilor functiei) -> se recomanda utilizarea
obiectelor immutable si transmiterea parametrilor unei metode prin valoare

###### Expresii lambda
- O expresie lambda este o forma prescurtata de scriere a instantei unei clase care implementeaza o interfata functionala
- Arata ca a o metoda (mai sunt denumite si "metode anonime), dar e mai mult de atat
- Cea mai importanta parte a instantei este metoda (restul poate fi intuit din definitia interfetei), deci expresia lambda este sintaxa instantei care a fost redusa la esential
- Pentru a compune o expresie lambda, copiem parametrul metodei test(), desenam o sageata si apoi copiem expresia din corpul meotdei test, lasand deoparte return si ;:
-> test(Dog d) {
  return d.getAge() > 9;} devine: (d) -> d.getAge() > 5;
- Tipul expresiei este dat de interfata
- Putem scoate parantezele parametrului d din lambda deoarece metoda test() are un singur parametru (daca avem mai multi parametri, folosim parantezele): d -> d.getAge() > 5;
- Tipul parametrului d este dedus, dar sunt situatii in care nu poate fi dedus si atunci acesta trebuie adaugat: (Dog d) -> d.getAge() > 5;
- Daca este doar o expresie in lambda, atunci valoarea expresiei este intoarsa si nu ai nevoie de instructiunea return: d -> return d.getAge() > 5 nu compileaza !
- Pentru a folosi instructiunea return si sa compileze, trebuie sa scrie lambda ca: AnimalTester at = d -> { return d.getAge() > 5;};
- Cu alte cuvinte, daca body ul expresie lambda este mai mult decat o expresie (adica este o instructiune sau mai multe instructiuni), trebuie sa folosim {} (parantezele ondulate)
- Putem pasa expresii lambda metodelor (vezi exemplu din pachetul expresiilambda)
- Putem declara expresii si putem folosi variabile in cadrul expresiilor lambda, dar nu putem redeclara variabile
- Variabilele folosite in lambda uri trebuie sa fie final sau effectively final (adica valoarea nu se schimba dupa initializare)
- Pot aparea efecte secundare cand gfolosim expresiile lambda -> un exemplu ar fi ca nu putem modifica valoarea variabilelor folosite in interiorul expresiilor lambda (variabilele trebuie sa fie final sau effective final)

###### Interfete functionale din jdk
- Incepand cu Java 8, gasim 43 de interfete functionale; acestea se gasesc in java.util.function
- Interfetele functionale sunt interfetele cu o singura metoda abstracta. Exemplu: Comparator, Predicate
- Interfetele functionale se impart in suppliers, consumers, predicates sau functions
- Interfetele de baza sunt: Supplier, Consumer, Predicate si Function
- Suppliers:
-> Ofera rezultate.Metoda get() nu are niciun argument si intotdeauna intoarce ceva
- Consumers:
-> Consumerii consuma valori. Metoda accept() ia un argument si nu intoarce nimic
- Predicates:
-> Predicatele testeaza lucruri (si fac operatii logice). Metoda test() ia un argument, face un test logic si intoarce true sau false
- Functions:
-> Cel mai generic tip dintre interfetele functionale. Metoda apply() ia un argument si intoarce o valoare
- Toate interfetele functionale din pachet sunt variatii ale lui Supplier, Consumer, Predicate si Function; de exemplu, BooleanSupplier este un supplier a carei metoda functionala ofera o valoare boolean; un
IntConsumer este un consumer a carui metoda functionala ia o valoare int, samd
- Majoritatea variatiilor de interfete functionale au fost introduse fie pentru a ne lasa sa dam mai multe argumente (eg, BiConsumer care ia 2 argumente in loc de unul) sau pentru a evita autoboxing ul (ex, IntConsumer si
BooleanSupplier), ceea ce le face mai eficiente
- Interfetele functionale par destul de abstracte, dar pe masura ce la folosim, realizam casunt destul de utile; cel mai bun mod de a le vedea in actiune este sa sa ne uitam pe documentatia Oracle API pentru una din interfete si
sa vedem cum se foloseste

###### Streamuri
- Streamurile au fost adaugate in java 8
- Streamurile reprezinta o modalitate de a procesa datele eficient; ele sunt inrudite cu colectiile (putem face un stream dintr-un tip de colectie pentru a procesa datele din colectie) si cu expresiile lambda (vom folosi lambda uri frecvent
pentru a opera stream urile)
- Un stream reprezinta o secventa de elemente (elementele sunt date) care poate fi procesata cu operatii
- Interfata Stream din java.util.stream are peste 30 de metode si aproximativ 3 sferturi din ele lucreaza cu interfete functionale intr-un fel
- Sursa unui stream poate fi reprezentata de un array sau o colectie
- Putem aplica operatii pe stream uri; acestea pot fi intermediare (putem efectua aceste operatii intre sursa streamului si sfarsitul acestuia) sau terminale (stream ul este transofrmat si
nu se mai pot efectua alte operatii)
- Adevarata putere a stream urilor este data de operatiile intermediare; operatiile intermediare produc un stream nou, iar streamurile folosesc un "pipeline" care imbunatatesc eficienta procesarii datelor (in anumite circumstante)
- "Pipeline" ul unui stream consta din 3 parti: o sursa, zero sau mai multe operatii intermediare si o operatie terminala
- Stream urile pot fi folosite o singura data; odata ce acesta a fost terminat ( o operatie terminala a fost folosita), nu mai poate fi folosit
- In Java, stream urile sunt obiecte usoare (lightweight), deci putem crea multiple stream uri daca dorim
- Ca sa cream un stream dintr-un Map, intai trebuie sa apelam entrySet() pe map (Map nu mosteneste Collection)
- putem crea stream uri folosind meotda Stream.of()
- Operatii intermediare pe streamuri: filter(), sorted(), distinct(), map(), etc; acestea nu se executa pana cand nu este invocata o operatie terminala pe stream
- Operatii terminale: forEach(), count(), collect(), reduce(), sum(), average(), findFirst(), findAny()
- Exista si streamuri pentru primitive (ex: IntStream, DoubleStream, LongStream)
- Putem cauta obiecte si vlaori intr-un stream folosind anyMatch(), noneMatch(), findAny, findFirst()
- Putem sorta elementele care curg printr-un stream; metodat sorted() din Stream poate sorta dupa ordinea naturala sau folosind un comparator
- Nu trebuie sa modificam datele sursa in timp ce le prelucram; in schimb, putem sa le filtram si sa le colectam si sa operam pe ce am filtrat 


###### Optional
- Introdus in java 8
- Optionalele sunt in esenta niste containere pentru obiecte care pot avea valoare sau nu (null sau non null)
- Ele sunt utile pentru ca tot in java 8 s-au introdus si streamurile; nu putem stii daca o sursa este goala sau are valori pana cand nu ajungem la operatia terminala/ nu putem stii daca 
operatiile pe stream au eliminat toate valorile
- Ca sa extragem valoarea dintr-un optional, trebuie sa verificam intai ca exista valoarea folosind isPresent(), altfel primim exceptie 
- Exista variatii de Optional pentru a evita autoboxingul: OptionalDouble, OptionalInt si OptionalLong
