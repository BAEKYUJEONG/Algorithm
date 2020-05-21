#include <iostream>
#include <string>
#include <stack>

using namespace std;
 
int main() {
    stack<int> S;
    int n;

    cin >> n;
    
    for (int i = 0; i < n; i++) {
        string str;
        cin >> str;
        if (str == "push") {
            int x; 
            cin >> x;
            S.push(x);
        }
        else if (str == "top") {
            if (S.empty())cout << "-1" << endl;
            else cout << S.top() << endl;
        }
        else if (str == "pop") {
            if (S.empty())cout << "-1" << endl;
            else {
                cout << S.top() << endl;
                S.pop();
            }
        }
        else if (str == "empty") {
            cout << S.empty() << endl;
        }
        else {
            cout << S.size() << endl;
        }
    }
    return 0;
}