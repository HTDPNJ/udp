import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
//发送的是数据类型，先要把数据类型转换成byte数组
public class DoubleMyClient
{//客户端

    public static void main(String[] args)throws IOException
    {
        //1、创建客户端+端口
        DatagramSocket client=new DatagramSocket(6666);
        //2、准备数据
        Double num=89.12;
        byte []data=convert(num);
        //3、打包（发送的地点和端口）
        DatagramPacket packet=
                new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8888));
        //4、发送
        client.send(packet);
        //5、释放
        client.close();

    }
    public static byte[] convert(double num) throws IOException
    {
        byte[] data=null;
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        DataOutputStream dos=new DataOutputStream(bos);
        dos.writeDouble(num);
        dos.flush();

        //获取数据
        data=bos.toByteArray();
        dos.close();
        return data;
    }
}
