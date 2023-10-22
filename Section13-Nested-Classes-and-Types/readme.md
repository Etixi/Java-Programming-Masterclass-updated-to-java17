### **Classes (ou types) imbriquées dans une autre classe (ou type)**
+ Une classe peut contenir d'autres types dans le corps de la classe, tels que d'autres « classes, interfaces, énumérations et enregistrements ».
+ Ceux-ci sont appelés types imbriqués ou classes imbriquées.
+ Vous souhaiterez peut-être utiliser des classes imbriquées lorsque vos classes sont étroitement couplées, ce qui signifie que leurs fonctionnalités sont imbriquées.


### **Classes imbriquées**
+ Les quatre différents types de classes imbriquées que vous pouvez utiliser en Java sont : `les classes imbriquées statiques, la classe interne et les classes locales et anonymes`.


|Type| Description                                                                                                                            |
|-------|----------------------------------------------------------------------------------------------------------------------------------------|
|`Classe imbriquée statique`| déclarée dans le corps de la classe. Tout comme un champ statique, l'accès à cette classe se fait via l'identifiant du nom « Classe »  |
|`instance ou classe interne`| déclarée dans le corps de la classe. Ce type de classe n'est accessible que via une instance de la classe externe.                     |
|`classe locale`| déclarée dans un corps de méthode                                                                                                      |
|`classe anonyme`| classe sans nom, déclarée et instanciée dans la même instruction                                                                       |


### **Des restrictions importantes pour les classes imbriquées ont été supprimées dans JDK16**
+ Avant `JDK16`, seules les classes imbriquées statiques étaient autorisées à avoir des méthodes statiques.
+ Depuis le `JDK16`, les quatre types de classes imbriquées peuvent avoir des membres statiques de n'importe quel type, y compris des méthodes statiques.

### **Classe imbriquée statique**
+ La `classe imbriquée statique` est une classe enfermée dans la structure d'une autre classe, déclarée comme `static`.
+ Cela signifie que la classe, si elle est accessible en externe, nécessite le nom de la classe externe dans le cadre de la qualification.
+ Cette classe a l'avantage de pouvoir accéder aux attributs privés sur la classe externe.
+ La classe englobante peut accéder à tous les attributs de la classe imbriquée statique, y compris également les attributs privés.




