# rest-api-project
this is simple rest api project for practice.

## REST 응답을 받기 위해선 공통 response class를 생성.
- REST 응답에서 공통으로 들어가는게 **응답코드, 응답메세지, 데이터** 


#### post 요청시 "JSON parse error: Can not construct instance of ~WalletVO : no suitable constructor found, can not deserialize from Object value (missing default constructor or creator, or perhaps need to add/enable type information?) 에러.

- POST요청시 vo에 디폴트 생성자(Constructor)가 없어서 에러가 났음. 생성해주니 성공.
- [stackoverflow 참고](https://stackoverflow.com/questions/7625783/jsonmappingexception-no-suitable-constructor-found-for-type-simple-type-class)  

```
This happens for these reasons    
1. your inner class should be defined as static  
  
2. It might be that you got no default constructor in your class (UPDATE: This seems not to be the case) (나의 경우!)  
 
3. It could be your Setters are not defined properly or are not visible (e.g. private setter)
```

- 스터디참고 블로그 : http://easy-coding.tistory.com/2?category=717044
