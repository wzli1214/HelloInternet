### Team member:
Weizhao Li & Zhuolun Gao

### Dependencies:
+ Java JDK
+ scala

### Step 1:
By default, AWS cloud 9 alrealdy has JAVA JDK, if your environment doesn't have one.
Follow this document below to install the JAVA JDK,

https://docs.aws.amazon.com/cloud9/latest/user-guide/sample-java.html#sample-java-install

### Step 2:
Run the setup.sh to install the scala on Ubuntu environment.

### Step 3:
Run the server with port number:

```bash
scala RpcServer.scala 10001
```

### Step 4:

On AWS cloud9, click + button, open a new terminal. Run the client with the server's hostname/IP and port like this:

```bash
scala RpcClient.scala localhost 10001
```

### Result
The client would send "Hello in Scala", once the server receives the message, the server would send back "Goodbye in scala"


### Socket API explanation

Since scala mostly uses JAVA API, most of the API is the same as JAVA.

#### Setup the socket

we can use Socket(InetAddress address, int port) to setup the socket. 
Also, we can setup the socket for the server by using ServerSocket(int port)

#### Sending and Receiving

Utilize input and output stream 
Use DataOutputStream(socket.getOutputStream) to setup output stream, use DataInputStream(socket.getInputStream) to setup input stream.

Use flush() to send the message. Use readUTF() to receive the message.

#### Close

Use close() to close the input and output stream, use close() to close the socket.