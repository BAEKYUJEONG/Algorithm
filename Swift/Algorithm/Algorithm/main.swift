//
//  main.swift
//  Algorithm
//
//  Created by 백유정 on 2022/08/05.
//

import Foundation

func solution(_ bridge_length:Int, _ weight:Int, _ truck_weights:[Int]) -> Int {
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

var length: Int = 2
var weight: Int = 10
var trucks: [Int] = [7, 4, 5, 6]

print(solution(length, weight, trucks))
