package org.avdo.patterns.builder;

public class VendingMachineDemo {

    public static void main(String[] args) {
        VendingMachine.VendingMachineBuilder builder = new VendingMachine.VendingMachineBuilder();
        VendingMachine vendingMachine = builder.addItem("Snickers", 50)
                .addItem("Mars", 50)
                .addItem("Choksa", 40)
                .addItem("Eurovafel", 70)
                .addItem("Coke", 100)
                .addItem("Fanta", 100)
                .addItem("Hell", 80)
                .addItem("Tuborg", 1700)
                .build();

        vendingMachine.insertCoin(100);
        vendingMachine.insertCoin(50);
        vendingMachine.insertCoin(20);

        vendingMachine.selectItem("Hell");
        vendingMachine.selectItem("Tuborg");
    }
}
