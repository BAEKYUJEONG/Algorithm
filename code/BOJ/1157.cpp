#include<iostream>

using namespace std;

int main(){
  string s;
  int arr[26] = {0, }; //배열을 초기화 할 경우 이런 식으로 표기.
  int max = 0;
  int index = 0;

  cin >> s;

  for(int i=0; i<s.length(); i++){
    if(s[i]<97){
      arr[s[i]-65]++; //대문자
    }else{
      arr[s[i]-97]++; //소문자
    }
  }

  for(int i=0; i<26; i++){
    if(max < arr[i]){
      max = arr[i];
      index = i;
    }
  }

  for(int i=0; i<26; i++){
    if(i == index){
      continue;
    }else if(max == arr[i]){ //if문으로 따로 빼서 표기 가능.
      cout << "?" << endl;
      return 0;
    }
  }

  cout << (char)(index+65);
  return 0;

}