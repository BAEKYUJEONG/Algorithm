//
//  main.swift
//  Algorithm
//
//  Created by 백유정 on 2022/08/05.
//

import Foundation

func logic() {
    let tc: Int = Int(readLine()!)!
    
    for _ in 1...tc {
        let input: [Int] = readLine()!.split(separator: " ").map { Int($0)! }
        print(input[0] + input[1])
    }
}
