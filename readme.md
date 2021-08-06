# 1. 스프링 개요

#### 1-1 스프링 프레임워크
- 스프링 프레임워크 : 주요기능으로 DI, AOP, MVC, JDBC 등 제공

#### 1-2 스프링 프레임워크 모듈
- spring-core : 스프링의 핵심인 DI(Dependency Injection)와 IoC(Inversion of Control)를 제공
- spring-aop : AOP 구현 기능 제공
- spring-jdbc : 데이터베이스를 쉽게(적은 양의 코드) 다룰 수 있는 기능 제공
- spring-tx : 스프링에서 제공하는 트랜잭션 관련 기능 제공
- spring-webmvc : 스프링에서 제공하는 컨트롤러와 뷰를 이용한 스프링 MVC 구현 기능 제공

모듈에 대한 의존설정을 개발 프로젝트에 XML 파일등을 이용해서 개발자가 직접 하면 된다.

#### 1-3 스프링 컨테이너(IoC)
- 스프링 컨테이너 : 스프링에서 객체를 생성하고 조립하는 컨테이너로, 컨테이너를 통해 생성된 객체를 빈(Bean)이라고 부른다.

1) XML문서를 이용한 객체생성 및 속성 데이터 작성

2) *스프링 컨테이너*에서 객체 생성 및 조립 (객체를 빈이라고 한다.)

3) 개발문서(자바문서)에서 애플리케이션 구현

# 2. 개발 환경 구축

#### 2-1 Java 설치
- JDK(Java Development Kit) 설치
   - 개발자는 JDK가 있어야 개발 가능, 단지 프로그램만 사용하는 사용자라면 JRE만 설치되어있으면 가능
 
#### 2-2 환경변수 설정
- javac.exe, java.exe를 다른 디렉토리에서도 실행할 수 있도록 하기 위해 환경 변수(Path)에 bin 경로 등록

#### 2-3 IDE(STS4) 다운로드

# 3. 스프링 프로젝트 생성

#### 3-1 프로젝트 생성

#### 3-2 pom.xml 작성

```
  <dependencies>
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-context</artifactId>
		<version>4.1.0.RELEASE</version>
	</dependency>
  </dependencies>

  <build>
		<plugins>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.1</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
					<encoding>utf-8</encoding>
				</configuration>
			</plugin>
		</plugins>
	</build>
```

 ***에러가 날 경우, Maven -> Update project***

#### 3-3 폴더 및 pom.xml파일의 이해

1) 폴더의 이해
- spring 프로젝트 : 스프링 프로젝트 Root
- spring/src/main/java : 앞으로 만들어지는 자바 파일들이 관리되는 폴더, java 파일 관리
- spring/src/main/resouce : 자원을 관리하는 폴더로 스프링 설정 파일(XML) 또는 프로퍼티 파일 등 관리, 지원파일 관리

  ***java, resources 폴더는 스프링 프레임워크의 기본 구조를 이루는 폴더로 개발자는 이대로 폴더 구성해야됨***

2) pom.xml파일의 이해
- pom.xml 파일은 메이븐 설정파일로 메이븐은 라이브러리를 연결해주고, 빌드를 위한 플랫폼
- 필요한 라이브러리만 다운로드해서 사용

## 4. 처음해 보는 스프링 프로젝트

#### 4-1 Java파일을 이용한 프로젝트 실행

```java
TranspotationWalk transpotationWalk = new TranspotationWalk();
transpotationWalk.move();
```

#### 4-2 우선 따라 해 보는 스프링 프로젝트
- spring 방식의 '의존'을 이용하기 위해서는 Main에서 TransportationWalk 객체를 직접 생성하지 않고, 스프링 설정 파일(XML)을 이용
- 가장 큰 차이점은 Java파일에서 이용한 new 연산자를 사용하지 않고 스프링 설정파일(XML)을 이용하는 것

```java
// spring container에 접근
GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");

// container에있는 Bean(객체) 가져오기
TranspotationWalk transpotationWalk = ctx.getBean("id", 데이터타입);
transpotationWalk.move();
		
// resources 반환
ctx.close();
```

## 5. 또 다른 프로젝트 생성 방법

#### 5-1 폴더(java, resources)와 파일(pom.xml) 만들기
#### 5-2 이클립스에서 import하기
