package misc;

public class ques {
	
	class Item{
		public int productIid;
		public int quantity;
		public int price;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Item[] shoplist 
		int ans = 0;
		for(int i = 0 ; i < shoplist.length; i++) {
			Item item = shoplist[i];
			ans += item.quantity * item.price;
		}

	}

}
