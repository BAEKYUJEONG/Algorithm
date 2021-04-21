#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 0;
    int count = 0;
    int max = 0;
    int check = 0;
    for(int i=1; i<=s.length; i++){
        for(int j=0; j<s.length; j+=i){
            if(s.substr(j.j+i)==s.substr(j+i,j+i+i)){
                count+=i;
            }
        }
        if (max<=count){
            max = count;
            check = i;
        }
        count = 0;
    }
    return answer;
}