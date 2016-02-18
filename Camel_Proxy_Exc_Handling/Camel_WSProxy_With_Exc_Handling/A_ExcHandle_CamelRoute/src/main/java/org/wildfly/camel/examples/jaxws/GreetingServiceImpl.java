/*
 * #%L
 * Wildfly Camel :: Example :: Camel JAX-WS
 * %%
 * Copyright (C) 2013 - 2014 RedHat
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.wildfly.camel.examples.jaxws;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.component.bean.ProxyHelper;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "greeting", endpointInterface = "org.wildfly.camel.examples.jaxws.GreetingService")
public class GreetingServiceImpl {

	@Inject
	@ContextName("jaxrs-camel-context")
	private CamelContext context;

	/**
	 * Greeting service to proxy
	 */
	private GreetingService greetingService;

	@PostConstruct
	public void initServiceProxy() throws Exception {
		/**
		 * Create a proxy for the direct:start endpoint using the Camel
		 * ProxyHelper
		 */
		Endpoint endpoint = context.getEndpoint("direct:start");
		greetingService = ProxyHelper.createProxy(endpoint,
				GreetingService.class);
	}

	@WebMethod(operationName = "greet")
	public String greet(@WebParam(name = "name") String name) {
		/**
		 * Invoke the proxied greet method and pass on the arguments we received
		 */
		return greetingService.greet(name);
	}

	@WebMethod(operationName = "greetWithMessage")
	public String greetWithMessage(@WebParam(name = "message") String message,
			@WebParam(name = "name") String name) {
		/**
		 * Invoke the proxied greetWithMessage method and pass on the arguments
		 * we received
		 */
		return greetingService.greetWithMessage(message, name);
	}
}
