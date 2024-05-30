# Multithreading

Java oferă suport încorporat pentru multithreading.

- Un **thread** este de fapt un proces "ușor".Un program multithreaded conține două sau mai multe
  părți care pot rula concurent. Fiecare parte a unui astfel de program se numește **fir de executie** și fiecare
  fir definește o cale separată a execuției.
- **Multithreading** este o formă specializată de multitasking.
- Thread (fir de executie) -> set de instrucțiuni executate într-o ordine clară, definită și independentă
  și paralel cu alte seturi de instrucțiuni ale aceluiași program de aplicație.

- Când avem un singur fir de executie în programul nostru =>  îl numim "program cu un singur fir de executie (sinle threaded program)".
- În Java, primul thread, cel care începe cu metoda principală, se mai numește si **thread principal (main thread)**.
- Când spunem că avem o aplicatie "Single threaded" în Java => înseamnă că avem o aplicație care pornește de la metoda principală și nu creează alte fire de executie.
- Discutăm aici doar despre firele create de noi în programul aplicației; există, de asemenea, alte fire de executie gestionate de JVM, cum ar fi firul pe care rulează
  colectorul de gunoi din Java.
- Sistemul Java run-time depinde de firele de executie pentru multe lucruri. Firele de executie reduc ineficiența prin prevenirea risipei ciclurilor CPU.
- Când avem mai multe fire, nu avem cum să știm ordinea în care va fi executat codul lor.

#### Definirea si pornirea unui fir de executie
- O aplicație care creează o instanță de Thread trebuie să furnizeze codul care va rula în acel fir de executie. Putem face asta in 2 feluri:

-> Subclasam Thread:

- Clasa Thread în sine implementează Runnable, deși metoda sa run() nu face nimic. O aplicația poate subclasa Thread, oferind propria implementare a lui run().
- Această abordare este mai ușor de utilizat în aplicații simple, dar este limitată de faptul că clasa ta  trebuie să fie un descendent al lui Thread.

-> Furnizarea unui obiect Runnable:

- Interfața Runnable definește o singură metodă, run(), menită să conțină codul executat în firul de executie. Obiectul Runnable este transmis constructorului Thread
- Această abordare este mai generică, deoarece obiectul Runnable poate subclasa o altă clasă decât Thread.

#### Starile unui fir de executie (thread):
- **New** - Când creăm o instanță a clasei Thread, un thread este în starea "new".
- **Running** - Firul de executie Java este într-o stare de rulare.
- **Suspended** - Un fir de executie care ruleaza poate fi suspendat, actiune care îi suspendă temporar
  activitatea. Un fir de executie suspendat poate fi apoi reluat, permițându-i să reia de unde a rămas.
- **Blocked** - Un fir de executie Java poate fi blocat atunci când așteapta o resursă.
- **Terminated** - Un fir de executie poate fi oprit, ceea ce oprește imediat executarea acestuia indiferent de moment. Odată ce un fir de executie este oprit, acesta nu poate fi reluat.

###### Întreruperea execuției cu sleep():
- _Thread.sleep_ - determină întreruperea execuției firului curent pentru o perioadă specificată.
- Acesta este un mijloc eficient de a pune timpul procesorului la dispozitia celorlalte fire de executie ale unei aplicatii
  sau la dispozitia altor aplicații care ar putea rula pe un sistem informatic.
- Metoda somnului poate fi, de asemenea, utilizată pentru ritm

#### Wait & notify

- Object.wait() – folosit pentru a suspenda un fir de executie
- Object.notify() – folosit pentru a trezi un fir de executie
- Object.notifyAll() - folosit pentru a trezi toate firele de executie

####  Intreruperi:
- O întrerupere este o indicație pentru un fir de executie că ar trebui să se oprească din ceea ce face și sa faca altceva; Este la latitudinea programatorului să decidă exact cum răspunde 
un fir de executie la o întrerupere, dar este foarte frecvent ca firul să incheie executia (terminate).
- Un fir de executie trimite o întrerupere invocând întreruperea pe obiectul Thread pentru ca firul să să fie întrerupt. Pentru ca mecanismul de întrerupere să funcționeze corect, 
firul întrerupt trebuie să suporte propria întrerupere.

###### Sustinerea Intreruperilor:
- Dacă firul de executie invocă frecvent metode care aruncă InterruptedException, pur și simplu revine din metoda de executare după ce prinde acea excepție
- Multe metode care aruncă InterruptedException, cum ar fi sleep(), sunt concepute pentru a anula funcționarea lor curentă și sa fac return imediat când se primește o întrerupere.
- Ce se întâmplă dacă un fir de executie merge mult timp fără a invoca o metodă care aruncă InterruptedException? In acest caz, trebuie să invoce periodic Thread.interrupted, care intoarce
  true dacă s-a primit o întrerupere.

#### Joinuri
- Metoda de join() permite unui fir de executie să aștepte finalizarea altuia.
- Dacă t este un obiect Thread al cărui thread se execută în prezent, _t.join();_ cauzeaza firul de executie curent sa întrerupa execuția până când firul lui t termină.


#### Sincronizare
- Firele de executie comunică în principal prin partajarea accesului la câmpuri și la  obiectele la care se refera campurile de referinta; această formă de comunicare este extrem de eficientă, 
dar face două tipuri de erori posibile: erori de interferență a firului de executie și erori de consistență a memoriei. Instrumentul necesar pentru prevenirea acestor erori este **sincronizarea**.
- Cu toate acestea, sincronizarea poate introduce disputa firelor de executie (thread contention), care apare atunci când două sau mai multe fire de executie încearcă să acceseze 
aceeași resursă simultan și care provoaca JVM ul sa execute unul sau mai multe fire mai lent sau chiar sa suspende execuția acestora; Starvation și livelock sunt forme de dispută a firelor.


##### Metode sincronizate
- Limbajul de programare Java oferă două expresii de sincronizare de bază: metode sincronizate și declarații sincronizate.
- Pentru a sincroniza o metodă, pur și simplu adăugați cuvântul cheie **_synchronized_** la declarația sa.
- Nu este posibil ca două invocări ale unor metode sincronizate pe același obiect să se intercaleze.
- Atunci când un fir execută o metodă sincronizată a unui obiect, toate celelalte fire de execuție care invocă metode sincronizate pe acelasi obiecte își suspendă execuția 
până când primul fir de executie a terminat cu obiectul
When a synchronized method exits, it automatically establishes a happens-before
relationship with any subsequent invocation of a synchronized method for the same object. This guarantees
that changes to the state of the object are visible to all threads.
Note that constructors cannot be synchronized - using the synchronized keyword with a
constructor is a syntax error.
Synchronizing constructors doesn't make sense, because only the thread that creates
an object should have access to it while it is being constructed.

##### Blocuri sincronizate
- Alături de metode, putem avea și blocuri de cod sincronizate care urmează aceleași principii

#### Deadlock
- Deadlock descrie o situație în care două sau mai multe fire de executie sunt blocate pentru totdeauna, așteptându-se unul pe celălalt.