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
| `src/main/ch1/lec01/Lec01Ex1.kt` | `src/test/ch1/lec01/Lec01Ex1Test.kt` |

### 예제 1.2 마지막 결과를 기록하는 isStringLong 버전
| code | test code |
| ---- | --------- |
| `src/main/ch1/lec01/Lec01Ex2.kt` | `src/test/ch1/lec01/Lec01Ex2Test.kt` |

### 예제 1.3 검증이 없는 테스트는 언제나 통과한다
| code | test code |
| ---- | --------- |
| `src/main/ch1/lec01/Lec01Ex2.kt` | `src/test/ch1/lec01/Lec01Ex3Test.kt` |


## 2장 단위 테스트란 무엇인가
### 2장 관련 코드
* `Customer.kt`
* `Store.kt `

### 예제 2.1 고전적인 스타일로 작성된 테스트
| code | test code |
| ---- | --------- |
| - | `src/test/ch2/lec01/ClassicalCustomerTest.kt` |

### 예제 2.2 런던 스타일로 작성된 단위 테스트
| code | test code |
| ---- | --------- |
| - | `src/test/ch2/lec01/LondonCustomerTest.kt` |


## 3장 단위 테스트 구조
### 3장 관련 코드
* `Customer.kt`
* `Store.kt `
* `Calculator.kt`
* `DeliveryServiec.kt`

### 예제 3.1 calculator 내 Sum 메서드를 다루는 테스트
| code | test code |
| ---- | --------- |
| `src/main/ch3/lec01/Calculator.kt` | `src/test/ch3/lec01/CalculatorTest.kt` |


### 예제 3.4 의존성과 SUT 구별하기
| code | test code |
| ---- | --------- |
| `src/main/ch3/lec01/Calculator.kt` | `src/test/ch3/lec01/CalculatorTest2.kt` |

### 예제 3.7 테스트 생성자에서 초기화 코드 추출
| code | test code |
| ---- | --------- |
| - | `src/test/ch3/lec03/BadTestFixtureCustomerTest.kt` |

### 예제 3.8 비공개 팩토리 메서드로 도출한 공통 초기화 코드
| code | test code |
| ---- | --------- |
| - | `src/test/ch3/lec03/GoodTestFixtureByFactoryMethodCustomerTest.kt` |

### 3.4.2 예제: 지침에 따른 테스트 이름 변경
| code | test code |
| ---- | --------- |
| `src/main/ch3/lec10/DeliveryService.kt` | `src/test/ch3/lec10/DeliveryServiceTest.kt` |

### 예제 3.11 몇 가지 사실을 포괄하는 테스트
| code | test code |
| ---- | --------- |
| `src/main/ch3/lec10/DeliveryService.kt` | `src/test/ch3/lec11/DeliveryServiceTest.kt` |

### 예제 3.12 긍정적인 시나리오와 부정적인 시나리오를 검증하는 두 가지 테스트
| code | test code |
| ---- | --------- |
| `src/main/ch3/lec10/DeliveryService.kt` | `src/test/ch3/lec12/DeliveryServiceTest.kt` |

### 예제 3.13 매개변수화된 테스트를 위한 데이터 생성
| code | test code |
| ---- | --------- |
| `src/main/ch3/lec10/DeliveryService.kt` | `src/test/ch3/lec13/DeliveryServiceTest.kt` |

### 3.6 검증문 라이브러리를 사용한 테스트 가독성 향상
| code | test code |
| ---- | --------- |
| `src/main/ch3/lec01/Calculator.kt` | `src/test/ch3/lec14/CalculatorTest.kt` |

## 4장 좋은 단위 테스트의 4대 요소
### 예제 4.1 메시지의 HTML 표현 생성
* `Message.kt`
* `IRenderer.kt`
* `MessageRenderer.kt` 

### 예제 4.2 MessageRenderer의 구조가 올바른지 확인
| code | test code |
| ---- | --------- |
| - | `src/test/ch4/lec02/MesseageRendererTest.kt` |

### 예제 4.4 MessageRenderer에서 생성하는 결과 검증
| code | test code |
| ---- | --------- |
| - | `src/test/ch4/lec02/MesseageRendererTest.kt` |

## 5장 목과 테스트 취약성
### 5.1절 목과 스텁 구분
#### 도메인 코드
* `Controller`
* `IDatabase`
* `IEmailGateway`
* `Report`

#### 예제 5.1 목 라이브러리에서 Mock 클래스를 사용해 목을 생성
* `ch5/lec01/Lec01Ex1Test`

#### 예제 5.2 Mock 클래스를 사용해 스텁을 생성
* `ch5/lec01/Lec01Ex2Test`

#### 예제 5.3 스텁으로 상호 작용 검증
* `ch5/lec01/Lec01Ex3Test`

#### 예제 5.4 목이자 스텁인 storeMock
* `ch5/lec01/Lec01Ex4Test`


### 5.2절 식별할 수 있는 동작과 구현 세부 사항
#### 예제 5.5 구현 세부 사항을 유출하는 User 클래스
* `Controller`
  * `User` 

#### 예제 5.6 API가 잘 설계된 User 클래스
* `Controller2`
  * `GoodUser` 

#### 예제 5.7 구현 세부 사항으로서의 상태
* `MessageRenderer` 


### 5.3절 목과 테스트 취약성 간의 관계
#### 예제 5.9 외부 애플리케이션과 도메인 모델 연결하기
* `CustomerController`
* `IEmailGateway` 
* `EmailGateway` 
* `IStore`
  * `Store`
* `ProductRepository`
  * `Product` 
* `CustomerRepsository` 
  * `Customer`

#### 예제 5.10 취약한 테스트로 이어지지 않는 목 사용
* `ch5/lec03/Lec03Ex10Test`
  * 미완성: sut.purchase()시 false 리턴
  * 고전파는 데이터베이스로부터 조회(Query) 의존성에 대해서는 Mock을 사용하지 않고, 직접 연동하는 방식을 선호하나??
  * 6장/7장에 내용 나온다고 함 

#### 예제 5.11 취약한 테스트로 이어지는 목 사용
* `ch5/lec03/Lec03Ex11Test`


## 6장. 단위테스트 스타일
| code | test code |
| ---- | --------- |
| ch6 | ch6 |


## 7장. 가치 있는 단위 테스트를 위한 리팩터링
| code | test code |
| ---- | --------- |
| ch7 | ch7 |

* 7.2절까지 작성되었습니다
* 정상 동작하는지 검증되지 않았습니다
