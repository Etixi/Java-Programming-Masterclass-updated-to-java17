### **Streams Java, Ce qu'ils sont et ce qu'ils ne sont pas**
+ Lorsque vous pensez à un `Stream`, vous pensez peut-être à des « flux d'E/S », comme un flux d'entrée mis en mémoire tampon ou une sortie de fichier.
+ Ce n'est pas le type de flux dont je parle ici.
+ La documentation Java d'Oracle décrit un « flux » comme suit.

| `Streams`                                                                                    |
|----------------------------------------------------------------------------------------------|
| Séquence d'éléments prenant en charge les opérations d'agrégation séquentielles et parallèles. |

+ Les `Streams` sont des mécanismes permettant de décrire toute une série de processus, avant de les exécuter.

### **Un Stream est différent d'une collection**
+ Les types `stream et collection` ont été conçus à des fins différentes.
+ `Une collection` est utilisée pour `stocker et gérer une série d'éléments` en java, fournissant un `accès direct` aux éléments des collections.
+ Vous pouvez utiliser des collections pour manipuler ou interroger un ensemble de données.
+ Il n'y a rien que vous puissiez faire avec un `stream` que vous ne puissiez déjà faire avec une `Collection`.
+ Cependant, un `stream` a été conçu pour `gérer le traitement des éléments`.
+ Les « flux » ne stockent pas réellement d'éléments, mais ces éléments sont calculés à la demande, à partir d'une source fournissant des données.

### **Le Stream paresseux**
+ Une autre différence importante est que les `Streams` sont paresseux, comme les variables d'expression lambda.
+ Lorsque vous appelez de nombreuses méthodes sur un `stream`, l'exécution peut ne pas avoir lieu immédiatement.
+ Au lieu de cela, vous devrez invoquer une opération spéciale sur le « stream », comme vous le feriez en appelant la méthode fonctionnelle d'un lambda.
+ Cette opération spéciale est appelée opération terminale.

