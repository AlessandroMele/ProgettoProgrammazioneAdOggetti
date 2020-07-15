# ProgettoProgrammazioneAdOggetti
Repo per il Progetto di Programmazione ad Oggetti A.A. 2019/2020

DISCLAIMER:
Il numero di commit effettuata dai singoli non incide sul singolo contributo effettivo del progetto.
Tutte le funzionalità, le modifiche e i miglioramenti hanno egual contributo da parte dei due candidati, in quanto non è stata optata la soluzione del 
"dividersi  il lavoro da fare" ma bensì è stato tutto discusso e implementato assieme, alternando la condivisione dello schermo.

Il progetto consente di effettuare chiamate:
-GET: "/metadata"
-GET: "/data"
-GET: "/stats"
-POST:"/filters"
![Alt text](/README_Files/Use Case Diagram.jpg?raw=true)

L'utente può quindi richiedere di ottenere i dati, effettuare statistiche su essi in base a determinati parametri (lunghezza del messaggio e presenza di emoji) e di applicare filtri
(massimi/minimi di valori di condivisioni, di lunghezza del messaggio e numero di reazioni).

![Alt text](/README_Files/Sequence Diagram.jpg?raw=true)

CHIAMATE:
GET: "/metadata"
Esempio di chiamata: "http://localhost:8080/data"
Risposta:
[
    {
        "name": "id",
        "description": "Identifier of the post",
        "type": "String"
    },
    {
        "name": "message",
        "description": "Message(or Description) of the post",
        "type": "String"
    },
    {
        "name": "numShares",
        "description": "Number of Shares about the post",
        "type": "Integer"
    },
    {
        "name": "numReactions",
        "description": "Number of Reactions about the post",
        "type": "Integer"
    }
]

La chiamata con rotta "/metadata" permette di ottenere informazioni sulla classe FacebookPost, in particolare i nomi degli attributi, una breve descrizione e il tipo di dato.

GET: "/data"

Esempio di chiamata: "http://localhost:8080/data"
Esempio di risultato:
[
    {
        "id": "3310241255674547_3147335141965160",
        "message": "“Riassumendo:\n\n- Vi fate geolocalizzare da Tinder per trovare altri single\n-
        	Vi fate geolocalizzare da Facebook per pubblicità di attività vicino a voi\n-
        	Vi fate geolocalizzare da Google per associare le foto che fate ai luoghi\n-
        	Vi fate geolocalizzare da Runtastic per condividere il percorso del vostro jogging serale\n-
        	Vi fate geolocalizzare da TripAdvisor per capire com'è l'aperitivo al locale in cui state entrando\n-
        	Vi fate geolocalizzare da Apple per quando capiterà forse un giorno di lasciare l'iPhone nel locale in cui avete fatto l'aperitivo\n-
        	Vi fate geolocalizzare dalla app del supermercato per trovare il punto vendita più vicino\n-
        	Vi fate geolocalizzare da Glovo, Just Eat ed altri food delivery per farvi consegnare il cibo a casa\n-
        	Vi fate geolocalizzare da Whatsapp, Messenger, Telegram ed altre app di messaggistica senza un apparente motivo\n-
        	Vi fate geolocalizzare da Subito it per annunci nella vostra città\n\n
        	Però nel pieno di una pandemia globale, è una grave violazione dei dati personali farsi geolocalizzare da un’app per tracciare i contagi
        e permettere a tutti di uscire da questa situazione il prima possibile.”",
        "numShares": 0,
        "numReactions": 2
    },
    {
        "id": "3310241255674547_1125474974151197",
        "message": "Quando un sogno ha tanti ostacoli vuol dire che è quello giusto!\nWork in progress..💃",
        "numShares": 1,
        "numReactions": 144
    },
    {
        "id": "3310241255674547_3108618742503467",
        "message": "“Il dramma di Internet è che ha promosso lo scemo del villaggio a portatore di verità.”\n- Umberto Eco",
        "numShares": 0,
        "numReactions": 16
    },
    {
        "id": "3310241255674547_1386970144668344",
        "message": "no message",
        "numShares": 2,
        "numReactions": 131
    }
]    

