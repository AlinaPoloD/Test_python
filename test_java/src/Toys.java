public class Toys {



    private int id;
    private String name;
    private static int counter = 0;
    private double frequency; //частота выпадения
    private int quantity; //количество игрушек

    public Toys(String name, int quantity, double frequency ) {
        id = ++counter;
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }



    public String getName() {
        return name;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }


    public double getFrequency() {
        return frequency;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "Toys{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", frequency=" + frequency +
                ", quantity=" + quantity +
                '}';
    }
}
