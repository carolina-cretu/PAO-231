# Ascoieri intre clase (agregare si compozitie). Clasele String, StringBuilder si StringBuffer. Obiecte Immutable. Records

In oop, un obiect comunica cu un alt obiect folosind functionalitate si servicii oferite de acel obiect.
Compozitia si agregarea sunt 2 forme de asociere.


#### Aggregare

- este o relatie de tip HAS-A
- este o asociere de tip unidirectional, exemplu: un departament poate avea profesori
- ambele entitati pot supravietui individual, ceea ce inseamna ca daca distrugem o entitate, cealalta entitate nu va fi afectata (putem distruge departamentul, profesorii pot exista si independent)

#### Compozitie

- este tot o relatie de tip HAS-A, doar ca una mai stransa
- ambele entitati depind una de cealalta
- the contained class cannot exist independently of the container. If the container is destroyed, the child is also destroyed
- clasa continuta nu poate exista independent de clasa care o contine. Daca clasa container este distrusa si clasa continuta va fi distrusa (exemplu: o casa cu camere)

#### String

- Stringurile sunt obiecte care sunt sustinute intern de un sir de caractere
- Stringurile sunt immutable. De fiecare data cand incercam sa schimbam un obiect de tip String, se creeaza un nou obiect de fapt
- https://docs.oracle.com/javase/tutorial/java/data/strings.html

#### StringBuilder

- Clasa Stringbuilder reprezinta un sir de caractere mutabil
- este o alternativa la clasa String si la crearea ineficienta de obiecte
- https://docs.oracle.com/javase/tutorial/java/data/buffers.html

#### StringBuffer

- singura diferenta intre StringBuffer si StringBuilder este faptul ca StringBuffer este thread safe - metodele sunt sincronizate astfel incat toate operatiile efectuate pe o anumita instanta
se comporta ca si cum ar fi desfasurate intr-un soi de serie care e consistenta cu ordinea apelurilor de metode facuta de fiecare fr de executie implicat
- deoarece este thread safe, este mai lenta; se recomanda folosirea StringBuilder ori de cate ori este posibil !
- https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuffer.html


#### Este Java “pass-by-reference” or “pass-by-value”?

- Java este intotdeauna **pass-by-value**.
- parametrii de tip obiect sunt de fapt referinte (care sunt pasate prin valoare)


#### Obiecte Immutable

- Odata ce un obiect a fost creat, nu ii putem schimba continutul. Toate clasele wrapper sunt immutable
  (Integer, Boolean, Byte, Short). Clasa String este si ea immutable
- We can create our own immutable class as well by following the rules:
- Putem crea propria clasa immutable daca urmam regulile de mai jos:

◆ Clasa trebuie sa fie final pentru a nu putea fi extinsa.

◆ Membrii clasei trebuie sa fie declarati final (ca sa poate fi initializati o singura data in c
onstructor/bloc si apoi sa nu mai poata fi modificati)

◆ Defininm un constructor cu parametri

◆ Getter methods for all the variables in the class
◆ Metode getter pentru toate variabilele continute in clasa

◆ Don’t expose setter methods (to not have the option to change the value of the
instance variable)
◆ Nu se creeaza metode setter (pentru ca altfel am putea modifica variabilele din exterior)


◆ Cand expunem metode care modifica starea obiectului, intodeauna intoarcem o noua instanta a clasei

◆ Daca clasa contine un obiect mutabil:

● In interiorul constructorului trebuie sa ne asiguram ca folosim o copie clona a argumentului pasat
si nu trebuie sa setam campul mutabil egal cu instanta reala pasata in constructor (asta pentru a impiedica modificarea obiectului)

● Trebuie sa ne asiguram ca intotdeaun returnam o copie clona a campului si nu instanta reala de obiect

#### Records
- Sunt clase immutable care au nevoie doar de numele si tipul campurilor
- Au fost introduse in Java 14 pentru a facilita crearea de clase immutable si a ne scapa de scrierea de codul inutil
- Metodele equals, hashCode si toString, precum si campurile private, finale si constructorul public sunt generate de compilator
- Constructorul public este generat cu un argument pentru fiecare camp din record
- Constructorul poate fi customizat si putem genera constructori cu diferiti parametri
- Metode de tip getter sunt de asemenea generate pentru fiecare camp din record
- Putem adauga metode si variabile de tip static
