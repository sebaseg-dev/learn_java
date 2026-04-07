package fr.sebaseg.datalayer;

import fr.sebaseg.datalayer.model.Category;
import fr.sebaseg.datalayer.model.Comment;
import fr.sebaseg.datalayer.model.Product;
import fr.sebaseg.datalayer.service.CategoryService;
import fr.sebaseg.datalayer.service.CommentService;
import fr.sebaseg.datalayer.service.ProductService;
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
    public void run(String @NonNull ... args) throws Exception {

        Iterable<Product> products = productService.getProducts();
        products.forEach(product -> System.out.println(product.getName()));

        Iterable<Category> categories = categoryService.getServices();
        categories.forEach(category -> System.out.println(category.getName()));

        Iterable<Comment> comments = commentService.getComments();
        comments.forEach(comment -> System.out.println(comment.getContent()));

        Optional<Product> product = productService.getProductById(4);
        product.ifPresent(p -> System.out.println(p.getName()));
    }
}
