### **Introduction à la concurrence et aux threads**
+ `Process` est une application unitaire, qui possède son propre espace mémoire.
+ Les termes processus et candidature sont souvent utilisés de manière interchangeable, et je l'ai fait moi-même, et je le ferai à nouveau dans cette section.

### **Espace mémoire du processus = Tas**
+ Chaque application possède son propre espace mémoire, également appelé « le tas ».
+ `Le tas n'est pas partagé` entre deux applications ou deux processus, ils ont chacun le sien.

### **Fil de discussion**
+ `Un thread` est une unité d'exécution unique, au sein d'un processus.
+ `Chaque processus peut avoir plusieurs threads`.
+ Chaque application a au moins un thread, et c'est « le thread principal ».
+ Notre code s'exécutera sur le thread principal.
+ Nous pouvons également faire exécuter notre code dans d'autres threads, que nous pouvons explicitement créer et démarrer.

### **Les threads partagent la mémoire du processus**
+ La création d'un thread ne nécessite pas autant de ressources que la création d'un processus.
+ Chaque thread créé par un processus partage l'espace mémoire de ce processus, le tas.
+ Cela peut causer de gros problèmes avec vos applications.

### **Les threads ont également de la mémoire de pile**
+ Chaque thread possède ce qu'on appelle une pile de threads.
+ Il s'agit de la mémoire à laquelle seul un seul thread aura accès.
+ Chaque application Java s'exécute comme un seul processus, et chaque processus peut alors contenir plusieurs threads.
+ Chaque processus a un tas et chaque thread a une pile de threads.

### **Pourquoi utiliser plusieurs threads ?**
+ Quels sont certains des avantages de la création d'une application multithread ?
+ L'une des raisons les plus courantes est de décharger les tâches de longue durée.
+ Au lieu de bloquer le thread principal, nous pouvons créer des threads supplémentaires pour exécuter des tâches qui peuvent prendre beaucoup de temps.
+ Cela libère le thread principal afin qu'il puisse continuer à travailler, à s'exécuter et à répondre à l'utilisateur.
+ Vous pouvez également utiliser plusieurs threads pour traiter de grandes quantités de données, ce qui peut améliorer les performances des opérations gourmandes en données.
+ Un serveur Web est un autre cas d'utilisation de nombreux threads, permettant de gérer simultanément plusieurs connexions et requêtes.

### **Concurrence**
+ La concurrence fait référence à une application qui fait plus d'une chose à la fois.
+ La concurrence permet « à différentes parties d'un programme de progresser de manière indépendante », conduisant souvent à une meilleure utilisation des ressources et à une amélioration.
+ Il n'est pas nécessaire qu'une tâche soit terminée avant qu'une autre puisse commencer, et « plusieurs threads peuvent faire des progrès incrémentiels ».


### **Threads de Java**
+ Les threads sont les éléments fondamentaux permettant de prendre en charge la concurrence dans une application Java.
+ Ils sont essentiels, car ils nous permettent d'effectuer plusieurs tâches simultanément, au sein d'un seul processus.

### **La classe java.util.Thread**
+ Vous pouvez voir que cette classe implémente l'interface « Runnable », qui a une seule méthode abstraite, la méthode « run ».
+ Chaque instance d'un thread a un état.
+ Les champs affichés ici sont tous encapsulés et cela inclut un groupe de threads, un nom, une priorité, un statut et un identifiant de thread.
+ Un thread peut être construit sans arguments.
+ Il peut être construit en lui passant une instance `Runnable`.
+ La première méthode est la méthode run, qui doit être surchargée, car elle est déclarée abstraite sur l'interface Runnable.


### **Priorité du Thread**
+ La priorité du thread est une valeur comprise entre 1 et 10.
+ La classe de thread trois priorités prédéfinies, incluses sous forme de constantes.

        Thread.MIN_PRIORITY = 1 (low)
        Thread.NORM_PRIORITY = 5 (default)
        Thread.MAX_PRIORITY = 10 (high)

+ Les threads de priorité plus élevée ont de meilleures chances d'être planifiés par un planificateur de threads.
+ Cependant, le comportement des priorités peut varier selon les différents systèmes d'exploitation et implémentations JVM.
+ Vous pouvez considérer cette priorité comme une suggestion pour le processus de gestion des threads.

### **La différence entre exécuter run et start sur un thread**
+ Il y a une grande différence entre appeler `run() et start()`
+ Si vous exécutez la méthode `run`, elle est exécutée `de manière synchrone` par le thread en cours d'exécution à partir duquel elle est invoquée.
+ Si vous souhaitez que votre code soit exécuté `de manière asynchrone, vous devez appeler la méthode start`.


### **Le modificateur natif sur une méthode**
+ Le modificateur `native` indique que le code source de cette méthode n'est pas écrit en java.
+ Il est écrit dans un autre langage, comme C ou C++.
+ Le code de cet exemple fait partie d'une bibliothèque native, telle qu'un fichier dll.

### **Pourquoi utiliser une bibliothèque native**
+ Les raisons de le faire incluent.
  + Pour accéder aux fonctionnalités au niveau du système spécifiques à la plate-forme.
  + Pour s'interfacer avec le matériel.
  + Pour optimiser les performances des tâches qui pourraient nécessiter beaucoup de calculs.

### **Runnable est une interface fonctionnelle**
+ Il est important de reconnaître que `Runnable est une interface fonctionnelle`.
+ Sa méthode fonctionnelle, ou sa méthode d'accès unique, est la méthode `run`.
+ Partout où vous voyez un `type Runnable`, c'est une cible pour une `expression lambda`.
+ Vous pouvez demander à n'importe quelle classe d'implémenter l'interface `Runable` pour s'exécuter de manière asynchrone.

### **Avantages de l'extension du Thread**
+ Vous pouvez mieux contrôler le comportement et les propriétés du thread.
+ Vous pouvez accéder aux méthodes et aux champs du thread directement depuis votre sous-classe.

### **Inconvénients de l'extension du Thread**
+ Vous ne pouvez étendre qu'une seule classe en Java, votre sous-classe ne peut donc étendre aucune autre classe.
+ Votre classe est étroitement couplée à la classe Thread, ce qui peut rendre sa maintenance difficile.

### **Implémentation de Runnable**
+ Cette classe est passée au constructeur Thread, qui accède à un Runnable.
+ Vous pouvez également transmettre une classe anonyme, une expression lambda ou une référence de méthode à ce constructeur, pour créer une instance d'un Thread.
+ Vous appelez à nouveau start sur la nouvelle instance de Thread, pour exécuter le code de manière asynchrone.

### **Avantages de l'implémentation d'un Runnable et de la création d'une instance de Thread avec celui-ci**
+ Vous pouvez étendre n'importe quelle classe tout en implémentant Runnable.
+ Votre classe (si vous créez une classe) est faiblement couplée à la classe Thread, ce qui facilite sa maintenance.
+ Vous pouvez utiliser des classes anonymes, des expressions lambda ou des références de méthodes pour décrire très rapidement le comportement des threads.
+ Vous avez moins de contrôle sur le comportement et les propriétés du thread.
+ En d'autres termes, vous ne pouvez pas accéder directement aux méthodes et champs du thread, depuis la méthode run.


