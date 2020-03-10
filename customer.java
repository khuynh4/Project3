import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.io.*;
import java.util.HashMap; 
//Kevin Huynh and Michael Doan
//LATE PASS

class customer extends observer{
    String name;
    String type;
    int returns;
    int days_for_rent;
    Vector<car> rented_cars;
    
    public customer(String name, String type){
        this.name = name;
        this.type = type;
        this.rented_cars = new Vector();
    }
    void set_name(String n){
        this.name = n;
    }
    String get_name(){
        return this.name;
    }
    void set_type(String n){
        this.type = n;
    }
    String get_type(){
        return this.type;
    }
    void set_returns(int n){
        this.returns = n;
    }
    int get_returns(){
        return this.returns;
    }
    void set_days_for_rent(int n){
        this.days_for_rent = n;
    }
    int get_days_for_rent(){
        return this.days_for_rent;
    }
    Vector get_rented_cars(){
        return rented_cars;
    }
    void rented_car(car c){
        rented_cars.add(c);
    }
    void update(){//This will update as needed and print out the current state that the customer is in with their rental
        System.out.println("Customer: " + this.name);
        System.out.println("Total Days Rented: " + String.valueOf(days_for_rent));
        for(int i = 0; i < rented_cars.size(); i++){
            System.out.println("License Plate: " + rented_cars.get(i).get_license());
            System.out.println("Car Add Ons: " + rented_cars.get(i).get_add_on());
        }
    }
}