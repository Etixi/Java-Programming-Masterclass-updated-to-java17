### **Communiquer en dehors des ressources JVM**
+ Les ressources peuvent être des « fichiers, connexions réseau, connexions de base de données, flux, sockets ».
+ Nous les utilisons pour interagir avec « les systèmes de fichiers, les réseaux et les bases de données, pour échanger des informations ».

### **Gestion des exceptions**
+ Lorsque vous utilisez des ressources externes, la gestion des exceptions devient beaucoup plus importante.

### **Que se passe-t-il réellement lorsque vous ouvrez un fichier depuis une application Java ?**
+ Lorsque vous instanciez l'une des classes d'accès « fichier de Java », Java déléguera au système d'exploitation l'ouverture à partir du « système de fichiers du système d'exploitation ».
+ Ceci effectue ensuite tout ou partie des étapes suivantes.
    + Tout d'abord, il vérifie si le fichier existe.
    + Si le fichier existe, il vérifie ensuite si l'utilisateur ou le processus dispose des autorisations appropriées pour le type d'accès demandé.
    + Si cela est vrai, alors les métadonnées du fichier sont récupérées et un descripteur de fichier est alloué. Ce descripteur est un handle vers le fichier d’opérande.
    + Une entrée est effectuée dans la table des fichiers ou la table des blocs de contrôle de fichiers du système d'exploitation, pour suivre le fichier de l'opérande.
    + Le fichier est peut-être verrouillé.
    + Le fichier peut être mis en mémoire tampon par le « OS », ce qui signifie que de la mémoire est allouée, pour mettre en cache tout ou partie du contenu du fichier, afin d'optimiser les opérations de lecture et d'écriture.

### **Fermeture d'une ressource de fichier ouvert**
+ De nombreuses méthodes en Java font que l'ouverture d'un fichier ressemble à l'instanciation d'un autre.
+ Vous n'êtes pas obligé d'appeler open a file, il est donc facile d'oublier que vous avez réellement ouvert une ressource.
+ La fermeture du descripteur de fichier libérera la mémoire utilisée pour stocker toutes les données liées au fichier et permettra à d'autres processus d'accéder au fichier.
+ Heureusement, la plupart des classes Java que vous utiliserez pour interagir avec les fichiers implémentent également une interface « AutoCloseable », qui rend la fermeture des ressources transparente.

### **IO, NIO, NIO.2**
+ Java a ce qui semble être une grande série de classes très confuses, dans de nombreux packages, pour prendre en charge les « entrées/sorties ».
+ Je couvrirai les types les plus couramment utilisés, mais parlons d'abord de la terminologie quelque peu déroutante de Java qui inclut « IO, NIO et NIO.2 ».
+ Premièrement, `IO` était un terme pour `input/output`, et `java.io` est un package qui contient l'ensemble original de types, qui prennent en charge la lecture et l'écriture de données à partir de ressources externes.
+ `NIO` a été introduit comme `Non-blocking IO`, avec le package `java.nio` dans `java 1.4`, ainsi que quelques autres packages associés. La communication avec les ressources est facilitée par des types spécifiques de channels et par les données stockées dans des conteneurs appelés « Buffers », lors de l'échange.
+ `NIO.2` signifie `New IO`, et est un terme qui est apparu avec `java 1.7`, mettant l'accent sur des améliorations significatives apportées au package `java.nio`, plus important encore au package de fichiers `java.nio` et ses types.

### **Exception vérifiée**
+ `Une exception vérifiée` représente un problème anticipé ou courant qui pourrait survenir.
+ Vous pouvez imaginer qu'une faute de frappe dans le nom du fichier pourrait être un phénomène courant et que le système ne serait pas en mesure de localiser un fichier.
+ C'est si courant que Java a généralement une exception nommée juste pour cette situation, la `FileNotFoundException`, qui est une sous-classe de `IOException`.

### **Une exception vérifiée doit être interceptée ou spécifiée dans la clause throw de la méthode conteneur**
+ Comment gérer une exception vérifiée ?
+ Vous avez deux options.
+ Vous pouvez envelopper l'instruction qui lève une exception vérifiée dans un bloc try catch, puis gérer la situation dans le bloc catch.
+ Ou, alternativement, vous pouvez modifier la signature de la méthode, en déclarant une clause throws et en spécifiant ce type d'exception.

