package org.agoncal.fascicle.quarkus.puttingtogether.load;

public class CDBookStoreLoad {

    public static void main(String[] args) {
        Thread heroScenario = new Thread(new CatalogScenario());
        heroScenario.start();
        Thread villainScenario = new Thread(new InventoryScenario());
        villainScenario.start();
        Thread fightScenario = new Thread(new NumberScenario());
        fightScenario.start();
    }
}
