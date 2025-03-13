//
//  BOJ.swift
//  Algorithm
//
//  Created by 백유정 on 2022/08/06.
//

import Foundation

final class BOJ {
    
    /// 생태학
    func logic_4358() {
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
    }
    
    /// 한 줄로 서기
    func logic_1138() {
        /// 남은 자리 중에 자기가 가진 인덱스 만큼 떨어져 앉으면 자신의 자리
        let N = Int(readLine()!)!
        let heightArr = readLine()!.split(separator: " ").map{ Int($0)! }
        var answerArr = [Int](repeating: 0, count: N)

        for i in 0...N-1 {
            var target = heightArr[i]
            
            for j in 0...N-1 {
                if answerArr[j] == 0 {
                    if target == 0 {
                        answerArr[j] = i+1
                    }
                    target -= 1
                }
            }
        }

        answerArr.forEach{ print($0, terminator: " ") }
    }
    
    /// 주사위
    func logic_1041() {
        let N = Int(readLine()!)!
        var cubeArr = readLine()!.split(separator: " ").map{ Int($0)! }
        var answer = 0
        let sideArr = [5,4,3,2,1,0]

        if N == 1 {
            cubeArr.sort()
            for i in 0...cubeArr.count-2 {
                answer += cubeArr[i]
            }
        } else {
            var min = 50
            var minTwo = 50
            var minThree = 50
            var minIndex = 0
            var minTwoIndex = 0
            
            for i in 0...cubeArr.count-1 {
                if min > cubeArr[i] {
                    min = cubeArr[i]
                    minIndex = i
                }
            }
            
            /// 1면 보이는 갯수
            let one = ((N-2)*(N-2) + (N-2)*(N-1)*4) * min
            
            for i in 0...cubeArr.count-1 {
                if i == minIndex || i == sideArr[minIndex] { continue }
                if minTwo > cubeArr[i] {
                    minTwo = cubeArr[i]
                    minTwoIndex = i
                }
            }
            
            /// 2면 보이는 갯수
            let two = ((N-1)*4 + (N-2)*4) * (min + minTwo)
            
            for i in 0...cubeArr.count-1 {
                if i == minIndex || i == sideArr[minIndex] || i == minTwoIndex || i == sideArr[minTwoIndex] { continue }
                if minThree > cubeArr[i] {
                    minThree = cubeArr[i]
                }
            }
            
            /// 3면 보이는 갯수
            let three = 4 * (min + minTwo + minThree)
            
            answer = one + two + three
        }

        print(answer)

    }

    /// 카드2
    func logic_2164() {
        let input = Int(readLine()!)!

        var queue = Queue<Int>()

        for i in 1...input {
            queue.enqueue(i)
        }

        while queue.count != 1 {
            _ = queue.dequeue()
            let pop = queue.dequeue()
            queue.enqueue(pop!)
        }

        print(queue.dequeue()!)

        struct Queue<T> {
            private var queue: [T] = []
            
            public var count: Int {
                return queue.count
            }
            
            public var isEmpty: Bool {
                return queue.isEmpty
            }
            
            public mutating func enqueue(_ element: T) {
                queue.append(element)
            }
            
            public mutating func dequeue() -> T? {
                return isEmpty ? nil : queue.removeFirst()
            }
        }
    }
    
    /// 비슷한 단어
    func logic_2607() {
        let input = Int(readLine()!)!
        let wordArr = readLine()!.sorted()
        var sum = 0

        for _ in 1...input-1 {
            var sameArr = wordArr
            var similarArr = readLine()!.sorted()
            
            if wordArr == similarArr {
                sum += 1
                continue
            } else if similarArr.count > wordArr.count + 1 ||  similarArr.count < wordArr.count - 1 {
                continue
            }
            
            if similarArr.count == wordArr.count - 1 { /// 1개 적을 때
                var same = 0
                for i in 0...similarArr.count-1 {
                    for j in 0...sameArr.count-1 {
                        if sameArr[j] == similarArr[i] {
                            same += 1
                            sameArr[j] = " "
                            similarArr[i] = " "
                        }
                    }
                }
                
                if same == similarArr.count {
                    sum += 1
                }
            } else {
                var same = 0
                for i in 0...similarArr.count-1 {
                    for j in 0...sameArr.count-1 {
                        if sameArr[j] == similarArr[i] {
                            same += 1
                            sameArr[j] = " "
                            similarArr[i] = " "
                        }
                    }
                }
                
                if similarArr.count == wordArr.count { /// 같을 때
                    if same >= wordArr.count - 1 {
                        sum += 1
                    }
                } else { /// 1개 많을 때
                    if same >= wordArr.count {
                        sum += 1
                    }
                }
            }
        }

        print(sum)

    }
    
