package csye6200_Lab1;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.time.LocalDateTime;    

public class Item {
	
	int itemID;
	double price;
	String name;
	int qty;
	
	Item(int itemId, double price,String name,int qty)
	{
		this.itemID=itemId;
		this.price=price;
		this.name=name;
		this.qty=qty;
	}
	
	public String toString()
	{
		return this.name+"  "+this.qty+"  "+ "$"+this.price*this.qty;
	}
	
	
	public static void demo(double cashInHand) {
		Item[] items=new Item[4];
		items[0]=new Item(1, 1.99,"peanut  ",1);
		items[1]=new Item(2, 1.99,"bread   ",1);
		items[2]=new Item(3, 1.49,"egg     ",1);
		items[3]=new Item(4, 0.49,"snickers",1);
	
		double sum=0;
	
	/*
	 * displaying all items asking user to select the item and qty
	 */	Scanner sc=new Scanner(System.in);
		double itemTotalPrice;
		char isCont='Y';
		int itemNo;
		int itemQty;
		double change=0;
		
		
		while(isCont=='Y' || isCont=='y')   //Compares ASCII Value
		{   
			System.out.println("Please select from the following list of Items:");
			
			for(Item item:items) {
				System.out.println("Item Id:"+item.itemID+ " "+item.name+" $"+item.price);
			}
			itemNo=sc.nextInt();
			sc.nextLine();
			System.out.println("please enter the quantity of the item selected:");
			itemQty=sc.nextInt();
			sc.nextLine();
			sum=sum+items[(itemNo-1)].price*itemQty;
			if((cashInHand-sum)<0) {
				System.out.println("you dont have enough cash to go through with the purchase.. :/ your remaining "
						+ "balance is $"+change);
			}
			else {
			change =cashInHand-sum;
			items[itemNo-1].qty=itemQty;
			System.out.println("Balance: $"+change);
			}			
			
			
			System.out.println("Do you still want to Continue Shopping? (Y/N)");
			isCont=sc.next().charAt(0);
			
	
		}
		

		
		System.out.println("\n \n ---------------Your Receipt-----------------");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now)+"\n");
		
		DecimalFormat df = new DecimalFormat("#.##");
	
	for(Item item:items)
	{
		if(item.qty>0)
		System.out.println(item.toString());
	}
	System.out.println("------------------");
	System.out.println("     Total:  $"+df.format(sum));
	
	
	
	System.out.println("\n Your Change :$"+(df.format(change)));
	
	
		  
	   System.out.println("\n Thank You!!");
		
	}
	

}
