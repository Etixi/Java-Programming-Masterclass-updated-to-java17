### **Tableaux**
+ Les éléments d'un tableau sont indexés à partir de 0.
+ Si nous avons un tableau stockant cinq noms, conceptuellement, il ressemble à ceci.

|Indice|0|1|2|3|4|
|---------|----|----|----|----|----|
|Valeurs stockées dans un tableau de 5 éléments|"Andy"|"Bob"|"Charlie"|"David"|"Eve"|
+ Le premier élément est à l'index 0 et est `Andy`.
+ Le dernier élément de ce tableau est à l'index 4 et a la valeur String `Eve`.

### **Décalage d'un tableau**
+ Lorsque vous déclarez un tableau, vous spécifiez d'abord le type des éléments que vous souhaitez dans le tableau.
+ Ensuite, vous incluez des crochets dans la déclaration, qui est la clé de Java, pour identifier la variable en tant que tableau.
+ Les crochets peuvent suivre le type comme indiqué dans les deux premiers exemples. C'est beaucoup plus courant.
+ Les crochets peuvent également être après le nom de la variable, comme indiqué dans le dernier exemple. Vous ne spécifiez pas de taille dans la déclaration du tableau elle-même.

| Déclaration de variable de tableau |
|------------------------------------|
| `int[] integerArray;`              |
| `String[] nameList;`               |
| `int[] courseList[];`              |

### **Instanciation d'un tableau**

| Création de tableaux                | Création d'objets                         |
|-------------------------------------|-------------------------------------------|
| `int[] integerArray = new int[10];` | `StringBuilder sb = new StringBuilder();` |


### **Les tableaux ne sont PAS redimensionnables**
+ La taille d'un tableau, une fois créé, est fixe.
+ Dans ce cas, `integerArray` aura 10 éléments.

| Array Creation                      |
|-------------------------------------|
| `int[] integerArray = new int[10];` |

+ Vous ne pouvez pas modifier la taille d'un tableau une fois le tableau instancié.
+ Nous ne pouvons pas ajouter ou supprimer d'éléments, nous ne pouvons attribuer des valeurs qu'à l'un des dix éléments de ce tableau, dans cet exemple.

### **L'initialiseur du tableau**
+ Un initialiseur de tableau facilite grandement le travail d'instanciation et d'initialisation d'un petit tableau.

| The array initializer                                        |
|--------------------------------------------------------------|
| `int[] firstFivePositives = {1, 2, 3, 4, 5}`                 |

+ Dans cet exemple, vous pouvez voir que nous utilisons toujours le mot-clé `new`, et que nous avons `int`, entre crochets.
+ Mais ici, nous spécifions les valeurs, nous voulons que le tableau soit initialisé, dans une liste délimitée par des virgules, entre accolades.
+ Comme ces valeurs sont spécifiées, la longueur du tableau peut être déterminée, nous ne spécifions donc pas la taille entre crochets. Et en fait, Java fournit un moyen encore plus simple de le faire.

### **L'initialiseur du tableau en tant que tableau anonyme**
+ Java nous permet de supprimer `new int[]` de l'expression, comme le montre ici.
+ C'est ce qu'on appelle un tableau anonyme. 
+ Ici, nous montrons des exemples pour un tableau `int` et un tableau String.

| The array initializer                                        |
|--------------------------------------------------------------|
| `int[] firstFivePositives = {1, 2, 3, 4, 5}`                 |
| `String[] names = {"Andy", "Bob", "Charlie", "David", "Eve"}` |


+ Un initialier de tableau anonyme, ne peut être utilisé que dans une instruction de déclaration.