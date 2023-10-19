### **Généralisation et abstraction**
+ Nous utilisons les termes **«Abstraction»** et **«Généralisation»** lorsque nous commençons à essayer de modéliser des choses du monde réel dans un logiciel.
+ Avant de me lancer dans les types d'interfaces et les classes abstraites, je souhaite parler de la signification de ces concepts.

### **Généralisation**
+ Lorsque vous commencez à modéliser des objets pour votre application, vous commencez par identifier les caractéristiques et les comportements que vos objets ont en commun.
+ On généralise quand on crée une hiérarchie de classes.
+ Une classe de base est la classe la plus générale, l'élément de base le plus élémentaire, que l'on peut dire que tout a en commun.

### **Abstraction**
+ Une partie de la généralisation consiste à utiliser l'abstraction.
+ Vous pouvez généraliser un ensemble de caractéristiques et de comportements dans un type abstrait.
+ Si vous considérez une pieuvre, un chien et un pingouin, vous diriez probablement que ce sont tous des animaux.
+ Un animal est vraiment un concept abstrait.
+ Un animal n'existe pas vraiment, sauf pour décrire un ensemble de choses plus précises.
+ Si vous ne pouvez pas le dessiner sur un morceau de papier, c'est probablement abstrait.
+ L'abstraction simplifie la vue d'un ensemble de traits et de comportements d'un objet, afin que nous puissions en parler en tant que groupe, ainsi que généraliser leurs fonctionnalités.

### **Prise en charge de Java pour l'abstraction**
+ Java prend en charge l'abstraction de plusieurs manières différentes.
    + Java nous permet de créer une hiérarchie de classes, où le sommet de la hiérarchie, la classe de base, est généralement un concept abstrait, qu'il s'agisse d'une classe abstraite ou non.
    + Java créons des classes abstraites.
    + Java nous donne un moyen de créer des interfaces.

### **Méthode abstraite**
+ Dans les parties qui suivent, je parlerai beaucoup de méthodes abstraites et concrètes.
+ Une méthode abstraite a une signature de méthode et un type de retour, mais n'a pas de corps de méthode.
+ Pour cette raison, nous disons qu’une méthode abstraite n’est pas implémentée.
+ Son but est de décrire le comportement que tout objet de ce type aura toujours.
+ Conceptuellement, nous pouvons comprendre des comportements comme bouger ou manger sur un animal, nous pourrions donc les inclure en tant que méthodes abstraites, sur un type abstrait.
+ Vous pouvez considérer une méthode abstraite comme un contrat.
+ Ce contrat promet que tous les sous-types fourniront la fonctionnalité promise, avec le nom et les arguments convenus.

### **Méthode concrète**
+ Une méthode concrète a un corps de méthode, généralement avec au moins une instruction.
+ Cela signifie qu'il a un code opérationnel, qui est exécuté dans les bonnes conditions.
+ On dit qu'une méthode concrète implémente une méthode abstraite, si elle en écrase une.
+ Les classes et interfaces abstraites peuvent avoir un mélange de méthodes abstraites et concrètes.

### **Modificateurs de méthode**
+ J'ai déjà couvert les modificateurs d'accès et ce qu'ils signifient pour les types, ainsi que pour les membres des types.
+ Et nous savons que nous avons des modificateurs d'accès public, protégé, package et privé, comme options pour les membres.
+ En plus des modificateurs d'accès, les méthodes ont d'autres modificateurs, que nous énumérerons ici, à titre d'introduction de haut niveau.

| Modificateur   |Objectif|
|----------------|---------------|
| `abstract`     | Lorsque vous déclarez un résumé de méthode, un corps de méthode est toujours omis. Une méthode abstraite ne peut être déclarée que sur une classe abstraite ou une interface.|
| `static`       | Parfois appelée méthode de classe plutôt que méthode d'instance, car elle est appelée directement sur l'instance de classe.|
| `final`        |Une méthode qui est finale ne peut pas être remplacée par des sous-classes.|
| `default`      |Ce modificateur n'est applicable qu'à une interface, et nous en parlerons dans notre interface.|
| `native`       |C'est une autre méthode sans corps, mais elle est très différente du modificateur abstrait. Le corps de la méthode sera implémenté dans du code dépendant de la plate-forme, généralement écrit dans un autre langage de programmation tel que C. Il s'agit d'un sujet avancé et généralement peu utilisé, et nous ne l'aborderons pas dans ce cours.|
| `synchronized` |Ce modificateur gère la manière dont plusieurs threads accéderont au code dans cette méthode. Nous aborderons cela dans une section ultérieure sur le code multithread.|


