import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//AA1711
//user name is "admin"
//Password is "admin123"
public class Main {

    public static void main(String[] args) {
        //username admin
        //password admin123
        try {
            Scanner sc = new Scanner(System.in); // get scanner to read input from user
            HashMap<String,Supplier> supArray =new HashMap<>(); // save data of supplier object according to name
            HashMap<String,Organization>  orgArray = new HashMap<>();// save data of organization object according to name
            HashMap<String,Tender> tenderArray =new HashMap<>();// save dat of Tender object according to category
            System.out.println("\tWelcome ABC Company\n\n");
            System.out.print("enter user name :");
            String username = sc.next();//user name is "admin"
            System.out.print("enter Password :");
            String password = sc.next();//Password is "admin123"
            if (username.matches("admin") && password.matches("admin123")) {
                System.out.println("Log in SuccessFull!!!\n\n");
                while(true) {
                    System.out.println("1.create Organization");//give user interface.
                    System.out.println("2.create Supplier");
                    System.out.println("3.Call a Tender");
                    System.out.println("4.Offer a Bid");
                    System.out.println("5.Close the Tender");
                    System.out.println("any number to quit\n");
                    System.out.println("Enter the number");
                    int number = sc.nextInt();// scan the menu number.
                    if (number == 1) {//do the   Register new Organization.
                        try { // Surround with the try catch block to avoid the exception,but I don't have much time to make the programme unbreakable.
                            System.out.print("Enter the name of the Organization :");
                            String name = sc.next();
                            System.out.print("Enter the Category of the Organization :");
                            String category = sc.next();
                            //Organization organization = new Organization(name,category);

                            orgArray.put(name, new Organization(name, category));
                        }catch (Exception e){
                            System.out.println("Error occurred");
                        }


                    } else if (number == 2) { //do the Register new supplier
                        try {
                            System.out.print("Enter the name of the Supplier :");
                            String name = sc.next();
                            System.out.print("Enter the category of the Supplier :");
                            String category = sc.next();
                            //Supplier supplier = new Supplier(name,category);

                            supArray.put(name, new Supplier(name, category));
                        }catch (Exception e){
                            System.out.println("Error occurred");
                        }
                    }else if (number == 3){ // do the  Open (Call) a tender.
                        try {
                            System.out.print("Enter the name of the Organization :");
                            String name = sc.next();
                            if (orgArray.containsKey(name)) {
                                System.out.print("Enter the maximum value for the Tender :");
                                float current_price = sc.nextFloat();
                                //Tender tender = new Tender(name,current_price,orgArray.get(name).category);
                                tenderArray.put(orgArray.get(name).category, new Tender(name, current_price, orgArray.get(name).category));

                            } else
                                System.out.println("enter valid organization");
                        }catch (Exception e){
                            System.out.println("Error occurred");
                        }

                    }else if (number ==4){ //do the Offer a bid.
                        try {
                            System.out.print("Enter supplier name :");
                            String name = sc.next();// enter name of supplier
                            System.out.print("Enter Category :");
                            String category = sc.next();//enter category
                            if (supArray.containsKey(name) && tenderArray.containsKey(category)) {
                                System.out.print("enter the value you want to bid : ");
                                Float price = sc.nextFloat();
                                tenderArray.get(category).placeBid(supArray.get(name), price);
                            } else
                                System.out.println("Enter valid Category");
                        }catch (Exception e){
                            System.out.println("Error occurred");
                        }


                    }else if (number ==5){ // do the Close a tender.
                        try {
                            System.out.print("Enter the name of the Organization :");
                            String name = sc.next();
                            if (tenderArray.containsKey(name)) {
                                tenderArray.get(name).printList();
                                System.out.println("=============================================");
                                tenderArray.get(name).closeTender();
                                tenderArray.remove(name);
                            } else
                                System.out.println("enter valid organization");
                        }catch (Exception e){
                            System.out.println("Error occurred");
                        }

                    }else
                        break;
                }


            }else{
                System.out.println("Enter valid username password");
            }
        }catch(Exception e){
        }
    }
}
