### **Introduction à la concurrence et aux threads**
+ `Process` est une application unitaire, qui possède son propre espace mémoire.
+ Les termes processus et candidature sont souvent utilisés dev manière interchangeable, et je l'ai fait moi-même, et je le ferai à nouveau dans cette section.

### **Espace mémoire du processus = Tas**
+ Chaque application possède son propre espace mémoire, également appelé « le tas ».
+ `Le tas n'est pas partagé` entre deux applications ou deux processus, ils ont chacun le sien.

### **Fil dev discussion**
+ `Un thread` est une unité d'exécution unique, au sein d'un processus.
+ `Chaque processus peut avoir plusieurs threads`.
+ Chaque application a au moins un thread, et c'est « le thread principal ».
+ Notre code s'exécutera sur le thread principal.
+ Nous pouvons également faire exécuter notre code dans d'autres threads, que nous pouvons explicitement créer et démarrer.

### **Les threads partagent la mémoire du processus**
+ La création d'un thread ne nécessite pas autant dev ressources que la création d'un processus.
+ Chaque thread créé par un processus partage l'espace mémoire dev ce processus, le tas.
+ Cela peut causer dev gros problèmes avec vos applications.

### **Les threads ont également dev la mémoire dev pile**
+ Chaque thread possède ce qu'on appelle une pile dev threads.
+ Il s'agit dev la mémoire à laquelle seul un seul thread aura accès.
+ Chaque application Java s'exécute comme un seul processus, et chaque processus peut alors contenir plusieurs threads.
+ Chaque processus a un tas et chaque thread a une pile dev threads.

### **Pourquoi utiliser plusieurs threads ?**
+ Quels sont certains des avantages dev la création d'une application multithread ?
+ L'une des raisons les plus courantes est dev décharger les tâches dev longue durée.
+ Au lieu dev bloquer le thread principal, nous pouvons créer des threads supplémentaires pour exécuter des tâches qui peuvent prendre beaucoup dev temps.
+ Cela libère le thread principal afin qu'il puisse continuer à travailler, à s'exécuter et à répondre à l'utilisateur.
+ Vous pouvez également utiliser plusieurs threads pour traiter dev grandes quantités dev données, ce qui peut améliorer les performances des opérations gourmandes en données.
+ Un serveur Web est un autre cas d'utilisation dev nombreux threads, permettant dev gérer simultanément plusieurs connexions et requêtes.

### **Concurrence**
+ La concurrence fait référence à une application qui fait plus d'une chose à la fois.
+ La concurrence permet « à différentes parties d'un programme dev progresser dev manière indépendante », conduisant souvent à une meilleure utilisation des ressources et à une amélioration.
+ Il n'est pas nécessaire qu'une tâche soit terminée avant qu'une autre puisse commencer, et « plusieurs threads peuvent faire des progrès incrémentiels ».


### **Threads dev Java**
+ Les threads sont les éléments fondamentaux permettant dev prendre en charge la concurrence dans une application Java.
+ Ils sont essentiels, car ils nous permettent d'effectuer plusieurs tâches simultanément, au sein d'un seul processus.

### **La classe java.util.Thread**
+ Vous pouvez voir que cette classe implémente l'interface « Runnable », qui a une seule méthode abstraite, la méthode « run ».
+ Chaque instance d'un thread a un état.
+ Les champs affichés ici sont tous encapsulés et cela inclut un groupe dev threads, un nom, une priorité, un statut et un identifiant dev thread.
+ Un thread peut être construit sans arguments.
+ Il peut être construit en lui passant une instance `Runnable`.
+ La première méthode est la méthode run, qui doit être surchargée, car elle est déclarée abstraite sur l'interface Runnable.


### **Priorité du Thread**
+ La priorité du thread est une valeur comprise entre 1 et 10.
+ La classe dev thread trois priorités prédéfinies, incluses sous forme dev constantes.

        Thread.MIN_PRIORITY = 1 (low)
        Thread.NORM_PRIORITY = 5 (default)
        Thread.MAX_PRIORITY = 10 (high)

+ Les threads dev priorité plus élevée ont dev meilleures chances d'être planifiés par un planificateur dev threads.
+ Cependant, le comportement des priorités peut varier selon les différents systèmes d'exploitation et implémentations JVM.
+ Vous pouvez considérer cette priorité comme une suggestion pour le processus dev gestion des threads.

### **La différence entre exécuter run et start sur un thread**
+ Il y a une grande différence entre appeler `run() et start()`
+ Si vous exécutez la méthode `run`, elle est exécutée `dev manière synchrone` par le thread en cours d'exécution à partir duquel elle est invoquée.
+ Si vous souhaitez que votre code soit exécuté `dev manière asynchrone, vous devez appeler la méthode start`.


### **Le modificateur natif sur une méthode**
+ Le modificateur `native` indique que le code source dev cette méthode n'est pas écrit en java.
+ Il est écrit dans un autre langage, comme C ou C++.
+ Le code dev cet exemple fait partie d'une bibliothèque native, telle qu'un fichier dll.

