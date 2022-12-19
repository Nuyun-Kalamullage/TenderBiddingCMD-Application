//AA1711
public class Supplier{
    private String name;
    public String category;
    private float price;

    public void setPrice(float price) {
        this.price = price;
    }

    public Supplier(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Supplier() {

    }
    public void show(){
        System.out.println(name +" place bid for Rs:"+price+"/=");
    }
    public void showLowest(){
        System.out.println("Tender in "+category+"category goes to "+ name +" with Rs:"+price+"/=.");
    }
}
