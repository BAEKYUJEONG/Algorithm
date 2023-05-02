//
//  main.swift
//  Algorithm
//
//  Created by 백유정 on 2022/08/05.
//

import Foundation

let input = Int(readLine()!)!
var numSet: Set<Int> = []

let arr = readLine()!.split(separator: " ").map { numSet.insert(Int($0)!) }

let tc = Int(readLine()!)!
let answerArr = readLine()!.split(separator: " ").map { Int($0)! }

for answer in answerArr {
    if numSet.contains(answer) {
        print(1)
    } else {
        print(0)
    }
}
