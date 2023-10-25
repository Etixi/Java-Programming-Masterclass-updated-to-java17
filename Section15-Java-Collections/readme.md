### **Une collection**
+ `Une collection` est juste un objet qui représente un groupe d'objets.
+ En général, les groupes d'objets ont des relations les uns avec les autres.
+ L'informatique a des noms communs et un ensemble de comportements attendus pour différents types d'objets de collection.
+ Les objets de collection, dans différentes langues, incluent des « tableaux, listes, vecteurs, ensembles, files d'attente, tables, dictionnaires et cartes ».
+ Ceux-ci se différencient par la manière dont ils stockent les objets en mémoire, la manière dont les objets sont récupérés et ordonnés et si les entrées nulles et en double sont autorisées.

### **Un cadre de collecte**
+ La documentation Java d'Oracle décrit son cadre de collections comme:
    + `"Une architecture unifiée pour représenter et manipuler les collections, permettant de manipuler les collections indépendamment des détails d'implémentation."`
+ Si vous souhaitez lire la « documentation Oracle », ils ont un bon aperçu sur le lien suivant :
    + https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html
+ Ceci a été écrit pour `JDK-8`, mais cela s'applique toujours.


### **L'interface de collecte**
+ L'interface Collection est la racine de la hiérarchie des collections.
+ Comme la plupart des racines des hiérarchies logicielles, c'est une représentation abstraite du comportement dont vous auriez besoin pour gérer un groupe d'objets.
+ Ce type est généralement utilisé pour « transmettre des collections » et les manipuler là où une « généralité maximale » est souhaitée.
+ N'oubliez pas que l'interface nous permet de décrire les objets par ce qu'ils peuvent faire, plutôt que par leur apparence réelle ou par la manière dont ils sont finalement construits.
+ Si vous regardez les méthodes de cette interface, vous pouvez voir les opérations de base qu'une collection de n'importe quelle forme ou type devrait prendre en charge.
+ Nous avons déjà examiné chacune de ces opérations, dans notre étude des `ArrayLists et LinkedList`.
+ Lors de la gestion d'un groupe, vous ajouterez et supprimerez des éléments, vérifierez si un élément est dans le groupe et parcourrez les éléments.
+ Il y en a d'autres, mais ce sont ceux-là qui décrivent presque tout ce que vous voudriez faire pour gérer un groupe.
+ Java utilise le terme « Élément » pour désigner un membre du groupe géré.


### **Implémentations de Collection**

| Interface | 	Hash Table  | 	Resizable Array | Balanced Tree | 	Linked List   | Hash Table + Linked List |
|-----------|--------------|------------------|---------------|----------------|--------------------------|
| **Set**   | **HashSet**  | 	 	              | **TreeSet**   | 	 	            | **LinkedHashSet**        |
| **List**  | 	 	          | **ArrayList**    | 	 	           | **LinkedList** |                          |	 
| **Deque** | 	 	          | **ArrayDeque**   | 	 	           | **LinkedList** |                          |	 
| **Map**   | 	**HashMap** | 	 	              | **TreeMap**   | 	 	            | **LinkedHashMap**        |


### **Resumé des méthodes**

