# JDBC. Programare functionala.

###### JDBC (JAVA DATABASE CONNECTIVITY)
- 


###### Programare functionala
- Pentru a persista si a gestiona date intr-o aplicatie, folosim o baza de date care este gestionata de un SGBD (sistem de gestiune a bazelor de date) dedicat, aflat de obicei pe un server
- JDBC este un API dedicat accesarii bazelor de date din cadrul unei aplicatii java care permite conectarea la un server de bae de date, precum si executarea unor instructiui SQL (Structured Query Language) pentru a face operatii de tip CRUD
- Sunt 3 concepte importante cand lucram cu o baza de date: crearea unei conexiuni cu baza de date, crearea unei instructiuni care sa se execute in baza de date si obtinerea unui set de date care sa reprezinte rezultatele
- Aceste 3 concepte sunt definite prin interfete in pachetul java.sql: Connection, Statement si ResultSet
- Interfata Connection  defineste contractul pentru un obiect care reprezinta conexiunea cu baza de date, Statement ofera abstractizarea functionalitatii necesare pentru a executa o instructiune SQL in baza de date, iar interfata ResultSet 
reprezinta abstractizarea functionalitatii necesare pentru a procesa un result set (datele din tabel) care este intors de instructiunea SQL SELECT
- Clasele care implementeaza interfetele Connection, Statement si ResultSet si un numar de alte interfete sunt create de vendor ul bazei de date pe care o utilizam
- Colectia de clase care implementeaza interfetele reprezinta driver ul JDBC
- Un driver JDBC este de regula oferit de vendor intr-un fisier jar sau zip; clasele care implementeaza driverul trebuie sa respecte un set minim de cerinte pentru a fi JDBC conform -> lista completa si detalii
despre cerintele JDBC pot fi gasite in specificatia JSR-221

