# Clasa Object. Metode din clasa Object. Interfete. Enumuri. Singleton pattern

#### Clasa Object:
- este clasa de baza in java (pe care toate clasele o extind)
- contine un set de metode care sunt mostenite de toate clasele (toString(), equals(), hashCode(), getClass())
- getClass() este o metoda finala si nu poate fi redefinita, dar restul metodelor trebuie redefinite pentru a intoarce corect informatiile pentru fiecare obiect


#### Metoda equals():
- folosita pentru a compara obiecte intre ele
- implementarea din Object face comparatie superficiala (compara daca 2 referinte pointeaza catre acelasi obiect)
- pentru a compara corect 2 obiecte de acelasi fel, trebuie sa fie suprascrisa si implementarea ei sa tina cont de atributele clasei


#### Contractul equals():
- reflexiv: un obiect trebuie sa fie egal cu el insusi
- simetric: x.equals(y) trebuie sa returneze acelasi rezultat ca y.equals(x)
- tranzitiv: if x.equalshashcode(y) and y.equalshashcode(z), then also x.equalshashcode(z)
- tranzitiv: daca x.equals(y) si y.equals(z), atunci si x.equals(z)
- consistent: valoarea lui .equals() ar trebui sa se schimbe doar daca o proprietate care e continuta in .equals() se schimba (nu sunt permise rezultate aleatorii)
Pentru mai multe detalii, se poate consulta documentatia oficiala Java SE Docs.


#### Metoda hashCode():
- in termeni simpli, hashCode() intoarce o valoare integer, generata de un algoritm de hashing
- pentru a intoarce un hash corespunzator trebuie suprascrisa in subclase, iar immplementarea ei sa tina cont de equals/ de contract

#### Contractul hashCode():
- consistenta interna: valoarea metodei hashCode() ar trebui sa se schimbe daca o proprietate continuta in equals() se schimba
- consistenta equals(): obiectele care sunt egale trebuie sa returneze acelasi hash code
- coliziuni: obiectele inegale pot avea acelasi hash code
- nota: daca equals() este suprascrisa, atunci trebuie suprascrisa si hashCode(), nu doar una dintre ele !

#### Interfete:
- o interfata este un tip abstract ce contine o colectie de metode si constante (este un contract; defineste o caracteristica/un comportament)
- este un concept de baza, folosit pentru a obtine abstractizare, polimorfism si mostenire multipla (o clasa poate implementa mai multe interfete, dar poate extinde o singura clasa)
- o interfata poate contine metode constante, metode abstracte, metode default si metode statice
- o metoda intr-o interfata nu poate fi finala sau protected ( dar poate fi privata incepand cu Java 9)
- variabilele sunt din start publice, statice si finale (indiferent ca scriem acesti modificatori sau nu)

#### Enumuri:
- o clasa de tip Enum este un tip special de clasa care extinde java.lang.Enum
- sunt folosite pentru a face codul mai usor de citit, sa permita verificari la compilare, dar si pentru a interzice pasarea de valori invalide 
- nu se poate instantia folosind operatorul new, deoarece constructorul este privat, iar callul catre constructor se face fara sa vedem (putem sa ne imaginam ca fiecare constanta este pasata constructorului)
- se pot adauga variabile, metode in enum
- fiecare constanta este un obiect al enumului 
- fiecare constanta este public static final
- enumurile sunt usor de folosit in switch uri si in design patternuri
- o singura instanta a constantelor exista in JVM, deci se pot comparara valorile folosind  operatorul ==
- contine metode precum values() - intoarce toate constantele, valueOf() - intoarce constanta corespunzatoare String ului specificat, in caz ca exista , ordinal() - intoarce indexul, la fel ca la array uri

#### Singleton (design pattern):
- un design pattern este un model specific de comunicare intre obiecte si clase care rezolva o problema de design intr-un context specific
- Singleton este un model de tip creational care restrictioneaza o clasa sa intantieze obiecte multiple - clasa este definita in asa fel incat o singura instanta poate exista
- clasa are constructor privat pentru a asigura existenta unei singure instante
- instanta este definita si redata din interiorul clasei printr-o metoda statica