    /// 오늘도 졌다
    func logic_14582() {
        let myTeamArr = readLine()!.split(separator: " ").map { Int($0)! }
        let yourTeamArr = readLine()!.split(separator: " ").map { Int($0)! }

        var mySum = 0
        var yourSum = 0
        var isWin = false

        for i in 0...8 {
            mySum += myTeamArr[i]
            if mySum > yourSum {
                isWin = true
            }
            yourSum += yourTeamArr[i]
        }

        if mySum >= yourSum {
            print("No")
        } else {
            if isWin {
                print("Yes")
            } else {
                print("No")
            }
        }
    }
    
    /// 수 찾기
    func logic_1920() {
        _ = Int(readLine()!)!
        var numSet: Set<Int> = []

        _ = readLine()!.split(separator: " ").map { numSet.insert(Int($0)!) }

        _ = Int(readLine()!)!
        let answerArr = readLine()!.split(separator: " ").map { Int($0)! }

        for answer in answerArr {
            if numSet.contains(answer) {
                print(1)
            } else {
                print(0)
            }
        }
    }
    
    /// 슈퍼 마리오
    func logic_2851() {
        var arr: [Int] = []
        var sum = 0
        var isHigherThan100 = false

        for _ in 0...9 {
            arr.append(Int(readLine()!)!)
        }

        for i in 0...9 {
            sum += arr[i]
            if sum >= 100 {
                (sum-100) <= (100-(sum-arr[i])) ? print(sum) : print(sum-arr[i])
                isHigherThan100 = true
                break
            }
        }

        if !isHigherThan100 {
            print(sum)
        }
    }
    
    /// 팰린드롬 만들기
    func logic_1213() {
        let input = readLine()!
        let arr = input.sorted()

        var alphabetArr: [String] = []
        var countArr: [Int] = []

        var isOddNum = false
        var oddNum = ""
        var same = 1

        if input.count == 1 {
            print(input)
        } else {
            alphabetArr.append(String(arr[0]))

            for i in 1...arr.count-1 { // 문자열 전체를 돌면서
                
                if arr[i] == arr[i-1] { // 앞뒤 문자가 같으면
                    same += 1
                } else { // 앞뒤 문자가 다르면
                    alphabetArr.append(String(arr[i]))
                    countArr.append(same)
                    
                    if oddNumCount(i-1) == false {
                        break
                    }
                    same = 1
                }
                
                if i == arr.count - 1 { // 마지막 글자면
                    countArr.append(same)
                    if oddNumCount(i) == false {
                        break
                    } else {
                        makeNum()
                    }
                }
            }
        }

        func oddNumCount(_ i: Int) -> Bool {
            if same % 2 == 1 { // 문자의 갯수가 홀수개면
                if isOddNum == true { // 홀수개인 문자가 2개 이상이면
                    print("I'm Sorry Hansoo")
                    return false
                } else {
                    isOddNum = true
                    oddNum = String(arr[i])
                }
            }
            return true
        }

        func makeNum() {
            for i in 0...alphabetArr.count - 1 {
                if countArr[i] >= 2 {
                    for _ in 1...countArr[i] / 2 {
                        print(alphabetArr[i], terminator: "")
                    }
                }
            }

            if isOddNum == true {
                print(oddNum, terminator: "")
            }

            for i in (0...alphabetArr.count - 1).reversed() {
                if countArr[i] >= 2 {
                    for _ in 1...countArr[i] / 2 {
                        print(alphabetArr[i], terminator: "")
                    }
                }
            }
        }
    }
    
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
    
    /// 체스판 칠하기
    func logic_1018() {
        let input: [Int] = readLine()!.split(separator: " ").map { Int($0)! }
        let m = input[0]
        let n = input[1]
        var chessArr: [[Character]] = []

        for _ in 0..<m {
            chessArr.append(readLine()!.map{ $0 })
        }

        var answer = 64

        for i in 0...m-8 {
            for j in 0...n-8 {
                var change1 = 0
                var change2 = 0
                
                for col in i..<i+8 {
                    for row in j..<j+8 {
                        
                        if (col + row) % 2 == 0 {
                            if chessArr[col][row] == "B" {
                                change1 += 1
                            } else {
                                change2 += 1
                            }
                        } else {
                            if chessArr[col][row] == "B" {
                                change2 += 1
                            } else {
                                change1 += 1
                            }
                        }
                        
                    }
                }
                
                answer = min(answer, change1, change2)
            }
        }
        print(answer)
    }
}
