#include<iostream>

using namespace std;

int main(){
    
    int a, b;
    
    while(cin>>a>>b){
        cout<<a+b<<endl;
    }
    
    return 0;
    
}

/*
#include<iostream>

using namespace std;

int main(){
    
    int a, b;
    
    while(true){
        
        cin>>a>>b;
        cout<<a+b;
    }
    
}

처음에 이렇게 품 옘병
입력이 주어질때마다 출력값을 계속 내면 되는데,
무턱대고 while(true)를 쓴 것이 출력초과를 만들어냄.
작은 조건이라도 눈여겨보고 넣을 줄 알자.
while(cin>>a>>b)가 정답.
*/