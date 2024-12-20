package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject {
  private Subject target; //  실제 객체
  private String cacheValue;  //  캐시된 데이터

  public CacheProxy(Subject target) {
    this.target = target;
  }

  @Override
  public String operation() {
    log.info("프록시 호출");
    if(cacheValue == null) { //  캐시된 데이터가 없을 경우, 즉 처음 호출된 경우
      cacheValue = target.operation();  //  실제 객체 호출
    }

    return cacheValue;
  }
}
