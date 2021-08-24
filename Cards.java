import java.util.LinkedList;

import javax.swing.ImageIcon;

/**
 * 
 */

/**
 * @author Jasmine
 *
 */
public class Cards {
	
	LinkedList<Integer> orderList = new LinkedList<Integer>();
	LinkedList<Integer> oriList = new LinkedList<Integer>();
	int num;
	
	public Cards(int num) {
		this.num = num;
		for (int i=0; i < num; i++) {
			oriList.add(i+1);
		}
	}
	
	public void printOrder() {
		System.out.println("Original Order of Cards (top card first): " 
	+ orderList);
	}
	
	public LinkedList<Integer> order() {
		
		int j = oriList.size();
		while (j > 1) {
			orderList.addFirst(oriList.removeLast());
			orderList.addFirst(orderList.removeLast());
			j--;
		}
		if (j == 1) {
			orderList.addFirst(oriList.removeLast());
		}
		return orderList;
		
	}
	
}
