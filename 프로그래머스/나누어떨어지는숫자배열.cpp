#include <string>
#include <vector>
#include <algorithm>
//algorithm 안 써서 헤맨 것이 너무 빡친다.

using namespace std;

/*bool order(int a, int b){
    return a < b;
}*/

vector<int> solution(vector<int> arr, int divisor) {
    vector<int> answer;
    
    int count;
    
    for(int i=0; i<arr.size(); i++){
        if(arr[i]%divisor==0){
            answer.push_back(arr[i]);
            //answer+=arr[i];
            count++;
        }
    }
    
    if(answer.size()==0){
        answer.push_back(-1);
    }else{
        //sort(arr,arr+count);
        sort(answer.begin(), answer.end());
        //처음과 끝을 이런 식으로 나타내는 게 좋은 듯.
        //sort(answer.begin(), answer.end(), order);로도 가능
        //위에 bool 함수를 만들어서. 하지만 기본이 오름차순.
    }
    
    return answer;
}

/*
size_t 는 unsigned int 이며, 문자열이나 메모리의 사이즈를 나타낼 때 사용합니다.
"unsigned int"를 

typedef unsigned int size_t; 

이렇게 size_t 라는 이름으로 정의해 놓은 것입니다.
*/