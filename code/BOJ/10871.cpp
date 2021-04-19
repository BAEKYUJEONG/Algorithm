#include<iostream>

using namespace std;

int main(){
    
    int n, x, r;
    
    cin >> n >> x;
        
    for(int i=0; i<n; i++){
        cin >> r;
        
        if(x>r){
            cout << r << " ";
        }
    }
    
    cout << endl;

}

/*
입력할 대상이 많으면, c++에서는
cin >> a >> b; 와 같이 연속해서 입력 가능.
또한 rand()를 쓸 필요 없이 위와 같은 함수만으로도 r을 무작위로 생성 가능.
*/