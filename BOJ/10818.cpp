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

//���� �����ڸ� �� �ȽἭ ���� �Ẹ�Ҵ�.
//if�����ε� ����