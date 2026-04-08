package fr.sebaseg.datalayer;

import fr.sebaseg.datalayer.model.Category;
import fr.sebaseg.datalayer.model.Comment;
import fr.sebaseg.datalayer.model.Product;
import fr.sebaseg.datalayer.service.CategoryService;
import fr.sebaseg.datalayer.service.CommentService;
import fr.sebaseg.datalayer.service.ProductService;
import jakarta.transaction.Transactional;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Optional;

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {

    @Autowired
    ProductService productService;

    @Autowired
    CommentService commentService;

    @Autowired
    CategoryService categoryService;

    public static void main(String[] args) {
        SpringApplication.run(DataLayerApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String @NonNull ... args) {

        Iterable<Product> products = productService.getProducts();
        products.forEach(product -> System.out.println(product.getName()));

        Iterable<Category> categories = categoryService.getCategories();
        categories.forEach(category -> System.out.println(category.getName()));

        Iterable<Comment> comments = commentService.getComments();
        comments.forEach(comment -> System.out.println(comment.getContent()));

        Optional<Product> product = productService.getProductById(4);
        product.ifPresent(p -> System.out.println(p.getName()));

        System.out.println("----------------------------------------");

        Optional<Product> product2 = productService.getProductById(1);
        product2.ifPresent(p -> System.out.println(p.getName()));
        Iterable<Comment> associatedComments;
        if (product2.isPresent()) {
            associatedComments = product2.get().getComments();

            for (Comment comment : associatedComments) {
                System.out.println(comment.getContent());
            }
        }

        System.out.println("----------------------------------------");
        Product product2Re = product2.orElse(null);
        if (product2Re != null) {
            product2Re.getCategories().forEach(
                    category -> System.out.println(category.getName())
            );
        } else {
            System.out.println("Aucune catégorie associée");
        }

        System.out.println("----------------------------------------");
        categoryService.getCategories().forEach(
                category -> System.out.println(category.getName())
        );

        Category newCategory = new Category();
        newCategory.setName("Promotion1");

        newCategory = categoryService.addCategory(newCategory);

        categoryService.getCategories().forEach(
                category -> System.out.println(category.getName())
        );

        System.out.println("----------------------------------------");
        Product newProduct = new Product();
        newProduct.setName("AssuranceAuTiersFidelite");
        newProduct.setDescription("Avec promotion");
        newProduct.setCost(1000);

        newCategory.addProduct(newProduct);

        newProduct = productService.addProduct(newProduct);

        productService.getProducts().forEach(p -> System.out.println(p.getName()));

        newProduct.getCategories().forEach(category -> System.out.println(category.getName()));
    }
}
