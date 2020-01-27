import java.io.{DataInputStream, DataOutputStream, ObjectOutputStream}
import java.net.{InetAddress, Socket}

object RpcClient {

  def main(args: Array[String]): Unit = {
    //Set up the socket
    val ia: InetAddress = InetAddress.getByName("localhost")
    val socket: Socket = new Socket(ia,10001)

    //Set up the input and output stream
    val out: ObjectOutputStream = new ObjectOutputStream(new DataOutputStream(socket.getOutputStream))
    val in: DataInputStream = new DataInputStream(socket.getInputStream)

  
    val msg = "Hello in Scala"
    println("The client is going to send："+ msg)

    //Send the msg to the client
    out.writeUTF(msg)
    out.flush()

    //Receive the response from the server
    val result: String = in.readUTF()
    println("The server responded：" + result)
    in.close()
    out.close()
    socket.close()

  }
}

