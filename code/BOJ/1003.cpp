#include <iostream>

using namespace std;

int zero, one;

int fibonacci(int n) {

 if (n == 0) {

  zero++;

  return 0;

 }else if (n == 1) {

  one++;

  return 1;

 }else {

  return fibonacci(n - 1) + fibonacci(n - 2);

 }

}

int main() {

 int T;

 cin >> T;

 for (int i = 0; i < T; i++) {

  int N; 

  cin >> N;

  zero = 0, one = 0;

  fibonacci(N);

  cout << zero << " " << one << endl;

 }

 return 0;

}