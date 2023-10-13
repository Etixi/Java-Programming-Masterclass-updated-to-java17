### **The switch statement**

            switch(value) {
                case x :
                    // Code for value == x
                    break;
                case y :
                    // Code for value == y
                    break;
                default :
                    // Code for value not eqaul to x or y
            }

### **Switch Value Types**

| Valid Switch Value Types        |
|---------------------------------|
| byte, short, int, char          |
| Byte, Short, Integer, Character |
| String                          |
| enum                            |

+ Important : Impossible d'utiliser `long, float, double ou boolean` sur leurs wrappers.


### **En boucle**
+ `Looping ` exécutons le code plusieurs fois.
+ `Java` prend en charge plusieurs instructions pour boucler ou exécuter du code de manière répétitive.

| Statements | Explanation  |
|------------|--------------|
| `for`      | La boucle `for` est plus complexe à configurer mais est couramment utilisée lorsque vous parcourez un ensemble de valeurs.             |
| `while`    | La boucle `while` s'exécute jusqu'à ce qu'une condition spécifiée devienne fausse.             |
| `do while` | La boucle `do while` en exécute toujours au moins un et continue jusqu'à ce qu'une condition spécifiée devienne fausse.             |


### **Une classe**
+ Une classe peut être décrite comme :
    + un type de données personnalisé.
    + un bloc de code spécial qui contient des méthodes.


+ Un cours est comme un formulaire vide qui est copié et distribué.
+ Le formulaire est copié et distribué. C'est donc comme la création d'objets à partir de la classe.
+ Un objet est comme le formulaire une fois qu'il a été distribué et rempli.
+ Chaque objet aura des valeurs uniques pour les données du formulaire collectées.

### **Un objet**
+ Un objet est appelé une instance d'une classe particulière.

  + Vous créez un objet en « instanciant une classe ».
  + Objet et instance sont des termes interchangeables.
  + Vous pouvez créer de nombreux objets en utilisant une seule classe. Chacun peut avoir des attributs ou des valeurs uniques.

|Champ statique| Champ d'instance|
|-----------------|------------------------|
|Nécessite le mot-clé `static` lorsqu'il est déclaré sur la classe|Omet les mots-clés `static` déclarés sur la classe.|
|La valeur du champ est stockée dans un emplacement mémoire spécial et à un seul endroit| La valeur du champ ne reçoit aucune mémoire et n'a aucune valeur jusqu'à la création de l'objet.|
|La valeur est accessible par `ClassName.fieldname`. Exemple : `Integer.MAX_VALUE`|La valeur est accessible par `ObjectVariable.fieldname`. Exemple mon `Object.FieldName` (`myObject` est notre nom de variable pour un objet que nous créons et `myFieldName` est un attribut de la classe|
|Nécessite le mot-clé `static` lorsqu'il est déclaré sur la classe.|Omet le mot-clé `static` lorsqu'il est déclaré sur la classe.|
|La méthode est accessible par `ClassName.methodName`. Exemple : `Integer.parseInt("123")`. Une méthode appelée `parseInt` est appelée directement depuis la `Class, Integer`.|La méthode est accessible par `ObjectVariable.methodName`. Exemple : `"bonjour".toUpperCase()`. Une méthode appelée `UpperCase` est appelée sur l'instance d'une chaîne avec la valeur `"hello"`|
​
