# Interfete -> metode private, statice, default si clase adaptor. Interfete marker. Controlul mostenirii.

###### Sintaxa interfete:
public interface numeInterfa.a{
constante //public, static si final
metode abstracte (fara implementare) //public si abstract
metode implicite (default) cu implementare
metode statice cu implementare
metode private cu implementare

###### Metode default in interfete
- Metodele default au aparut in Java 8
- Metodele default au aparut din necesitatea de a adauga cod nou in interfete care au multiple implementari
- Acestea sunt implicit publice si se declara folosind cuvantul cheie 'default'; au implementare definitia in interfata
fara a a forta implementarile sa le adauge; ele ne ajuta sa adaugam metode noi in interfete care sunt disponibile
automat in clasele care le implementeaza (deci nu trebuie sa modificam clasele care implementeaza interfetele)
- Cu metodele default se pastreaza compatibilitatea inversa (backwards compatibility)
- De retinut:
- -> Daca o clasa implementeaza 2 interfete ce contin metode default cu aceeasi semnatura, este obligata sa implementeze metoda/metodele default
pentru a rezolva conflictul (diamond problem)
- -> se poate folosi in implementarea metodelor default una sau amandoua implementari default din interfete !

###### Metode statice in interfete
- Metodele statice au aparut in Java 8
- ele au fost adaugate pentru a oferi un mecanism care ne permite sa crestem nivelul de coeziune al unui design prin alaturarea
metodelor inrudite intr-un singur loc fara a fi nevoie sa cream un obiect (acelasi lucru se poate obtine si cu o clasa abstracta,
diferenta este ca aceasta are constructori, stare si comportament)
- Metodele statice in interfete fac posibila gruparea metodelor utilitare fara a crea clase utilitare artificiale care sunt simple placeholdere
- Definirea unei metode statice intr-o interfata este identica cu definirea unei metode statice intr-o clasa
- Fiind statice, aceste metode nu fac parte din API ul claselor care implementeaza interfata, deci sunt chemate folosind NumeInterfata.NumeMetodaStatica
- O metoda statica poate fi invocata dintr-o alta clasa statica sau default


###### Metode private in interfete
- Au fost adaugate in Java 9
- au fost adaugate pentru a inlatura codul duplicat din metodele default (daca exista cod comun, se poate adauga in metode private) -> astfel ea nu este apelata din exteriorul interfetei
- Nu pot fi abstracte
- Pot fi statice, dar nu default


###### Clase adaptor
- Clasele adaptor sunt clasele care implementeaza minimal toate metodele din interfata
- Ele ajuta la implementarea interfetelor cu multiple metode abstracte, deoarece putem extinde direct clasa adaptor si putem redefini doar metodele care ne intereseaza
- Un astfel de exemplu este interfata MouseListener, care are multiple metode ce definesc evenimente de tip mouse -> clasa adaptor MouseAdapter


###### Interfete marker
- Interfetele marker sunt interfete care nu au metode si nici constante definite
- Furnizeaza informatii la runtime masinii virtuale/compilatorului despre obiecte
- Exista mai multe interfete marker in jdk, exemple: Cloneable, Serializable, Remote
- In cazul interfetei Cloneable, daca incercam sa clonam un obiect care nu implementeaza aceasta interfata, masina virtuala va arunca o exceptie de tip 
CloneNotSupportedException, ceea ce ne demonstreaza ca interfata Cloneable este un indicator pentru masina virtuala ca putem chema
Object.clone()
- In mod similar, JVM va arunca NotSerializableException daca icnercam sa apelam ObjectOutputStream.writeObject() pe
un obiect care nu implementeaza interfata Serializable
- Putem crea si interfete marker custom 
- Adnotarile sunt o alternativa pentru a obtine acelasi rezultat ca interfetele marker, diferenta 
consta in faptul ca putem tine cont de polimorfism cu interfetele marker si putem adauga restrictii suplimentare

###### Controlul mostenirii
- A fost introdus in java 17
- A fost introdus pentru a avea un control mai granular asupra mostenirii
- Prin acest mecanism, clasele si interfetele definesc subtipurile ce le pot avea (o clasa sau o interfata pot defini
 ce clase le pot extinde/implementa)
- Este un feature util pentru modelarea domeniului (imaginati-va un business care lucreaza cu vehicule de orice tip, cu exceptia celor pe 2 roti) si cresterea securitatii librariilor
- introduce cativa noi modificatori: sealed, non-sealed si permits.
- Restrictii:
-> toate subclasele permise trebuie sa apartina aceluiasi modul ca si clasa sealed
-> fiecare subclasa permisa trebuie sa extinda clasa seamed in mod explicit
-> fiecare subclasa permisa trebuie sa defineasca un modificator: final, sealed sau non-sealed.