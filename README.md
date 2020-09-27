# BankApplication(java, eclipse-workspace)

### 프로젝트에 대한 설명
* 은행과 고객 사이에 일어나는 상황 중 입금 및 출금과 관련한 행위를 정의
* 입출금 행위를 모델링하여 은행 및 고객 클래스의 객체 사이의 상호 작용이 진행되도록 함
* 은행은 고객의 잔고를 저장(기억)하고 있으며, 응용프로그램의 실행 시에 잔고 정보가 보여짐
* 고객은 입금 및 출금 행위를 수행함
* 한번 실행 후에 입금과 출금을 반복할 수 있음
* 은행과 고객은 응용 프로그램 안의 객체들로 존재
* 고객은 다수가 될 수 있으며, 이는 고객이 가지고 있는 account 번호를 가지고 식별함
* 고객의 계좌에는 이자가 일정 기간 지나면 발생하게 되는데 이는 고객의 등급에 따라 다름

### 사용자 입력과 관련하여
* 프로그램에서는 은행의 직원(Teller)가 고객의 account에 입금 및 출금을 하는 것을 목적으로 함
* Teller는 고객의 account번호를 활용하여 입출금을 진행함
* 입금 혹은 출금은 해당 account 번호를 기반으로 특정 ClientObj에게 전달되고, ClientObj는 BankObj에게 메시지를 전달함
* 여기서 MessageObj가 정의 되어, Client와 Server 사이에 메시지 전달이 진행됨
* MessageObj에는 입출금과 관련한 정보가 저장되어 있음(Account#, 입금 또는 출금, 금액, 조회기능)
* Client 클래스는 NormalClient와 VIPClient가 있으며 이는 상속 관계를 통해 명시함
* 입금, 출금, 조회 3개의 서비스가 존재하며 각 서비스는 인터페이스(BankService Interface)를 활용하여 구성됨

### 구현방법
Teller Class: Main method를 가지고 사용자 입금 내역을 처리해 줌
Client Class: NormalClient와 VIPClient 클래스는 하위 클래스로 정의
NormalClient: 연 이자율이 2%로 할당 되어 기간에 따라 업데이트 됨, BankService Interface를 Implement함
VIPClient: 연 이자율이 3%로 할당 되어 기간에 따라 업데이트 됨, BankService Interface를 Implement함
BankService Interface: Client 클래스 2종류가 구현해야하는 메소드를 정의 함
Bank Class: 고객 요청을 기반으로 데이터베이스를 갱신해 주는 일을 함, 잔고의 갱신이 주된 일이 됨

### 결과
![Alt text](/image.png)
