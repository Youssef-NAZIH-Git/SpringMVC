# Gestionnaire de Produits — Spring MVC
 
> Application web de gestion de produits construite avec Spring Boot, Thymeleaf et Spring Security.
 
---
 
## Table des matieres
 
- [Apercu](#apercu)
- [Technologies utilisees](#technologies-utilisees)
- [Architecture](#architecture)
- [Fonctionnalites](#fonctionnalites)
- [Securite](#securite)
- [Captures d'ecran](#captures-decran)
- [Installation et demarrage](#installation-et-demarrage)
- [Configuration](#configuration)
 
---
 
## Apercu
 
Cette application permet de gerer un catalogue de produits via une interface web simple et intuitive.
Elle offre la creation, la modification, la suppression et la recherche de produits, le tout protege
par un systeme d'authentification base sur les roles.
 
---
 
## Technologies utilisees
 
| Categorie         | Technologie                          |
|-------------------|--------------------------------------|
| Framework         | Spring Boot                          |
| Vue               | Thymeleaf + Thymeleaf Layout Dialect |
| Securite          | Spring Security 6                    |
| Persistance       | Spring Data JPA                      |
| Base de donnees   | H2 (developpement) / MySQL (prod)    |
| Validation        | Jakarta Bean Validation              |
| Style             | Bootstrap 5.3                        |
| Build             | Maven                                |
| Utilitaires       | Lombok                               |
 
---
 
## Architecture
 
```
Navigateur
    |
    v
Spring Security (filtre d'authentification + autorisation par role)
    |
    v
ProductController  (@Controller)
    |
    v
ProductRepository  (Spring Data JPA)
    |
    v
Base de donnees (H2 / MySQL)
```
 
Le projet suit le patron **MVC** :
 
- **Modele** : entites JPA + repositories
- **Vue** : templates Thymeleaf dans `src/main/resources/templates/`
- **Controleur** : `ProductController` mappant les routes HTTP
 
---
 
## Fonctionnalites
 
- Affichage de la liste des produits
- Recherche de produits par nom (insensible a la casse)
- Ajout d'un nouveau produit avec validation
- Modification d'un produit existant
- Suppression d'un produit
- Authentification et gestion des roles (`USER`, `ADMIN`)
- Redirection automatique vers la page principale
 
---
 
## Securite
 
L'acces aux routes est controle par Spring Security selon les roles suivants :
 
| Route           | Role requis |
|-----------------|-------------|
| `/index/**`     | USER        |
| `/save/**`      | ADMIN       |
| `/delete/**`    | ADMIN       |
| Toute autre     | Authentifie |
 
Comptes disponibles en mode developpement (en memoire) :
 
| Utilisateur | Mot de passe | Role        |
|-------------|--------------|-------------|
| `user1`     | `1234`       | USER        |
| `user2`     | `1234`       | USER        |
| `admin`     | `1234`       | USER, ADMIN |
 
> Les mots de passe sont haches avec `BCryptPasswordEncoder`.
 
---
 
## Captures d'ecran
 
### Page de connexion
 
<img width="565" height="365" alt="image" src="https://github.com/user-attachments/assets/b162a620-dbc8-4c3e-8e81-6b42fff22bcd" />

---
 
### Liste des produits (index)
 
<img width="1919" height="444" alt="image" src="https://github.com/user-attachments/assets/cb12cb8d-6fb0-4484-b0ef-e37198d042e7" />
 
---
 
### Recherche d'un produit
 
<img width="1919" height="357" alt="image" src="https://github.com/user-attachments/assets/2af58407-603e-4c49-a5cb-9e1eaa1c75fd" />

 
---
 
### Ajout d'un produit
 
<img width="1916" height="320" alt="image" src="https://github.com/user-attachments/assets/49a66e66-6fb2-473b-b127-a7ef93d04e24" />
 
---
 
### Modification d'un produit
 
<img width="1919" height="417" alt="image" src="https://github.com/user-attachments/assets/db44596a-328a-4fd0-80b4-e004a80ce594" />
 
---
 
### Page d'erreur de validation
 
<img width="842" height="279" alt="image" src="https://github.com/user-attachments/assets/927e6e9e-97be-411e-a857-056d9b9d003a" />
 
---
 
## Installation et demarrage
 
### Prerequis
 
- Java 17+
- Maven 3.8+
- (Optionnel) MySQL pour la production
 
### Etapes
 
```bash
# 1. Cloner le depot
git clone https://github.com/votre-utilisateur/votre-repo.git
cd votre-repo
 
# 2. Compiler et lancer
mvn spring-boot:run
```
 
L'application sera disponible sur : [http://localhost:8080](http://localhost:8080)
 
La console H2 est accessible sur : [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
 
---
 
## Configuration
 
Le fichier principal de configuration est `src/main/resources/application.properties`.
 
---
 
> Projet realise a des fins d'apprentissage de Spring MVC, Thymeleaf et Spring Security de M. YOUSSFI, En utilisant le video aussi
 
