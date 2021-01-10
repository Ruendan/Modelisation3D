- Liste des étudiant·es (nom, prénom, groupe)
    - Dubois Quentin, Groupe G
    - Devigne Nathan, Groupe G
    - Hottin Lucas, Groupe G
    - Camus Sylvain, Groupe G

- Description des activités/responsabilités de chaque membre de l'équipe (rappel: les responsabilités doivent être équilibrées)

    Dubois Quentin - Ruendan/Marmotte : 
        Je me suis d'abord occupé de la classe Point, Face, Figure et une partie de la partie Modele du MVC.
        Je me suis aussi occupé de la Rédaction des tests unitaires, afin d'être certain que les méthodes de Rotation, de Translation, et 
        les autres fonctions intermediaires. (Ces fonctions se trouvant dans les Classes "Matrix" et "Deplacements" qui constituent les
        concepts Mathématiques.).
        J'ai finalement implémenté le modèle Observer/Observé (La vue Observant le Modele, et donc les elements de la vue sont des 
        observers de la classe Figure principalement).
        Aussi, je me suis chargé de l'edition du jar executable "executable.jar"

        Livrable 2

        J'ai principalement ajouté des features, comme par exemple le fait que l'utilisateur puisse ajouté ses propres fichiers ply, l'affichage d'une nouvelle vue, les parametres (ces elements se trouvent au dessus de l'explorer).
        J'ai egalement fait les erreurs, et leur affichage. Ainsi, quand une erreur est soulevée, un message en lien s'affiche.
        Pour une meilleur efficacité, j'ai essayé de totalement changer la manière dont les points et les faces etaient modélisées (faire un calcul matriciel au lieu d'une boucle qui prends beaucoup plus de temps. Cet ajout peut etre trouvé sur la branche feature/matriceDePoint. Et Lucas a essayé de faire sa propre implementation).
        Ensuite, une feature que j'ai voulu ajouté mais que je n'ai cependant pas eu le temps d'ajouter est le fait de faire ses propres scripts. Ainsi, l'utilisateur aurai pu faire des scripts personalisés et executés grâce à un bouton. On pourra trouver les ebauches de ce travail sur la branche feature/personnalScript. 

    Devigne Nathan : 
        Je me suis premièrement occupé de la conceptualisation de l'interface de notre projet afin que l'on ait un modèle en accord avec tout les membres du projet
        Je me suis ensuite occupé de la création d'éléments contenus dans l'interface; la liste des fichiers, les différents boutons et leur placement,
        la création d'une classe pour simplifier leur création et permettre d'y placer une image, l'ajout de tooltip. J'ai également produit les images présentes dans les boutons de l'application.
        Après le premier modèle du livrable 1 j'ai redesigné l'interface afin de nous permettre d'ajouter des boutons supplémentaires pour les différentes fonctions à appliquer au modèle.
        J'ai terminé par ajouter l'icône de l'application avant de rédiger la javadoc ainsi que de produire le diagramme UML.
        
    Hottin Lucas : 
        Je me suis initialement occupé de la conceptualisation de la figure dans la classe Figure et de l'affichage du modèle 3D, j'ai donc fais les fonctions de Translation, de Rotation et de Zoom.
        Au fur et à mesure j'ai créé avec Quentin de nouvelles classes "Matrix" et "Mouvement" pour alléger la classe Figure.
        Avec Sylvain on a travaillé sur l'ordre d'affichage, je me suis donc aidé de la classe Vecteur pour les faire.
        J'ai aussi aidé dans le changement de modèle de l'explorateur.
        J'ai aidé beaucoup sur l'optimisation en étant dérrière mes camarades et non dérrière mon écran.
        Je me suis aussi occupé de pas mal de la doc du coté de la modélisation.
        Avec Quentin on a essayé de convertir la liste de point en matrice mais le manque de temps nous en a empéché donc nous sommes resté sur la version stable de la liste de point.
        Je me suis aussi occupé de faire les déplacement à la souris, le zoom je l'ai fait avec Sylvain.

    Camus Sylvain : 
        J'ai réalisé le Parser des fichiers ply !! (qui est entièrement modulable ^^ ), j'ai aussi réalisé toute la partie avec les vecteurs,
	j'ai aussi fait enormément de refactoring. Incluant notamment la mise en place du pmd. Ainsi que de nombreux fix (redimensionnement du canva, j'en passe)
	Mise en Place des Ombre, évolution de l'interface graphique, Implémentation du Toggle Switch, Mise en place des Couleur( couleurs sur Point et sur face)

- Toutes précisions qui vous semblent importantes pour la bonne évaluation de votre projet (problème spécifique par exemple une absence prolongée de l'un des membres, réalisation dont vous êtes particulièrement fiers, ...)
    #TODO