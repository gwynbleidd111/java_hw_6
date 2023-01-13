
import java.util.*;

public class filter {

    private Set<laptop> notebooks = new HashSet<>();
    private List<Criterion> criterionList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);


    public void printList(){
        for (laptop notebook : notebooks){
            if (notebookIsCorrect(notebook)){
                System.out.println(notebook);
            }
        }
    }

    public boolean notebookIsCorrect(laptop notebook){

        for (Criterion criterion : criterionList){
            Object valueNotebook = null;

            if (criterion.property.equals("brand")){
                valueNotebook = notebook.getBrand();
            }else if (criterion.property.equals("name")){
                valueNotebook = notebook.getName();
            }else if (criterion.property.equals("model")){
                valueNotebook = notebook.getModel();
            }else if (criterion.property.equals("screen_diagonal")){
                valueNotebook = notebook.getScreen_diagonal();
            }else if (criterion.property.equals("cpu")){
                valueNotebook = notebook.getCpu();
            }else if (criterion.property.equals("ram")){
                valueNotebook = notebook.getRam();
            }else if (criterion.property.equals("hard_disk_capacity")){
                valueNotebook = notebook.getHard_disk_capacity();
            }else if (criterion.property.equals("operating_system")){
                valueNotebook = notebook.getOperating_system();
            }else if (criterion.property.equals("color")){
                valueNotebook = notebook.getColor();
            }else if (criterion.property.equals("price")){
                valueNotebook = notebook.getPrice();
            }else {
                continue;
            }

            if (criterion.value != null && !criterion.value.equals(valueNotebook)){
                return false;
            }

            if (criterion.maxValue != null && criterion.maxValue < Double.parseDouble(Objects.toString(valueNotebook))){
                return false;
            }

            if (criterion.minValue != null && criterion.minValue > Double.parseDouble(Objects.toString(valueNotebook))){
                return false;
            }
        }

        return true;
    }
    public filter(Set<laptop> notebooks) {
        this.scanner = new Scanner(System.in);
        this.notebooks = notebooks;
    }

    public filter(Set<laptop> notebooks, List<Criterion> criterionList) {
        this.scanner = new Scanner(System.in);
        this.notebooks = notebooks;
        this.criterionList = criterionList;
    }

    public int getCriteria(){
        String text = "Введите цифру, соответствующую необходимому критерию: ";

        List<String> properties = propertiesForFilter();

        for (int i = 0; i < properties.size(); i++)
        {
            text += "\n" + (i + 1) + ". " + getPropertyDescription(properties.get(i));
        }

        System.out.println(text);

        int value = scanner.nextInt();

        return value;
    }

    public String getPropertyDescription(String property){

        Map<String, String> descriptionsProperties = descriptionsProperties();

        return descriptionsProperties.get(property);

    }

    public Map<String, String> descriptionsProperties(){
        Map<String, String> map = new HashMap<>();

        map.put("brand", "Бренд");
        map.put("name", "Наименование");
        map.put("model", "Модель");
        map.put("screen_diagonal", "Диагональ экрана");
        map.put("cpu", "Процессор");
        map.put("ram", "Объем оперативной памяти");
        map.put("hard_disk_capacity", "Объем ЖД");
        map.put("operating_system", "Операционная система");
        map.put("color", "Цвет");
        map.put("price", "Цена");

        return map;

    }

    public List<String> propertiesForFilter(){
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

    public String getOperations(){

        String text = "Выберите опрерацию: \n " +
                "1. Добавить фильтр. \n " +
                "2. Вывести список. \n " +
                "3. Завершить.";

        System.out.println(text);

        String answer = scanner.next();

        return answer;
    }

    public Set<String> quantitativeSelection(){
        Set<String> set = new HashSet<>();
        set.add("screen_diagonal");
        set.add("ram");
        set.add("hard_disk_capacity");
        set.add("price");

        return set;
    }

    public Set<String> stringSelection(){
        Set<String> set = new HashSet<>();

        set.add("brand");
        set.add("name");
        set.add("model");
        set.add("cpu");
        set.add("operating_system");
        set.add("color");

        return set;
    }

    public void start(){

        boolean flag = true;
        while (flag){

            String operation = getOperations();
            if (operation.equals("3")){
                flag = false;
                scanner.close();
                continue;
            }else if(operation.equals("1")){

                int criterion = getCriteria();
                List<String> properties = propertiesForFilter();
                if (criterion - 1 < 0 || criterion - 1 > properties.size() - 1){
                    System.out.println("Введено некорректное значение.");
                    continue;
                }
                String property = properties.get(criterion - 1);
                Criterion criterionObject = null;
                try {
                    if (quantitativeSelection().contains(property)){
                        criterionObject = Criterion.startGetting(scanner, property, true);
                    }else {
                        criterionObject = Criterion.startGetting(scanner, property, false);
                    }
                }catch (Exception e){
                    System.out.println("Ошибка при выборе критерия.");
                    continue;
                }
                if (criterionObject != null){
                    System.out.println("Критерий добавлен.");
                    criterionList.add(criterionObject);
                }
            }
            else if (operation.equals("2")){
                printList();
            }
        }
    }
}


class Criterion {

    Object value;
    Double minValue;
    Double maxValue;
    boolean isQuantitative;
    String property;

    public Criterion(String property, boolean isQuantitative, Object value, Double minValue, Double maxValue) {
        this.property = property;
        this.isQuantitative = isQuantitative;
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public static Criterion startGetting(Scanner scanner, String property, boolean isQuantitative) {

        if (isQuantitative) {

            String quest = "Выберите тип криетрия: " +
                    "\n 1. Значение." +  
                    "\n 2. Интервал.";
            System.out.println(quest);

            String text = scanner.next();

            Criterion criterion = null;

            if (text.equals("1")) {
                System.out.println("Введите значение поиска: ");
                int getValue = scanner.nextInt();
                criterion = new Criterion(property, isQuantitative, getValue, null, null);
            } else if (text.equals("2")) {
                System.out.println("Введите минимальное значение: ");
                double getMin = scanner.nextDouble();
                System.out.println("Введите максимальное значение: ");
                double getMax = scanner.nextDouble();
                criterion = new Criterion(property, isQuantitative, null, getMin, getMax);
            }

            return criterion;
        }

        System.out.println("Введите значение поиска: ");
        String getValue = scanner.next();
        return new Criterion(property, isQuantitative, getValue, null, null);
}

}
