import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
//接收的是数据类型，把byte数组转换成数据类型
public class DoubleMyServer
{
    /*服务端*/
    public static void main(String[] args) throws IOException
    {
        //1、创建服务器+端口
        DatagramSocket server=new DatagramSocket(8888);
        //2、准备接受容器
        byte[] container=new byte[1024];
        //3、封装成包
        DatagramPacket packet=new DatagramPacket(container,container.length);
        //4、接受数据
        server.receive(packet);
        //5、分析数据
        double data=convert(packet.getData());
        System.out.println(data);
        //6、释放
        server.close();

    }
    public static double convert(byte[] data)throws IOException{
        DataInputStream dis=new DataInputStream(new ByteArrayInputStream(data));
        double num=dis.readDouble();
        dis.close();
        return num;
    }
}
