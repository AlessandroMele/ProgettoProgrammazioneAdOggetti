Repo per il Progetto di Programmazione ad Oggetti A.A. 2019/2020

Il progetto consente di effettuare chiamate:
-GET: "/metadata"
-GET: "/data"
-GET: "/stats"
-POST:"/filters"

<img src="/README_Files/Use Case Diagram.jpg">

L'utente può quindi richiedere di ottenere i dati relativi ai post di un user Facebook, effettuare statistiche su essi in base a determinati parametri (lunghezza del messaggio e presenza di emoji) e di applicare filtri (massimi/minimi di valori di condivisioni, di lunghezza del messaggio e numero di reazioni).

<img src="/README_Files/Sequence Diagram.jpg">

CHIAMATE:

GET: "/metadata"

Esempio di chiamata:"http://localhost:8080/metadata"

Risposta:

[
 { "name": "id", "description": "Identifier of the post", "type": "String" },
 { "name": "message", "description": "Message(or Description) of the post", "type": "String" },
 { "name": "numShares", "description": "Number of Shares about the post", "type": "Integer" },
 { "name": "numReactions", "description": "Number of Reactions about the post", "type": "Integer" }
]

La chiamata con rotta "/metadata" permette di ottenere informazioni sulla classe FacebookPost, in particolare i nomi degli attributi, una breve descrizione e il tipo di dato.

GET: "/data"

Esempio di chiamata: "http://localhost:8080/data"

Esempio di risposta:

[
 { "id": "3310241255674547_3147335141965160",
 "message": "“Riassumendo:\n\n- Vi fate geolocalizzare da Tinder per trovare altri single\n- Vi fate geolocalizzare da Facebook per pubblicità di attività vicino a voi\n- Vi fate geolocalizzare da Google per associare le foto che fate ai luoghi\n- Vi fate geolocalizzare da Runtastic per condividere il percorso del vostro jogging serale\n- Vi fate geolocalizzare da TripAdvisor per capire com'è l'aperitivo al locale in cui state entrando\n- Vi fate geolocalizzare da Apple per quando capiterà forse un giorno di lasciare l'iPhone nel locale in cui avete fatto l'aperitivo\n- Vi fate geolocalizzare dalla app del supermercato per trovare il punto vendita più vicino\n- Vi fate geolocalizzare da Glovo, Just Eat ed altri food delivery per farvi consegnare il cibo a casa\n- Vi fate geolocalizzare da Whatsapp, Messenger, Telegram ed altre app di messaggistica senza un apparente motivo\n- Vi fate geolocalizzare da Subito it per annunci nella vostra città\n\n Però nel pieno di una pandemia globale, è una grave violazione dei dati personali farsi geolocalizzare da un’app per tracciare i contagi e permettere a tutti di uscire da questa situazione il prima possibile.”",
 "numShares": 0,
 "numReactions": 2 },
 { "id": "3310241255674547_1125474974151197",
 "message": "Quando un sogno ha tanti ostacoli vuol dire che è quello giusto!\nWork in progress..💃",
 "numShares": 1,
 "numReactions": 144 },
 { "id": "3310241255674547_3108618742503467",
 "message": "“Il dramma di Internet è che ha promosso lo scemo del villaggio a portatore di verità.”\n- Umberto Eco",
 "numShares": 0,
 "numReactions": 16 },
 { "id": "3310241255674547_1386970144668344",
 "message": "no message",
 "numShares": 2,
 "numReactions": 131 }
]

