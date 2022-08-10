//
//  main.swift
//  Algorithm
//
//  Created by 백유정 on 2022/08/05.
//

import Foundation

func solution(_ a:[Int], _ b:[Int]) -> Int {
    var answer: Int = 0
    
    for i in 0..<a.count {
        answer += a[i] * b[i]
    }
    
    return answer
}
