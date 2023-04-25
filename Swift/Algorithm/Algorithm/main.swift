//
//  main.swift
//  Algorithm
//
//  Created by 백유정 on 2022/08/05.
//

import Foundation

var numArr = [Int](repeating: 0, count: 10)
var max = 0
var index = 0

let input = readLine()!

for i in input {
    numArr[Int(String(i))!] += 1
}

for i in 0...9 {
    if max < numArr[i] && i != 6 && i != 9 {
        max = numArr[i]
        index = i
    }
}

let num = Double(numArr[6] + numArr [9]) / Double(2)

if numArr[index] > Int(ceil(num)) {
    print(max)
} else {
    print(Int(ceil(num)))
}
