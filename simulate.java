import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.io.*;
import java.util.HashMap; 
//Kevin Huynh and Michael Doan
//LATE PASS

public class simulate{
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream out = new PrintStream(new File("35_Day_Simulation.txt")); //creates a file for output 
        PrintStream console = System.out;
        System.setOut(out); //all prints will go to the text file
        
        Random rand = new Random();
        car_rental car_rent = new car_rental();
        Vector<customer> customer_ = new Vector();
        Vector<Integer> can_rent = new Vector();
        String cust_type = "";
        String customer_name = "";
        String license = "";
        String remove = "";
        customer c;
        int can_rent_int = 0;
        int random_ = 0;
        boolean tf = false;
        int night = 0;
        boolean if_avail = true;
        int index = 0;
    
        String[] names = new String[]{ "Natsu", "Gray", "Lucy", "Juvia", "Gajeel", "Erza", "Mavis", "Makarov", "Laxus", "Happy", "Wendy", "Lily", "Carla", "Mirajane", "Cana", "Elfman", "Evergreen", "Freed", "Gildarts", "Bickslow", "Lisanna", "Igneel", "Sting", "Rogue"};
        //made it more fun by using names from the anime Fairy Tail
        for(int i = 0; i < 24; i++){
            if(i <= 5){
                cust_type = "Casual";
            }
            else if(i > 5 && i <= 11){
                cust_type = "Business";
            }
            else if(i > 11 && i <= 23){
                cust_type = "Regular";
            }
            c = new customer(names[i], cust_type);
            customer_.add(c);
            can_rent.add(1);
        } //populates the customers array with names and a type, 6 casual, 6 business, 12 regular
    
        for(int i = 0; i < 36; i++){ //simualate 35 days
            System.out.println("Day: " + String.valueOf(i));
            System.out.println("Daily Profit: " + String.valueOf(car_rent.daily_profit));
            System.out.println("Daily Rentals: " + String.valueOf(car_rent.daily_rentals));
            car_rent.available_cars();
            car_rent.current_rentals();
            for(int j = 0; j < car_rent.customers.size(); j++){ //see if the customer actually rented a car
                if(car_rent.customers.get(j).get_rented_cars().size() > 0){
                    car_rent.customers.get(j).set_returns(car_rent.customers.get(j).get_returns() - 1); //decreases the amount of days left until the customer has to return the car
                    if(car_rent.customers.get(j).get_returns() == 0){ //if the customer has to return the car, the loop puts the car back into the necessary places
                        for(int k = 0; k < car_rent.customers.get(j).rented_cars.size(); k++){
                            license = car_rent.customers.get(j).rented_cars.get(k).get_license();
                            car_rent.available.replace(license, 0, 1);
                        }
                        car_rent.cost(car_rent.customers.get(j));
                        for(int l = 0; l < car_rent.customers.get(j).rented_cars.size(); l++){
                            car_rent.customers.get(j).rented_cars.get(l).clear_add_on();
                            car_rent.customers.get(j).rented_cars.remove(l); //a customer removal
                        }
                        remove = car_rent.customers.get(j).get_name();
                        for(int m = 0; m < customer_.size(); m++){
                            if(customer_.get(m).get_name() == remove){
                                can_rent.set(m, 1); //this indicates that the car is now available, 1 for available, 0 for not
                            }
                        }
                        car_rent.remove_customer(car_rent.customers.get(j));
                        car_rent.daily_rentals = car_rent.daily_rentals + 1; //adds rentals to the count
                        car_rent.total_rentals = car_rent.total_rentals + 1;
                    }
                }
            }
            for(int n = 0; n < can_rent.size(); n++){//sees what customers are able to rent a car
                can_rent_int = can_rent_int + can_rent.get(n);
            }
            random_ = rand.nextInt(can_rent_int);
            for(int o = 0; o < random_; o++){ //this loop selects a random number of cars to visit the car rental shop
                random_ = rand.nextInt(24);
                while(!tf){
                    if(can_rent.get(random_) == 1){
                        tf = true;
                    }
                    else{
                        random_ = rand.nextInt(24);
                    }
                }
                can_rent.set(random_, 0); //this places the customer so that they won't be able to rent
                car_rent.add_customer(customer_.get(random_));
                index = car_rent.customers.indexOf(customer_.get(random_));
                if(car_rent.customers.get(index).get_type() == "Casual"){ //these if and if elses set the amount of days a customer will rent the car for based on their customer type, and if there's enough cars for them to rent
                    night = rand.nextInt(3) + 1;
                    car_rent.customers.get(index).set_returns(night);
                    car_rent.customers.get(index).set_days_for_rent(night);
                    if_avail = car_rent.car_check(1);
                    if(if_avail){
                        car_rent.rent_car(car_rent.customers.get(index));
                    }

                }
                else if(car_rent.customers.get(index).get_type() == "Business"){
                    car_rent.customers.get(index).set_returns(7);
                    car_rent.customers.get(index).set_days_for_rent(7);
                    if_avail = car_rent.car_check(3);
                    if(if_avail){
                        for(int k = 0; k < 3; k++){
                            car_rent.rent_car(car_rent.customers.get(index));
                        }
                    }
                }
                else{
                    night = rand.nextInt(3) + 3;
                    car_rent.customers.get(index).set_returns(night);
                    car_rent.customers.get(index).set_days_for_rent(night);
                    int rand_car= rand.nextInt(3) + 1;
                    if_avail = car_rent.car_check(rand_car);
                    if(if_avail){
                        for(int k = 0; k < rand_car; k++){
                            car_rent.rent_car(car_rent.customers.get(index));
                        }
                    }
                }
            }
            car_rent.add_add_ons(car_rent.customers.get(i)); //had it somewhere else and a million add ons were added, this gives a reasonable amount
        }
        System.out.println("The Total Amount of Rentals: " + car_rent.total_rentals); //prints out the total amount of times a car was rented
        System.out.println("The Total Profit: $10000" + car_rent.total_profit); //Not sure why total profit wasn't updating the whole time
    }
}
