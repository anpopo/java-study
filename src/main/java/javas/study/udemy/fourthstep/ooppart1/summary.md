# Reference /  Instance / Class
- Class 는 Instance 를 만들기 위한 설계도이다. 어떤 상태를 가지고 어떤 메소드를 가지는지 미리 정의해 둔다.
- Instance 는 Class 의 new 키워드를 통해 만들어진 실제하는 객체이다.
  - Instance 는 Object 로 실제 메모리에 올라가있는 주소값이 있다.
- Reference 는 Instance 에 접근하기 위해 필요한 참조값 (혹은 주소값)이다.

- 건물을 건축하는 것을 예로 들면,
  - 건물을 **건축하기 위한 설계도**는 **Class**
  - 설계도를 보고 **실제로 건축한 집**은 **ew 키워드를 사용해 실제 Instance 를 만드는 것**
    - 설계도에는 각각의 건물이 가지고 있는 상태 혹은 행위가 정의되어 있고, 실제로 노랑색 건물을 지을지 파랑색 건물을 지을지는 Instance 가 생성될 때 정해진다.
    - 단, 기본적으로 지붕은 빨간색이다라는 상태값을 미리 가질 수도 있다.
  - **건축한 건물이 가지고 있는 주소**는 **Reference** 이다.
    - 메모리에 올라가 있는 Instance 의 참조값은 하나임이 보장된다.
    - Instance 에 접근할 수 있는 방법은 reference 를 통한 방법 밖에 없다.
    - 여러 변수를 선언하고 같은 instance 를 할당하면 결과적으로 같은 reference 를 가진다.
      - 건물의 주소는 단 하나. 그 주소를 가지고 있는 종이를 100 명 , 1000 명의 사람이 가지고 있어도 주소는 항상 동일한 집을 가르킨다.

    

# this / super
- this 는 현재 참조하고 있는 클래스를 의미한다.
- super 는 상속 관계에서 부모 클래스의 참조를 의미한다.

- static 키워드가 붙은 범위외의 인스턴스를 가르키는 범위내에선 항상 사용이 가능하다.

- this 키워드를 사용하여 현재 클래스가 가지고 있는 상태와 행위에 대해 접근이 가능하다.
- super 키워드를 사용하여 부모 클래스가 가지고 있는 상태와 행위에 대해 접근이 가능하다. -> 접근 제한자(access modifier)에 따라 호출 여부 결정

- this() 는 현재 참조하는 클래스의 생성자를 의미한다.
  - 생성자를 오버로딩해서 만드는 경우 this() 메소드를 이용한 체이닝 호출을 통해서 효율적으로 사용이 가능하다.
  - 생성자 내부에서만 호출이 가능하면 무조건 첫번째 구문으로 작성되야 한다.
- super() 는 상송 관계에서 참조하는 부모 클래스의 생성자를 의미한다.
  - 반드시 생성자 내부에서 첫번째 구문으로 작성되어야 한다.
  - 추상 클래스는 new 키워드를 통한 객체 초기화를 할 수 없지만 구현체 클래스를 생성할떄 super() 가 호출되어 추상 클래스의 인스턴스를 생성한다. 
- super() 와 this() 는 하나의 생성자에서 같이 호출할 수 없다.

- 메소드 overloading / overriding 
- overloading
  - 같은 이름의 다른 파라미터를 가지는 메소드를 하나의 클래스에서 두 개 이상 정의하는 것
  - 메소드의 리턴 타입은 같거나 다를 수 있다.
  - 다형성과 관계가 없다?
    - 몇몇의 개발자들은 컴파일 시점의 다형성에 대해 이야기 한다.
  - static / instance 메소드에 대해 overloading 이 가능하다.
  - 다른 접근 제한자를 사용하는 것이 가능하다.
  - 다른 checked / unchecked 예외를 던질 수 있다.
- overriding
  - 부모 클래스에 있는 메소드를 상속 관계의 자식 클래스에서 재정의 하는것
  - 같은 이름과 같은 arguments 를 가짐
  - 런타임 다형성, 동적 메소드 실행이라고도 한다.
    - 메소드가 런타임시에 동적으로 호출되기 때문이다.
  - 메소드 오버라이딩에 대해 기억해야 할 사항
    - static 메소드는 override 할 수 없다.
    - 상속관계의 모든 메소드는 오버라이딩을 할 수 있다.
    - 접근 제한자 private 와 생성자는 할 수 없다.
    - final 키워드를 가진 메소드는 할 수 없다.
    - super 키워드를 통해 부모 메소드 호출 가능
    - 부모의 메소드보다 더 낮은 접근 제한자는 허용 안함
    - 더 넓은 checked 예외 혹은 새로운 예외를 던지면 안됨

- static method / instance method
- 스태틱 메소드
  - static 키워드를 가진 메소드
  - 인스턴스 메소드와 변수를 바로 접근할 수 없다.
  - static method 는 this 키워드를 사용할 수 없다.
- 인스턴스 메소드
  - 인스턴스에 선언된 메소드
  - 클래스를 통해 인스턴스를 초기화 한 후 접근이 가능하다.
  - 인스턴스 메소드는 인스턴스 메소드와 필드에 바로 접근이 가능하다.
  - 인스턴스 메소드는 스태틱 메소드와 변수에 접근이 가능하다.
-  