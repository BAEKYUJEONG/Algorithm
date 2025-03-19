//
//  Programmers.swift
//  Algorithm
//
//  Created by 백유정 on 2022/08/06.
//

import Foundation

final class Programmers {
    
    /// 다리를 지나는 트럭
    func solution_42583(_ bridge_length: Int, _ weight: Int, _ truck_weights: [Int]) -> Int {
        var sec = 0
        var sumWeight = 0
        var bridge: [Int] = Array(repeating: 0, count: bridge_length)
        var trucks: [Int] = truck_weights
        
        while !bridge.isEmpty {
            sec += 1 // 1초가 지났으니
            sumWeight -= bridge.removeFirst() // 맨 앞의 다리를 다 건너가는 트럭을 sum에서 빼준다.
            
            if let truck = trucks.first {
                if truck + sumWeight <= weight {
                    sumWeight += trucks.removeFirst()
                    bridge.append(truck)
                } else {
                    bridge.append(0)
                }
            }
        }
        return sec
    }
    
    /// 올바른 괄호
    func solution_12909(_ s: String) -> Bool {
        var tmp: Int = 0 
        
        for c in s {
            (c == "(") ? (tmp += 1) : (tmp -= 1)
            
            if tmp < 0 {
                return false
            }
        }
        
        return (tmp == 0) ? true : false
    }
    
    /// 내적
    func solution_70128(_ a: [Int], _ b: [Int]) -> Int {
        var answer: Int = 0
        
        for i in 0..<a.count {
            answer += a[i] * b[i]
        }
        return answer
    }
    
    /// 숫자 문자열과 영단어
    func solution_81301(_ s: String) -> Int {
        let arr = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
        var str = s
        for i in 0..<arr.count {
            str = str.replacingOccurrences(of: arr[i], with: String(i))
        }
        return Int(str)!
    }
    
    /// 음양 더하기
    func solution_76501(_ absolutes: [Int], _ signs: [Bool]) -> Int {
        var answer: Int = 0
        
        for i in 0..<signs.count {
            answer += (signs[i] == true) ? absolutes[i] : -absolutes[i]
        }
        return answer
    }
    
    /// 문자열 내림차순으로 배치하기
    func solution_12917(_ s:String) -> String {
        return String(s.sorted(by: >))
    }
    
    /// 택배 상자 꺼내기
    func solution_389478(_ n: Int, _ w: Int, _ num: Int) -> Int {
        var floor = (num - 1) / w
        var answer = 1
        var box = num

        while box < n {
            print(box)
            
            floor += 1
            answer += 1
            box = (2 * w) * floor + 1 - box
        }

        if box > n {
            answer -= 1
        }

        return answer
    }
    
    /// 귤 고르기
    func solution_138476(_ k:Int, _ tangerine:[Int]) -> Int {
        var dictionary: [Int : Int] = [ : ]
        var answer = 0
        var n = k
        
        for size in tangerine {
            if let value = dictionary[size] {
                dictionary[size] = value + 1
            } else {
                dictionary[size] = 1
            }
        }
        
        let sortedArray = dictionary.sorted { $0.value > $1.value }
        
        for (key, value) in sortedArray {
            if n > 0 {
                n = n - value
                answer += 1
            } else {
                break
            }
        }
        
        return answer
    }
}
