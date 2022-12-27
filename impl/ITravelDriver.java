package impl;

import interfacec.TravelDriver;
import objectss.Storage;
import objectss.Travel;
import objectss.User;

public class ITravelDriver implements TravelDriver {
    private static TravelDriver travelDriver;
    public static TravelDriver getTravelDriver(){
        if(travelDriver == null){
            travelDriver = new ITravelDriver();
        }
        return travelDriver;
    }
    @Override
    public ITravelDriver driverr(Travel travel) {
        System.out.println("Travel list: ");
        Storage.travelList.forEach(System.out::println);
        return getTravelDriver().driverr(travel);
    }
}
