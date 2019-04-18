package util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SecurityManager {

	public SecurityManager() {
		// TODO Auto-generated constructor stub
	}
	private static final String[] htmleScape = {"<",">","\'","\"","&"};
	private static final String[] scriptstr = {"script","javascript"};
	private static final String[] sqlStr = {"create","insert","delete","update","select","drop","alter","add",
			"and","or","from","where","distinct","all","not","\\*","%","\\?","min","max","avg","sum","count",
			"group","having","1=1"};
	public static String removeIlegalStr(String value) {
		String result=value;
		for (int i = 0; i < htmleScape.length; i++) {
			result=result.replaceAll(htmleScape[i], "");
		}
		for (int i = 0; i < scriptstr.length; i++) {
			String insensitiveStr="(?i)"+scriptstr[i];
			result=result.replaceAll(insensitiveStr, "");
		}
		for (int i = 0; i < sqlStr.length; i++) {
			String insensitiveStr="(?i)"+sqlStr[i];
			result=result.replaceAll(insensitiveStr, "");
		}
		return result;
	}
	public static Map<String, String[]> getLegalRequestMap(Map<String, String[]> rawmap) {
		Map<String, String[]> legalMap=new HashMap<String, String[]>();
		for (Entry<String, String[]> entry : rawmap.entrySet()) {
			String[] values = entry.getValue();
			String[] legalvalues = new String[values.length];
			for (int i=0;i<legalvalues.length;i++) {
				legalvalues[i]=removeIlegalStr(values[i]);
			}
			legalMap.put(entry.getKey(), legalvalues);
		}
		return legalMap;
	}
	public static void main(String[] args) {
		String ilegalString="create a script file:<sCript>alert(\"hello\")</scriPt>";
		String result = removeIlegalStr(ilegalString);
		System.out.println(result);
	}
}