### **La clause finale**
+ Une clause `finally` est utilisée conjointement avec une instruction `try`.
+ Une instruction `try` traditionnelle nécessite soit une clause `catch ou finalement`, ou peut inclure les deux.
+ La clause `finally` est toujours déclarée après le `catch block` s'il en est un.
+ Le code du bloc `finally` est toujours exécuté, peu importe ce qui se passe dans les blocs `try or catch`.
+ Le bloc «finally» n'a accès ni aux variables locales du bloc «try or catch».

### **Quel est le but de la clause final ?**
+ Le but initial de la « clause finale » était d'avoir un seul bloc de code pour effectuer des opérations de nettoyage.
+ Cela incluait la fermeture de la connexion ouverte, la libération des verrous ou la libération de ressources.
+ Cette clause garantissait que ce code était exécuté, aussi bien lors de l'exécution normale qu'en cas d'exception.
+ La syntaxe `try with resources`, introduite dans `JDK7, est une meilleure approche` que d'utiliser la clausefinal pour fermer les ressources.
+ La « clause finale » peut être utilisée pour exécuter d'autres tâches importantes, telles que la journalisation ou la mise à jour de l'interface utilisateur.

### **Inconvénients de l'utilisation de la clause final**
+ Il peut être difficile de lire et de comprendre le code qui utilise cette clause.
+ Il peut être utilisé pour masquer les erreurs, ce qui peut rendre le débogage plus difficile.
+ Si vous exécutez du code qui n'est pas lié aux tâches de nettoyage, cela rendra plus difficile la maintenance de votre code.


### **Comparaison de try-with-resources à la clause try traditionnelle**

| try-with-resources examples                                                                                                                                                                                                                                                        | traditional try clause                                                                                                                                                                                                                                                    |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| // First Example <br/> `try (FileReader reader = new FileReader(filename) {` <br/> //do something `}` <br/> // Second Example <br/> `try (FileReader reader = new FileReader(filename);` <br/> `FileWriter writer = new FileWriter("New" + filename)` <br/> do something <br/> `}` | `FileReader reader = null;` <br/> `try {` <br/> `reader = new FileReader(filename);` <br/> `} finally {` <br/> `if (reader != null)` <br/> `try {` <br/> `reader.close();` <br/> `} catch(IOException e) {` <br/> // do Something <br/> `}` <br/> `}` <br/> `}` <br/> `}` |


+ L'essai avec les ressources prend une liste de variables de ressources délimitées par deux points.
+ Les ressources de cette liste doivent implémenter l'interface `AutoClosaeble ou Closeable`.

