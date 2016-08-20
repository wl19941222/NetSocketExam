package Exam1.Exam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 使用程序从网上下载pdf,网址为http：//files.saas.hand-china.com/java/target.pdf，
 * 保存至本地，编程时使用带缓冲的读写，将需要保证保存后的pdf文件能正常打开
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
				
				
				URL url1 = new URL("http://files.saas.hand-china.com/java/target.pdf");
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
