package org.avdo.patterns.factory.webpage;

public class WebsiteFactory {

    public static Website getWebsite(WebsiteType websiteType) {

        if (websiteType == WebsiteType.BLOG) {
            return new Blog();
        } else if (websiteType == WebsiteType.SHOP) {
            return new Shop();
        } else if (websiteType == WebsiteType.SERVICEPROVIDER) {
            return new ServiceProvider();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Website website = WebsiteFactory.getWebsite(WebsiteType.BLOG);
        Website website1 = WebsiteFactory.getWebsite(WebsiteType.SHOP);
        Website website2 = WebsiteFactory.getWebsite(WebsiteType.SERVICEPROVIDER);
    }
}
