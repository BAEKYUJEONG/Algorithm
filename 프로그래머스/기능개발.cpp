#include <string>
#include <vector>
using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    vector<int> proR;
    vector<int> speedR;
    vector<int> cnt;
    int count = 0;
    
    for (int i=0; i < progresses.size(); i++) {
        proR.push_back(progresses[progresses.size()-i -1]);
        speedR.push_back(speeds[speeds.size()-i-1]);
    }
    //이게 있어야 배열을 반대 순서로 넣어준 다음 pop_back()을 할 수 있음.
    //vector는 push_back(), pop_back()만 있는 배열과 비슷한 구조이기 때문.
    
    while(proR.size() > 0) {
        for (int i = 0; i < progresses.size(); i++) {
            proR[i] = proR[i] + speedR[i];
        }
        
        while(proR.back()>= 100){
            if (proR.back() >= 100) {
                proR.pop_back();
                speedR.pop_back();
                count++;
            }
        }
        cnt.push_back(count);
        count = 0;
    }
    
    for (int i = 0; i < cnt.size(); i++) {
        if (cnt[i] !=0 ) {
            answer.push_back(cnt[i]);
        }
    }
    
    return answer;
}