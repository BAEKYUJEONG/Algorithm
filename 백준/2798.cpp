#include <iostream>
#include <vector>

using namespace std;

int main(){
  int N, M, temp;
  int sum = 0;
  int close = 0;
  vector <int> card;

  cin >> N >> M;

  for(int i=0; i<N; i++){
    cin >> temp;
    card.push_back(temp);
  }

  for(int i=0; i<N-2; i++){
    for(int j=i+1; j<N-1; j++){
      for(int k=j+1; k<N; k++){
        sum = card[i]+card[j]+card[k];

        if(sum<=M && sum>close){
          close = sum;
        }
      }
    }
  }

  cout << close << endl;

  return 0;
}