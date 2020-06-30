package servlets;

import database.Database;
import models.Product;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HomepageServlet extends HttpServlet {

    private static final String PRODUCTS_ATTRIBUTE_KEY = "products";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database database = (Database) getServletContext().getAttribute(ServletUtils.DATABASE_KEY);
        List<Product> allProducts = database.getAllProducts();
        req.setAttribute(PRODUCTS_ATTRIBUTE_KEY, allProducts);
        req.getRequestDispatcher("Homepage.jsp").forward(req, resp);
    }
}
