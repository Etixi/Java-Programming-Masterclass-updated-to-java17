### **Mutable vs Immuable**
+ Les objets ont un état, qui correspond aux champs d'instance stockés dans les données.
+ L'état peut changer après la création d'un objet, que ce soit intentionnellement ou non.
+ Lorsque l'état reste constant tout au long de la durée de vie de l'objet et que le code ne peut pas changer d'état, cet objet est appelé « objet mutable ».
+ Un « objet immuable » est un objet dont l'état interne reste constant.
+ Un `objet mutable` est un objet dont l'état interne ne reste pas constant.
+ Quel est le meilleur ?
+ Eh bien, comme toute autre chose, ça dépend.

### **Objets immuables - Avantages**
+ Travailler avec des objets présente certains avantages.
+ `Un objet immuable` n'est pas sujet à des modifications indésirables, imprévues et involontaires, appelées effets secondaires.
+ `Une classe immuable` est intrinsèquement `thread-safe`, car aucun thread ne peut la modifier une fois qu'elle a été construite.
+ Cela nous permet d'utiliser des collections et des opérations plus efficaces, qui n'ont pas à gérer la synchronisation des accès à cet objet.
+ Ce sont deux avantages les plus importants.

### **Objets immuables - Inconvénients**
+ Travailler avec des objets immuables présente certains inconvénients.
+ Un `objet immuable` ne peut pas être modifié après sa création.
+ Cela signifie que lorsqu'une nouvelle valeur est nécessaire, vous devrez probablement faire une copie de l'objet avec la nouvelle valeur.
+ Vous vous souviendrez de la discussion comparant  `String vs StringBuilder`.
+ Si vous avez constamment besoin de modifier les valeurs du texte, il est plus efficace d'utiliser un objet mutable comme une instance `StringBuiler`, générant des tonnes de `nouveaux objets String`.

### **La classe doit être conçue pour produire des objets immuables**
+ Je parlerai de la conception de classes immuables à venir.
+ Il est important de comprendre que les `POJO et Java Beans`, créés par de nombreux outils de génération de code, ne sont pas par conception immuables, et par conséquent, cette architecture n'est peut-être pas la conception préférée pour votre classe.
+ Tout cela semble plutôt simple, mais de nombreux sujets y sont liés.
+ L'un des outils les plus utiles de notre arsenal pour créer des classes immuables est le modificateur d'accès final.
+ Je reviendrai sur ce modificateur beaucoup plus en détail.

### **Mutable vs Immuable**
+ Les objets ont un état, qui correspond aux champs d'instance stockés dans les données.
+ L'état peut changer après la création d'un objet, que ce soit intentionnellement ou non.
+ Lorsque l'état reste constant tout au long de la durée de vie de l'objet et que le code ne peut pas changer d'état, cet objet est appelé « objet mutable ».
+ Un « objet immuable » est un objet dont l'état interne reste constant.
+ Un `objet mutable` est un objet dont l'état interne ne reste pas constant.
+ Quel est le meilleur ?
+ Eh bien, comme toute autre chose, ça dépend.

### **Le modificateur final en Java**
+ Lorsque nous utilisons le « modificateur final », nous pouvons empêcher toute modification supplémentaire de ce composant.
    + Une `méthode finale` signifie qu'elle ne peut pas être remplacée par une sous-classe.
    + Un « champ final » signifie que le champ d'un objet ne peut pas être réaffecté ou recevoir une valeur différente après son initialisation.
    + Un `finals static` est un champ de classe qui ne peut pas être réaffecté, ni recevoir une valeur différente, après le processus d'initialisation de la classe. Un champ déclaré sur une interface est toujours « public, statique et final ».
+ Une `classe finale` ne peut pas être surchargée, ce qui signifie qu'aucune classe ne peut l'utiliser, dans la clause extends.
    + Une `variable finale`, dans un bloc de code, signifie qu'une fois qu'une valeur lui a été attribuée, tout code restant dans le bloc ne peut pas la changer.
    + `Un paramètre de méthode final signifie que nous ne pouvons pas attribuer une valeur différente à ce paramètre dans le bloc de code de méthode`.

### **Utilisation du modificateur final sur les méthodes**
+ Vous pouvez utiliser le modificateur final sur les méthodes.
+ Utiliser final avec des méthodes n'a de sens que si vous souhaitez restreindre ce que votre sous-classe peut remplacer ou masquer.
+ Utiliser final sur une méthode `instance` signifie que la sous-classe ne peut pas la `remplacer`.
+ Utiliser final sur une méthode `class(static)` signifie que les sous-classes ne peuvent pas la `masquer`.