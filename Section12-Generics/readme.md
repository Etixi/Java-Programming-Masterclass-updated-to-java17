### **Que sont les génériques**
+ Java prend en charge les types génériques, tels que les classes, les enregistrements et les interfaces. Il prend également en charge les méthodes génériques. Cela semble déroutant ?

### **Déclarer une classe ou déclarer une classe générique**
+ Sur cette partie, je vous montre une déclaration de classe normale, à côté d'une classe générique.
+ La chose à remarquer avec la classe générique, c'est que la déclaration de classe comporte des crochets angulaires avec un « T », directement après le nom de la classe.
+ `T` est l'espace réservé pour un type qui sera spécifié plus tard.
+ Cela s'appelle un identifiant de type, et il peut s'agir de n'importe quelle lettre ou mot, mais « T », qui est l'abréviation de Type, est couramment utilisé.


|Regular class| Generic Class                                        |
|-------------|------------------------------------------------------|
|Class ITellYou { <br/> private String field; <br/> }| Class YouTellMe<T> { <br/> private T field; <br/> }  |


### **Utiliser une classe générique comme type de référence**
+ Sur cette partie, j'ai une déclaration de variable de `ArrayList` générique.
+ Dans cette déclaration d'un type référence qui utilise des génériques, le paramètre type est déclaré entre crochets.
+ Le type de référence est `ArrayList`, le paramètre de type (ou type paramétré) est `String`, qui est indiqué entre crochets angulaires, et `listOfString` est le nom de la variable.
+ De nombreuses bibliothèques Java sont écrites à l'aide de classes et d'interfaces génériques, nous les utiliserons donc beaucoup à l'avenir.
+ Mais c'est quand même une bonne idée d'apprendre à écrire votre propre classe générique, pour vous aider à comprendre le concept.


### **Paramètres de type générique**
+ Je vous ai déjà montré qu'une façon de déclarer une classe générique est d'inclure un paramètre de type que je montre ici, entre crochets.
+ Maintenant, utiliser `T` n'est qu'une convention, abréviation du type pour lequel vous souhaitez utiliser cette classe d'équipe.
+ Mais tu peux y mettre ce que tu veux.
+ Les types uniques sont la convention, et ils sont cependant beaucoup plus faciles à repérer dans le code de classe, alors laissez-moi vous encourager à vous en tenir à cette convention.
+ Vous pouvez avoir plus d'un paramètre de type, nous l'avons donc défini pour faire `T1, T2, T3`. (codé)

        public class Team<T1, T2, T3> { }

+ Mais encore une fois, la convention dit qu'au lieu d'utiliser des paramètres de type comme celui-ci, il est plus facile de lire le code avec des sélections de lettres alternatives.
+ Et ce sont généralement `S, U et V`dans cet ordre.
+ Si nous avions trois types, nous voudrions probablement déclarer cette classe comme indiqué ici, `T, S et U`.

        public class Team<T, S, U> { }

+ Quelques lettres sont récupérées pour des cas d'utilisation particuliers.
+ Les identificateurs de paramètres de type les plus couramment utilisés sont:
  + `E` pour élément (largement utilisé par Java Collections Framework).
  + `K` pour clé (utilisé pour les types mappés).
  + `N` pour Numéro.
  + `T` pour Type.
  + `V` pour Valeur.
  + `S, U, V etc` pour les 2ème, 3ème, 4ème types.


