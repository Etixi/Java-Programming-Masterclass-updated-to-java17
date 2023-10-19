### **Tableau Java vs liste Java**
+ Un tableau est mutable, et nous avons vu que nous pouvions définir ou modifier des valeurs dans le tableau, mais nous ne pouvions pas le redimensionner.
+ Java nous propose plusieurs classes qui nous permettent d'ajouter et de supprimer des éléments, et de redimensionner une séquence d'éléments.
+ Ces classes sont dites implémentent le comportement d'une liste.
+ Alors, qu'est-ce qu'une liste ?

### **Alors, qu'est-ce qu'une liste**
+ Dans notre vie de tous les jours, nous utilisons tout le temps des listes.
+ Quand on va à l'épicerie, on a une liste.
+ Nous avons une liste de choses que nous devons faire, une liste d'adresses, une liste de numéros de contact, etc.
+ Ce ne serait cependant pas une liste très utile, si nous commencions avec 10 éléments que nous pourrions modifier, mais ne jamais ajouter ou supprimer un élément.
+ Répertoriez un type spécial en Java, appelé interface.
+ Pour l'instant, je dirai qu'une interface List décrit un ensemble de signatures de méthodes que toutes les classes List sont censées avoir.
+ Examinons certaines de ces méthodes. Je vais extraire les méthodes List dans l'API Java.

### **La liste de tableaux**
+ `ArrayList` est une classe qui maintient réellement un tableau en mémoire, qui est en fait plus grand que ce dont nous avons besoin, dans la plupart des cas.
+ Il garde une trace de la capacité, qui est la taille réelle du tableau en mémoire.
+ Mais il garde également une trace des éléments qui ont été attribués ou définis, ce qui correspond à la taille de `ArrayList`.
+ Au fur et à mesure que des éléments sont ajoutés à une `ArrayList`, sa capacité devra peut-être augmenter. Tout cela se passe automatiquement, en coulisses.
+ C'est pourquoi `ArrayList` est redimensionnable.


