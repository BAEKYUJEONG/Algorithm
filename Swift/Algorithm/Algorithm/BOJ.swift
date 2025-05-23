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
    
    /// 체스판 다시  칠하기
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
    
    /// 모음의 개수
    func logic_1264() {
        while let input = readLine(), input != "#" {
            let arr: [String] = ["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"]
            let inputArr = Array(input).map { String($0) }
            var count = 0

            for element in inputArr {
                if arr.contains(element) {
                    count += 1
                }
            }
            print(count)
        }
    }
    
    /// 알파벳 찾기
    func logic_10809() {
        let s = readLine()!
        let arr = [Int](0...26)
        var resultArr = [Int](repeating: -1, count: 26)
        let stringArr = s.map { Int($0.asciiValue!) - 97 } // 입력 받은 string을 asciiValue Int로 arr에 저장 (a인 97을 빼서 0을 기준으로 만듦) ex) 2 1 3 5 (c b d f)

        for i in arr { // 0부터 26까지 순회
            if stringArr.contains(arr[i]) { // a부터 순서대로 있는지 확인 (만약에 그 해당하는 알파벳이 있으면)
                resultArr[i] = stringArr.firstIndex(of: arr[i])! // 맨 처음에 나오는 위치 확인
            }
        }

        resultArr.forEach {
            print($0, terminator: " ")
        }
    }
    
    /// 로프
    func logic_2217() {
        let num = Int(readLine()!)!
        var arr = [Int]()
        var answer = 0

        for _ in 1...num {
            arr.append(Int(readLine()!)!)
        }

        arr.sort()

        for i in 0..<num {
            answer = (num - i) * arr[i] > answer ? (num - i) * arr[i] : answer
        }

        print(answer)
    }
    
    /// 학생 번호
    func logic_1235() {
        let num = Int(readLine()!)!
        var arr = [String]()
        var set: Set<String> = []

        for _ in 1...num {
            arr.append(readLine()!)
        }

        for n in 1...arr[0].count {
            for i in 0..<num {
                set.insert(String(arr[i].suffix(n)))
            }
            
            if set.count == num {
                print(n)
                break
            } else {
                set.removeAll()
            }
        }
    }
    
    /// 국영수
    func logic_10825() {
        let num = Int(readLine()!)!
        var items = [(Int, Int, Int, String)]()

        for _ in 0..<num {
            let input = readLine()!.split(separator: " ").map { String($0) }
            if let korean = Int(input[1]),
               let eng = Int(input[2]),
               let math = Int(input[3]) {
                items.append((korean, eng, math, input[0]))
            }
        }
        
        let sortedItems = items.sorted {
            if $0.0 != $1.0 { return $0.0 > $1.0 } // 국어 내림차순
            else if $0.1 != $1.1 { return $0.1 < $1.1 } // 영어 오름차순
            else if $0.2 != $1.2 { return $0.2 > $1.2 } // 수학 내림차순
            else { return $0.3 < $1.3 } // 이름 사전순
        }

        for item in sortedItems {
            print(item.3)
        }
    }
    
    /// 좌표 정렬하기
    func logic_11650() {
        let num = Int(readLine()!)!
        var arr = [(Int, Int)]()
        
        for _ in 0..<num {
            let input = readLine()!.split(separator: " ").map{ Int($0)! }
            arr.append((input[0], input[1]))
        }
        
        arr.sort {
            if $0.0 != $1.0 { return $0.0 < $1.0 }
            else { return $0.1 < $1.1 }
        }
        
        for item in arr {
            print(item.0, " ", item.1)
        }
    }
    
    /// 통계학
    func logic_2108() {
        let num = Int(readLine()!)!
        var sum = 0
        var arr = [Int]()
        var dictionary: [Int: Int] = [:]

        for _ in 0..<num {
            let input = Int(readLine()!)!
            sum += input
            arr.append(input)
            if dictionary.keys.contains(input) {
                dictionary.updateValue(dictionary[input]! + 1, forKey: input)
            } else {
                dictionary[input] = 1
            }
        }

        arr.sort()
        let dicArr = dictionary.sorted { $0.value > $1.value }.map { ($0.key, $0.value) }

        var maxCountArr = [(Int, Int)]()
        maxCountArr.append(dicArr[0])

        for item in dicArr {
            if maxCountArr[0].0 != item.0 {
                if maxCountArr[0].1 == item.1 {
                    maxCountArr.append(item)
                } else {
                    break
                }
            }
        }

        print(Int(round(Double(sum) / Double(num))))
        print(arr[num/2])

        if maxCountArr.count == 1 {
            print(maxCountArr[0].0)
        } else {
            maxCountArr.sort { $0.0 < $1.0 }
            print(maxCountArr[1].0)
        }

        print(arr[num-1] - arr[0])
    }
    
    /// 시리얼 번호
    func logic_1431() {
        let num = Int(readLine()!)!
        var arr = [String]()

        for _ in 0..<num {
            arr.append(String(readLine()!))
        }

        arr.sort {
            if $0.count != $1.count {
                return $0.count < $1.count
            } else {
                let sum1 = $0.compactMap { $0.wholeNumberValue }.reduce(0, +)
                let sum2 = $1.compactMap { $0.wholeNumberValue }.reduce(0, +)
                
                if sum1 != sum2 {
                    return sum1 < sum2
                } else {
                    return $0 < $1
                }
            }
        }

        arr.forEach { item in
            print(item)
        }
    }
    
    /// 수 정렬하기 2
    func logic_2751() {
        let n = Int(readLine()!)!
        var array: [Int] = []
        for _ in 0..<n {
            array.append(Int(readLine()!)!)
        }
        print(array.sorted().map { String($0) }.joined(separator: "\n"))
    }
    
    /// 문자와 문자열
    func logic_27866() {
        let s = readLine()!
        let i = Int(readLine()!)! - 1
        print(s[s.index(s.startIndex, offsetBy: i)])
    }
    
    /// 새싹
    func logic_25083() {
        let str = """
         ,r'"7
r`-_   ,'  ,/
 \\. ". L_r'
   `~\\/
      |
      |
"""
        print(str)
    }
    
    /// 요세푸스 순열
    func logic_11866() {
        let input = readLine()!.split(separator: " ").map{ Int(String($0))! }
        let n = input[0]
        let k = input[1]
        
        var arr = Array(1...n)
        var result = [Int]()
        var index = 0
        
        while !arr.isEmpty {
            index = (index + k - 1) % arr.count
            result.append(arr.remove(at: index))
        }
        
        print("<\(result.map{ String($0) }.joined(separator: ", "))>")
    }
    
    /// 세로 읽기
    func logic_10798() {
        var arr = Array(repeating: "", count: 15)
        for _ in 0..<5 {
            readLine()!.enumerated().forEach {
                arr[$0.offset].append($0.element)
            }
        }
        print(arr.joined())
    }
    
    /// 짐 챙기는 숌
    func logic_1817() {
        let input = readLine()!.split(separator: " ").map { Int(String($0))! }
        let n = input[0]
        let m = input[1]

        if n == 0 {
            print(0)
        } else {
            let books = readLine()!.split(separator: " ").map { Int(String($0))! }
            var box = 0
            var count = 1
            
            for book in books {
                box += book
                
                if box > m {
                    count += 1
                    box = book
                }
            }
            
            print(count)
        }
    }
    
    /// 카드 1
    func logic_2161() {
        let input = Int(readLine()!)!
        var array = Array(1...input)
        var flag = true
        var answer = [Int]()

        while !array.isEmpty {
            if flag {
                let first = array.removeFirst()
                answer.append(first)
            } else {
                let first = array.removeFirst()
                array.append(first)
            }
            
            flag = !flag
        }

        print(answer.map { "\($0)" }.joined(separator: " "))
    }
}