### **Concepts du système de fichiers**
+ `Un répertoire (ou dossier)` est un conteneur de système de fichiers pour d'autres répertoires ou fichiers.
+ `Un chemin` est soit un répertoire, soit un nom de fichier, et peut inclure des informations sur les répertoires ou dossiers parents.
+ `Un répertoire racine` est le répertoire de niveau supérieur dans un système de fichiers.
+ Le « répertoire de travail actuel » est le répertoire dans lequel le processus actuel travaille ou à partir duquel il s'exécute.
+ Un `Chemin absolu` inclut la racine (en commençant par `/` ou éventuellement par `C:\` dans Windows, où `c` est l'identifiant de la racine.
+ `Un chemin relatif` définit les chemins vers le travail en cours, et ne commencerait donc pas par `/`, mais peut éventuellement commencer par un point `.` puis un fichier par un caractère séparateur.



|Modificateur et type| 	Méthode et description                                                                                                                                                                                                                                                                                |
|--------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|boolean| 	`canExecute()` <br/> Teste si l'application peut exécuter le fichier désigné par ce chemin d'accès abstrait.                                                                                                                                                                                          |
|boolean| 	`canRead()` <br/> Teste si l'application peut lire le fichier désigné par ce chemin d'accès abstrait.                                                                                                                                                                                                 | 
|boolean| 	`canWrite()` <br/> Teste si l'application peut modifier le fichier désigné par ce chemin d'accès abstrait.                                                                                                                                                                                            |
|int| 	`compareTo(File pathname)` <br/> Compare lexicographiquement deux chemins abstraits.                                                                                                                                                                                                                  |
|boolean| 	`createNewFile()` <br/> Crée atomiquement un nouveau fichier vide nommé par ce chemin abstrait si et seulement si un fichier portant ce nom n'existe pas encore.                                                                                                                                      |
|static File| 	`createTempFile(String prefix, String suffix)` <br/> Crée un fichier vide dans le répertoire de fichiers temporaires par défaut, en utilisant le préfixe et le suffixe donnés pour générer son nom.                                                                                                   |
|static File| 	`createTempFile(String prefix, String suffix, File directory)` Crée un nouveau fichier vide dans le répertoire spécifié, en utilisant les chaînes de préfixe et de suffixe données pour générer son nom.                                                                                              |
|boolean| 	`delete()` <br/> Supprime le fichier ou le répertoire désigné par ce chemin d'accès abstrait.                                                                                                                                                                                                         |
|void| 	`deleteOnExit()` <br/> Demande que le fichier ou le répertoire désigné par ce chemin abstrait soit supprimé à la fin de la machine virtuelle.                                                                                                                                                         |
|boolean| 	`equals(Object obj)` <br/> Teste l’égalité de ce chemin abstrait avec l’objet donné.                                                                                                                                                                                                                  |
|boolean| `exist()` <br/>Teste si le fichier ou le répertoire désigné par ce chemin abstrait existe.                                                                                                                                                                                                             |
|File| 	`getAbsoluteFile()`  <br/>     Renvoie la forme absolue de ce chemin abstrait.                                                                                                                                                                                                                        |
|String| 	`getAbsolutePath()` <br/>Renvoie la chaîne de chemin absolu de ce chemin abstrait.                                                                                                                                                                                                                    |
|File| 	`getCanonicalFile()` <br/>Renvoie la forme canonique de ce chemin abstrait.                                                                                                                                                                                                                           |
|String| 	`getCanonicalPath()` <br/>Renvoie la chaîne de chemin canonique de ce chemin abstrait.                                                                                                                                                                                                                |
|long| 	`getFreeSpace()` <br/>Renvoie le nombre d'octets non alloués dans la partition nommée par ce nom de chemin abstrait.                                                                                                                                                                                  |
|String| 	`getName()`<br/> Renvoie le nom du fichier ou du répertoire désigné par ce chemin abstrait.                                                                                                                                                                                                           |
|String| 	`getParent()` <br/>    Renvoie la chaîne de chemin du parent de ce chemin abstrait, ou nullsi ce chemin ne nomme pas de répertoire parent.                                                                                                                                                            |
|File| 	`getParentFile()` <br/>   Renvoie le chemin abstrait du parent de ce chemin abstrait, ou nullsi ce chemin ne nomme pas de répertoire parent.|
|String| 	`getPath()` <br/>  Convertit ce chemin abstrait en une chaîne de nom de chemin.|
|long| 	`getTotalSpace()` <br/>   Renvoie la taille de la partition nommée par ce chemin abstrait.|
|long| 	`getUsableSpace()` <br/> Renvoie le nombre d'octets disponibles pour cette machine virtuelle sur la partition nommée par ce chemin abstrait.|
|int| 	`hashCode()` <br/>   Calcule un code de hachage pour ce chemin abstrait.|
|boolean| 	`isAbsolute()` <br/> Teste si ce chemin abstrait est absolu.|
|boolean| 	`isDirectory()` <br/>  Teste si le fichier désigné par ce chemin abstrait est un répertoire.|
|boolean| 	`isFile()` <br/>Teste si le fichier désigné par ce chemin abstrait est un fichier normal.|                                                                                                                                                                                                                               |
|boolean| 	`isHidden()` <br/>Teste si le fichier nommé par ce chemin abstrait est un fichier caché. |                                                                                                                                                                                                                               |
|long| 	`lastModified()`Renvoie l'heure à laquelle le fichier désigné par ce chemin abstrait a été modifié pour la dernière fois. |                                                                                                                                                                                              |
|long| 	`length()` <br/>Renvoie la longueur du fichier indiquée par ce chemin abstrait.  |                                                                                                                                                                                                                                       |
|String[]| 	`list()` <br/>Renvoie un tableau de chaînes nommant les fichiers et répertoires du répertoire désigné par ce chemin abstrait. |                                                                                                                                                                                          |
|String[]| 	`list(FilenameFilter filter)` <br/>Renvoie un tableau de chaînes nommant les fichiers et répertoires du répertoire désigné par ce chemin abstrait qui satisfont au filtre spécifié. |                                                                                                                                    |
|File[]| 	`listFiles()` <br/>Renvoie un tableau de chemins abstraits désignant les fichiers du répertoire désigné par ce chemin abstrait.|                                                                                                                                                                                         |
|File[]| 	`listFiles(FileFilter filter)` <br/>Renvoie un tableau de chemins abstraits désignant les fichiers et répertoires du répertoire désigné par ce chemin abstrait qui satisfont au filtre spécifié. |                                                                                                                       |
|File[]| 	`listFiles(FilenameFilter filter)` <br/>Renvoie un tableau de chemins abstraits désignant les fichiers et répertoires du répertoire désigné par ce chemin abstrait qui satisfont au filtre spécifié.|                                                                                                                    |
|static File[]| 	`listRoots()` <br/>Répertoriez les racines du système de fichiers disponibles.                                                                                                                                                                                                                        |
|boolean| 	`mkdir()` <br/> Crée le répertoire nommé par ce chemin abstrait.                                                                                                                                                                                                                                      |
|boolean| 	`mkdirs()` <br/>  Crée le répertoire nommé par ce chemin abstrait, y compris tous les répertoires parents nécessaires mais inexistants.|                                                                                                                                                                                 |
|boolean| 	`renameTo(File dest)` <br/>Renomme le fichier désigné par ce chemin abstrait.                                                                                                                                                                                                                         |
|boolean| 	`setExecutable(boolean executable)` <br/>Une méthode pratique pour définir l’autorisation d’exécution du propriétaire pour ce chemin abstrait. |                                                                                                                                                                        |
|boolean| 	`setExecutable(boolean executable, boolean ownerOnly)` <br/>Définit l'autorisation d'exécution du propriétaire ou de tout le monde pour ce chemin abstrait. |                                                                                                                                                           |
|boolean| 	`setLastModified(long time)` <br/>Définit l'heure de la dernière modification du fichier ou du répertoire nommé par ce chemin abstrait.|                                                                                                                                                                                 |
|boolean| 	`setReadable(boolean readable)` <br/>Une méthode pratique pour définir l’autorisation de lecture du propriétaire pour ce chemin abstrait. |                                                                                                                                                                              |
|boolean| 	`setReadable(boolean readable, boolean ownerOnly)` <br/>Définit l'autorisation de lecture du propriétaire ou de tout le monde pour ce chemin d'accès abstrait. |                                                                                                                                                       |
|boolean| 	`setReadOnly()` <br/>Marque le fichier ou le répertoire nommé par ce chemin abstrait afin que seules les opérations de lecture soient autorisées. |                                                                                                                                                                      |
|boolean| 	`setWritable(boolean writable)` <br/>    Une méthode pratique pour définir l’autorisation d’écriture du propriétaire pour ce chemin abstrait.|
|boolean| 	`setWritable(boolean writable, boolean ownerOnly)` <br/>  Définit l'autorisation d'écriture du propriétaire ou de tout le monde pour ce chemin d'accès abstrait.|
|Path| 	`toPath()` <br/>Renvoie un objet java.nio.file.Path construit à partir de ce chemin abstrait. |                                                                                                                                                                                                                          |
|String| 	`toString()` <br/>Renvoie la chaîne de chemin de ce chemin abstrait. |                                                                                                                                                                                                                                                   |
|URI| 	`toURI()` <br/>Construit un fichier : URI qui représente ce chemin abstrait.   |                                                                                                                                                                                                                                         |
|URL| 	`toURL()`<br/>Obsolète. <br/>Cette méthode n'échappe pas automatiquement aux caractères illégaux dans les URL. Il est recommandé que le nouveau code convertisse un chemin d'accès abstrait en URL en le convertissant d'abord en URI, via la toURIméthode, puis en convertissant l'URI en URL via la URI.toURLméthode. |