|Modificateur et type| 	Méthode et description  |
|--------------------|--------------------------|
|`boolean`| `add(E e)` <br/>Ajoute l'élément spécifié à la fin de cette liste (opération facultative).|
|`void`|	`add(int index, E element)` <br/>Insère l'élément spécifié à la position spécifiée dans cette liste (opération facultative).|
|`boolean`|	`addAll(Collection<? extends E> c)` <br/>Ajoute tous les éléments de la collection spécifiée à la fin de cette liste, dans l'ordre dans lequel ils sont renvoyés par l'itérateur de la collection spécifiée (opération facultative).|
|boolean|	`addAll(int index, Collection<? extends E> c)` <br/>Insère tous les éléments de la collection spécifiée dans cette liste à la position spécifiée (opération facultative).|
|void|	`clear()` <br/> Supprime tous les éléments de cette liste (opération facultative).|
|boolean|	`contains(Object o)` <br/> Renvoie vrai si cette liste contient l'élément spécifié.|
|boolean|	`containsAll(Collection<?> c)`<br/> Renvoie vrai si cette liste contient tous les éléments de la collection spécifiée.|
|boolean|	`equals(Object o)` <br/> Compare l'objet spécifié avec cette liste pour l'égalité.|
|E|	`get(int index)` <br/> Renvoie l'élément à la position spécifiée dans cette liste.|
|int|	`hashCode()` <br/> Renvoie la valeur du code de hachage pour cette liste.|
|int|	`indexOf(Object o)` <br/> Renvoie l'index de la première occurrence de l'élément spécifié dans cette liste, ou -1 si cette liste ne contient pas l'élément.|
|boolean|	`isEmpty()` <br/> Renvoie vrai si cette liste ne contient aucun élément.|
|Iterator<E>|	`iterator()` <br/> Renvoie un itérateur sur les éléments de cette liste dans le bon ordre.|
|int|	`lastIndexOf(Object o)` <br/> Renvoie l'index de la dernière occurrence de l'élément spécifié dans cette liste, ou -1 si cette liste ne contient pas l'élément.|
|ListIterator<E>|	`listIterator()` <br/> Renvoie un itérateur de liste sur les éléments de cette liste (dans le bon ordre).|
|ListIterator<E>|	`listIterator(int index)` <br/> Renvoie un itérateur de liste sur les éléments de cette liste (dans le bon ordre), en commençant à la position spécifiée dans la liste.|
|E|	`remove(int index)` <br/> Supprime l'élément à la position spécifiée dans cette liste (opération facultative).|
| boolean |	`remove(Object o)` <br/> Supprime la première occurrence de l'élément spécifié de cette liste, s'il est présent (opération facultative).|
|boolean |	`removeAll(Collection<?> c)` <br/> Supprime de cette liste tous ses éléments contenus dans la collection spécifiée (opération facultative).|
|default void|	`replaceAll(UnaryOperator<E> operator)` Remplace chaque élément de cette liste par le résultat de l'application de l'opérateur à cet élément.|
|boolean|	`retainAll(Collection<?> c)` Conserve uniquement les éléments de cette liste qui sont contenus dans la collection spécifiée (opération facultative).|
|E	| `set(int index, E element)` <br/>  Remplace l'élément à la position spécifiée dans cette liste par l'élément spécifié (opération facultative).|
|int|	`size()` <br/> Renvoie le nombre d'éléments dans cette liste.|
|default void|	`sort(Comparator<? super E> c)` <br/> Trie cette liste selon l'ordre induit par le spécifié Comparator.|
|default Spliterator<E>|	`spliterator()` <br/> Crée un Spliterator sur les éléments de cette liste.|
|List<E>|	`subList(int fromIndex, int toIndex)` Renvoie une vue de la partie de cette liste entre les fromIndex spécifiés , inclus, et toIndex , exclusifs.|
|Object[]|	`toArray()` <br/> Renvoie un tableau contenant tous les éléments de cette liste dans le bon ordre (du premier au dernier élément).|
|<T> T[]|	`toArray(T[] a)` <br/> Renvoie un tableau contenant tous les éléments de cette liste dans le bon ordre (du premier au dernier élément) ; le type d'exécution du tableau renvoyé est celui du tableau spécifié.|


### **Tableaux vs ArrayList**
+ Cette diapositive montre que les tableaux et les ArrayLists ont plus en commun qu'ils n'en ont pas.

| Feature                        | array                        | ArrayList |
|--------------------------------|------------------------------|-----------|
| primitives types-supported     | Yes                          | `NO`      |
| indexed                        | Yes                          | Yes          |
| ordered by index               | Yes                          |  Yes         |
| duplicates allowed             | Yes                          | Yes          |
| nulls alllowed                 | Yes, for non-primitive types |  Yes         |
| resizable                      | `NO`                         |  Yes         |
| mutable                        | Yes                          |  Yes         |
| inherits from java.util.Object | Yes                          |  Yes         |
| implements List interface      | `NO`                         |  `Yes`         |

### **Instanciation sans valeurs**

| Instantiating Arrays                                                                                                                              | Instantiating ArrayList                                                                                                  |
|---------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| `String[] array = new String[10]`                                                                                                                 | `ArrayList<String> arrayList = new ArrayList<>()`                                                                        |
| Un tableau de 10 éléments est créé, tous avec des références nulles <br/>. Le compilateur permettra uniquement <br/> d'attribuer des «Strings» aux éléments. | Une `ArrayList` vide est créée. <br/>Le compilateur vérifiera que seuls les « Syrings » sont ajoutés à la « ArrayList ». |


