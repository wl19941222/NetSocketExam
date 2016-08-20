package Exam33.Exam33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 编程访问http://hq.sinajs.cn/list=sz300170,
 * 解释所得到的数据,并将生成XML数据文件和JSON文件,
 * 并保存到本地, 如:xml数据:
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      
    	new ReadFile().start();
    }
    
    
    static class ReadFile extends Thread{
    	@Override
    	public void run() {
    		URL url;
			try {
				
				
				URL url1 = new URL("http://hq.sinajs.cn/list=sz300170");
				URLConnection connection = url1.openConnection();
			    InputStream is = connection.getInputStream();
			    InputStreamReader isr = new InputStreamReader(is,"GBK");//如果乱码，可在这里指定编码方式（比如：(is,"UTF-8")）
			    BufferedReader br = new BufferedReader(isr);
			    
			    String line;
			    StringBuilder builder = new StringBuilder();
			    while ((line = br.readLine()) != null) {
					builder.append(line);
				}
			    
			    br.close();
			    isr.close();
			    is.close();
			    
			    System.out.println(builder.toString());
			
			
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    	}
    }
     
    
}
