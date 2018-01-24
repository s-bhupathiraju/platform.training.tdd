package com.ebsco.platform.training.tdd.begin.config;


import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.HateoasPageableHandlerMethodArgumentResolver;
import org.springframework.data.web.HateoasSortHandlerMethodArgumentResolver;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.data.web.PagedResourcesAssemblerArgumentResolver;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@Configuration
public class UserHALConfig extends WebMvcConfigurationSupport {
	@Override
	protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(pageableResolver());
		argumentResolvers.add(sortResolver());
		argumentResolvers.add(pagedResourcesAssemblerArgumentResolver());
	}

	@Bean
	public HateoasPageableHandlerMethodArgumentResolver pageableResolver() {
		return new HateoasPageableHandlerMethodArgumentResolver(sortResolver());
	}

	@Bean
	public HateoasSortHandlerMethodArgumentResolver sortResolver() {
		return new HateoasSortHandlerMethodArgumentResolver();
	}

	@Bean
	public PagedResourcesAssembler<?> pagedResourcesAssembler() {
		return new PagedResourcesAssembler<Object>(pageableResolver(), null);
	}

	@Bean
	public PagedResourcesAssemblerArgumentResolver pagedResourcesAssemblerArgumentResolver() {
		return new PagedResourcesAssemblerArgumentResolver(pageableResolver(), null);
	}
}