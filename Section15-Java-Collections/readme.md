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