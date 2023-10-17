### **Composition**
+ `Composition` est un autre composant de la programmation orientée objet.

### **Héritage vs composition**
+ L'héritage définit une relation `IS A`.
+ La composition définit une relation `HAS A`.

### **Relation IS-A :**
+ `La relation IS-A` représente l'héritage ou une relation `is a` entre les classes. 
+ Cela signifie qu'une classe est une version spécialisée d'une autre classe. 
+ La classe dérivée (sous-classe ou classe enfant) hérite des propriétés et du comportement de la classe de base (superclasse ou classe parent). 
+ En Java, la relation IS-A est établie à l'aide du mot-clé `extends`.

        class Animal { ... }
        class Dog extends Animal { ... }

### **Relation HAS-A :** 

+ la relation `HAS-A` représente la composition ou l'agrégation, indiquant qu'une classe a une instance d'une autre classe. 
+ Cela signifie qu'une classe a une relation avec une autre classe par le biais de son instance. 
+ La classe contenant l'objet est appelée conteneur, tandis que l'objet contenu est une instance d'une autre classe.


        class Engine { ... }

        class Car {
        private Engine engine;
        // other fields and methods
        }

### **Composition**
+ Nous avons commencé à parler de `composition` et l'avons comparée à l'héritage.
+ `L'héritage` est un moyen de réutiliser les fonctionnalités et les attributs.
+ `Composition` est un moyen de faire en sorte que la combinaison de classes agisse comme un seul objet cohérent.


### **Utiliser la composition, l'héritage ou les deux**
+ En règle générale, lorsque vous concevez vos programmes en Java, vous souhaitez probablement d'abord examiner la composition.
+ La plupart des experts vous diront qu'en règle générale, envisagez d'utiliser la composition avant de mettre en œuvre l'héritage.
+ Vous avez vu dans cet exemple, nous avons utilisé les deux.
+ Toutes nos pièces ont pu hériter d'un ensemble d'attributs, comme le fabricant et le modèle.
+ Le code appelant n'avait pas besoin de savoir quoi que ce soit sur ces pièces pour que l'ordinateur personnel fasse quelque chose.

### **Pourquoi la composition est-elle préférée à l'héritage dans de nombreuses conceptions?**
+ Les raisons pour lesquelles la composition est préférée à l'héritage:
  + `Composition` est plus flexible. Vous pouvez ajouter des pièces ou les supprimer, et ces modifications sont moins susceptibles d'avoir un effet en aval.
  + `Composition` permet une réutilisation fonctionnelle en dehors de la hiérarchie des classes, ce qui signifie que les classes peuvent partager des attributs et des comportements, en ayant des composants similaires, au lieu d'hériter des fonctionnalités d'une classe parent ou de base.
  + `L'héritage de Java` interrompt l'encapsulation, car les sous-classes peuvent avoir besoin d'un accès direct à l'état ou au comportement d'un parent.

### **Pourquoi l'héritage est-il moins flexible?**
+ L'héritage est moins flexible.
+ L'ajout ou la suppression d'une classe dans une hiérarchie de classes peut avoir un impact sur toutes les sous-classes à partir de ce point.
+ De plus, une nouvelle sous-classe peut ne pas avoir besoin de toutes les fonctionnalités ou attributs de sa classe parent.

### **Que signifie l'encapsulation?**
+ En Java, l'encapsulation signifie cacher des choses, en les rendant privées ou inaccessibles.

### **Pourquoi cacher des choses?**
+ Pourquoi voudrions-nous cacher des choses en Java ?
  + Pour simplifier l'interface, nous souhaiterons peut-être masquer les détails inutiles.
  + Pour protéger l'intégrité des données sur un objet, nous pouvons masquer ou restreindre l'accès à certaines données et opérations.
  + Pour dissocier l'interface publiée des détails internes de la classe, nous masquons les noms et types réels des membres de la classe.

### **Qu'entend-on par interface ici**
+ Bien que Java ait un type appelé interface, ce n'est pas de cela dont nous parlons ici.
+ Lorsque nous parlons de l'interface publique ou publiée d'une classe, nous parlons en réalité des membres de la classe qui sont exposés ou accessibles par le code appelant.
+ Tout le reste de la classe lui est interne ou privé.
+ Une interface de programmation d'application, ou API, est le contrat public qui indique aux autres comment utiliser la classe.


### **Avantages de l'encapsulation**
+ C'est vraiment l'un des énormes avantages de l'encapsulation, c'est que vous n'affectez aucun autre code.
+ C'est un peu comme une boîte noire à bien des égards. Mais la classe `EnhancedPlyer` a plus de contrôle sur ses données.

### **Garder le contrôle**
+ C'est pourquoi nous souhaitons utiliser l'encapsulation. Nous protégeons les membres de la classe, et certaines méthodes, des accès externes.
+ Cela empêche l'appel du code de contourner les règles et contraintes que nous avons intégrées à la classe.
+ Lorsque nous créons une nouvelle instance, elle est initialisée avec des données valides. Mais nous veillons également à ce qu’il n’y ait pas d’accès direct aux champs.
+ C'est pourquoi vous souhaitez toujours utiliser l'encapsulation. C'est quelque chose auquel il faut vraiment s'habituer.

### **Principes d'encapsulation**
+ Pour créer une classe encapsulée, vous souhaitez:
  + Créez des constructeurs pour l'initialisation des objets, qui imposent que seuls les objets avec des données valides soient créés.
  + Utilisez le modificateur d'accès privé pour vos champs.
  + Utilisez les méthodes `setter et getter` avec parcimonie et uniquement en cas de besoin.
  + Utilisez des modificateurs d'accès qui ne sont pas privés, uniquement pour les méthodes que le code appelant doit utiliser.

### **Polymorphisme**
+ `Ploymorphism` nous permet d'écrire du code pour appeler une méthode, le comportement de cette méthode peut être différent, pour différents objets.
+ Cela signifie que le comportement qui se produit lors de l'exécution du programme dépend du type d'exécution de l'objet.
+ Et le type d'exécution peut être différent du type déclaré dans le code.
+ Le type déclaré doit avoir une sorte de relation avec le type d'exécution, et l'héritage est un moyen d'établir cette relation.
+ Il existe d'autres moyens, mais dans cette partie, nous parlerons de la façon d'utiliser l'héritage, pour prendre en charge le « polymorphisme ».



