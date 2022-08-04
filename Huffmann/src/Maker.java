import java.util.Scanner;

public class Maker {
	static String[] chars;
	public static String result, oldBinary, newBinary;

	public static void start(String txt) {
		chars = new String[256];
		result = "";
		TreeNode.treeTop = null;
		GrowthElement.first = null;

		GrowthElement.growTree(txt);

		assignCodes(TreeNode.treeTop, "");
		
		String newTxt = txt;
		
		for (int i = 0; i < 256; i++) {
			if(chars[i] != null) {
				char c = (char)(i);
				newTxt = newTxt.replaceAll(""+c, chars[i] + " ");
				result += (c + ": " + chars[i]) + "\r\n";
			}
		}
		System.out.println(result);
		oldBinary = (convertStringToBinary(txt));
		newBinary = (newTxt);
	}
	
	public static String convertStringToBinary(String input) {
        String result = "";
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result = result + (
                    String.format("%8s", Integer.toBinaryString(aChar))   // char -> int, auto-cast
                            .replaceAll(" ", "0")                         // zero pads
            );
            result = result + " ";
        }
        return result.toString();
    }
	
	static void assignCodes(TreeNode ht, String code) {
		if (ht.value.length() == 1) {
			int pos = (byte)ht.value.toCharArray()[0];
			chars[pos] = code;
		}
		else {
			assignCodes(ht.left, code + "1");
			assignCodes(ht.right, code + "0");
		}
	}

}
