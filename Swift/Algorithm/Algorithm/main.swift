//
//  main.swift
//  Algorithm
//
//  Created by 백유정 on 2022/08/05.
//

import Foundation

let input = readLine()!
let arr = input.sorted()

var alphabetArr: [String] = []
var countArr: [Int] = []

var isOddNum = false
var oddNum = ""
var same = 1

if input.count == 1 {
    print(input)
} else {
    alphabetArr.append(String(arr[0]))

    for i in 1...arr.count-1 { // 문자열 전체를 돌면서
        
        if arr[i] == arr[i-1] { // 앞뒤 문자가 같으면
            same += 1
        } else { // 앞뒤 문자가 다르면
            alphabetArr.append(String(arr[i]))
            countArr.append(same)
            
            if oddNumCount(i-1) == false {
                break
            }
            same = 1
        }
        
        if i == arr.count - 1 { // 마지막 글자면
            countArr.append(same)
            if oddNumCount(i) == false {
                break
            } else {
                makeNum()
            }
        }
    }
}

func oddNumCount(_ i: Int) -> Bool {
    if same % 2 == 1 { // 문자의 갯수가 홀수개면
        if isOddNum == true { // 홀수개인 문자가 2개 이상이면
            print("I'm Sorry Hansoo")
            return false
        } else {
            isOddNum = true
            oddNum = String(arr[i])
        }
    }
    return true
}

func makeNum() {
    for i in 0...alphabetArr.count - 1 {
        if countArr[i] >= 2 {
            for _ in 1...countArr[i] / 2 {
                print(alphabetArr[i], terminator: "")
            }
        }
    }

    if isOddNum == true {
        print(oddNum, terminator: "")
    }

    for i in (0...alphabetArr.count - 1).reversed() {
        if countArr[i] >= 2 {
            for _ in 1...countArr[i] / 2 {
                print(alphabetArr[i], terminator: "")
            }
        }
    }
}
