//
//  main.swift
//  Algorithm
//
//  Created by 백유정 on 2022/08/05.
//

import Foundation

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
