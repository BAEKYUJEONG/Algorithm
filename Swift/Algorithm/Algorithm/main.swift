//
//  main.swift
//  Algorithm
//
//  Created by 백유정 on 2022/08/05.
//

import Foundation

/// 남은 자리 중에 자기가 가진 인덱스 만큼 떨어져 앉으면 자신의 자리

let N = Int(readLine()!)!
let heightArr = readLine()!.split(separator: " ").map{ Int($0)! }
var answerArr = [Int](repeating: 0, count: N)

for i in 0...N-1 {
    var target = heightArr[i]
    
    for j in 0...N-1 {
        if answerArr[j] == 0 {
            if target == 0 {
                answerArr[j] = i+1
            }
            target -= 1
        }
    }
}

answerArr.forEach{ print($0, terminator: " ") }
