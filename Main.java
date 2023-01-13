import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<laptop> set = new HashSet<>();
        set.add(new laptop("HUAWEI", "HUAWEI MateBook 14 KLVL-W56W", "KLVL-W56W", 14, "AMD Ryzen 5 5500U", 16, 512,"Windows 11 Home", "серый", 65990));
        set.add(new laptop("MSI", "MSI GF63 Thin 11UD-206XRU", "GF63 Thin 11UD-206XRU", 15, "Intel Core i5 11400H", 16, 512,"Free DOS", "черный ", 79890));
        set.add(new laptop("HONOR", "HONOR MagicBook 15", "MagicBook 15", 15, "AMD Ryzen 5 5500U", 8, 512,"без операционной системы", "серый", 39990));
        set.add(new laptop("LENOVO", "Lenovo Legion S7 15ACH6", "15ACH6", 15, "AMD Ryzen 7 5800H", 32, 1024,"без операционной системы", "черный", 132890));
        set.add(new laptop("HP", "HP ZBook Fury 15 G8", "Fury 15 G8", 15, "Intel Core i7 11800H", 32, 1024,"Linux", "серый", 225910));
        filter operation = new filter(set);
        operation.start();

    }
}
