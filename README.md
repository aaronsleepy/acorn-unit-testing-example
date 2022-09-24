# Unit Testing (단위 테스트) Kotlin 예제

단위 테스트(생산성과 품질을 위한 단위 테스트 원칙과 패턴)에 대한 Kotlin 예제 

## Prerequisite
* JUnit 5
  * ```testImplementation("org.assertj:assertj-core:3.3.0")```
* Run Configuration에 **"Use tracing"** 활성화
![image](https://user-images.githubusercontent.com/89061309/183836815-ad9cf675-03b6-4d0d-9dab-a3dcd01eb788.png)


## 1장 단위 테스트의 목표
### 예제 1.1 예제 메서드를 부분적으로 다루는 테스트
| code | test code |
| ---- | --------- |
| `src/main/ch1/lec01/Lec01Ex1.kt` | `src/test/ch1/lec01/Lec01Ex1.kt` |

### 예제 1.2 마지막 결과를 기록하는 isStringLong 버전
| code | test code |
| ---- | --------- |
| `src/main/ch1/lec01/Lec01Ex2.kt` | `src/test/ch1/lec01/Lec01Ex2.kt` |

### 예제 1.3 검증이 없는 테스트는 언제나 통과한다
| code | test code |
| ---- | --------- |
| `src/main/ch1/lec01/Lec01Ex2.kt` | `src/test/ch1/lec01/Lec01Ex3.kt` |


## 2장 단위 테스트란 무엇인가
## 2장 관련 코드
* `Customer.kt`
* `Store.kt `

### 예제 2.1 고전적인 스타일로 작성된 테스트
| code | test code |
| ---- | --------- |
| - | `src/test/ch2/lec01/ClassicalCustomerTest.kt` |


## 3장 단위 테스트 구조


## 4장 좋은 단위 테스트의 4대 요소


## 5장 목과 테스트 취약성
