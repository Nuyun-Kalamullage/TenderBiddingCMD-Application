import java.util.HashMap;

//AA1711
public class Tender {
    private float current_price;
    private String name;
    private String category;
    private Supplier lowestSupplier = new Supplier();

    HashMap<String, Supplier> lowestSuppliers = new HashMap<>();

    public Tender(String name, float current_price, String category) {
        super();
        this.current_price = current_price;
        this.name = name;
        this.category = category;
    }


    public void placeBid(Supplier supplier,float price){
        try {
            if (current_price > price) {
                System.out.println("Bid Successful");
                supplier.setPrice(price);
                lowestSupplier = supplier;
                lowestSuppliers.put(supplier.category, supplier);
            } else
                System.out.println("Enter lower bid");
        } catch (Exception e) {
            System.out.println("Found some error");
        }
    }

    public void printList(){
        for (Supplier s : lowestSuppliers.values()) {
            s.show();
        }
    }
    public void closeTender(){
        lowestSupplier.showLowest();
    }


}
