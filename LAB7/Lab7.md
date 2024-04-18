# Exceptii. Input/Output (Fluxuri I/O). Interfete functionale


Exceptie = eveniment ce se produce in timpul executiei unui program si ce
perturba functionarea corecta a acestuia.

Exemple de exceptii - in cazul unui program ce citeste date din fisier:
- daca fisierul nu exista
- daca nu avem suficiente permisiuni pentru a-l citi


##### Aruncarea exceptiilor

- Exceptiile sunt obiecte => pentru a instantia o exceptie se foloseste cuvantul cheie **new**
- Pentru a arunca o exceptie => se foloseste cuvantul cheie **throw**

Cateva exemple de exceptii:

- Exception:  părintele majorităţii claselor excepţie din Java
- IndexOutOfBoundsException: cand accesam un array/colectie folosind un index ce depaseste marimea alocata a acestuia
- NullPointerException: când se accesează un obiect neinstanţiat (null).
- NoSuchElementException:  când se apelează next pe un Iterator care nu mai conţine un element următor.


În momentul în care se instanţiază un obiect-excepţie, în acesta se reţine
întregul lanţ de apeluri de funcţii prin care s-a ajuns la instrucţiunea
curentă. Această succesiune se numeşte **stack trace** şi se poate afişa
prin apelul **e.printStackTrace()**, unde e este obiectul excepţie.

##### Tratarea exceptiilor

Exceptiile pot fi tratate in doua moduri:

- adaugand **throws** in antetul functiei
- folosind un bloc try-catch

##### Try - catch - finally

- putem avea mai multe blocuri catch inlantuite (!ordinea exceptiilor trebuie sa fie de la
  cea mai specifica la cea mai putin specifica)
- codul din catch se executa in cazul in care se arunca exceptia respectiva
- finally - poate fi adaugat dupa catch; codul din acest bloc se executa **intotdeauna**,
  si daca a fost aruncata exceptia, si daca nu.

##### Clasificarea exceptiilor

Nu toate exceptiile trebuie prinse.


- Checked exceptions: trebuiesc prinse si tratate
- Unchecked exceptions: nu trebuie

###### Exceptii checked

Aceste exceptii ar trebui prinse, tratate, iar apoi executia programului ar trebui
sa fie reluata
Exemplu: daca se citeste numele unui fisier de la tastatura, aplicatia urmand a-l deschide si parsa, in cazul in care acest
fisier nu exista, ar trebui sa aruncam o eroare; aceasta poate fi tratata ulterior, astfel
incat utilizatorul sa-si dea seama ca a intervenit o eroare (ex: sa ii afisam un mesaj de eroare)

###### Erori

- definesc situaţii excepţionale declanşate de factori externi aplicaţiei,
  ce nu pot fi de obicei anticipate sau tratate
  Exemplu: alocarea unui obiect foarte mare =>  OutOfMemoryError.

###### Exceptii de Runtime (exceptii unchecked)

- situatii excepţionale, declanşate de factori interni aplicaţiei.
  Aplicaţia nu poate anticipa şi nu îşi poate reveni dacă acestea sunt aruncate.
- Aceste exceptii de obicei semnaleaza prezenta unui bug in cod, deci in loc sa le prindem, ar trebui sa gasim sursa
  problemei si sa o tratam.
- exemplu: NullPointerException

##### Good practices:

- nu folositi return intr-un bloc finally
- nu folositi throws intr-un bloc finally
- nu ignorati exceptiile (eg: doar sa le printam si sa continuam executia)


##### Fluxuri I/O:
- folosite pentru a procesa input si pentru a produce output
- pachet: **java.io**

Un **stream** reprezinta un flux de date

Tipuri de stream-uri:
- InputStream: folosit pentru a citi date
- OutputStream: folosit pentru a scrie date

#### Byte Streams

- 8 bit (octet)
- clase: FileInputStream/FileOutputStream
- utile daca vrem sa procesam date in format binar (ex: imagini)

#### Character Streams

- 16 bit (character)
- clase: FileReader/FileWriter
- in spate, foloseste tot FileInputStream/FileOutputStream
- utile daca vrem sa procesam caractere Unicode

#### File

- permite operații specifice fișierelor și directoarelor, precum creare, ștergere, mutare etc., mai puțin operații de citire/scriere.

Metode uzuale ale clasei File:
- String getAbsolutePath() – returnează calea absolută a unui fișier;
- String getName() – returnează numele unui fișier;
- boolean createNewFile() – creează un nou fișier, iar dacă fișierul există deja metoda returnează false;
- File[] listFiles() – listeaza fisierele dintr-un director

#### DataInputStream & DataOutputStream

- permit citirea și scrierea datelor la nivel de tipuri de date primitive
- clase: DataInputStream/DataOutputStream


#### Fluxuri I/O folosind buffer

- numar mare de accesari => probleme de performanta
  Clase:
- BufferedReader, BufferedWriter – fluxuri de procesare la nivel de buffer de caractere
- BufferedInputStream, BufferedOutputStream – fluxuri de procesare la nivel de buffer de octeți

#### Interfete functionale

Incepand cu Java 8 => suport pentru programare functionala

_Lambda_ este un concept din programarea functionala si reprezinta o functie anonima

**Interfata functionala** => interfete ce contin fix o metoda abstracta.
Acestea pot fi implementate folosind expresii lambda.
Acestea au fost introduse pentru a reduce numarul de linii de cod scrise, si pentru a permite
pasarea functiilor ca si parametru altor metode.

- package: _java.util.function_ - interfete functionale uzuale, predefinite

#### Function

- primeste un parametru si intoarce un rezultat
- metoda abstracta: apply(Object)

#### BiFunction

- primeste 2 parametrii si intoarce un rezultat
- metoda abstracta: apply(Object, Object);

- IntFunction, DoubleFunction, IntToDoubleFunction, IntToLongFunction,
  DoubleToIntFunction,
  DoubleToLongFunction, LongToDoubleFunction, and LongToIntFunction.

#### Predicate

- primeste un parametru si returneaza Boolean
- metoda abstracta: test(Object)
- BiPredicate: primeste 2 parametrii

#### Supplier:

- nu primeste nici un parametru si returneaza un rezultat
- metoda abstracta: get()
- IntSupplier, DoubleSupplier, BooleanSupplier, LongSupplier

#### Consumer:

- primeste un parametru si nu returneaza nimic (void)
- metoda abstracta: accept(Object)
- IntConsumer, LongConsumer, DoubleConsumer, BiConsumer, ObjtIntConsumer,
  ObjLongConsumer, ObjDoubleconsumer

#### UnaryOperator

- primeste un parametru si returneaza un rezultat de acelasi tip
- metoda abstracta: apply(Object)
- IntUnaryOperator, DoubleUnaryOperator, LongUnaryOperator

#### BinaryOperator

- primeste 2 parametrii si returneaza un rezultat de acelasi tip
- metoda abstracta: apply(Object, Object)
- IntBinaryOperator, LongBinaryOperator, DoubleBinaryOperator

#### Interfete functionale custom

- @FunctionalInterface
- compilatorul va arunca o eroare in cazul in care avem mai mult de o metoda abstracta