//
//  main.swift
//  Algorithm
//
//  Created by 백유정 on 2022/08/05.
//

import Foundation

let input = Int(readLine()!)!
let wordArr = readLine()!.sorted()
var sum = 0

for _ in 1...input-1 {
    var sameArr = wordArr
    var similarArr = readLine()!.sorted()
    
    if wordArr == similarArr {
        sum += 1
        continue
    } else if similarArr.count > wordArr.count + 1 ||  similarArr.count < wordArr.count - 1 {
        continue
    }
    
    if similarArr.count == wordArr.count - 1 { /// 1개 적을 때
        var same = 0
        for i in 0...similarArr.count-1 {
            for j in 0...sameArr.count-1 {
                if sameArr[j] == similarArr[i] {
                    same += 1
                    sameArr[j] = " "
                    similarArr[i] = " "
                }
            }
        }
        
        if same == similarArr.count {
            sum += 1
        }
    } else {
        var same = 0
        for i in 0...similarArr.count-1 {
            for j in 0...sameArr.count-1 {
                if sameArr[j] == similarArr[i] {
                    same += 1
                    sameArr[j] = " "
                    similarArr[i] = " "
                }
            }
        }
        
        if similarArr.count == wordArr.count { /// 같을 때
            if same >= wordArr.count - 1 {
                sum += 1
            }
        } else { /// 1개 많을 때
            if same >= wordArr.count {
                sum += 1
            }
        }
    }
}

print(sum)