| Modificateur et type | 	Méthode et description                                                                                                                   |
|----------------------|-------------------------------------------------------------------------------------------------------------------------------------------|
| boolean              | 	`add(E e)` <br/> Garantit que cette collection contient l'élément spécifié (opération facultative).                                      |
| boolean              | 	`addAll(Collection<? extends E> c)` <br/>Ajoute tous les éléments de la collection spécifiée à cette collection (opération facultative). |
| void                 | 	`clear()` <br/> Supprime tous les éléments de cette collection (opération facultative).    |                                              
|boolean| 	`contains(Object o)` <br/> Renvoie vrai si cette collection contient l'élément spécifié. |                                                
|boolean| 	 `containsAll(Collection<?> c)` <br/> Renvoie vrai si cette collection contient tous les éléments de la collection spécifiée.            
|boolean| 	`equals(Object o)` <br/> Compare l'objet spécifié avec cette collection pour vérifier l'égalité.                                         |
|int| 	`hashCode()` <br/> Renvoie la valeur du code de hachage pour cette collection.|                                                          |
|boolean|	`isEmpty()` Renvoie vrai si cette collection ne contient aucun élément.|
|Iterator<E>|	`iterator()` <br/> Renvoie un itérateur sur les éléments de cette collection.|
|default Stream<E>|	`parallelStream()` <br/> Renvoie un éventuellement parallèle Stream avec cette collection comme source.|
|boolean|	`remove(Object o)` <br/> Supprime une seule instance de l'élément spécifié de cette collection, si elle est présente (opération facultative).|
|boolean|	`removeAll(Collection<?> c)` <br/> Supprime tous les éléments de cette collection qui sont également contenus dans la collection spécifiée (opération facultative).|
|default boolean|	`removeIf(Predicate<? super E> filter)` Supprime tous les éléments de cette collection qui satisfont au prédicat donné.|
|boolean|	`retainAll(Collection<?> c)` <br/> Conserve uniquement les éléments de cette collection qui sont contenus dans la collection spécifiée (opération facultative).|
|int|	`size()` <br/> Renvoie le nombre d'éléments dans cette collection.|
|default Spliterator<E>|	`spliterator()` <br/> Crée un Spliterator sur les éléments de cette collection.|
|default Stream<E>|	`stream()` <br/> Renvoie une séquence Stream avec cette collection comme source.|
|Object[]|	`toArray()` <br/> Renvoie un tableau contenant tous les éléments de cette collection.|
|<T> T[]|	`toArray(T[] a)` <br/> Renvoie un tableau contenant tous les éléments de cette collection ; le type d'exécution du tableau renvoyé est celui du tableau spécifié.|

### **L'interface cartographique, pourquoi est-elle différente ?**
+ `Map` dans le cadre des collections est une autre structure de données.
+ Bien qu'il s'agisse toujours d'un regroupement d'éléments, c'est différent, car les éléments sont stockés avec des références saisies.
+ Cela signifie qu'une carte nécessite deux arguments de type, comme vous pouvez le voir sur cette partie, où je montre l'interface racine, Collection, Comparer à l'interface `Map`.


| Collection Interface                        | Map Interface       |
|---------------------------------------------|---------------------|
| interface Collection<E> extends Iterable<E> | interface Map<K, V> |

+ Le `Map` a `K` pour son type de clé et `V` pour le type de valeur.
+ Comme pour toutes les classes génériques, la seule restriction sur ces types est qu'ils doivent être des types référence et non des primitives.

### **Caractéristiques de la carte**
+ Un `Map` Java ne peut pas contenir de clés en double.
+ Chaque clé ne peut correspondre qu'à une seule valeur.

### **Map Implementations (les classes qui implémentent Map)**
+ Dans les prochaines conférences, j'examinerai 3 des classes Java qui implémentent les interfaces `map`, le `HashMap`, le `LinkedHashMap` et le `TreeMap`.
+ Le `HashMap` n'est pas ordonné, le `LinkedHashMap` est trié par ordre d'insertion et le `TreeMap` est trié `map`.

### **Implémentations de Map ordonnées et triées**
+ L'interface `Map` a les classes `LinkedHasMap et TreeMap`.
+ Le `LinkedHashMap` est une collection d'entrées de valeurs-clés, dont les clés sont classées par ordre d'insertion.
+ Le `TreeMap` est trié par ses clés, donc une clé doit implémenter Comparable, ou être initialisée, avec un Comparator spécifié.

