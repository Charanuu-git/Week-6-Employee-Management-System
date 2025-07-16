npackage employeeManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}
	
	// @Bean
	// public FilterRegistrationBean<JwtFilter> jwtFilterRegistration(JwtFilter jwtFilter) {
	//     FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
	//     registrationBean.setFilter(jwtFilter);
	//     registrationBean.addUrlPatterns("/employees/*");  // secure all employee endpoints
	//     return registrationBean;
	// }

}
