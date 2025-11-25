package net.ouadoss.web;

import jakarta.servlet.http.HttpSession; // Pour gérer la session utilisateur
import jakarta.validation.Valid; // Pour valider les objets avec Spring Validation
import net.ouadoss.entities.Product; // Import de l'entité Product
import net.ouadoss.repsoitory.ProductRepository; // Import du repository pour accéder aux produits
import org.springframework.beans.factory.annotation.Autowired; // Pour injecter automatiquement le repository
import org.springframework.security.access.prepost.PreAuthorize; // Pour sécuriser les méthodes selon le rôle
import org.springframework.stereotype.Controller; // Indique que cette classe est un contrôleur Spring MVC
import org.springframework.ui.Model; // Pour passer des données au template Thymeleaf
import org.springframework.validation.BindingResult; // Pour vérifier les erreurs de validation
import org.springframework.web.bind.annotation.GetMapping; // Pour gérer les requêtes GET
import org.springframework.web.bind.annotation.PostMapping; // Pour gérer les requêtes POST
import org.springframework.web.bind.annotation.RequestParam; // Pour récupérer les paramètres dans l'URL

import java.util.List;

@Controller // Cette classe est un contrôleur Spring MVC
public class ProductController {

    @Autowired
    private ProductRepository productRepository; // Injection du repository pour manipuler les produits

    // Page principale accessible aux utilisateurs avec le rôle USER
    @GetMapping("/user/index")
    @PreAuthorize("hasRole('USER')") // Autorise uniquement les utilisateurs ayant le rôle USER
    public String index(Model model) {
        List<Product> products = productRepository.findAll(); // Récupère tous les produits
        model.addAttribute("productList", products); // Passe la liste des produits à la vue Thymeleaf
        return "products"; // Retourne le nom de la page HTML à afficher
    }

    // Redirection de la page d'accueil vers la page des produits
    @GetMapping("/")
    public String home() {
        return "redirect:/user/index";
    }

    // Supprimer un produit (accessible uniquement aux ADMIN)
    @PostMapping("/admin/delete")
    @PreAuthorize("hasRole('ADMIN')") // Seuls les admins peuvent supprimer
    public String delete(@RequestParam(name = "id") Long id){
        productRepository.deleteById(id); // Supprime le produit par son id
        return "redirect:/user/index"; // Redirige vers la liste des produits
    }

    // Afficher le formulaire pour ajouter un nouveau produit (ADMIN seulement)
    @GetMapping("/admin/newProduct")
    @PreAuthorize("hasRole('ADMIN')")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product()); // Ajoute un objet Product vide pour le formulaire
        return "new-product"; // Page Thymeleaf pour créer un produit
    }

    // Enregistrer un nouveau produit après soumission du formulaire (ADMIN seulement)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/saveProduct")
    public String saveProduct(@Valid Product product, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) return "new-product"; // Si erreurs de validation, retourne le formulaire
        productRepository.save(product); // Sauvegarde le produit dans la base
        return "redirect:/admin/newProduct"; // Redirige pour permettre d'ajouter un autre produit
    }

    // Page affichée si l'utilisateur n'a pas les droits nécessaires
    @GetMapping("/notAuthorized")
    public String notAuthorized(){
        return "notAuthorized"; // Retourne une page Thymeleaf d'accès refusé
    }

    // Page de login
    @GetMapping("/login")
    public String login(){
        return "login"; // Affiche le formulaire de connexion
    }

    // Déconnexion de l'utilisateur
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate(); // Supprime toutes les informations de session
        return "login"; // Redirige vers la page de login
    }
}
