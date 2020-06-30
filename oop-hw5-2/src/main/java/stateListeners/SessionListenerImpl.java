package stateListeners;

import models.ShoppingCart;
import utils.ServletUtils;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListenerImpl implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setAttribute(ServletUtils.SHOPPING_CART_KEY, new ShoppingCart());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().removeAttribute(ServletUtils.SHOPPING_CART_KEY);
    }
}
