# BroadcastPractice
안드로이드 4대 컴포넌트 중 하나인 브로드캐스트 연습용 레포지토리!
# register / unregister 타이밍
- onResume()/onPause(): 액티비티가 포커스를 얻은 상태(예를들어, 알람이 울리면 onPause -> 알람이 끝나면 onResume이 불림)에서 리시버가 동작해야 하는 경우
- onStart()/onStop(): 보이지만 포커스는 잃은 상태(when a dialog is being shown, 액티비티가 완전히 화면을 벗어나면 onStop -> 액티비티가 다시 화면으로 돌아왔을 때 onStart)에서 리시버가 동작해야 하는 경우
- onCreate()/onDestroy(): visible하지 않은 상태에서도 브로드캐스트를 알아차리고 그 상태를 저장, 액티비티가 돌아왔을 때 알아야하는 경우

👉 이런 상황에 맞춰 register, unregister 하면 됨

ref. https://stackoverflow.com/questions/7887169/when-to-register-unregister-broadcast-receivers-created-in-an-activity


ref.

https://50billion-dollars.tistory.com/entry/Android-%EB%B8%8C%EB%A1%9C%EB%93%9C%EC%BA%90%EC%8A%A4%ED%8A%B8-%EB%A6%AC%EC%8B%9C%EB%B2%84-Broadcast-Receiver
https://www.geeksforgeeks.org/broadcast-receiver-in-android-with-example/

https://blog.mindorks.com/using-localbroadcastmanager-in-android
https://medium.com/android-news/local-broadcast-less-overhead-and-secure-in-android-cfa343bb05be
