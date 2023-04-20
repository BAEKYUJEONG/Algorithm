//
//  main.swift
//  Algorithm
//
//  Created by 백유정 on 2022/08/05.
//

import Foundation

let input = readLine()!
var numArr: [Int] = []

for i in input {
    numArr.append(Int(String(i))!)
}

numArr.sort(by: >)

for i in numArr {
    print(i, terminator: "")
}
