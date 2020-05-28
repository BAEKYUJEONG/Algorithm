#include <iostream>
#include <string>
#include <deque>

using namespace std;

int main(){

  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int n;

  cin >> n;

  deque <int> dq;

  for(int i=0; i<n; i++){

    string temp;
    cin >> temp;

    int num;

    if(temp == "push_back"){
      cin >> num;
      dq.push_back(num);
    }
    else if(temp == "push_front"){
      cin >> num;
      dq.push_front(num);
    }
    else if(temp == "pop_front"){
      if(dq.empty()){
        cout << -1 << endl;
      }
      else{
        cout << dq.front() << endl;
        dq.pop_front();
      }
    }
    else if (temp == "pop_back"){
      if (dq.empty()){
        cout << -1 << endl;
      }
      else{
        cout << dq.back() << endl;
        dq.pop_back();
      }
    }
    else if (temp == "size"){
      cout << dq.size() << endl;
    }
    else if (temp == "empty"){
      if (dq.empty()){
        cout << 1 << endl;
      }
      else
        cout << 0 << endl;
    }
    else if (temp == "front"){
      if (dq.empty())
        cout << -1 << endl;
      else
        cout << dq.front() << endl;
    }
    else if (temp == "back"){
      if (dq.empty())
        cout << -1 << endl;
      else
        cout << dq.back() << endl;
    }
  }
  return 0;
}