package JavaToyStore;


import java.util.Objects;
import java.util.PriorityQueue;


public class Toy implements Comparable<Toy> {
    private String id;
    private String name;
    private Integer quantity;
    private Integer frequency;

    public Toy() {

    }

    public Toy(String id, String name, Integer quantity, Integer frequency) {   //три конструктора
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public Toy(String id, String name) {

        this.name = name;
        this.id = id;
    }

    public Toy(String id, Integer frequency) {

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

    public String getId() {
        return id;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }


    private PriorityQueue<Toy> catalog = new PriorityQueue<Toy>();
    private PriorityQueue<Toy> catalog2 = new PriorityQueue<Toy>();

    public void addition(Toy toy) {    // добавление игрушки в каталог магазина
        catalog.add(toy);

    }

    public Toy game() {       // метод розыгрыша
        Toy PrizeOfTheGame = catalog.poll();
        if (PrizeOfTheGame.getQuantity() > 1) {     // если игрушек с данным id больше одной, то должна выйти одна игрушка,
                                                    // а остальные должны остаться!
            int a = PrizeOfTheGame.getQuantity();
            PrizeOfTheGame.setQuantity(a - 1);
            catalog.add(PrizeOfTheGame);
//            PrizeOfTheGame.setQuantity(1);
        }
        return PrizeOfTheGame;


    }

    public void addition2(Toy toy2) {      // добавление разыгранного приза во второй список
        catalog2.add(toy2);
    }

    public Toy removingPrise() {            // метод выдачи приза
        return catalog2.poll();
    }


    public void removing(Toy toy2) {          //метод изменения частоты у уже занесенной в каталог игрушки (замена)
        for (Toy x : catalog) {
            if (toy2.id.equals(x.id) && toy2.name.equals(x.name)) {
                catalog.remove(x);
                toy2.setQuantity(x.quantity);   // частоту меняем, а количество должно остаться как было
                catalog.add(toy2);

            }

        }


    }

    public boolean greeting(Toy toy) {                //проверка совпадения id и названия (name)

        for (Toy x : catalog) {
            if (toy.id.equals(x.id) && toy.name.equals(x.name)) {
                return true;

            }

        }
        return false;
    }


    public void displayInfo(String id) {      // Информация по игрушке из каталога магазина
        for (Toy x : catalog) {
            if (Objects.equals(id, x.id)) {
                System.out.printf("Название игрушки: %s, Количество: %s, Вероятность появления: %d\n", x.getName(),
                        x.getQuantity(), x.getFrequency());

            }
//            else if (catalog.isEmpty()) {
//                System.out.print("Нет такого id");
//            }
            else {
                System.out.print("Нет такого id\n");
            }

        }
        if (catalog.isEmpty()) {
                System.out.print("Нет такого id \n");
            }
    }



    @Override
    public int compareTo(Toy o) {
        return o.frequency.compareTo(this.frequency);
    }
}