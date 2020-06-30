package servlet;

import manager.AccountManager;
import models.User;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateUserServlet extends HttpServlet {

    private static final String DEFAULT_CREATE_TITLE = "Create Account";
    private static final String DEFAULT_CREATE_H1 = "Create New Account";
    private static final String DEFAULT_CREATE_ADDITIONAL_MESSAGE = "Please Enter Proposed name and password";

    private static final String INVALID_CREATE_ADDITIONAL_MESSAGE = "Please Enter Different name";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.setAtributes(req, DEFAULT_CREATE_TITLE, DEFAULT_CREATE_H1, DEFAULT_CREATE_ADDITIONAL_MESSAGE);
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter(ServletUtils.NAME_PARAMETER_KEY);
        String password = req.getParameter(ServletUtils.PASSWORD_PARAMETER_KEY);

        AccountManager accountManager = (AccountManager) getServletContext().getAttribute(ServletUtils.ACCOUNT_MANAGER_kEY);
        if (accountManager.userNameExists(name)) {
            ServletUtils.setAtributes(req, DEFAULT_CREATE_TITLE, "The Name " + name + " is Already in use", INVALID_CREATE_ADDITIONAL_MESSAGE);
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        } else {
            User user = new User(name, password);
            accountManager.createUser(user);
            req.setAttribute(ServletUtils.GREETINGS_KEY, "Welcome " + name);
            req.getRequestDispatcher("welcome.jsp").forward(req, resp);
        }
    }
}
