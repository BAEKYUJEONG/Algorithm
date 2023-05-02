//
//  main.swift
//  Algorithm
//
//  Created by 백유정 on 2022/08/05.
//

import Foundation

var arr: [Int] = []
var sum = 0
var isHigherThan100 = false

for _ in 0...9 {
    arr.append(Int(readLine()!)!)
}

for i in 0...9 {
    sum += arr[i]
    if sum >= 100 {
        (sum-100) <= (100-(sum-arr[i])) ? print(sum) : print(sum-arr[i])
        isHigherThan100 = true
        break
    }
}

if !isHigherThan100 {
    print(sum)
}
