package SNC;

import java.util.*;

public class StateNumberCar{
    private String codeCar;
    private int stateNum;
    private int mileage;
    private int addParam;

    public StateNumberCar(String codeCar, int stateNum, int mileage, int addParam) {
        this.codeCar = codeCar;
        this.stateNum = stateNum;
        this.mileage = mileage;
        this.addParam = addParam;
    }

    public StateNumberCar(String codeCar, int stateNum, int mileage) {
        this.codeCar = codeCar;
        this.stateNum = stateNum;
        this.mileage = mileage;
    }

    public String getCodeCar() {
        return codeCar;
    }

    public void setCodeCar(String codeCar) {
        this.codeCar = codeCar;
    }

    public int getStateNum() {
        return stateNum;
    }

    public void setStateNum(int stateNum) {
        this.stateNum = stateNum;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getAddParam() {
        return addParam;
    }

    public void setAddParam(int addParam) {
        this.addParam = addParam;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateNumberCar that = (StateNumberCar) o;
        return stateNum == that.stateNum && mileage == that.mileage && addParam == that.addParam && Objects.equals(codeCar, that.codeCar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeCar, stateNum, mileage, addParam);
    }

    @Override
    public String toString() {
        return codeCar + "-" + stateNum + "-" + mileage + (addParam != 0 ? ("-" + addParam):"");
    }

    public static StateNumberCar convert(String fullCode) throws Exception{ //Конвертирует String в объект класса StateNumberCar
        String[] elemSNC = fullCode.split( "_"); //Отделяю String от int переменных
        String stateNum = elemSNC[0];

        String[] splitNumParam = elemSNC[1].split( "-");

        int parseStateNum = Integer.parseInt(splitNumParam[0]);
        int parseMileage = Integer.parseInt(splitNumParam[1]);

        if(splitNumParam[2] != null) { //Проверяем на доп параметр
            int parseAddParam = Integer.parseInt(splitNumParam[2]);
            return new StateNumberCar(stateNum, parseStateNum, parseMileage, parseAddParam);
        }
        else return new StateNumberCar(stateNum, parseStateNum, parseMileage);
    }

    public int getIntCodeCar(){ //Возвращает код транспорта типа int
        String code = this.codeCar.substring(1);
        return Integer.parseInt(code);
    }

    public double getFuelStability(){ //Возвращает стоимоть топлива за литр
        switch (getIntCodeCar()){
            case 100: return 46.10;
            case 200: return 48.90;
            case 300: return 47.50;
            case 400: return 48.90;
        }
        return 0;
    }

    public double getFuelConsumption(){ //Возвращает расход на 100 км
        switch (getIntCodeCar()){
            case 100: return 12.5;
            case 200: return 12;
            case 300: return 11.5;
            case 400: return 20;
        }
        return 0;
    }

    public double getCostCar(){ //Возвращает стоимость топлива на 100 км
        return getFuelConsumption() * getFuelStability();
    }

    public static boolean isValid(String str){//Проверяет коректность формата строки
        if (str.equals(null)) return false;
        try {
            convert(str);
        } catch (Exception e) { return false;}
        return true;
    }
}
