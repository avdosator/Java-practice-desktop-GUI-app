package org.avdo.patterns.factory.webpage;

public class Shop implements Website {

    public Shop() {
        System.out.println("You created a new web shop page");
    }
    @Override
    public void createWebsite() {
        pages.add(new ItemPage());
        pages.add(new SearchPage());
    }
}
