package net.ouadoss.entities;

import jakarta.persistence.Entity; // Permet de déclarer cette classe comme une entité JPA
import jakarta.persistence.GeneratedValue; // Pour générer automatiquement la valeur de l'identifiant
import jakarta.persistence.Id; // Pour indiquer le champ clé primaire de l'entité
import jakarta.validation.constraints.Min; // Pour valider les valeurs minimales
import jakarta.validation.constraints.NotEmpty; // Pour valider que les chaînes ne sont pas vides
import jakarta.validation.constraints.Size; // Pour valider la taille des chaînes
import lombok.*; // Lombok pour générer automatiquement getters, setters, constructeurs, etc.

@Entity // Indique que cette classe est une entité persistée dans la base de données
@NoArgsConstructor // Génère un constructeur sans argument (utile pour JPA)
@AllArgsConstructor // Génère un constructeur avec tous les arguments
@Getter // Génère automatiquement les getters pour tous les champs
@Setter // Génère automatiquement les setters pour tous les champs
@ToString // Génère automatiquement la méthode toString()
@Builder // Permet d'utiliser le pattern Builder pour créer des objets facilement
public class Product {

    @Id // Indique que ce champ est la clé primaire
    @GeneratedValue // La valeur de l'id est générée automatiquement (auto-incrémentée)
    private Long id;

    @NotEmpty // Valide que le nom ne doit pas être vide
    @Size(min = 3, max = 50) // Valide que le nom doit contenir entre 3 et 50 caractères
    private String name;

    @Min(0) // Valide que le prix doit être supérieur ou égal à 0
    private double price;

    @Min(1) // Valide que la quantité doit être supérieure ou égale à 1
    private double quantity;
}

