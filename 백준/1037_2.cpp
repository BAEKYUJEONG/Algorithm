#include <iostream>
#include <string>
#include <algorithm>

using namespace std;


int main() {
    int N;
    cin >> N ;
    
    int *Num = new int[N];
    
    for(int i=0;i<N;i++){
        cin >> Num[i];
    }
    
    sort(Num,Num+N);
    
    cout << Num[0]*Num[N-1];

}