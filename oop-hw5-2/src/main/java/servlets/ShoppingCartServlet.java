package servlets;

import database.Database;
import models.Product;
import models.ShoppingCart;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShoppingCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("productID");
        Database database = (Database) getServletContext().getAttribute(ServletUtils.DATABASE_KEY);
        ShoppingCart shoppingCart = (ShoppingCart) req.getSession().getAttribute(ServletUtils.SHOPPING_CART_KEY);
        String[] productIds = shoppingCart.getProductIds();
        if (id == null || "".equals(id)) {
            for (String productId : productIds) {
                int count = Integer.parseInt(req.getParameter(productId));
                shoppingCart.putItems(productId, count);
            }
        } else {
            shoppingCart.addItem(database.getProductById(id));
        }

        req.getRequestDispatcher("shoppingCart.jsp").forward(req, resp);

    }
}
