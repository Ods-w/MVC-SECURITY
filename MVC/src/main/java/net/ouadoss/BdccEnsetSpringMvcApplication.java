package net.ouadoss;

import net.ouadoss.entities.Product; // Import de l'entité Product
import net.ouadoss.repsoitory.ProductRepository; // Import du repository pour accéder aux produits
import org.springframework.boot.CommandLineRunner; // Permet d’exécuter du code au démarrage de l’application
import org.springframework.boot.SpringApplication; // Classe pour lancer l’application Spring Boot
import org.springframework.boot.autoconfigure.SpringBootApplication; // Annotation pour configurer Spring Boot automatiquement
import org.springframework.context.annotation.Bean; // Permet de déclarer un Bean dans le contexte Spring

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}) // Option pour désactiver la sécurité automatique (commentée ici)
@SpringBootApplication // Indique que c’est l’application principale Spring Boot
public class BdccEnsetSpringMvcApplication {

    // Méthode principale pour lancer l’application
    public static void main(String[] args) {
        SpringApplication.run(BdccEnsetSpringMvcApplication.class, args);
    }

    // Bean CommandLineRunner : ce code s’exécute automatiquement au démarrage de l’application
    @Bean
    public CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            // Création et sauvegarde de produits dans la base de données
            productRepository.save(Product.builder()
                    .name("Computer")
                    .price(5400)
                    .quantity(12)
                    .build());

            productRepository.save(Product.builder()
                    .name("Printer")
                    .price(1200)
                    .quantity(11)
                    .build());

            productRepository.save(Product.builder()
                    .name("Smart Phone")
                    .price(12000)
                    .quantity(33)
                    .build());

            // Affichage de tous les produits présents dans la base pour vérifier leur sauvegarde
            productRepository.findAll().forEach(p -> {
                System.out.println(p.toString());
            });
        };
    }

}
