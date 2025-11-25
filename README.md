## Compte Rendu du TP3 : Gestion des Produits avec Spring Boot
### 1. Objectif du TP:

#### L’objectif principal de ce TP est de développer une application Web permettant de gérer des produits,
#### en utilisant les technologies Spring Boot, Spring Data JPA, Hibernate, Thymeleaf, et Spring Security. 
#### L’application doit permettre de créer, afficher, modifier et supprimer des produits.

### 2. Création de l’entité Product
#### L’entité Product représente un produit dans l’application et a été annotée avec @Entity pour permettre le mapping avec la base de données via JPA.
#### Elle contient les attributs principaux d’un produit : id (identifiant unique auto-généré), name (nom du produit), price (prix), description et quantity (quantité disponible).
<img width="1105" height="735" alt="image" src="https://github.com/user-attachments/assets/1e2f702b-e6fb-4068-98d4-e96c38d5a097" />

<img width="658" height="102" alt="image" src="https://github.com/user-attachments/assets/ab9b69da-5214-4410-942a-408972963780" />

### 3. Création du ProductRepository
#### Pour gérer l’accès aux données, nous avons créé l’interface ProductRepository qui étend JpaRepository. Cette interface fournit des méthodes prêtes à l’emploi pour effectuer
#### des opérations CRUD (Create, Read, Update, Delete) sur les produits sans avoir besoin d’écrire du code SQL complexe.nous j'ai ajouté une méthode personnalisée findByNameContaining(String keyword) pour 
#### permettre la recherche de produits par nom.
<img width="1558" height="236" alt="image" src="https://github.com/user-attachments/assets/682d7511-ea89-4e3d-b72a-827beb3a4e71" />

### 4. Test de la couche DAO
#### Avant de passer au développement des vues, nous avons testé la couche DAO pour vérifier que les opérations de base fonctionnent correctement.
#### Des produits ont été ajoutés, modifiés et supprimés, et les résultats ont été vérifiés dans la base de données H2.
<img width="1600" height="844" alt="image" src="https://github.com/user-attachments/assets/57e471d6-27e3-486b-9a1a-237dbd762da6" />

### 5. Désactivation de la protection par défaut de Spring Security
#### Au début du TP, la sécurité par défaut de Spring Security est désactivée pour permettre de développer et tester facilement les fonctionnalités
#### de l’application, comme l’ajout, l’affichage ou la suppression de produits, sans être bloqué par un login. Concrètement,toutes les pages deviennent
#### accessibles sans authentification. Une fois que l’application fonctionne correctement, Spring Security peut être éactivé pour sécuriser l’accès avec des utilisateurs et des rôles.
<img width="1600" height="851" alt="image" src="https://github.com/user-attachments/assets/80f24c8b-5403-42f6-b3ba-1c102dd3d925" />
 

### 6. Création du contrôleur et des vues Thymeleaf
#### Le contrôleur ProductController gère toutes les interactions entre l’utilisateur et l’application. Il permet d’afficher la liste des produits
#### d’ajouter de nouveaux produits via un formulaire, de supprimer des produits existants, et de mettre à jour les informations des produits.
#### USER :
#### Accès limité
### Peut seulement consulter la liste des produits
#### Page de login
<img width="1912" height="551" alt="image" src="https://github.com/user-attachments/assets/16eb4dae-11a3-4574-99d0-2b0e143c8d44" />

<img width="1916" height="510" alt="image" src="https://github.com/user-attachments/assets/4c45a177-daa7-44c0-ab51-e55e23b1298a" />

#### ADMIN:
#### Accès complet à l’application , peut ajouter, modifier et supprimer des produits
<img width="1912" height="528" alt="image" src="https://github.com/user-attachments/assets/b5fed046-833e-4864-bb55-f033525db703" />

<img width="1903" height="570" alt="image" src="https://github.com/user-attachments/assets/abe1b9bb-4567-489c-9e5b-3dcb3fae3ed4" />

<img width="1915" height="600" alt="image" src="https://github.com/user-attachments/assets/1fb97d33-7afc-445d-a960-eacca628effc" />

<img width="1911" height="627" alt="image" src="https://github.com/user-attachments/assets/22fda8b7-14da-4f80-ba6d-5d0eb57a742e" />

### 8 . Conclusion
#### Ce TP a permis de développer une application Web complète avec Spring Boot, intégrant à la fois la gestion des données avec JPA/Hibernate et la présentation via Thymeleaf.
#### Nous avons appris à :
#### Créer et gérer des entités JPA
#### Utiliser Spring Data pour simplifier les opérations sur la base de données
#### Créer des vues dynamiques avec Thymeleaf
#### Sécuriser une application avec Spring Security
#### Ajouter des fonctionnalités avancées comme la recherche et la mise à jour de produits
