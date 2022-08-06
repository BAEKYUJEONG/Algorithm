//
//  main.swift
//  Algorithm
//
//  Created by 백유정 on 2022/08/05.
//

import Foundation

let input = readLine()!

let inputArr = input.split(separator: " ")

let a = Int(inputArr[0])!
let b = Int(inputArr[1])!
let c = Int(inputArr[2])!

print((a+b)%c)
print(((a%c)+(b%c))%c)
print((a*b)%c)
print(((a%c)*(b%c))%c)
