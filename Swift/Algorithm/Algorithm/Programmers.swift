//
//  Programmers.swift
//  Algorithm
//
//  Created by 백유정 on 2022/08/06.
//

import Foundation

final class programmers {
    
    /// 음양 더하기
    func solution_76501(_ absolutes:[Int], _ signs:[Bool]) -> Int {
        var answer: Int = 0
        
        for i in 0..<signs.count {
            answer += (signs[i] == true) ? absolutes[i] : -absolutes[i]
        }
        return answer
    }
}
