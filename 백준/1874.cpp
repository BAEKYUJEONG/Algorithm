#include <iostream>
#include <vector>
#include <string>
#include <stack>

using namespace std;

int main() {
  int N;
  vector<int> vec;
  stack<int> arr;
  vector<string> s;
  int j =0;
    
  cin >> N;
  
  for (int i=0; i<N; i++) {
    int tmp;
    cin >> tmp;
    vec.push_back(tmp);
  }
  for (int i=1; i<=N; i++) {
    arr.push(i);
    s.push_back("+");
    
    while(!arr.empty() && arr.top() == vec[j]){
      int tmp = vec[j];
      arr.pop();
      s.push_back("-");
      j++;
    }
  }
  if (!arr.empty()) {
    cout << "NO" << endl;
  } else {
    for (int i=0; i< s.size(); i++) {
      cout << s[i] << "\n";
    }
  }

  return 0;
}