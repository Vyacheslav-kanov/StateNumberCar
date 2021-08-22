package SNC.Compare;

import SNC.StateNumberCar;

import java.util.Comparator;

public enum ComparatorAddParam implements Comparator<StateNumberCar> {

    ASCENDING {
        @Override
        public int compare(StateNumberCar one, StateNumberCar two) {
            if(one.getAddParam() > two.getAddParam()) return 1;
            if(one.getAddParam() < two.getAddParam()) return -1;
            return 0;
        }
    },
    DECREASING{
        @Override
        public int compare(StateNumberCar one, StateNumberCar two) {
            if(one.getAddParam() < two.getAddParam()) return 1;
            if(one.getAddParam() > two.getAddParam()) return -1;
            return 0;
        }
    };

}
