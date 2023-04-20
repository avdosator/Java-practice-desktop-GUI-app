package org.avdo.patterns.builder;

public class Pizza {

    private final boolean tomato;
    private final boolean cheese;
    private final boolean ham;
    private final boolean mushrooms;
    private final boolean olives;
    private final boolean salami;

    private Pizza(PizzaBuilder pizzaBuilder) {
        this.tomato = pizzaBuilder.tomato;
        this.cheese = pizzaBuilder.cheese;
        this.ham = pizzaBuilder.ham;
        this.mushrooms = pizzaBuilder.mushrooms;
        this.olives = pizzaBuilder.olives;
        this.salami = pizzaBuilder.salami;
    }


    public static class PizzaBuilder {
        private boolean tomato;
        private boolean cheese;
        private boolean ham;
        private boolean mushrooms;
        private boolean olives;
        private boolean salami;

        public PizzaBuilder addTomato(boolean tomato) {
            this.tomato = tomato;
            return this;
        }

        public PizzaBuilder addCheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public PizzaBuilder addHam(boolean ham) {
            this.ham = ham;
            return this;
        }

        public PizzaBuilder addMushrooms(boolean mushrooms) {
            this.mushrooms = mushrooms;
            return this;
        }

        public PizzaBuilder addOlives(boolean olives) {
            this.olives = olives;
            return this;
        }

        public PizzaBuilder addSalami(boolean salami) {
            this.salami = salami;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
