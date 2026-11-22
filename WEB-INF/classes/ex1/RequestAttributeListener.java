package ex1;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class RequestAttributeListener implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {
        System.out.println("[RequestAttribute] AJOUT : " + event.getName() + " = " + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {
        System.out.println("[RequestAttribute] REMPLACE : " + event.getName() + " = " + event.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {
        System.out.println("[RequestAttribute] SUPPRIME : " + event.getName());
    }
}