1. __PREREQUIS__
    - Quelle version de java utiliser pour compiler/exécuter : Java 1.8, à savoir celle incluant de base JavaFX.

        "java -version" -> "java 1.8.XXX".


2. __JAR__
    - Ligne de commande pour exécuter le projet à partir du jar exécutable :

        "java -jar executable.jar"

    /!\ Le répertoire "ressources" doit être au même niveau que l'archive jar /!\.




3. __ECLIPSE__
    - Ligne de commande pour exécuter le projet sur eclipse /!\ SI VOUS UTILISEZ UNE VERSION DE JAVA > 1.8/!\.

        __WINDOWS__
            Run Configuration : ajouter cette ligne :  
                --module-path "lib/javafx-sdk-Windows/lib" --add-modules javafx.controls,javafx.fxml

        __LINUX__
            Run Configuration : ajouter cette ligne :  
                --module-path "lib/javafx-sdk-Linux/lib" --add-modules javafx.controls,javafx.fxml


    - La classe principale à Run est la classe "source-du-projec/src/application/MainIHM.java"