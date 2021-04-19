#include<iostream>

using namespace std;

int main(){
    
    int star, i, j;
    cin >> star;
    
    for(i=0; i<star; i++){
        for(j=0; j<star-(i+1); j++){
            cout << " ";
        }
        for(j=0; j<i+1; j++){
            cout << "*";
        }
        cout << endl;
    }
}

// 별찍기 심화. 우측 정렬
//이중for문이지만 for문 안에 두개의 for문
//\n 기능 endl 을 잊지말자
//main 함수 안에서 처음부터 인자를 받아서 해도 되지만, (프로그래머스처럼) 쉽게 cin으로 해도 된다.