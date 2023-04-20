package org.avdo.patterns.factory.webpage;

import java.util.ArrayList;
import java.util.List;

public interface Website {

    List<Page> pages = new ArrayList<>();
    void createWebsite();
}
