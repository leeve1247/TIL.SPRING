package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//excludeFilters 한 이유는 AppConfig의 구현체를 제외하기 위함(컴포난트 스캔의 역할을 확인하기 위함)
@ComponentScan(
        basePackages = "hello.core.member",
        //패키지 경로를 추가로 지정할 수도 있습니다.
        basePackageClasses =  AutoAppConfig.class,
        //default 경로는 어떻게 될까?
        //설정 정보 클래스의 위치를 프로젝트 최상단에 둔다.
        //ex) AutoAppConfig 의 위치.:com.hello를 컴포넌트 스캔 대상으로 결정됨
        //이유?: 구성정보를 먼저 보는게 좋기 때문
        //스프링부트의 ComponentSacn 은 @SpringBootApplication에 내장되어있습니다.

        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)
)
public class AutoAppConfig {

}

