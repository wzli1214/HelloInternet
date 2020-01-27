// package com.rpc.server

import java.io.{DataInputStream, DataOutputStream, ObjectInputStream}
import java.net.{ServerSocket, Socket}


object RpcServer {
  
  def main(args: Array[String]): Unit = {
    
    if(args.length != 1) {
      println("the number of arguments of args not equals 1.")
      System.exit(0)
    }
    
    //Set up the server
    val listener: ServerSocket = new ServerSocket(args(0).toInt)
    println("The server is in service.......")
    
    while (true) {
      //Set up the socket
      val socket: Socket = listener.accept()
      
      // get client ip
      val clientIp = socket.getInetAddress.getHostAddress
      println("client ip: " + clientIp)
      
      //Set up the input and output stream
      val out = new DataOutputStream(socket.getOutputStream())
      val in = new ObjectInputStream(new DataInputStream(socket.getInputStream()))

      val read: String = in.readUTF()
      println("The client sent：" + read)

      val ma: Array[String] = read.split(" ")
      
      val serverLanguage = "Scala"
      val result = "Goodbye " + ma(ma.length - 1) + " from " + serverLanguage
      println("The server is going to send：" + result)
      
      //Send the response back to the client
      out.writeUTF(result.toString)
      out.flush()

      out.close()
      in.close()
      socket.close()

    }

  }

}
