#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main(){
    
    int n;
    vector <int> a;
    
    
    cin >> n;
    
    for(int i=0; i<n; i++){
        int tmp = 0;
        cin >> tmp;
        a.push_back(tmp);
    }
    
    sort(a.begin(),a.end());
    
    cout << a[0]*a[n-1] <<endl;
 
    
}