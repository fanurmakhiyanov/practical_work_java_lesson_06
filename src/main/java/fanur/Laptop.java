package fanur;

import java.util.*;

public class Laptop {

    private int price;
    private int ram;
    private int hardDrive;
    private int diagonalScreen;

    private static final TreeSet<Laptop> modelsSet = new TreeSet<>(new Comparator<Laptop>() {
        @Override
        public int compare(Laptop o1, Laptop o2) {
            return (o1.ram - o2.ram) - (o1.price - o2.price) -
                    (o1.hardDrive - o2.hardDrive) - (o1.diagonalScreen - o2.diagonalScreen);
        }
    });

    private Laptop(int price, int ram, int hardDrive, int diagonalScreen) {
        this.price = price;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.diagonalScreen = diagonalScreen;
    }

    public Laptop() {
    }

    public void addModelLaptop(int price, int ram, int hardDrive, int diagonalScreen) {
        Laptop newModel = new Laptop(price,ram, hardDrive, diagonalScreen);
        modelsSet.add(newModel);
    }

    @Override
    public String toString() {
        return "\nЦена = " + price + " $" +
                " / Объем оперативной памяти = " + ram + " Гб" +
                " / Объем жесткого диска = " + hardDrive + " Гб" +
                " / Диагональ экрана = " + diagonalScreen + " дюймов";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop that = (Laptop) o;
        return price == that.price &&
                ram == that.ram &&
                hardDrive == that.hardDrive &&
                diagonalScreen == that.diagonalScreen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, ram, hardDrive, diagonalScreen);
    }

    public String searchModels() {
        System.out.println("Укажите минимальные характеристики ноутбука:");
        HashMap<Integer, Integer> minMod = getSpecifications();
        System.out.println("Укажите максимальные характеристики ноутбука:");
        HashMap<Integer, Integer> maxMod = getSpecifications();

        List<Laptop> resultList = new ArrayList<>();
        for (var model : modelsSet) {
            if ((model.price >= minMod.get(1) && model.price <= maxMod.get(1)) &&
                    (model.ram >= minMod.get(2) && model.ram <= maxMod.get(2)) &&
                    (model.hardDrive >= minMod.get(3) && model.hardDrive <= maxMod.get(3)) &&
                    (model.diagonalScreen >= minMod.get(4) && model.diagonalScreen <= maxMod.get(4))){
                resultList.add(model);
            }
        }
        if (resultList.size() > 0)
            return resultList.toString();
        else return "По вашему запросу ничего не найдено. Попробуйте задать иные параметры";
    }

    private static HashMap<Integer, Integer> getSpecifications() {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        System.out.println("Задайте цену в $: ");
        resultMap.put(i++, scanner.nextInt());
        System.out.println("Задайте объем оперативной памяти RAM в Гб: ");
        resultMap.put(i++, scanner.nextInt());
        System.out.println("Задайте объем жесткого диска SDD в Гб: ");
        resultMap.put(i++, scanner.nextInt());
        System.out.println("Задайте диагональ экрана в дюймах: ");
        resultMap.put(i, scanner.nextInt());
        return resultMap;
    }

}
