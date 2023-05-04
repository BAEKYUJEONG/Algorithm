//
//  main.swift
//  Algorithm
//
//  Created by 백유정 on 2022/08/05.
//

import Foundation

let myTeamArr = readLine()!.split(separator: " ").map { Int($0)! }
let yourTeamArr = readLine()!.split(separator: " ").map { Int($0)! }

var mySum = 0
var yourSum = 0
var isWin = false

for i in 0...8 {
    mySum += myTeamArr[i]
    if mySum > yourSum {
        isWin = true
    }
    yourSum += yourTeamArr[i]
}

if mySum >= yourSum {
    print("No")
} else {
    if isWin {
        print("Yes")
    } else {
        print("No")
    }
}
