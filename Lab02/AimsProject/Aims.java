
public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		// before removing disc
		System.out.println("After adding disc successfully");
		System.out.println("Total cost is: " + anOrder.totalCost());
		System.out.println("Total quantity is: " + anOrder.getQtyOrdered());
		
		// after removing successfully
		System.out.println("In case of removing successfully");
		anOrder.removeDigitalVideoDisc(dvd1);
		System.out.println("Total cost is: " + anOrder.totalCost());
		System.out.println("Total quantity is: " + anOrder.getQtyOrdered());
		
		// after removing fail
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Harry Potter", "Fantasy", "Roger Allers", 87, 19.95f);
		System.out.println("In case of removing fali");
		anOrder.removeDigitalVideoDisc(dvd4);
		System.out.println("Total cost is: " + anOrder.totalCost());
		System.out.println("Total quantity is: " + anOrder.getQtyOrdered());
	}

}
