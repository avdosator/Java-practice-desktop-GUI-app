package org.avdo.patterns.factory.webpage;

public class ServiceProvider implements Website {

    public ServiceProvider() {
        System.out.println("You created a new service provider page");
    }
    @Override
    public void createWebsite() {
        pages.add(new InfoPage());
        pages.add(new ItemPage());
    }
}