### **Collections de vues de TreeMap**
| Afficher les méthodes de collecte                                                                                           | Remarques                                                                                                                                                                                                                                                                                                   |
|-----------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `entrySet(), keySet(), values()`                                                                                            | Fournit des vues des mappages, des clés et des valeurs. Ce sont des vues disponibles sur n'importe quelle carte, et pas seulement sur le « TreeMap ». Je les inclut ici, pour vous rappeler qu'il s'agit de « vues »                                                                                        |
| `descendingKeySet()` <br/> `descendingKeyMap()`                                                                             | Fournit un jeu de clés ou une carte d'ordre inversé, inversé par les valeurs clés.                                                                                                                                                                                                                          |
| `headMap(K key)` <br/> `headMap(K key, boolean inclusive)` <br/> `tailMap(K key)` <br/> `tailMap(K key, boolean inclusive)` | Fournit des vues de la première ou de la dernière partie de la carte, divisées par la clé transmise. <br/> La map `head` est par défaut `EXCLUSIVE` de tous les éléments supérieurs ou égaux à la clé. <br/> La carte `tail` est par défaut `INCLUSIVE` de tous les éléments supérieurs ou égaux à la clé.  |
| `subMap(K fromKey, K toKey)` <br/> `subMap(K fromKey, boolean inclusive, K toKey, boolean inclusive)`                       | Fournit une vue de la section contiguë de la carte, supérieure ou égale au `fromkey` et inférieure au `tokey`, donc le `toKey est EXCLUSIF`. <br/> La version surchargée vous permet de déterminer l'inclusivité souhaitée pour les deux clés.                                                              |


### **EnumSet et EnumMap**
+ Avant de continuer, je souhaite parler de deux autres classes dans le framework collections, spécialement créées pour prendre en charge plus efficacement les types enum.
+ Vous pouvez utiliser n'importe quelle « liste, ensemble ou carte » avec une constante enzyme.
+ Les `EnumSet et EnumMap`, chacun a une implémentation spéciale proposée par `HashSet ou HashMap`.
+ Ces implémentations rendent ces deux types extrêmement compacts et efficaces.
+ Il n'y a pas d'implémentation de liste spéciale pour les types enum.

### **L'EnumSet**
+ EnumSet est une implémentation Set spécialisée à utiliser avec les valeurs enum.
+ Tous les éléments d'un `EnumSet` doivent provenir d'un seul type enum.
+ Le `EnumSet` est abstrait, ce qui signifie que nous ne pouvons pas l'instancier directement.
+ Il est livré avec des méthodes d'usine pour créer des instances.
+ En général, cet ensemble a de bien meilleures performances que l'utilisation d'un `HashSet`, avec un type enum.
+ Les opérations groupées (telles que `containsAll` et `retainAll`) devraient s'exécuter très rapidement, en temps constant, `O(1)`, si elles sont exécutées sur un `enumSet` et que leur argument est un `EnumSet`.

### **L'EnumMap**
+ Le `Enum Map` est une implémentation spécialisée de `Map` à utiliser avec les clés de type enum.
+ Les clés doivent toutes provenir du même type d'énumération, et elles sont naturellement classées par la valeur ordonnée des constantes d'énumération.
+ Cette `map` a les mêmes fonctionnalités qu'une `HashMap`, avec `O(1)` pour les opérations de base.
+ Le type de clé enum est spécifié lors de la construction de `EnumMap`, soit explicite en passant la classe du type de clé, soit implicitement en passant un autre `EnumSet`.
+ En général, cette `map` a de meilleures performances que l'utilisation d'un `HashMap`, avec un type enum.


### **Deux types d'implémentations d'EnumSet**
+ Les ensembles d'énumérations sont représentés en interne sous forme de vecteurs de bits, qui ne sont qu'une série de uns et de zéros.
+ Un un indique que la constante enum (avec une valeur ordinale égale à l'index du bit) est dans l'ensemble.
+ Un zéro indique que la constante enum n'est pas dans l'ensemble.
+ L'utilisation d'un vecteur de bits permet à toutes les opérations d'ensemble d'utiliser le calcul des bits, ce qui le rend très rapide.
+ Un `RegularEnumSet` utilise un seul long as comme vecteur de bits, ce qui signifie qu'il peut contenir un maximum de 64 bits, représentant 64 valeurs d'énumération.
+ Un `JumboEnumSet` est renvoyé si vous avez plus de 64 énumérations.

