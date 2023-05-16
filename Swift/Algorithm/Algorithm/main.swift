//
//  main.swift
//  Algorithm
//
//  Created by 백유정 on 2022/08/05.
//

import Foundation

let N = Int(readLine()!)!
var cubeArr = readLine()!.split(separator: " ").map{ Int($0)! }
var answer = 0
var sideArr = [5,4,3,2,1,0]

if N == 1 {
    cubeArr.sort()
    for i in 0...cubeArr.count-2 {
        answer += cubeArr[i]
    }
} else {
    var min = 50
    var minTwo = 50
    var minThree = 50
    var minIndex = 0
    var minTwoIndex = 0
    
    for i in 0...cubeArr.count-1 {
        if min > cubeArr[i] {
            min = cubeArr[i]
            minIndex = i
        }
    }
    
    let one = ((N-2)*(N-2) + (N-2)*(N-1)*4) * min
    
    for i in 0...cubeArr.count-1 {
        if i == minIndex || i == sideArr[minIndex] { continue }
        if minTwo > cubeArr[i] {
            minTwo = cubeArr[i]
            minTwoIndex = i
        }
    }
    
    let two = ((N-1)*4 + (N-2)*4) * (min + minTwo)
    
    for i in 0...cubeArr.count-1 {
        if i == minIndex || i == sideArr[minIndex] || i == minTwoIndex || i == sideArr[minTwoIndex] { continue }
        if minThree > cubeArr[i] {
            minThree = cubeArr[i]
        }
    }
    
    let three = 4 * (min + minTwo + minThree)
    
    answer = one + two + three
}

print(answer)