### **Pourquoi utiliser une bibliothèque native**
+ Les raisons dev le faire incluent.
  + Pour accéder aux fonctionnalités au niveau du système spécifiques à la plate-forme.
  + Pour s'interfacer avec le matériel.
  + Pour optimiser les performances des tâches qui pourraient nécessiter beaucoup dev calculs.

### **Runnable est une interface fonctionnelle**
+ Il est important dev reconnaître que `Runnable est une interface fonctionnelle`.
+ Sa méthode fonctionnelle, ou sa méthode d'accès unique, est la méthode `run`.
+ Partout où vous voyez un `type Runnable`, c'est une cible pour une `expression lambda`.
+ Vous pouvez demander à n'importe quelle classe d'implémenter l'interface `Runable` pour s'exécuter dev manière asynchrone.

### **Avantages dev l'extension du Thread**
+ Vous pouvez mieux contrôler le comportement et les propriétés du thread.
+ Vous pouvez accéder aux méthodes et aux champs du thread directement depuis votre sous-classe.

### **Inconvénients dev l'extension du Thread**
+ Vous ne pouvez étendre qu'une seule classe en Java, votre sous-classe ne peut donc étendre aucune autre classe.
+ Votre classe est étroitement couplée à la classe Thread, ce qui peut rendre sa maintenance difficile.

### **Implémentation dev Runnable**
+ Cette classe est passée au constructeur Thread, qui accède à un Runnable.
+ Vous pouvez également transmettre une classe anonyme, une expression lambda ou une référence dev méthode à ce constructeur, pour créer une instance d'un Thread.
+ Vous appelez à nouveau start sur la nouvelle instance dev Thread, pour exécuter le code dev manière asynchrone.

### **Avantages dev l'implémentation d'un Runnable et dev la création d'une instance dev Thread avec celui-ci**
+ Vous pouvez étendre n'importe quelle classe tout en implémentant Runnable.
+ Votre classe (si vous créez une classe) est faiblement couplée à la classe Thread, ce qui facilite sa maintenance.
+ Vous pouvez utiliser des classes anonymes, des expressions lambda ou des références dev méthodes pour décrire très rapidement le comportement des threads.
+ Vous avez moins dev contrôle sur le comportement et les propriétés du thread.
+ En d'autres termes, vous ne pouvez pas accéder directement aux méthodes et champs du thread, depuis la méthode run.


### **États des threads sur Thread.State**

|||
|------|----------------------------------------------------|
|`NEW`|Un thread qui n'a pas encore démarré est dans cet état|
|`RUNNABLE`|Un thread s'exécutant dans la machine virtuelle Java est dans cet état|
|`BLOCKED`|Un thread bloqué en attente du verrouillage d'un moniteur est dans cet état|
|`WAITING`|Un thread qui attend indéfiniment qu'un autre thread effectue une action particulière est dans cet état|
|`TIMED_WAITING`|Un thread qui attend qu'un autre thread exécute une action pendant un temps d'attente spécifié est dans l'état|
|`TERMINATED`|Un thread qui s'est terminé est dans cet état|

### **Thread accédant à la mémoire**
+ Chaque thread a sa propre pile pour les variables locales et les appels dev méthode.
+ Un thread n'a pas accès à la pile d'un autre thread.
+ Cet espace mémoire partagé permet à tous les threads, dev lire et dev modifier les mêmes objets.
+ Lorsqu'un thread modifie un objet sur le tas, ces modifications sont visibles par les autres threads.


### **Découpage du temps**
+ `Time Slicing` est également connu sous le nom dev partage dev temps ou dev division du temps.
+ C'est une technique utilisée dans les systèmes d'exploitation multitâches, pour permettre à plusieurs threads ou processus dev partager un seul processeur pour l'exécution.
+ Le temps CPU disponible est découpé en petits intervalles dev temps, qui sont répartis entre les threads.
+ Chaque thread obtient cet intervalle, pour tenter dev progresser sur les tâches qu'il doit accomplir.
+ Qu'il termine sa tâche ou non, dans ce laps dev temps, n'a pas d'importance pour le système dev gestion des threads.
+ Une fois le temps écoulé, il doit céder à un autre thread et attendre à nouveau son tour.
+ Malheureusement, lorsque vos threads partagent dev la mémoire tas, les choses peuvent changer pendant cette attente.

### **Le modèle dev mémoire Java (JMM)**
+ Le modèle dev mémoire Java est une « spécification » qui définit certaines règles et comportements pour les threads, pour aider à contrôler et gérer l'accès partagé aux données et aux opérations.
+ `Atomicité des opérations`. Peu d’opérations sont véritablement atomiques.
+ La `synchronisation` est le processus dev contrôle dev l'accès des threads aux ressources partagées.

