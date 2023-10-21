### **Que sont les génériques**
+ Java prend en charge les types génériques, tels que les classes, les enregistrements et les interfaces. Il prend également en charge les méthodes génériques. Cela semble déroutant ?

### **Décalquer une classe ou déclarer une classe générique**
+ Sur cette partie, je vous montre une déclaration de classe normale, à côté d'une classe générique.
+ La chose à remarquer avec la classe générique, c'est que la déclaration de classe comporte des crochets angulaires avec un « T », directement après le nom de la classe.
+ `T` est l'espace réservé pour un type qui sera spécifié plus tard.
+ Cela s'appelle un identifiant de type, et il peut s'agir de n'importe quelle lettre ou mot, mais « T », qui est l'abréviation de Type, est couramment utilisé.

### **Utiliser une classe générique comme type de référence**
+ Sur cette partie, j'ai une déclaration de variable de `ArrayList` générique.
+ Dans cette déclaration d'un type référence qui utilise des génériques, le paramètre type est déclaré entre crochets.
+ Le type de référence est `ArrayList`, le paramètre de type (ou type paramétré) est `String`, qui est indiqué entre crochets angulaires, et `listOfString` est le nom de la variable.
+ De nombreuses bibliothèques Java sont écrites à l'aide de classes et d'interfaces génériques, nous les utiliserons donc beaucoup à l'avenir.
+ Mais c'est quand même une bonne idée d'apprendre à écrire votre propre classe générique, pour vous aider à comprendre le concept.


