//
//  main.swift
//  Algorithm
//
//  Created by 백유정 on 2022/08/05.
//

import Foundation

var treeDictionary: [String: Int] = [:]
var totalCnt = 0

while true {
    if let tree = readLine() {
        if treeDictionary.keys.contains(tree) {
            treeDictionary.updateValue(treeDictionary[tree]! + 1, forKey: tree)
        } else {
            treeDictionary[tree] = 1
        }
        totalCnt += 1
    } else {
        break
    }
}

let sortedDictionary = treeDictionary.sorted { $0.0 < $1.0 }

for treeItem in sortedDictionary {
    print(treeItem.key, getPercentage(value: Double(treeItem.value), total: Double(totalCnt)))
}

func getPercentage(value: Double, total: Double) -> String {
    let percent = value/total * 100
    let roundPercent = round(percent * 10000) / 10000
    return String(format: "%.4f", roundPercent)
}
