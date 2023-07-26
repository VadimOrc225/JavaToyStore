package JavaToyStore;


import java.util.Scanner;
import java.util.function.ToIntFunction;

public class ToyView {
    Scanner iScanner = new Scanner(System.in);
    public char getInputOperator() {
        System.out.println("Что Вы хотите? (Добавить игрушку - введите 1; Изменить частоту выпадания в % или количество -" +
                " введите 2; Показать информацию по игрушке - введите 3; Розыгрыш - 7; Получение выпавшей игрушки - 8  ");
        char op = iScanner.next().charAt(0);
        String s = "12378";
        if (s.indexOf(op) == -1) {            // проверка на ввод правильного знака операции
            System.out.println("Ввод неверный.Повторите ввод");
            getInputOperator();
        }
        return op;
    }

    public Integer getInputId() {
        System.out.println("Введите id игрушки");
        Integer id = Integer.parseInt(iScanner.next());
        return id;
    }
    public String getInputName() {
        System.out.println("Введите название игрушки");
        String name = iScanner.next();
        return name;
    }
    public Integer getInputQuantity() {
        System.out.println("Введите количество добавляемых игрушек с данным id");
        Integer quantity = Integer.parseInt(iScanner.next());
        return quantity;
    }
    public Integer getInputFrequency() {
        System.out.println("Введите частоту выпадения данной призовой игрушки");
        Integer frequency = Integer.parseInt(iScanner.next());
        return frequency;
    }

    public char getInputAction() {
        System.out.println("Что Вы хотите? (Изменить количество игрушек - введите 1; Изменить частоту выпадения - введите 2;" +
                " Выход - 9");
        char op2 = iScanner.next().charAt(0);
        String s = "129";
        if (s.indexOf(op2) == -1) {            // проверка на ввод правильного знака операции
            System.out.println("Ввод неверный.Повторите ввод");
            getInputAction();
        }
        return op2;
    }
    public Integer getInputNewQuantity() {
        System.out.println("Введите новое количество");
        Integer newQuantity = Integer.parseInt(iScanner.next());
        return newQuantity;
    }
    public Integer getInputNewFrequency() {
        System.out.println("Введите новую частоту выпадения данной призовой игрушки");
        Integer newFrequency = Integer.parseInt(iScanner.next());
        return newFrequency;
    }
    public void noWord(){
        System.out.println("Такой игрушки не существует. Повторите ввод. 9 - выход в предыдущее меню");
    }


}
