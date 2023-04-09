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
}
