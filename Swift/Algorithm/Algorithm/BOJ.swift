//
//  BOJ.swift
//  Algorithm
//
//  Created by 백유정 on 2022/08/06.
//

import Foundation

final class BOJ {
    
    /// 접미사 배열
    func logic_11656() {
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
    }
    
    /// 단어 뒤집기
    func logic_9093() {
        let tc = Int(readLine()!)!

        for _ in 1...tc {
            let strArr: [String] = readLine()!.split(separator: " ").map { String($0) }
            for string in strArr {
                let arr = Array(string)
                for i in arr.reversed() {
                    print(i, terminator: "")
                }
                print(" ", terminator: "")
            }
        }
    }
    
    /// 방 번호
    func logic_1475() {
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
    }
    
    /// 소트인사이드
    func logic_1427() {
        let input = readLine()!
        var numArr: [Int] = []

        for i in input {
            numArr.append(Int(String(i))!)
        }

        numArr.sort(by: >)

        for i in numArr {
            print(i, terminator: "")
        }
    }
    
    /// 쉽게 푸는 문제
    func logic_1292() {
        let input: [Int] = readLine()!.split(separator: " ").map { Int($0)! }
        var numberArr: [Int] = []
        var num = 1
        var answer = 0

        for i in 1...input[1] {
            for _ in i...i+num-1 {
                numberArr.append(num)
            }
            num += 1
            
            if numberArr.count > input[1] { break }
        }

        for i in input[0]-1...input[1]-1 {
            answer += numberArr[i]
        }

        print(answer)
    }
    
    /// 문자열
    func logic_9086() {
        let tc: Int = Int(readLine()!)!

        for _ in 1...tc {
            let input: String = readLine()!
            print("\(input.first!)\(input.last!)")
        }
    }
    
    /// A+B - 3
    func logic_10950() {
        let tc: Int = Int(readLine()!)!
        
        for _ in 1...tc {
            let input: [Int] = readLine()!.split(separator: " ").map { Int($0)! }
            print(input[0] + input[1])
        }
    }
    
    /// 나머지
    func logic_10430() {
        let input = readLine()!

        let inputArr = input.split(separator: " ")

        let a = Int(inputArr[0])!
        let b = Int(inputArr[1])!
        let c = Int(inputArr[2])!

        print((a+b)%c)
        print(((a%c)+(b%c))%c)
        print((a*b)%c)
        print(((a%c)*(b%c))%c)
    }
}
