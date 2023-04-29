//
//  main.swift
//  Algorithm
//
//  Created by 백유정 on 2022/08/05.
//

import Foundation

let str = readLine()!
var startIndex: String.Index
var answerArr: [String] = []

for i in 0...str.count - 1 {
    startIndex = str.index(str.startIndex, offsetBy: i)
    let range = startIndex...
    answerArr.append(String(str[range]))
}

answerArr = answerArr.sorted()

for answer in answerArr {
    print(answer)
}
