import java.io.{DataInputStream, DataOutputStream, ObjectOutputStream}
import java.net.{InetAddress, Socket}

object RpcClient {

  def main(args: Array[String]): Unit = {
    
    if(args.length != 2) {
      println("the number of arguments of args not equals 2.")
      System.exit(0)
    }
    //Set up the socket
    val ia: InetAddress = InetAddress.getByName(args(0))
    val socket: Socket = new Socket(ia,args(1).toInt)

    //Set up the input and output stream
    val out: ObjectOutputStream = new ObjectOutputStream(new DataOutputStream(socket.getOutputStream))
    val in: DataInputStream = new DataInputStream(socket.getInputStream)
    
    val clientLanguage = "Scala"
    println("Sending: " + "Hello in " + clientLanguage)
    val msg =  "Hello in " + clientLanguage

    //Send the msg to the server
    out.writeUTF(msg)
    out.flush()

    //Receive the response from the server
    val result: String = in.readUTF()
    println("The server responded：" + result)
    in.close()
    out.close
    
    socket.close()

  }
}

