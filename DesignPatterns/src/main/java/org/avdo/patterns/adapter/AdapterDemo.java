package org.avdo.patterns.adapter;

public class AdapterDemo {

    public static void main(String[] args) {
        Person person1 = new Person("Avdo", "Sator", "avd@menjo.kaso", "225-883");
        Person person2 = new Person("Vedo", "Mulich", "dove.njo@manjo", "123-321");
        System.out.println(person1);
        System.out.println(person2);

        Contact contact = new ContactAdapter(person1);
        Contact contact1 = new ContactAdapter(person2);
        System.out.println(contact1);
        System.out.println(contact);
    }
}
