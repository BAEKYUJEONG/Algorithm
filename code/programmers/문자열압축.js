function solution(s) {
    var answer = s.length;
    var arr = [];
    var cnt =0;
    var check = []
    var min = s.length;
    
    for (var i = 1; i<Math.ceil(s.length/2)+1; i++) {
        arr[i] = [];
        for(var j =0; j<s.length; j+=i) {
           arr[i].push(s.substring(j, j+i))
        }
    }
    
    var last = "";
    
    for (var i =1; i< arr.length; i++) {
        last = arr[i][1]
        check = [];
        for (var j =1; j< arr[i].length; j++) {
            if ( arr[i][j-1] != arr[i][j]) {
                check.push(cnt);
                cnt =0;
            } else {
                cnt++
            }
        }

        if (cnt !=0){
            check.push(cnt)
        }
        console.log(check)
        cnt =0;
        
        for (var j =0; j<check.length; j++) {
            if (check.length > 0 && check[j] !=0){
                min -= i*check[j] - (check[j]+1).toString().length
            }
        }
        
        answer = Math.min(answer, min)
        min = s.length
    }
    console.log(arr)

    return answer;
}