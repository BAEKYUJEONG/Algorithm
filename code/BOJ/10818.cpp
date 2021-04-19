#include <iostream>

using namespace std;

int main(){
	
	int n;
	cin>>n;
	
	int num[n+1];
	int min = 1000000;
	int max = -1000000;
	
	for(int i=0; i<n; i++){
		cin >> num[i];
		
        max = num[i] > max ? num[i] : max;
        min = num[i] < min ? num[i] : min;
	}
	
	cout << min << " " << max << endl;
	
	return 0;
}

//삼항 연산자를 잘 안써서 섞어 써보았다.
//if문으로도 가능