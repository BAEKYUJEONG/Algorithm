#include <iostream>
#include <memory.h>

using namespace std;

int dp[46];

int fibo(int n){
    if(n == 0)
        return 0;
    if(n == 1)
        return 1;

    if(dp[n] != -1)
        return dp[n];
    
    dp[n] = fibo(n-1) + fibo(n-2);
    
    return dp[n];
}

int main(int argc, const char * argv[]) {
    memset(dp,-1,sizeof(int) * 46);
    int n;
    cin>>n;
    cout<<fibo(n)<<endl;
    return 0;
}