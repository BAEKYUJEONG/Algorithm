#include <vector>

using namespace std;

long long sum(vector<int> &a) {
	long long ans = 0;
    
    for(vector<int>::iterator iter=a.begin(); iter<a.end(); iter++)
        ans += *iter;
	return ans;
}

//iterator를 쓰고 포인터를 써 문제를 푼다는 것에 의의를 두는 문제.