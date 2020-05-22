#include <string>
#include <vector>
#include <queue>
 
using namespace std;
 
int solution(vector<int> priorities, int location){
    int answer = 0;
    queue <pair<int, int>> q;
    priority_queue <int> priq;
    
    for(int i = 0; i < priorities.size(); i++){
        q.push(make_pair(i, priorities[i]));
        // 처음 location, 중요도 push
        priq.push(priorities[i]);
        // 중요도 오름차순 정렬 push
        //priority_queue? 우선순위 큐. 자동 오름차순 정렬 기능.
    }
    
    while(!q.empty()){
        int n = q.front().first; // 맨 앞 항목 location
        int p = q.front().second; // 맨 앞 항목 중요도
        
        if(p == priq.top()){
        // 현재 항목 중요도 == 가장 중요
            if(n == location){
            // 현재 항목 == 내가 알고 싶은 위치 항목
                answer++;
                break;
            }else{
                answer++;
                q.pop();
                priq.pop();
                // 가장 중요한 항목 o, but 내가 알고 싶은 것 x, 순서 뒤로 밀림
                // 항목에 해당하는 것들 pop
            }
        }else{
            q.push(q.front());
            q.pop();
            // 항목을 뒤로 이동시킨다.
        }
    }
    
    return answer;
}