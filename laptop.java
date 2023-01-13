import java.util.ArrayList;
import java.util.List;

public class laptop {
    private String brand; // бренд
    private String name; // наименование
    private String model; // модель
    private int screen_diagonal; // диагональ экрана
    private String cpu; // процессор
    private int ram; // объем оперативной памяти
    private int hard_disk_capacity; // объем ЖД
    private String operating_system; // ОС
    private String color; // цвет
    private int price; // цена

    public laptop(String brand, String name, String model, int screen_diagonal, String cpu, int ram, int hard_disk_capacity, String operating_system, String color, int price) {
        this.brand = brand;
        this.name = name;
        this.model = model;
        this.screen_diagonal = screen_diagonal;
        this.cpu = cpu;
        this.ram = ram;
        this.hard_disk_capacity = hard_disk_capacity;
        this.operating_system = operating_system;
        this.color = color;
        this.price = price;
    }

    public boolean validateObject(){
        return true;
    }

    public static List<String> propertiesForFilter(){
        List<String> list = new ArrayList<>();
        list.add("brand");
        list.add("name");
        list.add("model");
        list.add("screen_diagonal");
        list.add("cpu");
        list.add("ram");
        list.add("hard_disk_capacity");
        list.add("operating_system");
        list.add("color");
        list.add("price");

        return list;

    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public Integer getScreen_diagonal() {
        return screen_diagonal;
    }

    public String getCpu() {
        return cpu;
    }

    public int getRam() {
        return ram;
    }

    public int getHard_disk_capacity() {
        return hard_disk_capacity;
    }

    public String getOperating_system() {
        return operating_system;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setScreen_diagonal(Integer screen_diagonal) {
        this.screen_diagonal = screen_diagonal;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHard_disk_capacity(int hard_disk_capacity) {
        this.hard_disk_capacity = hard_disk_capacity;
    }

    public void setOperating_system(String operating_system) {
        this.operating_system = operating_system;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ноутбук " + brand + ", " + name + ", " + model + ", " + screen_diagonal
                + "'', " + cpu + ", " + ram + "ГБ, " + hard_disk_capacity + "ГБ, "
                + operating_system + ", " + color + ", " + price + " рублей.";
    }
}
