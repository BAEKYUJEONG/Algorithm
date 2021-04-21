#include <iostream>

using namespace std;

int main(void) {
	int n;
	cin >> n;
	
	if(n % 4 == 0 && n%100 !=0){
		cout << "1";
	}else if(n % 400 == 0){
                         cout << "1";
            }else 
                  cout << "0";
}

//&이 아니라 &&로. 기본적인 실수는 하지 말자!