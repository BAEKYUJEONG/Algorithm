using namespace std;

long long solution(int w,int h) {
    long long answer = 1;
    long long mark_n;
    long long division_n;
    long long new_w, new_h;
    long long sum = (long long)w * (long long)h;
    
    if(w>h) mark_n = h;
    else mark_n = w;
    
//    mark_n = (w>h) ? h : w; 한 줄 가능.
    
    for(int i=mark_n; i>0; i--){
        if(w%i==0 && h%i==0){
            division_n = i;
            break;
        }
    }
    
    new_w = w/division_n;
    new_h = h/division_n;
    
    answer = sum - division_n * (new_w + new_h - 1);
    
    return answer;
}
