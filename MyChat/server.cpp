#include<bits/stdc++.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<sys/un.h>
#include<unistd.h>
using namespace std;
int main(void){
    int server_sockfd,client_sockfd;
    int server_len,client_len;
    struct sockaddr_un server_address;
    struct sockaddr_un client_address;
    //delete the socket before,and create a new unnamed socket
    unlink("server_socket");
    server_sockfd=socket(AF_UNIX,SOCK_STREAM,0);

    //name the created socket
    server_address.sun_family=AF_UNIX;
    strcpy(server_address.sun_path,"server_socket");
    server_len=sizeof(server_address);
    bind(server_sockfd,(struct sockaddr *)&server_address,server_len);
    
    //create a link queue and wait the connect of client
    listen(server_sockfd,5);
    while(1){
        char  ch;
        cout<<"server waiting!"<<endl;

        //now turn to  accept the connect
        client_len=sizeof(client_address);
        client_sockfd=accept(server_sockfd,
                (struct sockaddr *)&client_address,(socklen_t *)&client_len);
        
        //do the r/w operation in the client on the client_sockfd socket
        read(client_sockfd,&ch,1);
        ch++;
        write(client_sockfd,&ch,1);
        close(client_sockfd);
    }
    return 0;
}