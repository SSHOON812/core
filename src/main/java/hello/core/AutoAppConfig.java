package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member", // 탐색할 패키지를 지정 할 수 있다. 이 패키지를 포함하여 하위 패키지 모두 탐색
        basePackageClasses = AutoAppConfig.class, // 탐색할 클래스를 지정 할 수 있다.
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
)

// 권장 방법 = 설정 정보 클래스의 위치를 프로젝트 최상단에 두는 것 basePackages 지정은 생략 한다.
public class AutoAppConfig {
}
