
public class GrowthElement {
	public static GrowthElement first;
	public GrowthElement next;
	public GrowthElement previous;
	TreeNode node;
	
	public int count;

	public GrowthElement(TreeNode ht, int c) {
		this.node = ht;
		this.count = c;
	}

	public static void addElement(GrowthElement temp) {
		if (first != null) {
			temp.next = first;
			first.previous = temp;
		}
		first = temp;
	}
	
	public static void removeElement(GrowthElement ge) {
		if (ge == null)
			return;
		if (first == ge) {
			if(first.next == null) {
				first = null;
			}else {
				first = ge.next;
				first.previous = null;
			}
		} else if (ge.next == null) {
			ge.previous.next = null;

		} else {
			ge.previous.next = ge.next;
			ge.next.previous = ge.previous;
		}
	}
	
	static void scanText(String t) {
		while (t.length() > 0) {
			char l = t.charAt(0);
			int b = t.length();
			t = t.replace("" + l, "");
			int count = b - t.length();
			TreeNode ht = new TreeNode("" + l);
			GrowthElement.addElement(new GrowthElement(ht, count));
		}
		
	}

	static void growTree(String t) {
		scanText(t);
		
		GrowthElement smallest1;
		GrowthElement smallest2;
		while (GrowthElement.first.next != null) { 
			
			//Find de 2 mindste
			smallest1 = null;
			smallest2 = null;
			GrowthElement temp = GrowthElement.first;
			while (temp != null) {
				if (smallest1 == null)
					smallest1 = temp;
				else if (smallest2 == null)
					smallest2 = temp;
				else if(smallest1.count >= smallest2.count) {
					if(temp.count < smallest1.count) smallest1 = temp;
				}else {
					if(temp.count < smallest2.count) smallest2 = temp;
				}
				temp = temp.next;
			}
			
			//koble de 2 sammen til et element
			TreeNode joined = new TreeNode(smallest1.node.value + smallest2.node.value, smallest1.node, smallest2.node);
			
			//tilføj det ene element og slet de 2 andre
			GrowthElement.addElement(new GrowthElement(joined, smallest1.count + smallest2.count));
			GrowthElement.removeElement(smallest1);
			GrowthElement.removeElement(smallest2);
			
			//debugging, men det er meget rart at have
			System.out.println("The two smallest letters are: " + smallest1.node.value + ": " + smallest1.count
					+ " and " + smallest2.node.value + ": " + smallest2.count);
			

		}
		TreeNode.treeTop = GrowthElement.first.node;
		GrowthElement.removeElement(GrowthElement.first);

	}

}