La chiamata con rotta "/data" permette di ottenere un elenco di post Facebook in formato JSON.
Lo step successivo prevede un parsing del JSON, ove nel caso in cui mancassero dei campi (ad esempio se il post non avesse un messaggio) verranno assegnati valori di default
(come nell'esempio di risposta).
Dopo di che, i post verranno inseriti in un apposita struttura dati.

In particolare la classe FacebookPost è composta da attributi, quali un identificatore univoco, il messaggio (la descrizione, ciò che l'utente ha scritto),
il numero di condivisioni e il numero di reazioni (likes, cuore, abbraccio, arrabiato) relativamente a tale post.
Inoltre il metodo ContainsEmoji() permette di verificare la presenza o meno di emoji nel messaggio; mentre il metodo LengthMessage() restituisce la lunghezza del messaggio
(ossia il numero dei caratteri).
Specifichiamo che se nel post non fosse presente un messaggio (dunque message = "no message"), tale metodo considererà la lunghezza nulla; accorgimento necessario per non "falsificare"
le statistiche.
![Alt text](/README_Files/Model Class Diagram.jpg?raw=true)

GET: "/stats"

Esempio di chiamata: "http://localhost:8080/stats?minLength=0&maxLength=10&emoji=notSpecified"
Esempio di risposta:
{
    "averageReactionValue": 28.0,
    "sumReactionValue": 605,
    "maxReactionValue": 131,
    "minReactionValue": 0,
    "maxLengthMessage": 4,
    "maxShareValue": 2,
    "minShareValue": 0,
    "averageShareValue": 0.0,
    "sumShareValue": 8,
    "percPosts": 52.0,
    "percReactions": 45.0,
    "totalReactions": 1330,
    "totalShares": 8
}

Il package stats contiene la classe StatisticsMethod, un'interfaccia composta da metodi "essenziali" (specifiche di progetto) quali condivisioni e lunghezza del messaggio relativi ai post.
La classe Statistics contiene gli attributi:
-massimo, minimo, somma e media per condivisioni e reazioni;
-percentuali delle reazioni e dei post della struttura filtrata rispetto a quella completa;
-massima lunghezza di caratteri tra tutti i messaggi.

Sono presenti le implementazioni dei metodi astratti di StatisticsMethod, in aggiunta ad altri relativi alle reazioni (che abbiamo ritenuto di particolare interesse da analizzare) e
alle percentuali di quest'ultime.
![Alt text](/README_Files/Use Case Diagram.jpg?raw=true)

In particolar modo la richiesta delle statistiche avviene tramite @RequestParam, il quale consente all'utente di scegliere i valori sui quali ottenere risultati:
-"minLength" rappresenta il valore minimo di caratteri sui quali vogliamo operare;
-"maxLength" il valore massimo;
-"emoji" l'opzione che permette di considerare/ignorare la presenza o meno di queste all'interno del messaggio.

La struttura verrà filtrata in base ai valori inseriti, per poi ottenere statistiche fra la struttura filtrata e quella completa.
In particolar modo abbiamo gestito l'implementazione mediante @RequestParam.
Il metodo che filtrerà in base ai parametri è FilteredPostByParam() (della classe Filtering), successivamente verrà istanziato un oggetto Statistics che effettuerà statistiche
in base alla struttura filtrata e quella completa.
Nel caso in cui fossero inseriti range negativi (minLength>maxLength), oppure valori di minimo e/o massimo negativi, interverranno eccezioni personalizzate
che avviseranno l'utente di non aver inserito valori corretti.
Per le emoji, consideriamo con:
-"TRUE" post che contengono almeno una emoji;
-"FALSE" post che non contengono emoji;
-"NOTSPECIFIED" sia post che contengono che non emoji.

Il metodo operante su emoji è "case unsensitive", ad esempio nel caso in cui fosse inserito "TrUe", esso verrà considerato "TRUE".
Qualsiasi altro valore immesso genera un'eccezione personalizzata che avvisa l'utente di aver inserito una stringa errata (es: "prova").

POST: "/filters"
Esempio di chiamata: "http://localhost:8080/filters"
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
    {
        "id": "3310241255674547_2986399728058703",
        "message": "no message",
        "numShares": 0,
        "numReactions": 2
    },
    {
        "id": "3310241255674547_2782888908409787",
        "message": "no message",
        "numShares": 0,
        "numReactions": 2
    }
]

Il package filters contiene la classe Filters, che rappresenta a tutti gli effetti l'oggetto filtro, composto da 3 attributi JSONObject (di cui verrà poi effettuato il parsing)
e i relativi campi di minimo e massimo.
La classe Filtering contiene esclusivamente metodi dediti al filtraggio:
-FilteredPostByParam(), discusso precedentemente;
-FilteredPost() si occupa del filtraggio dei post rispetto ai valori inseriti nel body, dunque il filtraggio vero e proprio.

In particolar modo la richiesta dei filtri avviene tramite @RequestBody, il quale consente all'utente di scegliere i valori sui quali ottenere risultati tramite body
in formato JSON:
![Alt text](/README_Files/Filters Class Diagram.jpg?raw=true)
In particolare abbiamo gestito l'implementazione nel seguente modo:
Ad esempio, nel caso in cui mancasse il campo "reactions", esso verrà gestito ponendo i corrispettivi valori di minimo e massimo tra tutti i post mediante il metodo SetStatsValues().

Esempio:
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

Nel caso in cui fossero inseriti range di valori negativi (min>max), oppure valori di minimo e/o massimo negativi interverranno anche qui opportune eccezioni personalizzate
che avviseranno l'utente di aver inserito valori non accettati.

ECCEZIONI:
![Alt text](/README_Files/Exceptions Class Diagram.jpg?raw=true)
Le eccezioni personalizzate gestite sono:
BadValueException -> se il valore numerico inserito è negativo;
BadRangeValueException -> se il range di valori numerici inseriti è negativo;
BadStringException -> se la stringa inserita non è "true","false","notspecified" e relativi upper/lower case.










