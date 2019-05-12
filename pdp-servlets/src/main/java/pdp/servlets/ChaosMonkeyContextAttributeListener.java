package pdp.servlets;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ChaosMonkeyContextAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println(String.format("ServletContextAttributeListener - attributeAdded( %s=%s )", event.getName(), event.getValue()));
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println(String.format("ServletContextAttributeListener - attributeRemoved( %s=%s )", event.getName(), event.getValue()));
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println(String.format("ServletContextAttributeListener - attributeReplaced( %s=%s )", event.getName(), event.getValue()));
    }
}
