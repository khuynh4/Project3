import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.io.*;
import java.util.HashMap; 
//Kevin Huynh and Michael Doan
//LATE PASS

public abstract class car{
    String type = "";
    String add_on = "";
    String license = "";
    int cost = 0;
    int add_on_p = 0;
    //since this is a abstract class, these are declared so the car subclasses can implement these functions in their class
    public abstract String get_type();
    public abstract String get_add_on();
    public abstract String get_license();
    public abstract int get_cost();
    public abstract int get_add_on_p();
    public abstract void set_add_ons(String a);
    public abstract void set_license(String lic);
    public abstract void clear_add_on();
}

class economy extends car{
    public economy(){
        type = "Economy";
        cost = 100;
    }
    
    public String get_type(){
        return this.type;
    }
    public String get_add_on(){
        return this.add_on;
    }
    public String get_license(){
        return this.license;
    }
    public int get_cost(){
        return 100;
    }
    public int get_add_on_p(){
        return this.add_on_p;
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

class standard extends car{
    public standard(){
        type = "Standard";
        cost = 200;
    }
    
    public String get_type(){
        return this.type;
    }
    public String get_add_on(){
        return this.add_on;
    }
    public String get_license(){
        return this.license;
    }
    public int get_cost(){
        return 200;
    }
    public int get_add_on_p(){
        return this.add_on_p;
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

class luxury extends car{
    public luxury(){
        type = "Luxury";
        cost = 500;
    }
    
    public String get_type(){
        return this.type;
    }
    public String get_add_on(){
        return this.add_on;
    }
    public String get_license(){
        return this.license;
    }
    public int get_cost(){
        return 500;
    }
    public int get_add_on_p(){
        return this.add_on_p;
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

class SUV extends car{
    public SUV(){
        type = "SUV";
        cost = 300;
    }
    
    public String get_type(){
        return this.type;
    }
    public String get_add_on(){
        return this.add_on;
    }
    public String get_license(){
        return this.license;
    }
    public int get_cost(){
        return 300;
    }
    public int get_add_on_p(){
        return this.add_on_p;
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

class minivan extends car{
    public minivan(){
        type = "Minivan";
        cost = 400;
    }
    
    public String get_type(){
        return this.type;
    }
    public String get_add_on(){
        return this.add_on;
    }
    public String get_license(){
        return this.license;
    }
    public int get_cost(){
        return 400;
    }
    public int get_add_on_p(){
        return this.add_on_p;
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