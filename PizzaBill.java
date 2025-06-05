class pizza {
    private int price;

    private boolean veg;

    private int baseprice;

    private int extracheese = 100;
    private int extratoping = 50;
    private int takebag = 20;

    private boolean isExtracheese = false;
    private boolean isExtratoping = false;
    private boolean isExtrabag = false;

    public pizza(boolean veg) {
        this.veg = veg;
        if (this.veg) {
            this.price = 300;
        } else {
            this.price = 400;
        }

        baseprice = this.price;
    }

    public int Extracheese() {

        isExtracheese = true;
        this.price += extracheese;

        return this.price;
    }

    public int topping() {

        isExtratoping = true;
        this.price += extratoping; 

        return this.price;
    }

    public int takeaway() {

        isExtrabag = true;
        this.price += takebag; 

        return this.price;
    }

    public void getPrice() {
        String bill = "";
        if (isExtracheese) {
            bill += "extracheese price is= " + extracheese + "\n";
        }

        if (isExtratoping) {
            bill += "Extra topping price is= " + extratoping + "\n";
        }

        if (isExtrabag) {
            bill += "Extra takeaway bag price is= " + takebag + "\n"; 
        }

        bill += "bill is = " + this.price + "\n";
        System.out.println(bill);
    }
}

class specialPizza extends pizza {
    public specialPizza(boolean veg) {
        super(veg);
    }
    
}

public class PizzaBill {
    public static void main(String[] args) {
        pizza obj = new pizza(true);
        obj.Extracheese();
        obj.takeaway();
        obj.topping();
        obj.getPrice();


        System.out.println("special pizza");

        specialPizza obj1=new specialPizza(false);
        obj1.Extracheese();
        obj1.getPrice();
    }
}