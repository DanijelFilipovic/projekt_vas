# Projekt iz kolegija "Višeagentni sustavi"
Implementacija jednostavne umjetne inteligencije (UI) u računalnoj igri primjenom agenata kao konačnih automata. Ovaj projekt je rađen u sklopu kolegija "Višeagentni sustavi."

## Korištene tehnologije
Projekt je rađen u u progamskom jeziku Java, a za njegovu implementaciju korištene su i sljedeće biblioteke i radni okviri:
 + [LWJGL](https://www.lwjgl.org/) (*Lightweight Java Game Library*)
 + [JADE](http://jade.tilab.com/) (*Java Agent DEvelopment Framework*)
 
## Kratak opis
Aplikacija se sastoji od 5 agenata: 1 agent koji "vrti" igru (*Game Agent*), a ostala 4 agenta predstavljaju neprijateljsku UI. Tijekom svakog ciklusa *Game Agent* šalje zahtjev neprijateljskim agentima za ažuriranje, a uz taj zahtjev prilaže stanje okoline (informacije o igraču, zidovima, klopkama i ostalim neprijateljskim agentima). Na temelju vlastitog stanja, trenutne pozicije i stanju okoline, neprijateljski agent će napraviti jedno od sljedećeg:
 + ako je agent u stanju mirovanja i igrač se nalazi van dometa, ne radi išta,
 + ako je agent u stanju mirovanja i igrač se nalazi u dometu, prijeđi u stanje lova,
 + ako je agent u stanju lova i igrač se nalazi van dometa, prijeđi u stanje mirovanja,
 + ako je agent u stanju lova i igrač se nalazi u dometu, pomakni se u njegovom smjeru i pošalji novu poziciju *Game Agent*-u,
 + ako je agent u stanju lova i došlo je do kolizije s sa zidom ili drugim agentom, riješi koliziju,
 + ako je agent u stanju lova i došlo je do kolizije s klopkom, pošalji zahtjev za uklanjanje klopke i prijeđi u "mrtvo" stanje,

*Game Agent* će, također, u svakom ciklusu provjeravati je li došlo do kolizije između neprijateljskog agenta i igrača. Ako je, igra završava s ispisom teksta "*Game Over"*. 

Isto tako, *Game Agent* provjerava i jesu li svi agenti maknuti iz igre. Ako jesu, igra završava s ispisom teksta "*Victory*".
