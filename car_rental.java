import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.io.*;
import java.util.HashMap; 
//Kevin Huynh and Michael Doan
//LATE PASS

public class car_rental extends subject{
    int daily_profit = 0;
    int total_profit = 0;
    int daily_rentals = 0;
    int total_rentals = 0;
    Vector<customer> customers;
    car car_array[] = new car[24];
    HashMap<String, Integer> available = new HashMap<String, Integer>();
    
    public car_rental(){
        this.customers = new Vector();
        car_factory create = new car_factory();
        int num = 100;
        Random rand = new Random(); 
        int random_;
        int lic_num;
        random_ = rand.nextInt(4);
        for(int i = 0; i < 24; i++){//this loop creates a car and sets a license plate. unique license plates will start with what type of car it is in 3 letters and then it will have a random 3 digit number with 100 being the base and a random number between 1-899 will be added to it.
            if(i <= 5){
                random_ = rand.nextInt(899);
                lic_num = num + random_;
                car_array[i] = create.what_car("Economy");
                car_array[i].set_license("ECO" + String.valueOf(lic_num));
                lic_num = 0;
            }
            else if (i > 5 && i <= 10){
                random_ = rand.nextInt(899);
                lic_num = num + random_;
                car_array[i] = create.what_car("Standard");
                car_array[i].set_license("STA" + String.valueOf(lic_num));
                lic_num = 0;
            }
            else if (i > 10 && i <= 15){
                random_ = rand.nextInt(899);
                lic_num = num + random_;
                car_array[i] = create.what_car("Luxury");
                car_array[i].set_license("LUX" + String.valueOf(lic_num));
                lic_num = 0;
            }
            else if (i > 15 && i <= 20){
                random_ = rand.nextInt(899);
                lic_num = num + random_;
                car_array[i] = create.what_car("SUV");
                car_array[i].set_license("SUV" + String.valueOf(lic_num));
                lic_num = 0;
            }
            else if (i > 20 && i <= 24){
                random_ = rand.nextInt(899);
                lic_num = num + random_;
                car_array[i] = create.what_car("SUV");
                car_array[i].set_license("SUV" + String.valueOf(lic_num));
                lic_num = 0;
            }
            //puts the car in the available dictionary for later
            available.put(car_array[i].get_license(), 1);
        }
    }
    
    public void add_customer(customer cus){//adds a customer to the vector
        customers.add(cus);
    }
    public void remove_customer(customer cus){//removes a customer from the vector
        int i = 0;
        i = customers.indexOf(cus);
        customers.remove(i);
    }
    public void notify_customer(customer cus){ //for the observer
        cus.update();
    }
    void available_cars(){//This will print out all available cars
        int avail = 0;
        for(Map.Entry<String, Integer> entry: available.entrySet()){
            avail = avail + entry.getValue();
        }
        System.out.println("There are " + avail + " cars available for rent. Here are your options!");
        for(Map.Entry<String,Integer> entry: available.entrySet()){
            if(entry.getValue() == 1)//if the value of the Hash Map is 1, then the car is available so it will only print those that have a value of 1.
                System.out.println(entry.getKey());
        }
    }
    void current_rentals(){//This iterates through the customers vector and prints the current rentals that the customers have
        System.out.println("The current rentals: ");
        for(int i = 0; i < this.customers.size(); i++){
            System.out.println(this.customers.get(i).get_name());
            for(int j = 0; j < this.customers.get(i).rented_cars.size(); j++){
                System.out.println(this.customers.get(i).rented_cars.get(j).get_license());
            }
        }
    }
    void rent_car(customer c){//this gives a customer a random car and puts the car as unavailable in the available HashMap
        Random rand = new Random();
        int random_ = rand.nextInt(24);
        c.rented_car(this.car_array[random_]);
        car current = car_array[random_];
        for(Map.Entry<String, Integer> entry: available.entrySet()){
            if(entry.getKey() == current.get_license()){
                this.available.put(current.get_license(), 0);
            }
        }
    }
    void add_add_ons(customer c){//this gets a random number so the max you can have is 1 GPS, 1 radio and 4 car seats. Then it sets the add ons for each car based on the for loop and the ran.nextint
        Random rand = new Random();
        int GPS = rand.nextInt(2);
        int radio = rand.nextInt(2);
        int car_seat = rand.nextInt(5);
        
        for(int i = 0; i < c.rented_cars.size(); i++){
            GPS = rand.nextInt(2);
            radio = rand.nextInt(2);
            car_seat = rand.nextInt(5);
            for(int j = 0; j < c.rented_cars.size(); j++){
                if (GPS == 1){
                    GPS x = new GPS(c.rented_cars.get(j));
                    c.rented_cars.get(j).set_add_ons(x.get_add_on());
                }
                if (radio == 1){
                    radio y = new radio(c.rented_cars.get(j));
                    c.rented_cars.get(j).set_add_ons(y.get_add_on());
                }
                if (car_seat != 0){
                    car_seat z = new car_seat(c.rented_cars.get(j));
                    for (int k = 0; k < car_seat; k++){
                        c.rented_cars.get(j).set_add_ons(z.get_add_on());
                    }
                }
            }
        }
    }
    void cost(customer c){//adds up all the prices the customer needs to pay
        notify_customer(c);
        int cost = 0;
        for(int i = 0; i < c.rented_cars.size(); i++){
            cost = cost + c.rented_cars.get(i).get_add_on_p() + (c.rented_cars.get(i).get_cost() * c.returns);
        }
        
        this.daily_profit = this.daily_profit + cost;
        this.total_profit = this.total_profit + cost;
        System.out.println("The total cost for the rental: " + String.valueOf(cost));
    }
    boolean car_check(int x){//checks to see if the car is available
        int i = 0;
        for (Map.Entry<String,Integer> entry : available.entrySet()){
            i = i + entry.getValue();
        }
        if(i >= x){
            return true;
        }
        else{
            System.out.println("GG better luck next time!");
            return false;

        }
    }
}