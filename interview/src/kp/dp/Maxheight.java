
package kp.dp;

import java.util.HashMap;
import java.util.Map;

/*class TMap implements Comparable {
	char char1;
	Integer cnt;

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Integer val = (Integer) o;
		return (this.cnt > val ? cnt : val);
	}

}
*/
public class Maxheight {
	public static void main(String args[]) {
		String str = "aaaxxxxx";
		Map<String, Integer> m = new HashMap<String, Integer>();
		int max = -1;
		String val1 = "";
		for (int i = 0; i < str.length(); i++) {
			if (m.containsKey(Character.toString(str.charAt(i)))) {
				m.put(str.substring(i, i + 1), m.get(str.substring(i, i + 1)) + 1);
			} else {
				m.put(str.substring(i, i + 1), 1);
			}
			if (max < m.get(str.substring(i, i + 1))) {
				val1 = str.substring(i, i + 1);
			}
		}
		System.out.println(val1 + m.get(val1));
	}
}