+ Sur cette diapositive, je montre les différences entre la création d'une nouvelle instance d'un tableau et une nouvelle instance d'un `ArrayList`.
+ Un tableau nécessite des crochets dans la déclaration.
+ Dans la nouvelle instance, des crochets sont également requis, avec une taille spécifiée à l'intérieur.
+ Une `ArrayList` doit être déclarée, avec le type d'élément dans la `ArrayList`, entre crochets angulaires.

### **Création de types spéciaux de listes**

| Utilisation de `Arrays.asList`                                                                                   | Utilisation de `List.of`                                                                                   |
|------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|
| La liste renvoyée n'est `PAS` redimensionnable, mais est mutable                                                 | La liste renvoyée est `IMMUTABLE`                                                                          |
| `var newList = Arrays.asList("Sunday", "Monday", "Tuesday")`                                                     | `var listOne = List.of("Sunday", "Monday", "Tuesday")`                                                     |
| `String[] days = new String[]{"Sunday", "Monday", "Tuesday"}` <br/> `List<String> newList = Arrays.asList(days)` | `String[] days = new String[]{"Sunday", "Monday", "Tuesday"}` <br/> `List<String> listOne = List.of(days)` |


### **LinkedList**
+ Je viens de beaucoup parler de la `LinkedList` et de la `ArrayList`, qui sont différentes sous les couvertures.
+ Une `ArrayList` est implémentée au-dessus d'un tableau, mais une `LinkedList` est un lit doublement lié.
+ Les deux implémentent toutes les méthodes de List, mais `LinkedLits` implémente également les méthodes `Queue` et `Stack`.

### **Une file d'attente est une collecte de données premier entré, premier sorti (FIFO)**
+ Quand vous pensez à une file d'attente, vous pourriez penser à faire la queue.
+ Lorsque vous entrez dans une file d'attente ou une file d'attente, vous vous attendez à être traité, par rapport à la première personne en file d'attente.
+ Nous appelons une collecte de données First-in, First-Out, ou FIFO
+ Si vous souhaitez supprimer un élément, vous interrogez la file d'attente, obtenant le premier élément ou la première personne de la ligne.
+ Si vous souhaitez ajouter un article, vous le proposez dans la file d'attente, en l'envoyant en fin de file.
+ Les files d'attente asymétriques traitent toujours les éléments depuis le début de la file d'attente.
+ Une file d'attente à double extrémité permet d'accéder à la fois au début et à la fin de la file d'attente.
+ Une `LinkedList` peut être utilisée comme une file d'attente à double extrémité.
+ Lorsque vous envisagez une «pile», vous pouvez penser à une pile verticale d'éléments, les uns au-dessus des autres, comme nous le montrons sur cette diapositive.
+ Lorsque vous ajoutez un élément, vous le poussez sur la pile.
+ Si vous souhaitez obtenir un élément, vous prendrez l'élément du haut ou le retirerez de la « pile ».
+ Nous appelons cela une collecte de données Last-In, First-out, et non LIFO.
+ Une `LinkedList` peut également être utilisée comme pile.

### **Qu'est-ce qu'un Iterartor?**
+ Jusqu'à présent, nous avons principalement utilisé des boucles for pour parcourir ou parcourir des éléments dans un tableau ou une liste.
+ Nous pouvons utiliser la boucle for traditionnelle et un index, pour indexer dans une liste.
+ Nous pouvons utiliser la boucle for améliorée et une collection pour parcourir les éléments, un à la fois.
+ Mais Java fournit d'autres moyens pour parcourir les listes.
+ Deux alternatives sont le `iterator` et le `ListIterator`.

