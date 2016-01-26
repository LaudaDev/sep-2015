# sep-2015
Uni project

*Pokretanje Merchant-Web-App

1. Potrebno je u eclipsu otvoriti backend projekat i runovati ga kao obicnu aplikaciju.Nakon toga podici ce se rest services.
2. Potrebeno je podignuti mongo. Uci u folder dbInit. Ukucati sledece komande:
	
	$mongo merchantDatabase dbInit.js 

Ovo ce kreirati bazu merchantDatabase i kolekcije koje su potrebne za funkcionisanje InsuranceApp-a

3. InsuranceApp aplikacija - pokretanje

Sto se tice aplikacije potrebno je uci u folder aplikacije i pokrenuti bower install. neophodni dependency ce biti skinuti u assets/js folder.
Nakon toga odraditi npm install. Kad se zavrsi sa skidanjem node modula pokrenuti gulp.


