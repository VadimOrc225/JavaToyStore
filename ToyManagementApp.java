package JavaToyStore;

public class ToyManagementApp {
    public static void main(String[] args) {
        Toy model = new Toy();
        ToyView view = new ToyView();
        ToyPresenter presenter = new ToyPresenter(model, view);
        presenter.performAction();

    }
}
