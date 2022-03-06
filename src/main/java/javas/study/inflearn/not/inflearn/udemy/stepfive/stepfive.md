# step 5

## value types VS reference types

#### value type
- primitive 타입 변수 생성 시 메모리 내의 단일 공간에 변수의 값이 할당된다.
- 해당하는 공간의 값을 독립적으로 가지고 있기 때문에 같은 값을 할당하고 하나의 변수의 값을 바꾸더라도 두개의 변수는 독립적으로 동작한다.

#### reference type
- new 키워드를 사용하여 변수를 만드는 경우 참조값이 메모리에 할당된다.
- reference (참조값) 은 주소값이며, 해당 주소값을 사용하여 메모리에 할당된 object 를 찾을 수 있다.
- 변수에 reference type 의 값을 할당하는 것은 주소값을 할당하는 것과 같기 때문에 몇개의 변수를 같은 reference 를 할당하는 것은 결국 하나의 실제 메모리에 올라간 object 를 참조한다.