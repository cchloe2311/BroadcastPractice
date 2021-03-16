# BroadcastPractice
안드로이드 4대 컴포넌트 중 하나인 브로드캐스트 연습용 레포지토리!
# BroadcastReceiver
> 안드로이드에서 다양한 이벤트와 정보를 받아 반응하는 컴포넌트

- 이를 이용해 메세지를 여러 객체제 전달할 수 있음
- 디바이스에서 발생하는 일 중 앱이알아야 하는 상황을 알림
- Receiver를 통해 디바이스의 상황을 감지하고 적절한 작업을 수행
## 구현 방법
### 정적 Receiver
- manifest 레벨에 수신을 원하는 action을 지정
- BroadcastReceiver를 상속받아 onReceive() 메소드 재정의

👉 한 번 등록하면 계속 유지. 단, 해제가 어려움
### 동적 Receiver
- code 레벨
- 인텐트필터 생성 및 액션 등록
- onReceiver() 메소드 재정의
- 리시버와 인텐트 등록
- 브로드캐스크 등록 해제 -> 해제 하지 않으면 리시버를 중복 가능 => 둘자 작동하지 않음 / 메모리 누수
#### register / unregister 타이밍
- onResume()/onPause(): 액티비티가 포커스를 얻은 상태(예를들어, 알람이 울리면 onPause -> 알람이 끝나면 onResume이 불림)에서 리시버가 동작해야 하는 경우
- onStart()/onStop(): 보이지만 포커스는 잃은 상태(when a dialog is being shown, 액티비티가 완전히 화면을 벗어나면 onStop -> 액티비티가 다시 화면으로 돌아왔을 때 onStart)에서 리시버가 동작해야 하는 경우
- onCreate()/onDestroy(): visible하지 않은 상태에서도 브로드캐스트를 알아차리고 그 상태를 저장, 액티비티가 돌아왔을 때 알아야하는 경우

👉 이런 상황에 맞춰 register, unregister 하면 됨

ref. https://stackoverflow.com/questions/7887169/when-to-register-unregister-broadcast-receivers-created-in-an-activity

👉 등록한 Receiver 컴포넌트 생명주기가 끝나면 동작하지 않아서 시스템에 큰 부하를 주지 않고 컴포넌트 내에 소스로 존재하기 때문에 멤버 변수 사용 가능 (몇몇 액션을 아예 정적리시버에서 등록하지 못함)

리비서는 main thread 에서 돈다

ref.

https://50billion-dollars.tistory.com/entry/Android-%EB%B8%8C%EB%A1%9C%EB%93%9C%EC%BA%90%EC%8A%A4%ED%8A%B8-%EB%A6%AC%EC%8B%9C%EB%B2%84-Broadcast-Receiver
https://www.geeksforgeeks.org/broadcast-receiver-in-android-with-example/

https://blog.mindorks.com/using-localbroadcastmanager-in-android
https://medium.com/android-news/local-broadcast-less-overhead-and-secure-in-android-cfa343bb05be
