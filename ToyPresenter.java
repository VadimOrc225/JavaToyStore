package JavaToyStore;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ToyPresenter {
    private Toy model;
    private ToyView view;

    public ToyPresenter(Toy model, ToyView view) {
        this.model = model;
        this.view = view;
    }


    public void performAction() {
        char operator = view.getInputOperator();
        switch (operator) {
            case '1':
                String id = view.getInputId();
                String name = view.getInputName();
                Integer quantity = view.getInputQuantity();
                Integer frequency = view.getInputFrequency();
                Toy toy = new Toy(id, name, quantity, frequency);
                model.addition(toy);

                break;
            case '2':
                id = view.getInputId();
                name = view.getInputName();
                Toy toy2 = new Toy(id, name);
                if (model.greeting(toy2)) {
                    char operatorAction = view.getInputAction();
                    switch (operatorAction) {
                        case '1':
                            quantity = view.getInputNewQuantity();
                            model.setQuantity(quantity);
                            break;
                        case '2':
                            frequency = view.getInputNewFrequency();
                            toy2.setFrequency(frequency);
                            model.removing(toy2);     // замена игрушки в каталоге на игрушку с новой частотой
                            break;

                        case '9':
                            performAction();

                    }
                } else {
                    view.noWord();
                    view.getInputAction();
                }
                break;
            case '3':
                id = view.getInputId();
                model.displayInfo(id);
                break;
            case '7':
                Toy a = model.game();
                model.addition2(a);
                System.out.println(a);

                break;
            case '8':
                String fileName = "JavaToyStore/result.txt";
                File file = new File(fileName);
                FileWriter writer;

            {
                try {
                    writer = new FileWriter(file, true);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Toy prize = model.removingPrise();


                try {
                    try {
                        String val = prize.getId();
                        writer.write(String.valueOf(val));
                    } catch (NullPointerException e) {
                        throw new RuntimeException(e);

                    }


                    writer.write(" ");
                    try {
                        String val = prize.getName();
                        writer.write(String.valueOf(val));
                    } catch (NullPointerException e) {
                        throw new RuntimeException(e);

                    }
                    writer.write("\n");

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


                try {
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            break;
        }
        performAction();
    }


}