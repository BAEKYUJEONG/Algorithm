#include <iostream>
#include <string>

using namespace std;
 
int main(int argc, char *argv[]){
  int N;
  int num = 665;
  string s;

  cin >> N;

  while(num++){
    s = to_string(num);

    if(s.find("666") != -1){
      N--;
    }

    if(N==0){
      cout << num << endl;
      break;
    }
  }

  return 0;
}