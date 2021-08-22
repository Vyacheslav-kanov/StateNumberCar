import SNC.Compare.ComparatorAddParam;
import SNC.Compare.ComparatorMileage;
import SNC.StateNumberCarList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static StateNumberCarList stateNumberCarList = new StateNumberCarList();

    public static void main(String[] args) {
        continuousInput();
        stateNumberCarList.print();

        stateNumberCarList.sort(ComparatorMileage.ASCENDING);
        System.out.println("Сортировка по пробегу (Возрастание):");
        stateNumberCarList.print();

        stateNumberCarList.sort(ComparatorAddParam.DECREASING);
        System.out.println("Сортировка по пораметру (убываение):");
        stateNumberCarList.print();

        System.out.println("Общая стоимость: " + stateNumberCarList.getPrice());
        System.out.println("минимальная стоимость: " + stateNumberCarList.getDownCost());
        System.out.println("Максимальная стоимость: " + stateNumberCarList.getHighCost());
    }

    public static void continuousInput(){
        System.out.println("Вводите текст: \n Введите 'end' для выхода");
        while (true) {
            String str = "";
            try {
                str = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (str.equals("end")) break;
            stateNumberCarList.add(str);
        }
    }
}
