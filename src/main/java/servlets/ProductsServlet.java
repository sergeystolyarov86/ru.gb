package servlets;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "productsServlet",urlPatterns = "/products")
public class ProductsServlet extends HttpServlet {
    private static class Product {
     
        private List<Product> productList = new ArrayList<>();
        private int id;
        private int coast;
        private String title;

        private String[] products={"banana","apple","carrot","apricot","grapefruit","lemon","mango","pineapple",
                "lime","avocado"};

        public Product( ) {
        }
        public Product(int id, String title,int coast ) {
            this.id = id;
            this.coast = coast;
            this.title = title;
        }
        public  List<Product> generateProducts(){
            Random random = new Random();
            for (int i = 0; i < products.length; i++) {
                productList.add(new Product(i,products[i],random.nextInt(1000) ));
            }
            return productList;
        }

        @Override
        public String toString() {
            return
                    "id = " + id +
                    ", title = " + title +
                    ", coast = '" + coast + '\'' ;
        }
    }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           Product product = new Product();
           product.generateProducts();
           for (Product p : product.productList ){
                resp.getWriter().println(p);
           }
        }
    }


