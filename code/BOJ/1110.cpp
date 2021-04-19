#include<iostream>

using namespace std;

int main(){
    
    int n, init;
    
    if(0<=n && n<=99){
        cin >> n;
    }
    init = n;
    
    int a,b,sum;
    int count =0;
    
    do{
        a = n/10;
        b = n%10;
        sum = a+b;
        n = b*10+(sum%10);
        count++;
    }while(n!=init);
    
    cout << count;
}

/*
제발 바보처럼 if문에 한번에 겹쳐 쓰지 말것.
0<=n<=99 (x)
그냥 문제 이해를 잘하자. 단순 앞뒷자리 더하는 문제가 아니라 
전 항목의 뒷자리와 더해서 나온 앞자리를 더하는 거였음. 이것 때문에 겁나 헤맴.
init = n 이게 들어가야한다! 위쪽에 배치 잘하기.
*/