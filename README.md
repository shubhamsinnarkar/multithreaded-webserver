# multithreaded-webserver

 Build a single threaded Web Client on your own which interacts with
your Web Server, and downloads a file from the server

Display the essential connection parameters of connection for both
the Web client ( on the server side ) and for the Web Server ( on the
client side )

Specification
Specifications - Server
The server being multi-threaded, should be able to handle multiple requests
concurrently. The main thread ( server ), listens to a specified port like the
standard port for HTTP (8080). Upon receiving a HTTP request, the server
sets up a TCP connection to the requesting client and serves the request in
a separate thread using a new port. After sending the response back to the
client, it closes the connection. For this exercise you may choose any browser of
your choice for testing. ( Internet Explorer or FireFox or Chrome )2
. However
you should submit a client program as per the the Section Specifications - Client.
The server is assumed to work with HTTP GET messages. If the requested
file exists at the server, it responds with a “HTTP/1.1 200 OK” together with the
requested page to the client, otherwise it sends a corresponding error message,
“HTTP/1.1 404 Not Found” or “HTTP/1.1 400 Bad Request”.
• If running the server program using command line, the syntax should be
server_code_name < port_number >
• You must test your Web server implementation on your local machine
using a Web browser. You need to specify the used port number within
the URL. If omitting the port number portion, i.e., 8080, the browser
should use the default port 8080. To cite an example,
http ∶ //localhost ∶ 8080/index.html
• You should display/log the request and header lines of request messages
on the server for the purpose of debugging.
Specifications - Client
• The client should be able to initiate a connection to the server, via a socket
and request any page on the server. Upon receipt of the response message
from the server, the client extracts and displays/logs the message status3
,
and then retrieves the page content from the corresponding message body.
• The requested file need not be HTML, even a text file would suffice 4
.
• You may execute the client program using command line, with the following syntax,client_code < server_IP address >< port_no ><
requested_f ile_name >
(a) Server_IPaddress: The IP address or name of the Web server, e.g.,
127.0.0.1 or localhost for the server running on the local machine.
(b) port_no: The port on which the server is listening to contnections
from clients. If the port number is not entered, the default port 8080
should be used.
(c) requested_file_name: The name of the requested file, which may
include the path to the file.
Specifications - Connection Parameters
You should be able to extract the following information from the connection
objects,
(a) Calculate and Display RTT for the client request5
.
(b) Print the relevant server details on client side. The examples could
be Host Name of the server, socket family, socket type, protocol, timeout
and get peer name6
.
(c) Print the relevant client details on server side. The examples could
be Host Name of the client, socket family, socket type, protocol, timeout
and get peer name 7
