#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(const pair<int, double> &a, const pair<int, double> &b){
    if(a.second > b.second){
        return true;
    }else if(a.second == b.second){
        if(a.first < b.first){
            return true;
        }else{
            return false;
        }
    }else{
        return false;
    }
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    
    vector<pair<int,double>> stg;
    //pair를 만들어서 <스테이지, 실패율> 이렇게 만들어 비교하면 편하다.
    
    for(int i=1; i<=N; i++){
        int num = 0;
        //현재 스테이지에 머물러있는 사람 = 스테이지랑 같은 수인 사람
        int break_p = 0;
        //스테이지 깬 플레이어. 유저의 수>=N 인 것들.
        
        for(int j=0; j<stages.size(); j++){
            if(i==stages[j]){
                num++;
            }
            if(stages[j]>=i){
                break_p++;
            }
        }
        
        if(break_p == 0) {
            stg.push_back(make_pair(i, 0));
            continue;
        }
        //자리가 중요하다. for문 안에서 위에 차지하면 break_p가 0인 상태에서 시작하기 때문에 무조건 조건에 부합할 수 밖에 없음.
        
        double failrate = 0;
        failrate = (double)num/break_p;
        stg.push_back(make_pair(i,failrate));
    }
    
    sort(stg.begin(),stg.end(),compare);
    
    for(int i=0; i<N; i++){
        answer.push_back(stg[i].first);
    }
    
    return answer;
}

//처음에 비교함수 부분을 bool compare(int a, int b)이라 했는데
//bool compare(const pair<int, double> &a, const pair<int, double> &b)라고 해야한다.
//const는 C, C++에서 상수 라는 의미입니다. 즉, 변수, 함수, 객체, 포인터 등.... 을 상수화 시킬 수 있는 키워드 입니다. 그럼 상수란?? 데이터의 초기화가 이뤄지면 그 값을 바꿀 수 없도록 해 주는 것입니다.

//비교함수 밑부분도 stg.second(a) > stg.second(b);가 아닌
//a.second > b.second 식으로 표현해야한다.