### **Comment fonctionne un itérateur?**
+ Si vous êtes familier avec les bases de données, vous connaissez peut-être un curseur de base de données, qui est un mécanisme qui permet le parcours sur les enregistrements d'une base de données.
+ Un itérateur peut être considéré comme similaire à un curseur de base de données.
+ Le type de curseur auquel nous faisons référence ici peut être décrit comme un objet qui permet de parcourir les enregistrements d'une collection.
+ Le `Iterator` est assez simple.
+ Lorsque vous obtenez une instance d'un itérateur, vous appelez la méthode `next` pour obtenir l'élément suivant dans la liste.
+ Vous pouvez utiliser la méthode `hasNext` pour vérifier s'il reste des éléments à traiter.
+ Dans le code, vous pouvez voir une boucle while, qui utilise la méthode `hasNext` de l'itérateur, pour déterminer si elle doit continuer la boucle.
+ Dans la boucle, la méthode `next` est appelée, sa valeur affectée à une variable locale et la variable locale imprimée.
+ Cela imprimerait simplement chaque élément d'une liste, mais le ferait via l'objet itérateur.


### **Iterator vs. ListIterator**

+ Un `Iterartor` est uniquement en avant et ne prend en charge que la méthode `remove`.
+ Un `ListIterator` peut être utilisé pour avancer et reculer, et en plus de la méthode `remove`, il prend également en charge les méthodes `add` et `set`.

### **Pourquoi Java a-t-il des types de données primitifs?**
+ Certains langages orientés objet ne prennent en charge aucun type de données primitif, ce qui signifie que tout est un objet.
+ Mais la plupart des langages orientés objet les plus populaires du moment prennent en charge à la fois les types primitifs et les objets, tout comme Java.
+ Les types primitifs représentent généralement la manière dont les données sont stockées sur un système d'exploitation.
+ Les primitives présentent certains avantages par rapport aux objets, notamment lorsque la magnitude ou le nombre d'éléments augmente.
+ Les objets occupent de la mémoire supplémentaire et peuvent nécessiter un peu plus de puissance de traitement.
+ Nous savons que nous pouvons créer des objets, avec des types de données primitifs comme types de champs, par exemple, et que nous pouvons également renvoyer des types primitifs à partir de méthodes.


### **Pourquoi tous les types Collection de Java ne prennent-ils pas en charge les primitives?**

        LinkedLIst<int> myIntegers = new LinkedList<>();

+ Plus important encore, nous ne pouvons pas facilement utiliser des primitives, dans certaines des fonctionnalités que nous découvrirons dans le futur, comme les génériques.
+ Mais Java, comme nous le savons, nous donne des classes wrapper pour chaque type primitif.
+ Et on peut passer **`d'une primitive à un wrapper, qu'on appelle boxing`** , ou **`d'un wrapper à une primitive, qu'on appelle unboxing`**, avec une relative facilité en Java.

### **Qu'est-ce que le boxing?**

+ Une primitive est encadrée ou enveloppée dans une classe conteneur dont les données principales sont la valeur de la primitive.
+ Chaque type de données primitif a une classe wrapper, comme indiqué dans la liste, que nous avons vu auparavant.
+ Chaque type de wrapper enferme une valeur primitive spécifique.


### **Comment boxe-t-on ?**

+ Chaque wrapper a une méthode d'usine statique surchargée, `valueOf()`, qui prend une primitive et renvoie une instance de la classe wrapper.
+ Le code présenté sur cette diapositive renvoie une instance de la classe `java.lang.Integer`, à la variable boxedInt, avec la valeur 15.
+ On peut dire que ce code encadre manuellement un entier primitif.

            Integer boxedInt = Integer.valueOf(15);

### **Boxing obsolète utilisant le constructeur wrapper?**

+ Une autre manière manuelle de faire du `Boxing`, que vous verrez dans le code plus ancien, consiste à créer une nouvelle instance de la classe wrapper, en utilisant le nouveau mot-clé et en transmettant la valeur primitive au constructeur.
+ Nous en montrons un exemple ici.

        Integer boxedInt = new Integer(15);

+ Si vous essayez ceci dans IntelliJ, avec n'importe quelle version de Java supérieure à JDK-9, IntelliJ vous le dira, il s'agit d'un code obsolète.