- Crearea unei conexiuni cu baza de date:
-> DriverManager este o  clasa utilitara cu metode statice (nu avem doar interfete in JDBC) din JDBC api pe care o folosim pentru a interactiona cu un driver JDBC si care ne intoarce obiecte 
de tip Connection; aceste foloseste un factory design pattern in spate
-> DriverManager gestioneaza ce implementare de JDBC driver obtii cand ceri o instanta de Connection prin apelarea metodei getConnection()
-> DriverManager foloseste un mecanism de cautare in classpath (introdus in JDBC 4.0) de JARuri sau fisiere ZIP care contin un fisier denumit java.sql.Driver in directorul META-INF/services al jar ului/zip ului; acest fisier contine numele intreg al clasei
folosite de vendor pentru a implementa interfata jdbc.sql.Driver -> exemplu, pentru un driver Derby, numele complet este org.apache.derby.jdbc.ClientDriver
-> Mai departe, DriverManager va incerca sa incarce clasa pe care a folosti-o in fisierul java.sql.Driver folosind class loaderul: Class.forName("org.apache.derby.jdbc.ClientDriver");
-> cand clasa driver este incarcata, blocul de initializare static pe care il contine se va executa; conform specificatiei JDBC, una dintre primele activitati ale unei instante de driver este sa se "auto-inregistreze" la DriverManager 
prin apelul unei metode statice. Codul arata cam asa:
 public class ClientDriver implements java.sql.Driver {
  static {
    ClientDriver driver = new ClientDriver();
    DriverManager.registerDriver(driver);
  } //...

}
-> pentru versiunile de JDBC mai mici de 4.0, este necesar sa incarcam manual driverul folosind Class.forName()
-> Metoda getConnection() este supraincarcata, dar toate versiunile au un parametru String pentru URL
-> cand se paseaza URL ul, DriverManager paseaza acest String (si eventual userul/parola) prin apelul metodei connect() a fiecarei clasa driver cunoscuta de acesta (sau auto inregistrata la DriverManager; daca una dintre clasele driver recunoaste URL ul, se intoarce un Obiect de tip Connection, dar 
daca url ul este incorect (sau parola/userul), vom primi o exceptie de tip SQLException
-> URL ul este folosit pentru a determina ce implementare de driver se va folosi pentru a obtine un obiect Connection. Nu sunt cerinte stricte pentru URL, dar formatul este de tip jdbc:<subprotocol>: <subname>, iar subprotocolul reprezinta numele vendorului. Exemplu:
- URL: jdbc:mysql://localhost:3306/Books: prima parte (jdbc) identifica ca este un url JDBC; a 2 a parte (mysql) indica ca vendorul driver este mysql driver; a 3 a parte indica ca baza de date este pe localhost ul acestei masini
  (adresa ip 127.0.0.1), pe portul 3306; ultima parte indica numele bazei de date (Books)

- Crearea unei instructiuni care sa se execute in baza de date:
-> dupa ce obtinem un Connection, putem crea o instanta de Statement pentru a executa instructiuni SQL folosind o metoda
-> Sunt mai multe forme de metode de tip Statement: cele care intorc un result set si cele care intorc un status de tip integer: instructiunile SQL de tip DDL (Data definition language) ca ALTER/CREATE/DROP TABLE 
sau instructiunile UPDATE/INSERT/DELETE (DML - Data manipulation language) intorc ori numarul de randuri afectate de query ori 0;
-> Cea mai des folosita metoda Statement face un query SQL care intoarce niste date (de exmeplu, un apel de tip select pentru a obtine toate randurile din tabelul Customers)
-> Exemple de metode:
- public ResultSet executeQuery(String sql) throws SQLException -> cea mai des folosita metoda; o folosim cand stim ca vrem sa intoarcem rezultate (de exemplu, facem query pentru unul sau mai multe randuri de date)
- public int executeUpdate(String sql) throws SQLException -> folosita pentru operatii SQL care afecteaza unul sau mai multe randuri si nu intoarce rezultate (de exemplu, INSERT, UPDATE, DELETE si query uri de tip DDL)
- public boolean execute(String sql) throws SQLException -> aceasta meroda este folosita cand nu exista siguranta rezultatului obtinut (query ul poate intoarce un result set sau nu); intoarce true daca query ul a rezultat intrun result set si 
false in caz contrar. Mai des este folosita la invocarea unei proceduri stocate (folosind CallableStatement)
- public ResultSet getResultSet() throws SQLException -> daca execute() intoarce true, atunci putem extrage resul setu ul folosind aceasta metoda; intoarce null daca nu sunt rezultate
- public int getUpdateCount() throws SQLException -> daca execute() intoarce false(), atunci avem nu numar de randuri; -1 indica ca nu sunt rezultate

- Obtinerea unui set de date care sa reprezinte rezultatele:
-> Cand o interogare intoarce un result set, o instanta a clasei care implementeaza ResultSet este intoarsa; obo=iecutl ResultSet reprezinta rezultatele interogarii - toate dotele din fiecare rand pe coloana
-> Felul in care sunt stocate datele in ResultSet este vendor specific; folosind metodele din ResultSet putem citi si manipula datele
-> un ResultSet este o copie a datelor din baza de date din momentul in care interogarea a fost executata
-> Obiectul ResultSet mentine un cursor (sua un pointer) catre randul curent al rezultatelor; cand este executata interogarea, curosrul nu refera un rand din rezultate, ci deasupra primului rand. Pentru a 
obitine rezultatele, intotdeauna apelam next() pentru a muta cursorul catre primul rand. 
-> De principiu, un obiect ResultSet este read-only (datele nu pot fi modificate) si poti muta cursorul doar inainte, dar acest comportament poate fi modificat
-> metoda next() intoarce true pana in momentul in care cursorul nu mai refera catre niciun rand de date (sau nu sunt date in ResultSet); cel mai usor este sa fie folosit intr-un while
-> fiecare rand din obiectul ResultSet contine una sau mai multe coloane si datele din fiecare coloana sunt de tipul SQL; trebuie sa folosim metodele ResultSet ului pentru a pune valorile in tipurile Java corecte. Exemplu:
- SQL INTEGER poate fi citit ca Java int
- SQL VARCHAR poate fi citit ca Java String
- SQL DATE poate fi citit ca un obiect java.sql.Date
-> Valorile pot fi citite folosind numele coloanelor ca parametri pasati metodelor din ResultSet sau pasand valoarea indexului pentru fiecare tip SQL; aceasta valoare este pozitia integer a coloanei in result set
- -> Indexul coloanelor incepe de la 1 si ordinea conteaza in acest caz; numarul coloanelor se poate obtine folosind obiectul metadata al ResultSet ului
- String title = rs.getString(1); //este prima coloana 
- String title = rs.getString("Title); // folosind numele coloanei
-> Cele mai folosite metode ale lui ResultSet sunt:
- public boolean getBoolean(String columnLabel) -> obtine valoarea coloanei data ca parametru ca tip Java boolean; poate tine tipul SQL BOOLEAN (daca baza de date suporta acest tip)
- public double getDouble(String columnLabel) -> obtine valoarea coloanei data ca parametru ca tip Java double; poate tine tipurile SQL DOUBLE si FLOAT
- public int getInt(String columnLabel) -> obtine valoarea coloanei data ca parametru ca tip Java int; poate tine tipul SQL INTEGER
- public float getFloat(String columnLabel) -> obtine valoarea coloanei data ca parametru ca tip Java float; recomandat pentru tipul SQL REAL
- public long getLong(String columnLabel) -> obtine valoarea coloanei data ca parametru ca tip Java long; recomandat pentru tipul SQL BIGINT
- public java.sql.Date getDate(String columnLabel) -> obtine valoarea coloanei data ca parametru ca tip Java Date object; recomandat pentru tipul SQL DATE
- public java.lang.String getString(String columnLabel) -> obtine valoarea coloanei data ca parametru ca tip Java String object; recomandat pentru tipurile SQL CHAR, VARCHAR si LONGVARCHAR
- public java.sql.Time getTime(String columnLabel) -> obtine valoarea coloanei data ca parametru ca tip Java Time object; recomandat pentru tipul SQL TIME
- public java.sql.Timestamp getTimestamp(String columnLabel) -> obtine valoarea coloanei data ca parametru ca tip Java Timestamp object; recomandat pentru tipul SQL TIMESTAMP
- public java.lang.Object getObject(String columnLabel) -> obtine valoarea coloanei data ca parametru ca tip Java object; recomandat pentru orice tip SQL; poate fi folosit pentru a converti un tip SQL la 
clasa wrappper corespunzatoare (Integer, Double)

- Extragerea informatiilor de tip metadata dintr-un ResultSet
-> Sunt multe situatii in care nu stim in avans numele coloanelor, numarul lor, samd
-> Folosind clasa ResultSetMetaData putem obtine informatii importante despre result setul intors, cum ar fi: numarul de cooane, numele tabelei, numele coloanei si numele clasei Java folosita ca sa reprezinta coloana cand este intoarsa ca Object
-> clasa ResultSetMetaData este deseori folosita pentru obtinerea de rapoarte

- Cursorul in ResultSet
-> Comportamentul default al unui Statement este curosr care merge doar inainte si result seturi care nu suporta modificari; aceste variabile pot fi gasite in interfata ResultSet
-> Specificatia JDBC defineste niste variabile statice de tip int in plus care permit programatorului sa mute cursorul inainte, inapoi sau pe o pozitie specifica in result set; in plus, result set ul poate
fi modificat in timp ce e deschis si modificarile pot fi scrise in baza de date
-> Pentru a crea un result set care sa foloseasca un cursor pozitionabil si/sau modificari pe date, trebuie creat un Statement care sa aiba tipul de scroll si setarea de concurenta specifice
-> Un cursor poate fi de 3 feluri: 
- TYPE_FORWARD_ONLY -> setarea defualt, merge doar inainte 
- TYPE_SCROLL_INSENSITIVE -> cursorul poate fi mutat inainte sau inapoi sau pozitionat la o anumita locatie; orice schimbare in date nu este reflectata in result set (result set ul nu tine pasul cu baza de date); in general suportat de bazele de date
- TYPE_SCROLL_SENSITIVE -> cursorul poate fi mutat inainte sau inapoi sau pozitionat la o anumita locatie; orice schimbare in date este reflectata in result set (result set ul tine pasul cu baza de date); foarte dificil de implementat si nu prea des intalnit din aceasta cauza
-> Tipuri de concurenta intr-un result set:
- CONCUR_READ_ONLY -> default, un result set deschis nu poate fi modificat sau schimbat
- CONCUR_UPDATABLE -> un result set deschis poate fi modificat sau schimbat
-> Miscarea cursorului si modificarile concurente nu sunt obligatorii pentru bazele de dae sau pentru JDBC drivere, de aceea putem folosi interfata DatabaseMetaData pentru a determina capabilitatile acestora
-> Crearea obiectului Statement cu un alt tip de cursor/setare de concurenta poate rezulta in exceptie daca nu este suportat, iar driverul va arunca un warning si va reseta valorile la default
-> Metode de pozitionare a cursorului:
- boolean next() -> muta cursorul la urmatorul rand; intoarce false daca cursorul este pozitionat dupa ultimul rand
- boolean previous() -> muta cursorul inapoi un rand; intoarce false faca cursorul este pozitionat inaintea primului rand
- boolean absolute(int row) -> muta cursorul la o pozitie absoluta in result set; mutarea la randul 0, inseamna inaintea primului rand; mutarea la un numar negativ inepe de la ultimul rand si merge inapoi; intoarce false
cand este pozitionat inaintea primului rand sau dupa ultimul rand
- boolean relative(int row) -> muta cursorul la o poitie relativa fata de pozitia curenta; valoare 1 muta cursorul inainte un rand; -1 muta inapoi un rand;  intoarce false
  cand este pozitionat inaintea primului rand sau dupa ultimul rand
- boolean first() -> muta cursorul la primul rand din result set; intoarce false daca result setul este gol
- boolean last() -> muta cursorul la ultimul rand din result set; intoarce false daca result setul este gol
- void beforeFirst() -> muta cursorul inaintea primului rand din ResultSet
- void afterLast() -> muta cursorul dupa ultimul rand in ResultSet

- Modificarea unui ResultSet
-> Un obiect ResultSet poate fi folosit si pentru a modifica continutul unei baze de date sau a sterge/updata/insera randuri
-> Un obiect ResultSet poate fi modificat daca obiectul Statement are setarea de concurenta CONCUR_UPDATABLE
-> Exista metode de updateXXX pentru fiecare tip (Integer, String, Date, etc) care pot primi ca argument un String sau un index de coloana de tip int
-> Putem updata coloane folosind obiecte: metodele getObject() si updateObject() care pot primi ca argument un String sau un index de coloana de tip int ca prim argument si un Object ca argument secundar; String poate fi pasat ca al 2 lea argument pentru orice
tip de date SQL (daca intruneste cerintele metodei valueOf() pentru fiecare tip de date, va putea fi convertit)
-> Pentru inserarea unui nou rand, trebuie sa avem un ResultSet deschis, sa ne mutam pe pozitia de inserare rand, adaugarea valorilor pentru coloane si apoisa facem insertul (sa scriem in baza de date)


- Exceptii
-> Deoarece lucram cu conexiuni JDBC care sunt facute printr-un socket pe retea catre o resursa de baze de date, putem din start sa intampinam probleme: reteaua/baza de date poate fi jos
-> In caz de eroare, avem SqlException care este aruncata; care ne poate da detalii despre eroare prin urmatoarele metode: getMessage(), getlSQLState(), getErrorCode(), getNextError()

- Warninguri
-> Obiectele de tip Connection, Statement si ResultSet pot arunca warninguri; un exemplu este atunci cand setam cursorul/setare de concurenta la un nivel neacceptat de baza de date
-> Resetarea acestor warninguri se face cand obiectul Connection este inchis, un Statement este reexecutat, un ResultSet cand este citit un nou rand sau cand se apeleaza metoda clearWarnings() pentru fiecare obiect

- Inchiderea resurselor de tip SQL
-> Este o practica buna sa inchidem resursele de tip SQL
-> fiecare obiect major JDBC -Connection, Statement, ResultSet- are o metoda close() pentru a ne ajuta sa inchidem explicit resursa; aceste obiecte au o relatie unul cu celalalt, daca unul dintre ele apeleaza close(),
va avea un impact asupra celorlalte
-> O alta practica buna este sa minimizam crearea de obiecte Connection si inchiderea lor deoarece este un proces costisitor
-> Incepand cu Java 7, Connection, Statement, ResultSet implementeaza AutoCloseable (suporta autmoatic resource management) si pot fi folosite in try-with-resources


- Proceduri stocate si functii
-> pentru comenzi SQL parametrizate, putem folosi PreparedStatemnt
-> pentru  apelarea functiilor sau procedurilor, putem folosi CallableStatement
