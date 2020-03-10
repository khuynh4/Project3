import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.io.*;
import java.util.HashMap; 
//Kevin Huynh and Michael Doan
//LATE PASS

public class car_factory{//creates a new car based on the type it is given
    public car what_car(String car_type){
        if(car_type == "Economy"){
            return new economy();
        }
        else if(car_type == "Standard"){
            return new standard();
        }
        else if(car_type == "Luxury"){
            return new luxury();
        }
        else if(car_type == "SUV"){
            return new SUV();
        }
        else if(car_type == "Minivan"){
            return new minivan();
        }
        return null;
    }
}