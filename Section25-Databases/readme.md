### **Aperçu**
+ Dans cette section du cours, nous allons nous intéresser aux bases de données.
+ Nous allons commencer par un aperçu de `Bases de données et installer SQLite`, une source gratuite et open source de `SQL` (qui est un langage de base de données utilisé pour communiquer avec les bases de données).
+ Nous utiliserons la ligne de commande lorsque nous commencerons à utiliser `SQL`, mais ensuite dans les vidéos ultérieures de cette section, nous passerons à Java et commencerons à utiliser les bases de données à partir de Java.
+ Mais nous devons comprendre `SQL` avant de faire cela.
+ Vous vous demandez peut-être pourquoi `SQLite` et pas `MySQL`, une autre base de données ?
+ D'une manière générale, les compétences que vous apprendrez avec `SQLite` s'appliquent à n'importe quelle base de données, y compris `MySQL`. Ainsi, le « SQL » que vous apprendrez et le code Java que vous créerez nécessitent très peu de modifications pour fonctionner sur n'importe quelle base de données.
+ `SQLite` est idéal pour commencer, et j'ai des vidéos dans cette section montrant comment le faire fonctionner sous Windows. Mac et Linus aussi.
+ Mais vers la fin de cette section, nous allons également rendre MySQL opérationnel à titre d'exercice afin que vous puissiez voir à quel point il est facile d'accéder à une autre base de données.

### **Terminologie des bases de données**
+ `Database` : le conteneur de toutes les données que vous stockez.
+ Dans SQLite, l'intégralité de la base de données est stockée dans un seul fichier.
+ `Database Dictionary :` fournit une liste complète de la structure et des types de données dans la base de données.
+ `Table :` une collection de données associées contenues dans la base de données.
+ `Field :` l'unité de base des données dans un tableau.
+ Le tableau Factures comporte les champs Facture, Date, Description et Montant.
+ `Colonne :` est un autre nom pour le champ.
+ Cela peut prêter à confusion, mais les bases de données relationnelles existaient avant les feuilles de calcul.
+ `Row :` un seul ensemble de données contenant toutes les colonnes du tableau.
+ Le tableau Factures comporte 4 lignes - les lignes sont également appelées enregistrements.
+ Cela entraîne beaucoup de duplications...
+ et rend les mises à jour difficiles.
+ `A View` est une sélection de lignes et de colonnes, possible à partir de plus d'une table.

### **Telechargement SQLite**
+ [SQLite](www.sqlite.org/download.html)