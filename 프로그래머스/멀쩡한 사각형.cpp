using namespace std;

long long solution(int w,int h) {
    long long answer = 1;
    int mark_n;
    int division_n;
    int new_w, new_h;
    
    if(w>h) mark_n = h;
    else mark_n = w;
    
    for(int i=0; i<mark_n/2; i++){
        if(w%i==0 && h%i==0){
            division_n = i;
        }
    }
    
    new_w = w/division_n;
    new_h = h/division_n;
    
    
    
    
    return answer;
}


//경우들을 직접 그려가며 생각하고 있었는데, 1*n들의 경우와 2*n들의 경우는 나름 공식이 가능한데, 3*5와 같은 경우는 또 모르겠어서 공식을 만드는데 있어 골머리중... 위칸에서 반이상을 차지하며 2칸이 멀쩡하게 쓸 수 있다. 그래서 지금 좌표를 찍으며 선이 지나갔는지 확인하는 코드를 만들까하는데 그건 또 너무 노가다 같아서 실패 중이다. 수학적 사고를 늘리는 연습을 더 하는중.