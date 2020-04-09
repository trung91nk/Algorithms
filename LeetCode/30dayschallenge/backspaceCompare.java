import java.util.*;
public class backspaceCompare{
	public static void main(String [] args){
		String s = "a#c";
		String t = "b";
		System.out.println(backspaceCompare(s,t));
	}
	public static boolean backspaceCompare(String S,String T){
		if(erase(S).equals(erase(T))){
			return true;
		}else{
			return false;
		}
	}
	public static String erase (String s){
		char [] c = s.toCharArray();
		List<Character> listChar = new ArrayList<Character>();
		int i =0;
		int ptr = 0;
		while((int)(c[i])==(int)('#')){
			i++;
		}
		for(int j = i;j<c.length;j++){
			if((int)(c[j])!=(int)('#')){
				listChar.add(c[j]);
				ptr++;
			}else{
				if(ptr>=1){
					listChar.remove(ptr-1);
					ptr--;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(Character ch : listChar){
			sb.append(ch);
		}
		return sb.toString();
	}
}
