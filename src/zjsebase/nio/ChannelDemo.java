package zjsebase.nio;

/**
 * @auther huidu
 * @create 2019/11/28 19:09
 * @Description: nio中的通道
 * 用于源节点于目标节点的连接，与缓冲区配合进行传输，本身不传输数据，缓冲区在通道中传输
 *
 * 通道的主要实现类
 * 	   java.nio.channels.Channel 接口：
 * 		   |--FileChannel
 * 		   |--SocketChannel
 * 		   |--ServerSocketChannel
 * 		   |--DatagramChannel
 *
 * 获取通道的方法
 *     1. Java 针对支持通道的类提供了 getChannel() 方法
 * 		   本地 IO：
 * 		       FileInputStream/FileOutputStream
 * 		       RandomAccessFile
 *
 * 		   网络IO：
 * 		       Socket
 * 		       ServerSocket
 * 		       DatagramSocket
 *
 *     2. 在 JDK 1.7 中的 NIO.2 针对各个通道提供了静态方法 open()
 *     3. 在 JDK 1.7 中的 NIO.2 的 Files 工具类的 newByteChannel()
 *
 * 通道之间的数据传输方法
 *     transferFrom()
 *     transferTo()
 *
 * 分散(Scatter)与聚集(Gather)
 *     分散读取（Scattering Reads）：将通道中的数据分散到多个缓冲区中
 *     聚集写入（Gathering Writes）：将多个缓冲区中的数据聚集到通道中
 *
 * 字符集：Charset
 *     编码：字符串 -> 字节数组
 *     解码：字节数组  -> 字符串
 */
public class ChannelDemo {
    public static void main(String[] args) {
    }
}
