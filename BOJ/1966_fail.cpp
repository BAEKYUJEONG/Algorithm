#include <string>
#include <vector>
#include <queue>
#include <iostream>
 
using namespace std;
 
int main (){
    int test_case;
    int N, M;
    //N은 문서 길이
    //M이 location
    int answer = 0;

    vector <int> priorities;
    queue <pair<int, int>> q;
    priority_queue <int> priq;

    cin >> test_case;

    for(int i=0; i<test_case; i++){

      answer = 0;

      cin >> N >> M;
      
      for(int i=0; i<N; i++){
        int tmp = 0;
        cin >> tmp;
        priorities.push_back(tmp); //문서 순서대로 받음.
      }

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
        q.pop();

        if(p == priq.top()){
        // 현재 항목 중요도 == 가장 중요
            priq.pop();
            answer++;
            if(n == M){
            // 현재 항목 == 내가 알고 싶은 위치 항목
                cout << answer << endl;
                break;
            }
        }else{
            q.push({n,p});
            // 항목을 뒤로 이동시킨다.
        }
      }
    }

    return 0;
}