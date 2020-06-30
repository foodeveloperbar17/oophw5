package servlet;

import manager.AccountManager;
import models.User;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private static final String DEFAULT_WELCOME_TITLE = "Welcome";
    private static final String DEFAULT_WELCOME_H1 = "Welcome to Homework 5";
    private static final String DEFAULT_WELCOME_ADDITIONAL_MESSAGE = "Please log in.";

    private static final String INVALID_CREDENTIALS_TITLE = "Information Incorrect";
    private static final String INVALID_CREDENTIALS_H1 = "Please Try Again";
    private static final String INVALID_CREDENTIALS_ADDITIONAL_MESSAGE = "Either your user name or password is incorrect. Please try again;";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.setAtributes(req, DEFAULT_WELCOME_TITLE, DEFAULT_WELCOME_H1, DEFAULT_WELCOME_ADDITIONAL_MESSAGE);

        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter(ServletUtils.NAME_PARAMETER_KEY);
        String password = req.getParameter(ServletUtils.PASSWORD_PARAMETER_KEY);
        User user = new User(name, password);

        AccountManager accountManager = (AccountManager) getServletContext().getAttribute(ServletUtils.ACCOUNT_MANAGER_kEY);
        if (accountManager.validCredentials(user)) {
            req.setAttribute(ServletUtils.GREETINGS_KEY, "Welcome " + name);
            req.getRequestDispatcher("welcome.jsp").forward(req, resp);
        } else {
            ServletUtils.setAtributes(req, INVALID_CREDENTIALS_TITLE, INVALID_CREDENTIALS_H1, INVALID_CREDENTIALS_ADDITIONAL_MESSAGE);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
