package JavaToyStore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;


public class Toy implements Comparable{
    private Integer id;
    private String name;
    private Integer quantity;
    private Integer frequency;

    public Toy() {

    }

    public Toy(Integer id, String name, Integer quantity, Integer frequency) {   //три конструктора
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public Toy(Integer id, String name) {

        this.name = name;
        this.id = id;
    }
    public Toy(Integer id, Integer frequency) {

        this.id = id;
        this.frequency = frequency;
    }

    public Toy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getFrequency() {
        return frequency;
    }
    public Integer getId() {
        return id;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }



    private PriorityQueue<Toy> catalog = new PriorityQueue<Toy>();
    private LinkedList<Toy> catalog2 = new LinkedList<>();

    public void addition(Toy toy) {
        catalog.add(toy);

    }
    public Toy game() {

        return catalog.poll();

    }
    public void addition2(Toy toy2) {      // добавление развгранного приза во второй список
        catalog2.add(toy2);
    }

    public Toy removingPrise() {            // метод выдачи приза
        return catalog2.pop();
    }


    public void removing(Toy toy2) {          //метод изменения частоты у уже занесенной в каталог игрушки (замена)
        for (Toy x : catalog) {
            if (toy2.id.equals(x.id) && toy2.name.equals(x.name)) {
                catalog.remove(x);
                toy2.setQuantity(x.quantity);
                catalog.add(toy2);

            }

        }


    }

    public boolean greeting(Toy toy) {

        for (Toy x : catalog) {
            if (toy.id.equals(x.id) && toy.name.equals(x.name)) {
                return true;

            }

        }
        return false;
    }


    public void displayInfo(Integer id) {
        for (Toy x : catalog) {
            if (Objects.equals(id, x.id)) {
                System.out.printf("Название игрушки: %s, Количество: %s, Вероятность появления: %d\n", x.getName(),
                        x.getQuantity(), x.getFrequency());

            }
            else {System.out.print("Нет такого id");}

        }

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}