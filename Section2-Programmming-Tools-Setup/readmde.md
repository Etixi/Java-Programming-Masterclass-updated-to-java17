### **Install JDK 17 for Winbdows**
+ [JDK 17](https://download.oracle.com/java/17/latest/jdk-17_windows-x64_bin.exe ( sha256))

### **Confirming Installation and intro to JShell**

#### **Terminal**

| Commands      | Description       |
|---------------|-------------------|
| java -version | java version      |
| java          | some informations |

#### **Jshell**

+ JShell est devenu un composant standard du kit Java Developers dans Java 9.
+ Il s'agit de ce qu'on appelle le programme interactif Read-Eval-Print-Loop (ou REPL en abrégé), ce qui signifie qu'il fait à peu près exactement cela :
    + Il « lit » la commande ou le segment de code que nous tapons.
    + Il « évalue » et exécute le code, et permet souvent d'utiliser des raccourcis.
    + Il « imprime » les résultats de l'évaluation ou de l'exécution, sans obliger le développeur à écrire du code pour afficher les résultats.
    + Enfin, il revient en boucle pour plus d'entrées (plus de segments de code ou de commandes).
      JShell s'exécute dans un terminal (ou sur la ligne de commande pour Windows) et est utile pour essayer rapidement de nouvelles idées.

+ JShell ne remplace pas le besoin d'un IDE.
+ C'est juste un outil pratique pour démarrer rapidement avec Java. Nous passerons à un IDE plus tard dans le cours.


#### **Work in JShell**

                PS C:\WINDOWS\system32> jshell
                |  Welcome to JShell -- Version 17.0.6
                |  For an introduction type: /help intro

                jshell> /help intro

                jshell> /help

                jshell> /list -all


                jshell> /list -start


                jshell> /exit
