#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{
    bool answer = true;
    int p=0;
    int y=0;
    
    for(int i=0; i<s.size(); i++){
        if(s[i]=='P' || s[i]=='p'){
            p++;
        }
        if(s[i]=='Y' || s[i]=='y'){
            y++;
        }
    }
    
    if(p==y){
        answer = true;
    }else{
        answer = false;
    }

    return answer;
}

//여기서 "P" 라고 써서 나가리됨.
//또한 무조건 카운팅 하는 경우 초기화를 시켜주고 시작하자.