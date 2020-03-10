import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.io.*;
import java.util.HashMap; 
//Kevin Huynh and Michael Doan
//LATE PASS

public abstract class car_decorator extends car{//adds add ons at run time
    public abstract String get_add_on();
    public abstract int get_add_on_p();
}
class car_seat extends car_decorator{
    car c;
    public car_seat(car c){
        this.c = c;
    }
    public String get_add_on(){
        return c.get_add_on() + "Car Seat - $10, ";
    }
    public int get_add_on_p(){
       return c.get_add_on_p() + 10;
    }
    public String get_type(){
        return this.type;
    }
    public String get_license(){
        return this.license;
    }
    public int get_cost(){
        return this.cost;
    }
    public void set_add_ons(String a){
        this.add_on = a;
    }
    public void set_license(String lic){
        this.license = lic;
    }
    public void clear_add_on(){
        this.add_on = "";
    }
}

class GPS extends car_decorator{
    car c;
    public GPS(car c){
        this.c = c;
    }
    public String get_add_on(){
        return c.get_add_on() + "GPS - $15, ";
    }
    public int get_add_on_p(){
        return c.get_add_on_p() + 10;
    }   
    public String get_type(){
        return this.type;
    }
    public String get_license(){
        return this.license;
    }
    public int get_cost(){
        return this.cost;
    }
    public void set_add_ons(String a){
        this.add_on = a;
    }
    public void set_license(String lic){
        this.license = lic;
    }
    public void clear_add_on(){
        this.add_on = "";
    }
}

class radio extends car_decorator{
    car c;
    public radio(car c){
        this.c = c;
    }
    public String get_add_on(){
        return c.get_add_on() + "Radio - $10, ";
    }
    public int get_add_on_p(){
        return c.get_add_on_p() + 10;
    }   
    public String get_type(){
        return this.type;
    }
    public String get_license(){
        return this.license;
    }
    public int get_cost(){
        return this.cost;
    }
    public void set_add_ons(String a){
        this.add_on = a;
    }
    public void set_license(String lic){
        this.license = lic;
    }
    public void clear_add_on(){
        this.add_on = "";
    }
}
