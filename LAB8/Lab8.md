# Serializarea obiectelor. Externalizarea obiectelor. Colectii (partea 1)

###### Serializarea obiectelor
- Este conversia starii unui obiect intru-un sir de bytes, iar deserializarea este procesul invers; altfel
spus, serializarea este conversia unui obiect Java intr-un sir static (secventa) de bytes pe care il
putem salva ulterior intr-o baza de date sau il putem transfera pe retea
- Nu este un proces dependent de platforma; putem serializa un obiect pe o masina virtuala si apoi deserializa pe alta
- Clasele eligibile pentru serializare trebuie sa implementeze interfata marker Serializable
- Folosim clasele high level IO ObjectOutputStream si ObjectInputStream  care fac wrap peste clasele
low level OutputStream si InputStream pentru a serializa/deserializa obiecte
- Cea mai importanta metoda in ObjectOutputStream este:
  public final void writeObject(Object o) throws IOException; -> primeste input un obiect serializabil si il converteste intr-o secventa de bytes
- Cea mai importanta metoda in ObjectInputStream este:
  public final Object readObject() throws IOException, ClassNotFoundException; -> poate citi un sir de bytes si il converteste intr-un obiect Java caruia ii putem face cast la obiectul original
- Dezavantaje:
  -> Cand o clasa implementeaza Serializable, toate subbclasele sale devin serializabile
  -> Daca un obiect contine o referinta catre un obiect, amanadoua trebuie sa implementeze Serializable,
altfel o exceptie de tip NotSerializableException va fi aruncata
  -> Daca unul dintre campurile unui obiect serializabil contine un array de obiecte, atunci toate aceste obiecte trebuie sa fie serializabile,
altfel o exceptie de tip NotSerializableException va fi aruncata
  -> Daca o clasa serializabila extinde o clasa neserializabila, atunci datele membre accesibile ale superclasei nu vor fi serializate
  -> Serializarea nu tine cont de modificatorii de acces ai datelor membre, deci vor fi sallvate in format binar si datele de tip protected/private
  -> Nu salveaza datele membre statice


- JVM asociaza un long (o versiune) fiecarei clase serializabile -> este generat printr-un algoritm de hash
- folosim aceasta versiune pentru a verifica ca obiectele salvate si cele incarcate au aceleasi atribute, deci sunt
compatibile procesului
- Majoritatea ide urile pot genera acest numar automat, pe baza numeleui clasei, al atributelor si modificatorilor de acces; orice
schimbare rezulta in alt long si poate cauza o exceptie de tip InvalidClassException deoarece nu mai corespunde versiunea
- Daca o clasa serializabila nu declara un serialVersionUID, JVM va genera unui automat la runtime; cu toate acestea,
este recomandat ca fiecare clasa sa declare un serialVersionUID, deoarece cel generat este dependent de compilare si poate duce la
  InvalidClassExceptions 
- Cu toate ca serializarea obiectelor este specificata in Java, comportamentul poate fi modificat prin serializare custom
- Serializarea custom este utila cand vrem sa serializam un obiect care contine atribute neserializabile; folosim
 -> private void writeObject(ObjectOutputStream out) throws IOException; si
 -> private void readObject(ObjectInputStream in)
  throws IOException, ClassNotFoundException; pentru a transforma atributele neserializabile in alte forme care pot fi serializate 
- Campurile care nu trebuie serializate (sau nu pot fi serializate) trebuie sa fie marcate ca si "transient" (pentru a fi ignorate la serializare)

###### Externalizarea obiectelor
- Interfata Externalizable extinde Serializable, iar principalul ei tel este sa faciliteze serializarea/deserializarea custom
- Orice clasa care implementeaza aceasta interfata trebuie sa implementeze 2 metode:
-> public void writeExternal(ObjectOutput out) throws IOException; -> adaugam properietatile obiectului aici pentru a serializa. foloseste metode ca writeUTF(), writeInt()
-> public void readExternal(ObjectInput in) throws IOException, 
  ClassNotFoundException; -> pentru deserializare folosim aceasta metoda care foloseste readUTF(), readInt()
- Este o practica buna sa adaugam serialVersionUID manual; daca acesta lipseste, JVM va genera unul care va fi dependent de compilator (poate cauza InvalidClassException)
- Este folosita pentru a serializa obiecte proprietati care nu sunt serializabile
- este mai perfomanta, deoarece nu foloseste reflection