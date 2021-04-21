#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    
    for(int i=0; i<prices.size(); i++){
        int count = 0;
        //밖이 아니라 안에 넣어줘야 하는 이유 : 그래야 한바퀴 돌 때마다 계속 초기화가 가능하다.
        //아니면 [4,3,1,1,0]이 [4,7,8,9,9]로 나옴!
        for(int j=i+1; j<prices.size(); j++){
            if(prices[i]<=prices[j]){
                count++;
            }else{
                count++;
                break;
            }
        }
        answer.push_back(count);
    }
    return answer;
}

//별찍기와 비슷하다고 생각될 수 있는 문제지만서도 문제의 이해가 부족했다.
//유동적으로 계속 앞항과 뒤항으로 따졌을 때 값이 떨어질 경우에 대해 생각하는 것이 아니라,
//i항에 들어있는 값과 나머지 뒤 항들과의 비교를 해야함.
//이중 for문 문제. 하나를 기준으로 또 안쪽에서 한바퀴 도는 것. 간단.