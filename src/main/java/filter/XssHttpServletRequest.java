package filter;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import util.SecurityManager;

public class XssHttpServletRequest extends HttpServletRequestWrapper {
	protected Map<String, String[]> parameters;  
	public XssHttpServletRequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	/*@Override
	public Map<String, String[]> getParameterMap() {
		// TODO Auto-generated method stub
		Map<String, String[]> map= super.getParameterMap();
		Map<String, String[]> newmap = new HashMap<String, String[]>();
		for (Entry<String, String[]> entry : map.entrySet()) {
			newmap.put(entry.getKey(), removeIlegalChars2(entry.getValue()));
		}
		return newmap;
	}

	@Override
	public String getParameter(String name) {
		// TODO Auto-generated method stub
		return removeIlegalChars(super.getParameter(name));
	}
	public String removeIlegalChars(String value) {
		String result=value.replaceAll("script", "");
		return result;
	}
	public String[] removeIlegalChars2(String[] value) {
		String[] newArray = new String[value.length];
		for (int i = 0; i < newArray.length; i++) {
			newArray[i]=removeIlegalChars(value[i]);
		}
		return newArray;
	}*/
	public void setCharacterEncoding(String enc)  
            throws UnsupportedEncodingException {  
        super.setCharacterEncoding(enc);  
        //当编码重新设置时，重新加载重新过滤缓存。  
        refiltParams();  
    }  
      
    void refiltParams(){  
        parameters=null;  
    }  
  
    @Override  
    public String getParameter(String string) {  
        String strList[] = getParameterValues(string);  
        if (strList != null && strList.length > 0)  
            return strList[0];  
        else  
            return null;  
    }  
  
    @Override  
    public String[] getParameterValues(String string) {  
        if (parameters == null) {  
            paramXssFilter();  
        }  
        return (String[]) parameters.get(string);  
    }  
  
    @Override  
    public Map<String, String[]> getParameterMap() {  
        if (parameters == null) {  
            paramXssFilter();  
        }  
        return parameters;  
    }  
  
    /** 
     *  
     * 校验参数，若含xss漏洞的字符,进行替换 
     */  
    private void paramXssFilter() {  
        parameters = SecurityManager.getLegalRequestMap(getRequest().getParameterMap());
    }  
  
}