### **Qu'est-ce que l'autoBoxing?**

+ Nous pouvons simplement attribuer une primitive à une variable wrapper, comme nous le montrons sur cette diapositive.
  
          Integer boxedInteger = 15;   
          int unboxedInt = boxedInteger.intValue(15);

+ Java autorise ce code, et il est en fait préféré, à la boxe manuelle.
  Sous les couvertures, Java fait la boxe. En d’autres termes, une instance de Integer est créée et sa valeur est définie sur 15.
+ Autoriser Java à effectuer une boîte automatique est préférable à toute autre méthode, car Java fournira le meilleur mécanisme pour le faire.
+ Chaque classe wrapper prend en charge une méthode pour renvoyer la valeur primitive qu'elle contient. C’est ce qu’on appelle le déballage.
+ Dans l'exemple de cette diapositive, nous avons automatiquement placé la valeur entière 15 dans une variable appelée boxedInteger.
+ Cela nous donne un objet qui est une classe wrapper Integer et qui a la valeur 15.
+ Pour déballer cela, sur une classe Integer, nous pouvons utiliser la méthode `intValue`, qui renvoie la valeur encadrée, l'int primitif.
+ Cette méthode est appelée `unboxing manuel`. Et comme pour le boxing, il n'est pas nécessaire de déballer manuellement.

### **unboxing automatique**

        Integer boxedInteger = 15;
        
        int unboxedInt = boxedInteger;

+ Le `unboxing automatique` est en réalité simplement appelé `unboxing` dans la plupart des cas.
+ Nous pouvons assigner une instance d'une classe wrapper, directement à une variable primitive. Le code sur cette diapositive montre un exemple.
+ Nous attribuons une instance d'objet à une variable primitive, dans la deuxième instruction.


### **Énumération**
+ Le type `enum` est le type de Java qui prend en charge quelque chose appelé `énumération`.
+ Wikipédia définit l'énumération comme ***« Une liste complète et ordonnée de tous les éléments d'une collection.»***

### **Le type d'énumération**
+ Java décrit le type enum comme: Un type de données spécial qui contient des constantes prédéfinies.
+ Une constante est une variable dont la valeur ne peut pas être modifiée, une fois que sa valeur a été attribuée.
+ Ainsi, une énumération est un peu comme un tableau, sauf que ses éléments sont connus, non modifiables, et chaque élément peut être référencé par un nom de constante, au lieu d'une position d'index.

          public enum DayOfWeek {
                SUNDAY, MONDAY, TUESADY, WEDNESDAY, THURSDAY, FRIDAY, STAURDAY
          }

+ Une énumération est ordonnée, par la façon dont vous déclarez les constantes.
+ Cela signifie que `SUNDAY` est considéré comme le premier jour de la semaine et `SATURDAY` est le dernier jour de la semaine.

+ Le type enum est utilisé pour déclarer un ensemble limité de constantes, et parfois, il existe un ordre naturel dans la liste, comme dans le cas des jours de la semaine.
+ Quelques autres exemples de déclarations enum possibles pourraient être:
  + Les mois de l'année : `JANVIER, FÉVRIER, MARS, etc`.
  + Les directions dans une boussole : `EST, NORD, OUEST, SUD`.
  + Un ensemble de tailles : `EXTRA_SMALL, SMALL, MEDIUM, LARGE, EXTRA_LARGE`.

+ Sous les couvertures, `le type enum est un type spécial de classe`, qui contient des champs pour prendre en charge les constantes, mais nous y reviendrons dans une discussion ultérieure.
+ Vous n'avez pas besoin de comprendre tous les éléments internes d'une énumération pour tirer les avantages de l'utilisation de ce type.
+ Une fois que vous vous serez habitué au fonctionnement de ce type, vous pourrez trouver de nombreux endroits pour utiliser une énumération.
+ Ils simplifient votre code et le rendent plus lisible de plusieurs manières.