### **Pourquoi utiliser un Stream?**
+ Les  Streams` sont un ajout intéressant à Java, car ils offrent plusieurs avantages.
    + Premièrement, ils rendent le code permettant de traiter les données uniforme, concis et reproductible, d'une manière qui ressemble au langage de requête structuré (SQL) d'une base de données.
    + Deuxièmement, lorsque vous travaillez avec de grandes collections, les «Streams» parallèles offriront un avantage en termes de performances.
+ Tous les exemples de code que j'ai fournis jusqu'à présent, à l'aide de collections, continueront d'être utiles pour de nombreux cas d'utilisation.
+ Il est temps de parler de ces nouvelles choses, en utilisant ce cours supplémentaire de programmation fonctionnelle.


### **Sources de flux**
+ Cette diapositive montre les huit méthodes que j'ai abordées dans cette partie.
+ Deux `streams` peuvent être infinis, la méthode `Stream.generate` ainsi que `Stream.iterate` qui n'inclut pas de paramètre `Predicate`

| Method                                                                   | Finite | Infinite |
|--------------------------------------------------------------------------|--------|----------|
| **`Collection.stream()`**                                                | *      |          |
| **`Arrays.stream(T [])`**                                                | *      |          |
| **`Stream.of(T...)`**                                                    | *      |          |
| **`Stream.iterate(T seed, UnaryOpearator(<T> f)`**                       | *      | *        |
| **`Stream.iterate(T seed, Predicate<? super T> p, UnaryOperator<T> f)`** | *      |          |
| **`Stream.generate(Supplier<? extends T> s)`**                           |        | *        |
| **`InStream.range(int startInclusive, int endExclusive)`**               | *      |          |
| **`InStream.rangeClosed(int startInclusive, int endExclusive)`**         | *      |          |

+ **`range et rangeClosed` également disponible sur `DoubleStream et LongStream`, avec des types `double et long` produits.**


### **Les opérations intermédiaires les plus courantes**

| Return Type | Operation                                                                                                                                   |
|------------|---------------------------------------------------------------------------------------------------------------------------------------------|
| `Stream<T>` | `distinct()`                                                                                                                                |
| `Stream<T>`          | `filter(Predicate<? super T> predicate)` <br/> `takeWhile(Predicate<? super T> predicate)` <br/> `dropWhile(Predicate<? super T> predicate)` |
| `Stream<T>`          | `limit(long maxSize)`                                                                                                                       |
| `Stream<T>`          | `map(Function<? super T, ? extends R> mapper)`                                                                                              |
| `Stream<T>`          | `peek(Consumer<? super T> action)`                                                                                                          |
| `Stream<T>`          | `skip(long n)`                                                                                                                              |
| `Stream<T>`          | `sorted()` <br/> `sorted(Comparator<? super T> comparator)`                                                                                 |


### **Opérations intermédiaires qui affectent la taille du `Stream`** résultant
+ Je vais commencer par parler de l'ensemble des opérations, qui peuvent modifier le nombre d'éléments, dans le « flux » résultant.

|Type de retour|Opération| Description                                                                                                                                                                                                                                                                                                  |
|--------------|----------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|Stream`<T>`|`distinct()`| Supprime les valeurs en double de `Stream`                                                                                                                                                                                                                                                                   |
|Stream`<T>`|`filter(Predicate<? super T> predicate)` <br/> `takeWhile(Predicate<? super T> predicate)` <br/> `dropWhile(Predicate<? super T> predicate)`| Ces méthodes vous permettent de réduire les éléments dans le flux de sortie. Les éléments qui correspondent au prédicat du filtre sont conservés dans le flux sortant, pour les opérations de filtre et `takeWhile`. Les éléments seront supprimés jusqu'à ce que le prédicat `dropWhile' ne soit plus vrai. |
|Stream`<T>`|`limit(long maxSize)` | Cela réduit votre `stream` à la taille spécifiée dans l'argument.                                                                                                                                                                                                                                            |
|Stream`<T>`|`skip(long n)` | Cette méthode ignore les éléments, ce qui signifie qu'ils ne feront pas partie du `stream`                                                                                                                                                                                                                   |


### **Opérations intermédiaires qui opèrent sur chaque élément**

|Type de retour|Opération| Description                                                                                                                                                                                                                                                                  |
|--------------|---------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|Stream`<R>`|`map(Function<? super T, ? extends R> mapper)`| Il s'agit d'une fonction appliquée à chaque élément du `stream`. Parce que c'est une fonction, le type de retour peut être différent c'est une fonction, le type de retour peut être différent, ce qui a pour effet de transformer le flux en un type différent.             |
|Stream`<T>`|`peek(Consumer<? super T> action)` | Cette fonction ne modifie pas le `stream`, mais vous permet d'exécuter une fonction `consommateur` provisoire pendant le traitement du pipeline                                                                                                                              |
|Stream`<T>`|`sorted()` <br/> `sorted(Comparator<? super T> comparator)`| Il existe deux versions de stockées. Le premier utilise le tri `naturalOrder`, ce qui signifie que les éléments du `stream` doivent implémenter `Comparable`. Si vos éléments n'utilisent pas «Comparable», vous souhaiterez utiliser sorted et transmettre un comparateur.  |


### **Streams primitifs**
+ En plus du `Stream` générique, qui vous permet de diffuser n'importe quel type de référence, Java a trois `streams` primitifs.

| Streams primitifs spéciaux | Mappage du type de référence au type primitif       | Mapping du Stream primitif au type de référence                  |
|----------------------------|-----------------------------------------------------|------------------------------------------------------------------|
| `DoubleStream`             | **mapToDouble(ToDoubleFunction<? super T> mapper)** | **MapToObj(DoubleFunction<? extends U> mapper)**                 |
| `IntStream`                | **mapToInt(ToIntFunction<? super T> mapper)**       | **MapToObj(IntFunction<? extends U> mapper)** <br/> **boxed()**  |
| `LongStream`               | **mapToLong(ToLongFunction<? super T> mapper)**     | **mapToObj(LongFunction<? extends U> mapper)** <br/> **boxed()** |

### **Opérations des terminaux**
+ Les « flux » primitifs ont également une moyenne et une somme, ainsi qu'une opération `summaryStatistics` qui vous donne « compte, min, max, moyenne et somme » en un seul résultat.

| Correspondance et recherche | Transformations et réductions de types | Réductions statistiques (numériques) | Traitement       |
|-----------------------------|----------------------------------------|--------------------------------------|------------------|
| `allMatch`                  | `collect`                              | `average`                            | `forEach`        |
| `anyMatch`                  | `reduce`                               | `count`                              | `forEachOrdered` |
| `findAny`                   | `toArray`                              | `max`                                |                  |
| `findFirst`                 | `toList`                               | `min`                                |                  |
| `NoneMatch`                 |                                        | `sum`                                |                  |
|                             |                                        | `summaryStatistics`                  |                  |


