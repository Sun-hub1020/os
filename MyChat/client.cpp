#include<bits/stdc++.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<sys/un.h>
#include<unistd.h>
using namespace std;
int main(void){
    int  sockfd,len,result;
    struct sockaddr_un address;
    char ch='A';
    
    //create a socket for the client
    sockfd=socket(AF_UNIX,SOCK_STREAM,0);

    //name the socket accordding to the server
    address.sun_family=AF_UNIX;
    strcpy(address.sun_path,"server_socket");
    len=sizeof(address);

    //connect the socket of client and server
    result=connect(sockfd,(struct sockaddr *)&address,len);
    if(result==-1){
        cerr<<"opps:client"<<endl;
        exit(1);
    }

    //do the r/w operation throught client_sockfd socket
    write(sockfd,&ch,1);
    read(sockfd,&ch,1);
    cout<<"char from server = "<<ch<<endl;
    close(sockfd);
    return 0;
}