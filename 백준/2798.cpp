#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int N, M, temp;
    int result = 0;
    vector <int> A;

    cin >> N >> M;
    
    for(int i=0; i<N; i++){
        cin >> temp;
        A.push_back(temp);
    }
    
    for (int i = 0; i < N-2; i++)
    {
        for (int j = i + 1; j < N-1; j++)
        {
            for (int k = j + 1; k < N; k++)
            {
                if (A[i] + A[j] + A[k] <= M && A[i] + A[j] + A[k] > result)
                {
                    result = A[i] + A[j] + A[k];
                }
            }
        }
    }
    
    cout << result << endl;
    
    return 0;
}