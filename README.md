# Humanitas Connect

Humanitas Connect je Android aplikacija namijenjena za pokretanje, pregled i upravljanje humanitarnim akcijama. Aplikacija omogućava korisnicima kreiranje akcija prikupljanja pomoći, pretraživanje aktivnih projekata, te praćenje statusa i ciljeva humanitarnih aktivnosti u realnom vremenu.

Projekat je razvijen kao dio praktičnih obaveza na predmetu Razvoj mobilnih aplikacija (RMA).



## Ključne funkcionalnosti

Aplikacija pokriva kompletan korisnički tok i specifikacije definisane projektnim zadatkom:

1. Splash Screen: Prvi ekran koji prikazuje vizuelni identitet aplikacije i priprema resurse za rad.
2. Korisnička autentifikacija (Login i Registracija): Sigurna prijava i registracija novih korisnika uvezana sa Firebase Authentication sistemom putem e-maila i lozinke.
3. Početna stranica (Home Landing Page): Dinamički prikaz svih aktivnih humanitarnih akcija povučenih iz baze podataka u realnom vremenu.
4. Pretraživanje (Search View): Napredno filtriranje i pretraga humanitarnih akcija po ključnim riječima (naslovu) direktno tokom kucanja.
5. UI praznog ekrana (Empty State): Prilagođeni vizuelni prikaz koji informiše korisnika ukoliko trenutno nema aktivnih akcija ili nema rezultata pretrage.
6. Dodavanje novih akcija: Forma koja omogućava prijavljenim korisnicima unos naslova, opisa i finansijskog cilja nove humanitarne akcije, koja se odmah sinhronizuje sa bazom.
7. Korisnički profil: Prikaz informacija o trenutno prijavljenom korisniku, opcija za slanje linka za promjenu lozinke na e-mail, te potpuna odjava sa sistema.
8. Postavke (Settings): Ekran sa kontrolama za prilagođavanje aplikacije korisniku (uključivanje i isključivanje obavještenja).



## Tehnologije i arhitektura

* Razvojno okruženje: Android Studio (Java).
* Baza podataka: Firebase Realtime Database (za skladištenje i sinhronizaciju akcija u realnom vremenu).
* Autentifikacija: Firebase Authentication.
* Arhitektonski pristup: Logika čistog koda (Clean Code) uz razdvajanje korisničkog interfejsa (UI layouts) od poslovne logike aplikacije.
* UI komponente: RecyclerView sa prilagođenim adapterom (ActionAdapter) za efikasan prikaz liste, ConstraintLayout, Toolbar i FloatingActionButton.



## Setup projekta i pokretanje

Da biste pokrenuli ovaj projekat lokalno u Android Studiju, ispratite sljedeće korake:

1. Klonirajte repozitorij:
   git clone https://github.com/AdinN20/projekat2rma.git

2. Otvaranje u Android Studiju:
   * Pokrenite Android Studio.
   * Izaberite opciju Open i pronađite klonirani folder projekta.
   * Sačekajte da Gradle završi indeksiranje i sinhronizaciju zavisnosti (Gradle Sync).

3. Povezivanje sa Firebase-om:
   * Kreirajte novi projekat na Firebase Konzoli.
   * Dodajte Android aplikaciju sa paketom com.example.humanitasconnect.
   * Preuzmite fajl google-services.json i stavite ga u direktorijum app/.
   * Omogućite Email/Password autentifikaciju i pokrenite Realtime Database.

4. Pokretanje aplikacije:
   * Izaberite željeni emulator ili povežite fizički Android uređaj.
   * Kliknite na ikonicu Run (Shift + F10).



## Autor i dozvole

* Student: Adin Pirić
* Ustanova: Visoka škola Internacionalna poslovno-informaciona akademija Tuzla (IPI)
* Predmet: Razvoj mobilnih aplikacija (RMA)

Napomena: Pristup ovom GitHub repozitoriju omogućen je predmetnom profesoru i asistentu na službene e-mail adrese navedene u specifikaciji zadatka.
