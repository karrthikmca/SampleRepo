import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Bridge3 {

	public static void main(final String[] args) {
		final Bridge3 test = new Bridge3();
		System.out.println(test.checkIcelands(2, "({A,B,C,D,E,F},{(A,C),(B,C),(C,E),(B,E),(B,D),(E,F)}),({A,B,C,D,E,F},{(A,C),(B,C),(C,E),(B,E),(B,D),(E,F)})"));

	}

	public static String checkIcelands(final Integer input1, final String input2) {
		final String[] testCase = input2.concat(",").split("}\\),");
		final Map<Integer, Collection<String>> testCaseOutputMap = new HashMap<Integer, Collection<String>>();
		Integer testCaseNum = 0;
		for (final String str : testCase) {
			testCaseNum++;
			testCaseOutputMap.put(testCaseNum, new ArrayList<String>());
			final String[] icelandsAndBridges = str.substring(1, str.length() - 1).split("}");
			final String bridges = icelandsAndBridges[1].substring(1) + "),}";
			final String[] bridgesArray = bridges.substring(1, bridges.length() - 1).split("\\),");
			for (final String bridge : bridgesArray) {
				final String[] bridgeTemp = bridge.substring(1).split(",");
				if (bridgeTemp.length < 2) {
					testCaseOutputMap.get(testCaseNum).add(bridge + ")");
				} else {
					final String bridgeStart = bridgeTemp[0];
					final String bridgeEnd = bridgeTemp[1];
					final Map<String, Collection<String>> bridgeStartConnMap = new HashMap<String, Collection<String>>();
					bridgeStartConnMap.put(bridgeStart, new ArrayList<String>());
					final Map<String, Collection<String>> bridgeEndConnMap = new HashMap<String, Collection<String>>();
					bridgeEndConnMap.put(bridgeEnd, new ArrayList<String>());
					boolean isStrongBridge = false;
					for (final String bridgeStr : bridgesArray) {
						if (!bridge.equals(bridgeStr)) {
							final String[] bridgeTempConn = bridgeStr.substring(1).split(",");
							final String bridgeStartConn = bridgeTempConn[0];
							final String bridgeEndConn = bridgeTempConn[1];
							if (bridgeStartConn.equals(bridgeStart) || bridgeEndConn.equals(bridgeStart)) {
								bridgeStartConnMap.get(bridgeStart).add(bridgeStartConn);
								bridgeStartConnMap.get(bridgeStart).add(bridgeEndConn);
								if (bridgeEndConnMap.get(bridgeEnd).contains(bridgeStartConn) || (bridgeEndConnMap.get(bridgeEnd).contains(bridgeEndConn))) {
									isStrongBridge = true;
									break;
								}
							} else if (bridgeStartConn.equals(bridgeEnd) || bridgeEndConn.equals(bridgeEnd)) {
								bridgeEndConnMap.get(bridgeEnd).add(bridgeStartConn);
								bridgeEndConnMap.get(bridgeEnd).add(bridgeEndConn);
								if (bridgeStartConnMap.get(bridgeStart).contains(bridgeStartConn) || (bridgeStartConnMap.get(bridgeStart).contains(bridgeEndConn))) {
									isStrongBridge = true;
									break;
								}
							}
						}
					}
					if (!isStrongBridge) {
						testCaseOutputMap.get(testCaseNum).add(bridge + ")");
					}
				}
			}
		}
		final StringBuilder strBuilder = new StringBuilder("");
		for (final Map.Entry<Integer, Collection<String>> outputEntry : testCaseOutputMap.entrySet()) {
			strBuilder.append("{");
			if (outputEntry.getValue().isEmpty()) {
				strBuilder.append("NA");
			} else {
				for (final String outputStr : outputEntry.getValue()) {
					strBuilder.append(outputStr).append(",");
				}
				strBuilder.setLength(strBuilder.length() - 1);
			}
			strBuilder.append("},");
		}
		strBuilder.setLength(strBuilder.length() - 1);
		return strBuilder.toString();

	}
}