La chiamata con rotta "/data" permette di ottenere un elenco di post Facebook in formato JSON.
Lo step successivo prevede un parsing del JSON, ove nel caso in cui mancassero dei campi (ad esempio se il post non avesse un messaggio) verranno assegnati valori di default (come nell'esempio di risposta). Dopo di che, i post verranno inseriti in un apposita struttura dati.
In particolare la classe FacebookPost è composta da attributi, quali:
-un identificatore univoco;
-il messaggio (la descrizione, ciò che l'utente ha scritto) nel post;
-il numero di condivisioni del post;
-il numero di reazioni (likes, cuore, abbraccio, arrabiato) del post.

Inoltre il metodo ContainsEmoji() permette di verificare la presenza o meno di emoji nel messaggio; mentre il metodo LengthMessage() restituisce la lunghezza del messaggio (ossia il numero dei caratteri). Si noti che se nel post non fosse presente un messaggio (dunque message = "no message"), tale metodo considererà la lunghezza nulla; accorgimento necessario per non "falsificare" le statistiche.

<img src="/README_Files/Model Class Diagram.jpg">

GET: "/stats"

Esempio di chiamata: "http://localhost:8080/stats?minLength=0&maxLength=10&emoji=notSpecified"

Esempio di risposta:

{
    "minLengthMessage": 0,
    "maxLengthMessage": 10,
    "shares": {
        "average": 0.38,
        "sum": 8,
        "max": 2,
        "min": 0,
        "perch": 38.09,
        "total": 21
    },
    "reactions": {
        "average": 28.8,
        "sum": 605,
        "max": 131,
        "min": 0,
        "perch": 45.48,
        "total": 1330
    }
}

Il package stats contiene la classe StatisticsMethod, un'interfaccia composta da metodi "essenziali"; quali somma, massimo, minimo e media relativamente a un specifico campo.
La classe StatisticsModel implementa i metodi di StastisticsMethods e contiene inoltre gli attributi per memorizzare tali valori, in aggiunta sono presenti
le percentuali e il totale rispetto alla struttura completa.
La classe Statistics di fatto contiene i metodi relativi al "Parsing" della struttura totale rispetto al campo di cui vogliamo calcolare le statistiche.
Ad esempio parseToShare() restituisce un ArrayList<Integer> sui quali si possono calcolare statistiche.
Per la lunghezza minima e massima del messaggio si è scelto di agire con due attributi, "minLengthMessage" e "maxLengthMessage" con relativi metodi, mantenendo il medesimo
modus operandi riguardante gli oggetti di StatisticsModel.

<img src="/README_Files/Stats Class Diagram.jpg">

In particolar modo la richiesta delle statistiche avviene tramite @RequestParam, il quale consente all'utente di scegliere i valori sui quali ottenere risultati:

-"minLength" rappresenta il valore minimo di caratteri;
-"maxLength" il valore massimo;
-"emoji" l'opzione che permette di considerare/ignorare la presenza o meno di queste all'interno del messaggio.

Il metodo che filtrerà in base ai parametri è FilteredPostByParam() (della classe Filtering), successivamente verrà istanziato un oggetto Statistics che effettuerà statistiche in base alla struttura filtrata e quella completa.
Nel caso in cui fossero inseriti range negativi (minLength>maxLength), oppure valori di minimo e/o massimo negativi, interverranno eccezioni personalizzate che avviseranno l'utente di non aver inserito valori corretti.
Per le emoji, si considera:

-"TRUE" post che contengono almeno una emoji;
-"FALSE" post che non contengono emoji;
-"NOTSPECIFIED"  post che contengono e non emoji.

Il metodo operante su emoji è "case unsensitive", ad esempio nel caso in cui fosse inserito "TrUe", esso verrà considerato "TRUE".
Qualsiasi altro valore immesso genera un'eccezione personalizzata che avvisa l'utente di aver inserito una stringa errata (es: "prova").

POST: "/filters"

Esempio di chiamata: "http://localhost:8080/filters"

Esempio di body:
{
 "length":{
	"min": 0,
	"max": 20
	},
"shares":{
    	"min": 0,
    	"max": 400
	},
"reactions":{
    	"min": 0,
    	"max": 400
	}
}

Esempio di risposta:
[
 { "id": "3310241255674547_2986399728058703",
 "message": "no message",
 "numShares": 0,
 "numReactions": 2 },
 { "id": "3310241255674547_2782888908409787",
 "message": "no message",
 "numShares": 0,
 "numReactions": 2 }
]

Il package filters contiene la classe FiltersModel che contiene minimo e massimo di un generico campo, trattati con il medesimo modus operandi di StatisticsModel.
La classe Filters,invece, rappresenta a tutti gli effetti l'oggetto filtro, composto da 3 attributi JSONObject (di cui verrà poi effettuato il parsing) e 3 FiltersModel
La classe Filtering contiene esclusivamente metodi dediti al filtraggio:
-FilteredPostByParam(), discusso precedentemente;
-FilteredPost() si occupa del filtraggio dei post rispetto ai valori inseriti nel body, dunque il filtraggio vero e proprio.
La richiesta dei filtri avviene tramite @RequestBody, il quale consente all'utente di scegliere i campi sui quali filtrare i post mediante un body in formato JSON.
In particolare il body è formato da 3 campi: length (lunghezza del messaggio), shares (numero condivisioni), reactions (numero reazioni); ad ognuno di questi è possibile indicare i corrispettivi valori di minimo e di massimo.
Nel caso in cui mancasse un campo (per esempio "reactions") , verranno impostati i corrispettivi valori di minimo e massimo, selezionati tra tutti i post, mediante il metodo ReadValues().

Esempio di body incompleto:
{
	"length":{
		"min": 0,
		"max": 20
		},
	"shares":{
		"min": 0,
    		"max": 400
		}
}

Nel caso in cui fossero inseriti range di valori negativi (min>max), oppure valori di minimo e/o massimo negativi interverranno opportune eccezioni personalizzate che avviseranno l'utente di aver inserito valori non accettati.

<img src="/README_Files/Filters Class Diagram.jpg">


ECCEZIONI:
Le eccezioni personalizzate gestite sono:
-BadValueException -> se il valore numerico inserito è negativo;
-BadRangeValueException -> se il range di valori numerici inserito è negativo (min>max);
-BadStringException -> se la stringa inserita non è "true","false","notspecified" e relative combinazioni upper/lower case.

<img src="/README_Files/Exceptions Class Diagram.jpg">

DISCLAIMER:  Tutte le funzionalità, le modifiche e i miglioramenti hanno egual contributo da parte dei due candidati, in quanto non è stata optata la soluzione del "dividersi il lavoro da fare" ma bensì è stato tutto discusso e implementato assieme, alternando la condivisione dello schermo. Il numero di commit effettuato dai singoli non incide sul singolo contributo effettivo del progetto.
