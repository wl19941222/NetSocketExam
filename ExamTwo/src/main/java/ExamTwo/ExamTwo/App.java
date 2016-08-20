package ExamTwo.ExamTwo;


/**
 * 实现一个socket服务器端 和 一个socket客户端，
 * 先启动服务器端，当客户端连接上了后，
 * 将一题中得到的target.pdf通过Stream发送给客户端，
 * 客户端接收并保存为pdf文件，并保证pdf文件能被正常打开
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	new ServerListeners().start();
    	
    }
}
