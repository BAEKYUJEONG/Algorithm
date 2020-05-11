#include <iostream> 
using namespace std; 

int main() 
{ 
    int star; // N 갯수 
    cin >> star; // N 입력 
    if (star < 1 || star >100) // 1<= N <= 100 사이 
        return 0; 
    for (int i = 0; i < star; i++) // 각줄 
    { 
        for (int j = 0; j < i+1; j++) // 각줄당 별 갯수 
        { 
            cout << "*"; // * 출력 
        } 
        cout << endl; // 줄 넘기기 
    } 
        return 0; 
}
