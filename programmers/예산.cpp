#include <iostream>
#include <stdio.h>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> d, int budget) {
    
    int answer = 0;
    int sum = 0;
    int count = 0 ;
    
    cin >> budget;
    
    sort(d.begin(),d.end());
    
    for(int i=0; i<d.size(); i++){
        sum += d[i];
        if(budget>=sum){
            count++;
        }
    }
    
    answer = count;
    
    return answer;
}

//처음에는 sum += d[i]를 if문 안에 넣어서 틀렸다.
//하나 더 크게 나오는 이슈가 발생할 경우가 있더라.