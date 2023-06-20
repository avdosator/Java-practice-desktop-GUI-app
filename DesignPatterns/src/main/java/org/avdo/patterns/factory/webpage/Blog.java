package org.avdo.patterns.factory.webpage;

public class Blog implements Website {

    public Blog() {
        System.out.println("You created a new blog page");
    }
    @Override
    public void createWebsite() {
        pages.add(new CommentPage());
        pages.add(new InfoPage());
    }
}