### **Thread-Safe**
+ Un objet ou un bloc dev code est thread-safe, s'il n'est pas compromis, par l'exécution dev threads concurrents.
+ Cela signifie que l'exactitude et la cohérence dev la sortie du programme ou son état visible ne sont pas affectés par les autres threads.
+ Les opérations atomiques et les objets immuables sont des exemples dev code thread-safe.

### **Erreurs dev cohérence mémoire**
+ Le système d'exploitation peut extraire des variables du tas et « faire une copie » dev la valeur dans le cache dev stockage dev chaque thread.
+ Chaque thread possède sa propre mémoire dev stockage petite et rapide, qui contient sa propre copie dev la valeur d'une ressource partagée.
+ Un thread peut modifier une variable partagée, mais ce « changement peut ne pas être immédiatement reflété ou visible ».
+ Au lieu dev cela, il est d'abord mis à jour dans le cache local du thread.
+ Le système d'exploitation ne peut pas vider les modifications du premier thread dans le tas tant que le thread n'a pas fini dev s'exécuter.


### **volatile**
+ Le mot-clé `volatile` est utilisé comme modificateur pour les variables dev classe.
+ C'est un « indicateur » que la valeur dev cette variable peut être modifiée par plusieurs threads.
+ Ce modificateur « garantit » que la variable est toujours lue et écrite dans la mémoire principale, plutôt que depuis des caches spécifiques aux threads.
+ Cela assure la cohérence dev la mémoire pour la valeur dev cette variable entre les threads.
+ `volatile` a une utilisation limitée.

### **Quand utiliser volatile**
+ Il existe des scénarios spécifiques dans lesquels vous souhaiterez utiliser volatile.
  + Lorsqu'une variable est utilisée pour suivre l'état d'une ressource partagée, comme un compteur ou un indicateur.
  + Lorsqu'une variable est utilisée pour communiquer entre les threads.

### **Quand NE PAS utiliser volatile**
+ Lorsqu'une variable n'est que par un seul thread.
+ Lorsqu'une variable est utilisée pour stocker une grande quantité dev données.


### **Créer un fil de discussion coûte cher**
+ Créer des threads, les détruire, puis les recréer peut coûter cher.
+ Un pool de threads atténue le coût, en conservant un ensemble de threads, dans un pool, pour les travaux actuels et futurs.
+ Les threads, une fois qu'ils ont terminé une tâche, peuvent ensuite être réaffectés à une autre tâche, sans avoir à détruire ce thread et à en créer un nouveau.

### **Les mécanismes d'un pool de threads**
+ Un pool de threads se compose de trois composants.
+ Les `Worker Threads` sont disponibles dans un pool pour exécuter des tâches. Ils sont pré-créés et maintenus en vie tout au long de la durée de vie de l'application.
+ Les « tâches soumises » sont placées dans une file d'attente premier entré, premier sorti. Les threads extraient les tâches de la file d'attente et les exécutent, de sorte qu'elles soient exécutées dans l'ordre dans lequel elles sont soumises.
+ `Le Thread Pool Manager` alloue des tâches aux threads et assure une bonne synchronisation des threads.

### **Classes de pool de threads de Java**
+ Java propose cinq variantes du Thread Pool.

|Classe|Description| Méthode des exécuteurs    |
|------|------------|---------------------------|
|`FixedThreadPool`|Possède un nombre fixe de threads| `newFixedThreadPool`      |
|`CachedThreadPool`|Crée de nouveaux threads selon les besoins, il s'agit donc d'un pool de taille variable| `newCachedThreadPool`     |
|`ScheduledThreadPool`|Peut planifier des tâches pour qu'elles s'exécutent à une heure précise ou à intervalles réguliers| `newScheduledThreadPool`  |
|`WorkStealingPool`|Utilise un algorithme de vol de travail pour répartir les tâches entre les threads du pool| `newWorkStealingPool`     |
|`ForkJoinPool`| `WorkStealingPool` spécialisé pour exécuter `FokJoinTasks`. | `n/a`                     |

### **Différence entre Runnable et Callable**
+ Quelle est la différence entre `Runnable et Callable ?`.

|Méthode fonctionnelle de Runnable| Méthode fonctionnelle de Callable |
|---------------------------------|-----------------------------------|
|**`void run()`**| **`V call() throws Exception`**   |

+ De manière significative, Callable renvoie une valeur. Cela signifie que vous pouvez récupérer les données de vos threads en cours d'exécution.

### **exécuter ou soumettre**
+ Dans cette partie, je vous montre les signatures de méthodes pour l'exécution et la soumission.

|method| signature                                                                                                                                           |
|------|-----------------------------------------------------------------------------------------------------------------------------------------------------|
|execute| **`void execute (Runnable command)`**                                                                                                               |
|submit| **`Future<?> submit(Runnable task)`** <br/> **`<T> Future<T> submit(runnable task, T result)`** <br/> **`<T> Future<T> submit(Callable<T> task)`**  |


