#include <iostream>

using namespace std;

int main(){
    
    int C, N;
    
    cin >> C;
    
    for(int i=0; i<C; i++) {
        float average = 0;
        int sum = 0;
        int count = 0;
        float percentage = 0;
        
        cin >> N;
        int score[N];
        
        for(int j=0; j<N; j++) {
            cin >> score[j];
            sum += score[j];
        }
        
        average = (double)sum/N;
        
        for(int j=0; j<N; j++) {
            if(score[j] > average){
                count++;
            }
        }
        
        percentage = (double)(count/N)*100;
        cout.precision(3);
        cout << percentage << "%" << endl;
    }
    
    return 0;
}
