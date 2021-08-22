package SNC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StateNumberCarList implements Comparator<StateNumberCar>{

    private List<StateNumberCar> list;

    public StateNumberCarList() {
        this.list = new ArrayList<>();
    }

    public void add(String str){
        if(StateNumberCar.isValid(str)) {
            try{
                list.add(StateNumberCar.convert(str));
            }catch (Exception e){e.printStackTrace();}
        }
    }

    public void add(StateNumberCar obj){
        list.add(obj);
    }

    public StateNumberCar get(int index){
        return this.list.get(index);
    }

    public double getPrice(){ //Возвращает общую стоимость расходов
        double result = 0;
        for(StateNumberCar e: this.list){
           result += e.getCostCar();
        }
        return result;
    }

    public double getPrice(String codeCar){
        double result = 0;
        for(StateNumberCar e: this.list){
            if(e.getCodeCar().equals(codeCar))
            result += e.getCostCar();
        }
        return result;
    }

    public double getPrice(int codeCar){
        double result = 0;
        for(StateNumberCar e: this.list){
            if(e.getIntCodeCar() == codeCar)
            result += e.getCostCar();
        }
        return result;
    }

    public double getHighCost(){ //Наибольшая стоимость
        double maxCostCar = 0;
        for(StateNumberCar e: this.list){
            if(e.getCostCar() > maxCostCar) maxCostCar = e.getCostCar();
        }
        return maxCostCar;
    }

    public double getDownCost(){ //Наименьшая стоимость
        double minCostCar = 0;
        for(StateNumberCar e: this.list){
            if(e.getCostCar() > minCostCar) minCostCar = e.getCostCar();
        }
        return minCostCar;
    }

    public void sort(Comparator comp){
        Collections.sort(this.list, comp);
    }

    public void sort(){
        Collections.sort(this.list, new StateNumberCarList());
    }

    public void print(){
        for (StateNumberCar e: this.list){
            System.out.println(e.toString());
        }
    }

    @Override
    public int compare(StateNumberCar one, StateNumberCar two) {
        if(one.getCostCar() > two.getCostCar()) return 1;
        if(one.getCostCar() < two.getCostCar()) return -1;
        return 0;
    }
}
