#include <string>
#include <vector>
#include<algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;

    for(int i=0; i<commands.size(); i++){
        
        vector<int> temp;
        for(int j=commands[i][0]-1; j<commands[i][1]; j++)
            temp.push_back(array[j]);
        sort(temp.begin(),temp.end());
        answer.push_back(temp[commands[i][2]-1]);
    
    }
    return answer;
}

/*
// 밑은 참고코드
vector<int> solution(vector<int> array1, vector<vector<int>> commands) {
    vector<int> answer;
    //반환되야되는 세트동안 반복
    for (int i = 0; i < commands.size(); i++){
        //임시 벡터 생성
        vector<int> temp;
        //필요한 부분만 임시벡터에 넣음
        for (int j = commands[i][0] - 1; j < commands[i][1]; j++)
            temp.push_back(array1[j]);
        //**임시 벡터정렬**
        sort(temp.begin(), temp.end());
        //임시벡터의 index번째를 answer에 넣음
        //여기서는 특이하게 at을 씀.
        answer.push_back(temp.at(commands[i][2] - 1));
    }
    return answer;
}
*/